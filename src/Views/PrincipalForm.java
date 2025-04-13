package Views;

import Controllers.ConnexionBD;
import javax.swing.JOptionPane;

public class PrincipalForm extends javax.swing.JFrame {

    ConnexionBD conn = new ConnexionBD();

    public PrincipalForm(String username) {
        initComponents();
        this.setLocationRelativeTo(null);
        labelUsername.setText(username);
    }

    PrincipalForm() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelUsername = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BtnDeconnexion = new javax.swing.JButton();
        BtnRapport = new javax.swing.JButton();
        BtnReception = new javax.swing.JButton();
        BtnParametre = new javax.swing.JButton();
        BtnEnvoi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 204));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelUsername.setFont(new java.awt.Font("Red Hat Text Regular", 1, 18)); // NOI18N
        jPanel1.add(labelUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 155, 32));

        jLabel2.setFont(new java.awt.Font("MADE Soulmaze", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(121, 85, 72));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-boîte-50.png"))); // NOI18N
        jLabel2.setText("GColis");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, -1, 47));

        BtnDeconnexion.setBackground(new java.awt.Color(121, 85, 72));
        BtnDeconnexion.setFont(new java.awt.Font("Red Hat Text", 0, 18)); // NOI18N
        BtnDeconnexion.setForeground(new java.awt.Color(255, 255, 255));
        BtnDeconnexion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-sortie-20.png"))); // NOI18N
        BtnDeconnexion.setText("Se deconnecter");
        BtnDeconnexion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnDeconnexion.setFocusPainted(false);
        BtnDeconnexion.setMaximumSize(new java.awt.Dimension(156, 31));
        BtnDeconnexion.setMinimumSize(new java.awt.Dimension(156, 31));
        BtnDeconnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeconnexionActionPerformed(evt);
            }
        });
        jPanel1.add(BtnDeconnexion, new org.netbeans.lib.awtextra.AbsoluteConstraints(684, 408, -1, 49));

        BtnRapport.setBackground(new java.awt.Color(121, 85, 72));
        BtnRapport.setFont(new java.awt.Font("Red Hat Text", 0, 18)); // NOI18N
        BtnRapport.setForeground(new java.awt.Color(255, 255, 255));
        BtnRapport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-fichier-de-rapport-20.png"))); // NOI18N
        BtnRapport.setText("Rapports");
        BtnRapport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnRapport.setFocusPainted(false);
        BtnRapport.setMaximumSize(new java.awt.Dimension(156, 31));
        BtnRapport.setMinimumSize(new java.awt.Dimension(156, 31));
        BtnRapport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRapportActionPerformed(evt);
            }
        });
        jPanel1.add(BtnRapport, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 408, -1, 49));

        BtnReception.setBackground(new java.awt.Color(121, 85, 72));
        BtnReception.setFont(new java.awt.Font("Red Hat Text", 0, 18)); // NOI18N
        BtnReception.setForeground(new java.awt.Color(255, 255, 255));
        BtnReception.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-receive-20.png"))); // NOI18N
        BtnReception.setText("Reception de colis");
        BtnReception.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnReception.setFocusPainted(false);
        BtnReception.setMaximumSize(new java.awt.Dimension(156, 31));
        BtnReception.setMinimumSize(new java.awt.Dimension(156, 31));
        BtnReception.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReceptionActionPerformed(evt);
            }
        });
        jPanel1.add(BtnReception, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 408, -1, 49));

        BtnParametre.setBackground(new java.awt.Color(121, 85, 72));
        BtnParametre.setFont(new java.awt.Font("Red Hat Text", 0, 18)); // NOI18N
        BtnParametre.setForeground(new java.awt.Color(255, 255, 255));
        BtnParametre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-paramètres-20.png"))); // NOI18N
        BtnParametre.setText("Paramètres");
        BtnParametre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnParametre.setFocusPainted(false);
        BtnParametre.setMaximumSize(new java.awt.Dimension(156, 31));
        BtnParametre.setMinimumSize(new java.awt.Dimension(156, 31));
        BtnParametre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnParametreActionPerformed(evt);
            }
        });
        jPanel1.add(BtnParametre, new org.netbeans.lib.awtextra.AbsoluteConstraints(532, 408, -1, 49));

        BtnEnvoi.setBackground(new java.awt.Color(121, 85, 72));
        BtnEnvoi.setFont(new java.awt.Font("Red Hat Text", 0, 18)); // NOI18N
        BtnEnvoi.setForeground(new java.awt.Color(255, 255, 255));
        BtnEnvoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-envoyé-18.png"))); // NOI18N
        BtnEnvoi.setText("Envoi de colis");
        BtnEnvoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnEnvoi.setFocusPainted(false);
        BtnEnvoi.setMaximumSize(new java.awt.Dimension(156, 31));
        BtnEnvoi.setMinimumSize(new java.awt.Dimension(156, 31));
        BtnEnvoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEnvoiActionPerformed(evt);
            }
        });
        jPanel1.add(BtnEnvoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 408, -1, 49));

        jLabel1.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/user.png"))); // NOI18N
        jLabel1.setText("Utilisateur connecté:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, -1, 32));

        jMenu1.setText("File");
        jMenu1.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 895, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnDeconnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeconnexionActionPerformed
        //conn.Deconnexion();
        JOptionPane.showMessageDialog(null, "Vous êtes déconnecté du système !", "Deconnecte", JOptionPane.INFORMATION_MESSAGE);
        dispose();
        new LoginForm().setVisible(true);
    }//GEN-LAST:event_BtnDeconnexionActionPerformed

    private void BtnEnvoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEnvoiActionPerformed
        new EnvoiForm().setVisible(true);
    }//GEN-LAST:event_BtnEnvoiActionPerformed

    private void BtnReceptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReceptionActionPerformed

        new ReceptionForm().setVisible(true);
    }//GEN-LAST:event_BtnReceptionActionPerformed

    private void BtnRapportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRapportActionPerformed
        new RapportForm().setVisible(true);
    }//GEN-LAST:event_BtnRapportActionPerformed

    private void BtnParametreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnParametreActionPerformed
        new ParametreForm().setVisible(true);
    }//GEN-LAST:event_BtnParametreActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnDeconnexion;
    private javax.swing.JButton BtnEnvoi;
    private javax.swing.JButton BtnParametre;
    private javax.swing.JButton BtnRapport;
    private javax.swing.JButton BtnReception;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelUsername;
    // End of variables declaration//GEN-END:variables
}
