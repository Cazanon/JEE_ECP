package views.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedProperty;

import controllers.ejb.ControllerEJBFactory;
import controllers.ws.ControllerWsFactory;

public class View implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{controllerEJBFactory}")
	private ControllerEJBFactory controllerEJBFactory;
	
	@ManagedProperty(value = "#{controllerWsFactory}")
	private ControllerWsFactory controllerWsFactory;

	public ControllerEJBFactory getControllerEJBFactory() {
		if(controllerEJBFactory == null){
			controllerEJBFactory = new ControllerEJBFactory();
		}
		return controllerEJBFactory;
	}

	public ControllerWsFactory getControllerWSFactory() {
		if(controllerWsFactory == null){
			controllerWsFactory = new ControllerWsFactory();
		}
		return controllerWsFactory;
	}
}
