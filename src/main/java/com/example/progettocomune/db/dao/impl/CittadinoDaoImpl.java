package com.example.progettocomune.db.dao.impl;

import com.example.progettocomune.db.dao.interfaces.CittadinoDao;
import com.example.progettocomune.db.entity.Cittadino;
import com.example.progettocomune.db.entity.Dipendente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CittadinoDaoImpl implements CittadinoDao {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Cittadino selectByCodFiscale(String codiceFiscale) {
        try {
            return manager.createQuery("select x from Cittadino x where x.codice_fiscale =: c", Cittadino.class)
                    .setParameter("c", codiceFiscale).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Cittadino> selectAll() {
        return manager.createQuery("from Cittadino x", Cittadino.class).getResultList();
    }

    @Override
    public void update(Cittadino cittadino) {
       manager.merge(cittadino);
    }

    @Override
    public void insert(Cittadino cittadino) {
        try {
            manager.persist(cittadino);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cittadino selectById(int id) {
        try {
            return manager.createQuery("select x from Cittadino x where x.id =: i", Cittadino.class)
                    .setParameter("i", id).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Cittadino delete() {
        return null;
    }
}
