package com.taskmanager.taskmanagerapi.servicesimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanager.taskmanagerapi.entities.User;
import com.taskmanager.taskmanagerapi.repositories.UserRepository;
import com.taskmanager.taskmanagerapi.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(TaskServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public Optional<List<User>> findAll() {
		log.info("Buscando todos os usuários.");
		return Optional.ofNullable(userRepository.findAll());
	}

	@Override
	public User persistir(User user) {
		log.info("Persistindo os usuários", user);
		return this.userRepository.save(user);
	}
}
