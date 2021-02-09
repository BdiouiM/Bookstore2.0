package com.esprit.demo.entity;
import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

//autoriser au autre class à heriter user
@MappedSuperclass
public abstract class User implements Serializable{
	private static final long serialVersionUID = 675448607963296437L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="U_ID")
	private long id;
	@Column(name="U_CIN")
	private int cin;
	@Column(name="U_NOM")
	private String nom;
	@Column(name="U_PRENOM")
	private String prenom;
	@Column(name="U_EMAIL")
	private String email;
	@Column(name="U_ADRESSE")
	private String adresse;
	@Column(name="U_USERNAME")
	private String username;
	@Column(name="U_PASSWORD")
	private String password;
	@Column(name="U_ROLE")
	 //@Enumerated(EnumType.STRING)
	private String role;
	public User(){}
	public User(int cin, String nom, String prenom, String email, String adresse, String username,	String password, String role) {
			
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getCin() {
		return cin;
	}
	public void setCin(int cin) {
		this.cin = cin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Client [id=" +  +  + cin + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
				+ ", adresse=" + adresse + ", username=" + username + ", password=" + password + ", role=" + role + "]";
	}
	
}
