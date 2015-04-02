package views.beans;

import java.util.List;

import persistence.models.entities.Tema;
import persistence.models.entities.Voto;

public class VotarBean extends View{

	private static final long serialVersionUID = 1L;
	
	private List<Tema> temas;
	private String mensaje;
	private Tema tema;
	private Voto voto;
	private String clave;

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

	public Voto getVoto() {
		return voto;
	}

	public void setVoto(Voto voto) {
		this.voto = voto;
	}

	public void update() {
		temas = getControllerFactory().getEliminarTemaController().getTemas();
		if(temas.size() == 0){
			mensaje = "No hay temas";
		}
	}
	
	public void process(){
		if(getControllerFactory().getEliminarTemaController().autorizado(clave) && tema !=null){
			getControllerFactory().getEliminarTemaController().eliminar(tema);
			mensaje = "Tema eliminado";
		}else{
			mensaje = "Clave incorrecta. No autorizado a eliminar el tema";
		}
	}

	public void obtenerTema(String id) {
		tema = getControllerFactory().getEliminarTemaController().obtenerTema(id);		
	}
	
}
