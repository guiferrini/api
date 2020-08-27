package com.guiferrini.apizup.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.guiferrini.apizup.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> { //tipo da classe de dominio, tipo do id da classe

}
