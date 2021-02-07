package bookstore;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sun.el.parser.ParseException;

import bookstore.entities.Livre;
import bookstore.exception.StockException;
import bookstore.service.StockService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockTests {
	@Autowired
	StockService stockService;
	//private static final Logger L = (Logger) LogManager.getLogger(BookstoreApplicationTests.class);   
	
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
   @Test
   	public void testListLivre() throws StockException {
    	Livre l = new Livre();
    	l.setId((long) 9);
    	if(stockService.existeLivre(l))
    	{stockService.afficherLivre(l);}
    }
    @Test
   	public void testAfficherLivres() throws ParseException {
    	List<Livre> livres=stockService.ListerLivres();
    	stockService.AfficherLivres(livres);
    }

}
