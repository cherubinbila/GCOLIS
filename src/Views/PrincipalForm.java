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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 204));
        setResizable(false);

        labelUsername.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("MADE Soulmaze", 0, 48)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-boîte-50.png"))); // NOI18N
        jLabel2.setText("GColis");

        BtnDeconnexion.setFont(new java.awt.Font("Red Hat Text", 0, 15)); // NOI18N
        BtnDeconnexion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-sortie-20.png"))); // NOI18N
        BtnDeconnexion.setText("Se deconnecter");
        BtnDeconnexion.setMaximumSize(new java.awt.Dimension(156, 31));
        BtnDeconnexion.setMinimumSize(new java.awt.Dimension(156, 31));
        BtnDeconnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeconnexionActionPerformed(evt);
            }
        });

        BtnRapport.setFont(new java.awt.Font("Red Hat Text", 0, 15)); // NOI18N
        BtnRapport.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-fichier-de-rapport-20.png"))); // NOI18N
        BtnRapport.setText("Rapports");
        BtnRapport.setMaximumSize(new java.awt.Dimension(156, 31));
        BtnRapport.setMinimumSize(new java.awt.Dimension(156, 31));
        BtnRapport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRapportActionPerformed(evt);
            }
        });

        BtnReception.setFont(new java.awt.Font("Red Hat Text", 0, 15)); // NOI18N
        BtnReception.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-receive-20.png"))); // NOI18N
        BtnReception.setText("Reception de colis");
        BtnReception.setMaximumSize(new java.awt.Dimension(156, 31));
        BtnReception.setMinimumSize(new java.awt.Dimension(156, 31));
        BtnReception.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReceptionActionPerformed(evt);
            }
        });

        BtnParametre.setFont(new java.awt.Font("Red Hat Text", 0, 15)); // NOI18N
        BtnParametre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-paramètres-20.png"))); // NOI18N
        BtnParametre.setText("Paramètres");
        BtnParametre.setMaximumSize(new java.awt.Dimension(156, 31));
        BtnParametre.setMinimumSize(new java.awt.Dimension(156, 31));
        BtnParametre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnParametreActionPerformed(evt);
            }
        });

        BtnEnvoi.setFont(new java.awt.Font("Red Hat Text", 0, 15)); // NOI18N
        BtnEnvoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-envoyé-18.png"))); // NOI18N
        BtnEnvoi.setText("Envoi de colis");
        BtnEnvoi.setMaximumSize(new java.awt.Dimension(156, 31));
        BtnEnvoi.setMinimumSize(new java.awt.Dimension(156, 31));
        BtnEnvoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEnvoiActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/user.png"))); // NOI18N
        jLabel1.setText("Utilisateur connecte:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BtnEnvoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnReception, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnRapport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnParametre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnDeconnexion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, 0)
                                .addComponent(labelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(75, 75, 75))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnParametre, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnDeconnexion, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnRapport, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnReception, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnEnvoi, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelUsername;
    // End of variables declaration//GEN-END:variables
}
