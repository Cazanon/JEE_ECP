package views.beans;

import javax.faces.bean.ManagedBean;

import persistence.models.entities.Tema;
import controllers.ejb.AddTemaController;

@ManagedBean
public class AddTemaBean extends View{

	private static final long serialVersionUID = 1L;
	
	private Tema tema;
	private boolean existe;
	private boolean added = false;
	
	public void setTema(Tema tema) {
		this.tema=tema;		
	}
	
	public Tema getTema(){
		return tema;
	}

	public boolean isExiste() {
		return existe;
	}

	public void setExiste(boolean existe) {
		this.existe = existe;
	}

	public boolean isAdded() {
		return added;
	}

	public void setAdded(boolean added) {
		this.added = added;
	}

	public void process() {
		setExiste(false);
		assert tema != null;		
		AddTemaController addTemaController = getControllerFactory().getAddTemaController(); 
		if(!addTemaController.existe(tema)){
			addTemaController.add(tema);
			setAdded(true);
		}else{
			setExiste(true);
		}
	}

}
