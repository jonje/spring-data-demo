package com.example.springdatademo.service;

import com.example.springdatademo.entity.PostEntity;
import com.example.springdatademo.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private final PostRepository repository;

    public PostService(final PostRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<PostEntity> getPostByDate(LocalDate date) {
        int month = date.getMonthValue();
        int year = date.getYear();
        return this.repository.findAllByDate(month, year).orElse(new ArrayList<>());
    }
}
