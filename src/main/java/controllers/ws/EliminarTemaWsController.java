package controllers.ws;

import java.util.List;

import persistence.models.entities.Tema;
import ws.TemaUris;
import controllers.EliminarTemaController;

public class EliminarTemaWsController implements EliminarTemaController{

	@Override
	public void eliminar(Tema tema) {
		ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS, tema.getId().toString()).delete();		
	}

	@Override
	public boolean autorizado(String clave) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Tema> getTemas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tema obtenerTema(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
