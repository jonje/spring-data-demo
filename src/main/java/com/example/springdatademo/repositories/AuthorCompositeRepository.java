package com.example.springdatademo.repositories;

import com.example.springdatademo.domain.AuthorComposite;
import com.example.springdatademo.domain.NameId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorCompositeRepository extends JpaRepository<AuthorComposite, NameId> {
}
