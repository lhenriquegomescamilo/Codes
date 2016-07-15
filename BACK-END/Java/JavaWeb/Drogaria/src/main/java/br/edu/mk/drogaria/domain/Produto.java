package br.edu.mk.drogaria.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Produto{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long primaryKey;
	
	@Column(length = 50)
	private String descricao;
	
	@Column(nullable = false)
	private Short quantidade;
	
	@Column(nullable = false, precision = 7, scale = 2)
	private BigDecimal preco;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Fabricante fabricante;

	public Produto(){}
	
	public Produto(String descricao, Short quantidade, BigDecimal preco, Fabricante fabricante){
		this.setDescricao(descricao);
		this.setQuantidade(quantidade);
		this.setPreco(preco);
		this.setFabricante(fabricante);
	}
	
	public Produto(Long id, String descricao, Short quantidade, BigDecimal preco, Fabricante fabricante){
		this.setPrimaryKey(id);
		this.setDescricao(descricao);
		this.setQuantidade(quantidade);
		this.setPreco(preco);
		this.setFabricante(fabricante);
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Short getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Short quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public Long getPrimaryKey() {
		return primaryKey;
	}
	
	public void setPrimaryKey(Long primaryKey) {
		this.primaryKey = primaryKey;
	}
	
	@Override
	public String toString() {
		return "Produto [descricao=" + descricao + ", quantidade=" + quantidade + ", preco=" + preco + ", fabricante="
				+ fabricante + "]";
	}
	
	
	
}
