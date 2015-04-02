package controllers;


public interface ControllerFactory {
	
	public AddTemaController getAddTemaController();
	
	public EliminarTemaController getEliminarTemaController();
	
	public VerVotosController getVerVotosController();
	
	public VotarController getVotarController();

}
