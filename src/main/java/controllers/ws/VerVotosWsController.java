package controllers.ws;

import java.util.List;

import javax.ws.rs.core.GenericType;

import persistence.models.entities.Tema;
import ws.TemaUris;
import controllers.VerVotosController;

public class VerVotosWsController implements VerVotosController{

	@Override
	public int votosPorTema(Tema tema) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double mediaVotosTemaNivelEstudios(Tema tema, String nivelEstudios) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Tema> getTemas() {
		GenericType<List<Tema>> genericType = new GenericType<List<Tema>>(){};
        return ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS).entities(genericType);
	}

	@Override
	public int getVotos(Tema tema) {
		return ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS, tema.getNombre()).entity(Integer.class);
	}

}
