package br.com.animal2.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;


@Entity
@SequenceGenerator(name = "SEQ_PROPRIETARIO", 
sequenceName = "SEQ_PROPRIETARIO", initialValue = 1)
public class Proprietario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, 
	generator = "SEQ_PROPRIETARIO")
	private Long id;
	
	private String nomeProp;
	
	@OneToOne (cascade={CascadeType.PERSIST, 
			CascadeType.MERGE, CascadeType.REMOVE})
	private Endereco endereco;
	
	@OneToMany(mappedBy="proprietario", fetch=FetchType.LAZY, cascade={CascadeType.PERSIST, 
			CascadeType.MERGE, CascadeType.REMOVE})
	
	private List<Animal> animais;
	
	@OneToMany(cascade={CascadeType.PERSIST, 
			CascadeType.MERGE, CascadeType.REMOVE})
	
	private List<Telefone> telefones;
	
	@ManyToMany(cascade={CascadeType.PERSIST, 
			CascadeType.MERGE, CascadeType.REMOVE},
			fetch=FetchType.EAGER)
	@JoinColumn(name="pacoteservicos_id")
	private List<PacoteServicos> pacoteServicos;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeProp() {
		return nomeProp;
	}
	public void setNomeProp(String nomeProp) {
		this.nomeProp = nomeProp;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public List<Animal> getAnimais() {
		return animais;
	}
	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	public List<PacoteServicos> getPacoteServicos() {
		return pacoteServicos;
	}
	public void setPacoteServicos(List<PacoteServicos> pacoteServicos) {
		this.pacoteServicos = pacoteServicos;
	}
	
	
	
	
}
