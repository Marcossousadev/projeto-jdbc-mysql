package org.marcossousadev;

import org.marcossousadev.model.dao.DaoFactory;
import org.marcossousadev.model.dao.PersonasDao;
import org.marcossousadev.model.entity.Personas;

public class MainFindById {

    public static void main(String[] args) {
        PersonasDao personasDao = DaoFactory.createPersonasDao();
        Personas persona = personasDao.findById(6);
        System.out.println(persona);
    }
}
