package com.qintess.livraria.model.entities;

import java.io.Serializable;
import java.util.Date;

public class Venda implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer idVenda;
	private Date data;
	private Float total;

	private Cliente cliente;
	
	public Venda() {
		// TODO Auto-generated constructor stub
	}

	public Venda(Integer idVenda, Date data, Float total, Cliente cliente) {

		this.idVenda = idVenda;
		this.data = data;
		this.total = total;
		this.cliente = cliente;
	}

	public Integer getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Integer idVenda) {
		this.idVenda = idVenda;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
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
		Venda other = (Venda) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Venda [idVenda=" + idVenda + ", data=" + data + ", total=" + total + ", cliente=" + cliente + "]";
	}

}
