package com.tayadetech.oneToone.repository;

import org.springframework.data.repository.CrudRepository;

import com.tayadetech.oneToone.entity.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
