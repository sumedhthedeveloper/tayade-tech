package com.tayadetech.oneTomany.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import com.tayadetech.oneTomany.entity.Book;
import com.tayadetech.oneTomany.entity.Page;

import java.util.List;

public interface PageRepository extends CrudRepository<Page, Long> {

    List<Page> findByBook(Book book, Sort sort);
}