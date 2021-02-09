package com.esprit.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.demo.entity.Client;
import com.esprit.demo.repository.VisiteurRepository;
@Service
public class VisiteurServiceUmp implements InterfaceVisiteurService{
	@Autowired
	VisiteurRepository visiteurRepository;
	
	@Override
	public Client AjouterVisiteur(Client c) {
		return visiteurRepository.save(c);
	}

}
