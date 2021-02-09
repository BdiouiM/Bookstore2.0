package com.esprit.demo.entity;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table( name = "PERSONNEL")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Personnel extends User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="P_ID")
	Long pId;*/
	@Column(name="P_POSTE")
	 private String poste;
	@Column(name="P_SALAIRE")
      private float salaire;
	/* @OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "ID",referencedColumnName="u_id")
     private User user;*/
     
public Personnel(int cin, String nom, String prenom, String email, String adresse, String username, String password, String role, Long tpId, String poste, float salaire) {
	super(cin, nom, prenom, email, adresse, username,password, role);
	//this.pId = tpId;
	this.poste = poste;
	this.salaire = salaire;
		
	}


public Personnel() {
super();
}

/*public long getId() {
	return pId;
}
public void setId(long pId) {
	this.pId = pId;
}*/
public String getPoste() {
return poste;
}

public float getSalaire() {
return salaire;
}

public void setPoste(String poste) {
this.poste = poste;
}

public void setSalaire(float salaire) {
this.salaire = salaire;
}

@Override
public String toString() {
return super.toString()+ "Personnel{" + "poste=" + poste + ", salaire=" + salaire + '}';
}

		
}