package testing2;

import java.sql.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.table.*;
/**
 *
 * @author asakanaboy_00
 */
public class EditSearchPigmentForm extends javax.swing.JFrame 
{
    
    public EditSearchPigmentForm() 
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        add_pigment_dialog = new javax.swing.JDialog();
        jLabel3 = new javax.swing.JLabel();
        add_tingi = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        add_pigment_name = new javax.swing.JTextField();
        add_stock = new javax.swing.JSpinner();
        exit_add_pigment_button = new javax.swing.JButton();
        add_pigment_button = new javax.swing.JButton();
        exit_edit_search_pigment_button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pigment_table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        edit_pigment_name = new javax.swing.JTextField();
        edit_stock = new javax.swing.JSpinner();
        edit_tingi = new javax.swing.JSpinner();
        edit_pigment_button = new javax.swing.JButton();
        cancel_edit_pigment_button = new javax.swing.JButton();
        save_edit_pigment_button = new javax.swing.JButton();
        jSpinner5 = new javax.swing.JSpinner();
        jSpinner6 = new javax.swing.JSpinner();
        open_add_pigment_form_button = new javax.swing.JButton();
        reset_pigment_button = new javax.swing.JButton();
        search_pigment_button = new javax.swing.JButton();
        search_pigment = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        add_pigment_dialog.setTitle("Add Pigment");
        add_pigment_dialog.setMinimumSize(new java.awt.Dimension(350, 266));
        add_pigment_dialog.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        add_pigment_dialog.setResizable(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("tingi");

        add_tingi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        add_tingi.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("stock");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("pigment name");

        add_pigment_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        add_pigment_name.setName(""); // NOI18N

        add_stock.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        add_stock.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        exit_add_pigment_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        exit_add_pigment_button.setText("exit");
        exit_add_pigment_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_add_pigment_buttonActionPerformed(evt);
            }
        });

        add_pigment_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        add_pigment_button.setText("add");
        add_pigment_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_pigment_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout add_pigment_dialogLayout = new javax.swing.GroupLayout(add_pigment_dialog.getContentPane());
        add_pigment_dialog.getContentPane().setLayout(add_pigment_dialogLayout);
        add_pigment_dialogLayout.setHorizontalGroup(
            add_pigment_dialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(add_pigment_dialogLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(add_pigment_dialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(add_pigment_button, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(add_pigment_dialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(add_pigment_name)
                    .addComponent(add_stock)
                    .addComponent(add_tingi, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exit_add_pigment_button, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        add_pigment_dialogLayout.setVerticalGroup(
            add_pigment_dialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(add_pigment_dialogLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(add_pigment_dialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(add_pigment_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(add_pigment_dialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(add_stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(add_pigment_dialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(add_tingi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(add_pigment_dialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_pigment_button)
                    .addComponent(exit_add_pigment_button))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        exit_edit_search_pigment_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        exit_edit_search_pigment_button.setText("exit");
        exit_edit_search_pigment_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exit_edit_search_pigment_buttonActionPerformed(evt);
            }
        });

        pigment_table.setAutoCreateRowSorter(true);
        pigment_table.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pigment_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        pigment_table.setColumnSelectionAllowed(false);
        pigment_table.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pigment_table.setDoubleBuffered(true);
        pigment_table.setDragEnabled(true);
        pigment_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pigment_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(pigment_table);
        pigment_table.getAccessibleContext().setAccessibleDescription("");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("tingi");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("pigment name");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("stock");

        edit_pigment_name.setEditable(false);
        edit_pigment_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edit_pigment_name.setFocusable(false);
        edit_pigment_name.setName(""); // NOI18N

        edit_stock.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edit_stock.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        edit_stock.setEnabled(false);
        edit_stock.setFocusable(false);

        edit_tingi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edit_tingi.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        edit_tingi.setEnabled(false);

        edit_pigment_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        edit_pigment_button.setText("edit");
        edit_pigment_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_pigment_buttonActionPerformed(evt);
            }
        });

        cancel_edit_pigment_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cancel_edit_pigment_button.setText("cancel");
        cancel_edit_pigment_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_edit_pigment_buttonActionPerformed(evt);
            }
        });

        save_edit_pigment_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        save_edit_pigment_button.setText("save");
        save_edit_pigment_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_edit_pigment_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(edit_pigment_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(edit_stock, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(edit_pigment_name, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(edit_tingi, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(save_edit_pigment_button)
                        .addGap(31, 31, 31)
                        .addComponent(cancel_edit_pigment_button)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(edit_pigment_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edit_stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edit_tingi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(edit_pigment_button)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(save_edit_pigment_button)
                    .addComponent(cancel_edit_pigment_button))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jSpinner5.setEnabled(false);
        jSpinner5.setFocusable(false);

        jSpinner6.setEnabled(false);

        open_add_pigment_form_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        open_add_pigment_form_button.setText("add pigment");
        open_add_pigment_form_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                open_add_pigment_form_buttonActionPerformed(evt);
            }
        });

        reset_pigment_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        reset_pigment_button.setText("reset search");
        reset_pigment_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_pigment_buttonActionPerformed(evt);
            }
        });

        search_pigment_button.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        search_pigment_button.setText("search ");
        search_pigment_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_pigment_buttonActionPerformed(evt);
            }
        });

        search_pigment.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("pigment name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(search_pigment, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(open_add_pigment_form_button, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                    .addComponent(search_pigment_button, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(reset_pigment_button, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                                    .addComponent(exit_edit_search_pigment_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jSpinner6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(search_pigment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(search_pigment_button)
                            .addComponent(reset_pigment_button))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(open_add_pigment_form_button)
                            .addComponent(exit_edit_search_pigment_button))
                        .addGap(22, 22, 22)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinner6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exit_edit_search_pigment_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_edit_search_pigment_buttonActionPerformed
        dispose();
    }//GEN-LAST:event_exit_edit_search_pigment_buttonActionPerformed

    private void search_pigment_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_pigment_buttonActionPerformed
        Pigments pigment = new Pigments();
        pigment.setPigment_name(this.search_pigment.getText());       
        this.search_pigment.setText("");  
        fill_table(pigment.searchPigment());
    }//GEN-LAST:event_search_pigment_buttonActionPerformed

    private void pigment_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pigment_tableMouseClicked
        try
        {
            Pigments pigment2 = new Pigments();
            edit_pigment_button.setVisible(true);
            save_edit_pigment_button.setVisible(false);
            cancel_edit_pigment_button.setVisible(false);
            edit_stock.setEnabled(false);
            edit_tingi.setEnabled(false);
            int row = pigment_table.getSelectedRow(); 
            String table_click = (pigment_table.getModel().getValueAt(row, 1).toString());
            pigment2.setPigment_name(table_click);     
            ResultSet rs = pigment2.searchPigment();
            if(rs.next())
            {
                edit_pigment_name.setText(rs.getString("pigment_name"));              
                edit_stock.setValue(rs.getInt("stock"));
                edit_tingi.setValue(rs.getInt("tingi"));
                jSpinner5.setValue(rs.getInt("stock"));
                jSpinner6.setValue(rs.getInt("tingi"));
            }
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_pigment_tableMouseClicked

    private void edit_pigment_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_pigment_buttonActionPerformed
        edit_pigment_button.setVisible(false);
        save_edit_pigment_button.setVisible(true);
        cancel_edit_pigment_button.setVisible(true);
        edit_stock.setEnabled(true);
        edit_tingi.setEnabled(true);
    }//GEN-LAST:event_edit_pigment_buttonActionPerformed

    private void cancel_edit_pigment_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_edit_pigment_buttonActionPerformed
        edit_pigment_button.setVisible(true);
        save_edit_pigment_button.setVisible(false);
        cancel_edit_pigment_button.setVisible(false);
        edit_stock.setEnabled(false);
        edit_tingi.setEnabled(false);
    }//GEN-LAST:event_cancel_edit_pigment_buttonActionPerformed

    private void save_edit_pigment_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_edit_pigment_buttonActionPerformed
        if (edit_stock.getValue()==jSpinner5.getValue() && edit_tingi.getValue()==jSpinner6.getValue())
        {
            JOptionPane.showMessageDialog(null,"You haven't made any changes!");
        }
        else
        {
            int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to edit the selected pigment?", "Confirm Edit",  JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION)
            {
                edit_pigment_button.setVisible(false);
                save_edit_pigment_button.setVisible(false);
                cancel_edit_pigment_button.setVisible(false);
                edit_stock.setEnabled(false);
                edit_tingi.setEnabled(false);
                Pigments pigment = new Pigments();
                pigment.setPigment_name(this.edit_pigment_name.getText());
                pigment.setStock(Integer.parseInt(this.edit_stock.getValue().toString()));
                pigment.setTingi(Integer.parseInt(this.edit_tingi.getValue().toString()));
                pigment.editPigment();  
                fill_table(pigment.updateTable());
                JOptionPane.showMessageDialog(null,"Pigment has been edited!");
            }
        }
    }//GEN-LAST:event_save_edit_pigment_buttonActionPerformed

    private void reset_pigment_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_pigment_buttonActionPerformed
        Pigments pigment = new Pigments();
        fill_table(pigment.updateTable());
        edit_pigment_name.setText("");
        edit_stock.setValue(0);
        edit_tingi.setValue(0);
        edit_pigment_button.setVisible(false);
        save_edit_pigment_button.setVisible(false);
        cancel_edit_pigment_button.setVisible(false);
        edit_stock.setEnabled(false);
        edit_tingi.setEnabled(false);
    }//GEN-LAST:event_reset_pigment_buttonActionPerformed

    private void open_add_pigment_form_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_open_add_pigment_form_buttonActionPerformed
        add_pigment_dialog.setVisible(true);
    }//GEN-LAST:event_open_add_pigment_form_buttonActionPerformed

    private void exit_add_pigment_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exit_add_pigment_buttonActionPerformed
        add_pigment_dialog.dispose();
    }//GEN-LAST:event_exit_add_pigment_buttonActionPerformed

    private void add_pigment_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_pigment_buttonActionPerformed
        if (this.add_pigment_name.getText().trim().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Pigment Name cannot be blank!");
        }
        else
        {
            try
            {
                Pigments pigment = new Pigments();
                pigment.setPigment_name(this.add_pigment_name.getText());
                if (pigment.searchPigment().first())
                {
                    JOptionPane.showMessageDialog(null,"Pigment already exists!");
                }
                else
                {
                    pigment.setStock(Integer.parseInt(this.add_stock.getValue().toString()));
                    pigment.setTingi(Integer.parseInt(this.add_tingi.getValue().toString()));
                    pigment.addPigment();
                    JOptionPane.showMessageDialog(null,"Pigment has been added!");
                    this.add_pigment_name.setText("");
                    this.add_stock.setValue(0);
                    this.add_tingi.setValue(0);                   
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_add_pigment_buttonActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Pigments pigment = new Pigments();
        fill_table(pigment.updateTable());      
        edit_pigment_button.setVisible(false);
        save_edit_pigment_button.setVisible(false);
        cancel_edit_pigment_button.setVisible(false);
        jSpinner5.setVisible(false);
        jSpinner6.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    public void fill_table(ResultSet rs) {      
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Pigment ID");
        model.addColumn("Pigment Name");
        model.addColumn("Stock");
        model.addColumn("Tingi");    
                
        try 
        {
            while(rs.next()) 
            {              
                String[] set1 = { rs.getString("id_pigment"), rs.getString("pigment_name"), rs.getString("stock"), rs.getString("tingi")};
                model.addRow(set1);
            }
        } 
        catch (Exception e)
        {
            e.printStackTrace();
        }
                
        pigment_table.setModel(model); 
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
            java.util.logging.Logger.getLogger(EditSearchPigmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditSearchPigmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditSearchPigmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditSearchPigmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new EditSearchPigmentForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_pigment_button;
    private javax.swing.JDialog add_pigment_dialog;
    private javax.swing.JTextField add_pigment_name;
    private javax.swing.JSpinner add_stock;
    private javax.swing.JSpinner add_tingi;
    private javax.swing.JButton cancel_edit_pigment_button;
    private javax.swing.JButton edit_pigment_button;
    private javax.swing.JTextField edit_pigment_name;
    private javax.swing.JSpinner edit_stock;
    private javax.swing.JSpinner edit_tingi;
    private javax.swing.JButton exit_add_pigment_button;
    private javax.swing.JButton exit_edit_search_pigment_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner5;
    private javax.swing.JSpinner jSpinner6;
    private javax.swing.JButton open_add_pigment_form_button;
    private javax.swing.JTable pigment_table;
    private javax.swing.JButton reset_pigment_button;
    private javax.swing.JButton save_edit_pigment_button;
    private javax.swing.JTextField search_pigment;
    private javax.swing.JButton search_pigment_button;
    // End of variables declaration//GEN-END:variables
}