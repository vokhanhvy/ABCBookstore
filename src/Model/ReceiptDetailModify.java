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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;



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
            String sql = "select * from Books where BookId = ? or BookName = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, txt);      
            statement.setString(2, txt);    
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
            String sql = "insert into Receipt(ReceiptId, BookId , BookName, Quantity , Price , EmpId, Total) values(?, ?, ?, ?, ?, ?, ?)";
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
            String sql = "update Receipt set Quantity=?, Total=? where ReceiptId=? and BookId=?";
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

            String sql = "delete from Receipt where ReceiptId=? and BookName=?";

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
            String sql = "select * from Receipt where ReceiptId = ? and BookId = ?";
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
            String sql = "select * from Receipt where ReceiptId = ?";
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
    
    
    
    public static int showBookSale(Date date1, Date date2) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = SqlConnection.connectDB();
            String sql = "select sum (l.quantity) as revenue from Receipt l inner join Export r on r.ReceiptId = l.receiptID where Date between ? and ?";
            statement = connection.prepareCall(sql);

            java.util.Date date1st = date1;
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
            String sqlDate1st = dateformat.format(date1st);
            statement.setString(1, sqlDate1st);

            java.util.Date date2nd = date2;
            String sqlDate2nd = dateformat.format(date2nd);
            statement.setString(2, sqlDate2nd);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int value = resultSet.getInt("Revenue");

                return value;
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
        return 0;
    }
    
    public static String showBestSaler(Date date1, Date date2) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = SqlConnection.connectDB();
            String sql = "select top(1) bookname from (select BookName, sum(quantity) as newsum from Receipt l \n"
                    + "   inner join Export r on r.ReceiptId = l.receiptID where Date between ? and ? group by bookName) a \n"
                    + "   order by newsum desc";
            statement = connection.prepareCall(sql);

            java.util.Date date1st = date1;
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
            String sqlDate1st = dateformat.format(date1st);
            statement.setString(1, sqlDate1st);

            java.util.Date date2nd = date2;
            String sqlDate2nd = dateformat.format(date2nd);
            statement.setString(2, sqlDate2nd);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String value = resultSet.getString("BookName");

                return value;
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
}
