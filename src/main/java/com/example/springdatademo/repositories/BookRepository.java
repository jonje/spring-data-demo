package com.example.springdatademo.repositories;

import com.example.springdatademo.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author jpjensen
 * @version %I%
 * @since
 */

public interface BookRepository extends JpaRepository<Book, Long> {
}
