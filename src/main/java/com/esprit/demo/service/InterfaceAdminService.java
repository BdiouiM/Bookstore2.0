package com.esprit.demo.service;

import java.util.Optional;

import com.esprit.demo.entity.Personnel;

public interface InterfaceAdminService {
	Iterable<Personnel> AllPersonnels() ;
	Optional<Personnel> GetUserById(long id);
	Personnel addPersonnel(Personnel personnel);
	void deleteById(Long id);
}
