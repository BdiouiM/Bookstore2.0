package com.esprit.demo.controller;



import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.demo.entity.Client;
import com.esprit.demo.entity.Personnel;
import com.esprit.demo.entity.User;
import com.esprit.demo.service.PersonnelServiceImp;
import com.esprit.demo.service.UserServiceImp;
import com.mysql.cj.Session;
@Controller
@RestController
//@CrossOrigin("*")
@RequestMapping("/userController")
public class UserControl {
/*	
	@Autowired
	private PersonnelServiceImp ser ;
	@PostMapping("/addPersonnel")
    public Personnel addPersonnel(@RequestBody Personnel personnel) {
        return ser.savePersonnel(personnel);
    }
	@GetMapping("/Personnel")
	    public List<Personnel> findAllPersonnel() {
	        return ser.getPersonnel();
	    }*/
	
	/*@Autowired
	private UserServiceImp service ;
	 @PostMapping("/addClient")
	    public Client addClient(@RequestBody Client client) {
	        return service.saveClient(client);
	    }
	     @PostMapping("/addUsers")
	    public boolean addUsers(User u, Client c) {
	        return service.saveUsers(u, c);
	    }
	    @PostMapping("/addClient")
	    public Client addClient(@RequestBody Client client) {
	        return service.saveClient(client);
	    }
	     @GetMapping("/clients")
	    public List<Client> findAllClients() {
	        return service.getClients();
	    }
	 @GetMapping("/clients")
	    public List<Client> findAllClients() {
	        return service.getClients();
	    }
	 @PostMapping("/addUsers")
	    public boolean addUsers(User u, Client c) {
	        return service.saveUsers(u, c);
	    }
	 @GetMapping("/users")
	    public List<User> findAllUsers() {
	        return service.getUsers();
	    }

	    @GetMapping("/userById/{id}")
	    public User findUserById(@PathVariable long id) {
	        return service.getUserById(id);
	    }
	  
	    @RequestMapping( value = "/del/{id}", method = RequestMethod.DELETE)
	    public void delete(@PathVariable Long id)
	    {

	        service.deleteById(id);
	    }
	    @RequestMapping(value = {"/mise"}, method = RequestMethod.PUT)
	    public void update(@RequestBody List<User> user)
	    {
	    	service.updateUser(user);
	    }*/
}
