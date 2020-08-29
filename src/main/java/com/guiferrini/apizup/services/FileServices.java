package com.guiferrini.apizup.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guiferrini.apizup.domain.File;
import com.guiferrini.apizup.repository.FileRepository;
import com.guiferrini.apizup.services.exception.ObjectNotFoundException;

@Service
public class FileServices {
	
	//instanciando FileRepository, Spring faz a injeção de dependencia
	@Autowired
	private FileRepository repo;
	
	//buscar File por ID
	public File findById(String id) {
		Optional<File> obj = repo.findById(id); //se n encontra File retorna vazio(null), entao: msg 'n encontrado'
		return obj.orElseThrow(() -> new ObjectNotFoundException("Arquivo não encontrado"));
	}	
	
	//busca File por Title
	public List<File> findByTitle(String text) {
		return repo.findByTitleContainingIgnoreCase(text);
	}
}
