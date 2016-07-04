package br.com.system.domain;

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
	private Long code;
	
	@Column(name = "ite_quantidade", nullable = false)
	private Integer amount;
	
	@Column(name = "ite_valor_parcial", precision = 7, scale = 2, nullable = false)
	private BigDecimal value;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_vendas_ven_codigo", foreignKey = @ForeignKey(name = "ven_codigo"), nullable = false)
	private Sale sale;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_produtos_pro_codigo", foreignKey = @ForeignKey(name = "pro_codigo"), nullable = false)
	private Product product;

	
	//Builders
	public Item(){}
	
	public Item(Integer amount, BigDecimal value, Sale sale, Product product){
		this.setAmount(amount);
		this.setValue(value);
		this.setSale(sale);
		this.setProduct(product);
	}
	
	public Item(Long code, Integer amount, BigDecimal value, Sale sale, Product product){
		this.setCode(code);
		this.setAmount(amount);
		this.setValue(value);
		this.setSale(sale);
		this.setProduct(product);
	}
	
	
	//Getters and Setters
	
	public Long getCode() {
		return code;
	}
	
	public void setCode(Long code) {
		this.code = code;
	}
	

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Item [code =" + getCode() 
				+ ", Amount = " + getAmount() 
				+ ", Value = " + getValue()
				+ ", Sale = "+ getSale() 
				+ ", Product = " + getProduct() + "]";
	}	
}
