package com.example.progettocomune.db.dao.interfaces;

import com.example.progettocomune.db.entity.Cittadino;
import com.example.progettocomune.db.entity.Dipendente;

import java.util.List;

public interface CittadinoDao {

    public Cittadino selectByCodFiscale(String codiceFiscale);

    public List<Cittadino> selectAll();
    public void update(Cittadino cittadino);
    public void insert (Cittadino cittadino);
    public Cittadino selectById(int id);
    public Cittadino delete();

    //TODO vedere se campo user è unique
}
