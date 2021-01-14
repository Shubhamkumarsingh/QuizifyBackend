package com.project.quizify.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.el.ListELResolver;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.project.quizify.models.ERole;
import com.project.quizify.models.Role;
import com.project.quizify.models.User;
import com.project.quizify.request.LoginRequest;
import com.project.quizify.request.SignupRequest;
import com.project.quizify.response.JwtResponse;
import com.project.quizify.response.MessageResponse;
import com.project.quizify.service.UserDetailsImpl;

import com.project.quizify.repository.*;
import com.project.quizify.security.jwt.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
public class AdninController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder encoder;

	
	@GetMapping("/alluser")
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	
	@PostMapping("/add")
	
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()));
		//System.out.println(user);
		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();
          
		//if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
			System.out.println(roles);
	//	} else {
//			strRoles.forEach(role -> {
//				switch (role) {
//				
//				case "mod":
//					Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
//							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//					roles.add(modRole);
//
//					break;
//					
//				
//				}
//			});
//		}

		System.out.println(roles);
		user.setRoles(roles);
		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("Moderator registered successfully!"));
	}

	
}
