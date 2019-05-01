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

import com.alcides.apptasks.model.Task;
import com.alcides.apptasks.repository.TaskRepository;

@RestController
@CrossOrigin
@RequestMapping(value="/task")
public class TasksController {
	
	@Autowired 
	private TaskRepository repository;
	
	@GetMapping()
    public List<Task> getAll() {
        return repository.findByIsExcluido(false);
    }
	
	@GetMapping("/byUser/{id}")
    public List<Task> getByUserId(@PathVariable Long id) {
        return repository.findByIsExcluidoAndUserId(false, id);
    }
	
	@GetMapping("/byId/{id}")
    public Task getById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }
	
	@PostMapping()
    public Task save(@RequestBody Task task) {
		if (task == null)
			return repository.save(null);
		
		if (task.getId() == null) {
			task.setConcluido(false);
			task.setIsExcluido(false);
		}
		
        return repository.save(task);
    }
	
	@DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
		Task task = repository.findById(id).orElseThrow();
		
		task.setIsExcluido(true);
		repository.save(task);
		
		return ResponseEntity.ok().build();
    }
}
