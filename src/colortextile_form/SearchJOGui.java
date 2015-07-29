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
import colortextile_class.production_recipe;
import colortextile_class.purchase_order;
import forms.*;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
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
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

//import net.proteanit.sql.DbUtils;

/**
 *
 * @author asakanaboy_00
 */
public class SearchJOGui extends javax.swing.JFrame {

    private ArrayList order_list = new ArrayList( );
    /**
     * Creates new form SearchJO
     */
    public SearchJOGui() {
        initComponents();
       
        //Place Into Center
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x,y);
        
        //this.combo_customer.addItem("");
        //customer list = new customer();
        //list.get_customer_list();
        //for ( String name : list.getCustomer_names() )
        //{
        //this.combo_customer.addItem(name);
        //}
        
        //this.spinner_from.setEnabled(false);
       
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
    private void publicsorter(){
        String text = this.text_job_id.getText(); 
        String text2  = this.text_job_id2.getText();
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(this.jTable1.getModel()); 

        ArrayList<RowFilter<Object, Object>> andFilters = new ArrayList<RowFilter<Object, Object>>();
            andFilters.add(RowFilter.regexFilter(text));
            andFilters.add(RowFilter.regexFilter(text2));
        
        RowFilter<Object, Object> rf = RowFilter.andFilter(andFilters);
        
        this.jTable1.setRowSorter(rowSorter); 

        if (text.trim().length() == 0) {

        rowSorter.setRowFilter(null); 

        } else 

        { rowSorter.setRowFilter(rf); }

    }
    
    
    
