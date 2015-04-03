package ws.rest;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.TemaDao;
import persistence.models.daos.VotoDao;
import persistence.models.daos.jpa.DaoJpaFactory;
import persistence.models.entities.Tema;
import persistence.models.entities.Voto;
import ws.TemaUris;

@Path(TemaUris.PATH_TEMAS)
public class TemaResource {

	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response create(Tema tema) {
		Response result;
		DaoFactory.setFactory(new DaoJpaFactory());
		DaoFactory.getFactory().getTemaDao().create(tema);
		result = Response.created(URI.create(TemaUris.PATH_TEMAS + "/" + tema.getId()))
				.entity(String.valueOf(tema.getId())).build();
		return result;
	}
	
	@GET
    @Path(TemaUris.PATH_NOMBRE + TemaUris.PATH_EXISTE)
    public String existe(@PathParam("nombre") String nombre) {
        Boolean result = false;        
		DaoFactory.setFactory(new DaoJpaFactory());
		TemaDao dao = DaoFactory.getFactory().getTemaDao();
		for (Tema t : dao.findAll()){
			if(t.getNombre().equals(nombre)) result = true;
		}	
        return Boolean.toString(result);
    }
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Tema> getTemas() {
		DaoFactory.setFactory(new DaoJpaFactory());
		List<Tema> temas = DaoFactory.getFactory().getTemaDao().findAll();
		return temas;
	}
	
	@DELETE
	@Path(TemaUris.PATH_ID)
	public void delete(@PathParam("id") Integer id) {
		DaoFactory.setFactory(new DaoJpaFactory());
		TemaDao daoTema = DaoFactory.getFactory().getTemaDao();
		VotoDao daoVoto = DaoFactory.getFactory().getVotoDao();
		List<Voto> votos = daoVoto.findAll();
		for (Voto voto : votos) {
			if(voto.getTema().getId() == id){
				daoVoto.deleteById(voto.getId());
			}
		}		
		daoTema.deleteById(id);
	}
}
