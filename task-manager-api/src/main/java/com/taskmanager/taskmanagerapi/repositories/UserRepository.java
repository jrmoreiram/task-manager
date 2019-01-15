package com.taskmanager.taskmanagerapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.taskmanager.taskmanagerapi.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Transactional(readOnly = true)
	List<User> findAll();
}
