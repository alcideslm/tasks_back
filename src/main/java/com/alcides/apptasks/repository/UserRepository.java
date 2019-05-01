package com.alcides.apptasks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alcides.apptasks.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findByIsExcluido(boolean b);
}