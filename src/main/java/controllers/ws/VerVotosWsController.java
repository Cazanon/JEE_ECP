package controllers.ws;

import java.util.List;

import javax.ws.rs.core.GenericType;

import persistence.models.entities.Tema;
import ws.TemaUris;
import ws.VotoUris;
import controllers.VerVotosController;

public class VerVotosWsController implements VerVotosController{

	@Override
	public int votosPorTema(Tema tema) {
		return 0;
	}

	@Override
	public double mediaVotosTemaNivelEstudios(Tema tema, String nivelEstudios) {
		return 0;
	}

	@Override
	public List<Tema> getTemas() {
		GenericType<List<Tema>> genericType = new GenericType<List<Tema>>(){};
        return ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS).entities(genericType);
	}

	@Override
	public int getVotos(Tema tema) {
		return ControllerWs.buildWebServiceManager(VotoUris.PATH_VOTOS, tema.getId().toString(),VotoUris.PATH_ID).entity(Integer.class);
	}

}
