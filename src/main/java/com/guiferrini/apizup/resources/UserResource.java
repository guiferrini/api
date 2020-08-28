package com.guiferrini.apizup.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.guiferrini.apizup.domain.User;
import com.guiferrini.apizup.dto.UserDTO;
import com.guiferrini.apizup.services.UserServices;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	//injetando services
	@Autowired
	private UserServices service;
	
	//método que retorna uma lista de usuario
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll(); //busca no BD os usuarios, guarda na lista
		List<UserDTO> listDTO = list.stream().map(obj -> new UserDTO(obj)).collect(Collectors.toList()); // convertendo objeto da list para um DTO(UserDTO)
		return ResponseEntity.ok().body(listDTO); //retorna a lista na resposta da requisição	
	}
	
	//método p retornar User por ID
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<UserDTO> findByID(@PathVariable String id) { //variavél id como parametro
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj)); //retorna objeto convertido p UserDTO	
	}
	
	//método p criar User
	@RequestMapping(method=RequestMethod.POST) //=@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO) {
		User obj = service.fromDTO(objDTO); //convertendo DTO p User
		obj = service.insert(obj); //inserido no BD
		//retorna resposta vazia, porem no baceçalho tem URL do recurso criado
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//método p apagar User por ID
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<UserDTO> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build(); //retorna cod 204 - success	
	}
	
	//método p atualizar User
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody UserDTO objDTO, @PathVariable String id) {
		User obj = service.fromDTO(objDTO); //convertendo DTO p User
		obj.setId(id); //garantir q meu obj vai ter ID da requisição
		obj = service.update(obj); // faz atualização
	    return ResponseEntity.noContent().build(); //retorna cod 204
	}
		
}
