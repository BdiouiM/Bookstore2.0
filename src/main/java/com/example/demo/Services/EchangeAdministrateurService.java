package com.example.demo.Services;


import com.example.demo.Entities.Echange;
import java.util.*;

public interface EchangeAdministrateurService {
	
	public List<Echange> getAllEchange();
	public Echange getEchangeById (int id );
	public Integer deleteEchangeById(int id);
	public Integer updatestatut(int id ,int clientechange);
}
