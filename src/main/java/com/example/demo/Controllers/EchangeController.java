package com.example.demo.Controllers;

//import com.example.demo.Entities.Clientechange;
import com.example.demo.Entities.Echange;
//import com.example.demo.Repositories.ClientEchangeRepository;
import com.example.demo.Repositories.EchangeRepository;
import com.example.demo.Services.EchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/*@RestController
@RequestMapping("/echange")
//aamalna Impelementation ll methode te3 Service Te3na
// for case te3na juste aamalt ken Ajout
// bch tzid go To Services->EchangeService w ajouti ay Method 8adi ba3ed implementeha lenna
public class EchangeController implements EchangeService {

     @Autowired
     private EchangeRepository ER ;
     @Autowired
     private ClientEchangeRepository CER ;
    @PostMapping("/ajoutEchange")
    public boolean ajoutEchange(@RequestBody Echange E,@RequestBody Clientechange Ce) {
        
        try{
            // for this Case a7na andna double Insertion
            // sabina ClientEchange( li heya andek Lignechange 9bal ) 5ater feha Clé primaire bch ymchi
            // ll table Echange
            // ken sabina Echange 9bal bch taamlk Erreur t9olk ClientEchangeID mafamesh f table
             CER.save(Ce);
             ER.save(E);
             return true;
        }catch (Exception EE){
            System.out.println(EE.getMessage());
            return  false ;
        }
    }
}*/
