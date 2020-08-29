package com.guiferrini.apizup.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.guiferrini.apizup.domain.File;
import com.guiferrini.apizup.domain.User;
import com.guiferrini.apizup.dto.AuthorDTO;
import com.guiferrini.apizup.repository.FileRepository;
import com.guiferrini.apizup.repository.UserRepository;

@Configuration //p Spring entender q isso é uma configuração
public class Instantiation implements CommandLineRunner { //carga inicial do BD

	// Injetando UserRepository p fazer operação com bd
	@Autowired
	private UserRepository userRepository;
	
	// Injetando FileRepository p fazer operação com bd
	@Autowired
	private FileRepository fileRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		//date - configuração padrao
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll(); // limpando a coleção User
		fileRepository.deleteAll(); // limpando a coleção File
		
		User guilherme = new User(null, "Guilherme Zupper", "guiZupper@zup.com");
		User zup = new User(null, "Zup Innovation", "zup@zup.com");
		User guga = new User(null, "Gustavo Kuerten", "guga@zup.com");
		
		userRepository.saveAll(Arrays.asList(guilherme, zup, guga)); //salvando os objetos na coleção User
		
		// instanciando o arquivo já com autor
		File file1 = new File(
				null, 
				sdf.parse("28/08/2020"), 
				"Zup Bootcamp", 
				"Inscrições abertas. Venha fazer parte...", 
				new AuthorDTO(zup)
				);
		File file2 = new File(
				null, 
				sdf.parse("28/08/2020"), 
				"Guilherme Ferrini CV", 
				"Detalhes do meu CV, formação, Estudos e aprendizados...", 
				new AuthorDTO(guilherme)
				);

		fileRepository.saveAll(Arrays.asList(file1, file2)); //salvando os objetos na coleção File
		
		zup.getFiles().addAll(Arrays.asList(file1)); //Adicionando User a seus Files
		userRepository.save(zup); //salvando com a referencia
		
		guilherme.getFiles().addAll(Arrays.asList(file2));
		userRepository.save(guilherme);
	}
}
