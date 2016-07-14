package br.edu.mk.drogaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Fabricante extends PrimaryKeyGeneric{
	
	@Column(length = 50, nullable = false)
	private String descricao;
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}	
	
}
