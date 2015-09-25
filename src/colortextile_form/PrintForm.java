/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colortextile_form;

import Database.DB_Manager;
import colortextile_class.SpreadsheetTrial;
import colortextile_class.design;
import colortextile_class.job_order;
import colortextile_class.production_recipe;
import colortextile_class.purchase_order;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.jdom.JDOMException;
import org.jopendocument.dom.ODSingleXMLDocument;

/**
 *
 * @author Eldridge
 */
public class PrintForm extends javax.swing.JFrame {

    private DefaultTableModel temporary_table_model;
    private DefaultTableModel search_model;
    private List<production_recipe> prod_recipe  = new ArrayList<>();
    /**
     * Creates new form PrintForm
     */
    public PrintForm() {
        initComponents();
        fill_table_per_purchase_table();
        //Center the form
        this.setSize(955, 570);
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x,y);
        
        
    }
    
    private void fill_table_per_purchase_table()
    {
        DB_Manager conn= new DB_Manager();
        search_model = conn.get_table_design_customer_job_order();
        
        this.search_print.setModel(search_model); 
        search_print.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        resizeColumnWidth(search_print);
        print_table.removeAll();
        temporary_table_model = conn.get_column_for_design_customer_job_order();
        print_table.setModel(temporary_table_model);
        //resizeColumnWidth(print_table);
        
    }
    
    public void resizeColumnWidth(JTable table) {
    final TableColumnModel columnModel = table.getColumnModel();
    for (int column = 0; column < table.getColumnCount(); column++) {
        int width = 50; // Min width
        for (int row = 0; row < table.getRowCount(); row++) {
            TableCellRenderer renderer = table.getCellRenderer(row, column);
            Component comp = table.prepareRenderer(renderer, row, column);
            width = Math.max(comp.getPreferredSize().width, width);
        }
        columnModel.getColumn(column).setPreferredWidth(width);
    }
}
    
    private void fill_table_merged_date_search()
    {
        DB_Manager conn= new DB_Manager();
        search_model = conn.get_table_merged_date();
        this.search_print.setModel(search_model); 
        resizeColumnWidth(search_print);
        print_table.removeAll();
        temporary_table_model = conn.get_column_table_for_merged_date();
        print_table.setModel(temporary_table_model);   
        //resizeColumnWidth(print_table);
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
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        search_print = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        print_table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        purchase_button = new javax.swing.JRadioButton();
        combined_date_button = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        print_button = new javax.swing.JButton();
        add_row_button = new javax.swing.JButton();
        delete_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cancel_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Print Form");
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(50, 153, 250));
        jPanel1.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 34)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Print Form");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 20, 270, 43);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        search_print.setAutoCreateRowSorter(true);
        search_print.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        search_print.setModel(new javax.swing.table.DefaultTableModel(
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
        search_print.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(search_print);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 100, 920, 180);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        print_table.setAutoCreateRowSorter(true);
        print_table.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        print_table.setModel(new javax.swing.table.DefaultTableModel(
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
        print_table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(print_table);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(10, 340, 920, 130);

        jPanel2.setOpaque(false);

        purchase_button.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        purchase_button.setForeground(new java.awt.Color(255, 255, 255));
        purchase_button.setSelected(true);
        purchase_button.setText("All Purchase Search");
        purchase_button.setOpaque(false);
        purchase_button.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                purchase_buttonItemStateChanged(evt);
            }
        });

        combined_date_button.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        combined_date_button.setForeground(new java.awt.Color(255, 255, 255));
        combined_date_button.setText("Combined Date Search");
        combined_date_button.setOpaque(false);
        combined_date_button.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combined_date_buttonItemStateChanged(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Search Item :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                .addGap(89, 89, 89)
                .addComponent(purchase_button, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(combined_date_button)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(combined_date_button)
                        .addComponent(purchase_button))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 64, 920, 40);

        print_button.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        print_button.setText("Print Table ");
        print_button.setMargin(new java.awt.Insets(2, 2, 2, 2));
        print_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_buttonActionPerformed(evt);
            }
        });
        jPanel1.add(print_button);
        print_button.setBounds(10, 480, 300, 40);

        add_row_button.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        add_row_button.setText("Add selected row to Print Table");
        add_row_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_row_buttonActionPerformed(evt);
            }
        });
        jPanel1.add(add_row_button);
        add_row_button.setBounds(300, 290, 320, 40);
        add_row_button.getAccessibleContext().setAccessibleName("add_row");

        delete_button.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        delete_button.setText("Remove Selected Item");
        delete_button.setMargin(new java.awt.Insets(2, 2, 2, 2));
        delete_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_buttonActionPerformed(evt);
            }
        });
        jPanel1.add(delete_button);
        delete_button.setBounds(328, 480, 300, 40);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Print Table");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 300, 130, 40);

        cancel_button.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        cancel_button.setText("Cancel & Exit");
        cancel_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_buttonActionPerformed(evt);
            }
        });
        jPanel1.add(cancel_button);
        cancel_button.setBounds(645, 480, 280, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 940, 540);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void add_row_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_row_buttonActionPerformed
        // TODO add your handling code here:
        int[] row = search_print.getSelectedRows();
        //int total_col = search_print.getColumnCount();
        //for(int col = 0; col < total_col; col++)
        //{
        for(int index_add = 0; index_add< row.length; index_add++ )
        {
            if(this.purchase_button.isSelected())
            {
                //DefaultTableModel TM = (DefaultTableModel) search_print.getModel();
                //temporary_table_model.addRow((Vector) TM.getDataVector().get(row[index_add]));
                //temporary_table_model.addRow((Vector) this.search_model.getDataVector().get(row[index_add]));
            
                String[] this_set = {
                        search_print.getValueAt(row[index_add], 0).toString(),
                        search_print.getValueAt(row[index_add], 1).toString(),
                        search_print.getValueAt(row[index_add], 2).toString(),
                        search_print.getValueAt(row[index_add], 3).toString(),
                        search_print.getValueAt(row[index_add], 4).toString(),
                        search_print.getValueAt(row[index_add], 5).toString(),
                        search_print.getValueAt(row[index_add], 6).toString()
                    };
                
                    temporary_table_model.addRow(this_set);
                
            }
            else
            {
                temporary_table_model.addRow((Vector) this.search_model.getDataVector().get(row[index_add]));
            }
            System.out.println("Row = "+row[index_add]);
        }
        
        for(int remove_indexes = row.length; remove_indexes>0; remove_indexes-- )
        {
            System.out.println("Row = "+row[remove_indexes-1]);
            search_model = (DefaultTableModel) search_print.getModel();
            search_model.removeRow(search_print.convertRowIndexToModel(row[remove_indexes-1]));
            //search_print.remove(row[remove_indexes-1]);
        }
        
        
         this.print_table.setModel(temporary_table_model);
        // search_print.remove(row);
        
        
    }//GEN-LAST:event_add_row_buttonActionPerformed

    private void delete_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_buttonActionPerformed
        // TODO add your handling code here:
        int[] indexes_selected = this.print_table.getSelectedRows();
        int index_count = this.print_table.getSelectedRowCount();
        //System.out.println(indexes_selected.length);
        for(int index_incre = indexes_selected.length; index_incre> 0; index_incre--)
        {
            this.search_model.addRow((Vector) this.temporary_table_model.getDataVector().get(indexes_selected[index_incre-1]));
            //this.search_print.setModel(search_model);
            this.temporary_table_model.removeRow(indexes_selected[index_incre-1]);
            
        }    
    }//GEN-LAST:event_delete_buttonActionPerformed

    private void print_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_buttonActionPerformed
        // TODO add your handling code here:
        if(print_table.getRowCount()>0)
        {
            for(int incre=0; incre<print_table.getRowCount(); incre++)
            {
                production_recipe this_prod_recipe = new production_recipe();
                this_prod_recipe.setDate(print_table.getValueAt(incre, 0).toString());
                if(purchase_button.isSelected())
                {
                    this_prod_recipe.setDesign_name(print_table.getValueAt(incre, 1).toString());
                    this_prod_recipe.setColor_name(print_table.getValueAt(incre, 2).toString());
                    this_prod_recipe.setFabric_style(print_table.getValueAt(incre, 3).toString());
                    this_prod_recipe.set_design_code_using_variables();
                    
                    this_prod_recipe.set_design_details_and_colorway_details_from_design_code();
                    this_prod_recipe.set_all_purchase_details_from_design_code_and_date();
                    this_prod_recipe.set_job_order_list_using_design_code_and_purchase_id();
                    this_prod_recipe.compute_all_colorway_to_total_quantity();
                    //this_prod_recipe.view_all_colorway_details();
                    //this_prod_recipe.view_all_job_order_details();
                    //this_prod_recipe.view_all_puchase_order();
                    prod_recipe.add(this_prod_recipe);
                }
                else
                {
                    ArrayList<Integer> all_designs = this_prod_recipe.get_all_design_codes_from_date();
                    for(int all_codes: all_designs)
                    {
                        //System.out.println(all_codes);
                        production_recipe recipe_to_add = new production_recipe();
                        recipe_to_add.setDesign_code(all_codes);
                        recipe_to_add.setDate(print_table.getValueAt(incre, 0).toString());
                        recipe_to_add.set_design_details_and_colorway_details_from_design_code();
                        recipe_to_add.set_all_purchase_details_from_design_code_and_date();
                        recipe_to_add.set_job_order_list_using_design_code_and_purchase_id();
                        recipe_to_add.view_all_colorway_details();
                        recipe_to_add.view_all_job_order_details();
                        recipe_to_add.view_all_puchase_order();
                        prod_recipe.add(recipe_to_add);
                    }
                }
            }
            SpreadsheetTrial file_to_print = new SpreadsheetTrial();
            file_to_print.bulk_print_item(prod_recipe);
            prod_recipe.clear();
        }
        else{
            JOptionPane.showMessageDialog(null,"Please add something to print");
        }
        
    }//GEN-LAST:event_print_buttonActionPerformed

    private void purchase_buttonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_purchase_buttonItemStateChanged
        // TODO add your handling code here:
        if(this.purchase_button.isSelected())
        {
            this.combined_date_button.setSelected(false);
            this.purchase_button.setSelected(true);
            fill_table_per_purchase_table();
        }
    }//GEN-LAST:event_purchase_buttonItemStateChanged

    private void combined_date_buttonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combined_date_buttonItemStateChanged
        // TODO add your handling code here:
        if(this.combined_date_button.isSelected())
        {
            this.purchase_button.setSelected(false);
            this.combined_date_button.setSelected(true);
            fill_table_merged_date_search();
        }
        
    }//GEN-LAST:event_combined_date_buttonItemStateChanged

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        String text = this.jTextField1.getText();
        TableRowSorter<TableModel> rowSorter
            = new TableRowSorter<>(this.search_print.getModel());
        
        this.search_print.setRowSorter(rowSorter);
        
        if (text.trim().length() == 0) {
            rowSorter.setRowFilter(null);
        } else {
            rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));        
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void cancel_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_buttonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cancel_buttonActionPerformed

    
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
            java.util.logging.Logger.getLogger(PrintForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrintForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrintForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrintForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrintForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_row_button;
    private javax.swing.JButton cancel_button;
    private javax.swing.JRadioButton combined_date_button;
    private javax.swing.JButton delete_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton print_button;
    private javax.swing.JTable print_table;
    private javax.swing.JRadioButton purchase_button;
    private javax.swing.JTable search_print;
    // End of variables declaration//GEN-END:variables
}
