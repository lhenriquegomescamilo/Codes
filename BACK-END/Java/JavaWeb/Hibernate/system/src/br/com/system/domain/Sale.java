package br.com.system.domain;

import java.math.BigDecimal;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_vendas")
public class Sale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ven_codigo")
	private Long code;
	
	@Column(name = "ven_horario")
	@Temporal(TemporalType.TIMESTAMP)
	private Date schedule;
	
	@Column(name = "ven_valor_total", precision = 7, scale = 2, nullable = false)
	private BigDecimal value;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_funcionario_fun_codigo", foreignKey = @ForeignKey(name = "fun_codigo"), nullable = false)
	private Employee employee;

	//Builders
	public Sale(){}
	
	public Sale(Date schedule, BigDecimal value, Employee employee){
		this.setSchedule(schedule);
		this.setValue(value);
		this.setEmployee(employee);
	}
	
	public Sale(Long code, Date schedule, BigDecimal value, Employee employee){
		this.setCode(code);
		this.setSchedule(schedule);
		this.setValue(value);
		this.setEmployee(employee);
	}
	
	//Getters and Setters
	
	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}
	
	public Date getSchedule() {
		return schedule;
	}

	public void setSchedule(Date schedule) {
		this.schedule = schedule;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Sale [Code = " + getCode() 
				+ ", Schedule = " + getSchedule() 
				+ ", Value = " + getValue() 
				+ ", Employee = "+ getEmployee() + "]";
	}
	
	
}
