/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdocratatouille.screens;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author Divyo
 */
public class MenuScreen extends javax.swing.JFrame {

    /**
     * Creates new form MenuScreen
     */
    public MenuScreen() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setTitle("Menu");
        setLocation(dim.width/2-this.getSize().width/2,dim.height/2-this.getSize().height/2);
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel1 = new keeptoo.KGradientPanel();
        UsersBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        AppScreenBtn = new javax.swing.JButton();
        LogoutBtn = new javax.swing.JButton();
        EarningScreenBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        kGradientPanel1.setkEndColor(new java.awt.Color(36, 231, 231));
        kGradientPanel1.setkStartColor(new java.awt.Color(200, 26, 168));

        UsersBtn.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        UsersBtn.setForeground(new java.awt.Color(255, 255, 255));
        UsersBtn.setText("Users");
        UsersBtn.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        UsersBtn.setContentAreaFilled(false);
        UsersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsersBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe Script", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Menu");

        AppScreenBtn.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        AppScreenBtn.setForeground(new java.awt.Color(255, 255, 255));
        AppScreenBtn.setText("Menus and Orders");
        AppScreenBtn.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        AppScreenBtn.setContentAreaFilled(false);
        AppScreenBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AppScreenBtnActionPerformed(evt);
            }
        });

        LogoutBtn.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        LogoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        LogoutBtn.setText("Log Out");
        LogoutBtn.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        LogoutBtn.setContentAreaFilled(false);
        LogoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutBtnActionPerformed(evt);
            }
        });

        EarningScreenBtn.setFont(new java.awt.Font("Segoe Print", 1, 24)); // NOI18N
        EarningScreenBtn.setForeground(new java.awt.Color(255, 255, 255));
        EarningScreenBtn.setText("Total Earnings");
        EarningScreenBtn.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        EarningScreenBtn.setContentAreaFilled(false);
        EarningScreenBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EarningScreenBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LogoutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AppScreenBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(UsersBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EarningScreenBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)))
                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(UsersBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AppScreenBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EarningScreenBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(LogoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UsersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsersBtnActionPerformed
        // TODO add your handling code here:
        
        this.dispose();
        UsersScreen user1 = new UsersScreen();
        user1.setVisible(true);
        
        
    }//GEN-LAST:event_UsersBtnActionPerformed

    private void AppScreenBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AppScreenBtnActionPerformed
        // TODO add your handling code here:
        AppScreen app = new AppScreen();
        app.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_AppScreenBtnActionPerformed

    private void LogoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutBtnActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this,"Successfully logged out");
        this.dispose();
        //User logout
        LoginScreen login = new LoginScreen();
        login.setVisible(true);

    }//GEN-LAST:event_LogoutBtnActionPerformed

    private void EarningScreenBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EarningScreenBtnActionPerformed
        // TODO add your handling code here:
        EarningScreen earn = new EarningScreen();
        earn.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_EarningScreenBtnActionPerformed

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
            java.util.logging.Logger.getLogger(MenuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AppScreenBtn;
    private javax.swing.JButton EarningScreenBtn;
    private javax.swing.JButton LogoutBtn;
    private javax.swing.JButton UsersBtn;
    private javax.swing.JLabel jLabel1;
    private keeptoo.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables
}
