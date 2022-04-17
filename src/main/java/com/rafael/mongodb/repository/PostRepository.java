package com.rafael.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.rafael.mongodb.domain.Post;


@Repository
public interface PostRepository extends MongoRepository<Post, String>{


}
