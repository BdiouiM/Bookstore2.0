package com.esprit.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.demo.entity.Client;
import com.esprit.demo.entity.User;
import com.esprit.demo.repository.ClientRepository;
import com.esprit.demo.repository.UserRepository;
import com.mysql.cj.Session;
@Service
@Transactional
public class UserServiceImp implements InterfaceUserService {
	
		@Autowired
		ClientRepository ClientRepo; 

	@Override
	public Client saveClient(Client client) {
		return ClientRepo.save(client);
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> updateUser(List<User> user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> getClients() {
		 return ClientRepo.findAll();
	}

	@Override
	public boolean saveUsers(User u, Client c) {
		// TODO Auto-generated method stub
		return false;
	}
	/*@Autowired
UserRepository<User> UserRepo;
	@Autowired
	ClientRepository ClientRepo; 

private static final Logger L=LogManager.getLogger(UserServiceImp.class);


@Override
public Client saveClient(Client client) {
	 return ClientRepo.save(client);
}

@Override
public List<Client> getClients() {
	 return ClientRepo.findAll();	 
}

public boolean saveUsers(User u, Client c) {
	User u = new User();
	Client C = new Client();
	u.setAdresse("aaa");
	u.setCin(21521);
	u.setEmail("XXXX");
	u.setNom("mejri");
	u.setPrenom("oumaima");
	u.setRole("Client");
	u.setUsername("oumaima");
	u.setPassword("ouma");
	C.setType("ABCD");
	C.setUser(u);
	try{
	UserRepo.save(u);
	ClientRepo.save(c);
	return true ;
	}catch(Exception E){System.out.println(E.getMessage());return false ;}
}


@Override
public List<User> getUsers() {
	 return UserRepo.findAll();
	 
}


@Override
public User getUserById(long id) {
	return UserRepo.findById(id).orElse(null);
}

@Override
public void deleteById(Long id) {
	UserRepo.deleteById(id);	
}


@Override
public List<User> updateUser(List<User> user) {
	 return UserRepo.saveAll(user);
}

@Override
public User saveUsers(User u) {
	return UserRepo.save(u);
}


@Override
public boolean saveUsers(User u, Client c) {
	try{
		UserRepo.save(u);
		ClientRepo.save(c);
		return true ;
		}catch(Exception E){System.out.println(E.getMessage());return false ;}
}*/
}



