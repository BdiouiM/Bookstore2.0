package bookstore.controll;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/reclamation-list")
    public Iterable<Reclamation> getAll() {
		
		return reclamationAdminService.findAll();
	}
	@PostMapping(/*value=*/"/reclamation-add"/*, method = RequestMethod.POST*/)
	    public  ResponseEntity<String> envoyerReclamation(@RequestBody Reclamation r) {
	         try {
				 reclamationClientService.envoyerReclamation(r);
				 return  new ResponseEntity("reclamation envoyée", HttpStatus.OK);
			} catch (ReclamationException e) {
				e.printStackTrace();
			}
	         return  new ResponseEntity("error add", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	
	@PostMapping(/*value = */"/reclamation-delete"/*, method = RequestMethod.POST*/)
	public ResponseEntity<String> annulerReclamation(@RequestBody Reclamation r){
		try {
	            reclamationClientService.annulerReclamationsClient(r);
	            return  new ResponseEntity("reclamation annulée", HttpStatus.OK);
		} catch (ReclamationException e) {
			e.printStackTrace();
		}
		return  new ResponseEntity("error delete", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
