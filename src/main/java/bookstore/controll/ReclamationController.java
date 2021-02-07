package bookstore.controll;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bookstore.entities.Reclamation;
import bookstore.entities.TypeReclamation;
import bookstore.exception.ReclamationException;
import bookstore.service.ReclamationAdminService;
import bookstore.service.ReclamationClientService;
import bookstore.service.Impl.ReclamationImpl;

@RequestMapping("/reclamation")
@RestController
public class ReclamationController {
	
	@Autowired
    private ReclamationImpl reclamationService;
<<<<<<< HEAD
=======
	
>>>>>>> develop
	@GetMapping("/reclamation-welcome")
	public String start(){return "Weclome to reclamation";}
	// RECLAMATION CLIENT
	@GetMapping("/reclamation-list")
    public Iterable<Reclamation> getAll() {
		
		return reclamationService.findAll();
	}
	//ajouter reclamation
	@PostMapping("/reclamation-add")
	@ResponseBody
	    public  ResponseEntity<String> envoyerReclamation(@RequestBody Reclamation r) {
	         try {
	        	 reclamationService.envoyerReclamation(r);
				 return  new ResponseEntity("reclamation envoyée", HttpStatus.OK);
			} catch (ReclamationException e) {
				e.printStackTrace();
			}
	         return  new ResponseEntity("error add", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	//supprimer reclamation
	@DeleteMapping("/reclamation-delete")
	@ResponseBody
	public ResponseEntity<String> annulerReclamation(@RequestBody Reclamation r){
		try {
			reclamationService.annulerReclamationsClient(r);
	            return  new ResponseEntity("reclamation annulée", HttpStatus.OK);
		} catch (ReclamationException e) {
			e.printStackTrace();
		}
		return  new ResponseEntity("error delete", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	//modifier reclamation
	@PutMapping("/reclamation-update/{user-desc}/{user-type}")
	@ResponseBody
	public ResponseEntity<String> modifierReclamation(@RequestBody Reclamation r,
			@PathVariable("user-desc") String  description,
			@PathVariable("user-type") TypeReclamation  type){
		try {
<<<<<<< HEAD
			reclamationService.modifierReclamation(r, date, description, type);
=======
			reclamationService.modifierReclamation(r, new Date(), description, type);
>>>>>>> develop
	            return  new ResponseEntity("reclamation modifiée", HttpStatus.OK);
		} catch (ReclamationException e) {
			e.printStackTrace();
		}
		return  new ResponseEntity("error update", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@GetMapping("/reclamation-existe")
	@ResponseBody
    public ResponseEntity<String> existeReclamation(@RequestBody Reclamation r) {
		if(reclamationService.existeReclamation(r))
			return  new ResponseEntity("reclamation existe", HttpStatus.OK);
		return  new ResponseEntity("error existe", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	//RECLAMATION ADMIN
	@GetMapping("/reclamation-listAdmin")
    public Iterable<Reclamation> listReclamations() {	
		return reclamationService.ListReclamations();
	}
	//annuler reclamation
	@PostMapping("/reclamation-annulerAdmin")
	@ResponseBody
	    public  ResponseEntity<String> annulerReclamationAdmin(@RequestBody Reclamation r) throws ReclamationException {
	         if(reclamationService.annulerReclamation(r))
	        	 return  new ResponseEntity<String>("reclamation annulée", HttpStatus.OK);
	         return  new ResponseEntity<String>("error annuler admin", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	//valider reclamation
	@PostMapping("/reclamation-validerAdmin")
	@ResponseBody
	    public  ResponseEntity<String> validerReclamationAdmin(@RequestBody Reclamation r) throws ReclamationException {
	         if(reclamationService.validerReclamations(r))
	        	 return  new ResponseEntity<String>("reclamation validée", HttpStatus.OK);
	         return  new ResponseEntity<String>("error valider admin", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	//traiter reclamation
	@GetMapping("/reclamation-traiterAdmin")
	@ResponseBody
    public ResponseEntity<String>  traiterReclamationAdmin(@RequestBody Reclamation r) throws ReclamationException {	
		  if(reclamationService.TraiterReclamation(r))
	        	 return  new ResponseEntity<String>("reclamation traitée", HttpStatus.OK);
	         return  new ResponseEntity<String>("error traiter admin", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	//nbr reclamations
	@GetMapping("/reclamation-nbrRAdmin")
	public int nombreReclamations(){
		return reclamationService.NombreReclamations();
	}
	//afficher reclamation
	@GetMapping("/reclamation-reclamationAdmin/{admin-id}")
	@ResponseBody
	public Reclamation afficherReclamationAdmin(@PathVariable("admin-id") Long idr){
		Reclamation r=new Reclamation();
		r.setId(idr);
		return reclamationService.afficherReclamation(r);
	}
	//existe reclamation
	@GetMapping("/reclamation-existeAdmin")
	@ResponseBody
    public ResponseEntity<String> existeReclamationAdmin(@RequestBody Reclamation r) {
		if(reclamationService.existeReclamation(r))
			return  new ResponseEntity("reclamation existe", HttpStatus.OK);
		return  new ResponseEntity("error existe", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
