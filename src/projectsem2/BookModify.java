/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsem2;

import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author KHANH VY
 */
public class BookModify {
    
    public static ArrayList findAllBooks() {
        ArrayList<Books> booksList = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        try {
            String databaseUrl = "jdbc:sqlserver://localhost:1433;databaseName=TestAbcBookstore;username=sa;password=12345678";
            connection = DriverManager.getConnection(databaseUrl);
            //querry
            String sql = "select * from TestBooks";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Books bks;
                bks = new Books(resultSet.getString("BookId"),
                        resultSet.getString("BookName"),
                        resultSet.getString("Author"),
                        resultSet.getString("Genre"),
                        resultSet.getString("Publisher"),
                        resultSet.getInt("Quantity"),
                        resultSet.getLong("Price"),
                        resultSet.getBlob("Image")
                        
                );
                booksList.add(bks);
        } 
             
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if(statement !=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        //end here
        return booksList;
    }
}
