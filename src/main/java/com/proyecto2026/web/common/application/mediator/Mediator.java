package com.proyecto2026.web.common.application.mediator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
@Slf4j
public class Mediator {
    Map<? extends Class<?>, RequestHandler<?, ?>> requestHandlersMap;

    public Mediator(List<RequestHandler<?, ?>> requestHandlers) {
        requestHandlersMap = requestHandlers.stream().collect(Collectors.toMap(RequestHandler::getRequestType, Function.identity()));
    }

    public <R, T extends Request<R>> R dispatch(T request) {
        RequestHandler<T, R> handler = (RequestHandler<T, R>) requestHandlersMap.get(request.getClass());

        if (handler == null) {
            log.error("No handler found for request type: {}", request.getClass());
            throw new RuntimeException("No handler found for request type: " + request.getClass());
        }

        return handler.handle(request);
    }

    @Async
    public <R, T extends Request<R>> void dispatchAsync(T request) {
        this.dispatch(request);
    }
}
