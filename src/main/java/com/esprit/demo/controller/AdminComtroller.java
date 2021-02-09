
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
	import com.esprit.demo.entity.Personnel;
import com.esprit.demo.entity.User;
import com.esprit.demo.service.AdminServiceImp;
import com.esprit.demo.service.SendMailService;
	@Controller
	@RestController
	@RequestMapping("/adminController")
	public class AdminComtroller {
		//private static final Logger L=LogManager.getLogger(UserServiceImp.class);
		@Autowired
		private AdminServiceImp service ;
			@Autowired
			private SendMailService sendMail ;
			
		 @GetMapping("/getAdmin")
		    public Iterable<Personnel> findAllPersonnels() {
			 
		        return service.AllPersonnels();
		    }
		 @GetMapping("/AdminById/{id}")
		    public Optional<Personnel> findUserById(@PathVariable long id) {
		        return service.GetUserById(id);
		        
		        		    }
		 @PostMapping("/addAdmin")
		    public Personnel add(@RequestBody Personnel personnel) throws Exception{
			 sendMail.send(personnel.getEmail(),"mejrioumaima68","Welcome, Complete registration!"+personnel.getUsername());
		        return service.addPersonnel(personnel);
		        
		    }
		  @PutMapping("/updateAdmin/{id}")
		   // @RequestMapping(value = {"/mise/{id}"}, method = RequestMethod.PUT)
		    public Boolean update(@PathVariable long id, @RequestBody Personnel personnel)
		    {
			  Optional<Personnel> optionalPersonnel=service.GetUserById(id);
			  if(optionalPersonnel.isPresent()) 
			  {			  
		    	 service.updateBy(personnel);
		    	 return true;
		    	}
			  return false;
		    }
		  @RequestMapping( value = "/deleteAdmin/{id}", method = RequestMethod.DELETE)
		    public boolean delete(@PathVariable Long id)
		    {
			  Optional<Personnel> optionalPersonnel=service.GetUserById(id);
			  if(optionalPersonnel.isPresent()) 
			  {	
			  service.deleteById(id);
			  return true;
			  }
			else  return false;
		    }
		public SendMailService getSendMail() {
			return sendMail;
		}
		public void setSendMail(SendMailService sendMail) {
			this.sendMail = sendMail;
		}
		  
		
	

}
