package com.tayadetech.oneTomany.repository;

import org.springframework.data.repository.CrudRepository;

import com.tayadetech.oneTomany.entity.Book;


public interface BookRepository extends CrudRepository<Book, Long> {

    Book findByIsbn(String isbn);
}