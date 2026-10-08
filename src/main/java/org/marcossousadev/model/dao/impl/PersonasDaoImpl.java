package org.marcossousadev.model.dao.impl;

import org.marcossousadev.db.DB;
import org.marcossousadev.exception.DBException;
import org.marcossousadev.exception.PersonasNotFound;
import org.marcossousadev.model.dao.PersonasDao;
import org.marcossousadev.model.entity.Personas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonasDaoImpl implements PersonasDao {

    private final Connection connection;

    public PersonasDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Personas persona) {
        PreparedStatement preparedStatement = null;

        try {
            String sqlInsert = "INSERT INTO personas (name, lastname, salary, age) "
                    + "VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sqlInsert);
            preparedStatement.setString(1, persona.getName());
            preparedStatement.setString(2, persona.getLastname());
            preparedStatement.setBigDecimal(3, persona.getSalary());
            preparedStatement.setInt(4, persona.getAge());
            preparedStatement.executeUpdate();
        }
        catch (SQLException sqlException) {
            throw new RuntimeException(sqlException.getMessage());
        }
        finally {
            DB.closedStatement(preparedStatement);
        }
    }

    @Override
    public int updateById(Personas persona) {
        PreparedStatement preparedStatement = null;
        findById(persona.getId());
        try {
            String sqlUpdateById = "UPDATE Personas "
                    + "SET name = ?, lastname = ?, salary = ?, age = ? "
                    + "WHERE id = ?";

            preparedStatement = connection.prepareStatement(sqlUpdateById);
            preparedStatement.setString(1, persona.getName());
            preparedStatement.setString(2, persona.getLastname());
            preparedStatement.setBigDecimal(3, persona.getSalary());
            preparedStatement.setInt(4, persona.getAge());
            preparedStatement.setInt(5, persona.getId());

            return preparedStatement.executeUpdate();

        }
        catch (SQLException sqlException){
            throw  new DBException(sqlException.getMessage());
        }
        finally {
            DB.closedStatement(preparedStatement);
        }
    }

    @Override
    public int deleteById(Integer id) {
        PreparedStatement preparedStatement = null;
        findById(id);
        try {
            String sqlDeleteById = "DELETE FROM personas WHERE id = ?";
            preparedStatement = connection.prepareStatement(sqlDeleteById);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate();
        }
        catch (SQLException sqlException){
            throw  new DBException(sqlException.getMessage());
        }
        finally {
            DB.closedStatement(preparedStatement);
        }
    }

    @Override
    public Personas findById(Integer id) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String sqlConsultById = "Select * from personas where id = ?";
            preparedStatement = connection.prepareStatement(sqlConsultById);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                return getPersonas(resultSet);
            }
            else {
                throw new PersonasNotFound("Pessoa não encontrada");
            }
        }
        catch (SQLException sqlException) {
            throw new RuntimeException(sqlException.getMessage());
        }
        finally {
            DB.closedStatement(preparedStatement);
            DB.closeResultSet(resultSet);
        }
    }

    @Override
    public List<Personas> findAll() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            String sqlConsultAll = "Select * from personas";
            preparedStatement = connection.prepareStatement(sqlConsultAll);
            resultSet = preparedStatement.executeQuery();
            List<Personas> PERSONAS = new ArrayList<>();

            while(resultSet.next()) {
                PERSONAS.add(getPersonas(resultSet));
            }
            return PERSONAS;
        }
        catch (SQLException sqlException) {
            throw new DBException(sqlException.getMessage());
        }
        finally {
            DB.closedStatement(preparedStatement);
            DB.closeResultSet(resultSet);
        }
    }

    private Personas getPersonas(ResultSet resultSet) throws SQLException {
        Personas persona = new Personas();
        persona.setId(resultSet.getInt("id"));
        persona.setName(resultSet.getString("name"));
        persona.setMiddlename(resultSet.getString("middlename"));
        persona.setLastname(resultSet.getString("lastname"));
        persona.setFullname(resultSet.getString("fullname"));
        persona.setSalary(resultSet.getBigDecimal("salary"));
        persona.setAge(resultSet.getInt("age"));

        return persona;
    }
}
