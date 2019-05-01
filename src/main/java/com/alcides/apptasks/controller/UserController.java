package com.alcides.apptasks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alcides.apptasks.model.User;
import com.alcides.apptasks.repository.UserRepository;

@RestController
@CrossOrigin
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired 
	private UserRepository repository;
	
	@GetMapping()
    public List<User> getAll() {
        return repository.findByIsExcluido(false);
    }
	
	@PostMapping()
    public User save(@RequestBody User user) {
		if (user == null)
			return repository.save(null);
		
		if (user.getId() == null) {
			user.setIsExcluido(false);
		}
		
		
        return repository.save(user);
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
		User user = repository.findById(id).orElseThrow();
		
		user.setIsExcluido(true);
		repository.save(user);
		
		return ResponseEntity.ok().build();
    }
}
