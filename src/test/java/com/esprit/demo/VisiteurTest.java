package com.esprit.demo;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.demo.entity.Client;
import com.esprit.demo.service.ClientServiceImp;
import com.esprit.demo.service.VisiteurServiceUmp;
@RunWith(SpringRunner.class)
@SpringBootTest
public class VisiteurTest {
	@Autowired
	VisiteurServiceUmp serviceVisiteur ;
	@Test
	public void test() {
		boolean expected =true;
	Client c= new Client();
	c.setNom("mejri");
	c.setPrenom("oumaima");
	c.setUsername("ouamaima");
	c.setPassword("ssssss");
	c.setAdresse("79 Rue med fadhel");
	c.setCin(7663);
	c.setEmail("mejrioumaima68@gmail.com");
	Assert.assertEquals(expected, serviceVisiteur.AjouterVisiteur(c));
	}

}
