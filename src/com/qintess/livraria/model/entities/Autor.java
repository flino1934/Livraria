package com.qintess.livraria.model.entities;

import java.io.Serializable;

public class Autor implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idAutor;
	private String nome;
	private String email;

	public Autor() {
		// TODO Auto-generated constructor stub
	}

	public Autor(Integer idAutor, String nome, String email) {

		this.idAutor = idAutor;
		this.nome = nome;
		this.email = email;
	}

	public Integer getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Integer idAutor) {
		this.idAutor = idAutor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Autor other = (Autor) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
