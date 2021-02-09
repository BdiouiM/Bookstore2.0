package com.esprit.demo;

import static org.junit.Assert.*;

import org.aspectj.weaver.ExposeTypeMunger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.demo.entity.Client;
import com.esprit.demo.service.ClientServiceImp;
@SpringBootTest
public class t {
	@Autowired
	ClientServiceImp service ;
	

	@Test
	
	
	public	void add()
			{
		Client c= new Client();
		c.setAdresse("jkslsl");
		c.setCin(7663);
		c.setEmail("mejrioumaima68@gmail.com");
		assertEquals(false,service.addClient(c));
	
			}

}
