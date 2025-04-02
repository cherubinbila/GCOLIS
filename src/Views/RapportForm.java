/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Controllers.ConnexionBD;
import Controllers.LivraisonController;
import Controllers.PrintController;
import Models.Colis;
import Models.Destinataire;
import Models.Expediteur;
import Models.Livraison;

import javax.swing.table.DefaultTableModel;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RapportForm extends javax.swing.JFrame {

    ConnexionBD connexionBD = new ConnexionBD();
    PreparedStatement pst = null;
    ResultSet rs = null;
    PrintController printController = new PrintController();

    /**
     * Creates new form RapportForm
     */
    public RapportForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        Rafraichir("annee");
        Donnees("annee");
    }

    private void ComboBox() {

    }

//    private void Rafraichir() {
//        connexionBD.Connexion();
//        String[] colonne = {"ID", "Nom de l'expediteur", "Nom du destinataire", "Type de colis", "Poids", "Ville d'expedition", "Ville de destination", "Date de livraison"};
//        String query = "select * from Livraison";
//        String[] ligne = new String[8];
//        String[] nomExp = new String[2];
//        String[] nomDes = new String[2];
//        DefaultTableModel model = new DefaultTableModel(null, colonne);
//
//
//        try {
//            pst = connexionBD.conn.prepareStatement(query);
//            rs = pst.executeQuery();
//
//            while (rs.next()) {
//
//                nomExp[0] = rs.getString("nomExp");
//                nomExp[1] = rs.getString("prenomExp");
//
//                nomDes[0] = rs.getString("nomDes");
//                nomDes[1] = rs.getString("prenomDes");
//
//                ligne[0] = rs.getString("ID");
//                ligne[1] = nomExp[0] + " " + nomExp[1];
//                ligne[2] = nomDes[0] + " " + nomDes[1];
//                ligne[3] = rs.getString("typeColis");
//                ligne[4] = rs.getString("poidsColis");
//                ligne[5] = rs.getString("villeExp");
//                ligne[6] = rs.getString("villeDes");
//                ligne[7] = rs.getString("dateExp");
//
//                model.addRow(ligne);
//
//                /*Object o[] = {
//                    rs.getInt("ID"), // ID est probablement un entier
//                    rs.getString("nomExp"), // Nom de l'expediteur
//                    rs.getString("nomDes"), // Nom du destinataire
//                    rs.getString("typeColis"), // Type de colis
//                    rs.getDouble("poidsColis"), // Poids
//                    rs.getString("villeExp"), // Ville d'expedition
//                    rs.getString("villeDes"), // Ville de destination
//                    rs.getDate("dateExp") // Date de livraison
//                };
//                model.addRow(o);*/
//            }
//
//            // N'oubliez pas de fermer les ressources
//            pst.close();
//            rs.close();
//
//            // Mettre à jour le tableau avec le modèle
//            TabLivraison.setModel(model);
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            // Fermer la connexion à la base de données
//            connexionBD.Deconnexion();
//        }
//    }
    private void Donnees(String periode) {
        connexionBD.Connexion();
        String query = "SELECT COUNT(*) AS nb_colis_total, COUNT(CASE WHEN isRec = 1 THEN 1 ELSE NULL END) AS nb_colis_envoyes, COUNT(CASE WHEN isRec = 0 THEN 1 ELSE NULL END) AS nb_colis_en_attente FROM Livraison";

        // Ajouter le filtre de période selon le paramètre
        switch (periode.toLowerCase()) {
            case "jour":
                query += " WHERE dateExp = CURDATE()";
                break;
            case "semaine":
                query += " WHERE YEARWEEK(dateExp, 1) = YEARWEEK(CURDATE(), 1)";
                break;
            case "mois":
                query += " WHERE MONTH(dateExp) = MONTH(CURDATE()) AND YEAR(dateExp) = YEAR(CURDATE())";
                break;
            case "annee":
                query += " WHERE YEAR(dateExp) = YEAR(CURDATE())";
                break;
            // Par défaut, pas de filtre (toutes les données)
        }

        try {
            pst = connexionBD.conn.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                TxtColisEnvoyes.setText(rs.getString("nb_colis_envoyes"));
                TxtColisAttente.setText(rs.getString("nb_colis_en_attente"));
            }

            pst.close();
            rs.close();
        } catch (SQLException e) {
            connexionBD.Deconnexion();
        }

        query = "SELECT SUM(prixLivraison) AS prix_total FROM Livraison";

        // Ajouter le filtre de période selon le paramètre
        switch (periode.toLowerCase()) {
            case "jour":
                query += " WHERE dateExp = CURDATE()";
                break;
            case "semaine":
                query += " WHERE YEARWEEK(dateExp, 1) = YEARWEEK(CURDATE(), 1)";
                break;
            case "mois":
                query += " WHERE MONTH(dateExp) = MONTH(CURDATE()) AND YEAR(dateExp) = YEAR(CURDATE())";
                break;
            case "annee":
                query += " WHERE YEAR(dateExp) = YEAR(CURDATE())";
                break;
            // Par défaut, pas de filtre (toutes les données)
        }

        try {
            pst = connexionBD.conn.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                TxtChiffreAffaire.setText(rs.getString("prix_total") + " FCFA");
            }

            pst.close();
            rs.close();
        } catch (SQLException e) {
            connexionBD.Deconnexion();
        }
    }

    private void Rafraichir(String periode) {
        connexionBD.Connexion();
        String[] colonne = {"ID", "Nom de l'expediteur", "Nom du destinataire", "Type de colis", "Poids", "Ville d'expedition", "Ville de destination", "Date de livraison"};
        String query = "SELECT * FROM Livraison";

        // Ajouter le filtre de période selon le paramètre
        switch (periode.toLowerCase()) {
            case "jour":
                query += " WHERE dateExp = CURDATE()";
                break;
            case "semaine":
                query += " WHERE YEARWEEK(dateExp, 1) = YEARWEEK(CURDATE(), 1)";
                break;
            case "mois":
                query += " WHERE MONTH(dateExp) = MONTH(CURDATE()) AND YEAR(dateExp) = YEAR(CURDATE())";
                break;
            case "annee":
                query += " WHERE YEAR(dateExp) = YEAR(CURDATE())";
                break;
            // Par défaut, pas de filtre (toutes les données)
        }

        String[] ligne = new String[8];
        String[] nomExp = new String[2];
        String[] nomDes = new String[2];
        DefaultTableModel model = new DefaultTableModel(null, colonne);

        try {
            pst = connexionBD.conn.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                nomExp[0] = rs.getString("nomExp");
                nomExp[1] = rs.getString("prenomExp");

                nomDes[0] = rs.getString("nomDes");
                nomDes[1] = rs.getString("prenomDes");

                ligne[0] = rs.getString("ID");
                ligne[1] = nomExp[0] + " " + nomExp[1];
                ligne[2] = nomDes[0] + " " + nomDes[1];
                ligne[3] = rs.getString("typeColis");
                ligne[4] = rs.getString("poidsColis");
                ligne[5] = rs.getString("villeExp");
                ligne[6] = rs.getString("villeDes");
                ligne[7] = rs.getString("dateExp");

                model.addRow(ligne);
            }

            pst.close();
            rs.close();
            TabLivraison.setModel(model);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connexionBD.Deconnexion();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabLivraison = new javax.swing.JTable();
        BtnRetour = new javax.swing.JButton();
        BtnImprimer = new javax.swing.JButton();
        BtnActualiser = new javax.swing.JButton();
        CmbPeriode = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        CmbPeriode1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TxtColisEnvoyes = new javax.swing.JLabel();
        TxtColisAttente = new javax.swing.JLabel();
        TxtChiffreAffaire = new javax.swing.JLabel();
        BtnAnnuler1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font("Red Hat Text Regular", 0, 24)); // NOI18N

        TabLivraison.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        TabLivraison.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TabLivraison.setRowHeight(30);
        TabLivraison.setRowMargin(5);
        TabLivraison.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        TabLivraison.setUpdateSelectionOnSort(false);
        jScrollPane1.setViewportView(TabLivraison);

        BtnRetour.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        BtnRetour.setText("Retour");
        BtnRetour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRetourActionPerformed(evt);
            }
        });

        BtnImprimer.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        BtnImprimer.setText("Imprimer");
        BtnImprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnImprimerActionPerformed(evt);
            }
        });

        BtnActualiser.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        BtnActualiser.setText("Actualiser");
        BtnActualiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualiserActionPerformed(evt);
            }
        });

        CmbPeriode.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        CmbPeriode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tout", "jour", "semaine", "mois", "annee" }));
        CmbPeriode.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbPeriodeItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        jLabel3.setText("Periode");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BtnActualiser)
                        .addGap(18, 18, 18)
                        .addComponent(BtnImprimer)
                        .addGap(18, 18, 18)
                        .addComponent(BtnRetour))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(603, 603, 603)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(CmbPeriode, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 977, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CmbPeriode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnRetour)
                    .addComponent(BtnImprimer)
                    .addComponent(BtnActualiser))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Liste des livraisons", jPanel1);

        jLabel4.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        jLabel4.setText("Periode");

        CmbPeriode1.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        CmbPeriode1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "tout", "jour", "semaine", "mois", "annee" }));
        CmbPeriode1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbPeriode1ItemStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        jLabel5.setText("Nombre de colis envoyes");

        jLabel6.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        jLabel6.setText("Nombre de colis en attente");

        jLabel7.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        jLabel7.setText("Chiffre d'affaire");

        TxtColisEnvoyes.setFont(new java.awt.Font("Red Hat Text Regular", 1, 18)); // NOI18N
        TxtColisEnvoyes.setText("jLabel8");

        TxtColisAttente.setFont(new java.awt.Font("Red Hat Text Regular", 1, 18)); // NOI18N
        TxtColisAttente.setText("jLabel9");

        TxtChiffreAffaire.setFont(new java.awt.Font("Red Hat Text Regular", 1, 18)); // NOI18N
        TxtChiffreAffaire.setText("jLabel10");

        BtnAnnuler1.setFont(new java.awt.Font("Red Hat Text Regular", 0, 18)); // NOI18N
        BtnAnnuler1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete_icon.png"))); // NOI18N
        BtnAnnuler1.setText("Retour");
        BtnAnnuler1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAnnuler1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnAnnuler1)
                    .addComponent(CmbPeriode1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtColisEnvoyes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtColisAttente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TxtChiffreAffaire, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))
                .addGap(446, 446, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(CmbPeriode1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(TxtColisEnvoyes))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(TxtColisAttente))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(TxtChiffreAffaire))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
                .addComponent(BtnAnnuler1)
                .addGap(41, 41, 41))
        );

        jTabbedPane1.addTab("Statistiques", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnActualiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualiserActionPerformed
        Rafraichir(CmbPeriode.getSelectedItem().toString());
    }//GEN-LAST:event_BtnActualiserActionPerformed

    private void CmbPeriodeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CmbPeriodeItemStateChanged
        Rafraichir(CmbPeriode.getSelectedItem().toString());
    }//GEN-LAST:event_CmbPeriodeItemStateChanged

    private void CmbPeriode1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CmbPeriode1ItemStateChanged
        Donnees(CmbPeriode1.getSelectedItem().toString());
    }//GEN-LAST:event_CmbPeriode1ItemStateChanged

    private void BtnRetourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRetourActionPerformed
        this.dispose();
    }//GEN-LAST:event_BtnRetourActionPerformed

    private void BtnAnnuler1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAnnuler1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_BtnAnnuler1ActionPerformed

    private void BtnImprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnImprimerActionPerformed
        try {
            printController.ImprimerListeLivraisons(CmbPeriode.getSelectedItem().toString());
        } catch (IOException ex) {
            Logger.getLogger(RapportForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtnImprimerActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnActualiser;
    private javax.swing.JButton BtnAnnuler1;
    private javax.swing.JButton BtnImprimer;
    private javax.swing.JButton BtnRetour;
    private javax.swing.JComboBox<String> CmbPeriode;
    private javax.swing.JComboBox<String> CmbPeriode1;
    private javax.swing.JTable TabLivraison;
    private javax.swing.JLabel TxtChiffreAffaire;
    private javax.swing.JLabel TxtColisAttente;
    private javax.swing.JLabel TxtColisEnvoyes;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
