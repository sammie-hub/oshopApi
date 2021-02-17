package com.oshop.auth;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.Assert;
import org.springframework.web.filter.OncePerRequestFilter;

import com.oshop.utils.TokenHelper;

public class TokenAuthenticationFilter  extends OncePerRequestFilter{

	 private final Log logger = LogFactory.getLog(this.getClass());

	 private final List<String> allowedOrigins = Arrays.asList("https://organic-shoppers.com");

	    @Autowired
	    private TokenHelper tokenHelper;

	    @Autowired
	    @Qualifier("customUserDetailsService")
	    private UserDetailsService userDetailsService;

	    /*
	     * The below paths will get ignored by the filter
	     */
	    public static final String ROOT_MATCHER = "/";
	    public static final String FAVICON_MATCHER = "/favicon.ico";
	    public static final String HTML_MATCHER = "/**/*.html";
	    public static final String CSS_MATCHER = "/**/*.css";
	    public static final String JS_MATCHER = "/**/*.js";
	    public static final String IMG_MATCHER = "/images/*";
	    public static final String LOGIN_MATCHER = "/auth/login";
	    public static final String LOGOUT_MATCHER = "/auth/logout";

	    private final List<String> pathsToSkip = Arrays.asList(
	            ROOT_MATCHER,
	            HTML_MATCHER,
	            FAVICON_MATCHER,
	            CSS_MATCHER,
	            JS_MATCHER,
	            IMG_MATCHER,
	            LOGIN_MATCHER,
	            LOGOUT_MATCHER
	    );

	    @Override
	    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

	    	 String origin = request.getHeader("Origin");
	            response.setHeader("Access-Control-Allow-Origin", allowedOrigins.contains(origin) ? origin : "");
	            response.setHeader("Vary", "Origin");
	            // Access-Control-Max-Age
	            response.setHeader("Access-Control-Max-Age", "3600");
//	            response.setHeader("Set-Cookie", "key=value; HttpOnly; SameSite=None; Secure");

	            // Access-Control-Allow-Credentials
	            response.setHeader("Access-Control-Allow-Credentials", "true");

	            // Access-Control-Allow-Methods
	            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");

	            // Access-Control-Allow-Headers
	            response.setHeader("Access-Control-Allow-Headers",
	                "Origin, X-Requested-With, Content-Type, Accept, " + "X-CSRF-TOKEN");

	        String authToken = tokenHelper.getToken(request);
	        if (authToken != null && !skipPathRequest(request, pathsToSkip)) {
	            // get username from token
	            try {
	                String username = tokenHelper.getUsernameFromToken(authToken);
	                // get user
	                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
	                // create authentication
	                TokenBasedAuthentication authentication = new TokenBasedAuthentication(userDetails);
	                authentication.setToken(authToken);
	                SecurityContextHolder.getContext().setAuthentication(authentication);
	            } catch (Exception e) {
	                SecurityContextHolder.getContext().setAuthentication(new AnonAuthentication());
	            }
	        } else {
	            SecurityContextHolder.getContext().setAuthentication(new AnonAuthentication());
	        }

	        chain.doFilter(request, response);
	    }
	    
	   

	    private boolean skipPathRequest(HttpServletRequest request, List<String> pathsToSkip) {
	        Assert.notNull(pathsToSkip, "path cannot be null.");
	        List<RequestMatcher> m = pathsToSkip.stream().map(path -> new AntPathRequestMatcher(path)).collect(Collectors.toList());
	        OrRequestMatcher matchers = new OrRequestMatcher(m);
	        return matchers.matches(request);
	    }

}
