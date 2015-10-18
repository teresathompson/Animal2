package br.com.animal2.modelo;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


@Entity
@SequenceGenerator(name = "SEQ_ANIMAL", 
				sequenceName = "SEQ_ANIMAL", initialValue = 1)
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, 
					generator = "SEQ_ANIMAL")

	private long id;
	
	private String nome;
	
	private String raca;
	private String corPelagem;
	private float peso;
	
	@ManyToOne
	private Proprietario proprietario;
	
	@OneToMany(mappedBy="animal", cascade={CascadeType.PERSIST, 
			CascadeType.MERGE, CascadeType.REMOVE})
	
	private List<Ficha> fichas;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	public String getCorPelagem() {
		return corPelagem;
	}
	public void setCorPelagem(String corPelagem) {
		this.corPelagem = corPelagem;
	}
	public Proprietario getProprietario() {
		return proprietario;
	}
	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}
	public List<Ficha> getFichas() {
		return fichas;
	}
	public void setFichas(List<Ficha> fichas) {
		this.fichas = fichas;
	}
	
	
}
	
	

	
