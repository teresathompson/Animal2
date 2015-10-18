package br.com.animal2.service;



import br.com.animal2.modelo.Ficha;
import common.service.EntityManagerUtil;

public class FichaService {

	public static Ficha inserir(Ficha f) {
		EntityManagerUtil.begin();
		EntityManagerUtil.getEM().persist(f);
		EntityManagerUtil.commit();
		return f;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public static Ficha buscarPorId(Long id) {
		return EntityManagerUtil.getEM().find(Ficha.class, id);
	}
}
