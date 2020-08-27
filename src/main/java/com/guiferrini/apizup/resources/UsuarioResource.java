package com.guiferrini.apizup.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guiferrini.apizup.domain.Usuario;

@RestController
@RequestMapping(value="/users")
public class UsuarioResource {
	
	@RequestMapping(method=RequestMethod.GET)
	//método que retorna uma lista de usuario
	public ResponseEntity<List<Usuario>> findAll() {
		Usuario guilherme = new Usuario("1", "Guilherme Zupper", "guiZupper@zup.com");
		Usuario joao = new Usuario("2", "Joao Segundo", "joaoSegundo@zup.com");
		List<Usuario> list = new ArrayList<>();
		list.addAll(Arrays.asList(guilherme, joao));
		return ResponseEntity.ok().body(list);
	}
}
