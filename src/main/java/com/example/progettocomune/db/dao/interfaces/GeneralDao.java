package com.example.progettocomune.db.dao.interfaces;

import java.util.List;

public interface GeneralDao <T>{


    public List<T> selectAll();
    public boolean update(T obj);
    public void insert (T obj);

}
