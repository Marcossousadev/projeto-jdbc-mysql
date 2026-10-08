package org.marcossousadev;

import org.marcossousadev.model.dao.DaoFactory;
import org.marcossousadev.model.dao.PersonasDao;
import org.marcossousadev.model.entity.Personas;

import java.math.BigDecimal;

public class MainInsert {
    public static void main(String[] args) {
        Personas personas = new Personas();
        personas.setName("Marcos");
        personas.setLastname("Sampaio");
        personas.setSalary(BigDecimal.valueOf(4000));
        personas.setAge(18);

        PersonasDao personasDao = DaoFactory.createPersonasDao();

        personasDao.insert(personas);
    }
}
