
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author btorralba
 */
public  class  RailroadFrame extends javax.swing.JFrame implements Observateur, Serializable {


    private static final ImageIcon DESERT = new ImageIcon("./src/imgs/Texture 100x100/desert.png");
    private static final ImageIcon DESERTSELECTION = new ImageIcon("./src/imgs/Texture 100x100/desertSelection.png");
    
    private static final ImageIcon VILLE = new ImageIcon("./src/imgs/Texture 100x100/ville.png");
    private static final ImageIcon VILLESELECTION = new ImageIcon("./src/imgs/Texture 100x100/villeSelection.png");
    
    
    private static final ImageIcon RAILV = new ImageIcon("./src/imgs/Texture 100x100/railsV.png");
    private static final ImageIcon RAILH = new ImageIcon("./src/imgs/Texture 100x100/railsH.png");
    private static final ImageIcon RAIL = new ImageIcon("./src/imgs/Texture 100x100/railsH.png");
    
    ArrayList<int[]> trajet = new ArrayList();
    
    /**
     * Creates new form RailroadFrame
     */
    JLabel[][] jboard;
    Modele modele;
    
    public RailroadFrame(Modele m) {
        initComponents();
        
        modele=m;
        
        
    // Pannel disposé en grille 8*8
        panelJeu.setLayout(new GridLayout(7,7));
        
    // board composé de jlabel    
        jboard = new JLabel[7][7];
         for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                // init case desert
                jboard[i][j] = new JLabel(DESERT);
                panelJeu.add(jboard[i][j]);
               jboard[i][j].addMouseListener(
                new CaseControler(i,j));
                }
   
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jMenuItem7 = new javax.swing.JMenuItem();
        panelJeu = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabelLimogesLait = new javax.swing.JLabel();
        jLabelTomstoneBois = new javax.swing.JLabel();
        jLabelLimogesFer = new javax.swing.JLabel();
        jLabelTomstoneFer = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelTomstoneCereales = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaInformations = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jLabelHillValley2 = new javax.swing.JLabel();
        jLabelHillValley1 = new javax.swing.JLabel();
        jLabelHillValley3 = new javax.swing.JLabel();
        jLabelHillValleyBois = new javax.swing.JLabel();
        jLabelHillValleyFer = new javax.swing.JLabel();
        jLabelHillValleyCereales = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPane4 = new javax.swing.JTextPane();
        jLabelHillValley4 = new javax.swing.JLabel();
        jLabelHillValley5 = new javax.swing.JLabel();
        jLabelHillValley6 = new javax.swing.JLabel();
        jLabelSantaFeBois = new javax.swing.JLabel();
        jLabelSantaFeFer = new javax.swing.JLabel();
        jLabelSantaFeCereales = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuSauvegarder = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        jMenuItem7.setText("jMenuItem7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 51, 0));
        setForeground(java.awt.Color.white);
        setResizable(false);

        panelJeu.setPreferredSize(new java.awt.Dimension(600, 600));

        javax.swing.GroupLayout panelJeuLayout = new javax.swing.GroupLayout(panelJeu);
        panelJeu.setLayout(panelJeuLayout);
        panelJeuLayout.setHorizontalGroup(
            panelJeuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        panelJeuLayout.setVerticalGroup(
            panelJeuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(175, 122, 68));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Wide Latin", 0, 10)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("PLACER RAILS");
        jButton1.setActionCommand("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Wide Latin", 0, 10)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("SUPPRIMER RAILS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextPane1.setText("Score :");
        jTextPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(jTextPane1);

        jLabelLimogesLait.setText("Cereales :");

        jLabelLimogesFer.setText("Fer :");

        jLabel6.setText("Bois :");

        jTextAreaInformations.setColumns(20);
        jTextAreaInformations.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextAreaInformations.setLineWrap(true);
        jTextAreaInformations.setRows(5);
        jScrollPane2.setViewportView(jTextAreaInformations);

        jLabel8.setFont(new java.awt.Font("Wide Latin", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Informations :");

        jTextPane2.setText("Tombstone");
        jScrollPane3.setViewportView(jTextPane2);

        jTextPane3.setText("Hill Valley");
        jScrollPane4.setViewportView(jTextPane3);

        jLabelHillValley2.setText("Fer :");

        jLabelHillValley1.setText("Bois :");

        jLabelHillValley3.setText("Cereales :");

        jLabelHillValleyBois.setText("jLabel1");

        jLabelHillValleyFer.setText("jLabel2");

        jLabelHillValleyCereales.setText("jLabel3");

        jTextPane4.setText("Santa Fe");
        jScrollPane5.setViewportView(jTextPane4);

        jLabelHillValley4.setText("Bois :");

        jLabelHillValley5.setText("Fer :");

        jLabelHillValley6.setText("Cereales :");

        jLabelSantaFeBois.setText("jLabel1");

        jLabelSantaFeFer.setText("jLabel2");

        jLabelSantaFeCereales.setText("jLabel3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelLimogesLait)
                            .addComponent(jLabel6)
                            .addComponent(jLabelLimogesFer))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTomstoneBois, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelTomstoneCereales, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelTomstoneFer, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelHillValley3)
                                    .addComponent(jLabelHillValley1)
                                    .addComponent(jLabelHillValley2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelHillValleyBois)
                                    .addComponent(jLabelHillValleyFer)
                                    .addComponent(jLabelHillValleyCereales)))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelHillValley6)
                                    .addComponent(jLabelHillValley4)
                                    .addComponent(jLabelHillValley5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelSantaFeBois)
                                    .addComponent(jLabelSantaFeFer)
                                    .addComponent(jLabelSantaFeCereales))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabelTomstoneBois, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLimogesFer)
                    .addComponent(jLabelTomstoneFer, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLimogesLait)
                    .addComponent(jLabelTomstoneCereales, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHillValley1)
                    .addComponent(jLabelHillValleyBois))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHillValley2)
                    .addComponent(jLabelHillValleyFer))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHillValley3)
                    .addComponent(jLabelHillValleyCereales))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelHillValley4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelHillValley5)
                        .addGap(10, 10, 10)
                        .addComponent(jLabelHillValley6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelSantaFeBois)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelSantaFeFer)
                        .addGap(10, 10, 10)
                        .addComponent(jLabelSantaFeCereales)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jButton1.getAccessibleContext().setAccessibleName("placerRails");

        jMenu1.setText("Partie");

        jMenuItem8.setText("Nouvelle Partie");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuBar1.add(jMenu1);

        jMenuSauvegarder.setText("Sauvegarder");
        jMenuSauvegarder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSauvegarderActionPerformed(evt);
            }
        });

        jMenuItem1.setText("Emplacement 1");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuSauvegarder.add(jMenuItem1);

        jMenuItem2.setText("Emplacement 2");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenuSauvegarder.add(jMenuItem2);

        jMenuItem3.setText("Emplacement 3");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenuSauvegarder.add(jMenuItem3);

        jMenuBar1.add(jMenuSauvegarder);

        jMenu2.setText("Charger");

        jMenuItem6.setText("Emplacement 1");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem4.setText("Emplacement 2");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem4);

        jMenuItem5.setText("Emplacement 3");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelJeu, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelJeu, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Bouton placer rail
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            modele.placerRails(trajet);
        } catch (InterruptedException ex) {
            Logger.getLogger(RailroadFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    modele.supprimerRails(trajet);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuSauvegarderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSauvegarderActionPerformed

    }//GEN-LAST:event_jMenuSauvegarderActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
            try {
            modele.sauvegarder("0");        // TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(RailroadFrame.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        try {
            modele.sauvegarder("1");
        } catch (IOException ex) {
            Logger.getLogger(RailroadFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        try {
            modele.sauvegarder("2");
        } catch (IOException ex) {
            Logger.getLogger(RailroadFrame.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        try {
            modele.charger("2");
        } catch (IOException ex) {
            Logger.getLogger(RailroadFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RailroadFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
 
        try { 
            modele.charger("1");
        } catch (IOException ex) {
            Logger.getLogger(RailroadFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RailroadFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        try {           
            modele.charger("3");
        } catch (IOException ex) {
            Logger.getLogger(RailroadFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RailroadFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
            // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem8ActionPerformed

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
            java.util.logging.Logger.getLogger(RailroadFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RailroadFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RailroadFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RailroadFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                
                //new RailroadFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelHillValley1;
    private javax.swing.JLabel jLabelHillValley2;
    private javax.swing.JLabel jLabelHillValley3;
    private javax.swing.JLabel jLabelHillValley4;
    private javax.swing.JLabel jLabelHillValley5;
    private javax.swing.JLabel jLabelHillValley6;
    private javax.swing.JLabel jLabelHillValleyBois;
    private javax.swing.JLabel jLabelHillValleyCereales;
    private javax.swing.JLabel jLabelHillValleyFer;
    private javax.swing.JLabel jLabelLimogesFer;
    private javax.swing.JLabel jLabelLimogesLait;
    private javax.swing.JLabel jLabelSantaFeBois;
    private javax.swing.JLabel jLabelSantaFeCereales;
    private javax.swing.JLabel jLabelSantaFeFer;
    private javax.swing.JLabel jLabelTomstoneBois;
    private javax.swing.JLabel jLabelTomstoneCereales;
    private javax.swing.JLabel jLabelTomstoneFer;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenu jMenuSauvegarder;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextAreaInformations;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTextPane jTextPane4;
    private javax.swing.JPanel panelJeu;
    // End of variables declaration//GEN-END:variables

    
    @Override
    public void avertirSelection(int i, int j, Case c) {
        
        jboard[i][j].setIcon(c.getTextureSelection());
    }
    
    @Override
    public void avertirDeselection(int i, int j, Case c){
        jboard[i][j].setIcon(c.getTexture());
    }
    
    @Override
    public void avertirChangementCase(int i, int j, Case c) {
        jboard[i][j].setIcon(c.getTexture());
    }
    
    @Override
    public void avertirTrainTrue(int i, int j, Case c) {
        jboard[i][j].setIcon(((Rail)c).getTextureTrain());
        
    }
    
    @Override
    public void avertirInformation(String s){
        //jTextAreaInformations.setText("null");
        jTextAreaInformations.setText(s);
    }
    
    @Override
    public void avertirTrainFalse(int i, int j, Case c) {
        jboard[i][j].setIcon(((Rail)c).getTexture());
        
    }
        
    @Override
    public void avertirCreationRessource(){
        
        jLabelTomstoneBois.setText( String.valueOf(modele.getVilles().get(2).getStock().get(0).getQuantite()));
        jLabelSantaFeBois.setText( String.valueOf(modele.getVilles().get(4).getStock().get(1).getQuantite()));
        jTextPane1.setText(Long.toString(modele.getPoint()));
        
        
    }
        
    @Override
    public void rafraichir(){
        for (int i=0; i<7;i++){
            for (int j=0; j<7;j++){
               
                 jboard[i][j].setIcon(modele.getMap()[i][j].getTexture());
                

            }
        }
        //avertirCreationRessource();
    }
    
    

    
    
    
    //Mouvement souris
     class CaseControler extends MouseAdapter {
        int i;
        int j;

        public CaseControler(int _i, int _j){
            i = _i;
            j = _j;
        }

    //action de clic
        @Override
        public void mouseClicked(MouseEvent e)
        {
            int tab[] = {i,j};
            
            System.out.println(i + " " + j);
            
            if(modele.getCase(i, j) instanceof Obstacle==false){
                //Si case non selectionné on change icone, et on enregistre ses coordonnées dans trajet
                if (modele.getCase(i, j).isSelection()==false){
                    modele.getCase(i, j).setSelection(true);
                    //jboard[i][j].setIcon(modele.getCase(i, j).getTextureSelection()); 
                    avertirSelection(i, j, modele.getCase(i, j));
                    trajet.add(tab);
                 }
            
            
                    //Si case selectionné on change iconne et on vide trajet
                    // else if (jboard[i][j].getIcon()==DESERTSELECTION){
                 //     jboard[i][j].setIcon(DESERT);
                else {
                    //jboard[i][j].setIcon(modele.getCase(i, j).getTexture()); 
                    avertirDeselection(i, j, modele.getCase(i, j));
                    modele.getCase(i, j).setSelection(false);
                    trajet.clear();
                }
            }
            
         
            
     
        }
     }

}
