/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author KHANH VY
 */
public class HoverEffect {
    
    public static void btnHover(JPanel panel) {
        Color clr = new Color(0, 153, 204);
        panel.setBackground(clr);
    }
    
    public static void btnHoverExt(JPanel panel){
        Color clr = new Color(0, 181, 204);
        panel.setBackground(clr);
    }
    public static void btnSearchHover(JPanel panel) {
        Color clr = new Color(204, 204, 204);
        panel.setBackground(clr);
    }
    
    public static void btnSearchHoverExt(JPanel panel){
        Color clr = new Color(254, 254, 254);
        panel.setBackground(clr);
    }
}
