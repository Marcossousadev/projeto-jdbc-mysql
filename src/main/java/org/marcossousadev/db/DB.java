package org.marcossousadev.db;

import org.marcossousadev.exception.DBException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {
    private static Connection connection = null;
    public static Connection getConnections() {
       try {
           if(connection == null) {
               Properties properties = loadProperties();
               String url = properties.getProperty("dburl");
               connection = DriverManager.getConnection(url, properties);
           }
       }
       catch (SQLException sqlException) {
           throw new DBException(sqlException.getMessage());
       }
       return connection;
    }

    private static Properties loadProperties() {
        try(FileInputStream fileInputStream = new FileInputStream("db.properties")) {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            return properties;
        }
        catch (IOException ioException){
            throw new DBException(ioException.getMessage());
        }
    }

    public static void closedStatement(Statement st) {
        if(st != null){
            try {
                st.close();
            }
            catch (SQLException sqlException) {
                throw new DBException(sqlException.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs){
        if(rs != null) {
            try {
                rs.close();
            }
            catch (SQLException ex) {
                throw new DBException(ex.getMessage());
            }
        }
    }
}
