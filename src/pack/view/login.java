/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import pack.control.login_koneksi;
import pack.dao.daoToko;
import pack.dao.implementToko;

/**
 *
 * @author Alfan11
 */
public class login extends javax.swing.JFrame {

    public static String user;

    /**
     * Creates new form login
     */
    public login() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        txtpass = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        btIn = new javax.swing.JButton();
        btUp = new javax.swing.JButton();
        btKeluar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 255, 204));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("PASSWORD");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(200, 80, 80, 30);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("USERNAME");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(200, 10, 80, 30);

        txtnama.setSelectionColor(new java.awt.Color(204, 204, 255));
        jPanel1.add(txtnama);
        txtnama.setBounds(170, 40, 130, 30);

        txtpass.setSelectionColor(new java.awt.Color(204, 204, 255));
        jPanel1.add(txtpass);
        txtpass.setBounds(170, 110, 130, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 70, 480, 180);

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));
        jPanel2.setLayout(null);

        btIn.setBackground(new java.awt.Color(204, 255, 255));
        btIn.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        btIn.setForeground(new java.awt.Color(153, 153, 153));
        btIn.setText("Sign In");
        btIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInActionPerformed(evt);
            }
        });
        jPanel2.add(btIn);
        btIn.setBounds(110, 30, 120, 30);

        btUp.setBackground(new java.awt.Color(204, 255, 255));
        btUp.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        btUp.setForeground(new java.awt.Color(153, 153, 153));
        btUp.setText("Sign Up");
        btUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpActionPerformed(evt);
            }
        });
        jPanel2.add(btUp);
        btUp.setBounds(250, 30, 120, 30);

        btKeluar.setBackground(new java.awt.Color(204, 204, 255));
        btKeluar.setFont(new java.awt.Font("OCR A Extended", 1, 12)); // NOI18N
        btKeluar.setForeground(new java.awt.Color(153, 0, 0));
        btKeluar.setText("Keluar");
        btKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKeluarActionPerformed(evt);
            }
        });
        jPanel2.add(btKeluar);
        btKeluar.setBounds(110, 70, 260, 30);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 250, 480, 140);

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Photographs", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LOGIN");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(180, 20, 140, 29);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 480, 70);

        setSize(new java.awt.Dimension(496, 426));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInActionPerformed
        Connection connection;
        PreparedStatement ps;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/toko?zeroDate TimeBehavior=convertToNull", "root", "");
            ps = connection.prepareStatement("SELECT * FROM `tb_akun` WHERE `username` = ? AND `password` = ?");
            ps.setString(1, txtnama.getText());
            ps.setString(2, txtpass.getText());
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                new home().show();
                //perlu deklarasi user diclass utama.                 
                user = txtnama.getText();
                
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Salah!");
                txtpass.setText("");
                txtnama.requestFocus();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Gagal!");
        }
    }//GEN-LAST:event_btInActionPerformed

    private void btUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpActionPerformed
        String user = txtnama.getText();
        String p = txtpass.getText();
        
        try{
            try(Statement statement = (Statement) login_koneksi.GetConnection().createStatement()){
                statement.executeUpdate("INSERT INTO tb_akun VALUES ('"+user+"', '"+p+"')");
            } 
            JOptionPane.showMessageDialog(null, "Sign Up Berhasil");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "GAGAL! Silahkan Ulangi");
        }
    }//GEN-LAST:event_btUpActionPerformed

    private void btKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKeluarActionPerformed
        dispose();
    }//GEN-LAST:event_btKeluarActionPerformed

    public JTextField getUser(){ 
        return txtnama;
    }
    
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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btIn;
    private javax.swing.JButton btKeluar;
    private javax.swing.JButton btUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtnama;
    private javax.swing.JPasswordField txtpass;
    // End of variables declaration//GEN-END:variables
}
