package com.example.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.Echange;

public interface EchangeRepository extends JpaRepository<Echange, Integer> {

}