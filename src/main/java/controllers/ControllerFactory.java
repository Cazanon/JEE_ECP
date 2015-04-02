package controllers;

import controllers.ejb.AddTemaEJBController;
import controllers.ejb.EliminarTemaEJBController;
import controllers.ejb.VerVotosEJBController;
import controllers.ejb.VotarEJBController;

public interface ControllerFactory {
	
	public AddTemaEJBController getAddTemaController();
	
	public EliminarTemaEJBController getEliminarTemaController();
	
	public VerVotosEJBController getVerVotosController();
	
	public VotarEJBController getVotarController();

}
