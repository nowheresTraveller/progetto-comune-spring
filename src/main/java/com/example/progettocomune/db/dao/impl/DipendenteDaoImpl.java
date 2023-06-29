package com.example.progettocomune.db.dao.impl;

import com.example.progettocomune.db.dao.interfaces.DipendenteDao;
import com.example.progettocomune.db.entity.Dipendente;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class DipendenteDaoImpl implements DipendenteDao {

    @PersistenceContext
    private EntityManager manager;


    @Override
    public Dipendente selectByUserAndPass(String user, String pass) {
        return manager.createQuery("select x from Dipendente x where x.username =:u and x.password =:p",Dipendente.class)
                .setParameter("u",user).setParameter("p",pass).getSingleResult();
    }

    @Override
    @Transactional
    public void insert(Dipendente dipendente) {

    }
}
