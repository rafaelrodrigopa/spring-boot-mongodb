package com.rafael.mongodb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.mongodb.domain.Post;
import com.rafael.mongodb.repository.PostRepository;
import com.rafael.mongodb.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Optional<Post> findById(String id) {
		Optional<Post> post = repo.findById(id);
		if (post == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return post;
	}
	
}
