package com.example.demo.Services;

import com.example.demo.Entities.Clientechange;
import com.example.demo.Entities.Echange;

public interface EchangeService {
	
    public void  ajoutEchange(Clientechange CE);
    public void updateTitre1Echange(int id,int client1,String titre1);
    public void updateTitre2Echange(int id,int client2,String titre2);
    public void updateClient1Confirmation(int id,int client2,String cliet1confirmation);
    
}
