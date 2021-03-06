package views.beans;

import javax.faces.bean.ManagedBean;

import persistence.models.entities.Tema;
import controllers.ejb.AddTemaEJBController;

@ManagedBean
public class AddTemaBean extends View{

	private static final long serialVersionUID = 1L;
	
	private Tema tema;
	private String mensaje;
	private boolean added = false;
	
	public void setTema(Tema tema) {
		this.tema=tema;		
	}
	
	public Tema getTema(){
		return tema;
	}

	public boolean isAdded() {
		return added;
	}

	public void setAdded(boolean added) {
		this.added = added;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public void process() {
		assert tema != null;
		//AddTemaWsController addTemaController = getControllerWSFactory().getAddTemaController();
		AddTemaEJBController addTemaController = getControllerEJBFactory().getAddTemaController(); 
		if(!addTemaController.existe(tema)){
			addTemaController.add(tema);
			added = true;
			mensaje = "Tema a�adido";
		}else{
			setMensaje("Tema no insertado, ya existe un tema con ese nombre");
		}
	}

}
