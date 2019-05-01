package com.alcides.apptasks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
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
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired 
	private UserRepository repository;
	
	@GetMapping()
    public List<User> getAll(Pageable pageable) {
        return repository.findByIsExcluido(false);
    }
	
	@PostMapping()
    public User save(@RequestBody User task) {
        return repository.save(task);
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
		User user = repository.findById(id).orElseThrow();
		
		user.setIsExcluido(true);
		repository.save(user);
		
		return ResponseEntity.ok().build();
    }
}
