/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



/**
 *
 * @author KHANH VY
 */
// when input bookid, search bookid on table Books to get all information -> return Book Object
public class ReceiptDetailModify {
    
    public static Model.Books searchBookId(String txt) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = SqlConnection.connectDB();
            String sql = "select * from TestBooks where BookId = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, txt);           
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Model.Books bk = new Model.Books(resultSet.getString("BookId"),
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
    
    
    public static void insertToReceiptDetail(Model.ReceiptDetail rcp) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = SqlConnection.connectDB();
            //query
            String sql = "insert into TestReceipt(ReceiptId, BookId , BookName, Quantity , Price , EmpId, Total) values(?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            statement.setString(1, rcp.getReceiptId());
            statement.setString(2, rcp.getBookId());
            statement.setString(3, rcp.getBookName());
            statement.setInt(4, rcp.getQuantity());
            statement.setLong(5, rcp.getPrice());
            statement.setInt(6, rcp.getEmpId());
            statement.setLong(7, rcp.getTotal());
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
    
    public static void updateReceiptDetail(Model.ReceiptDetail rcp) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = SqlConnection.connectDB();
            //querry
            String sql = "update TestReceipt set Quantity=?, Total=? where ReceiptId=? and BookId=?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, rcp.getQuantity());
            statement.setLong(2, rcp.getTotal());
            statement.setString(3, rcp.getReceiptId());
            statement.setString(4, rcp.getBookId());

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

    
    
    
    public static void deleteReceipDetailRow(String receipId, String bookName) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = SqlConnection.connectDB();
            //querry

            String sql = "delete from TestReceipt where ReceiptId=? and BookName=?";

            statement = connection.prepareCall(sql);
            statement.setString(1, receipId);
            statement.setString(2, bookName);
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
    
    
    
    public static ReceiptDetail searchReceipIdBookId(String receiptid, String bookid) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = SqlConnection.connectDB();
            String sql = "select * from TestReceipt where ReceiptId = ? and BookId = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, receiptid);
            statement.setString(2, bookid);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ReceiptDetail rcp = new ReceiptDetail(resultSet.getString("ReceiptId"),
                        resultSet.getString("BookId"),
                        resultSet.getString("BookName"),
                        resultSet.getInt("Quantity"),
                        resultSet.getInt("EmpId"),
                        resultSet.getLong("Price"),
                        resultSet.getLong("Total")
                );
                return rcp;
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
    
    
    public static ArrayList findAllReceipt(String receiptId) {
        ArrayList<ReceiptDetail> rcp = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = SqlConnection.connectDB();
            //querry
            String sql = "select * from TestReceipt where ReceiptId = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, receiptId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ReceiptDetail rcp1 = new ReceiptDetail(resultSet.getString("ReceiptId"),
                        resultSet.getString("BookId"),
                        resultSet.getString("BookName"),
                        resultSet.getInt("Quantity"),
                        resultSet.getInt("EmpId"),
                        resultSet.getLong("Price"),
                        resultSet.getLong("Total")
                );

                rcp.add(rcp1);
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
        return rcp;
    }
}
