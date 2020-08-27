package com.guiferrini.apizup.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guiferrini.apizup.domain.User;
import com.guiferrini.apizup.repository.UserRepository;

@Service
public class UserServices {
	
	//instanciando UserRepository, Spring faz a injeção de dependencia
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
}
