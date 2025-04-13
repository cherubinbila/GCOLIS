package Views;

import Controllers.ConnexionBD;
import Controllers.LivraisonController;
import Models.Colis;
import Models.Destinataire;
import Models.Expediteur;
import Models.Livraison;

import javax.swing.*;
import java.sql.*;

public class EnvoiForm extends javax.swing.JFrame {

    LivraisonController livraisonControl = new LivraisonController();
    ConnexionBD connexionBD = new ConnexionBD();
    Livraison livraison = new Livraison();
    Expediteur expediteur = new Expediteur();
    Destinataire destinataire = new Destinataire();
    Colis colis = new Colis();
    PreparedStatement pst = null;
    ResultSet rs = null;

    public EnvoiForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        ComboBox();
    }

    private void ComboBox() {

        connexionBD.Connexion();
        String query = "select *  from Ville order by nom DESC";
        //Ville
        try {
            pst = connexionBD.conn.prepareStatement(query);
            rs = pst.executeQuery();
            CmbVilleExp.removeAllItems();
            CmbVilleDes.removeAllItems();

            while (rs.next()) {
                CmbVilleExp.addItem(rs.getString("nom"));
                CmbVilleDes.addItem(rs.getString("nom"));

            }
        } catch (SQLException ex) {
            //Logger.getLogger(forminscription.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Prix au kilo
        String query1 = "select * from PrixauKilo";
        try {
            pst = connexionBD.conn.prepareStatement(query1);
            rs = pst.executeQuery();
            while (rs.next()) {
                colis.setPrixAuKilo(rs.getDouble("prix"));
            }
            connexionBD.Deconnexion();
        } catch (SQLException ex) {
        }
        connexionBD.Deconnexion();
        PrixKg("0");

    }

    private void PrixKg(String Poids) {

        double poids = Double.parseDouble(Poids);
        double prixTotal = colis.getPrixAuKilo() * poids;
        TextePrix.setText(String.valueOf(prixTotal));

    }

    private void Entrer() {
        if (txtNomExp.getText().isEmpty() || TxtPrenomExp.getText().isEmpty()
                || TxtTelephoneExp.getText().isEmpty()
                || TxtNomDest.getText().isEmpty() || TxtPrenomDest.getText().isEmpty()
                || TxtType.getText().isEmpty() || TxtPoids.getText().isEmpty()
                || TxtNoPiece.getText().isEmpty() || TxtTelephoneDest.getText().isEmpty()
                || TxtTelephoneExp.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tous les champs sont obligatoires !", "Échec de l'authentification", JOptionPane.ERROR_MESSAGE);
        } else {
            expediteur.setNom(txtNomExp.getText());
            expediteur.setPrenom(TxtPrenomExp.getText());
            expediteur.setTelephone(TxtTelephoneExp.getText());
            expediteur.setTypePiece(CmbTypePiece.getSelectedItem().toString());
            expediteur.setNumeroPiece(TxtNoPiece.getText());
            expediteur.setVille(CmbVilleExp.getSelectedItem().toString());
            destinataire.setNom(TxtNomDest.getText());
            destinataire.setPrenom(TxtPrenomDest.getText());
            destinataire.setTelephone(TxtTelephoneDest.getText());
            destinataire.setVille(CmbVilleDes.getSelectedItem().toString());
            colis.setType(TxtType.getText());
            colis.setPoids(Double.parseDouble(TxtPoids.getText()));
            livraison.setPrix(Double.parseDouble(TextePrix.getText()));
            livraisonControl.Livraison(livraison, expediteur, destinataire, colis);

            ViderChamps();
        }
    }

    private void ViderChamps() {
        txtNomExp.setText("");
        TxtPrenomExp.setText("");
        TxtTelephoneExp.setText("");
        TxtNoPiece.setText("");
        CmbVilleExp.setSelectedIndex(0);
        CmbTypePiece.setSelectedIndex(0);
        TxtNomDest.setText("");
        TxtPrenomDest.setText("");
        TxtTelephoneDest.setText("");
        CmbVilleDes.setSelectedIndex(0);
        TxtType.setText("");
        TxtPoids.setText("");
        PrixKg("0");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNomExp = new javax.swing.JTextField();
        TxtPrenomExp = new javax.swing.JTextField();
        TxtTelephoneExp = new javax.swing.JTextField();
        TxtNoPiece = new javax.swing.JTextField();
        CmbTypePiece = new javax.swing.JComboBox<>();
        CmbVilleExp = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        TxtNomDest = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        TxtPrenomDest = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        TxtTelephoneDest = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        CmbVilleDes = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        TxtType = new javax.swing.JTextField();
        TxtPoids = new javax.swing.JTextField();
        TextePrix = new javax.swing.JLabel();
        BtnEnregistrer = new javax.swing.JButton();
        BtnAnnuler = new javax.swing.JButton();
        BtnSortie = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(250, 250, 250));

        jLabel1.setFont(new java.awt.Font("MADE Soulmaze", 0, 48)); // NOI18N
        jLabel1.setText("Envoi de Colis");

        jPanel1.setBackground(new java.awt.Color(250, 250, 250));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Expediteur", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Red Hat Text Regular", 0, 24))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        jLabel3.setText("Nom:");

        jLabel4.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        jLabel4.setText("Prenom:");

        jLabel5.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        jLabel5.setText("Telephone:");

        jLabel6.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        jLabel6.setText("Type de piece:");

        jLabel7.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        jLabel7.setText("No de piece: ");

        jLabel8.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        jLabel8.setText("Ville:");

        CmbTypePiece.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        CmbTypePiece.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CNIB", "Passport" }));

        CmbVilleExp.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        CmbVilleExp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CmbVilleExp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CmbVilleExpFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtNoPiece)
                    .addComponent(TxtTelephoneExp)
                    .addComponent(txtNomExp)
                    .addComponent(TxtPrenomExp)
                    .addComponent(CmbTypePiece, 0, 196, Short.MAX_VALUE)
                    .addComponent(CmbVilleExp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNomExp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtPrenomExp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtTelephoneExp, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CmbTypePiece, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtNoPiece, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CmbVilleExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Destinataire", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Red Hat Text Regular", 0, 24))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        jLabel9.setText("Nom:");

        jLabel10.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        jLabel10.setText("Prenom:");

        jLabel11.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        jLabel11.setText("Telephone:");

        jLabel12.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        jLabel12.setText("Ville:");

        CmbVilleDes.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        CmbVilleDes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtTelephoneDest)
                    .addComponent(TxtNomDest)
                    .addComponent(TxtPrenomDest, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                    .addComponent(CmbVilleDes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtNomDest, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtPrenomDest, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtTelephoneDest, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CmbVilleDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(250, 250, 250));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Colis", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Red Hat Text Regular", 0, 24))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        jLabel13.setText("Type:");

        jLabel14.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        jLabel14.setText("Poids:");

        jLabel15.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        jLabel15.setText("Prix:");

        TxtType.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N

        TxtPoids.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        TxtPoids.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtPoidsActionPerformed(evt);
            }
        });
        TxtPoids.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtPoidsKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtPoidsKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtPoidsKeyTyped(evt);
            }
        });

        TextePrix.setFont(new java.awt.Font("Noto Sans Mono CJK SC", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel13))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TxtType)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(TextePrix, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addComponent(TxtPoids))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(TxtType, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtPoids, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextePrix, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );

        BtnEnregistrer.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        BtnEnregistrer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/confirm.png"))); // NOI18N
        BtnEnregistrer.setText("Enregistrer");
        BtnEnregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEnregistrerActionPerformed(evt);
            }
        });

        BtnAnnuler.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        BtnAnnuler.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/btn_refresh.png"))); // NOI18N
        BtnAnnuler.setText("Annuler");
        BtnAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAnnulerActionPerformed(evt);
            }
        });

        BtnSortie.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        BtnSortie.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete_icon.png"))); // NOI18N
        BtnSortie.setText("Retour");
        BtnSortie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSortieActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(415, 415, 415)
                .addComponent(BtnEnregistrer)
                .addGap(18, 18, 18)
                .addComponent(BtnAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(BtnSortie, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(188, 188, 188))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnEnregistrer, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnSortie, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAnnulerActionPerformed

        ViderChamps();
    }//GEN-LAST:event_BtnAnnulerActionPerformed

    private void BtnEnregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEnregistrerActionPerformed

        Entrer();

    }//GEN-LAST:event_BtnEnregistrerActionPerformed

    private void BtnSortieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSortieActionPerformed

        this.dispose();
    }//GEN-LAST:event_BtnSortieActionPerformed

    private void TxtPoidsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtPoidsActionPerformed

    }//GEN-LAST:event_TxtPoidsActionPerformed

    private void CmbVilleExpFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CmbVilleExpFocusGained

    }//GEN-LAST:event_CmbVilleExpFocusGained

    private void TxtPoidsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPoidsKeyTyped

    }//GEN-LAST:event_TxtPoidsKeyTyped

    private void TxtPoidsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPoidsKeyPressed
           }//GEN-LAST:event_TxtPoidsKeyPressed

    private void TxtPoidsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtPoidsKeyReleased
        String Poids = TxtPoids.getText();
        if (TxtPoids.getText().isEmpty()) {
            PrixKg("0");
        }
        if (Poids.matches("^-?\\d+(\\.\\d+)?([eE][-+]?\\d+)?$")) {
            PrixKg(Poids);
        }
    }//GEN-LAST:event_TxtPoidsKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAnnuler;
    private javax.swing.JButton BtnEnregistrer;
    private javax.swing.JButton BtnSortie;
    private javax.swing.JComboBox<String> CmbTypePiece;
    private javax.swing.JComboBox<String> CmbVilleDes;
    private javax.swing.JComboBox<String> CmbVilleExp;
    private javax.swing.JLabel TextePrix;
    private javax.swing.JTextField TxtNoPiece;
    private javax.swing.JTextField TxtNomDest;
    private javax.swing.JTextField TxtPoids;
    private javax.swing.JTextField TxtPrenomDest;
    private javax.swing.JTextField TxtPrenomExp;
    private javax.swing.JTextField TxtTelephoneDest;
    private javax.swing.JTextField TxtTelephoneExp;
    private javax.swing.JTextField TxtType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtNomExp;
    // End of variables declaration//GEN-END:variables
}
