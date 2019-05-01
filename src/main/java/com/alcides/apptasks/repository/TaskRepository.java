package com.alcides.apptasks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alcides.apptasks.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	List<Task> findByIsExcluido(boolean b);
}