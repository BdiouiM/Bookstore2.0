package com.example.demo.Services;

import com.example.demo.Entities.Clientechange;
import com.example.demo.Entities.Echange;
import java.util.*;

public interface EchangeAdministrateurService {
	
	public List<Echange> getAllEchange();
	public Echange getEchangeById (int id );
	public void updateStatutEchange(int id,String statutechange);
	public void deleteEchangeById(int id);
	
}
