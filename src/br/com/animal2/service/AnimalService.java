package br.com.animal2.service;


import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.animal2.modelo.Animal;


import common.service.EntityManagerUtil;

public class AnimalService {

	public static Animal inserir(Animal a) {
		EntityManagerUtil.begin();
		EntityManagerUtil.getEM().persist(a);
		EntityManagerUtil.commit();
		return a;
	}
	
	public static List<Animal> buscarid (long id){
		
		String jpql = "FROM " + Animal.class.getSimpleName() + " ORDER BY id DESC";
	TypedQuery<Animal> query = EntityManagerUtil.getEM().createQuery(jpql, Animal.class);
	
	return query.getResultList();
	}
	
	public static List<Animal> buscarOrdenadoPorNome() {

		String jpql = "FROM " + Animal.class.getSimpleName()
				+ " ORDER BY nome DESC";

		TypedQuery<Animal> query = 
				EntityManagerUtil.getEM().createQuery(jpql,Animal.class);


		return query.getResultList(); 
	}

	
	public static List<Object[]> 
	listaApenasUmAtributoDeAnimal(String nome) {

		String jpql;
		jpql = "SELECT a FROM "
				+ " Animal a WHERE a.nome = :nome";

		Query query = EntityManagerUtil.getEM().createQuery(jpql);
		query.setParameter("nome",nome);

		List<Object[]> lista = query.getResultList();

		return lista;
	}
	
}
