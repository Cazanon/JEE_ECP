package controllers.ejb;

import persistence.models.daos.DaoFactory;
import persistence.models.entities.Tema;
import persistence.models.utils.NivelEstudios;

public class VerVotosController {

	public int votosPorTema(Tema tema){
		return DaoFactory.getFactory().getVotoDao().getVotos(tema).size();
	}
	
	public double mediaVotosTemaNivelEstudios(Tema tema, NivelEstudios nivel){
		//TODO implementar funcionalidad
		return 0;
	}
	
}
