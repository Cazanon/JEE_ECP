package controllers.ejb;

import java.util.List;

import controllers.EliminarTemaController;
import persistence.models.daos.DaoFactory;
import persistence.models.daos.TemaDao;
import persistence.models.daos.VotoDao;
import persistence.models.daos.jpa.DaoJpaFactory;
import persistence.models.entities.Tema;
import persistence.models.entities.Voto;

public class EliminarTemaEJBController implements EliminarTemaController{

	private final String CLAVE_AUTORIZADO = "666";

	@Override
	public void eliminar(Tema tema){
		DaoFactory.setFactory(new DaoJpaFactory());
		TemaDao daoTema = DaoFactory.getFactory().getTemaDao();
		VotoDao daoVoto = DaoFactory.getFactory().getVotoDao();

		List<Voto> votos = daoVoto.findAll();
		for (Voto voto : votos) {
			if(voto.getTema().getId() == tema.getId()){
				daoVoto.deleteById(voto.getId());
			}
		}
		
		daoTema.deleteById(tema.getId());
	}

	@Override
	public boolean autorizado(String clave){
		if(clave.equals(CLAVE_AUTORIZADO)){
			return true;
		}
		return false;
	}

	@Override
	public List<Tema> getTemas(){
		DaoFactory.setFactory(new DaoJpaFactory());
		return DaoFactory.getFactory().getTemaDao().findAll();
	}

	@Override
	public Tema obtenerTema(String id){
		DaoFactory.setFactory(new DaoJpaFactory());
		for(Tema tema : DaoFactory.getFactory().getTemaDao().findAll()){
			if(tema.getId() == Integer.parseInt(id)) return tema;
		}
		return null;
	}
	
}
