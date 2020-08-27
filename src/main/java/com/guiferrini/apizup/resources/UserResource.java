package com.guiferrini.apizup.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guiferrini.apizup.domain.User;
import com.guiferrini.apizup.services.UserServices;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	//injetando services
	@Autowired
	private UserServices service;
	
	@RequestMapping(method=RequestMethod.GET)
	//método que retorna uma lista de usuario
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll(); //busca no BD os usuarios, guarda na lista
		return ResponseEntity.ok().body(list); //retorna a lista na resposta da requisição	
	}
}
