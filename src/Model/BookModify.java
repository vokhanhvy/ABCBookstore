/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;

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
            connection = SqlConnection.connectDB();
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
                        resultSet.getBytes("Image")
                        
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
    
    public static ArrayList findAllStorageTracking() {
        ArrayList<Import> importList = new ArrayList<>();
        
        Connection connection = null;
        Statement statement = null;
        try {
            connection = SqlConnection.connectDB();
            //querry
            String sql = "select * from TestImport";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Import imp;
                imp = new Import(resultSet.getInt("Quantity"),
                        resultSet.getString("BookId"),
                        resultSet.getDate("ImportDate"),
                        resultSet.getLong("Price"),
                        resultSet.getFloat("Discount")                         
                );
                importList.add(imp);
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
        return importList;
    }
    
    // resize image
    public static Image resize(Image org, int targetWidth, int targetHeight) {
        Image resultImage = org.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
        return resultImage;
    }
    
    // image to byte
    public static byte[] toByteArray(Image img, String type) throws IOException {
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bimage.createGraphics();
        g.drawImage(img, 0, 0, null);
        g.dispose();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bimage, type, baos);
        byte[] imageInByte = baos.toByteArray();
        return imageInByte;
    }
    
    //byte to image
    public static Image createImageFromByteArray(byte[] data, String type) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        BufferedImage bimage2 = ImageIO.read(bis);
        Image img = bimage2.getScaledInstance(bimage2.getWidth(), bimage2.getHeight(), Image.SCALE_SMOOTH);
        return img;
}
    
    
    
    
    public static void inserttoImport(Import imp) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = SqlConnection.connectDB();
            //querry
            String sql = "insert into TestImport(BookId, ImportDate , Quantity , Price , Discount) values(?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            statement.setString(1, imp.getBookid());

            java.util.Date date = imp.getDate();
            SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
            String sqlDate = dateformat.format(date);
            statement.setString(2, sqlDate);
            
            statement.setInt(3, imp.getQuantity());
            statement.setLong(4, imp.getPrice());
            statement.setFloat(5, imp.getDiscount());

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
    
    
    public static void insertToBooks(Books bk) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = SqlConnection.connectDB();
            //querry
            String sql = "insert into TestBooks(BookId, BookName , Author , Genre , Price, Publisher, Image, Quantity) values(?, ?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            statement.setString(1, bk.getBookId());
            statement.setString(2, bk.getBookName());
            statement.setString(3, bk.getAuthor());
            statement.setString(4, bk.getGenre());
            statement.setLong(5, bk.getPrice());
            statement.setString(6, bk.getPublisher());
            Blob blob = new SerialBlob(bk.getImage());
            statement.setBlob(7, blob);
            statement.setInt(8, bk.getQuantity());

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
    
    public static void updateOfBookPrice(Books bk){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = SqlConnection.connectDB();
            //querry
            String sql = "update TestBooks set Quantity=?, Price=? where BookId=?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, bk.getQuantity());
            statement.setLong(2, bk.getPrice());
            statement.setString(3, bk.getBookId());            
            statement.execute();
 
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
    }
    
    public static void updateOfBookInformation(Books bk){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = SqlConnection.connectDB();
            //querry
            String sql = "update TestBooks set BookName=?, Author=?, Genre=?, Publisher=?, Image=? where BookId=?";
            statement = connection.prepareCall(sql);
            statement.setString(1, bk.getBookName());
            statement.setString(2, bk.getAuthor());
            statement.setString(3, bk.getGenre()); 
            statement.setString(4, bk.getPublisher()); 
            
            Blob blob = new SerialBlob(bk.getImage());
            statement.setBlob(5, blob);

            statement.setString(6, bk.getBookId()); 
            statement.execute();
 
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
    }
    
    
    public static ArrayList searchBook(String txt) {
        ArrayList<Books> booksList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = SqlConnection.connectDB();
            //querry
            String sql = "select * from TestBooks where concat('.', BookId, '.', BookName, '.', Author, '.', Genre, '.', Publisher, '.', Price, '.') like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%.%" + txt + "%.%");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Books bk = new Books(resultSet.getString("BookId"),
                        resultSet.getString("BookName"),
                        resultSet.getString("Author"),
                        resultSet.getString("Genre"),
                        resultSet.getString("Publisher"),
                        resultSet.getInt("Quantity"),
                        resultSet.getLong("Price"),
                        resultSet.getBytes("Image")
                );
                booksList.add(bk);
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
        return booksList;
    }
    
    public static ArrayList searchStorageTracking(String txt) {
        ArrayList<Import> importList = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = SqlConnection.connectDB();
            //querry
            String sql = "select * from TestImport where concat('.', BookId, '.', ImportDate, '.', Price, '.') like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%.%" + txt + "%.%");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Import imp = new Import(resultSet.getInt("Quantity"),
                        resultSet.getString("BookId"),
                        resultSet.getDate("ImportDate"),
                        resultSet.getLong("Price"),
                        resultSet.getFloat("Discount")   
                );
                importList.add(imp);
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
        return importList;
    }
    
    public static Books selectTop1Book() {
        //Books book = new Books();

        Connection connection = null;
        Statement statement = null;
        try {
            connection = SqlConnection.connectDB();
            //querry
            String sql = "select top(1) * from TestBooks order by BookId desc";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                Books book = new Books(resultSet.getString("BookId"),
                        resultSet.getString("BookName"),
                        resultSet.getString("Author"),
                        resultSet.getString("Genre"),
                        resultSet.getString("Publisher"),
                        resultSet.getInt("Quantity"),
                        resultSet.getLong("Price"),
                        resultSet.getBytes("Image")
                );
                return book;
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
