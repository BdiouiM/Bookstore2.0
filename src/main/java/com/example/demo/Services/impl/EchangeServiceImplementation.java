package com.example.demo.Services.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Clientechange;
import com.example.demo.Repositories.AdminRepository;
import com.example.demo.Repositories.EchangeRreposiitory;
import com.example.demo.Services.EchangeService;

@Service
@Transactional
public class EchangeServiceImplementation implements EchangeService {
		@Autowired
		EchangeRreposiitory echangeRrepository;

		public void ajoutEchange(Clientechange CE) {
			echangeRrepository.save(CE);
		}

		public void updateTitre1Echange(int id, int client1, String titre1) {
			echangeRrepository.updateTitre1Echang(id,client1,titre1);
		}

		public void updateTitre2Echange(int id, int client2, String titre2) {
			echangeRrepository.updateTitre1Echang(id,client2,titre2);
		}

		public void updateClient1Confirmation(int id, int client1, String cliet1confirmation) {
			echangeRrepository.updateclien1confirmationEchang(id,client1,cliet1confirmation);
			
		}
		
		

		
			
		

		
		
		

	

}
