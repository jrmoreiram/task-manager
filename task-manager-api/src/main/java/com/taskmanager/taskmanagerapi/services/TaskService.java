package com.taskmanager.taskmanagerapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.taskmanager.taskmanagerapi.entities.Task;

@Service
public interface TaskService {

	/**
	 * Retorna todas as tarefas.
	 * 
	 * @return Optional<Task>
	 */
	Optional<List<Task>> findAll();

	/**
	 * Cadastra as tarefas na base de dados.
	 * 
	 * @param task
	 * @return Task
	 */
	Task persistir(Task task);
}
