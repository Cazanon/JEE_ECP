package controllers;

import persistence.models.entities.Tema;

public interface AddTemaController {
	
	public void add(Tema tema);
	
	public boolean existe(Tema tema);
	
}
