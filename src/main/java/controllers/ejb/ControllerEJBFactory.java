package controllers.ejb;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import controllers.ControllerFactory;

@ManagedBean(name = "controllerFactory")
@ApplicationScoped
public class ControllerEJBFactory implements ControllerFactory{
	
	private AddTemaEJBController addTemaController;
	private EliminarTemaEJBController eliminarTemaController;
	private VerVotosEJBController verVotosController;
	private VotarEJBController votarController;
	

	@Override
	public AddTemaEJBController getAddTemaController(){
		if(addTemaController==null){
			addTemaController = new AddTemaEJBController();
		}
		return addTemaController;
	}

	@Override
	public EliminarTemaEJBController getEliminarTemaController(){
		if(eliminarTemaController==null){
			eliminarTemaController = new EliminarTemaEJBController();
		}
		return eliminarTemaController;
	}

	@Override
	public VerVotosEJBController getVerVotosController(){
		if(verVotosController==null){
			verVotosController = new VerVotosEJBController();
		}
		return verVotosController;
	}

	@Override
	public VotarEJBController getVotarController(){
		if(votarController==null){
			votarController = new VotarEJBController();
		}
		return votarController;
	}
	
}
