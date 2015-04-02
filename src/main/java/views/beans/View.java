package views.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedProperty;

import controllers.ControllerFactory;
import controllers.ejb.ControllerEJBFactory;
import controllers.ws.ControllerWsFactory;

public class View implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{controllerFactory}")
	private ControllerFactory controllerFactory;

	public ControllerEJBFactory getControllerEJBFactory() {
		if(controllerFactory == null){
			controllerFactory = new ControllerEJBFactory();
		}
		return (ControllerEJBFactory) controllerFactory;
	}

	public ControllerWsFactory getControllerWSFactory() {
		if(controllerFactory == null){
			controllerFactory = new ControllerWsFactory();
		}
		return (ControllerWsFactory) controllerFactory;
	}
}
