package com.esprit.demo.service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.apache.tomcat.websocket.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.cj.Session;
import java.util.*;
@Service
public class SendMailService implements InterfaceSendMail{
	@Autowired	 
	InterfaceSendMail sendMail;
	@Autowired	
	private JavaMailSender javaMailSender;

	@Override
	public void send(String toAddress, String fromAddress, String subject) throws Exception{
		
			Integer	content=Integer.valueOf((int) ((Math.random() * 90000000) + 100000));
		 MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		 MimeMessageHelper mimeMessageHelper = new  MimeMessageHelper(mimeMessage);
		 mimeMessageHelper.setFrom(fromAddress);
		 mimeMessageHelper.setTo(toAddress);
		 mimeMessageHelper.setText("Please enter this confirmation code to confirm your mail"+Integer.toString(content));
		 mimeMessageHelper.setSubject(subject);
		 mimeMessageHelper.setSentDate(new Date());
		 javaMailSender.send(mimeMessage);
	}}

