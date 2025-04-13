package Views;

import Controllers.ConnexionBD;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginForm extends javax.swing.JFrame {

    ResultSet rs = null;
    PreparedStatement pst = null;

    ConnexionBD connexion = new ConnexionBD();

    public LoginForm() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void Entrer() {

        String query = "Select * from User where nom=? and password=?";
        try {

            pst = connexion.conn.prepareStatement(query);
            pst.setString(1, TextUsername.getText());
            pst.setString(2, TextUserPassword.getText());

            rs = pst.executeQuery();

            if (rs.next()) {
                try {
                    pst.close();
                    rs.close();
                    connexion.Deconnexion();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Il n'a pas été possible de se déconnecter !", "Echec de la deconnexion", JOptionPane.ERROR_MESSAGE);
                }
                JOptionPane.showMessageDialog(null, "Bienvenue: " + TextUsername.getText(), "Accès au Système", JOptionPane.INFORMATION_MESSAGE);
                new PrincipalForm(TextUsername.getText()).setVisible(true);
                this.dispose();
            } else if (TextUsername.getText().isEmpty() && TextUserPassword.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Champs d'utilisateur et de mot de passe vides !", "Échec de l'authentification", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Utilisateur ou mot de passe incorrects !", "Échec de l'authentification", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Utilisateur ou mot de passe incorrects !", "Échec de l'authentification", JOptionPane.ERROR_MESSAGE);
            System.err.println("Erreur de connexion à la base de données.");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TextUsername = new javax.swing.JTextField();
        TextUserPassword = new javax.swing.JPasswordField();
        BtnQuitter = new javax.swing.JButton();
        BtnConnexion = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(250, 250, 250));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("JetBrains Mono", 0, 24)); // NOI18N
        jLabel1.setText("Bienvenue sur GColis");

        jLabel2.setFont(new java.awt.Font("JetBrains Mono", 0, 18)); // NOI18N
        jLabel2.setText("Nom d'utilisateur");

        jLabel3.setFont(new java.awt.Font("JetBrains Mono", 0, 18)); // NOI18N
        jLabel3.setText("Mot de passe");

        TextUsername.setFont(new java.awt.Font("JetBrains Mono", 0, 15)); // NOI18N

        TextUserPassword.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        TextUserPassword.setToolTipText("");
        TextUserPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TextUserPasswordKeyPressed(evt);
            }
        });

        BtnQuitter.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        BtnQuitter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/exit.png"))); // NOI18N
        BtnQuitter.setText("Quitter");
        BtnQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnQuitterActionPerformed(evt);
            }
        });

        BtnConnexion.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        BtnConnexion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/confirm.png"))); // NOI18N
        BtnConnexion.setText("Se connecter");
        BtnConnexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConnexionActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ai-generated-8793863_640.jpg"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-boîte-128.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(493, 493, 493)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(BtnConnexion, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BtnQuitter))
                                .addComponent(TextUserPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addGap(212, 212, 212)))
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel6)
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TextUserPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnConnexion, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnQuitter, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel4))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnConnexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConnexionActionPerformed

        if (connexion.Status() == false) {
            System.err.println("Erreur de connexion à la base de données.");
            JOptionPane.showMessageDialog(null, "Base de données non connectée !", "Échec de l'authentification", JOptionPane.ERROR_MESSAGE);
        } else {
            Entrer();
        }

    }//GEN-LAST:event_BtnConnexionActionPerformed

    private void TextUserPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextUserPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Entrer();
        }
    }//GEN-LAST:event_TextUserPasswordKeyPressed

    private void BtnQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnQuitterActionPerformed
        System.exit(0);
    }//GEN-LAST:event_BtnQuitterActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnConnexion;
    private javax.swing.JButton BtnQuitter;
    private javax.swing.JPasswordField TextUserPassword;
    private javax.swing.JTextField TextUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
