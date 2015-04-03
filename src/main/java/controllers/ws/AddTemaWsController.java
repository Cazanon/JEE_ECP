package controllers.ws;

import persistence.models.entities.Tema;
import ws.TemaUris;
import controllers.AddTemaController;

public class AddTemaWsController implements AddTemaController{

	@Override
	public void add(Tema tema) {
		ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS).create(tema);		
	}

	@Override
	public boolean existe(Tema tema) {
		return ControllerWs.buildWebServiceManager(TemaUris.PATH_TEMAS, tema.getNombre(), TemaUris.PATH_EXISTE).entityBoolean();
	}

}
