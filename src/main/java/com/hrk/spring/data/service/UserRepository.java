package com.hrk.spring.data.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrk.spring.data.domain.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
