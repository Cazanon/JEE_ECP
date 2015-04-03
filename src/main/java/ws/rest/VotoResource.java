package ws.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.jpa.DaoJpaFactory;
import persistence.models.entities.Voto;
import persistence.models.utils.NivelEstudios;
import ws.VotoUris;

@Path(VotoUris.PATH_VOTOS)
public class VotoResource {
	
	@GET
	@Path(VotoUris.PATH_ID)
    @Produces(MediaType.APPLICATION_XML)
	public int getVotos(@PathParam("id") Integer id) {
		DaoFactory.setFactory(new DaoJpaFactory());
		int numeroVotos = 0;
		for(Voto voto : DaoFactory.getFactory().getVotoDao().findAll()){
			if(voto.getTema().getId() == id) numeroVotos++;
		}
		return numeroVotos;
	}
	
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
