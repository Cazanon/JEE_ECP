package controllers.ejb;

import java.util.List;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.jpa.DaoJpaFactory;
import persistence.models.entities.Tema;
import persistence.models.entities.Voto;

public class VerVotosController {

	public int votosPorTema(Tema tema){
		return DaoFactory.getFactory().getVotoDao().getVotos(tema).size();
	}
	
	public double mediaVotosTemaNivelEstudios(Tema tema, String nivelEstudios){
		//TODO implementar funcionalidad
		return 0;
	}
	
	public List<Tema> getTemas(){
		DaoFactory.setFactory(new DaoJpaFactory());
		return DaoFactory.getFactory().getTemaDao().findAll();
	}

	public int getVotos(Tema tema) {
		DaoFactory.setFactory(new DaoJpaFactory());
		int numeroVotos = 0;
		for(Voto voto : DaoFactory.getFactory().getVotoDao().findAll()){
			if(voto.getTema().getId() == tema.getId()) numeroVotos++;
		}
		return numeroVotos;
	}
	
}
