package views.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedProperty;

import controllers.ejb.ControllerFactory;

public class View implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{controllerFactory}")
	private ControllerFactory controllerFactory;

	public ControllerFactory getControllerFactory() {
		if(controllerFactory == null){
			controllerFactory = new ControllerFactory();
		}
		return controllerFactory;
	}
}
