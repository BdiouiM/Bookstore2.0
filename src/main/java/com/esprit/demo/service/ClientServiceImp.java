package com.esprit.demo.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.demo.entity.Client;
import com.esprit.demo.entity.Personnel;
import com.esprit.demo.repository.ClientRepository;

@Service
public class ClientServiceImp implements InterfaceClientService{
	@Autowired
	ClientRepository clientRepository;
	@Override
	public Iterable<Client> AllClient() {
		
		return clientRepository.findAll();
	}

	@Override
	public Optional<Client> GetClientById(long id) {
		
		return clientRepository.findById(id);
	}

	@Override
	public Client addClient(Client client) {
		
		return clientRepository.save(client);
	}
	
	public void deleteById(Long id) {
		 clientRepository.deleteById(id);
		
	}
	public Boolean updateBy(Client client)
    {
	 	// clientRepository.updateClientById(client.getId());
	 	 clientRepository.save(client);
	    	 return true;
    }
	
}
