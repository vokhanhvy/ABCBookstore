/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.*;

/**
 *
 * @author KHANH VY
 */
public class Validation {

    public static void checkDigit(JTextField text, JLabel lbl) {
        String check = text.getText().replace(",", "");
        if (!check.matches("\\d+")) {
            lbl.setText("*Accept digit only!");
        } else {
            lbl.setText("");
        }
    }

    public static void checkSpace(JTextField text, JLabel lbl) {
        String user = text.getText();
        if (user.indexOf(" ") >= 0) {
            lbl.setText("*Text must not contain spaces!");
        } else {
            lbl.setText("");
        }
    }

    //Check if Password and confirm password match
    public static void checkPass(JPasswordField pass, JPasswordField conpass, JLabel lbl) {
        //String pass = txtPass.getText();
        if (!conpass.getText().equals(pass.getText())) {
            lbl.setText("*Password not matched!");
        } else {
            lbl.setText("");
        }

    }

    public static void formatNumber(JTextField text) {
        NumberFormat numberFormatter = new DecimalFormat("#,###,###");

        String num = text.getText().replace(".", "");
        if (num.matches("\\d+")) {
            Long orgNum = Long.parseLong(text.getText());
            String newNum = numberFormatter.format(orgNum);
            text.setText(newNum);
        }
    }

    public static void checkDiscount(JTextField text, JLabel lbl) {
        String num = text.getText().replace(",", "");
        if (num.matches("\\d+")) {
            int num2 = Integer.parseInt(num);
            if (num2 < 0 || num2 > 100) {
                lbl.setText("Discount range from 0% - 100%");
            } else {
                lbl.setText("");
            }
        } else {
            lbl.setText("*Accept digit only!");
        }

    }

    public static void Notify(Component parent, String content, String title) {
        JOptionPane.showMessageDialog(parent, content, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
