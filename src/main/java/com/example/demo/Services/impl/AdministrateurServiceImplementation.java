package com.example.demo.Services.impl;

import java.util.List;

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

	public void updateStatutEchange(int id, String statutechange) {
		adminRepository.updateStatutEchang(id, statutechange);
	}

	public void deleteEchangeById(int id) {
		adminRepository.deleteById(id);
	}

}
