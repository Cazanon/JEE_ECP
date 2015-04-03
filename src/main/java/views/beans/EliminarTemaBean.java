package views.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import persistence.models.entities.Tema;

@ManagedBean
public class EliminarTemaBean extends View{

	private static final long serialVersionUID = 1L;
	
	private List<Tema> temas;
	private String mensaje;
	private Tema tema;
	private String clave;
	
	public EliminarTemaBean() {}
	
	public EliminarTemaBean(String clave) {
		this.clave = clave;
	}	

	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public void update() {
		temas = getControllerEJBFactory().getEliminarTemaController().getTemas();
		if(temas.size() == 0){
			mensaje = "No hay temas";
		}
	}
	
	public void process(){
		//if(getControllerWSFactory().getEliminarTemaController().autorizado(clave) && tema !=null){
		//getControllerWSFactory().getEliminarTemaController().eliminar(tema);
		if(getControllerEJBFactory().getEliminarTemaController().autorizado(clave) && tema !=null){
			getControllerEJBFactory().getEliminarTemaController().eliminar(tema);
			mensaje = "Tema eliminado";
		}else{
			mensaje = "Clave incorrecta. No autorizado a eliminar el tema";
		}
	}

	public void obtenerTema(String id) {
		tema = getControllerEJBFactory().getEliminarTemaController().obtenerTema(id);		
	}

}
