package views.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedProperty;

import controllers.ejb.ControllerFactory;

public abstract class View implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{controllerFactory}")
	private ControllerFactory controllerFactory;

	public ControllerFactory getControllerFactory() {
		return controllerFactory;
	}

	public void setControllerFactory(ControllerFactory controllerFactory) {
		this.controllerFactory = controllerFactory;
	}	

}
