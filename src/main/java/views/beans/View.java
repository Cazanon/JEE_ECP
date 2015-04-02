package views.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedProperty;

import controllers.ejb.ControllerEJBFactory;

public class View implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{controllerFactory}")
	private ControllerEJBFactory controllerFactory;

	public ControllerEJBFactory getControllerFactory() {
		if(controllerFactory == null){
			controllerFactory = new ControllerEJBFactory();
		}
		return controllerFactory;
	}
}
