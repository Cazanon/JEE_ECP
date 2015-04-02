package views.beans;

import persistence.models.entities.Tema;
import controllers.ejb.AddTemaController;

public class AddTemaBean extends View{

	private static final long serialVersionUID = 1L;
	
	private Tema tema;
	
	public void setTema(Tema tema) {
		this.tema=tema;		
	}
	
	public Tema getTema(){
		return tema;
	}

	public void process() {
		AddTemaController addTemaController = this.getControllerFactory().getAddTemaController();
		assert tema != null;		
		addTemaController.add(tema);		
	}

}
