package com.example.demo.Entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Clientechange {
    private int id;
    private Integer client1;
    private Integer client2;
    private String client1Confirmation;
    private Utilisateur utilisateurByClient1;
    private Utilisateur utilisateurByClient2;
    private Collection<Echange> echangesById;
    private String titre1;
    private String titre2;

    @Id
    @Column(name = "id",insertable = true,updatable = true,nullable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "client1",updatable = true,insertable = true)
    public Integer getClient1() {
        return client1;
    }

    public void setClient1(Integer client1) {
        this.client1 = client1;
    }

    @Basic
    @Column(name = "client2",updatable = true,insertable = true,nullable = true)
    public Integer getClient2() {
        return client2;
    }

    public void setClient2(Integer client2) {
        this.client2 = client2;
    }

    @Basic
    @Column(name = "client1confirmation")
    public String getClient1Confirmation() {
        return client1Confirmation;
    }

    public void setClient1Confirmation(String client1Confirmation) {
        this.client1Confirmation = client1Confirmation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Clientechange that = (Clientechange) o;

        if (id != that.id) return false;
        if (client1 != that.client1) return false;
        if (client2 != that.client2) return false;
        if (client1Confirmation != null ? !client1Confirmation.equals(that.client1Confirmation) : that.client1Confirmation != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + client1;
        result = 31 * result + client2;
        result = 31 * result + (client1Confirmation != null ? client1Confirmation.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "client1", referencedColumnName = "id", nullable = false)
    public Utilisateur getUtilisateurByClient1() {
        return utilisateurByClient1;
    }

    public void setUtilisateurByClient1(Utilisateur utilisateurByClient1) {
        this.utilisateurByClient1 = utilisateurByClient1;
    }

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "client2", referencedColumnName = "id", nullable = true)
    public Utilisateur getUtilisateurByClient2() {
        return utilisateurByClient2;
    }

    public void setUtilisateurByClient2(Utilisateur utilisateurByClient2) {
        this.utilisateurByClient2 = utilisateurByClient2;
    }

    @OneToMany(mappedBy = "clientechangeByClientechange")
    public Collection<Echange> getEchangesById() {
        return echangesById;
    }

    public void setEchangesById(Collection<Echange> echangesById) {
        this.echangesById = echangesById;
    }

    @Basic
    @Column(name = "titre1")
    public String getTitre1() {
        return titre1;
    }

    public void setTitre1(String titre1) {
        this.titre1 = titre1;
    }

    @Basic
    @Column(name = "titre2")
    public String getTitre2() {
        return titre2;
    }

    public void setTitre2(String titre2) {
        this.titre2 = titre2;
    }
}
