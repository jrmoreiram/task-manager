package com.taskmanager.taskmanagerapi.dtos;

import com.taskmanager.taskmanagerapi.entities.User;
import com.taskmanager.taskmanagerapi.enums.Status;

/**
 * 
 * @author Junior, Data Transfer Objetcts para os dados das tarefas.
 *
 */
public class TaskDto {
	private Long taskId;

	private User user;

	private Status status;

	private String taskName;

	private String description;

	private String timeEstimated;

	private String timeSpent;

	private String timeDetour;

	private String dateCreation;

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTimeEstimated() {
		return timeEstimated;
	}

	public void setTimeEstimated(String timeEstimated) {
		this.timeEstimated = timeEstimated;
	}

	public String getTimeDone() {
		return timeSpent;
	}

	public void setTimeDone(String timeSpent) {
		this.timeSpent = timeSpent;
	}

	public String getTimeDetour() {
		return timeDetour;
	}

	public void setTimeDetour(String timeDetour) {
		this.timeDetour = timeDetour;
	}

	public String getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}
}
