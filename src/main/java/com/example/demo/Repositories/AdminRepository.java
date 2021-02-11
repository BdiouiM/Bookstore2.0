package com.example.demo.Repositories;



import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.Entities.Echange;

public interface AdminRepository extends JpaRepository<Echange, Integer> {
	
	@Transactional
	@Modifying
	@Query("update Echange u set u.statutechange =: statutechange where u.id =: id")
	Integer updateStatutEchang(@Param(value = "id") Integer id, @Param(value = "statutechange") String statutechange);
	
	@Transactional
	@Modifying
	@Query("update Echange c set c.statutechange ='Valide'  where c.id=:id and c.clientechange=:clientechange")
	Integer updatestatute(@Param("id") Integer id,
			@Param(value ="clientechange")Integer clientechange
			);
	
	
	@Transactional
	@Modifying 
	@Query("delete from Echange e where e.id=:id")
	Integer deleteechange(@Param("id")Integer id);
	
	@Transactional
	@Modifying 
	@Query("delete from Clientechange e where e.id=:id")
	Integer deleteClientechange(@Param("id")Integer id);
}
