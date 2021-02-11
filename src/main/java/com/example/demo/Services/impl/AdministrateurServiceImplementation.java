package com.example.demo.Services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Echange;
import com.example.demo.Repositories.AdminRepository;
import com.example.demo.Services.EchangeAdministrateurService;

@Service
@Transactional
public class AdministrateurServiceImplementation implements EchangeAdministrateurService {
	@Autowired
	AdminRepository adminRepository;

	public List<Echange> getAllEchange() {
		return (List<Echange>) adminRepository.findAll();
	}

	public Echange getEchangeById(int id) {
		return adminRepository.findById(id).get();
	}
	
	@Override
	public Integer deleteEchangeById(int id) {
		int resultat = 0;
		System.out.println();
		int idClientEchange = adminRepository.findById(id).get().getClientechange();				
		int DeleteEchange = adminRepository.deleteechange(id);
		int DeleteClientEchange = adminRepository.deleteClientechange(idClientEchange);
		if((DeleteEchange>0)&&(DeleteClientEchange>0)){
			resultat =1;
		}else{
			resultat =0;
		}
		return resultat ;
	}

	@Override
	public Integer updatestatut(int id, int clientechange) {
		// TODO Auto-generated method stub
		return adminRepository.updatestatute(id, clientechange);
	}

}
