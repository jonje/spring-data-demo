package com.example.springdatademo.bootstrap;

import com.example.springdatademo.domain.Book;
import com.example.springdatademo.repositories.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author jpjensen
 * @version %I%
 */
@Profile({"local", "default"})
@Slf4j
@Component
public class DataInitializer implements CommandLineRunner {
    private final BookRepository bookRepository;

    public DataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        // Clean up all the books for a fresh start.
        this.bookRepository.deleteAll();

        Book book = new Book("Domain Driven Design", "123", "RandomHouse", null);
        log.info("Book before save id: {}", book.getId());
        Book savedBook = this.bookRepository.save(book);
        log.info("Book after save id: {}", savedBook.getId());

        Book bookSIA = new Book("Spring in Action", "332343232", "O`Reilly", null);
        Book savedSIA = this.bookRepository.save(bookSIA);

        this.bookRepository.findAll().forEach(book1 -> log.info("Book title: {}", book1.getTitle()));

    }
}
