package persistence.models.daos.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.TemaDao;
import persistence.models.entities.Tema;


public class TemaDaoJpaTest {

	private TemaDao dao;

	private Tema tema;

    @BeforeClass
    public static void beforeClass() {
        DaoFactory.setFactory(new DaoJpaFactory());
        DaoJpaFactory.dropAndCreateTables();
    }

    @Before
    public void before() {
    	this.tema = new Tema("Tema Test","Pregunta Test");
        dao = DaoFactory.getFactory().getTemaDao();
        dao.create(tema);
    }

    @Test
    public void testRead() {
        assertEquals(tema, dao.read(tema.getId()));
    }

    @Test
    public void testUpdate() {
        tema.setNombre("Tema Test Update");
        tema.setPregunta("Pregunta Test Update");	        
        dao.update(tema);
        assertEquals(tema.getNombre(), dao.read(tema.getId()).getNombre());
    }

    @Test
    public void testDeleteByID() {
        dao.deleteById(tema.getId());
        assertNull(dao.read(tema.getId()));
    }

    @Test
    public void testFindAll() {
    	this.tema = new Tema("Tema Test 2","Pregunta Test 2");        
        dao = DaoFactory.getFactory().getTemaDao();
        dao.create(tema);
        assertEquals(2, dao.findAll().size());
	}
    
    @Test
    public void testEquals() {      
        assertTrue(tema.equals(dao.read(tema.getId())));
	}

    @After
    public void after() {
        DaoJpaFactory.dropAndCreateTables();
    }

}
