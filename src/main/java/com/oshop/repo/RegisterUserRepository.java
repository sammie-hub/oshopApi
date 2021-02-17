package com.oshop.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oshop.model.users.UserRegisteration;

@Repository
public interface RegisterUserRepository extends JpaRepository<UserRegisteration, Integer> {

	UserRegisteration findByEmail(String email);
}
