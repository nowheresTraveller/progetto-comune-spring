package com.example.progettocomune.db.entity;

import javax.persistence.*;

@Entity
@Table(name="cittadino")
public class Cittadino {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String nome;
    private String cognome;

    @Column(name="codice_fiscale")
    private String codiceFiscale;

    @Column(name="data_di_nascita")
    private String dataNascita;

    public Cittadino() {
    }

    public Cittadino(String nome, String cognome, String codiceFiscale, String dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.dataNascita = dataNascita;
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

    public String getDataNascita() {
        return dataNascita;
    }
}
