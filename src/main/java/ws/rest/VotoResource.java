package ws.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import persistence.models.utils.NivelEstudios;
import ws.VotoUris;

public class VotoResource {
	
	@GET
    @Path(VotoUris.PATH_NIVEL_ESTUDIOS)
    @Produces(MediaType.APPLICATION_XML)
	public List<String> getNivelesEstudios() {
		List<String> nivelesEstudios = new ArrayList<String>();
		for(NivelEstudios nivelEstudios : NivelEstudios.values()) {
			nivelesEstudios.add(nivelEstudios.name());
		}
		return nivelesEstudios;
	}
	
}
