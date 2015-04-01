package persistence.models.daos;

import java.util.List;

import persistence.models.entities.Tema;
import persistence.models.entities.Voto;

public interface VotoDao extends GenericDao<Voto, Integer> {

	public List<Voto> getVotos(Tema tema);
	
}