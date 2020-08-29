package com.guiferrini.apizup.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.guiferrini.apizup.domain.File;

@Repository
public interface FileRepository extends MongoRepository<File, String> { //tipo da classe de dominio, tipo do id da classe

	//incluindo médoto de busca por title em File
	List<File> findByTitleContainingIgnoreCase(String text);
}
