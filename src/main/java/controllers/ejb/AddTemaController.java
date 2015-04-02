package controllers.ejb;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.TemaDao;
import persistence.models.daos.jpa.DaoJpaFactory;
import persistence.models.entities.Tema;

public class AddTemaController {

	public void add(Tema tema){
		DaoFactory.setFactory(new DaoJpaFactory());
		TemaDao dao = DaoFactory.getFactory().getTemaDao();
		dao.create(tema);
	}
	
	public boolean existe(Tema tema){
		DaoFactory.setFactory(new DaoJpaFactory());
		TemaDao dao = DaoFactory.getFactory().getTemaDao();
		if(dao.read(tema.getId())!=null){
			return true;
		}
		return false;
	}
	
}
