/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import Model.Books;
import Model.BookModify;
import Model.BookModify;
import Model.Books;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.util.Arrays;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author KHANH VY
 */
public class BookAdding extends javax.swing.JFrame {
    byte[] bookImage;
    /**
     * Creates new form AddBooks
     */
    public BookAdding(String txt1, String txt2, String txt3, String txt4, String txt5, String txt6) {
        initComponents(); 
        setLocationRelativeTo(null);
        lbl4.setText(txt1);
        lbl2.setText(txt2);
        lbl3.setText(txt3);
        lblName.setText(txt4);
        lblAuthor.setText(txt5);
        lblPublisher.setText(txt6);
    }
    
    public BookAdding() {
    
    }

    // Hover effect
    public void btnHover(JPanel panel) {
        Color clr = new Color(0, 153, 204);
        panel.setBackground(clr);
    }
    
    public void btnHoverExt(JPanel panel){
        Color clr = new Color(0, 181, 204);
        panel.setBackground(clr);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblPublisher = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnAddtoStorage = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();
        txtGenre = new javax.swing.JComboBox<>();
        lblErr = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblAuthor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 181, 204));
        jLabel1.setText("Please fill in the information for the new book");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, 50));

        lbl2.setFont(new java.awt.Font("Trebuchet MS", 0, 21)); // NOI18N
        lbl2.setForeground(new java.awt.Color(204, 204, 204));
        lbl2.setText("label2");
        jPanel1.add(lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 21)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Name:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 21)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("Author:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 21)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 204, 204));
        jLabel6.setText("Genre");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, -1, -1));

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 21)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setText("Publisher:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 21)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Price");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 0, 21)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setText("Image");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, -1, -1));

        jLabel10.setFont(new java.awt.Font("Trebuchet MS", 0, 21)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("BookId:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        lblPublisher.setFont(new java.awt.Font("Trebuchet MS", 0, 21)); // NOI18N
        lblPublisher.setForeground(new java.awt.Color(204, 204, 204));
        lblPublisher.setText("label4");
        jPanel1.add(lblPublisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 320, -1));

        jLabel12.setFont(new java.awt.Font("Trebuchet MS", 0, 21)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("Quantity:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, -1, -1));

        btnAddtoStorage.setBackground(new java.awt.Color(0, 181, 204));
        btnAddtoStorage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddtoStorageMouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Trebuchet MS", 0, 21)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Add to Storage");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
        });

        javax.swing.GroupLayout btnAddtoStorageLayout = new javax.swing.GroupLayout(btnAddtoStorage);
        btnAddtoStorage.setLayout(btnAddtoStorageLayout);
        btnAddtoStorageLayout.setHorizontalGroup(
            btnAddtoStorageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAddtoStorageLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnAddtoStorageLayout.setVerticalGroup(
            btnAddtoStorageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel1.add(btnAddtoStorage, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, 170, 60));

        jButton1.setText("Choose Image");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 480, -1, -1));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        lblImage.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 470, 140, 160));

        txtGenre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Novel", "Children", "Science-Technology", "Literature-Art", "Lifestyle", "Education", "Politics-Laws", "Culture-Social" }));
        txtGenre.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(204, 204, 204)));
        jPanel1.add(txtGenre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 310, -1));

        lblErr.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lblErr.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.add(lblErr, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 280, 20));

        lbl3.setFont(new java.awt.Font("Trebuchet MS", 0, 21)); // NOI18N
        lbl3.setForeground(new java.awt.Color(204, 204, 204));
        lbl3.setText("label1");
        jPanel1.add(lbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 310, -1));

        lbl4.setFont(new java.awt.Font("Trebuchet MS", 0, 21)); // NOI18N
        lbl4.setForeground(new java.awt.Color(204, 204, 204));
        lbl4.setText("label1");
        jPanel1.add(lbl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, -1, -1));

        lblName.setFont(new java.awt.Font("Trebuchet MS", 0, 21)); // NOI18N
        lblName.setForeground(new java.awt.Color(204, 204, 204));
        lblName.setText("label4");
        jPanel1.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 320, -1));

        lblAuthor.setFont(new java.awt.Font("Trebuchet MS", 0, 21)); // NOI18N
        lblAuthor.setForeground(new java.awt.Color(204, 204, 204));
        lblAuthor.setText("label4");
        jPanel1.add(lblAuthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 320, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                } else {
                    return f.getName().toLowerCase().endsWith(".jpg");
                }
            }
            
            @Override
            public String getDescription() {
                return "Image file (*.jpg)";
            }
        });
        if (chooser.showOpenDialog(jPanel1) == JFileChooser.CANCEL_OPTION) {
            return;
        }
        File file = chooser.getSelectedFile();
        try {
            ImageIcon icon = new ImageIcon(file.getPath());
            System.out.println(file.getPath());
            Image img = BookModify.resize(icon.getImage(), 140, 160);
            ImageIcon resizedIcon = new ImageIcon(img);
            lblImage.setIcon(resizedIcon);
            bookImage = BookModify.toByteArray(img, "jpg");
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
        btnHover(btnAddtoStorage);
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
        btnHoverExt(btnAddtoStorage);
    }//GEN-LAST:event_jLabel13MouseExited

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        String bookid, quantity, name, author, genre, publisher, price;

        quantity = lbl2.getText();
        bookid = lbl4.getText();
        name = lblName.getText();
        author = lblAuthor.getText();
        genre = txtGenre.getSelectedItem().toString();
        publisher = lblPublisher.getText();
        price = lbl3.getText();
        
        if ( genre == "" || bookImage ==null) {
            lblErr.setText("*Please fill in all fields!");
        } else {
                    Integer quantity1 = Integer.parseInt(quantity);
                    long price1 = Long.parseLong(price.replace(",", ""));
                    Books bk = new Books(bookid, name, author, genre, publisher, quantity1, price1, bookImage);
                    BookModify.insertToBooks(bk);
                    lblErr.setText("Add sucess!");
                    this.dispose();
                    
                }    
    }//GEN-LAST:event_jLabel13MouseClicked

    private void btnAddtoStorageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddtoStorageMouseClicked

    }//GEN-LAST:event_btnAddtoStorageMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BookAdding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookAdding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookAdding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookAdding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookAdding().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnAddtoStorage;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lblAuthor;
    private javax.swing.JLabel lblErr;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPublisher;
    private javax.swing.JComboBox<String> txtGenre;
    // End of variables declaration//GEN-END:variables
}
