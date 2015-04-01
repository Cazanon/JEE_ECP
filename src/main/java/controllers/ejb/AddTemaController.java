package controllers.ejb;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.TemaDao;
import persistence.models.entities.Tema;

public class AddTemaController {

	public void addTema(Tema tema){
		TemaDao dao = DaoFactory.getFactory().getTemaDao();
		dao.create(tema);
	}
	
	public boolean existe(Tema tema){
		TemaDao dao = DaoFactory.getFactory().getTemaDao();
		if(dao.read(tema.getId())!=null){
			return true;
		}
		return false;
	}
	
}
