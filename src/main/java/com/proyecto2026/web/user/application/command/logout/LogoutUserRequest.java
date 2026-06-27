package com.proyecto2026.web.user.application.command.logout;

import com.proyecto2026.web.common.application.mediator.Request;
import lombok.Data;

@Data
public class LogoutUserRequest implements Request<Void> {
    private String token;
}
