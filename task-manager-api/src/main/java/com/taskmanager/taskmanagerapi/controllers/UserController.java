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

import com.taskmanager.taskmanagerapi.dtos.UserDto;
import com.taskmanager.taskmanagerapi.entities.User;
import com.taskmanager.taskmanagerapi.response.Response;
import com.taskmanager.taskmanagerapi.servicesimpl.UserServiceImpl;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserServiceImpl userService;

	/**
	 * Retorna todos os usuários.
	 * 
	 * @return ResponseEntity<Response<UserDto>>
	 */
	@GetMapping(value = "/users")
	public ResponseEntity<Response<UserDto>> findAll() {
		log.info("Buscando todos os usuários");
		Response<UserDto> response = new Response<UserDto>();
		Optional<List<User>> user = userService.findAll();

		if (!user.isPresent()) {
			log.info("Usuários não encontrados.");
			response.getErrors().add("Usuários não encontrados.");
			return ResponseEntity.badRequest().body(response);
		}

		response.setData(this.convertUserDto((User) user.get()));
		return ResponseEntity.ok(response);
	}

	/**
	 * Popula um DTO com os dados dos usuários.
	 * 
	 * @param User
	 * @return UserDto
	 */
	private UserDto convertUserDto(User user) {
		UserDto UserDto = new UserDto();
		UserDto.setUserId(user.getUserId());
		UserDto.setUserLogin(user.getUserLogin());
		UserDto.setPassword(user.getPassword());
		UserDto.setConfirmationPassword(user.getConfirmationPassword());
		UserDto.setUserName(user.getUserName());
		UserDto.setDateBirth(user.getDateBirth());
		UserDto.setGender(user.getGender());
		UserDto.setEmail(user.getEmail());
		UserDto.setConfirmationEmail(user.getConfirmationEmail());
		return UserDto;
	}
}
