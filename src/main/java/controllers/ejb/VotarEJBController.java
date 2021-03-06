package controllers.ejb;

import java.util.ArrayList;
import java.util.List;

import controllers.VotarController;
import persistence.models.daos.DaoFactory;
import persistence.models.daos.jpa.DaoJpaFactory;
import persistence.models.entities.Tema;
import persistence.models.entities.Voto;
import persistence.models.utils.NivelEstudios;

public class VotarEJBController implements VotarController{

	@Override
	public void votar(Voto voto){
		DaoFactory.setFactory(new DaoJpaFactory());
		DaoFactory.getFactory().getVotoDao().create(voto);
	}

	@Override
	public List<Tema> getTemas(){
		DaoFactory.setFactory(new DaoJpaFactory());
		return DaoFactory.getFactory().getTemaDao().findAll();
	}

	@Override
	public List<String> getNivelEstudios(){
		List<String> niveles = new ArrayList<String>();
		for(NivelEstudios nivelEstudios : NivelEstudios.values()){
			niveles.add(nivelEstudios.toString());
		}		
		return niveles;
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
