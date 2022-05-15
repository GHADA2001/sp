package com.grokonez.jwtauthentication.controller;

import com.grokonez.jwtauthentication.model.ConfirmationEmail;
import com.grokonez.jwtauthentication.service.AuthService;
import com.grokonez.jwtauthentication.service.ConfirmationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.grokonez.jwtauthentication.message.request.LoginForm;
import com.grokonez.jwtauthentication.message.request.SignUpForm;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

	@Autowired
	AuthService authService;

	@Autowired
	ConfirmationService confirmationService;

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginForm loginRequest) {
		return 	authService.authenticateUser(loginRequest);
	}
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody SignUpForm signUpRequest) {

		return  authService.registerUser(signUpRequest);
	}
	@GetMapping("/confirm-account")
	public String confirmToken(String email) {
			return authService.confirmToken(email);
	}
	@GetMapping("/findConf/{email}")
	public Optional<ConfirmationEmail> findConfirmation(@PathVariable("email") String email) {
		return  confirmationService.findConfirmationByEmail(email);
	}

}


