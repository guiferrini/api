package com.guiferrini.apizup.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.guiferrini.apizup.domain.User;
import com.guiferrini.apizup.repository.UserRepository;

@Configuration //p Spring entender q isso é uma configuração
public class Instantiation implements CommandLineRunner { //carga inicial do BD

	// Injetando UserRepository p fazer operação com bd
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll(); // limpando a coleção
		
		User guilherme = new User(null, "Guilherme Zupper", "guiZupper@zup.com");
		User roger = new User(null, "Roger Federer", "rf@zup.com");
		User guga = new User(null, "Gustavo Kuerten", "guga@zup.com");

		userRepository.saveAll(Arrays.asList(guilherme, roger, guga)); //salvando os objetos na coleção User
	}
}
