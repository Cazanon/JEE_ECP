package views.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import controllers.ejb.AddTemaController;
import persistence.models.entities.Tema;

@ManagedBean
public class EliminarTemaBean extends View{

	private static final long serialVersionUID = 1L;
	
	private List<Tema> temas;
	
	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}

	public void update() {
		AddTemaController addTemaController = getControllerFactory().getAddTemaController(); 
		
	}

}
