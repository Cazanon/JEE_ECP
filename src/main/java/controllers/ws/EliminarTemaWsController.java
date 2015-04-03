package controllers.ws;

import java.util.List;

import javax.ws.rs.core.GenericType;

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
		WsManager webServicesManager = ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS,TemaUris.PATH_AUTORIZADO);
        webServicesManager.addParams("clave", clave);
        return webServicesManager.entityBoolean();
	}

	@Override
	public List<Tema> getTemas() {
		GenericType<List<Tema>> genericType = new GenericType<List<Tema>>(){};
        return ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS).entities(genericType);
	}

	@Override
	public Tema obtenerTema(String id) {
		return ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS, id.toString()).entity(Tema.class);
	}

}
