package com.guiferrini.apizup.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guiferrini.apizup.domain.User;
import com.guiferrini.apizup.dto.UserDTO;
import com.guiferrini.apizup.services.UserServices;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	//injetando services
	@Autowired
	private UserServices service;
	
	@RequestMapping(method=RequestMethod.GET)
	//método que retorna uma lista de usuario
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll(); //busca no BD os usuarios, guarda na lista
		List<UserDTO> listDTO = list.stream().map(obj -> new UserDTO(obj)).collect(Collectors.toList()); // convertendo objeto da list para um DTO(UserDTO)
		return ResponseEntity.ok().body(listDTO); //retorna a lista na resposta da requisição	
	}
}
