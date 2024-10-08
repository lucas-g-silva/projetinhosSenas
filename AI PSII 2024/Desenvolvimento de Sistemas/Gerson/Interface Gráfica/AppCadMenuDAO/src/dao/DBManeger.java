/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;

/**
 *
 * @author lucas-gabreil_silva
 */
public class DBManeger {
    public static final String USER = "root";
    public static final String PASSWORD = "log29jul";
    public static final String DB_NAME = "db_cad_lucas";
    public static final String URL = "jdbc:mysql://localhost:3306/" + DB_NAME;

    public DBManeger() {
    }
    
    private Connection connection;
    
    public boolean isConnected(){
        try{
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                 e.printStackTrace();
            }
            
        }
    }
}
