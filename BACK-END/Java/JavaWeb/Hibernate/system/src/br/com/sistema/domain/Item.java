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
@Table(name = "tbl_itens")
public class Item {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ite_codigo")
	private Long codigo;
	
	@Column(name = "ite_quantidade", nullable = false)
	private Integer quantidade;
	
	@Column(name = "ite_valor_parcial", precision = 7, scale = 2, nullable = false)
	private BigDecimal valor_parcial;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_vendas_ven_codigo", foreignKey = @ForeignKey(name = "ven_codigo"), nullable = false)
	private Venda venda;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_produtos_pro_codigo", foreignKey = @ForeignKey(name = "pro_codigo"), nullable = false)
	private Produto produto;

	public Long getCodigo() {
		return codigo;
	}
	
	/*
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	*/

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValor_parcial() {
		return valor_parcial;
	}

	public void setValor_parcial(BigDecimal valor_parcial) {
		this.valor_parcial = valor_parcial;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "Item [codigo =" + getCodigo() 
				+ ", quantidade = " + getQuantidade() 
				+ ", valor_parcial = " + getValor_parcial()
				+ ", venda = "+ getVenda() 
				+ ", produto = " + getProduto() + "]";
	}
	
	
}
