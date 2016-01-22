package com.hrk.spring.data.service;

import java.util.List;

import com.hrk.spring.data.domain.User;

public interface UserService {
	public List<User> findAll();
	public void saveBook(User user);
	public User findOne(long id);
	public void delete(long id);
}
