/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern;


import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author KHANH VY
 */
public class SqlConnection {
    public static Connection connectDB() throws SQLException {
    String databaseUrl = "jdbc:sqlserver://localhost:1433;databaseName=TestAbcBookstore;username=sa;password=12345678";
    Connection connection = DriverManager.getConnection(databaseUrl);
    return connection;
    }
}
