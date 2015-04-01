package persistence.models.daos.jpa;

import java.util.ArrayList;
import java.util.List;

import persistence.models.daos.VotoDao;
import persistence.models.entities.Tema;
import persistence.models.entities.Voto;

public class VotoDaoJpa extends GenericDaoJpa<Voto, Integer> implements VotoDao {

    public VotoDaoJpa() {
        super(Voto.class);
    }

	@Override
	public List<Voto> getVotos(Tema tema) {
		// TODO implementar funcionalidad
		return new ArrayList<Voto>();
	}
	
}