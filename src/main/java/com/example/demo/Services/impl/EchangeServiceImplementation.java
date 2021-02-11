package com.example.demo.Services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Clientechange;
import com.example.demo.Entities.Echange;
import com.example.demo.Repositories.EchangeClientRreposiitory;
import com.example.demo.Repositories.EchangeRepository;
import com.example.demo.Services.EchangeService;



@Service
@Transactional
public class EchangeServiceImplementation implements EchangeService {
	
		@Autowired
		EchangeClientRreposiitory echangeRrepository;
        @Autowired
        EchangeRepository ER;
        
        @Override		
public boolean ajoutEchange(Clientechange CE) {
        	boolean res = true ;
			try{
				echangeRrepository.save(CE);
				System.out.println(CE.getId());
				Echange a=new Echange();
				a.setClientechange(CE.getId());
				a.setStatutechange("waiting");
				ER.save(a);
				res = true ; 
				}
			catch(Exception e)
			{
				res = false ;
			}
			return res ; 
		}
        
		@Override
		public Integer updateTitre1Echange(int id, int client1, String titre1) {
			return echangeRrepository.updateTitre1Echange(id,client1,titre1);
		}
		
		@Override
		public Integer updateClient1Confirmation(int id, int client1, String client1confirmation) {
			return echangeRrepository.updateclien1confirmationEchang(id, client1, client1confirmation);
		}

		@Override
		public Integer updateClientEchange(int id, int client2, String titre2) {
			return echangeRrepository.updateclientEchange(id,client2,titre2);
		}

		@Override
		public Integer AnnulerClientEchange(int id) {
			return echangeRrepository.AnnulerClientEchange(id);
		}
		
		public List<Clientechange> getechanges() {
			return echangeRrepository.findAll();
		}

		@Override
		public List<Clientechange> getAllEchangeByCIN(int client1) {
		 List<Clientechange> ResList = getechanges();
		 List<Clientechange> liste=new ArrayList<>();
		 if(ResList.isEmpty()){
			 liste=null ;
			return  liste ;
		 }else{ 
			for(Clientechange l: ResList){
				if(l.getClient1().equals(client1))
					liste.add(l);
			}
			return liste;
		 }
		}

		
}
