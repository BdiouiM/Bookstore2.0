package com.esprit.demo.service;

import java.util.List;

//import java.util.List;

import com.esprit.demo.entity.Client;
import com.esprit.demo.entity.User;


public interface InterfaceUserService {
	Client saveClient(Client client);
	//boolean saveUsers();
	List<User> getUsers();
	public User getUserById(long id);
	void deleteById(Long id);
	List<User> updateUser(List<User> user);
	List<Client> getClients();
	//User saveUsers(User u)
	boolean saveUsers(User u, Client c);
}
