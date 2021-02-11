package com.esprit.demo;
import static org.junit.Assert.*;
import org.junit.Test;
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
import com.esprit.demo.entity.Personnel;
import com.esprit.demo.service.AdminServiceImp;
import com.esprit.demo.service.ClientServiceImp;
import com.sun.el.parser.ParseException;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminTest {

	@Autowired
	AdminServiceImp serviceAdmin ;
		@Test
		public	void add() throws ParseException
			{
		boolean expected =true;
		Personnel per= new Personnel();
		per.setNom("mejri");
		per.setPassword("oumaimaMejri");
		per.setPrenom("oumaima");
		per.setAdresse("79 street hlif");
		per.setCin(12356789);
		per.setEmail("mejrioumaima68@gmail.com");
		per.setSalaire(3000);
		per.setPoste("IT");
		Assert.assertEquals(expected, serviceAdmin.addPersonnel(per));
	
			}
		@Test
		public	void getAll() throws ParseException
			{
			boolean expected =true;
			
			Assert.assertEquals(expected, serviceAdmin.AllPersonnels());
			}
		@Test
		public	void get() throws ParseException
			{
		boolean expected =true;
				
		Assert.assertEquals(expected, serviceAdmin.GetUserById(3));
		
		
			}
		@Test
		public	void update() throws ParseException
			{
		boolean expected =true;
		Personnel personnel= new Personnel();
		personnel.setId(11);
		personnel.setAdresse("jkslsl");
		personnel.setCin(712333);
		personnel.setEmail("mejrioumaima68@gmail.com");
		Assert.assertEquals(expected, serviceAdmin.updateBy(personnel));
			}
		@Test
		public	void delete() throws ParseException
			{
		boolean expected =true;
				long id=12;
		serviceAdmin.deleteById(id);
			}

}
