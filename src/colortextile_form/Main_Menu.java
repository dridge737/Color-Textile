/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colortextile_form;

import colortextile_class.*;

/**
 *
 * @author Eldridge
 */
public class Main_Menu extends javax.swing.JFrame {

    /**
     * Creates new form Main_Menu
     */
    public Main_Menu() {
        initComponents();
        this.setSize(780, 400);
        
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
        add_new_recipe = new javax.swing.JButton();
        search_jo = new javax.swing.JButton();
        pigments = new javax.swing.JButton();
        Close_but = new javax.swing.JButton();
        add_new_recipe1 = new javax.swing.JButton();
        add_new_recipe2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Menu");
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Main Menu");
        jLabel1.setToolTipText("");

        add_new_recipe.setBackground(new java.awt.Color(255, 255, 255));
        add_new_recipe.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        add_new_recipe.setText("Edit Existing Order");
        add_new_recipe.setBorder(null);
        add_new_recipe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_new_recipeActionPerformed(evt);
            }
        });

        search_jo.setBackground(new java.awt.Color(255, 255, 255));
        search_jo.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        search_jo.setText("Search Job Order");
        search_jo.setBorder(null);
        search_jo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_joActionPerformed(evt);
            }
        });

        pigments.setBackground(new java.awt.Color(255, 255, 255));
        pigments.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        pigments.setText("Search Pigments");
        pigments.setBorder(null);
        pigments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pigmentsActionPerformed(evt);
            }
        });

        Close_but.setBackground(new java.awt.Color(255, 255, 255));
        Close_but.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        Close_but.setText("Exit");
        Close_but.setBorder(null);
        Close_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Close_butActionPerformed(evt);
            }
        });

        add_new_recipe1.setBackground(new java.awt.Color(255, 255, 255));
        add_new_recipe1.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        add_new_recipe1.setText("Add New Production Recipe");
        add_new_recipe1.setBorder(null);
        add_new_recipe1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_new_recipe1ActionPerformed(evt);
            }
        });

        add_new_recipe2.setBackground(new java.awt.Color(255, 255, 255));
        add_new_recipe2.setFont(new java.awt.Font("Century Gothic", 0, 20)); // NOI18N
        add_new_recipe2.setText("Add Order from Existing Design");
        add_new_recipe2.setBorder(null);
        add_new_recipe2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_new_recipe2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(add_new_recipe1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(49, 49, 49)
                            .addComponent(search_jo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(add_new_recipe2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(add_new_recipe, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(49, 49, 49)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Close_but, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pigments, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_jo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_new_recipe1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pigments, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_new_recipe2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Close_but, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_new_recipe, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 0, 740, 370);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(0, 0, 26, 370);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 26, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(750, 0, 26, 370);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Close_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Close_butActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_Close_butActionPerformed

    private void pigmentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pigmentsActionPerformed
        // TODO add your handling code here:
        testing2.EditSearchPigmentForm new_pigment_form = new testing2.EditSearchPigmentForm();
        new_pigment_form.setVisible(true);
    }//GEN-LAST:event_pigmentsActionPerformed

    private void add_new_recipeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_new_recipeActionPerformed
        // TODO add your handling code here:
        Add_new_design newDesign = new Add_new_design();
        newDesign.setVisible(true);
    }//GEN-LAST:event_add_new_recipeActionPerformed

    private void search_joActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_joActionPerformed
        // TODO add your handling code here:
        SearchJOGui new_jo = new SearchJOGui();
        new_jo.setVisible(true);
    }//GEN-LAST:event_search_joActionPerformed

    private void add_new_recipe1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_new_recipe1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_add_new_recipe1ActionPerformed

    private void add_new_recipe2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_new_recipe2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_add_new_recipe2ActionPerformed

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
            java.util.logging.Logger.getLogger(Main_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Close_but;
    private javax.swing.JButton add_new_recipe;
    private javax.swing.JButton add_new_recipe1;
    private javax.swing.JButton add_new_recipe2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton pigments;
    private javax.swing.JButton search_jo;
    // End of variables declaration//GEN-END:variables
}
