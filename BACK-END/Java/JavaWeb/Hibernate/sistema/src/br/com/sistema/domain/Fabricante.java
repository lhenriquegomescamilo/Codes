package br.com.sistema.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_fabricantes")
public class Fabricante {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fab_codigo")
	private Long codigo;
	
	@Column(name = "fab_descricao", length = 50, nullable = false)
	private String descricao;

	public Long getCodigo() {
		return codigo;
	}
	
	/*
	private void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	*/

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Fabricante [codigo = " + getCodigo() + ", descricao = " + getDescricao() + "]";
	}

	
}
