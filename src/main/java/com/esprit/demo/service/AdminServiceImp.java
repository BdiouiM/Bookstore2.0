package com.esprit.demo.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esprit.demo.entity.Personnel;
import com.esprit.demo.repository.AdminRepository;

	@Service
	public class AdminServiceImp implements InterfaceAdminService{
		@Autowired
		AdminRepository adminRepository;
		@Override
		  public Iterable<Personnel> AllPersonnels() {			 
		        return adminRepository.findAll();
		    }
		@Override
		  public Optional<Personnel> GetUserById(long id) {
		        return adminRepository.findById(id);
		    }
		
		@Override
		public void deleteById(Long id) {
			adminRepository.deleteById(id);
			
		}
		@Override
		public Personnel addPersonnel(Personnel personnel) {
			return adminRepository.save(personnel);
		}
		public Boolean updateBy(Personnel personnel)
	    {
		 	  
	    	 adminRepository.save(personnel);
	    	 return true;
	    }
		}

