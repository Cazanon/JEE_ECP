package views.beans;

import javax.faces.bean.ManagedBean;

import persistence.models.entities.Tema;

@ManagedBean
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
		assert tema != null;		
		getControllerFactory().getAddTemaController().add(tema);
	}

}
