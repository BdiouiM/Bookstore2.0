package com.example.demo.Repositories;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entities.Echange;

public interface AdminRepository extends JpaRepository<Echange, Integer> {
	
	@Modifying
	@Query("update echange u set u.statutechange = :statutechange where u.id = :id")
	void updateStatutEchang(@Param(value = "id") Integer id, @Param(value = "statutechange") String statutechange);

}
