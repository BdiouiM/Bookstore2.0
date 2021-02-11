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

import bookstore.entities.GenreLivre;
import bookstore.entities.Livre;
import bookstore.exception.LivreException;
import bookstore.service.LivreAdminService;
import bookstore.service.LivreClientService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class LivreTests {
	private static final GenreLivre ACTION = null;
	@Autowired
	LivreClientService livreClientService;
	@Autowired
	LivreAdminService livreAdminService;
	// TEST ADMIN LIVRE -MOHAMED HEDI BEN ATIG-
	/*	@Test
		public void testfindAll() {
	    	livreAdminService.findAll();
	    }*/
	   
	  /*  @Test
		public void testListLivres() throws ParseException {
	    	livreAdminService.ListLivres();
	    }
	    @Test
	   	public void testAjouterLivre() throws ParseException {
	    	Livre L1=new Livre(1L,"ok","test",11,10.2f,GenreLivre.ACTION);
	    	Livre L=new Livre((long) 7,"BA","hedi",18,19.7f,GenreLivre.COMEDY);

	    	try {
				livreAdminService.ajouterLivre(L1);
			} catch (LivreException e) {
				e.printStackTrace();
				//((org.apache.logging.log4j.Logger) L).debug("error envoyer livre");
			}
	    }*/
	    
	    /*
	    @Test
	   	public void testSupprimerLivre() throws ParseException {
	    	Livre L1=new Livre(14L,"ok","test",11,10.2f,GenreLivre.ACTION);
	    	try {
				livreAdminService.supprimerLivre(L.getId());
			} catch (LivreException e) {
				e.printStackTrace();
				//((org.apache.logging.log4j.Logger) L).debug("error envoyer livre");
			}
	    }*/
		
	    @Test
		public void testAfficherlivres() throws ParseException {
	    	List<Livre> L=new ArrayList<Livre>();
	    	L=livreAdminService.ListLivres();
	    	livreAdminService.AfficherLivre(L);
	    }
	   
	
	  /*   @Test
	   	public void testExistelivre() throws ParseException {
	    	Livre L=new Livre(14L,"ok","test",11,10.2f,GenreLivre.ACTION);
	    	if (livreAdminService.existeLivre(L)==true)
	    			{
	    		System.out.println("true");
	    			}
	    	else{
	    		System.out.println("false");
	    	}
	    }
*/
	   
	    @Test
	   	public void testModifierlivre() throws ParseException {
	    	Livre L=new Livre(14L,"ok","test",11,10.2f,GenreLivre.ACTION);
	    	L.setTitre("teeeeeeeeeeeeeeeeeeest");
	    	L.setAuteur("auteur tesssssssssssssst");
	    	L.setNbrPages(1);
	    	L.setPrix(1);
	    	L.setGenre(GenreLivre.ADVENTURE);

	    	try {
				livreAdminService.modifierLivre(L, L.getAuteur(), L.getGenre(), L.getNbrPages(), L.getPrix(), L.getTitre());
			} catch (LivreException e) {
				e.printStackTrace();
				
			}
	    } 
	

/*
// TEST CLIENT livre -MOHAMED HEDI BEN ATIG-
	    @Test
	   	public void testExistelivreClient() throws ParseException {
	    	boolean expected =false;
	    	Livre L = new Livre();
	    	Assert.assertEquals(expected,livreClientService.existeLivre(L));
	    } */
}