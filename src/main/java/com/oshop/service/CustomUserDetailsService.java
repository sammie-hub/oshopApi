package com.oshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.oshop.config.UserPrincipal;
import com.oshop.model.users.UserRegisteration;
import com.oshop.repo.RegisterUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final RegisterUserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(RegisterUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
	UserPrincipal userPrincipal;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserRegisteration user = userRepository.findByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException("404");
		}
		userPrincipal.setUser(user);
		return userPrincipal;
	}
    


    public void save(UserRegisteration user) {
        userRepository.save(user);
    }
}