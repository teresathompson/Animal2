package br.com.animal2.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "SEQ_FICHA", 
sequenceName = "SEQ_FICHA", initialValue = 1)

public class Ficha {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, 
	generator = "SEQ_FICHA")
	private long id;
	
	private String data;
	
	@ManyToOne(cascade={CascadeType.PERSIST, 
			CascadeType.MERGE, CascadeType.REMOVE})
	private Animal animal;
	
	@ManyToOne(cascade={CascadeType.PERSIST, 
			CascadeType.MERGE, CascadeType.REMOVE})
	private Proprietario proprietario;
	
	@Enumerated(EnumType.STRING)
	private TipoAtendimento tipo;
	
	private String descricao;
	
	private Integer batimentosCardiacos;
	
	private Integer respiracaoPorMin;
	
	private Float temperaturaRetal;
	
	@ManyToOne(cascade={CascadeType.PERSIST, 
			CascadeType.MERGE, CascadeType.REMOVE})
	private Vacina vacinas;
	
	private String vermifugo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public TipoAtendimento getTipo() {
		return tipo;
	}

	public void setTipo(TipoAtendimento tipo) {
		this.tipo = tipo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getBatimentosCardiacos() {
		return batimentosCardiacos;
	}

	public void setBatimentosCardiacos(Integer batimentosCardiacos) {
		this.batimentosCardiacos = batimentosCardiacos;
	}

	public Integer getRespiracaoPorMin() {
		return respiracaoPorMin;
	}

	public void setRespiracaoPorMin(Integer respiracaoPorMin) {
		this.respiracaoPorMin = respiracaoPorMin;
	}

	public Float getTemperaturaRetal() {
		return temperaturaRetal;
	}

	public void setTemperaturaRetal(Float temperaturaRetal) {
		this.temperaturaRetal = temperaturaRetal;
	}

	public Vacina getVacinas() {
		return vacinas;
	}

	public void setVacinas(Vacina vacinas) {
		this.vacinas = vacinas;
	}

	public String getVermifugo() {
		return vermifugo;
	}

	public void setVermifugo(String vermifugo) {
		this.vermifugo = vermifugo;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}
	
	

}
