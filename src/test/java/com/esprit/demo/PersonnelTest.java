package com.esprit.demo;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.demo.entity.Personnel;
import com.esprit.demo.service.AdminServiceImp;
import com.esprit.demo.service.PersonnelServiceImp;
import com.sun.el.parser.ParseException;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonnelTest {


	@Autowired
	PersonnelServiceImp servicePersonnel ;
		
		@Test
		public	void getAll() throws ParseException
			{
			boolean expected =true;
			
			Assert.assertEquals(expected, servicePersonnel.AllPersonnels());
			}
		@Test
		public	void get() throws ParseException
			{
		boolean expected =true;
				
		Assert.assertEquals(expected, servicePersonnel.GetUserById(3));
		
		
			}
		@Test
		public	void update() throws ParseException
			{
		boolean expected =true;
		Personnel personnel= new Personnel();
		personnel.setId(11);
		personnel.setAdresse("rue nj");
		personnel.setCin(712333);
		personnel.setEmail("mejrioumaima68@gmail.com");
		Assert.assertEquals(expected, servicePersonnel.updateBy(personnel));
			}
		@Test
		public	void delete() throws ParseException
			{
		boolean expected =true;
				long id=12;
		servicePersonnel.deleteById(id);
			}

}