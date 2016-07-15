package br.edu.mk.drogaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fabricante{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long primaryKey;
	
	@Column(length = 50, nullable = false)
	private String descricao;
	
	public Fabricante(){}
	
	public Fabricante(String descricao){
		this.descricao = descricao;
	}
	
	public Fabricante(Long id, String descricao){
		this.descricao = descricao;
		this.setPrimaryKey(id);
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public Long getPrimaryKey() {
		return primaryKey;
	}
	
	public void setPrimaryKey(Long primaryKey) {
		this.primaryKey = primaryKey;
	}

	@Override
	public String toString() {
		return "Fabricante [descricao=" + descricao + "]";
	}	
	
}
