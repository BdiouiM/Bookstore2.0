package com.esprit.demo.repository;
import org.springframework.stereotype.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.esprit.demo.entity.Client;
import com.esprit.demo.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
}
