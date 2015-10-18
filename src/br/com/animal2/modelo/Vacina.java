package br.com.animal2.modelo;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "SEQ_VACINA", 
		sequenceName = "SEQ_VACINA", initialValue = 1)

public class Vacina {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, 
	generator = "SEQ_VACINA")
	private Long ID;
	
	@Column
	private String nome;
	@Column
	private String fabricante;
	@Column
	private String dataFabricacao;
	@Column
	private String tipoVacina;
	@Column
	private String codBarras;
	
	public Long getID() {
		return ID;
	}
	public void setID(Long iD) {
		ID = iD;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getDataFabricacao() {
		return dataFabricacao;
	}
	public void setDataFabricacao(String dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}
	public String getCodBarras() {
		return codBarras;
	}
	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}
	public String getTipoVacina() {
		return tipoVacina;
	}
	public void setTipoVacina(String tipoVacina) {
		this.tipoVacina = tipoVacina;
	}
	
	

}

