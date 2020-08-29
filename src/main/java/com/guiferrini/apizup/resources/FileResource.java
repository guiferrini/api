package com.guiferrini.apizup.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.guiferrini.apizup.domain.File;
import com.guiferrini.apizup.services.FileServices;

@RestController
@RequestMapping(value="/files")
public class FileResource {
	
	//injetando services
	@Autowired
	private FileServices service;

	//método p retornar Files por ID
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<File> findByID(@PathVariable String id) { //variavél id como parametro
		File obj = service.findById(id);
		return ResponseEntity.ok().body(obj); //retorna objeto convertido p UserDTO	
	}		
}
