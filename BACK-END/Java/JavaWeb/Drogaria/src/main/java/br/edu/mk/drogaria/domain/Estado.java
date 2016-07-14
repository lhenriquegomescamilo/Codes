package br.edu.mk.drogaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Estado extends PrimaryKeyGeneric{
	
	@Column(length = 2, nullable = false)
	private String sigla;
	
	@Column(length = 50, nullable = false)
	private String nome;
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getSigla() {
		return sigla;
	}
	
}
