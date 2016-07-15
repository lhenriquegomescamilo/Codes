package br.edu.mk.drogaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estado{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long primaryKey;
	
	@Column(length = 2, nullable = false)
	private String sigla;
	
	@Column(length = 50, nullable = false)
	private String nome;
	
	public Estado(){}
	
	public Estado(String sigla, String nome){
		this.setSigla(sigla);
		this.setNome(nome);
	}
	
	public Estado(Long id, String sigla, String nome){
		this.setPrimaryKey(id);
		this.setSigla(sigla);
		this.setNome(nome);
	}
	
	
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
	
	public Long getPrimaryKey() {
		return primaryKey;
	}
	
	public void setPrimaryKey(Long primaryKey) {
		this.primaryKey = primaryKey;
	}

	@Override
	public String toString() {
		return "Estado [sigla=" + sigla + ", nome=" + nome + "]";
	}
	
	
	
}
