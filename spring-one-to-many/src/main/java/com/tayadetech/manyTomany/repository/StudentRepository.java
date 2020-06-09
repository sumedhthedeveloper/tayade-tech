package com.tayadetech.manyTomany.repository;

import org.springframework.data.repository.CrudRepository;

import com.tayadetech.manyTomany.entity.Student;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {

    List<Student> findByNameContaining(String name);
}
