package com.example.springdatademo;

import com.example.springdatademo.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringDataDemoApplicationTests {
    @Autowired
    BookRepository bookRepository;

    @Test
    void testBookRepository() {
        long count = this.bookRepository.count();
        assertThat(count).isGreaterThan(0);
    }

    @Test
    void contextLoads() {
    }

}
