package com.esprit.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.demo.entity.Personnel;
import com.esprit.demo.entity.User;



@Repository
public interface PersonnelRepository extends CrudRepository<Personnel, Long>{
}
