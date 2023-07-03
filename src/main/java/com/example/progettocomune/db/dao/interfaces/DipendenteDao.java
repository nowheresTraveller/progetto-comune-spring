package com.example.progettocomune.db.dao.interfaces;

import com.example.progettocomune.db.entity.Cittadino;
import com.example.progettocomune.db.entity.Dipendente;

import java.util.List;

public interface DipendenteDao {
    public Dipendente selectByUserAndPass(String user, String pass);

    public void insert (Dipendente dipendente);
}
