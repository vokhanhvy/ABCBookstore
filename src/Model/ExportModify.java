/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author KHANH VY
 */
public class ExportModify {
    public static void insertToExport(String  receiptId) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = SqlConnection.connectDB();
            //query
            String sql = "insert into TestExport(ReceiptId) values(?)";
            statement = connection.prepareCall(sql);
            statement.setString(1, receiptId);
            
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
    
    
    public static void updateExport(Export exp) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = SqlConnection.connectDB();
            //querry
            String sql = "update TestExport set Date=?, Total=?, EmpId=? where ReceiptId=? ";
            statement = connection.prepareCall(sql);
            
            java.util.Date date = exp.getDate();
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
            String sqlDate = dateformat.format(date);
            
            statement.setString(1, sqlDate);
            statement.setLong(2, exp.getTotal());
            statement.setInt(3, exp.getEmpId());
            statement.setString(4, exp.getReceiptId());

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
    
    public static Export searchExportReceiptId(String receiptid) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = SqlConnection.connectDB();
            String sql = "select * from TestExport where ReceiptId = ? ";
            statement = connection.prepareCall(sql);
            statement.setString(1, receiptid);
            
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Export exp = new Export(resultSet.getString("ReceiptId")
                );
                return exp;
            }

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
        //end here
        return null;
    }
    
    
    public static Export selectTop1Export() {
        Export exp = new Export();
        
        Connection connection = null;
        Statement statement = null;
        try {
            connection = SqlConnection.connectDB();
            //querry
            String sql = "select top(1) ReceiptId from TestExport where Total != 0 order by ReceiptId desc";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                
                exp = new Export(resultSet.getString("ReceiptId")
                );
                return exp;
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
}
