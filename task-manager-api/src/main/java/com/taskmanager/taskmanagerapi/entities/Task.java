package com.taskmanager.taskmanagerapi.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.taskmanager.taskmanagerapi.enums.Status;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@Entity
@Table(name = "tasks")
public class Task {

	private Long taskId;

	private User user;

	private Status status;

	private String taskName;

	private String description;

	private String timeEstimated;

	private String timeSpent;

	private String timeDetour;

	@JsonSerialize(using = DateSerializer.class)
	private Date dateCreation;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Enumerated(EnumType.STRING)
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

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm")
	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
}
