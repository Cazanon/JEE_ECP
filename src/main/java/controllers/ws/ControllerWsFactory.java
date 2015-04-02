package controllers.ws;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import controllers.ControllerFactory;
@ManagedBean(name = "controllerWSFactory")
@ApplicationScoped
public class ControllerWsFactory implements ControllerFactory{
	
	private AddTemaWsController addTemaController;
	private EliminarTemaWsController eliminarTemaController;
	private VerVotosWsController verVotosController;
	private VotarWsController votarController;
	

	@Override
	public AddTemaWsController getAddTemaController(){
		if(addTemaController==null){
			addTemaController = new AddTemaWsController();
		}
		return addTemaController;
	}

	@Override
	public EliminarTemaWsController getEliminarTemaController(){
		if(eliminarTemaController==null){
			eliminarTemaController = new EliminarTemaWsController();
		}
		return eliminarTemaController;
	}

	@Override
	public VerVotosWsController getVerVotosController(){
		if(verVotosController==null){
			verVotosController = new VerVotosWsController();
		}
		return verVotosController;
	}

	@Override
	public VotarWsController getVotarController(){
		if(votarController==null){
			votarController = new VotarWsController();
		}
		return votarController;
	}
}
