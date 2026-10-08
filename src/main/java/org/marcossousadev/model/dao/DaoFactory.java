package org.marcossousadev.model.dao;

import org.marcossousadev.db.DB;
import org.marcossousadev.model.dao.impl.PersonasDaoImpl;
import org.marcossousadev.model.entity.Personas;

public class DaoFactory {

    public static PersonasDao createPersonasDao() {
        return new PersonasDaoImpl(DB.getConnections());
    }
}
