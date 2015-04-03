package controllers.ws;

import java.util.List;

import javax.ws.rs.core.GenericType;

import persistence.models.entities.Tema;
import persistence.models.entities.Voto;
import ws.TemaUris;
import controllers.VotarController;

public class VotarWsController implements VotarController{

	@Override
	public void votar(Voto voto) {		
	}

	@Override
	public List<Tema> getTemas() {
		GenericType<List<Tema>> genericType = new GenericType<List<Tema>>(){};
        return ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS).entities(genericType);
	}

	@Override
	public List<String> getNivelEstudios() {
		return null;
	}

	@Override
	public Tema obtenerTema(String id) {
		return ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS, id.toString()).entity(Tema.class);
	}

}
