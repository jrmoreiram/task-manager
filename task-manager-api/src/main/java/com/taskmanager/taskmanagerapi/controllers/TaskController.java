package com.taskmanager.taskmanagerapi.controllers;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.taskmanagerapi.dtos.TaskDto;
import com.taskmanager.taskmanagerapi.entities.Task;
import com.taskmanager.taskmanagerapi.response.Response;
import com.taskmanager.taskmanagerapi.servicesimpl.TaskServiceImpl;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

	private static final Logger log = LoggerFactory.getLogger(TaskController.class);

	@Autowired
	private TaskServiceImpl taskService;

	/**
	 * Retorna todas as tarefas.
	 * 
	 * @return ResponseEntity<Response<TaskDto>>
	 */
	@GetMapping(value = "/task")
	public ResponseEntity<Response<TaskDto>> findAll() {
		log.info("Buscando todas as tarefas");
		Response<TaskDto> response = new Response<TaskDto>();
		Optional<List<Task>> task = taskService.findAll();

		if (!task.isPresent()) {
			log.info("Tarefas não encontradas.");
			response.getErrors().add("Tarefas não encontradas.");
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(this.convertTaskDto((Task) task.get()));
		return ResponseEntity.ok(response);
	}

	/**
	 * Popula um DTO com os dados das tarefas.
	 * 
	 * @param Task
	 * @return TaskDto
	 */
	private TaskDto convertTaskDto(Task task) {
		TaskDto taskDto = new TaskDto();
		taskDto.setTaskId(task.getTaskId());
		taskDto.setTaskName(task.getTaskName());
		taskDto.setUser(task.getUser());
		taskDto.setDescription(task.getDescription());
		taskDto.setStatus(task.getStatus());
		taskDto.setTimeEstimated(task.getTimeEstimated());
		taskDto.setTimeDone(task.getTimeDone());
		taskDto.setTimeDetour(task.getTimeDetour());
		return taskDto;
	}
}
