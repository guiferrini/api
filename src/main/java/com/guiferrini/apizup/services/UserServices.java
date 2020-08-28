package com.guiferrini.apizup.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guiferrini.apizup.domain.User;
import com.guiferrini.apizup.dto.UserDTO;
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
	
	//Criando User
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	//Apagando USer
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	//é um DTO q instancia um USER, o inverso da class DTO
	//p instanciar um User eu posso querer acessar o BD, por isso criado aqui, já tem dep do BD - manutanção no futuro acessando dados
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail()); 
	}
	
}
