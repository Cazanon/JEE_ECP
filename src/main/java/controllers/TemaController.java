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

	public static void addTema(TemaBean tema) {
    	DaoFactory.setFactory(new DaoJpaFactory());
    	DaoJpaFactory.getFactory().getTemaDao().create(temaBeanToEntity(tema));
	}

	private static TemaBean temaEntityToBean(Tema tema){
		return new TemaBean(tema.getNombre(),tema.getPregunta());
	}
	
	private static Tema temaBeanToEntity(TemaBean tema) {
		return new Tema(tema.getNombre(),tema.getPregunta());
	}


	//Preguntas profe:
//		Cuando se crea el DAO?
//		Servlet llama a Controller y llama a DAO?
//		Servlet solo de redireccion?
}
