package com.tayadetech;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tayadetech.models.User;
import com.tayadetech.repository.UserRepository;

@RestController
public class HomeResource {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/")
	public String home()
	{
		return ("<h2>Welcome..</h2>");
	}
	
	@GetMapping("/user")
	public String user()
	{
		return ("<h2>Welcome User..</h2>");
	}
	
	@GetMapping("/admin")
	public String admin()
	{
		return ("<h2>Welcome Admin..</h2>");
	}
	
}
