package com.example.springdatademo;

import com.example.springdatademo.domain.Book;
import com.example.springdatademo.repositories.BookRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jpjensen
 * @version %I%
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages = {"com.example.springdatademo.bootstrap"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SpringBootJpaTestSlice {

    @Autowired
    BookRepository bookRepository;

    @Rollback(value = false)
    @Order(1)
    @Test
    void testJpaTestSplice() {
        long countBefore = this.bookRepository.count();
        assertThat(countBefore).isEqualTo(2);

        this.bookRepository.save(new Book("My Book", "12346565", "Self", null));

        long countAfter = this.bookRepository.count();

        assertThat(countBefore).isLessThan(countAfter);
    }

    @Order(2)
    @Test
    void testJpaTestSpliceTransaction() {
        long countBefore = this.bookRepository.count();
        assertThat(countBefore).isEqualTo(3);

    }
}
