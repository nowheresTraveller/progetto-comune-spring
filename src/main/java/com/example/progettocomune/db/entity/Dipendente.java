package com.example.progettocomune.db.entity;

import javax.persistence.*;


@Entity
@Table(name="dipendente")
public class Dipendente {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String nome;
    private String cognome;
    @Column(name="codice_fiscale")
    private String codiceFiscale;

    private String username;
    private String password;

    public Dipendente() {
    }

    public Dipendente(String nome, String cognome, String codiceFiscale, String username, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
