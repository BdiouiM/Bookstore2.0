package com.example.demo.Repositories;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entities.Clientechange;
import com.example.demo.Entities.Echange;
import com.example.demo.Services.EchangeService;

public interface EchangeRreposiitory extends JpaRepository<Clientechange, Integer> {
	@Modifying
	@Query("update clientechange c set c.titre1 = :titre1 where c.id = :id and c.cin1=id")
	void updateTitre1Echang(@Param(value = "id") Integer id,
			@Param(value="cin1")Integer client1,
			@Param(value = "titre1") String titre1);
	
	@Modifying
	@Query("update clientechange c set c.titre2 = :titre2 where c.id = :id and c.cin2=id")
	void updateTitre2Echang(@Param(value = "id") Integer id,
			@Param(value="cin2")Integer client2,
			@Param(value = "titre2") String titre2);
	
	@Modifying
	@Query("update clientechange c set c.clien1confirmation = :clien1confirmation where c.id = :id and c.cin1=id")
	void updateclien1confirmationEchang(@Param(value = "id") Integer id,
			@Param(value="cin1")Integer client1,
			@Param(value = "clien1confirmation") String clien1confirmation);
}
