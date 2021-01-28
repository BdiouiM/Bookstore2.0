package bookstore;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sun.el.parser.ParseException;

import bookstore.entities.Reclamation;
import bookstore.entities.TypeReclamation;
import bookstore.exception.ReclamationException;
import bookstore.service.ReclamationAdminService;
import bookstore.service.ReclamationClientService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReclamationTests {
	@Autowired
	ReclamationAdminService reclamationAdminService;
	@Autowired
	ReclamationClientService reclamationClientService;
	// TEST ADMIN RECLAMATION -MOHAMED BDIOUI-
		@Test
		public void testfindAll() {
	    	reclamationAdminService.findAll();
	    }
	    @Test
		public void testNombreReclamation() {
	    	 reclamationAdminService.NombreReclamations();
	    }
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
	   /* @Test
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
	       }*/
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
			}
	    }
	    @Test
	   	public void testExisteReclamationClient() throws ParseException {
	    	boolean expected =false;
	    	Reclamation r = new Reclamation();
	    	Assert.assertEquals(expected,reclamationClientService.existeReclamation(r));
	    }

}
