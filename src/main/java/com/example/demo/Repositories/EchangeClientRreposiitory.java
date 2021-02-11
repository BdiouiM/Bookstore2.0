package com.example.demo.Repositories;



import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.Entities.Clientechange;



@Repository
public interface EchangeClientRreposiitory extends JpaRepository<Clientechange, Integer> {
	//public List<Clientechange>find(Long client1);
	@Transactional
	@Modifying
	@Query("update Clientechange c set c.titre1 =:titre1 where c.id =:id and c.client1=:client1")
	Integer updateTitre1Echange(@Param(value = "id") Integer id,
			@Param(value="client1")Integer client1,
			@Param(value = "titre1") String titre1);
	
	@Transactional
	@Modifying
	@Query("update Clientechange c set c.client1Confirmation =:client1Confirmation where c.id=:id and c.client1=:client1")
	Integer updateclien1confirmationEchang(@Param("id") Integer id,
			@Param(value ="client1")Integer client1,
			@Param(value= "client1Confirmation") String client1confirmation);
	
	@Transactional
	@Modifying
	@Query("update Clientechange c set c.client1Confirmation=null,c.titre2=null,c.client2=null where c.id=:id")
	Integer AnnulerClientEchange(@Param("id")int id );
	
	@Transactional
	@Modifying
	@Query("update Clientechange c set c.titre2=:titre2,c.client2=:client2 where c.id=:id")
	Integer updateclientEchange(@Param("id") Integer id,@Param("client2") Integer client2,@Param("titre2") String titre2);
}
