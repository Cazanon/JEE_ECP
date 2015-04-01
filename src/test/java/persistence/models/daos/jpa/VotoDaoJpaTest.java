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
import persistence.models.daos.VotoDao;
import persistence.models.entities.Tema;
import persistence.models.entities.Voto;
import persistence.models.utils.NivelEstudios;

public class VotoDaoJpaTest {
	
	private VotoDao dao;
	
    @BeforeClass
    public static void beforeClass() {
        DaoFactory.setFactory(new DaoJpaFactory());
        DaoJpaFactory.dropAndCreateTables();
    }

    @Before
    public void before() {    	
        dao = DaoFactory.getFactory().getVotoDao();
    }
    
    @After
    public void after() {
    	List<Voto> votos = dao.findAll();
    	for (Voto voto : votos) {
			dao.deleteById(voto.getId());    		
		}
    }

    @Test
    public void testCreate() {
    	Tema tema = new Tema("Tema Test","Pregunta Test");
        Voto votoCreate = new Voto("1",NivelEstudios.BASICO,"IP",tema);
    	dao.create(votoCreate);
        assertEquals(votoCreate, dao.read(votoCreate.getId()));
    }    
    
    @Test
    public void testRead() {
    	Tema tema = new Tema("Tema Test","Pregunta Test");
        Voto votoRead = new Voto("1",NivelEstudios.BASICO,"IP",tema);
        dao.create(votoRead);
        assertEquals(votoRead, dao.read(votoRead.getId()));
    }

    @Test
    public void testUpdate() {
    	Tema tema = new Tema("Tema Test","Pregunta Test");
        Voto votoUpdate = new Voto("1",NivelEstudios.BASICO,"IP",tema);
    	dao.create(votoUpdate);
    	votoUpdate.setIpUsuario("IP1");
    	votoUpdate.setNivelEstudios(NivelEstudios.ESO);
    	tema.setNombre("Tema Test 1");
    	tema.setPregunta("Pregunta Test 1");
    	votoUpdate.setTema(tema);
    	votoUpdate.setValoracion("2");      
        dao.update(votoUpdate);
        assertEquals(votoUpdate.getIpUsuario(), dao.read(votoUpdate.getId()).getIpUsuario());
        assertEquals(votoUpdate.getNivelEstudios(), dao.read(votoUpdate.getId()).getNivelEstudios());
        assertEquals(votoUpdate.getTema(), dao.read(votoUpdate.getId()).getTema());
        assertEquals(votoUpdate.getValoracion(), dao.read(votoUpdate.getId()).getValoracion());
    }

    @Test
    public void testFindAll() {
    	Tema tema1 = new Tema("Tema Test 1","Pregunta Test 1");
        Voto votoFind1 = new Voto("1",NivelEstudios.BASICO,"IP",tema1);
    	Tema tema2 = new Tema("Tema Test 2","Pregunta Test 2");
        Voto votoFind2 = new Voto("1",NivelEstudios.BASICO,"IP",tema2);
    	dao.create(votoFind1);
    	dao.create(votoFind2);
        assertEquals(2, dao.findAll().size());
	}
    
    @Test
    public void testEquals() {   
    	Tema tema = new Tema("Tema Test","Pregunta Test");
        Voto votoEquals = new Voto("1",NivelEstudios.BASICO,"IP",tema);
        dao.create(votoEquals);    
        assertTrue(votoEquals.equals(dao.read(votoEquals.getId())));
	}
    
    @Test
    public void testDeleteByID() {
    	Tema tema = new Tema("Tema Test","Pregunta Test");
        Voto votoDelete = new Voto("1",NivelEstudios.BASICO,"IP",tema);
        dao.create(votoDelete);    	
        dao.deleteById(votoDelete.getId());       
        assertNull(dao.read(votoDelete.getId()));
    }    

}
