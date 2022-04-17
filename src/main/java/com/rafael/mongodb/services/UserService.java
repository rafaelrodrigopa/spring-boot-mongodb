package com.rafael.mongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.mongodb.domain.User;
import com.rafael.mongodb.dto.UserDTO;
import com.rafael.mongodb.repository.UserRepository;
import com.rafael.mongodb.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public Optional<User> findById(String id) {
		Optional<User> user = repo.findById(id);
		if (user == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return user;
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	public User update(User obj) {
		Optional<User> newObj = repo.findById(obj.getId());
		User newObjUser = newObj.get();
		updateData(newObjUser, obj);
		return repo.save(newObjUser);
	}
	
	private void updateData(User newObjUser, User obj) {

		newObjUser.setName(obj.getName());
		newObjUser.setEmail(obj.getEmail());
		
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
	
}
