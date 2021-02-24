/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectsem2;

import java.util.Date;

/**
 *
 * @author KHANH VY
 */
public class Import {
    int num, quantity;
    String bookid;
    Date date;
    long price;
    float discount;

    public Import(int quantity, String bookid, Date date, long price, float discount) {
        this.quantity = quantity;
        this.bookid = bookid;
        this.date = date;
        this.price = price;
        this.discount = discount;
    }

    public Import(int num, int quantity, String bookid, Date date, long price, float discount) {
        this.num = num;
        this.quantity = quantity;
        this.bookid = bookid;
        this.date = date;
        this.price = price;
        this.discount = discount;
    }

    public Import() {
    }
    
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    
}
