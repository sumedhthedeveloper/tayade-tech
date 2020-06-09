package com.tayadetech.oneToone.repository;

import org.springframework.data.repository.CrudRepository;

import com.tayadetech.oneToone.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
