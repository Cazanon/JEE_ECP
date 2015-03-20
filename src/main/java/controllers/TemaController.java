package controllers;

import java.util.ArrayList;
import java.util.List;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.jpa.DaoJpaFactory;
import persistence.models.entities.Tema;
import views.beans.TemaBean;

public class TemaController {

	public static List<TemaBean> getTemas() {
    	DaoFactory.setFactory(new DaoJpaFactory());
    	List<Tema> listaTemas = DaoJpaFactory.getFactory().getTemaDao().findAll();
    	List<TemaBean> listaTemasBean = new ArrayList<TemaBean>();
    	for(Tema tema : listaTemas){
    		listaTemasBean.add(temaEntityToBean(tema));
    	}
    	return listaTemasBean;
	}
	
	private static TemaBean temaEntityToBean(Tema tema){		
		return null;
	}

}
