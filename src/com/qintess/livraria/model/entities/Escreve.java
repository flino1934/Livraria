package com.qintess.livraria.model.entities;

import java.io.Serializable;

public class Escreve implements Serializable{

	private Livro livro;
	private Autor autor;

	public Escreve() {
		// TODO Auto-generated constructor stub
	}

	public Escreve(Livro livro, Autor autor) {

		this.livro = livro;
		this.autor = autor;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
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
		Escreve other = (Escreve) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		return true;
	}

	@Override
	public String toString() {
	
		return "Escreve [livro=" + livro + ", autor=" + autor + "]";
	
	}
	
	

}
