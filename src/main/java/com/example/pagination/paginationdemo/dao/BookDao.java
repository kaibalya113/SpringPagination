package com.example.pagination.paginationdemo.dao;

import com.example.pagination.paginationdemo.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book, Long> {

    Page<Book> findByBookNameContaining(String bookName, Pageable pageable);
}
