/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package colortextile_form;

import java.awt.Color;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 *
 * @author Eldridge
 */
public class Edit_Existing_Design_form extends javax.swing.JFrame {

    /**
     * Creates new form Edit_Existing_Design_form
     */
    public Edit_Existing_Design_form() {
        initComponents();
        this.setBackground(Color.yellow);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    private int count_screen_1 = 0;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jLabel129 = new javax.swing.JLabel();
        colorway_name2 = new javax.swing.JTextField();
        name1 = new javax.swing.JComboBox();
        percentage1 = new javax.swing.JTextField();
        jSeparator17 = new javax.swing.JSeparator();
        jTextField34 = new javax.swing.JTextField();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        weigh_kg8 = new javax.swing.JTextField();
        jLabel134 = new javax.swing.JLabel();
        name2 = new javax.swing.JComboBox();
        percentage2 = new javax.swing.JTextField();
        jLabel135 = new javax.swing.JLabel();
        jTextField35 = new javax.swing.JTextField();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        name3 = new javax.swing.JComboBox();
        percentage3 = new javax.swing.JTextField();
        jLabel138 = new javax.swing.JLabel();
        jTextField36 = new javax.swing.JTextField();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        name4 = new javax.swing.JComboBox();
        percentage4 = new javax.swing.JTextField();
        jLabel141 = new javax.swing.JLabel();
        jTextField37 = new javax.swing.JTextField();
        jLabel142 = new javax.swing.JLabel();
        jSeparator18 = new javax.swing.JSeparator();
        binder8 = new javax.swing.JComboBox();
        jLabel143 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        design_name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        design_code = new javax.swing.JTextField();
        save_but = new javax.swing.JButton();
        cancel_but = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edit Design");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocationByPlatform(true);
        setName("edit_frame"); // NOI18N

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane2.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setForeground(new java.awt.Color(255, 255, 255));

        jLabel129.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel129.setText("Colorway Name :");

        colorway_name2.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N

        name1.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        name1.setName("pigment_name"); // NOI18N

        percentage1.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        percentage1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                percentage1FocusLost(evt);
            }
        });

        jTextField34.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jTextField34.setEnabled(false);

        jLabel130.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel130.setText("kg / prep");

        jLabel131.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel131.setText("Pigment Name :");

        jLabel132.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel132.setText("%");

        jLabel133.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel133.setText("Kilograms / KGS :");

        weigh_kg8.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        weigh_kg8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                weigh_kg8FocusLost(evt);
            }
        });

        jLabel134.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel134.setText("Pigment Name :");

        name2.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        name2.setName("pigment_name"); // NOI18N

        percentage2.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        percentage2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                percentage2FocusLost(evt);
            }
        });

        jLabel135.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel135.setText("%");

        jTextField35.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jTextField35.setEnabled(false);

        jLabel136.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel136.setText("kg / prep");

        jLabel137.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel137.setText("Pigment Name :");

        name3.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        name3.setName("pigment_name"); // NOI18N

        percentage3.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        percentage3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                percentage3FocusLost(evt);
            }
        });

        jLabel138.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel138.setText("%");

        jTextField36.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jTextField36.setEnabled(false);

        jLabel139.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel139.setText("kg / prep");

        jLabel140.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel140.setText("Pigment Name :");

        name4.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        name4.setName("pigment_name"); // NOI18N

        percentage4.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        percentage4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                percentage4FocusLost(evt);
            }
        });

        jLabel141.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel141.setText("%");

        jTextField37.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jTextField37.setEnabled(false);

        jLabel142.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel142.setText("kg / prep");

        binder8.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        binder8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2.5", "2.7", "4.2", "5" }));

        jLabel143.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel143.setText("Binder :");

        jLabel144.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel144.setText("%");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel131)
                .addGap(10, 10, 10)
                .addComponent(name1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(percentage1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel132, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel130))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel134)
                .addGap(10, 10, 10)
                .addComponent(name2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(percentage2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel135, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel136))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel137)
                .addGap(10, 10, 10)
                .addComponent(name3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(percentage3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel138, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel139))
            .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel129)
                .addGap(4, 4, 4)
                .addComponent(colorway_name2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel133)
                .addGap(10, 10, 10)
                .addComponent(weigh_kg8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel140)
                        .addGap(10, 10, 10)
                        .addComponent(name4, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(percentage4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel143)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(binder8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel144)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel141, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel142))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel129, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(colorway_name2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel133, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(weigh_kg8, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addComponent(jSeparator17, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel131))
                    .addComponent(name1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(percentage1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel132, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel130)))
                .addGap(6, 6, 6)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel134))
                    .addComponent(name2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(percentage2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel135, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel136)))
                .addGap(6, 6, 6)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel137))
                    .addComponent(name3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(percentage3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel138, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel139)))
                .addGap(6, 6, 6)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel140))
                    .addComponent(name4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(percentage4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel141, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel142)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(binder8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel144, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel143))
                .addGap(18, 18, 18)
                .addComponent(jSeparator18, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane2.addTab("Colorway : 1", jPanel9);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Design Name :");

        design_name.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Design Code :");

        design_code.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N

        save_but.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        save_but.setText("Save");

        cancel_but.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cancel_but.setText("Cancel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(design_code, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(design_name, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(save_but, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cancel_but, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(design_code, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(design_name, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancel_but, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(save_but, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void percentage4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_percentage4FocusLost
        // TODO add your handling code here:
        check_this_textbox(percentage4);
    }//GEN-LAST:event_percentage4FocusLost

    private void percentage3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_percentage3FocusLost
        // TODO add your handling code here:
        check_this_textbox(percentage3);
    }//GEN-LAST:event_percentage3FocusLost

    private void percentage2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_percentage2FocusLost
        // TODO add your handling code here:
        check_this_textbox(percentage2);
    }//GEN-LAST:event_percentage2FocusLost

    private void weigh_kg8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_weigh_kg8FocusLost
        // TODO add your handling code here:
        check_this_textbox(weigh_kg8);
    }//GEN-LAST:event_weigh_kg8FocusLost

    private void percentage1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_percentage1FocusLost
        // TODO add your handling code here:
        check_this_textbox(percentage1);
    }//GEN-LAST:event_percentage1FocusLost

    private boolean checkText(JTextField the_textfield)
    {
        String regex = "\\D";
        Pattern p = Pattern.compile(regex);
        
        return p.matcher(the_textfield.getText()).find();
    }
    
    private void check_this_textbox(JTextField the_textfield)
    {
        boolean text_check = checkText(the_textfield);
        
        if(text_check)
        {
            the_textfield.setBackground(Color.red);
            count_screen_1++;
        }
        else
        {
            if(the_textfield.getBackground() == Color.red)
            {
                the_textfield.setBackground(Color.white);           
                count_screen_1--;
            }
        }
            
        if(count_screen_1 > 0)
            save_but.setEnabled(false);
        else
            save_but.setEnabled(true);
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
            java.util.logging.Logger.getLogger(Edit_Existing_Design_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Edit_Existing_Design_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Edit_Existing_Design_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Edit_Existing_Design_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Edit_Existing_Design_form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox binder8;
    private javax.swing.JButton cancel_but;
    private javax.swing.JTextField colorway_name2;
    private javax.swing.JTextField design_code;
    private javax.swing.JTextField design_name;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JComboBox name1;
    private javax.swing.JComboBox name2;
    private javax.swing.JComboBox name3;
    private javax.swing.JComboBox name4;
    private javax.swing.JTextField percentage1;
    private javax.swing.JTextField percentage2;
    private javax.swing.JTextField percentage3;
    private javax.swing.JTextField percentage4;
    private javax.swing.JButton save_but;
    private javax.swing.JTextField weigh_kg8;
    // End of variables declaration//GEN-END:variables
}
