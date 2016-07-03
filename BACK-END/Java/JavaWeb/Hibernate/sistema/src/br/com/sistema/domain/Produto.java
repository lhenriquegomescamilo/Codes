package br.com.sistema.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_produtos")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pro_codigo")
	private Long codigo;
	
	@Column(name = "pro_descricao", length = 50)
	private String descricao;
	
	@Column(name = "pro_preco", precision = 7, scale = 2, nullable = false)
	private BigDecimal preco;
	
	@Column(name = "pro_quantidade", nullable = false)
	private Integer quantidade;	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_fabricantes_fab_codigo", foreignKey = @ForeignKey(name = "fab_codigo"), nullable = false)
	private Manufacturer fabricante;

	public Long getCodigo() {
		return codigo;
	}
	
	/*
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	*/

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Manufacturer getFabricante() {
		return fabricante;
	}

	public void setFabricante(Manufacturer fabricante) {
		this.fabricante = fabricante;
	}

	@Override
	public String toString() {
		return "Produto [codigo = " + getCodigo() 
				+ ", descricao = " + getDescricao() 
				+ ", preco = " + getPreco() 
				+ ", quantidade = " + getQuantidade()
				+ ", fabricante = " + getFabricante() + "]";
	}
	
	
}
