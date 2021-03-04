/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author KHANH VY
 */
public class Export {
    String receiptId;
    Date date;
    Long total;
    int EmpId;

    public Export() {
    }

    public Export(String receiptId, Date date, Long total, int EmpId) {
        this.receiptId = receiptId;
        this.date = date;
        this.total = total;
        this.EmpId = EmpId;
    }

    public Export(String receiptId) {
        this.receiptId = receiptId;
    }

    public String getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(String receiptId) {
        this.receiptId = receiptId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public int getEmpId() {
        return EmpId;
    }

    public void setEmpId(int EmpId) {
        this.EmpId = EmpId;
    }
}
