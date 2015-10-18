package br.com.animal2.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import br.com.animal2.modelo.Proprietario;
import br.com.animal2.modelo.Telefone;
import br.com.animal2.modelo.UF;
import common.service.EntityManagerUtil;

public class ProprietarioService {
	
	
	public static Proprietario inserir(Proprietario c) {
		EntityManagerUtil.begin();
		EntityManagerUtil.getEM().persist(c);
		EntityManagerUtil.commit();
		return c;
	}
	
	
	public static Proprietario buscarPorId(Long id) {
		return EntityManagerUtil.getEM().find(Proprietario.class, id);
	}
	
	public static List<Proprietario> buscarOrdenadoPorNome() {

		String jpql = "FROM " + Proprietario.class.getSimpleName()
				+ " ORDER BY nome DESC";

		TypedQuery<Proprietario> query = 
				EntityManagerUtil.getEM().createQuery(jpql,Proprietario.class);


		return query.getResultList(); 
	}


	public static List<Proprietario> listaProprietariosComDDDInformado(String DDD) {

		String jpql = "";
		jpql += "SELECT p FROM Proprietario";
		jpql += " INNER JOIN proprietario.telefones telefone";
		jpql += " WHERE telefone.DDD = :ddd";

		TypedQuery<Proprietario> query = EntityManagerUtil.getEM().createQuery(jpql, Proprietario.class);
		query.setParameter("ddd", DDD);

		return query.getResultList();

	}
	
	
	/**
	 * 
	 */
	public static void listarProprietarioDecrescente() {

		// Coletando lista de investimentos ordenados por valor (decrescente)
		List<Proprietario> listaProprietarios = new ArrayList<Proprietario>();

		listaProprietarios = ProprietarioService.buscarOrdenadoPorNome();

		for(Proprietario p : listaProprietarios) {
			System.out.println(p.getId());
			System.out.println(p.getNomeProp());
		}
	}

	public static List<Proprietario> buscarPorEstado(UF uf) {
		String jpql = "SELECT p FROM " + Proprietario.class.getSimpleName() + " p"
				+ " WHERE p.endereco.estado = :uf";

		TypedQuery<Proprietario> qry = EntityManagerUtil.getEM().createQuery(jpql, Proprietario.class);
		qry.setParameter("uf", uf);

		return qry.getResultList();
	}


}
