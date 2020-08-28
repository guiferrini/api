package com.guiferrini.apizup.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guiferrini.apizup.domain.User;
import com.guiferrini.apizup.repository.UserRepository;
import com.guiferrini.apizup.services.exception.ObjectNotFoundException;

@Service
public class UserServices {
	
	//instanciando UserRepository, Spring faz a injeção de dependencia
	@Autowired
	private UserRepository repo;
	
	//busca tds Users
	public List<User> findAll() {
		return repo.findAll();
	}
	
	//buscar User por ID
	public User findById(String id) {
		Optional<User> obj = repo.findById(id); //se n encontra User retorna vazio(null), entao: msg 'n encontrado'
		return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
	}
}
