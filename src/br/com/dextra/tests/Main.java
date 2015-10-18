package br.com.dextra.tests;

import java.util.ArrayList;
import java.util.List;

import br.com.animal2.modelo.Animal;
import br.com.animal2.modelo.Endereco;
import br.com.animal2.modelo.Ficha;
import br.com.animal2.modelo.PacoteServicos;
import br.com.animal2.modelo.Proprietario;
import br.com.animal2.modelo.Telefone;
import br.com.animal2.modelo.TipoAtendimento;
import br.com.animal2.modelo.UF;
import br.com.animal2.modelo.Vacina;
import br.com.animal2.service.AnimalService;
import br.com.animal2.service.EnderecoService;
import br.com.animal2.service.FichaService;
import br.com.animal2.service.PacoteServicoService;
import br.com.animal2.service.ProprietarioService;
import br.com.animal2.service.TelefoneService;
import br.com.animal2.service.VacinaService;

public class Main {

	public static void main(String[] args) {

		Endereco enderecoJames = new Endereco();

		enderecoJames.setCidade("Campinas");
		enderecoJames.setEstado(UF.SP);
		enderecoJames.setLogradouro("Rua 10, 342");

		Endereco enderecoAna = new Endereco();

		enderecoAna.setCidade("Saquarema");
		enderecoAna.setEstado(UF.RJ);
		enderecoAna.setLogradouro("Rua da Praia, 223");

		Telefone telefoneJames1 = new Telefone();
		telefoneJames1.setDDD("019");
		telefoneJames1.setTelefone("98998-2873");

		Telefone telefoneAna1 = new Telefone();
		telefoneAna1.setDDD("019");
		telefoneAna1.setTelefone("98998-2873");

		Telefone telefoneAna2 = new Telefone();
		telefoneAna2.setDDD("019");
		telefoneAna2.setTelefone("98998-2873");

		List<Telefone> telefonesJames = new ArrayList<Telefone>();
		telefonesJames.add(telefoneJames1);

		List<Telefone> telefonesAna = new ArrayList<Telefone>();
		telefonesAna.add(telefoneAna1);
		telefonesAna.add(telefoneAna2);

		Proprietario james = new Proprietario();

		james.setNomeProp("James Orland");

		Animal fifi = new Animal();
		Animal bob = new Animal();
		Animal stitch = new Animal();
		Animal sushi = new Animal();

		fifi.setCorPelagem("branca");
		fifi.setNome("Fifi");
		fifi.setPeso(10.6F);
		fifi.setProprietario(james);

		bob.setNome("Bob");
		bob.setProprietario(james);
		bob.setRaca("Boxer");

		stitch.setNome("Stitch");
		stitch.setProprietario(james);

		sushi.setNome("Sushi");
		sushi.setProprietario(james);

		List<Animal> animaisJames = new ArrayList<Animal>();

		animaisJames.add(fifi);
		animaisJames.add(bob);
		animaisJames.add(stitch);
		animaisJames.add(sushi);

		Vacina v8 = new Vacina();
		v8.setNome("Recombitek");
		v8.setCodBarras("00904854958");
		v8.setDataFabricacao("2015-05-01");
		v8.setTipoVacina("v8");
		v8.setFabricante("Merial");

		Ficha fifiFicha = new Ficha();
		fifiFicha.setBatimentosCardiacos(130);
		fifiFicha.setRespiracaoPorMin(20);
		fifiFicha.setProprietario(james);
		fifiFicha.setTemperaturaRetal(38.5F);
		fifiFicha
				.setDescricao("Animal apresenta tártaro e precisa fazer cirurgia para remoção e tratamento de gengivite");
		fifiFicha.setTipo(TipoAtendimento.EMERGÊNCIA);

		PacoteServicos fifiServ = new PacoteServicos();
		fifiServ.setNome("Banho e Tosa");
		fifiServ.setValor(100.50);

		EnderecoService.inserir(enderecoJames);
		EnderecoService.inserir(enderecoAna);
		TelefoneService.inserir(telefoneJames1);
		TelefoneService.inserir(telefoneAna1);
		TelefoneService.inserir(telefoneAna2);
		ProprietarioService.inserir(james);
		AnimalService.inserir(sushi);
		AnimalService.inserir(fifi);
		AnimalService.inserir(stitch);
		AnimalService.inserir(bob);
		VacinaService.inserir(v8);
		FichaService.inserir(fifiFicha);
		PacoteServicoService.inserir(fifiServ);

	}
	
	
	public static void buscaAnimaisPorId(long id){
		
		System.out.println("Id" + id + "-----------------------------------");
		List animaisId = AnimalService.buscarid(id);
		
		for (Object idAnimal : animaisId){
			Animal a = (Animal) idAnimal;
			System.out.println(a.getId());
		}
		
	}

	public static void listaNomesAnimais(String nome) {

		System.out.println("Lista animais com o nome" + nome
				+ "------------------------------");

		List nomesAnimais = AnimalService.listaApenasUmAtributoDeAnimal(nome);

		for (Object nomes : nomesAnimais) {
			Animal a = (Animal) nomes;
			System.out.println(a.getNome());
		}
	}

	public static void listaProprietariosPorDDD(String DDD) {

		List<Proprietario> listaProprietarioPorDDD = new ArrayList<Proprietario>();
		listaProprietarioPorDDD = ProprietarioService
				.listaProprietariosComDDDInformado(DDD);

		System.out.println("----- Listando Pessoas com telefones do DDD: "
				+ DDD);
		for (Proprietario p : listaProprietarioPorDDD) {
			System.out.println(p.getNomeProp());
			for (Telefone fones : p.getTelefones()) {
				System.out.println(fones.getDDD());
				System.out.println(fones.getTelefone());
			}
		}

	}
}
