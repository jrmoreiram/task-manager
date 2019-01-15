package com.taskmanager.taskmanagerapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.taskmanager.taskmanagerapi.entities.User;

@Service
public interface UserService {
	/**
	 * Retorna todos os usuários.
	 * 
	 * @return Optional<User>
	 */
	Optional<List<User>> findAll();

	/**
	 * Cadastra os usuários na base de dados.
	 * 
	 * @param user
	 * @return User
	 */
	User persistir(User user);
}
