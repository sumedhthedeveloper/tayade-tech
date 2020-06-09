package com.tayadetech.manyTomany.repository;

import org.springframework.data.repository.CrudRepository;

import com.tayadetech.manyTomany.entity.Course;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long> {

    List<Course> findByTitleContaining(String title);

    List<Course> findByFeeLessThan(double fee);
}