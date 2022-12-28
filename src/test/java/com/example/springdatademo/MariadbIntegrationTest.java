package com.example.springdatademo;

import com.example.springdatademo.domain.AuthorComposite;
import com.example.springdatademo.domain.AuthorUuid;
import com.example.springdatademo.domain.BookUuid;
import com.example.springdatademo.domain.NameId;
import com.example.springdatademo.repositories.AuthorCompositeRepository;
import com.example.springdatademo.repositories.AuthorUuidRepository;
import com.example.springdatademo.repositories.BookRepository;
import com.example.springdatademo.repositories.BookUuidRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = {"com.example.springdatademo.bootstrap"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MariadbIntegrationTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorUuidRepository authorUuidRepository;

    @Autowired
    BookUuidRepository bookUuidRepository;

    @Autowired
    AuthorCompositeRepository authorCompositeRepository;

    @Test
    void test() {
        long count = this.bookRepository.count();
        assertThat(count).isEqualTo(2);
    }
    @Test
    void authorUuidSaved() {
        AuthorUuid authorUuid = new AuthorUuid("Michael", "Weston");
        authorUuid = authorUuidRepository.save(authorUuid);
        assertThat(authorUuid).isNotNull();
        UUID id = authorUuid.getId();
        assertThat(id).isNotNull();

        Optional<AuthorUuid> authorOption = this.authorUuidRepository.findById(id);
        assertThat(authorOption.isPresent()).isTrue();
    }

    @Test
    void bookUuidSaved() {
        BookUuid bookUuid = new BookUuid("Test Book", "jdjdfkdfjdksls", "Test Publishing");
        bookUuid = this.bookUuidRepository.save(bookUuid);
        assertThat(bookUuid).isNotNull();
        UUID id = bookUuid.getId();
        assertThat(id).isNotNull();

        Optional<BookUuid> bookOptional = this.bookUuidRepository.findById(id);
        assertThat(bookOptional.isPresent()).isTrue();
    }

    @Test
    void authorCompositeSave() {
        NameId nameId = new NameId("Sam","Axe");
        AuthorComposite authorComposite = new AuthorComposite();
        authorComposite.setFirstName(nameId.getFirstName());
        authorComposite.setLastName(nameId.getLastName());
        authorComposite.setCountry("US");

        AuthorComposite saved = this.authorCompositeRepository.save(authorComposite);
        assertThat(saved).isNotNull();
        Optional<AuthorComposite> fetched = this.authorCompositeRepository.findById(nameId);
        assertThat(fetched.isPresent()).isTrue();
    }
}
