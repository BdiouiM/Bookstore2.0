package com.esprit.demo;
import org.junit.Assert;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

import org.aspectj.weaver.ExposeTypeMunger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.demo.entity.Client;
import com.esprit.demo.service.ClientServiceImp;
import com.sun.el.parser.ParseException;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientTest {
	@Autowired
	ClientServiceImp service ;
		@Test
		public	void add() throws ParseException
			{
		boolean expected =true;
		Client c= new Client();
		c.setNom("mejri");
		c.setPassword("aymennnajjz");
		c.setPrenom("oumaima");
		c.setUsername("oumaima");
		c.setAdresse("jkslsl");
		c.setCin(7663);
		c.setEmail("mejrioumaima68@gmail.com");
		Assert.assertEquals(expected, service.addClient(c));
	
			}
		@Test
		public	void get() throws ParseException
			{
		boolean expected =true;
				
		Assert.assertEquals(expected, service.GetClientById(15));
		
		
			}
		@Test
		public	void update() throws ParseException
			{
		boolean expected =true;
		Client c= new Client();
		c.setId(23);
		c.setAdresse("jkslsl");
		c.setCin(7663);
		c.setEmail("ima68@gmail.com");
		Assert.assertEquals(expected, service.updateBy(c));	
			}
		@Test
		public	void delete() throws ParseException
			{
		boolean expected =false;
				long id=13;
		service.deleteById(id);
			}
		

}