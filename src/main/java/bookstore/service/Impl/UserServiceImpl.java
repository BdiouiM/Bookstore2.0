package bookstore.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
<<<<<<< HEAD
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
=======
import java.util.stream.Collectors;
>>>>>>> develop
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bookstore.entities.Livre;
import bookstore.entities.Reclamation;
import bookstore.entities.StatutReclamation;
import bookstore.entities.TypeReclamation;
import bookstore.entities.User;
import bookstore.exception.ReclamationException;
import bookstore.exception.StockException;
import bookstore.repository.ReclamationRepository;
import bookstore.repository.StockRepository;
import bookstore.repository.UserRepository;
import bookstore.service.ReclamationAdminService;
import bookstore.service.ReclamationClientService;
import bookstore.service.StockService;
import bookstore.service.UserService;

import org.apache.logging.log4j.*;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	private static final Logger L = LogManager.getLogger(UserServiceImpl.class);
	@Override
	public User findByUsernameOrEmail(String usernameOrEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
