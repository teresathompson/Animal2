package br.com.animal2.service;

import br.com.animal2.modelo.Vacina;

import common.service.EntityManagerUtil;

public class VacinaService {
	
	public static Vacina inserir(Vacina v) {
		EntityManagerUtil.begin();
		EntityManagerUtil.getEM().persist(v);
		EntityManagerUtil.commit();
		return v;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public static Vacina buscarPorId(Long id) {
		return EntityManagerUtil.getEM().find(Vacina.class, id);
	}

}
