package persistence.models.daos.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import persistence.models.daos.DaoFactory;
import persistence.models.daos.TemaDao;
import persistence.models.entities.Tema;


public class TemaDaoJpaTest {

	private TemaDao dao;
	
    @BeforeClass
    public static void beforeClass() {
        DaoFactory.setFactory(new DaoJpaFactory());
        DaoJpaFactory.dropAndCreateTables();
    }

    @Before
    public void before() {    	
        dao = DaoFactory.getFactory().getTemaDao();
    }
    
    @After
    public void after() {
    	List<Tema> temas = dao.findAll();
    	for (Tema tema : temas) {
			dao.deleteById(tema.getId());    		
		}
    }

    @Test
    public void testCreate() {
        Tema temaCreate = new Tema("Tema Test","Pregunta Test");
    	dao.create(temaCreate);
        assertEquals(temaCreate, dao.read(temaCreate.getId()));
    }    
    
    @Test
    public void testRead() {
        Tema temaTestRead = new Tema("Tema Test","Pregunta Test");
        dao.create(temaTestRead);
        assertEquals(temaTestRead, dao.read(temaTestRead.getId()));
    }

    @Test
    public void testUpdate() {
    	Tema temaTestUpdate = new Tema("Tema Test","Pregunta Test");
    	dao.create(temaTestUpdate);
    	temaTestUpdate.setNombre("Tema Test Update");
    	temaTestUpdate.setPregunta("Pregunta Test Update");	        
        dao.update(temaTestUpdate);
        assertEquals(temaTestUpdate.getNombre(), dao.read(temaTestUpdate.getId()).getNombre());
        assertEquals(temaTestUpdate.getPregunta(), dao.read(temaTestUpdate.getId()).getPregunta());
    }

    @Test
    public void testFindAll() {
    	Tema temaTestFind1 = new Tema("Tema Test 1","Pregunta Test 1");
    	Tema temaTestFind2 = new Tema("Tema Test 2","Pregunta Test 2");
    	dao.create(temaTestFind1);
    	dao.create(temaTestFind2);
        assertEquals(2, dao.findAll().size());
	}
    
    @Test
    public void testEquals() {   
    	Tema temaTestEquals = new Tema("Tema Test","Pregunta Test");
        dao.create(temaTestEquals);    
        assertTrue(temaTestEquals.equals(dao.read(temaTestEquals.getId())));
	}
    
    @Test
    public void testDeleteByID() {
    	Tema temaTestDelete = new Tema("Tema Test","Pregunta Test");
        dao.create(temaTestDelete);    	
        dao.deleteById(temaTestDelete.getId());       
        assertNull(dao.read(temaTestDelete.getId()));
    }    

}
