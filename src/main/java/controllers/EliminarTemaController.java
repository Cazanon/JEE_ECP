package controllers;

import java.util.List;

import persistence.models.entities.Tema;

public interface EliminarTemaController {

	public void eliminar(Tema tema);
	
	public boolean autorizado(String clave);
	
	public List<Tema> getTemas();
	
	public Tema obtenerTema(String id);
	
}
