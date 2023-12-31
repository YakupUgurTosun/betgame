package com.spottoto.bet.exceptions.handler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.spottoto.bet.security.JwtTokenFilter.HEADER_STRING;

@Component
public class CustomAuthenticatiomEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {

        final String authHeader = request.getHeader(HEADER_STRING);

        if (authHeader == null) {
            response.addHeader("access_denied_reason", "authentication_required");
            response.sendError(401, "Unauthorized");

        }else
            response.sendError(403, "Access Denied");
    }


}