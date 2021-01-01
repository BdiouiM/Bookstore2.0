package bookstore.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_Reclamation")
public class Reclamation implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
	@Enumerated(EnumType.STRING)
	 private TypeReclamation type;
	@Column(name="C_statutReclamation")
	 private String StatutReclamation;
	@Column(name="C_dateReclamation")
	 private String DateReclamation;
	@Column(name="C_Description")
	 private String Description;
	@Column(name="C_ClientUsername")
	 private String ClientUsername;
	@ManyToOne
    User utilisateur;
	public Reclamation() {
	}
	public Reclamation(Long id, TypeReclamation type, String statutReclamation, String dateReclamation, String description,
			String clientUsername) {
		super();
		this.id = id;
		this.type=type;
		this.StatutReclamation = statutReclamation;
		this.DateReclamation = dateReclamation;
		this.Description = description;
		this.ClientUsername = clientUsername;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TypeReclamation getType() {
		return type;
	}
	public void setType(TypeReclamation type) {
		this.type = type;
	}
	public String getStatutReclamation() {
		return StatutReclamation;
	}
	public void setStatutReclamation(String statutReclamation) {
		StatutReclamation = statutReclamation;
	}
	public String getDateReclamation() {
		return DateReclamation;
	}
	public void setDateReclamation(String dateReclamation) {
		DateReclamation = dateReclamation;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getClientUsername() {
		return ClientUsername;
	}
	public void setClientUsername(String clientUsername) {
		ClientUsername = clientUsername;
	}
   
}
