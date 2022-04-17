package com.rafael.mongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.mongodb.domain.User;
import com.rafael.mongodb.dto.UserDTO;
import com.rafael.mongodb.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
//	public User findById(String id) {
//		User user = repo.findById(id);
//		if (user == null) {
//			throw new ObjectNotFoundException("Objeto não encontrado");
//		}
//		return user;
//	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
