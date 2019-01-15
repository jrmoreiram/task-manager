package com.taskmanager.taskmanagerapi.servicesimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanager.taskmanagerapi.entities.Task;
import com.taskmanager.taskmanagerapi.repositories.TaskRepository;
import com.taskmanager.taskmanagerapi.services.TaskService;

@Service
public class TaskServiceImpl implements TaskService{

	private static final Logger log = LoggerFactory.getLogger(TaskServiceImpl.class);

	@Autowired
	private TaskRepository taskRepository;

	@Override
	public Optional<List<Task>> findAll() {
		log.info("Buscando todas as tarefas.");
		return Optional.ofNullable(taskRepository.findAll());
	}

	@Override
	public Task persistir(Task task) {
		log.info("Persistindo as tarefas", task);
		return this.taskRepository.save(task);
	}
}
