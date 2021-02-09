package com.esprit.demo.controller;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import com.esprit.demo.entity.Personnel;
import com.esprit.demo.repository.PersonnelRepository;
import com.esprit.demo.service.PersonnelServiceImp;

import antlr.collections.List;

@Controller
@RestController
@RequestMapping("/personnelController")
public class PersonnelController {
	//private static final Logger L=LogManager.getLogger(UserServiceImp.class);
		@Autowired
	private PersonnelServiceImp ser ;
	
	 @GetMapping("/personnel")
	    public Iterable<Personnel> findAllPersonnels() {
		 
	        return ser.AllPersonnels();
	    }
	 @GetMapping("/personnelById/{id}")
	    public Optional<Personnel> findUserById(@PathVariable long id) {
	        return ser.GetUserById(id);
	    }
	 @PostMapping("/addpersonnel")
	    public Personnel add(@RequestBody Personnel personnel) {
		 
	        return ser.addPersonnel(personnel);
	    }
	  @PutMapping("/updatepersonnel/{id}")
	   // @RequestMapping(value = {"/mise/{id}"}, method = RequestMethod.PUT)
	    public Boolean update(@PathVariable long id, @RequestBody Personnel personnel)
	    {
		  Optional<Personnel> optionalPersonnel=ser.GetUserById(id);
		  if(optionalPersonnel.isPresent()) 
		  {			  
	    	 ser.updateBy(personnel);
	    	 return true;
	    	}
		  return false;
	    }
	  @RequestMapping( value = "/del/{id}", method = RequestMethod.DELETE)
	    public boolean delete(@PathVariable Long id)
	    {
		  Optional<Personnel> optionalPersonnel=ser.GetUserById(id);
		  if(optionalPersonnel.isPresent()) 
		  {	
		  ser.deleteById(id);
		  return true;
		  }
		else  return false;
	    }
	  
	
}
