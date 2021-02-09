package com.esprit.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.esprit.demo.entity.Personnel;
import com.esprit.demo.entity.User;
import com.esprit.demo.repository.PersonnelRepository;
@Service
public class PersonnelServiceImp implements InterfacePersonnelService{
	@Autowired
	PersonnelRepository personnelRepository;
	@Override
	  public Iterable<Personnel> AllPersonnels() {			 
	        return personnelRepository.findAll();
	    }
	@Override
	  public Optional<Personnel> GetUserById(long id) {
	        return personnelRepository.findById(id);
	    }
	
	@Override
	public void deleteById(Long id) {
		personnelRepository.deleteById(id);
		
	}
	@Override
	public Personnel addPersonnel(Personnel personnel) {
		return personnelRepository.save(personnel);
	}
	
	
	public Boolean updateBy(Personnel personnel)
    {
	 	  
    	 personnelRepository.save(personnel);
    	 return true;
    }
	}
