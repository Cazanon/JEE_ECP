package controllers;

import java.util.List;

import persistence.models.entities.Tema;

public interface VerVotosController {

	public int votosPorTema(Tema tema);
	
	public double mediaVotosTemaNivelEstudios(Tema tema, String nivelEstudios);
	
	public List<Tema> getTemas();

	public int getVotos(Tema tema);
	
}
