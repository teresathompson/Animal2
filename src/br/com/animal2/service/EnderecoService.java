package br.com.animal2.service;

import br.com.animal2.modelo.Endereco;
import common.service.EntityManagerUtil;

public class EnderecoService {

	public static Endereco inserir(Endereco e) {
		EntityManagerUtil.begin();
		EntityManagerUtil.getEM().persist(e);
		EntityManagerUtil.commit();
		return e;
	}
	
}
