package views.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import persistence.models.entities.Tema;
import persistence.models.utils.NivelEstudios;

@ManagedBean
public class VerVotosBean extends View{
	private static final long serialVersionUID = 1L;
	
	private List<Tema> temas;
	private List<String> nivelesEstudio;
	private String mensaje;
	private String numeroVotos;
	private String votosMedia;
	private Tema tema;
	private String nivelEstudios;


	public String getNumeroVotos() {
		return numeroVotos;
	}

	public void setNumeroVotos(String numeroVotos) {
		this.numeroVotos = numeroVotos;
	}

	public String getVotosMedia() {
		return votosMedia;
	}

	public void setVotosMedia(String votosMedia) {
		this.votosMedia = votosMedia;
	}
	
	public VerVotosBean(){
		nivelesEstudio = getControllerFactory().getVotarController().getNivelEstudios();
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
	
	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public String getNivelEstudios() {
		return nivelEstudios;
	}

	public void setNivelEstudios(String nivelEstudios) {
		this.nivelEstudios = nivelEstudios;
	}

	public void update() {
		temas = getControllerFactory().getVerVotosController().getTemas();
		if(temas.size() == 0){
			mensaje = "No hay temas";
		}
	}
	
	public void process(){
		if(tema != null){			
			numeroVotos = "El tema " + tema.getNombre() + " tiene " + getControllerFactory().getVerVotosController().getVotos(tema) + "votos";
		}
		if(nivelEstudios != null){			
			votosMedia = "La media de botos del tema " + tema.getNombre() + " para el nivel de estudios " + nivelEstudios + " es de " 
						 + getControllerFactory().getVerVotosController().mediaVotosTemaNivelEstudios(tema, nivelEstudios);
		}
	}

	public void obtenerTema(String id) {
		tema = getControllerFactory().getVotarController().obtenerTema(id);		
	}
	
	public NivelEstudios getNivel(String nivel){
    	for(NivelEstudios s : NivelEstudios.values()){
    		if(s.toString().equals(nivel)) return s;
    	}
    	return null;
	}

	
}