    DefaultTableModel model = new DefaultTableModel();
    public void fill_table(ResultSet rs){
        this.order_list.clear();
        
        DB_Manager conn= new DB_Manager();
        
        model.addColumn("Job Order");       // job_order
        model.addColumn("Customer Name");   //job_order
        model.addColumn("date");            //job_order
        model.addColumn("Quantity");        //purchase order
        model.addColumn("Design Name");     //design
        model.addColumn("Colorway Name");   //design
        model.addColumn("Fabric Style");    //desing
        model.addColumn("#"); // purchaseorder
        try {
            if (rs.first()){
                
               rs.previous();
                while (rs.next())
                {    
                    purchase_order info = new purchase_order();
                    info.setJob_order_id(rs.getString("job_order_id"));
                    info.setId_purchase(-1);
                    info.setDesign_code(-1);
                    ResultSet rs2 = info.Search_purchase_info();
               
                    // rs == job_order database
                    // rs2 == purchase_order database
                    if(rs2.first())
                    {
                        rs2.previous();
                        while(rs2.next()) 
                        {
                            design design_conn = new design();
                            design_conn.setDesign_code(rs2.getInt("design_code"));
                            ResultSet rs3 = design_conn.search_design();
                            //rs3 = design code
                            if (rs3.first()){
                                String[] set1 = 
                                {
                                    
                                    rs2.getString("job_order_id"), 
                                    conn.get_customer_name(rs.getInt("customer_id")),
                                    rs.getString("date"),
                                    rs2.getString("quantity"),
                                    rs3.getString("design_name"),
                                    rs3.getString("color_name"),
                                    rs3.getString("fabric_style"),
                                    Integer.toString(rs2.getInt("id_purchase"))
                                };
                                model.addRow(set1);
                                
                            } /*else {
                                String[] set1 = {
                                    Integer.toString(rs2.getInt("id_purchase")),
                                    rs2.getString("job_order_id"), 
                                    conn.get_customer_name(rs.getInt("customer_id")),
                                    rs.getString("date"),
                                    rs2.getString("quantity")
                                    };
                                model.addRow(set1);
                            } */
                        }
                    } 
                    
                    
                }
            } 
            else 
            {
            JOptionPane.showMessageDialog(null,"No Record");
            }
        } 
        catch (SQLException ex) 
        {
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

        jFrame1 = new javax.swing.JFrame();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        combo_customer1 = new javax.swing.JComboBox();
        text_job_id1 = new javax.swing.JTextField();
        button_search1 = new javax.swing.JButton();
        button_reset1 = new javax.swing.JButton();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        button_details1 = new javax.swing.JButton();
        label_pic1 = new javax.swing.JLabel();
        spinner_from1 = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        button_details = new javax.swing.JButton();
        button_edit = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        label_pic = new javax.swing.JLabel();
        text_job_id = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        text_job_id2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jFrame1.setTitle("Search Job Order");
        jFrame1.getContentPane().setLayout(null);

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Customer Name :");
        jFrame1.getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 73, 140, 21);

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Job Order ID :");
        jFrame1.getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 105, 140, 21);

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Date :");
        jFrame1.getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 137, 140, 21);

        combo_customer1.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jFrame1.getContentPane().add(combo_customer1);
        combo_customer1.setBounds(170, 70, 414, 27);

        text_job_id1.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jFrame1.getContentPane().add(text_job_id1);
        text_job_id1.setBounds(170, 102, 414, 27);

        button_search1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        button_search1.setText("Search");
        button_search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_search1ActionPerformed(evt);
            }
        });
        jFrame1.getContentPane().add(button_search1);
        button_search1.setBounds(36, 202, 123, 35);

        button_reset1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        button_reset1.setText("Reset");
        button_reset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_reset1ActionPerformed(evt);
            }
        });
        jFrame1.getContentPane().add(button_reset1);
        button_reset1.setBounds(165, 202, 134, 35);

        jCheckBox2.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jCheckBox2.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setText("Date");
        jCheckBox2.setOpaque(false);
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });
        jFrame1.getContentPane().add(jCheckBox2);
        jCheckBox2.setBounds(585, 133, 65, 29);

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 34)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Search Job Order");
        jFrame1.getContentPane().add(jLabel8);
        jLabel8.setBounds(40, 16, 289, 43);

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        jTable2.setAutoCreateRowSorter(true);
        jTable2.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jTable2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable2KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        button_details1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        button_details1.setText("Details");
        button_details1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_details1ActionPerformed(evt);
            }
        });

        spinner_from1.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        spinner_from1.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1410306137651L), null, null, java.util.Calendar.DAY_OF_MONTH));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(172, 172, 172)
                                .addComponent(spinner_from1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(450, 450, 450)
                                .addComponent(button_details1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label_pic1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(411, 411, 411)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(label_pic1, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(spinner_from1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)))
                .addComponent(button_details1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jFrame1.getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 1320, 480);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Search Job Order");
        setMaximumSize(new java.awt.Dimension(1021, 482));
        setMinimumSize(new java.awt.Dimension(1021, 482));
        setName("Search Job"); // NOI18N
        getContentPane().setLayout(null);

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
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTable1MouseReleased(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

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

        jDesktopPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jDesktopPane1.add(label_pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 180));

        text_job_id.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        text_job_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_job_idKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 34)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Search Job Order");

        text_job_id2.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        text_job_id2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_job_id2KeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Search 1:");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Search 2:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(text_job_id2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(text_job_id))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel6))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button_details, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_edit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(192, 192, 192)
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 929, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel6)
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_job_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_details, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(button_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(text_job_id2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 990, 570);

        setSize(new java.awt.Dimension(1006, 617));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void button_detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_detailsActionPerformed
        
        int row = jTable1.getSelectedRow();
        int total_col = jTable1.getColumnCount();
        String selected_job_order = jTable1.getValueAt(row, 0).toString();
        
        design this_design = new production_recipe();
        //this_recipe.set
        this_design.setDesign_name(jTable1.getValueAt(row, 4).toString());
        this_design.setColor_name(jTable1.getValueAt(row,5).toString());
        this_design.setFabric_style(jTable1.getValueAt(row,6).toString());
        this_design.get_design_code_using_variables();
        
        purchase_order selected_purchase = new purchase_order();
        selected_purchase.setJob_order_id(selected_job_order);
        selected_purchase.setDesign_code(this_design.getDesign_code());
        selected_purchase.set_this_purchase_details_from_job_order_and_design_code();
                
        Add_new_design design_form = new Add_new_design();
        design_form.setVisible(true);
        design_form.fill_info2(selected_purchase.getId_purchase());
        
    }//GEN-LAST:event_button_detailsActionPerformed

    public void get_purchase_details_using_row_details()
    {
    
    }
    public void close(){
        WindowEvent winCloseEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winCloseEvent);
    }
    private void button_search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_search1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button_search1ActionPerformed

    private void button_reset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_reset1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button_reset1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2KeyPressed

    private void button_details1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_details1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button_details1ActionPerformed

    private void button_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_editActionPerformed
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        int total_col = jTable1.getColumnCount();
        /*for(int col = 0; col < total_col; col++)
        {
            System.out.println(jTable1.getValueAt(row, col));
        }
        System.out.println("end"); */
        String selected_purchase_order = jTable1.getValueAt(row, 7).toString();
        
        purchase_order purchase = new purchase_order();
        purchase.setId_purchase(Integer.parseInt(selected_purchase_order));
        
        EditRecipe editDesign = new EditRecipe(Integer.parseInt(selected_purchase_order));
        editDesign.setVisible(true);
        close();
            
    }//GEN-LAST:event_button_editActionPerformed

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
        try {
            insert_pic();
        } catch (SQLException ex) {
            Logger.getLogger(SearchJOGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable1KeyReleased

    private void jTable1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseReleased
        // TODO add your handling code here:
        try {
            insert_pic();
        } catch (SQLException ex) {
            Logger.getLogger(SearchJOGui.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable1MouseReleased

    private void text_job_idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_job_idKeyReleased
        // TODO add your handling code here:
        this.publicsorter();
    }//GEN-LAST:event_text_job_idKeyReleased

    private void text_job_id2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_job_id2KeyReleased
        // TODO add your handling code here:
        this.publicsorter();
    }//GEN-LAST:event_text_job_id2KeyReleased
    private int get_design_code_from_table_selected(){
        
        int row = this.get_table_row_value();
        String id =(this.jTable1.getModel().getValueAt(row, 7).toString());
        //JOptionPane.showMessageDialog(null, "id= " + id);
        
        purchase_order conn = new purchase_order();
        conn.setId_purchase(Integer.parseInt(id));
        conn.setDesign_code(-1);
        //conn.setJob_order_id(null);
        
        ResultSet rs = conn.Search_purchase_info();
        
        try {
            if(rs.next()){
            int id1 = rs.getInt("design_code");
            System.out.println(id1);
            return id1;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SearchJOGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    private void insert_pic() throws SQLException{
        
        this.label_pic.setIcon(null);
        int id = this.get_design_code_from_table_selected();
        
        design design_conn = new  design();
        design_conn.setDesign_code(id);
        
        ResultSet rs = design_conn.get_picture_from_design_code();
        
        if(rs.first()){
            //System.out
                byte[] imagedata = rs.getBytes("design_picture");
                format = new ImageIcon(imagedata);
                
                Image image = format.getImage();
                Image newimg = image.getScaledInstance(240, 180,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                format = new ImageIcon(newimg);  // transform it back
                this.label_pic.setIcon(format);
        } 
        
        
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
    private javax.swing.JButton button_details1;
    private javax.swing.JButton button_edit;
    private javax.swing.JButton button_reset1;
    private javax.swing.JButton button_search1;
    private javax.swing.JComboBox combo_customer1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel label_pic;
    private javax.swing.JLabel label_pic1;
    private javax.swing.JSpinner spinner_from1;
    private javax.swing.JTextField text_job_id;
    private javax.swing.JTextField text_job_id1;
    private javax.swing.JTextField text_job_id2;
    // End of variables declaration//GEN-END:variables


private ImageIcon format = null;
}
