package com.oshop.model;

import java.security.Principal;

import org.springframework.security.core.Authentication;

public class UserTokenState {
    private String access_token;
    private Long expires_in;
    
    private String username;
    
    private String authourity;
    
   

    public UserTokenState() {
        this.access_token = null;
        this.expires_in = null;
        this.username = null;
        this.authourity = null;
      
    }

   



	



	public UserTokenState(String access_token, long expires_in, String username, String authourity) {
		super();
		this.access_token = access_token;
		this.expires_in = expires_in;
		this.username = username;
		this.authourity = authourity;
	}
















	public String getAuthourity() {
		return authourity;
	}









	public void setAuthourity(String authourity) {
		this.authourity = authourity;
	}









	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	


	public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Long expires_in) {
        this.expires_in = expires_in;
    }
}

