package bookstore.controll;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import bookstore.entities.GenreLivre;
import bookstore.entities.Livre;
import bookstore.exception.LivreException;
import bookstore.service.Impl.LivreImpl;

@RequestMapping("/livre")
@RestController
public class LivreController {
	@Autowired
    private LivreImpl livreService;
	@GetMapping("/livre-welcome")
	public String start(){return "Weclome to livre";}
	// Livre CLIENT
	@GetMapping("/livre-list")
    public Iterable<Livre> getAll() {
		
		return livreService.findAll();
	}
	
	
	//existe livre
		@GetMapping("/livre-existeClient")
		@ResponseBody
	    public ResponseEntity<String> existeLivreClient(@RequestBody Livre L) {
			if(livreService.existeLivre(L))
				return  new ResponseEntity("livre existe", HttpStatus.OK);
			return  new ResponseEntity("error ", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	
	//Livre ADMIN
	@GetMapping("/livre-listAdmin")
    public Iterable<Livre> listLivres() {	
		return livreService.ListLivres();
	}
	
	//afficher livre
	@GetMapping("/livre-livreAdmin/{admin-id}")
	@ResponseBody
	public Livre afficherLivreAdmin(@PathVariable("admin-id") Long idr){
		Livre L=new Livre();
		L.setId(idr);
		return livreService.afficherLivre(L);
	}
	//existe livre
	@GetMapping("/livre-existeAdmin")
	@ResponseBody
    public ResponseEntity<String> existeLivreAdmin(@RequestBody Livre L) {
		if(livreService.existeLivre(L))
			return  new ResponseEntity("livre existe", HttpStatus.OK);
		return  new ResponseEntity("error ", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	//supprimer livre
		@DeleteMapping("/livre-delete")
		@ResponseBody
		public ResponseEntity<String> supprimerLivre(@RequestBody Livre L){
			
				try {
					livreService.supprimerLivre(L);
		            return  new ResponseEntity("livre supprimé", HttpStatus.OK);

				} catch (LivreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		            return  new ResponseEntity("error delete", HttpStatus.OK);
			
		}
		//modifier livre
		@PutMapping("/livre-update/{user-date}/{user-desc}/{user-type}")
		@ResponseBody
		public ResponseEntity<String> modifierLivre(@RequestBody Livre L,@PathVariable("user-auteur") String auteur,
				@PathVariable("user-genre") GenreLivre genre,@PathVariable("user-nbrPages") int nbrPages, @PathVariable("user-prix") float prix, @PathVariable("user-titre") String titre){
			
				try {
					livreService.modifierLivre(L, auteur, genre,nbrPages, prix, titre);
		            return  new ResponseEntity("livre modifiée", HttpStatus.OK);

				} catch (LivreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			return  new ResponseEntity("error update", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		//ajouter livre
		@PostMapping("/livre-add")
		@ResponseBody
		    public  ResponseEntity<String> ajouterLivre(@RequestBody Livre L) {
		       
		        	 try {
						livreService.ajouterLivre(L);
						 return  new ResponseEntity("livre ajouté", HttpStatus.OK);

					} catch (LivreException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					};
				
		         return  new ResponseEntity("error add", HttpStatus.INTERNAL_SERVER_ERROR);
		    }

}
