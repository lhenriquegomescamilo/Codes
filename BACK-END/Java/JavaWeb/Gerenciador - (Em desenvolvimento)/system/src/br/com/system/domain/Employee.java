package br.com.system.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_funcionarios")
public class Employee {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fun_codigo")
	private Long code;
	
	@Column(name = "fun_nome", length = 50, nullable = false)
	private String name;
	
	@Column(name = "fun_cpf", length = 14, nullable = false, unique = true)
	private String cpf;
	
	@Column(name = "fun_senha", length = 32, nullable = false)
	private String password;
	
	@Column(name = "fun_funcao", length = 50, nullable = false)
	private String function;

	
	//Builders
	public Employee(){}
	
	public Employee(String name, String cpf, String password, String function){
		this.setCpf(cpf);
		this.setFunction(function);
		this.setName(name);
		this.setPassword(password);
	}
	
	
	//Getters and Setters
	public Long getCode() {
		return code;
	}
	
	
	public void setCode(Long code) {
		this.code = code;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	@Override
	public String toString() {
		return "Employee [code = " + getCode() + ", "
				+ "name = " + getName() 
				+ ", CPF = " + getCpf() 
				+ ", password = " + getPassword() 
				+ ", function =" + getFunction() + "]";
	}
	
	
}
