package com.hrk.spring.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrk.spring.data.domain.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	@Override
	public void saveBook(User user) {
		userRepository.save(user);
		
	}
	@Override
	public User findOne(long id) {
		return userRepository.findOne(id);
	}
	@Override
	public void delete(long id) {
		userRepository.delete(id);
		
	}
	

}
