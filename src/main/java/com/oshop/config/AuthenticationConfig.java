package com.oshop.config;

import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.oshop.auth.AuthenticationFailureHandler;
import com.oshop.auth.AuthenticationSuccessHandler;
import com.oshop.auth.LogoutSuccess;
import com.oshop.auth.RestAuthenticationEntryPoint;
import com.oshop.auth.TokenAuthenticationFilter;
import com.oshop.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class AuthenticationConfig extends WebSecurityConfigurerAdapter {

	  private final CustomUserDetailsService jwtUserDetailsService;
	  private final RestAuthenticationEntryPoint restAuthenticationEntryPoint;
	  private final LogoutSuccess logoutSuccess;
	  private final AuthenticationSuccessHandler authenticationSuccessHandler;
	  private final AuthenticationFailureHandler authenticationFailureHandler;
	  @Value("${jwt.cookie}")
	  private String TOKEN_COOKIE;
	  
	  @Autowired
	  public AuthenticationConfig(CustomUserDetailsService jwtUserDetailsService, RestAuthenticationEntryPoint restAuthenticationEntryPoint, LogoutSuccess logoutSuccess, AuthenticationSuccessHandler authenticationSuccessHandler, AuthenticationFailureHandler authenticationFailureHandler) {
	    this.jwtUserDetailsService = jwtUserDetailsService;
	    this.restAuthenticationEntryPoint = restAuthenticationEntryPoint;
	    this.logoutSuccess = logoutSuccess;
	    this.authenticationSuccessHandler = authenticationSuccessHandler;
	    this.authenticationFailureHandler = authenticationFailureHandler;
	  }

	  @Bean
	  public TokenAuthenticationFilter jwtAuthenticationTokenFilter() throws Exception {
	    return new TokenAuthenticationFilter();
	  }

	  @Bean
	  @Override
	  public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	  }

	  @Bean
	  public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	  }

	  @Autowired
	  public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder)
	          throws Exception {
	    authenticationManagerBuilder.userDetailsService(jwtUserDetailsService)
	            .passwordEncoder(passwordEncoder());

	  }
	 
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors();
//		http.csrf().ignoringAntMatchers("/login", "/api/signup","/logout") // if we disable the CSRF then I am not getting 401 on other POST requests
		http.csrf().disable()
//        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and()
        .addFilterBefore(jwtAuthenticationTokenFilter(), BasicAuthenticationFilter.class)
        .authorizeRequests().antMatchers(HttpMethod.POST, "/login/**").hasAnyRole("ADMIN", "USER").anyRequest().authenticated().and().formLogin().loginPage("/login")
        .successHandler(authenticationSuccessHandler).failureHandler(authenticationFailureHandler)
        .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .logoutSuccessHandler(logoutSuccess).deleteCookies(TOKEN_COOKIE);
		 
	}
	@Bean
    CorsConfigurationSource corsConfigurationSource() {
		 CorsConfiguration configuration = new CorsConfiguration();
		 configuration.addAllowedOrigin("https://organic-shoppers.com");
		 configuration.setAllowCredentials(true);
	        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
	        configuration.setAllowedHeaders(Arrays.asList("authorization", "content-type", "x-auth-token","Access-Control-Allow-Origin"));
	        configuration.setExposedHeaders(Arrays.asList("x-auth-token"));
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", configuration);
	        return source;
    }
	
	public String changePassword(String oldPassword, String newPassword) throws Exception {

	    Authentication currentUser = SecurityContextHolder.getContext().getAuthentication();
	    String username = currentUser.getName();

	    if (authenticationManagerBean() != null) {
	     
	      System.out.println("Re-authenticating user '" + username + "' for password change request.");
	    	 Authentication authentication= authenticationManagerBean().authenticate(new UsernamePasswordAuthenticationToken(username, oldPassword));
	    	 if(authentication.isAuthenticated()) {
	    		 return username;
	    	 }
	    	 else
	    	 {
	    		 return null;
	    	 }
		
	      
	    } else {
	      
	      System.out.println("No authentication manager set. can't change Password!");

	      return null;
	    }	   
	  }
}
