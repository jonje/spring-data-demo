package com.example.springdatademo.repository;

import com.example.springdatademo.entity.PostEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends CrudRepository<PostEntity, Long> {

    @Query("select p, com from PostEntity p inner join p.comments com where com.commentMonth = :month and com.commentYear = :year")
    Optional<List<PostEntity>> findAllByDate(int month, int year);
}
