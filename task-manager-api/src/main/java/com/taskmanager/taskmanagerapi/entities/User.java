package com.taskmanager.taskmanagerapi.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.taskmanager.taskmanagerapi.enums.Gender;

@Entity
@Table(name = "users")
public class User {

	private Long userId;

	private String userLogin;

	private String password;

	private String confirmationPassword;

	private String userName;

	@JsonSerialize(using = DateSerializer.class)
	private Date dateBirth;

	private Gender gender;

	private String email;
	
	private String confirmationEmail;

	@JsonSerialize(using = DateSerializer.class)
	private Date dateCreation;
	
	private List<Task> tasks;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm")
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

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm")
	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Task> getTask() {
		return tasks;
	}

	public void setTask(List<Task> tasks) {
		this.tasks = tasks;
	}
}
