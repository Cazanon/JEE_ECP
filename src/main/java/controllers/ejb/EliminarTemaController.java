package controllers.ejb;

import java.util.List;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.TemaDao;
import persistence.models.daos.VotoDao;
import persistence.models.entities.Tema;
import persistence.models.entities.Voto;

public class EliminarTemaController {

	private final String CLAVE_AUTORIZADO = "666";
	
	public void eliminar(Tema tema){
		TemaDao daoTema = DaoFactory.getFactory().getTemaDao();
		VotoDao daoVoto = DaoFactory.getFactory().getVotoDao();
		
		//Hacer esta logica en el DAO?
		List<Voto> votos = daoVoto.findAll();
		for (Voto voto : votos) {
			if(voto.getTema().getId() == tema.getId()){
				daoVoto.deleteById(voto.getId());
			}
		}
		
		daoTema.deleteById(tema.getId());
	}
	
	public boolean autorizado(String clave){
		if(clave.equals(CLAVE_AUTORIZADO)){
			return true;
		}
		return false;
	}
	
}
