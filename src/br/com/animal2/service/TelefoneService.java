package br.com.animal2.service;

import br.com.animal2.modelo.Telefone;
import common.service.EntityManagerUtil;

public class TelefoneService {

	public static Telefone inserir(Telefone t) {
		EntityManagerUtil.begin();
		EntityManagerUtil.getEM().persist(t);
		EntityManagerUtil.commit();
		return t;
	}
	
}
