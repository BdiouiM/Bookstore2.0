package com.example.demo.Controllers;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.Clientechange;
import com.example.demo.Entities.Echange;
import com.example.demo.Entities.Utilisateur;
import com.example.demo.Repositories.AdminRepository;
import com.example.demo.Repositories.EchangeClientRreposiitory;
import com.example.demo.Repositories.UtilisateurRepository;
import com.example.demo.Services.EchangeAdministrateurService;
import com.example.demo.Services.EchangeService;
import com.example.demo.Services.impl.AdministrateurServiceImplementation;
import com.example.demo.Services.impl.EchangeServiceImplementation;

@RestController
@RequestMapping("/echange")
public class EchangeController {

	@Autowired
	EchangeService echangeService;
	@Autowired
	public EchangeServiceImplementation ESI;
    @Autowired
    EchangeClientRreposiitory ER;
    
    @Autowired
    AdminRepository AD;
	@Autowired
	public AdministrateurServiceImplementation ASI;
	@Autowired
    private EchangeAdministrateurService echangeAdministrateurService;
    @Autowired
    UtilisateurRepository UR ; 

   /*********************Client*****************************************************************/ 
    @GetMapping("/meEchanges")  
    public List<Clientechange>meechange(@RequestParam("client1") int client1){
    	return ESI.getAllEchangeByCIN(client1);
    }

	@GetMapping("/getAllechanges")
	public List<Clientechange>getAllClientEchange(){
		return ESI.getechanges();
	}
	
	@GetMapping("/clientEchange")
	public List<Clientechange>getEchangeClient(){
		return ER.findAll();
	}
	@PostMapping("/updateTitre1")
	public boolean updateTitre1(@RequestParam(name = "id")int id,@RequestParam(name = "titre1")String titre1,@RequestParam(name = "client1")int client1){
		if(ESI.updateTitre1Echange(id, client1, titre1)>0){
			return true;
		}else{
			return false ;
		}
	}
	
	@PostMapping("/updateClientEchange")
	public boolean updateClientEchange(@RequestParam(name = "id")int id,@RequestParam(name = "titre2")String titre2,@RequestParam(name = "client2")int client2){
		if(ESI.updateClientEchange(id, client2, titre2)>0){
			
			return true;
		}else {
			return false ;
		}
	}
	
	@RequestMapping(value="/ajoutClientEchange",method=RequestMethod.POST)
	public
	 boolean ajoutechangeClient(@RequestBody Clientechange E){
		return ESI.ajoutEchange(E);
	}
	
	@PostMapping("/updateClientConfirmation")
	public boolean updateClientconfirmation(@RequestParam(name="id")int id,@RequestParam(name="client1") int client1){
		String ClientConfirmation ="Valide";
		if(ESI.updateClient1Confirmation(id, client1, ClientConfirmation)>0){
			return true ;
		}else{
			return false; 
		}
	}
	
	@PostMapping("/annulerCE")
	public boolean annulerClientEchange(@RequestParam("id") int id){
		if(ESI.AnnulerClientEchange(id)>0){
			return true;
		}else return false; 
	}
	
	@GetMapping("getEchangeClient")
	public List<Clientechange> getechangeclient(@RequestParam("client1") int client1){
		return ESI.getAllEchangeByCIN(client1);
	}
	/***********************admin**************************************************/
	@GetMapping("/echange-list")
	public List<Echange> getAllEchange(){
		return echangeAdministrateurService.getAllEchange();
	}
	
	@GetMapping("/echangeById/{id}")
	public Echange getEchangeById(@PathVariable("id")int id){
		return echangeAdministrateurService.getEchangeById(id);
	}
	
	@PostMapping("/deleteEchangeA")
	public Integer deleteEchangeA(@RequestParam("id")Integer Id){
		return ASI.deleteEchangeById(Id);
	}
	
	@PostMapping("/updatestatut")
	public boolean updatestatutAdmin(@RequestParam(name="id")int id,@RequestParam(name="clientechange") int clientechange){
		if(ASI.updatestatut(id, clientechange)>0){
			return true ;
		}else{
			return false; 
		}
	}
	
	/*************************User***********************************************/
    @GetMapping("/getClients")
    public List<Utilisateur> getClient(){
    	return UR.findAll();
    }
	}

