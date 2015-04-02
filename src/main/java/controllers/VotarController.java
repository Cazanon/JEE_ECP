package controllers;

import java.util.List;

import persistence.models.entities.Tema;
import persistence.models.entities.Voto;

public interface VotarController {
	
	public void votar(Voto voto);
	
	public List<Tema> getTemas();
	
	public List<String> getNivelEstudios();

	public Tema obtenerTema(String id);

}
