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
public class ItemVenda{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long primaryKey;
	
	@Column(nullable = false)
	private Short quantidade;
	
	@Column(precision = 8, scale = 2, nullable = false)
	private BigDecimal valorParcial;
	
	@ManyToOne
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Funcionario funcionario;

	public Short getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Short quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorParcial() {
		return valorParcial;
	}

	public void setValorParcial(BigDecimal valorParcial) {
		this.valorParcial = valorParcial;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public Long getPrimaryKey() {
		return primaryKey;
	}
	
	public void setPrimaryKey(Long primaryKey) {
		this.primaryKey = primaryKey;
	}

	@Override
	public String toString() {
		return "ItemVenda [primaryKey=" + primaryKey + ", quantidade=" + quantidade + ", valorParcial=" + valorParcial
				+ ", produto=" + produto + ", funcionario=" + funcionario + "]";
	}

}
