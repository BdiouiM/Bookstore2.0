package com.esprit.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.demo.entity.Personnel;
@Repository
public interface AdminRepository extends CrudRepository<Personnel, Long>{

}
