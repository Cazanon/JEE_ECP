package views.beans;

import javax.faces.bean.ManagedBean;

import persistence.models.entities.Tema;
import controllers.ejb.AddTemaController;

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
		AddTemaController addTemaController = getControllerFactory().getAddTemaController(); 
		if(!addTemaController.existe(tema)){
			addTemaController.add(tema);
			added = true;
			mensaje = "Tema añadido";
		}else{
			setMensaje("Tema no insertado, ya existe un tema con ese nombre");
		}
	}

}
