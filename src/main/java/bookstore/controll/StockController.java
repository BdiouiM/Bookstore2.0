package bookstore.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bookstore.entities.Livre;
import bookstore.exception.StockException;
import bookstore.service.StockService;
import bookstore.service.Impl.StockImpl;

@RequestMapping("/stock")
@RestController
public class StockController {
	@Autowired
    private StockImpl stockService;
	@GetMapping("/stock-welcome")
	public String start(){
		return "Weclome to stock";
    }
	
	@GetMapping("/stock-existe")
	@ResponseBody
	public boolean existeLivre(@RequestBody Livre l) throws StockException{
		return stockService.existeLivre(l);
    }
	@GetMapping("/stock-quantite")
	@ResponseBody
	public int quantiteLivre(@RequestBody Livre l) throws StockException{
		return stockService.QuantiteLivre(l);
    }
	@GetMapping("/stock-quantites")
	public int quantitesLivre() throws StockException{
		return stockService.QuantiteLivres();
    }
	/*@GetMapping("/stock-quantites")
	@ResponseBody
	public void passercommande(@RequestBody Livre l) throws Exception{
		 stockService.passerCommandeLivre(l);
    }*/
	@GetMapping("/stock-livres")
	@ResponseBody
	public  List<Livre> getLivres() throws Exception{
		 return stockService.ListerLivres();
    }
	@GetMapping("/stock-livre")
	@ResponseBody
	public Livre getLivre(@RequestBody Livre l) throws StockException{
		return stockService.afficherLivre(l);
    }
}
