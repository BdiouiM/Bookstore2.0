package com.example.demo.Entities;




import com.fasterxml.jackson.annotation.JsonManagedReference;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="utilisateur")
public class Utilisateur {
    private Integer id;
    private String email;
    private String username;
    private String cin;
    private Collection<Clientechange> clientechangesById;
    private Collection<Clientechange> clientechangesById_0;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "CIN")
    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Utilisateur that = (Utilisateur) o;

        if (id != that.id) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (cin != null ? !cin.equals(that.cin) : that.cin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (cin != null ? cin.hashCode() : 0);
        return result;
    }

    @JsonManagedReference(value="c1")
  
    @OneToMany(mappedBy = "utilisateurByClient1")
    public Collection<Clientechange> getClientechangesById() {
        return clientechangesById;
    }

    public void setClientechangesById(Collection<Clientechange> clientechangesById) {
        this.clientechangesById = clientechangesById;
    }
 
    @JsonManagedReference(value="c2")
    @OneToMany(mappedBy = "utilisateurByClient2")
    public Collection<Clientechange> getClientechangesById_0() {
        return clientechangesById_0;
    }

    public void setClientechangesById_0(Collection<Clientechange> clientechangesById_0) {
        this.clientechangesById_0 = clientechangesById_0;
    }
}
