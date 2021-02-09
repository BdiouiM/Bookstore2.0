package com.esprit.demo.repository;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.demo.entity.Client;
@Repository

public interface ClientRepository extends JpaRepository<Client, Long>{
	/*@Modifying
	@Query	(value="UPDATE Client c set cin=:u_cin where c.id=:u_id") 
	void updateClientById(@Param("id") long id);*/


}
