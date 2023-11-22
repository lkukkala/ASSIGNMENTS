package com.cg.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.LoginDTO;
import com.cg.dto.SignupDTO;
import com.cg.repository.RoleRepository;
import com.cg.repository.UserRepository;
import com.cg.entity.Role;
import com.cg.entity.User;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDTO loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsernameOrEmail(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
    }
	
	 @PostMapping("/signup")
	    public ResponseEntity<?> registerUser(@RequestBody SignupDTO signUpDto){

	        // add check for username exists in a DB
	        if(userRepository.existsByUsername(signUpDto.getUsername())){
	        	
	            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
	        }

	        // add check for email exists in DB
	        if(userRepository.existsByEmail(signUpDto.getEmail())){
	            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
	        }
	        User user = new User();
	        user.setName(signUpDto.getName());
	        user.setEmail(signUpDto.getEmail());
	        user.setUsername(signUpDto.getUsername());
	        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
	        
	        System.out.println(" User Data:"+user);
	        Role roles = roleRepository.findByName("role_admin").get();
	        System.out.println("Role Data: "+roles);
	        user.setRoles(Collections.singleton(roles));

	        userRepository.save(user);

	        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
	   }
	 
	 
	 

}
