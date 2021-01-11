package com.example.demo.Repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Clientechange;
import com.example.demo.Entities.Echange;

@Repository
public interface EchangeRepository extends JpaRepository<Clientechange, Integer> {
	
	//lister mes echanges 
	
			@Query(value = "SELECT * FROM clientechange e WHERE e.id= :id and e.client1=client1" , nativeQuery =true)
			List<Clientechange> retrieveechangebyID(
					@Param("id") Integer id,
					@Param("client1")Integer client1);
			
//update titre 1 du client 1
			@Modifying
			@Query("update clientechange e set e.titre1 = :titre1 where e.id = :id and e.client1:=client1")
			Clientechange updateTitre1ById(
					@Param("id") Integer id,
					@Param("titre1")String titre1,
					@Param("client1")Integer client1);
			
//update client 1 confirmation
			@Modifying
			@Query("update clientechange e set e.client1confirmation = :client1confirmation where e.id = :id and e.client1:=client1 ")
			Clientechange updateById(
					@Param("client1confirmation") String client1confirmation,
					@Param("id")Integer id,
					@Param("client1") int client1);
			
			
//update titre 2 du client 2
			@Modifying
			@Query("update clientechange e set e.titre2 = :titre2 where e.id = :id and e.client2:=client2")
			Clientechange updateTitre2ById(
					@Param("id") Integer id,
					@Param("titre2")String titre2,
					@Param("client2")Integer client2);
			
//update statuchange
			
			@Modifying
			@Query("update echange e set e.statutechange = :statutechange where e.id = :id and e.clientechange:=clientechange")
			Echange updatestatut(
					@Param("statutechange") String statutechange,
					@Param("id")Integer id,
					@Param("clientechange")Integer clientechange);

}
