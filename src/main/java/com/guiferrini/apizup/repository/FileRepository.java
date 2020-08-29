package com.guiferrini.apizup.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.guiferrini.apizup.domain.File;

@Repository
public interface FileRepository extends MongoRepository<File, String> { //tipo da classe de dominio, tipo do id da classe

}
