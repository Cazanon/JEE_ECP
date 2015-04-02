package views.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import persistence.models.entities.Tema;

@ManagedBean
public class EliminarTemaBean extends View{

	private static final long serialVersionUID = 1L;
	
	private List<Tema> temas;
	private boolean autorizado = false;
	
	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}

	public boolean isAutorizado() {
		return autorizado;
	}

	public void setAutorizado(boolean autorizado) {
		this.autorizado = autorizado;
	}

	public void update() {
		temas = getControllerFactory().getEliminarTemaController().getTemas(); 	
	}
	
	public void process(){
		
	}

	public void obtenerTema(String parameter) {
		// TODO Auto-generated method stub
		
	}

}
