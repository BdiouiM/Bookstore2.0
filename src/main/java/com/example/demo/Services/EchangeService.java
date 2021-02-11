package com.example.demo.Services;

import java.util.List;
import com.example.demo.Entities.Clientechange;


public interface EchangeService {
	
    public boolean ajoutEchange(Clientechange CE);
    public Integer updateTitre1Echange(int id,int client1,String titre1);
    public Integer updateClient1Confirmation(int id,int client1,String client1confirmation);
    public Integer updateClientEchange(int id,int client2,String titre2);
    public Integer AnnulerClientEchange(int id);  
    public List<Clientechange>getAllEchangeByCIN(int client1);
    
}
