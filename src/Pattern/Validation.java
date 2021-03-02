/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pattern;

import java.awt.*;
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
    
    public static void Notify(Component parent, String content, String title) {
        JOptionPane.showMessageDialog(parent, content, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
