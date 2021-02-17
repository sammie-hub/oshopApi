package com.oshop.auth;

import com.oshop.model.UserTokenState;
import com.oshop.model.users.UserRegisteration;
import com.oshop.utils.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final TokenHelper tokenHelper;
    private final ObjectMapper objectMapper;
    @Value("${jwt.expires_in}")
    private int EXPIRES_IN;
    @Value("${jwt.cookie}")
    private String TOKEN_COOKIE;

    @Autowired
    public AuthenticationSuccessHandler(TokenHelper tokenHelper, ObjectMapper objectMapper) {
        this.tokenHelper = tokenHelper;
        this.objectMapper = objectMapper;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        clearAuthenticationAttributes(request);
//        System.out.println(authentication.getPrincipal());
//        UserRegisteration user = (UserRegisteration) authentication.getPrincipal();

        String jws = tokenHelper.generateToken(authentication.getName());

        // Create token auth Cookie
        Cookie authCookie = new Cookie(TOKEN_COOKIE, (jws));

//        authCookie.setHttpOnly(true);
//        authCookie.setSecure(true);
        authCookie.setMaxAge(EXPIRES_IN);

        authCookie.setPath("/");
        // Add cookie to response
//        response.addCookie(authCookie);
        response.setHeader("Set-Cookie", "AUTH-TOKEN="+jws+"; HttpOnly; SameSite=None; Secure");
        // JWT is also in the response
        String authority = authentication.getAuthorities().stream().findFirst().get().getAuthority();
        UserTokenState userTokenState = new UserTokenState(jws, EXPIRES_IN, authentication.getName(), authority);
        String jwtResponse = objectMapper.writeValueAsString(userTokenState);
        response.setContentType("application/json");
        response.getWriter().write(jwtResponse);

    }
}
