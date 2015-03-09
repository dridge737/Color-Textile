/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package colortextile_form;

import Database.DB_Manager;
import colortextile_class.customer;
import colortextile_class.design;
import colortextile_class.job_order;
import colortextile_class.purchase_order;
import forms.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

//import net.proteanit.sql.DbUtils;

/**
 *
 * @author asakanaboy_00
 */
public class SearchJOGui extends javax.swing.JFrame {

    /**
     * Creates new form SearchJO
     */
    public SearchJOGui() {
        initComponents();
        
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        //int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x,0);
        
        this.combo_customer.addItem("");
        customer list = new customer();
        list.get_customer_list();
        for ( String name : list.getCustomer_names() )
        {
        this.combo_customer.addItem(name);
        }
        
        this.spinner_from.setEnabled(false);
        //this.spinner_to.setEnabled(false);
        
        job_order set = new job_order();
        fill_table(set.job_order_all());
        
    }
    public int get_table_row_value(){
        try{
            int row = this.jTable1.getSelectedRow();
            
            return row;
        }catch(Exception e){
            return -1;
        }
        
    }
    
                                                            ArrayList order_list = new ArrayList( );
    
    public void fill_table(ResultSet rs){
        this.order_list.clear();
        
        DB_Manager conn= new DB_Manager();
        purchase_order info = new purchase_order();
        
        design design_conn = new design();
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("#"); // purchaseorder
        model.addColumn("Job Order");       // job_order
        model.addColumn("Customer Name");   //job_order
        model.addColumn("date");            //job_order
        model.addColumn("Quantity");        //purchase order
        //model.addColumn("Design Code");
        model.addColumn("Design Name");     //design
        model.addColumn("Colorway Name");   //design
        model.addColumn("Fabric Style");    //desing
        
        try {
            
            if (rs.first()){
                
                
                rs.previous();
                while (rs.next()){
                    
                    info.setId_purchase(rs.getInt("id_purchase"));
                    ResultSet rs2 = info.Search_purchase_info();
                
                    this.order_list.add(rs2.getInt("id_purchase"));
                    
                if(rs2.first()){
                    rs2.previous();
                    while(rs2.next()) {
                    
                    design_conn.setDesign_code(rs2.getInt("design_code"));
                            ResultSet rs3 = design_conn.search_design();
                            
                            if (rs3.first()){
                                
                    String[] set1 = {   
                                    rs2.getString("purchase_order"),
                                    rs2.getString("job_order_id"), 
                                    conn.get_customer_name(rs.getInt("customer_id")),
                                    rs.getString("date"),
                                    rs2.getString("quantity"),
                             
                                    rs3.getString("design_name"),
                                    rs3.getString("color_name"),
                                    rs3.getString("fabric_style")};
                                
                                    model.addRow(set1);
                                
                            } else {
                            
                    String[] set1 = {   
                                    rs2.getString("purchase_order"),
                                    rs.getString("job_order_id"), 
                                    conn.get_customer_name(rs.getInt("customer_id")),
                                    rs2.getString("date"),
                                    rs.getString("quantity")
                                    };
                   
                                    model.addRow(set1);
                            }
                    
                    }
                             
                
                } else {
                    
                   String[] set1 = {   rs.getString("job_order_id"), 
                                    conn.get_customer_name(rs.getInt("customer_id")), 
                                    rs.getString("quantity")
                   };
                                   
               
                                    model.addRow(set1);
             
                }
                    // insert here loop
                    
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        combo_customer = new javax.swing.JComboBox();
        text_job_id = new javax.swing.JTextField();
        button_search = new javax.swing.JButton();
        button_reset = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        button_details = new javax.swing.JButton();
        label_pic = new javax.swing.JLabel();
        spinner_from = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Search Job Order");
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Customer Name :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 73, 140, 21);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Job Order ID :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 105, 140, 21);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Date :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 137, 140, 21);

        combo_customer.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        getContentPane().add(combo_customer);
        combo_customer.setBounds(170, 70, 414, 27);

        text_job_id.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        getContentPane().add(text_job_id);
        text_job_id.setBounds(170, 102, 414, 27);

        button_search.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        button_search.setText("Search");
        button_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_searchActionPerformed(evt);
            }
        });
        getContentPane().add(button_search);
        button_search.setBounds(36, 202, 123, 35);

        button_reset.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        button_reset.setText("Reset");
        button_reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_resetActionPerformed(evt);
            }
        });
        getContentPane().add(button_reset);
        button_reset.setBounds(165, 202, 134, 35);

        jCheckBox1.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Date");
        jCheckBox1.setOpaque(false);
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckBox1);
        jCheckBox1.setBounds(585, 133, 69, 29);

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 34)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Search Job Order");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(40, 16, 289, 43);

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

        button_details.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        button_details.setText("Details");
        button_details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_detailsActionPerformed(evt);
            }
        });

        spinner_from.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        spinner_from.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1410306137651L), null, null, java.util.Calendar.DAY_OF_MONTH));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(172, 172, 172)
                                .addComponent(spinner_from, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(450, 450, 450)
                                .addComponent(button_details, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label_pic, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(411, 411, 411)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(label_pic, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spinner_from, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)))
                .addComponent(button_details, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1320, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_searchActionPerformed
        // TODO add your handling code here:
       DB_Manager id = new DB_Manager();
        
        job_order jobsearch = new job_order();
        purchase_order purchasesearch = new purchase_order();
        
        
        
        SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
                String spinnerValuefrom = formater.format(this.spinner_from.getValue());
               
        if(!(this.combo_customer.getSelectedItem().toString().trim().equals(""))){
            
        jobsearch.setCustomer_id(id.get_id_customer(this.combo_customer.getSelectedItem().toString()));
        } else {
            jobsearch.setCustomer_id(-1);
        }
        
       
       
            
        if (!(this.text_job_id.getText().trim().equals(""))){
            jobsearch.setJob_id(this.text_job_id.getText());
            
            JOptionPane.showMessageDialog(null,"Job order input=  " + this.text_job_id.getText());
        } else {
            jobsearch.setJob_id(null);
        }
        
        
        
        if (this.jCheckBox1.isSelected())
        {
            jobsearch.setDate(spinnerValuefrom);         
        } else {
            jobsearch.setDate(null);
        }
        
        
        
        
        fill_table(jobsearch.Search_job_info()); 
           JOptionPane.showMessageDialog(null,"fill table 1  ");
        
       
     
        
       
        
    }//GEN-LAST:event_button_searchActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        if(this.jCheckBox1.isSelected()){
            this.spinner_from.setEnabled(true);
            
        } else {
            this.spinner_from.setEnabled(false);
            
        }
        
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void button_resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_resetActionPerformed
        // TODO add your handling code here:
        job_order set = new job_order();
        fill_table(set.job_order_all());
    }//GEN-LAST:event_button_resetActionPerformed

    
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        JOptionPane.showMessageDialog(null, "mouse clicked");
        
        try {
            insert_pic();
        } catch (SQLException ex) {
            Logger.getLogger(SearchJOGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void button_detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_detailsActionPerformed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        int total_col = jTable1.getColumnCount();
        for(int col = 0; col < total_col; col++)
        {
            System.out.println(jTable1.getValueAt(row, col));
        }
        String selected_purchase_order = jTable1.getValueAt(row, 0).toString();
        JOptionPane.showMessageDialog(null, "Selected purchase order: " + this.order_list.get(row).toString() + " from row : " + row  );
    }//GEN-LAST:event_button_detailsActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "key pressed");
   
        try {
            insert_pic();
        } catch (SQLException ex) {
            Logger.getLogger(SearchJOGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable1KeyPressed
    private String get_design_code_from_table_selected(){
        
        int row = this.get_table_row_value();
        String id =(this.jTable1.getModel().getValueAt(row, 4).toString());
        JOptionPane.showMessageDialog(null, "id= " + id);
        
        return id;
    }
    private void insert_pic() throws SQLException{
        
        
        design design_conn = new design();
      //  design_conn.setDesign_code(get_design_code_from_table_selected());
        design_conn.get_picture_from_design_code();
        Blob blob = design_conn.getDesign_image();
        
        int blobLength = (int) blob.length();
        byte[] image1 = blob.getBytes(1, blobLength);
        ImageIcon image = new ImageIcon(image1);
        
        
        label_pic.setIcon(image);
        getContentPane().add(label_pic);
        setVisible(true);
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
            java.util.logging.Logger.getLogger(SearchJOGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchJOGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchJOGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchJOGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchJOGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_details;
    private javax.swing.JButton button_reset;
    private javax.swing.JButton button_search;
    private javax.swing.JComboBox combo_customer;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel label_pic;
    private javax.swing.JSpinner spinner_from;
    private javax.swing.JTextField text_job_id;
    // End of variables declaration//GEN-END:variables
}
