package com.guiferrini.apizup.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="user") //p informar q User corresponde uma coleção no MongoDB
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//atributos basicos
	@Id //p MongoDB
	private String id;
	private String name;
	private String email;
	
	//Referenciando Files p User - List (interface), ArrayList(implementação possível dessa List). lazy =so carrega os 'Files' se eu explicitamente acessar, se n, só User é carregado (n tem carregamento/fluxo desnecessário)
	@DBRef(lazy=true)
	private List<File> files = new ArrayList<>();	
	
	//Construtores
	public User() {
	}

	//Contrutor q recebe atributos como parametro
	public User(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<File> getFiles() {
		return files;
	}
	
	public void setFiles(List<File> files) {
		this.files = files;
	}
	
	//hashCode e Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
