package controllers.ejb;

import java.util.ArrayList;
import java.util.List;

import persistence.models.daos.DaoFactory;
import persistence.models.entities.Tema;
import persistence.models.entities.Voto;
import persistence.models.utils.NivelEstudios;

public class VotarController {
	
	public void votar(Voto voto){
		DaoFactory.getFactory().getVotoDao().create(voto);
	}
	
	public List<Tema> getTemas(){
		return DaoFactory.getFactory().getTemaDao().findAll();
	}
	
	public List<String> getNivelEstudios(){
		List<String> niveles = new ArrayList<String>();
		for(NivelEstudios nivelEstudios : NivelEstudios.values()){
			niveles.add(nivelEstudios.toString());
		}		
		return niveles;
	}	

}
