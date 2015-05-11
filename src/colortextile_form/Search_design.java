/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package colortextile_form;

import Database.DB_Manager;
import colortextile_class.design;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Winston
 */
public class Search_design extends javax.swing.JFrame {

    /**
     * Creates new form Search_design
     */
    public Search_design() {
        design design_conn = new design();
        initComponents();
        fill_table(design_conn.get_all_design_details());
    }
    public void fill_table(ResultSet rs){
        
        
        DB_Manager conn= new DB_Manager();
        DefaultTableModel model = new DefaultTableModel();
        design design_conn = new design();
        
        model.addColumn("#");
        model.addColumn("Design Name");
        model.addColumn("Colorway Name");
        model.addColumn("fabric_style");
        
        
        
        
        try {
            if (rs.first()){
                
             rs.previous();
             
            while(rs.next()) {
              
                   String[] set1 = {    
                                        rs.getString("design_code"),
                                        rs.getString("design_name"),
                                        rs.getString("color_name"),
                                        rs.getString("fabric_style")
                                        
                                    };
               
                               model.addRow(set1);
     
                }
            } else {
                
            JOptionPane.showMessageDialog(null,"No Record");
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchJOGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.jTable1.setModel(model); 
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        text_design_name = new javax.swing.JTextField();
        text_design_color = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        button_search = new javax.swing.JButton();
        button_reset = new javax.swing.JButton();
        button_details = new javax.swing.JButton();
        label_pic = new javax.swing.JLabel();
        button_edit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 34)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Search Design");

        text_design_color.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_design_colorActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Design Name :");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Design Color   :");

        button_search.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        button_search.setText("Search");
        button_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_searchActionPerformed(evt);
            }
        });

        button_reset.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        button_reset.setText("Reset");
        button_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_resetActionPerformed(evt);
            }
        });

        button_details.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        button_details.setText("Use Design");
        button_details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_detailsActionPerformed(evt);
            }
        });

        button_edit.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        button_edit.setText("Edit Design");
        button_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_editActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(button_search, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(button_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(label_pic, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(button_details, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(button_edit)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(text_design_name, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(text_design_color, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(label_pic, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(button_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_design_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_design_color, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button_search, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_reset, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_details, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       try {
            insert_pic();
        } catch (SQLException ex) {
            Logger.getLogger(SearchJOGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void button_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_searchActionPerformed
        // TODO add your handling code here:
        design design_conn = new design();
        if (!(this.text_design_color.getText().equals(""))){
            design_conn.setColor_name(this.text_design_color.getText());
        } else {
            design_conn.setColor_name(null);
        }
        
        //design_conn.setDesign_code(this.text_design_code.getText());
        if (!(this.text_design_name.getText().equals(""))){
            design_conn.setDesign_name(this.text_design_name.getText());
        } else {
            design_conn.setDesign_name(null);
        }
        
        design_conn.setDesign_code(-1);
        fill_table(design_conn.search_design());
    }//GEN-LAST:event_button_searchActionPerformed

    private void button_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_resetActionPerformed
        // TODO add your handling code here:
       design design_conn = new design();
        fill_table(design_conn.get_all_design_details());
    }//GEN-LAST:event_button_resetActionPerformed

    private void text_design_colorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_design_colorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_design_colorActionPerformed

    private void insert_pic() throws SQLException{
        // super wrong........
        /*
        super("Image Display");
        setSize(400, 400);
        
        design design_conn = new design();
        design_conn.get_picture_from_design_code();
        Blob blobpic = design_conn.getDesign_image();
        Image img = Toolkit.getDefaultToolkit().createImage(blobpic);
        Imageicon icon =new ImageIcon(img);
        label_pic.setIcon(icon);
        add(lphoto);
        
        */
        String id = this.get_design_code_from_table_selected();
        
        design design_conn = new  design();
        design_conn.setDesign_code(Integer.parseInt(id));
        Blob blob = design_conn.getDesign_image();
        byte[] image1 = blob.getBytes(1, ALLBITS);
        ImageIcon image = new ImageIcon(image1);
        
        
        label_pic.setIcon(image);
        
        setVisible(true);
       
        
        
       
    }
    
    private void button_detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_detailsActionPerformed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        int total_col = jTable1.getColumnCount();
        for(int col = 0; col < total_col; col++)
        {
            System.out.println(jTable1.getValueAt(row, col));
        }
        System.out.println("end");
        String selcted_design_code = jTable1.getValueAt(row, 0).toString();
        
        Add_new_design design_form = new Add_new_design();
        design_form.setVisible(true);
        design_form.fill_info(Integer.parseInt(selcted_design_code));
    }//GEN-LAST:event_button_detailsActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
        try {
            insert_pic();
        } catch (SQLException ex) {
            Logger.getLogger(SearchJOGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable1KeyPressed

    private void button_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_editActionPerformed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        int total_col = jTable1.getColumnCount();
        for(int col = 0; col < total_col; col++)
        {
            System.out.println(jTable1.getValueAt(row, col));
        }
        
        String selcted_design_code = jTable1.getValueAt(row, 0).toString();
    }//GEN-LAST:event_button_editActionPerformed

    private String get_design_code_from_table_selected(){
        
        int row = this.get_table_row_value();
        String id =(this.jTable1.getModel().getValueAt(row, 0).toString());
        
            System.out.println(id);
        // testing commit --------------------------------------------------------------------------------------------------------------------------------------
        return id;
    }
    public int get_table_row_value(){
        try{
            int row = this.jTable1.getSelectedRow();
            
            return row;
        }catch(Exception e){
            return -1;
        }
        
    }
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
            java.util.logging.Logger.getLogger(Search_design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Search_design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Search_design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Search_design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Search_design().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_details;
    private javax.swing.JButton button_edit;
    private javax.swing.JButton button_reset;
    private javax.swing.JButton button_search;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel label_pic;
    private javax.swing.JTextField text_design_color;
    private javax.swing.JTextField text_design_name;
    // End of variables declaration//GEN-END:variables
}
