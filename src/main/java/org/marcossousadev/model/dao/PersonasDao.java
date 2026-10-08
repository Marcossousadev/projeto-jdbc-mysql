package org.marcossousadev.model.dao;

import org.marcossousadev.model.entity.Personas;

import java.util.List;

public interface PersonasDao {
    void insert(Personas persona);
    int updateById(Personas persona);
    // Integer tem como saber se veio nullo
    int deleteById(Integer id);
    Personas findById(Integer id);
    List<Personas> findAll();
}
