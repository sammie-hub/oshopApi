package com.oshop.service;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.oshop.email.SendEmail;
import com.oshop.model.users.UserRegisteration;
import com.oshop.repo.RegisterUserRepository;

@Service
public class RegisterUserService {

	@Autowired
	RegisterUserRepository registerUserRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private SendEmail sendemail;
	
	private static final String EMAIL_PATTERN =
            "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	
	public int registerUser(UserRegisteration user) {
		if(user.getPassword() == null || user.getPassword().length() <  8 ||
				user.getEmail() == null || !isValid(user.getEmail()) || 
				user.getFname() == null || user.getFname() == "" ||
				user.getLname() == null || user.getLname() == "")
		{
			return -2;
		}
		if(registerUserRepo.findByEmail(user.getEmail()) != null) {
			return -1;
		}
//		try {
//			sendemail.sendmail(user.getFname() + " " + user.getLname(), user.getEmail());
//		} catch (MessagingException | IOException e) {
//			return -2;
//		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return registerUserRepo.save(user).getId();
	}

	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}

	public static boolean isValid(final String email) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
	
	public void save(UserRegisteration user) {
		registerUserRepo.save(user);
	}
	
	public UserRegisteration findByEmail(String email) {
		return registerUserRepo.findByEmail(email);
	}
}
