package controllers.ejb;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "controllerFactory")
@ApplicationScoped
public class ControllerFactory {
	
	private AddTemaController addTemaController;
	private EliminarTemaController eliminarTemaController;
	private VerVotosController verVotosController;
	private VotarController votarController;
	
	
	public AddTemaController getAddTemaController(){
		if(addTemaController==null){
			addTemaController = new AddTemaController();
		}
		return addTemaController;
	}
	
	public EliminarTemaController getEliminarTemaController(){
		if(eliminarTemaController==null){
			eliminarTemaController = new EliminarTemaController();
		}
		return eliminarTemaController;
	}
	
	public VerVotosController getVerVotosController(){
		if(verVotosController==null){
			verVotosController = new VerVotosController();
		}
		return verVotosController;
	}
	
	public VotarController getVotarController(){
		if(votarController==null){
			votarController = new VotarController();
		}
		return votarController;
	}
	
}
