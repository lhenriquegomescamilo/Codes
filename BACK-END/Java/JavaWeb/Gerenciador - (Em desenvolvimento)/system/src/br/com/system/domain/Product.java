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
@Table(name = "tbl_produtos")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pro_codigo")
	private Long code;
	
	@Column(name = "pro_descricao", length = 50)
	private String description;
	
	@Column(name = "pro_preco", precision = 7, scale = 2, nullable = false)
	private BigDecimal price;
	
	@Column(name = "pro_quantidade", nullable = false)
	private Integer amount;	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_fabricantes_fab_codigo", foreignKey = @ForeignKey(name = "fab_codigo"), nullable = false)
	private Manufacturer manufacturer;

	
	//Builders
	public Product(){}
	
	public Product(String description, BigDecimal price, Integer amount, Manufacturer manufacturer){
		this.setDescription(description);
		this.setPrice(price);
		this.setAmount(amount);
		this.setManufacturer(manufacturer);
	}
	
	public Product(Long code, String description, BigDecimal price, Integer amount, Manufacturer manufacturer){
		this.setCode(code);
		this.setDescription(description);
		this.setPrice(price);
		this.setAmount(amount);
		this.setManufacturer(manufacturer);
	}
	
	
	//Getters and Setters
	
	public Long getCode() {
		return code;
	}
	
	
	public void setCode(Long code) {
		this.code = code;
	}
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Override
	public String toString() {
		return "Product [Code = " + getCode() 
				+ ", Description = " + getDescription() 
				+ ", Price = " + getPrice() 
				+ ", Amount = " + getAmount()
				+ ", Manufacturer = " + getManufacturer() + "]";
	}
	
	
}
