package com.oshop.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Component
public class LogoutSuccess implements LogoutSuccessHandler {

    private final ObjectMapper objectMapper;

    @Autowired
    public LogoutSuccess(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        Map<String, String> result = new HashMap<>();
        result.put("result", "success");
        response.setContentType("application/json");
        response.setHeader("Set-Cookie", "AUTH-TOKEN=''; HttpOnly; SameSite=None; Secure");
        response.getWriter().write(objectMapper.writeValueAsString(result));
        response.setStatus(HttpServletResponse.SC_OK);

    }

}
