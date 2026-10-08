package org.marcossousadev;

import org.marcossousadev.model.dao.DaoFactory;
import org.marcossousadev.model.dao.PersonasDao;
import org.marcossousadev.model.entity.Personas;

import java.util.List;

public class MainFindAll {
    public static void main(String[] args) {
        PersonasDao personasDao = DaoFactory.createPersonasDao();
        List<Personas> listPersonas = personasDao.findAll();

        listPersonas.forEach(System.out::println);
    }
}
