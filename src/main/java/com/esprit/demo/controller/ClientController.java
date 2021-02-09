package com.esprit.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.esprit.demo.entity.Client;
import com.esprit.demo.entity.Personnel;
import com.esprit.demo.service.ClientServiceImp;
@Controller
@RestController
@RequestMapping("/clientController")
public class ClientController {
	@Autowired
	private ClientServiceImp service ;
	@GetMapping("/client")
    public Iterable<Client> findAllClients() {
	 
        return service.AllClient();
    }
 @GetMapping("/clientById/{id}")
    public Optional<Client> findUserById(@PathVariable long id) {
        return service.GetClientById(id);
    }
 @PostMapping("/addClient")
    public Client add(@RequestBody Client client) {
	 
        return service.addClient(client);
    }
 @PutMapping("/updateClient/{id}")
 // @RequestMapping(value = {"/mise/{id}"}, method = RequestMethod.PUT)
  public Boolean update(@PathVariable long id, @RequestBody Client client)
  {
	  Optional<Client> optionalClient=service.GetClientById(id);
	  if(optionalClient.isPresent()) 
	  {			  
  	 service.updateBy(client);
  	 return true;
  	}
	  return false;
  }
@RequestMapping( value = "/delete/{id}", method = RequestMethod.DELETE)
  public boolean delete(@PathVariable Long id)
  {
	  Optional<Client> optionalClient=service.GetClientById(id);
	  if(optionalClient.isPresent()) 
	  {	
	  service.deleteById(id);
	  return true;
	  }
	else  return false;
  }

}
