package com.guiferrini.apizup.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.guiferrini.apizup.domain.File;

@Repository
public interface FileRepository extends MongoRepository<File, String> { //tipo da classe de dominio, tipo do id da classe

	//método de busca personalizado pelo campo title, expressão regular sera o paramatro(text), i-sensitiveCase
	@Query("{ 'title': { $regex: ?0, $options: 'i'} }")
	List<File> searchtitle(String text);
	
	//incluindo médoto de busca por title em File - query methods
	List<File> findByTitleContainingIgnoreCase(String text);	
}
