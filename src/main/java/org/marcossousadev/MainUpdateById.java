package org.marcossousadev;

import org.marcossousadev.model.dao.DaoFactory;
import org.marcossousadev.model.dao.PersonasDao;
import org.marcossousadev.model.entity.Personas;

import java.math.BigDecimal;

public class MainUpdateById {
    public static void main(String[] args) {
        Personas persona = new Personas();
        persona.setName("Paulo");
        persona.setLastname("Silva");
        persona.setSalary(BigDecimal.valueOf(5000));
        persona.setAge(20);
        persona.setId(1);
        PersonasDao personasDao = DaoFactory.createPersonasDao();
        int rowsAffected = personasDao.updateById(persona);

        System.out.println("Quantidade de linhas afetadas: " + rowsAffected);

    }
}
