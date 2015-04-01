package persistence.models.daos.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.VotoDao;
import persistence.models.entities.Tema;
import persistence.models.entities.Voto;
import persistence.models.utils.NivelEstudios;

public class VotoDaoJpaTest {
	
	private VotoDao dao;

	private Voto voto;
	private static Tema tema;

    @BeforeClass
    public static void beforeClass() {
        DaoFactory.setFactory(new DaoJpaFactory());
        DaoJpaFactory.dropAndCreateTables();        
        tema = new Tema("Tema Test","Pregunta Test");
        DaoFactory.getFactory().getTemaDao().create(tema);;
    }

    @Before
    public void before() {
    	this.voto = new Voto("Valoracion Test", NivelEstudios.BASICO, "IP Test", tema);
        dao = DaoFactory.getFactory().getVotoDao();
        dao.create(voto);
    }

    @Test
    public void testRead() {
        assertEquals(voto, dao.read(voto.getId()));
    }

    @Test
    public void testUpdate() {
        voto.setValoracion("Valoracion Test Update");
        voto.setNivelEstudios(NivelEstudios.ESO);
        voto.setIpUsuario("IP Test Update");
        tema.setNombre("Tema Test Update");
        tema.setPregunta("Pregunta Test Update");	 
        voto.setTema(tema);
        dao.update(voto);
        assertEquals(voto.getValoracion(), dao.read(voto.getId()).getValoracion());
    }

    @Test
    public void testDeleteByID() {
        dao.deleteById(voto.getId());
        assertNull(dao.read(voto.getId()));
    }

    @Test
    public void testFindAll() {
    	this.voto = new Voto("Valoracion Test 2", NivelEstudios.POSTGRADO, "IP Test 2", tema);      
        dao = DaoFactory.getFactory().getVotoDao();
        dao.create(voto);
        assertEquals(2, dao.findAll().size());
	}
    
    @Test
    public void testEquals() {      
        assertTrue(voto.equals(dao.read(voto.getId())));
	}

    @After
    public void after() {
        DaoJpaFactory.dropAndCreateTables();
    }

}
