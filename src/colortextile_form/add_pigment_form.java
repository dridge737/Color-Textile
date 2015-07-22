/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colortextile_form;

import colortextile_class.pigment;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Eldridge
 */
public class add_pigment_form extends javax.swing.JFrame {

    DefaultTableModel model = new DefaultTableModel();
    pigment update_this_pigment = new pigment();
    /**
     * Creates new form add_pigment_form
     */
    public add_pigment_form() {
        initComponents();
        this.set_to_center();
        this.fill_table();
        
    }

    public void set_to_center()
    {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x,y);
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
        jLabel8 = new javax.swing.JLabel();
        close_but = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        add_button = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pigment_table = new javax.swing.JTable();
        pig_text = new javax.swing.JTextField();
        edit_but = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Pigment");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setLayout(null);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Add Pigment Form");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(20, 20, 360, 40);

        close_but.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        close_but.setText("Close");
        close_but.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        close_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                close_butActionPerformed(evt);
            }
        });
        jPanel1.add(close_but);
        close_but.setBounds(287, 390, 128, 50);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Pigment List ");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 80, 400, 40);

        add_button.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        add_button.setText("Add Pigment");
        add_button.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        add_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_buttonActionPerformed(evt);
            }
        });
        jPanel1.add(add_button);
        add_button.setBounds(7, 390, 135, 50);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        jPanel2.setOpaque(false);

        pigment_table.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        pigment_table.setModel(new javax.swing.table.DefaultTableModel(
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
        pigment_table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pigment_table.setRowHeight(20);
        pigment_table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(pigment_table);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 117, 400, 200);

        pig_text.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        pig_text.setForeground(new java.awt.Color(204, 204, 204));
        pig_text.setText("Pigment Name :");
        pig_text.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pig_textFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pig_textFocusLost(evt);
            }
        });
        pig_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pig_textKeyReleased(evt);
            }
        });
        jPanel1.add(pig_text);
        pig_text.setBounds(10, 330, 400, 30);

        edit_but.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        edit_but.setText("Edit");
        edit_but.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 5));
        edit_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_butActionPerformed(evt);
            }
        });
        jPanel1.add(edit_but);
        edit_but.setBounds(146, 390, 135, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void add_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_buttonActionPerformed
        // TODO add your handling code here:
        if(pig_text.getText().length()>0 && !pig_text.getText().equals("Pigment Name :"))
        {
            colortextile_class.pigment add_this_pig = new colortextile_class.pigment();
            if(add_button.getText().equals("Add Pigment"))
            {   
                add_this_pig.setPigment_name(pig_text.getText());
                
            }
            else
            {
               this.update_this_pigment.set_pigment_id_from_name();
               if(this.update_this_pigment.getPigment_no() != -1)
               {
                   update_this_pigment.delete_this_pigment();
                   update_this_pigment.setPigment_name(pig_text.getText());
                   if(update_this_pigment.add_pigment())
                       JOptionPane.showMessageDialog(null, "Pigment has been updated.");
                   else
                       JOptionPane.showMessageDialog(null, "Pigment has already been added.");
               }
               this.edit_but.setText("Edit");
               add_button.setText("Add Pigment");
            }
            
            if(add_this_pig.add_pigment()){
                    JOptionPane.showMessageDialog(null, "Successfully added pigment : "+pig_text.getText());
                        //JOptionPane.showMessageDialog(null,"Matagumpay na naidagdag ang Pigment");
                    this.dispose();
                }    
                else
                JOptionPane.showMessageDialog(null, "Pigment has already been added.");
                //JOptionPane.showMessageDialog(null,"Naidagdag na ang pigment na ito.");
            this.fill_table();
            this.reset_pigment_text();
        }
        else
        JOptionPane.showMessageDialog(null, "Please add a character/letter to the pigment name");
        //JOptionPane.showMessageDialog(null,"Pakilagyan po ng letra ang ida-dagdag na pigment");
            
    }//GEN-LAST:event_add_buttonActionPerformed

    public void reset_pigment_text()
    {
        this.pig_text.setText("Pigment Name :");
            pig_text.setForeground(new Color(204,204,204));
    }
    
    private void close_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_close_butActionPerformed
        // TODO add your handling code here:
        if(close_but.getText().equals("Close"))
        {
            this.dispose();
        }
        
        
    }//GEN-LAST:event_close_butActionPerformed

    private void pig_textKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pig_textKeyReleased
        // TODO add your handling code here:
        String text = this.pig_text.getText();
        TableRowSorter<TableModel> rowSorter
            = new TableRowSorter<>(this.pigment_table.getModel());
        
        this.pigment_table.setRowSorter(rowSorter);
        
        if (text.trim().length() == 0) {
            rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));        
        }
    }//GEN-LAST:event_pig_textKeyReleased

    private void pig_textFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pig_textFocusGained
        // TODO add your handling code here:
        if(pig_text.getText().equals("Pigment Name :"))
        {
            pig_text.setText("");
            pig_text.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_pig_textFocusGained

    private void pig_textFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pig_textFocusLost
        // TODO add your handling code here:
        if(pig_text.getText().equals(""))
            this.reset_pigment_text();
    }//GEN-LAST:event_pig_textFocusLost

    private void edit_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_butActionPerformed
        // TODO add your handling code here:
        if(edit_but.getText().equals("Edit"))
        {
            pig_text.setForeground(Color.BLACK);
            pig_text.setText(this.pigment_table.getModel().getValueAt(this.pigment_table.getSelectedRow(), 0).toString());
            
            model.removeRow(this.pigment_table.getSelectedRow());
            this.update_this_pigment.setPigment_name(pig_text.getText());
            
            this.edit_but.setText("Cancel");
            this.add_button.setText("Save");
        }
        else
        {
            model.addRow(new String[]{pig_text.getText()});
            
            edit_but.setText("Edit");
            this.add_button.setText("Add Pigment");
            this.reset_pigment_text();
        }
    }//GEN-LAST:event_edit_butActionPerformed

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
            java.util.logging.Logger.getLogger(add_pigment_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(add_pigment_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(add_pigment_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(add_pigment_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new add_pigment_form().setVisible(true);
            }
        });
    }
    
    public void fill_table() {      
        
        //model.addColumn("Pigment ID");
        model.addColumn("Pigment Name");
        //model.addColumn("Stock");
        //model.addColumn("Tingi");    
        
        colortextile_class.pigment all_pigment = new colortextile_class.pigment();
        ArrayList new_list =all_pigment.get_all_pigment_name();
        for(int x=0; x<new_list.size(); x++)
        {
            model.addRow(new Object[]{new_list.get(x).toString()});
        }
        
        //pigment_table.setTableHeader(null);
        pigment_table.setModel(model);
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_button;
    private javax.swing.JButton close_but;
    private javax.swing.JButton edit_but;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField pig_text;
    private javax.swing.JTable pigment_table;
    // End of variables declaration//GEN-END:variables
}
