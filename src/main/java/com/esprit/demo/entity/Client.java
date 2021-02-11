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
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table( name = "CLIENT")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Client extends User implements Serializable{
	private static final long serialVersionUID = 1L;	
	@Column(name="type")
	private String type;
	

	
		  public Client() {
			  super();
		}
		  
		  public Client(int cin, String nom, String prenom, String email, String adresse, String username, String password, String role, String type) {
				super(cin, nom, prenom, email, adresse, username,password, role);
				
				this.type = type;
								
				}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

@Override
public String toString() {
return super.toString()+"Client{" + '}';
}
}