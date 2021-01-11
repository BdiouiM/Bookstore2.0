/*package com.example.demo;

//import com.example.demo.Controllers.EchangeController;
import com.example.demo.Entities.Clientechange;
import com.example.demo.Entities.Echange;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private EchangeController EC ;
    @Test
    void addEchange() {
        // ma7atitch Client 2 w titre 2 5ater athoukom bch ykamlou echange ba3ed so fl base normalement tal9ahom NULL

        Clientechange Ce = new Clientechange();
        Ce.setId(11);  // you have an autoincrement ID so u don't need to set it
        Ce.setClient1(1);
        Ce.setClient1Confirmation("Waiting");
        Ce.setTitre1("Hacker");
        Echange E = new Echange();
        E.setId(1); // you have an autoincrement ID so u don't need to set it
        E.setClientechange(11);
        E.setStatutechange("Waiting");
        assertEquals(true,EC.ajoutEchange(E,Ce));
    }
    @Test
    void annulerEchange() {
        // ma7atitch Client 2 w titre 2 5ater athoukom bch ykamlou echange ba3ed so fl base normalement tal9ahom NULL

        Clientechange Ce = new Clientechange();
        Ce.setId(11);  // you have an autoincrement ID so u don't need to set it
        Ce.setClient1(1);
        Ce.setClient1Confirmation("Waiting");
        Ce.setTitre1("waiting");
        Echange E = new Echange();
        E.setId(1); // you have an autoincrement ID so u don't need to set it
        E.setClientechange(11);
        E.setStatutechange("Waiting");
        assertEquals(true,EC.ajoutEchange(E,Ce));
    }


}*/
