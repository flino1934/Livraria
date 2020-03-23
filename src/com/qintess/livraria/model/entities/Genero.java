package com.qintess.livraria.model.entities;

import java.io.Serializable;

public class Genero implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idGenero;
	private String descricao;

	public Genero() {
		// TODO Auto-generated constructor stub
	}

	public Genero(Integer idGenero, String descricao) {

		this.idGenero = idGenero;
		this.descricao = descricao;
	}

	public Integer getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(Integer idGenero) {
		this.idGenero = idGenero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idGenero == null) ? 0 : idGenero.hashCode());
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
		Genero other = (Genero) obj;
		if (idGenero == null) {
			if (other.idGenero != null)
				return false;
		} else if (!idGenero.equals(other.idGenero))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Genero [idGenero=" + idGenero + ", descricao=" + descricao + "]";
	}

}
