package com.tts.ecommerce.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tts.ecommerce.model.Role;
import com.tts.ecommerce.model.User;
import com.tts.ecommerce.repository.RoleRepository;
import com.tts.ecommerce.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
	  this.userRepository = userRepository;
	  this.roleRepository = roleRepository;
	  this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public User findByUsername(String username) {
	  return userRepository.findByUsername(username);
	}

	public List<User> findAllUsers() {
	  return (List<User>) userRepository.findAll();
	}

	public void save(User user) {
	  userRepository.save(user);
	}

	public User saveNewUser(User user) {
	  user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	  Role userRole = roleRepository.findByRole("USER");
	  user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
	  return userRepository.save(user);
	}

	public User getLoggedInUser() {
	  String loggedInUsername = SecurityContextHolder.getContext().getAuthentication().getName();
	  return findByUsername(loggedInUsername);
	}

}
