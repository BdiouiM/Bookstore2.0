package com.esprit.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.demo.entity.Client;
import com.esprit.demo.entity.Personnel;
import com.esprit.demo.entity.User;
import com.esprit.demo.repository.UserRepository;

@Repository
public interface VisiteurRepository extends CrudRepository<Client, Long>
{

	

	
}
