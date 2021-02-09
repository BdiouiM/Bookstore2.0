package com.esprit.demo.service;

import java.util.Optional;

import com.esprit.demo.entity.Client;

public interface InterfaceClientService {
	Iterable<Client> AllClient();
	Optional<Client> GetClientById(long id);
	Client addClient(Client client);
}
