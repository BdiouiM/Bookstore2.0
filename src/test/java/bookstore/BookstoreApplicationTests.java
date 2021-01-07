package bookstore;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.apache.logging.log4j.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import com.sun.el.parser.ParseException;
import bookstore.entities.Livre;
import bookstore.entities.Reclamation;
import bookstore.entities.TypeReclamation;
import bookstore.entities.User;
import bookstore.exception.ReclamationException;
import bookstore.exception.StockException;
import bookstore.service.ReclamationAdminService;
import bookstore.service.ReclamationClientService;
import bookstore.service.StockService;
import bookstore.service.Impl.UserServiceImpl;
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookstoreApplicationTests {
	@Autowired
	ReclamationAdminService reclamationAdminService;
	@Autowired
	ReclamationClientService reclamationClientService;
	@Autowired
	StockService stockService;
	//private static final Logger L = (Logger) LogManager.getLogger(BookstoreApplicationTests.class);    
    // TEST ADMIN RECLAMATION -MOHAMED BDIOUI-
	@Test
	public void testfindAll() {
    	reclamationAdminService.findAll();
    }
   /* @Test
	public void testNombreReclamation() {
    	int expected =0;
    	Assert.assertEquals(expected, reclamationAdminService.NombreReclamations());
    }*/
    @Test
	public void testListReclamations() throws ParseException {
    	reclamationAdminService.ListReclamations();
    }
    @Test
	public void testAnnulerReclamation() throws ParseException {
    	Reclamation r = new Reclamation();
    	try {
    		Assert.assertFalse(reclamationAdminService.annulerReclamation(r));
		} catch (ReclamationException e) {
			e.printStackTrace();
		}
    }
    @Test
	public void testValiderReclamation() throws ReclamationException {
    	Reclamation r = new Reclamation();
    	try {
    		Assert.assertFalse(reclamationAdminService.validerReclamations(r));
		} catch (ReclamationException e) {
			e.printStackTrace();
		}  
    }
    @Test
	public void testTraiterReclamation() throws ReclamationException {
    	Reclamation r = new Reclamation();
    	try {
    		Assert.assertFalse(reclamationAdminService.TraiterReclamation(r));
		} catch (ReclamationException e) {
			e.printStackTrace();
		}  
    }
    @Test
	public void testAfficherReclamations() throws ParseException {
    	List<Reclamation> reclamations=new ArrayList<Reclamation>();
    	reclamations=reclamationAdminService.ListReclamations();
    	reclamationAdminService.AfficherReclamations(reclamations);
    }
    @Test
   	public void testAfficherReclamation() throws ParseException {
       	Reclamation r=new Reclamation();
       	try {
			Set<Reclamation> s =reclamationAdminService.afficherReclamation(r);
			Set<Reclamation> expected = new HashSet<Reclamation>();
			Assert.assertEquals(expected,s);
		} catch (ReclamationException e) {
			e.printStackTrace();
			//((org.apache.logging.log4j.Logger) L).debug("error afficher reclamation");
		}
       }
    @Test
   	public void testExisteReclamation() throws ParseException {
    	Reclamation r= new Reclamation();
    	reclamationAdminService.existeReclamation(r);
    }

    // TEST CLIENT RECLAMATION -MOHAMED BDIOUI-
    @Test
   	public void testEnvoyerReclamation() throws ParseException {
    	Reclamation r=new Reclamation();
    	try {
			reclamationClientService.envoyerReclamation(r);
		} catch (ReclamationException e) {
			e.printStackTrace();
			//((org.apache.logging.log4j.Logger) L).debug("error envoyer reclamation");
		}
    }
    @Test
   	public void testModifierReclamation() throws ParseException {
    	Reclamation r=new Reclamation();
    	r.setType(TypeReclamation.Level1);
    	r.setDescription("description test");
    	r.setDateReclamation(null);
    	try {
			reclamationClientService.modifierReclamation(r, r.getDateReclamation(), r.getDescription(), r.getType());
		} catch (ReclamationException e) {
			e.printStackTrace();
			//((org.apache.logging.log4j.Logger) L).debug("error modifier reclamtion");
		}
    }
    @Test
   	public void testExisteReclamationClient() throws ParseException {
    	boolean expected =false;
    	Reclamation r = new Reclamation();
    	Assert.assertEquals(expected,reclamationClientService.existeReclamation(r));
    }
    // TEST BIBLIOTHECAIRE STOCK -MOHAMED BDIOUI-
    @Test
   	public void testExisteLivre() throws ParseException {
    	boolean expected =false;
    	Livre l = new Livre();
    	Assert.assertEquals(expected,stockService.existeLivre(l));
    }
    @Test
   	public void testQuantiteLivre() throws ParseException {
    	int expected =0;
    	Livre l = new Livre();
    	try {
			Assert.assertEquals(expected,stockService.QuantiteLivre(l));
		} catch (StockException e) {
			//((org.apache.logging.log4j.Logger) L).debug("error quantite livre");
			e.printStackTrace();
		}
    }
    @Test
   	public void testQuantiteLivres() throws ParseException {
    	int expected =0;
		Assert.assertEquals(expected,stockService.QuantiteLivres());
    }
    @Test
   	public void testPasserCommande() throws ParseException {
    	Livre l = new Livre();
    	try {
			stockService.passerCommandeLivre(l);
		} catch (Exception e) {
			e.printStackTrace();
			//((org.apache.logging.log4j.Logger) L).debug("error passer commande");
		}
    }
    @Test
   	public void testListLivres() throws ParseException {
    	List<Livre> expected=new ArrayList<>();
    	Assert.assertEquals(expected,stockService.ListerLivres());
    }
   /* @Test
   	public void testListLivre() throws ParseException, StockException {
    	Livre l = new Livre();
    	l.setId((long) 9);
    	String expected="";
    	String livre=stockService.afficherLivre(l).stream().map(Livre::getAuteur).reduce("",String::concat);
    	Assert.assertEquals(expected,livre);
    }*/
    @Test
   	public void testAfficherLivres() throws ParseException {
    	List<Livre> livres=stockService.ListerLivres();
    	stockService.AfficherLivres(livres);
    }
}
