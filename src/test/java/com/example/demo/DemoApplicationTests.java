package com.example.demo;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demo.Controllers.EchangeController;
import com.example.demo.Entities.Clientechange;



@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests  {

    @Autowired
    private EchangeController EC ;
    
    @Test
    public void addUserCorrectForm() {
    	Clientechange U=new Clientechange();
    	U.setClient1(2);
    	U.setTitre1("Le Petit Prince");
    	assertTrue(EC.ajoutechangeClient(U));
	}
   @Test
 public void updateTitre1CorrectForm(){
	   
	   assertTrue(EC.updateTitre1(13, "Hello", 2));
 }
   @Test
   public void updateClient1ConfirmationCorrectForm(){
	   int id = 18 ; 
	   int clientid = 2 ;
	   assertTrue(EC.updateClientconfirmation(id, clientid));
   }
   
   @Test
   public void updateClient2CorrectForm(){
	   assertTrue(EC.updateClientEchange(4, "AhmedDridi", 2));
   }
   @Test
   public void annulerechangeCorrectForm(){
	   assertTrue(EC.annulerClientEchange(4));
   }
   @Test
   public void deleteEchangeAdmin(){
	   int tmp = EC.deleteEchangeA(11);
	   assertEquals(1, tmp);
   }
  
   @Test
   public void updateStatutAdminCorrectForm(){
	   assertTrue(EC.updatestatutAdmin(1,1));
   }
   
}
