package com.example.demo.Entities;

import javax.persistence.*;

@Entity
public class Echange {
    private Integer id;
    private String statutechange;
    private Integer clientechange;
    private Clientechange clientechangeByClientechange;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "statutechange")
    public String getStatutechange() {
        return statutechange;
    }

    public void setStatutechange(String statutechange) {
        this.statutechange = statutechange;
    }

    @Basic
    @Column(name = "clientechange" ,insertable = true,nullable = true,updatable = false)
    public Integer getClientechange() {
        return clientechange;
    }

    public void setClientechange(Integer clientechange) {
        this.clientechange = clientechange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Echange echange = (Echange) o;

        if (id != echange.id) return false;
        if (clientechange != echange.clientechange) return false;
        if (statutechange != null ? !statutechange.equals(echange.statutechange) : echange.statutechange != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (statutechange != null ? statutechange.hashCode() : 0);
        result = 31 * result + clientechange;
        return result;
    }

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "clientechange", referencedColumnName = "id", nullable = false)
    public Clientechange getClientechangeByClientechange() {
        return clientechangeByClientechange;
    }

    public void setClientechangeByClientechange(Clientechange clientechangeByClientechange) {
        this.clientechangeByClientechange = clientechangeByClientechange;
    }
}
