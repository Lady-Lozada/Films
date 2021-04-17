package co.edu.iudigital.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.iudigital.app.model.entity.User;
import co.edu.iudigital.app.service.iface.UserService;


@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	public User login(@RequestBody User user) throws Exception{
		return userService.login(user);
	}
	
	@PostMapping("/createUser")
	public ResponseEntity<Object> createUser(@RequestBody User user) {		
		return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
	}
}
