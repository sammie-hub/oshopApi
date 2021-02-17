package com.oshop.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.oshop.config.AuthenticationConfig;
import com.oshop.model.UserTokenState;
import com.oshop.model.users.UserRegisteration;
import com.oshop.service.RegisterUserService;
import com.oshop.utils.TokenHelper;

//@CrossOrigin(origins = "*")
@RestController
public class RegisterUserController {

	private final com.oshop.utils.TokenHelper tokenHelper;
	private final AuthenticationConfig authenticationConfig;
	private final RegisterUserService registerUserService;

	@Value("${jwt.expires_in}")
	private int EXPIRES_IN;

	@Value("${jwt.cookie}")
	private String TOKEN_COOKIE;

	@Autowired
	public RegisterUserController(TokenHelper tokenHelper, AuthenticationConfig authenticationConfig,
			RegisterUserService registerUserService) {
		this.tokenHelper = tokenHelper;
		this.authenticationConfig = authenticationConfig;
		this.registerUserService = registerUserService;
	}

	@RequestMapping(value = "register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public int addProduct(@RequestBody UserRegisteration user) {
		return registerUserService.registerUser(user);
	}

	@RequestMapping(value = "/refresh", method = RequestMethod.GET)
	public ResponseEntity<?> refreshAuthenticationToken(HttpServletRequest request, HttpServletResponse response) {
		String authToken = tokenHelper.getToken(request);
		if (authToken != null && tokenHelper.canTokenBeRefreshed(authToken)) {
			// TODO check user password last update
			String refreshedToken = tokenHelper.refreshToken(authToken);

			Cookie authCookie = new Cookie(TOKEN_COOKIE, (refreshedToken));
			authCookie.setPath("/");
//			authCookie.setHttpOnly(true);
//			authCookie.setSecure(true);
			authCookie.setMaxAge(EXPIRES_IN);
			// Add cookie to response
//			response.addCookie(authCookie);
			response.setHeader("Set-Cookie", "AUTH-TOKEN="+refreshedToken+"; HttpOnly; SameSite=None; Secure");
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String authority = auth.getAuthorities().stream().findFirst().get().getAuthority();
			UserTokenState userTokenState = new UserTokenState(refreshedToken, EXPIRES_IN, auth.getName(), authority);
			return ResponseEntity.ok(userTokenState);
		} else {
			UserTokenState userTokenState = new UserTokenState();
			return ResponseEntity.accepted().body(userTokenState);
		}
	}
	
	@RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public ResponseEntity<?> changePassword(@RequestBody PasswordChanger passwordChanger) throws Exception {
		String email = authenticationConfig.changePassword(passwordChanger.oldPassword, passwordChanger.newPassword);
		Map<String, String> result = new HashMap<>();
		if(email != null) {
			result.put("result", "200"); 
			UserRegisteration user = registerUserService.findByEmail(email); 
			user.setPassword(new BCryptPasswordEncoder().encode(passwordChanger.newPassword));
			registerUserService.save(user);
			return ResponseEntity.accepted().body(result); 
		}
		else
			result.put("result", "400"); 
			return ResponseEntity.badRequest().body(result);  
    }
	static class PasswordChanger {
        public String oldPassword;
        public String newPassword;
    }
}
