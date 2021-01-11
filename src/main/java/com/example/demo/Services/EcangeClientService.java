package com.example.demo.Services;

import com.example.demo.Entities.Clientechange;
import com.example.demo.Entities.Echange;

public interface EcangeClientService {
	
	public void  ajoutEchange(Echange E, Clientechange CE);
	public void confirmerechangeclient1(Echange E,Clientechange CE);
	public void anulerEchange(Echange E,Clientechange CE);
	public void mesechanges(Echange E,Clientechange CE);
	public void pointerEchange(Echange E,Clientechange CE);
	
	
	

}
