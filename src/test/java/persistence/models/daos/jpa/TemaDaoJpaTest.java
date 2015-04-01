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
        Tema temaRead = new Tema("Tema Test","Pregunta Test");
        dao.create(temaRead);
        assertEquals(temaRead, dao.read(temaRead.getId()));
    }

    @Test
    public void testUpdate() {
    	Tema temaUpdate = new Tema("Tema Test","Pregunta Test");
    	dao.create(temaUpdate);
    	temaUpdate.setNombre("Tema Test Update");
    	temaUpdate.setPregunta("Pregunta Test Update");	        
        dao.update(temaUpdate);
        assertEquals(temaUpdate.getNombre(), dao.read(temaUpdate.getId()).getNombre());
        assertEquals(temaUpdate.getPregunta(), dao.read(temaUpdate.getId()).getPregunta());
    }

    @Test
    public void testFindAll() {
    	Tema temaFind1 = new Tema("Tema Test 1","Pregunta Test 1");
    	Tema temaFind2 = new Tema("Tema Test 2","Pregunta Test 2");
    	dao.create(temaFind1);
    	dao.create(temaFind2);
        assertEquals(2, dao.findAll().size());
	}
    
    @Test
    public void testEquals() {   
    	Tema temaEquals = new Tema("Tema Test","Pregunta Test");
        dao.create(temaEquals);    
        assertTrue(temaEquals.equals(dao.read(temaEquals.getId())));
	}
    
    @Test
    public void testDeleteByID() {
    	Tema temaDelete = new Tema("Tema Test","Pregunta Test");
        dao.create(temaDelete);    	
        dao.deleteById(temaDelete.getId());       
        assertNull(dao.read(temaDelete.getId()));
    }    

}
