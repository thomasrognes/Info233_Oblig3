package DAO;

import interfaces.ConnectionDAOIF;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO implements ConnectionDAOIF {

    Connection conn = null;

    /**
     * Returns the DB connection
     * @return DB connection
     */
    public Connection getConnection(){
        return conn;
    }

    /**
     * Closes the db connection
     */
    public void closeConnection() throws SQLException{
        conn.close();
    }
}
