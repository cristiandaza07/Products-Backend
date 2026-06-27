package com.proyecto2026.web.common.infrastructure.filters;

import com.proyecto2026.web.common.infrastructure.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final HandlerExceptionResolver handlerExceptionResolver;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        String authorization = request.getHeader("Authorization");

        // Check if the authentication header contains "Bearer ".
        if (authorization == null || !authorization.startsWith("Bearer ")) {
            log.error("Token not found");
            filterChain.doFilter(request, response);
            return;
        }

        String token = authorization.substring(7);

        try {
            // If the token is in the blacklist cache, we reject the request immediately
            if (jwtService.isTokenBlacklisted(token)) {
                log.error("Token blacklisted");
                filterChain.doFilter(request, response);
                return;
            }

            boolean isTokenExpired = jwtService.isTokenExpired(token);
            boolean canBeTokenRenewed = jwtService.canBeTokenRenewed(token);

            // If the token is expired and cannot be renewed, return an error response.
            if (isTokenExpired && !canBeTokenRenewed) {
                log.error("Token expired");
                filterChain.doFilter(request, response);
                return;
            }

            String username = jwtService.getUsernameFromToken(token);

            UserDetails userDetails = userDetailsService.loadUserByUsername(username);

            boolean isValidToken = jwtService.isValidToken(token, userDetails);

            // If the token is invalid or the user is already authenticated, return an error response.
            if (!isValidToken || SecurityContextHolder.getContext().getAuthentication() != null) {
                log.error("Invalid token or user already authenticated");

                filterChain.doFilter(request, response);
                return;
            }

            // If the token is expired and can be renewed, renew the token and set the new token in the response header.
            if (isTokenExpired && canBeTokenRenewed) {
                String renewedToken = jwtService.renewToken(token, userDetails);
                response.setHeader("Authorization", "Bearer " + renewedToken);
            }

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    userDetails,
                    null,
                    userDetails.getAuthorities()
            );

            authenticationToken.setDetails(
                    new WebAuthenticationDetailsSource()
                            .buildDetails(request));

            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        } catch (Exception e) {
            log.error("Error processing token: {}", e.getMessage());
            handlerExceptionResolver.resolveException(request, response, null, e);
        }

        filterChain.doFilter(request, response);
    }
}
