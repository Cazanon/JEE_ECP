package controllers.ejb;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "controllerFactory")
@ApplicationScoped
public class ControllerEJBFactory {
	
	private AddTemaEJBController addTemaController;
	private EliminarTemaEJBController eliminarTemaController;
	private VerVotosEJBController verVotosController;
	private VotarEJBController votarController;
	
	
	public AddTemaEJBController getAddTemaController(){
		if(addTemaController==null){
			addTemaController = new AddTemaEJBController();
		}
		return addTemaController;
	}
	
	public EliminarTemaEJBController getEliminarTemaController(){
		if(eliminarTemaController==null){
			eliminarTemaController = new EliminarTemaEJBController();
		}
		return eliminarTemaController;
	}
	
	public VerVotosEJBController getVerVotosController(){
		if(verVotosController==null){
			verVotosController = new VerVotosEJBController();
		}
		return verVotosController;
	}
	
	public VotarEJBController getVotarController(){
		if(votarController==null){
			votarController = new VotarEJBController();
		}
		return votarController;
	}
	
}
