package br.com.animal2.service;

import br.com.animal2.modelo.PacoteServicos;
import common.service.EntityManagerUtil;

public class PacoteServicoService {
	
	public static PacoteServicos inserir(PacoteServicos p) {
		EntityManagerUtil.begin();
		EntityManagerUtil.getEM().persist(p);
		EntityManagerUtil.commit();
		return p;
	}

}
