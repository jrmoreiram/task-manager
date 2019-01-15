package com.taskmanager.taskmanagerapi.dtos;

import java.util.Date;
import java.util.List;

import com.taskmanager.taskmanagerapi.entities.Task;
import com.taskmanager.taskmanagerapi.enums.Gender;


/**
 * 
 * @author Junior, Data Transfer Objetcts para os dados dos usuários.
 *
 */
public class UserDto {
	private Long userId;

	private String userLogin;

	private String password;

	private String confirmationPassword;

	private String userName;
	
	private Date dateBirth;

	private Gender gender;

	private String email;
	
	private String confirmationEmail;

	private Date dateCreation;
	
	private List<Task> task;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmationPassword() {
		return confirmationPassword;
	}

	public void setConfirmationPassword(String confirmationPassword) {
		this.confirmationPassword = confirmationPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getConfirmationEmail() {
		return confirmationEmail;
	}

	public void setConfirmationEmail(String confirmationEmail) {
		this.confirmationEmail = confirmationEmail;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public List<Task> getTask() {
		return task;
	}

	public void setTask(List<Task> task) {
		this.task = task;
	}
}
