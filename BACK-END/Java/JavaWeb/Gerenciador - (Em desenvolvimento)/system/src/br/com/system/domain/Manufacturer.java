package br.com.system.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_fabricantes")
public class Manufacturer{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fab_codigo")
	private Long code;
	
	@Column(name = "fab_descricao", length = 50, nullable = false)
	private String description;

	
	//Builders
	public Manufacturer(){}
	
	public Manufacturer(String description){
		this.setDescription(description);
	}
	
	public Manufacturer(Long code, String description){
		this.setCode(code);
		this.setDescription(description);
	}
	
	//Getters and Setters
	public void setCode(Long code){
		this.code = code;
	}
	public Long getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Manufacturer [code = " + getCode() + ", description = " + getDescription() + "]";
	}

	
}
