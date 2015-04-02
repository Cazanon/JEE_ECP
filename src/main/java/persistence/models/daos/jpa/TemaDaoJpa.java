package persistence.models.daos.jpa;

import persistence.models.daos.TemaDao;
import persistence.models.entities.Tema;

public class TemaDaoJpa extends GenericDaoJpa<Tema, Integer> implements TemaDao {

    public TemaDaoJpa() {
        super(Tema.class);
    }
    
}