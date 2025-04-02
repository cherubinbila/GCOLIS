package Views;

import Controllers.ConnexionBD;
import Controllers.ReceptionController;
import Models.*;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ReceptionForm extends javax.swing.JFrame {

    ConnexionBD connexionBD = new ConnexionBD();
    ReceptionController receptionController = new ReceptionController();
    Livraison livraison = new Livraison();
    Recepteur recepteur = new Recepteur();
    Destinataire destinataire = new Destinataire();
    PreparedStatement pst = null;
    ResultSet rs = null;

    public ReceptionForm() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void recherche() {
        String query = "select * from Livraison where id = ?";
        connexionBD.Connexion();
        try {
            pst = connexionBD.conn.prepareStatement(query);
            pst.setString(1, TxtRechercher.getText());
            rs = pst.executeQuery();

            if (!rs.next()) {
                ViderChamps();
                JOptionPane.showMessageDialog(null, "Livraison introuvable!", "Échec de la recherche", JOptionPane.ERROR_MESSAGE);
            } else {
                String[] nomDes = new String[2];
                boolean isRec;

                do {
                    nomDes[0] = rs.getString("nomDes");
                    nomDes[1] = rs.getString("prenomDes");
                    isRec = rs.getBoolean("isRec");
                    if (!isRec) {
                        TxtNomDes.setText(nomDes[0] + " " + nomDes[1]);
                        TxtTelephoneDes.setText(rs.getString("telephoneDes"));
                        TxtNomDes.setEnabled(false);
                        TxtTelephoneDes.setEnabled(false);
                        TxtNomDes.setDisabledTextColor(new java.awt.Color(0, 0, 0));
                        TxtTelephoneDes.setDisabledTextColor(new java.awt.Color(0, 0, 0));
                    } else {
                        ViderChamps();
                        JOptionPane.showMessageDialog(null, "Livraison deja receptionnee !", "Échec de la recherche", JOptionPane.ERROR_MESSAGE);
                    }
                } while (rs.next());
            }

            connexionBD.Deconnexion();

        } catch (SQLException e) {
            System.err.println("a");
            JOptionPane.showMessageDialog(null, "Erreur lors de la recherche!", "Échec de la recherche", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void Entrer() {
        if (TxtTelephoneDes.getText().isEmpty() || TxtNomRec.getText().isEmpty() || TxtTelephoneRec.getText().isEmpty() || TxtNopiece.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tous les champs sont obligatoires !", "Échec de la recherche", JOptionPane.ERROR_MESSAGE);
        } else {
            livraison.setId_livraison(Integer.parseInt(TxtRechercher.getText()));
            destinataire.setNom(TxtNomDes.getText());
            destinataire.setTelephone(TxtTelephoneDes.getText());
            destinataire.setTypePiece(CmbTypePDes.getSelectedItem().toString());
            destinataire.setNumeroPiece(TxtNoPDes.getText());
            recepteur.setNom(TxtNomRec.getText());
            recepteur.setPrenom(TxtPrenomRec.getText());
            recepteur.setTelephone(TxtTelephoneRec.getText());
            recepteur.setTypePiece(CmbTypePRec.getSelectedItem().toString());
            recepteur.setNumeroPiece(TxtNopiece.getText());

            receptionController.Reception(livraison, destinataire, recepteur);

            ViderChamps();
        }
    }

    private void ViderChamps() {
        TxtRechercher.setText("");
        TxtNomDes.setText("");
        TxtTelephoneDes.setText("");
        TxtNomRec.setText("");
        TxtPrenomRec.setText("");
        TxtTelephoneRec.setText("");
        TxtNopiece.setText("");
        TxtNoPDes.setText("");
        CmbTypePDes.setSelectedIndex(0);
        CmbTypePRec.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        TxtRechercher = new javax.swing.JTextField();
        BtnRechercher = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        TxtNopiece = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        CmbTypePRec = new javax.swing.JComboBox<>();
        TxtTelephoneRec = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        TxtNomRec = new javax.swing.JTextField();
        Prenom = new javax.swing.JLabel();
        TxtPrenomRec = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TxtNoPDes = new javax.swing.JTextField();
        TxtTelephoneDes = new javax.swing.JTextField();
        TxtNomDes = new javax.swing.JTextField();
        CmbTypePDes = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        BtnAnnuler = new javax.swing.JButton();
        BtnRetour = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("MADE Soulmaze", 0, 48)); // NOI18N
        jLabel3.setText("Reception de colis");

        jLabel1.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        jLabel1.setText("Identifiant:");

        TxtRechercher.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N

        BtnRechercher.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        BtnRechercher.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/procurar.png"))); // NOI18N
        BtnRechercher.setText("Rechercher");
        BtnRechercher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRechercherActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Reception", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Red Hat Text Regular", 0, 24))); // NOI18N

        TxtNopiece.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        jLabel8.setText("No piece:");

        jLabel9.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        jLabel9.setText("Type de piece:");

        CmbTypePRec.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        CmbTypePRec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CNIB", "Passport" }));

        TxtTelephoneRec.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        jLabel10.setText("Telephone:");

        jLabel11.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        jLabel11.setText("Nom:");

        TxtNomRec.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N

        Prenom.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        Prenom.setText("Prenom");

        TxtPrenomRec.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(Prenom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtNopiece)
                    .addComponent(CmbTypePRec, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtTelephoneRec)
                    .addComponent(TxtNomRec, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                    .addComponent(TxtPrenomRec))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(TxtNomRec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Prenom)
                    .addComponent(TxtPrenomRec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(TxtTelephoneRec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(CmbTypePRec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TxtNopiece, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Destination", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Red Hat Text Regular", 0, 24))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        jLabel4.setText("Telephone:");

        jLabel5.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        jLabel5.setText("Type de piece:");

        jLabel6.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        jLabel6.setText("No piece:");

        TxtNoPDes.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N

        TxtTelephoneDes.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        TxtTelephoneDes.setEnabled(false);

        TxtNomDes.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        TxtNomDes.setEnabled(false);

        CmbTypePDes.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        CmbTypePDes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CNIB", "Passport" }));

        jLabel2.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        jLabel2.setText("Nom:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CmbTypePDes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtNoPDes)
                    .addComponent(TxtTelephoneDes)
                    .addComponent(TxtNomDes, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtNomDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TxtTelephoneDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(CmbTypePDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TxtNoPDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/accept.png"))); // NOI18N
        jButton1.setText("Enregistrer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        BtnAnnuler.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        BtnAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete_icon.png"))); // NOI18N
        BtnAnnuler.setText("Annuler");
        BtnAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAnnulerActionPerformed(evt);
            }
        });

        BtnRetour.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        BtnRetour.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/arrow_left.png"))); // NOI18N
        BtnRetour.setText("Retour");
        BtnRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRetourActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TxtRechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnRechercher))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(BtnAnnuler)
                                .addGap(18, 18, 18)
                                .addComponent(BtnRetour)))))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(163, 163, 163))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel3)
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtRechercher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnRechercher))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnAnnuler)
                    .addComponent(BtnRetour)
                    .addComponent(jButton1))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnRechercherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRechercherActionPerformed
        if (TxtRechercher.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Champs de recherche vide !", "Échec de la recherche", JOptionPane.ERROR_MESSAGE);
        } else {
            recherche();
        }
    }//GEN-LAST:event_BtnRechercherActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Entrer();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void BtnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAnnulerActionPerformed
        ViderChamps();
    }//GEN-LAST:event_BtnAnnulerActionPerformed

    private void BtnRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRetourActionPerformed
        this.dispose();
    }//GEN-LAST:event_BtnRetourActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAnnuler;
    private javax.swing.JButton BtnRechercher;
    private javax.swing.JButton BtnRetour;
    private javax.swing.JComboBox<String> CmbTypePDes;
    private javax.swing.JComboBox<String> CmbTypePRec;
    private javax.swing.JLabel Prenom;
    private javax.swing.JTextField TxtNoPDes;
    private javax.swing.JTextField TxtNomDes;
    private javax.swing.JTextField TxtNomRec;
    private javax.swing.JTextField TxtNopiece;
    private javax.swing.JTextField TxtPrenomRec;
    private javax.swing.JTextField TxtRechercher;
    private javax.swing.JTextField TxtTelephoneDes;
    private javax.swing.JTextField TxtTelephoneRec;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
