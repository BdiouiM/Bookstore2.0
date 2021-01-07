package bookstore.controll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import bookstore.entities.Reclamation;
import bookstore.exception.ReclamationException;
import bookstore.service.ReclamationAdminService;
import bookstore.service.ReclamationClientService;

@RequestMapping("/reclamation")
@RestController
public class ReclamationController {
	@Autowired
    private ReclamationClientService reclamationClientService;
	@Autowired
    private ReclamationAdminService reclamationAdminService;
	@GetMapping("/reclamation-welcome")
	public String start(){return "Weclome to reclamation";}
	
	@RequestMapping("/reclamation-list")
    public Iterable<Reclamation> getAll() {
		
		return reclamationAdminService.findAll();
	}
	/* @RequestMapping(value = "/envoyer", method = RequestMethod.POST)
	    public void envoyerReclamation(@RequestBody Reclamation r) {
	         try {
				reclamationClientService.envoyerReclamation(r);
			} catch (ReclamationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    }
	@RequestMapping(value = "/annulerRclient", method = RequestMethod.POST)
	public ResponseEntity<String> annulerReclamation(@RequestBody Reclamation r){
		try {
			reclamationClientService.annulerReclamationsClient(r);
		} catch (ReclamationException e) {
			e.printStackTrace();
		}
		return  new ResponseEntity("reclamation annulée", HttpStatus.OK);
	}*/
	
}
