package com.hrk.spring.data.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrk.spring.data.domain.User;
import com.hrk.spring.data.service.UserService;

@RestController
@RequestMapping(value = "/	")
public class UserController {
	@Autowired
	private UserService userService ;

	@RequestMapping(value = "/add/{userId}/{userName}/{password}/{email}")
	public User addUser(@PathVariable int id, @PathVariable String userName, @PathVariable String password,
			@PathVariable String email) {
		User user = new User();
		user.setUser_id(id);
		user.setUsername(userName);
		user.setPassword(password);
		user.setEmail(email);
		userService.saveBook(user);
		return user;
	}
	@RequestMapping(value = "/delete/{id}")
	public void deleteBook(@PathVariable int id) {
		User user = new User();
		user.setUser_id(id);
		userService.delete(id);
	}
	@RequestMapping(value = "/")
	public List<User> getBooks() {
		return userService.findAll();
	}
	@RequestMapping(value = "/{id}")
	public User getBook(@PathVariable int id) {
		User user = userService.findOne(id);
		return user;
	}
	
}
