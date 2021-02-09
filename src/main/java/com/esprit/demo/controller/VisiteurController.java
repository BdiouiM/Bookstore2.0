package com.esprit.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.demo.entity.Client;
import com.esprit.demo.entity.Personnel;

import com.esprit.demo.service.PersonnelServiceImp;
import com.esprit.demo.service.SendMailService;
import com.esprit.demo.service.VisiteurServiceUmp;


@Controller
@RestController
@RequestMapping("/visiteurController")
public class VisiteurController {
	@Autowired
	private SendMailService sendMail ;
	@Autowired
	private VisiteurServiceUmp service ;
	 @PostMapping("/addVisiteur")
	    public Client addVisiteur(@RequestBody Client c) throws Exception {
		 sendMail.send(c.getEmail(),"mejrioumaima68","Welcome, Complete registration!"+c.getUsername());
	        return service.AjouterVisiteur(c);
	    }
}
