package com.example.springdatademo.runner;

import com.example.springdatademo.entity.PostEntity;
import com.example.springdatademo.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class DatabaseRunner implements CommandLineRunner {
    private final PostRepository postRepository;

    public DatabaseRunner(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        Optional<List<PostEntity>> posts = this.postRepository.findAllByDate(10, 2022);
        List<PostEntity> postList = posts.orElse(new ArrayList<>());

        log.info("");
    }
}
