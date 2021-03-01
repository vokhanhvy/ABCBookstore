/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



/**
 *
 * @author KHANH VY
 */
// when input bookid, search bookid on table Books to get all information -> return Book Object
public class ReceiptDetailModify {
    public static projectsem2.Books searchBookId(String txt) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = SqlConnection.connectDB();
            String sql = "select * from TestBooks where BookId = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, txt);           
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                projectsem2.Books bk = new projectsem2.Books(resultSet.getString("BookId"),
                        resultSet.getString("BookName"),
                        resultSet.getString("Author"),
                        resultSet.getString("Genre"),
                        resultSet.getString("Publisher"),
                        resultSet.getInt("Quantity"),
                        resultSet.getLong("Price"),
                        resultSet.getBytes("Image")
                );
            return bk;
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
        return null;
    }
    
    public static void insertToReceiptDetail(Pattern.ReceiptDetail rcp) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = SqlConnection.connectDB();
            //query
            String sql = "insert into TestReceipt(ReceiptId, BookId , Quantity , Price , EmpId, Total) values(?, ?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            statement.setString(1, rcp.getReceiptId());
            statement.setString(2, rcp.getBookId());
            statement.setInt(3, rcp.getQuantity());
            statement.setLong(4, rcp.getPrice());
            statement.setInt(5, rcp.getEmpId());
            statement.setLong(6, rcp.getTotal());
            statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (statement != null) {
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
    }
}
