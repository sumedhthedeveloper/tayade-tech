package com.tayadetech.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tayadetech.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByUsername(String userName);
}
