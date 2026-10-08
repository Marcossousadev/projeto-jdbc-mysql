package org.marcossousadev;

import org.marcossousadev.model.dao.DaoFactory;
import org.marcossousadev.model.dao.PersonasDao;

public class MainDeleteById {
    public static void main(String[] args) {
        PersonasDao personasDao = DaoFactory.createPersonasDao();
        int rowAffected = personasDao.deleteById(7);
        System.out.println("Quantidade de linhas afetadas: " + rowAffected);
    }
}
