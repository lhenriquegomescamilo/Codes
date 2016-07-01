package br.com.sistema.domain;

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
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ven_codigo")
	private Long codigo;
	
	@Column(name = "ven_horario")
	@Temporal(TemporalType.TIMESTAMP)
	private Date horario;
	
	@Column(name = "ven_valor_total", precision = 7, scale = 2, nullable = false)
	private BigDecimal valor_total;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tbl_funcionario_fun_codigo", foreignKey = @ForeignKey(name = "fun_codigo"), nullable = false)
	private Funcionario funcionario;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public BigDecimal getValor_total() {
		return valor_total;
	}

	public void setValor_total(BigDecimal valor_total) {
		this.valor_total = valor_total;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	
}
