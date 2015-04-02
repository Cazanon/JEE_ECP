package views.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import persistence.models.entities.Tema;
import persistence.models.entities.Voto;
import persistence.models.utils.NivelEstudios;

@ManagedBean
public class VotarBean extends View{

	private static final long serialVersionUID = 1L;
	
	private List<Tema> temas;
	private List<String> nivelesEstudio;
	private String mensaje;
	private String ip;
	private Tema tema;
	private String valoracion;
	private String nivelEstudios;
	private Voto voto;


	public String getValoracion() {
		return valoracion;
	}

	public void setValoracion(String valoracion) {
		this.valoracion = valoracion;
	}
	
	public VotarBean(){
		nivelesEstudio = getControllerEJBFactory().getVotarController().getNivelEstudios();
	}
	
	public List<String> getNivelesEstudio() {
		return nivelesEstudio;
	}

	public void setNivelesEstudio(List<String> nivelesEstudio) {
		this.nivelesEstudio = nivelesEstudio;
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

	public Voto getVoto() {
		return voto;
	}

	public void setVoto(Voto voto) {
		this.voto = voto;
	}
	
	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	public String getRespuesta() {
		return valoracion;
	}

	public void setRespuesta(String respuesta) {
		this.valoracion = respuesta;
	}

	public String getNivelEstudios() {
		return nivelEstudios;
	}

	public void setNivelEstudios(String nivelEstudios) {
		this.nivelEstudios = nivelEstudios;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void update() {
		temas = getControllerEJBFactory().getVotarController().getTemas();
		if(temas.size() == 0){
			mensaje = "No hay temas";
		}
	}
	
	public void process(){
		if(valoracion != null){			
			getControllerEJBFactory().getVotarController().votar(voto);
			mensaje = "Has votado";
		}
	}

	public void obtenerTema(String id) {
		tema = getControllerEJBFactory().getVotarController().obtenerTema(id);		
	}
	
	public NivelEstudios getNivel(String nivel){
    	for(NivelEstudios s : NivelEstudios.values()){
    		if(s.toString().equals(nivel)) return s;
    	}
    	return null;
	}
}
