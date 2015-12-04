/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package colortextile_form;
import Database.DB_Manager;
import colortextile_class.*;
import java.awt.AWTException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
/**
 *
 * @author Eldridge
 */


public class Add_new_design extends javax.swing.JFrame {

    private int count_screen_1 = 0;
    //private colortextile_class.Job_purchase_link_functions this_purchase = new colortextile_class.Job_purchase_link_functions();
    private Recipe_functions use_func = new Recipe_functions();
    private boolean pigment_screen_showed = false;
    private boolean fabric_style_screen_showed = false;
    private boolean binder_screen_showed = false;
    private job_customer_quantity_list this_list = new job_customer_quantity_list();
    private job_customer_quantity_list temporary_list = new job_customer_quantity_list();
    private String current_style;
    private int pigment_button_check = -1;
    private int binder_button_check = -1;
    private production_recipe this_recipe = new production_recipe();
    public boolean edit_recipe = false;
    int last_added_pigment_no;
    int previous_quantity_total = 0;
    /**
     * Creates new form Add_new_design
     */
    
    public Add_new_design() {
        
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                if (JOptionPane.showConfirmDialog(null,"Are you sure to close this window?", "Close window?", 
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            dispose();
                }
                
            }
       });
        initComponents();
        addListItems();
        
        //Center the form
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        //int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x,0);
        //InputVerifier new_verifier = new Verifier();
        //this.pigment_percentage8.setInputVerifier(new_verifier);
        this.set_customer_list_and_autocomplete();
        set_color_list_autocomplete();
        this.remove_and_add_all_binders();
        job_ord_label.setText(use_func.change_job_order_prefix(spinner_date));
        current_style = fab_style_comb.getSelectedItem().toString();
        design new_design = new design();
        for(String this_fabric : new_design.get_all_fabric_styles())
        {
            fab_style_comb.addItem(this_fabric);
        }
    }
    public void remove_and_add_all_binders()
    {
        binder.removeAllItems();
        binder2.removeAllItems();
        binder3.removeAllItems();
        binder4.removeAllItems();
        binder5.removeAllItems();
        binder6.removeAllItems();
        binder7.removeAllItems();
        /*
        ArrayList<Float> all_binder = new ArrayList<>();
        all_binder.add((float) 3.5);
        all_binder.add((float) 4.0);
        all_binder.add((float) 5.5);
        all_binder.add((float) 8.0);
        add_all_binders(all_binder);
        
        */
        this.add_all_binders_from_database();
    }
    
    public void add_all_binders(ArrayList<Float> binder_to_be_added)
    {
        for(Float this_binder : binder_to_be_added)
        {
            binder.addItem(this_binder);
            binder2.addItem(this_binder);
            binder3.addItem(this_binder);
            binder4.addItem(this_binder);
            binder5.addItem(this_binder);
            binder6.addItem(this_binder);
            binder7.addItem(this_binder);
        }
    }
    public void add_all_binders_from_database()
    {
        colorway this_colorway = new colorway();
        ArrayList<Float> all_binder = this_colorway.get_all_binder();
        add_all_binders(all_binder);
    }
    public void set_color_list_autocomplete()
    {
        ArrayList<String> colors = new design().get_all_color_list();
        auto_complete color_complete = new auto_complete();
        color_complete.setupAutoComplete(this.design_color, colors);
        this.design_color.setColumns(30);
    }
    public void set_customer_list_and_autocomplete()
    {
        //fill_customer_list();
        //this.customer_name_text.setVisible(false);
        //this.customer_combo_list.setEditable(true);
        this.customer_combo_list.setVisible(false);
        
        customer list = new customer();
        list.get_customer_list();
        ArrayList<String> words = list.getCustomer_names();
        
//        for ( String name : list.getCustomer_names() )
//        {
//            words.add(name);
//        }
        auto_complete this_auto = new auto_complete();
        this_auto.setupAutoComplete(this.customer_name_text, words);
        
        this.customer_name_text.setColumns(30);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel14 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        spinner_date = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        design_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fab_style_comb = new javax.swing.JComboBox();
        design_color = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        quantity_total = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        customer_name_text = new javax.swing.JTextField();
        customer_combo_list = new javax.swing.JComboBox();
        text_job_order = new javax.swing.JTextField();
        button_include_customer = new javax.swing.JButton();
        button_remove_customer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        job_ord_label = new javax.swing.JLabel();
        edit_purchase = new javax.swing.JButton();
        add_fabric = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jLabel129 = new javax.swing.JLabel();
        colorway_name = new javax.swing.JTextField();
        name1 = new javax.swing.JComboBox();
        percentage1 = new javax.swing.JTextField();
        jSeparator17 = new javax.swing.JSeparator();
        kg_2 = new javax.swing.JTextField();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        weigh_kg = new javax.swing.JTextField();
        jLabel134 = new javax.swing.JLabel();
        name2 = new javax.swing.JComboBox();
        percentage2 = new javax.swing.JTextField();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        name3 = new javax.swing.JComboBox();
        percentage3 = new javax.swing.JTextField();
        jLabel138 = new javax.swing.JLabel();
        kg_3 = new javax.swing.JTextField();
        jLabel139 = new javax.swing.JLabel();
        jSeparator18 = new javax.swing.JSeparator();
        binder = new javax.swing.JComboBox();
        jLabel143 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        kg_1 = new javax.swing.JTextField();
        coverage1 = new javax.swing.JTextField();
        jLabel140 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        pig13 = new javax.swing.JButton();
        bind_add1 = new javax.swing.JButton();
        pig11 = new javax.swing.JButton();
        pig12 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        colorway_name3 = new javax.swing.JTextField();
        name5 = new javax.swing.JComboBox();
        percentage5 = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        kg_5 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        weigh_kg3 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        name6 = new javax.swing.JComboBox();
        percentage6 = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        kg_6 = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        name7 = new javax.swing.JComboBox();
        percentage7 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        kg_7 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        binder2 = new javax.swing.JComboBox();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        coverage3 = new javax.swing.JTextField();
        jLabel157 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        pig21 = new javax.swing.JButton();
        pig22 = new javax.swing.JButton();
        pig23 = new javax.swing.JButton();
        bind_add2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        colorway_name4 = new javax.swing.JTextField();
        name9 = new javax.swing.JComboBox();
        percentage9 = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        kg_9 = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        weigh_kg4 = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        name10 = new javax.swing.JComboBox();
        percentage10 = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        kg_10 = new javax.swing.JTextField();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        name11 = new javax.swing.JComboBox();
        percentage11 = new javax.swing.JTextField();
        jLabel74 = new javax.swing.JLabel();
        kg_11 = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        binder3 = new javax.swing.JComboBox();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        coverage4 = new javax.swing.JTextField();
        jLabel159 = new javax.swing.JLabel();
        jLabel165 = new javax.swing.JLabel();
        pig31 = new javax.swing.JButton();
        pig32 = new javax.swing.JButton();
        pig33 = new javax.swing.JButton();
        bind_add3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        colorway_name5 = new javax.swing.JTextField();
        name13 = new javax.swing.JComboBox();
        percentage13 = new javax.swing.JTextField();
        jSeparator11 = new javax.swing.JSeparator();
        kg_13 = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        weigh_kg5 = new javax.swing.JTextField();
        jLabel86 = new javax.swing.JLabel();
        name14 = new javax.swing.JComboBox();
        percentage14 = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        kg_14 = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        name15 = new javax.swing.JComboBox();
        percentage15 = new javax.swing.JTextField();
        jLabel90 = new javax.swing.JLabel();
        kg_15 = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        binder4 = new javax.swing.JComboBox();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        coverage5 = new javax.swing.JTextField();
        jLabel161 = new javax.swing.JLabel();
        jLabel166 = new javax.swing.JLabel();
        pig41 = new javax.swing.JButton();
        pig42 = new javax.swing.JButton();
        pig43 = new javax.swing.JButton();
        bind_add4 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        colorway_name6 = new javax.swing.JTextField();
        name17 = new javax.swing.JComboBox();
        percentage17 = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        kg_17 = new javax.swing.JTextField();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        weigh_kg6 = new javax.swing.JTextField();
        jLabel102 = new javax.swing.JLabel();
        name18 = new javax.swing.JComboBox();
        percentage18 = new javax.swing.JTextField();
        jLabel103 = new javax.swing.JLabel();
        kg_18 = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        name19 = new javax.swing.JComboBox();
        percentage19 = new javax.swing.JTextField();
        jLabel106 = new javax.swing.JLabel();
        kg_19 = new javax.swing.JTextField();
        jLabel107 = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JSeparator();
        binder5 = new javax.swing.JComboBox();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        coverage6 = new javax.swing.JTextField();
        jLabel163 = new javax.swing.JLabel();
        jLabel167 = new javax.swing.JLabel();
        pig51 = new javax.swing.JButton();
        pig52 = new javax.swing.JButton();
        pig53 = new javax.swing.JButton();
        bind_add5 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        colorway_name7 = new javax.swing.JTextField();
        name21 = new javax.swing.JComboBox();
        percentage21 = new javax.swing.JTextField();
        jSeparator15 = new javax.swing.JSeparator();
        kg_21 = new javax.swing.JTextField();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        weigh_kg7 = new javax.swing.JTextField();
        jLabel118 = new javax.swing.JLabel();
        name22 = new javax.swing.JComboBox();
        percentage22 = new javax.swing.JTextField();
        jLabel119 = new javax.swing.JLabel();
        kg_22 = new javax.swing.JTextField();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        name23 = new javax.swing.JComboBox();
        percentage23 = new javax.swing.JTextField();
        jLabel122 = new javax.swing.JLabel();
        kg_23 = new javax.swing.JTextField();
        jLabel123 = new javax.swing.JLabel();
        jSeparator16 = new javax.swing.JSeparator();
        binder6 = new javax.swing.JComboBox();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        coverage2 = new javax.swing.JTextField();
        jLabel155 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        pig61 = new javax.swing.JButton();
        pig62 = new javax.swing.JButton();
        pig63 = new javax.swing.JButton();
        bind_add6 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        colorway_name8 = new javax.swing.JTextField();
        name24 = new javax.swing.JComboBox();
        percentage24 = new javax.swing.JTextField();
        jSeparator19 = new javax.swing.JSeparator();
        kg_24 = new javax.swing.JTextField();
        jLabel117 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        weigh_kg8 = new javax.swing.JTextField();
        jLabel126 = new javax.swing.JLabel();
        name25 = new javax.swing.JComboBox();
        percentage25 = new javax.swing.JTextField();
        jLabel141 = new javax.swing.JLabel();
        kg_25 = new javax.swing.JTextField();
        jLabel142 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        name26 = new javax.swing.JComboBox();
        percentage26 = new javax.swing.JTextField();
        jLabel151 = new javax.swing.JLabel();
        kg_26 = new javax.swing.JTextField();
        jLabel152 = new javax.swing.JLabel();
        jSeparator20 = new javax.swing.JSeparator();
        binder7 = new javax.swing.JComboBox();
        jLabel169 = new javax.swing.JLabel();
        jLabel170 = new javax.swing.JLabel();
        jLabel171 = new javax.swing.JLabel();
        jLabel172 = new javax.swing.JLabel();
        coverage8 = new javax.swing.JTextField();
        jLabel173 = new javax.swing.JLabel();
        jLabel174 = new javax.swing.JLabel();
        pig71 = new javax.swing.JButton();
        pig72 = new javax.swing.JButton();
        pig_73 = new javax.swing.JButton();
        bind_add7 = new javax.swing.JButton();
        add_order = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        preview_but = new javax.swing.JButton();
        cancel_but = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Add New Design");
        setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        setForeground(java.awt.Color.white);
        setIconImages(null);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(790, 732));
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(50, 153, 250));
        jPanel14.setFocusable(false);
        jPanel14.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("New Recipe Form");
        jLabel7.setFocusable(false);
        jPanel14.add(jLabel7);
        jLabel7.setBounds(20, 20, 307, 45);

        spinner_date.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        spinner_date.setModel(new javax.swing.SpinnerDateModel());
        spinner_date.setToolTipText("Month, Day and Year");
        spinner_date.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinner_dateStateChanged(evt);
            }
        });
        jPanel14.add(spinner_date);
        spinner_date.setBounds(633, 20, 126, 34);
        spinner_date.setEditor(new JSpinner.DateEditor(spinner_date, "MM/dd/yyyy"));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 17)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Date :");
        jLabel6.setToolTipText("");
        jLabel6.setFocusable(false);
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel14.add(jLabel6);
        jLabel6.setBounds(525, 20, 100, 30);
        jLabel6.getAccessibleContext().setAccessibleName("date");

        getContentPane().add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 70));

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setFocusable(false);
        jPanel1.setLayout(null);

        design_name.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel1.add(design_name);
        design_name.setBounds(200, 210, 210, 34);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Design Name :");
        jLabel2.setFocusable(false);
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 210, 153, 34);

        fab_style_comb.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        fab_style_comb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PONGEE", "COTTON", "KATUNIA", "MICROPEACH", "TC", "TROPICANA" }));
        fab_style_comb.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                fab_style_combPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jPanel1.add(fab_style_comb);
        fab_style_comb.setBounds(590, 210, 150, 34);

        design_color.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel1.add(design_color);
        design_color.setBounds(200, 250, 210, 34);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 17)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Fabric Style :");
        jLabel11.setFocusable(false);
        jPanel1.add(jLabel11);
        jLabel11.setBounds(476, 210, 110, 34);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Color :");
        jLabel4.setFocusable(false);
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 250, 153, 34);

        jPanel16.setBackground(new java.awt.Color(51, 51, 51));
        jPanel16.setFocusable(false);
        jPanel16.setOpaque(false);
        jPanel16.setLayout(null);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 17)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Total Quantity :");
        jLabel3.setFocusable(false);
        jLabel3.setRequestFocusEnabled(false);
        jLabel3.setVerifyInputWhenFocusTarget(false);
        jPanel16.add(jLabel3);
        jLabel3.setBounds(450, 120, 130, 34);

        quantity_total.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        quantity_total.setText("0");
        quantity_total.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        quantity_total.setEnabled(false);
        quantity_total.setSelectionColor(new java.awt.Color(153, 153, 153));
        quantity_total.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                quantity_totalPropertyChange(evt);
            }
        });
        jPanel16.add(quantity_total);
        quantity_total.setBounds(580, 120, 150, 34);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("m");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel5.setFocusable(false);
        jLabel5.setRequestFocusEnabled(false);
        jLabel5.setVerifyInputWhenFocusTarget(false);
        jPanel16.add(jLabel5);
        jLabel5.setBounds(730, 120, 13, 34);

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("m");
        jLabel13.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel13.setFocusable(false);
        jLabel13.setRequestFocusEnabled(false);
        jLabel13.setVerifyInputWhenFocusTarget(false);
        jPanel16.add(jLabel13);
        jLabel13.setBounds(400, 120, 13, 34);

        quantity.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantityKeyReleased(evt);
            }
        });
        jPanel16.add(quantity);
        quantity.setBounds(190, 120, 210, 34);

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 17)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Quantity :");
        jLabel12.setFocusable(false);
        jLabel12.setRequestFocusEnabled(false);
        jLabel12.setVerifyInputWhenFocusTarget(false);
        jPanel16.add(jLabel12);
        jLabel12.setBounds(20, 120, 153, 34);

        customer_name_text.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        customer_name_text.setNextFocusableComponent(quantity);
        jPanel16.add(customer_name_text);
        customer_name_text.setBounds(190, 70, 210, 34);

        customer_combo_list.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        customer_combo_list.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        customer_combo_list.setFocusable(false);
        customer_combo_list.setRequestFocusEnabled(false);
        customer_combo_list.setVerifyInputWhenFocusTarget(false);
        jPanel16.add(customer_combo_list);
        customer_combo_list.setBounds(190, 70, 170, 34);

        text_job_order.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        text_job_order.setNextFocusableComponent(customer_name_text);
        text_job_order.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                text_job_orderKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text_job_orderKeyTyped(evt);
            }
        });
        jPanel16.add(text_job_order);
        text_job_order.setBounds(258, 20, 140, 34);

        button_include_customer.setBackground(new java.awt.Color(255, 255, 255));
        button_include_customer.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        button_include_customer.setText("Add Customer Order");
        button_include_customer.setFocusable(false);
        button_include_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_include_customerActionPerformed(evt);
            }
        });
        jPanel16.add(button_include_customer);
        button_include_customer.setBounds(24, 168, 380, 30);

        button_remove_customer.setBackground(new java.awt.Color(255, 255, 255));
        button_remove_customer.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        button_remove_customer.setText("Delete Order");
        button_remove_customer.setFocusable(false);
        button_remove_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_remove_customerActionPerformed(evt);
            }
        });
        jPanel16.add(button_remove_customer);
        button_remove_customer.setBounds(587, 168, 165, 30);

        jScrollPane1.setFocusable(false);

        jList1.setFocusable(false);
        jScrollPane1.setViewportView(jList1);

        jPanel16.add(jScrollPane1);
        jScrollPane1.setBounds(420, 15, 330, 100);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 17)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Customer Name :");
        jLabel9.setFocusable(false);
        jLabel9.setRequestFocusEnabled(false);
        jLabel9.setVerifyInputWhenFocusTarget(false);
        jPanel16.add(jLabel9);
        jLabel9.setBounds(20, 70, 153, 34);

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 17)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Job Order :");
        jLabel10.setFocusable(false);
        jLabel10.setRequestFocusEnabled(false);
        jLabel10.setVerifyInputWhenFocusTarget(false);
        jPanel16.add(jLabel10);
        jLabel10.setBounds(20, 20, 153, 34);

        job_ord_label.setBackground(new java.awt.Color(255, 255, 255));
        job_ord_label.setFont(new java.awt.Font("Century Gothic", 0, 17)); // NOI18N
        job_ord_label.setForeground(new java.awt.Color(255, 255, 255));
        job_ord_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        job_ord_label.setText("15P-10-");
        job_ord_label.setFocusable(false);
        job_ord_label.setRequestFocusEnabled(false);
        job_ord_label.setVerifyInputWhenFocusTarget(false);
        jPanel16.add(job_ord_label);
        job_ord_label.setBounds(186, 20, 70, 34);

        edit_purchase.setBackground(new java.awt.Color(255, 255, 255));
        edit_purchase.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        edit_purchase.setText("Edit Order");
        edit_purchase.setFocusable(false);
        edit_purchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_purchaseActionPerformed(evt);
            }
        });
        jPanel16.add(edit_purchase);
        edit_purchase.setBounds(414, 168, 165, 30);

        jPanel1.add(jPanel16);
        jPanel16.setBounds(10, 0, 770, 210);

        add_fabric.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        add_fabric.setText("+");
        add_fabric.setFocusable(false);
        add_fabric.setMargin(new java.awt.Insets(0, 0, 0, 0));
        add_fabric.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_fabricActionPerformed(evt);
            }
        });
        jPanel1.add(add_fabric);
        add_fabric.setBounds(452, 215, 25, 25);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 65, 790, 290));

        jPanel11.setBackground(new java.awt.Color(51, 153, 255));
        jPanel11.setFocusable(false);
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane2.setToolTipText("");
        jTabbedPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel9MouseExited(evt);
            }
        });
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel129.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel129.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel129.setText("Screen Name 1 :");
        jPanel9.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 120, 34));

        colorway_name.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jPanel9.add(colorway_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 10, 180, 34));

        name1.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        name1.setName("pigment_name"); // NOI18N
        jPanel9.add(name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 72, 165, 30));

        percentage1.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        percentage1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                percentage1KeyReleased(evt);
            }
        });
        jPanel9.add(percentage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 72, 61, 30));
        jPanel9.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 51, 775, 10));

        kg_2.setEditable(false);
        kg_2.setBackground(new java.awt.Color(204, 204, 204));
        kg_2.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        kg_2.setFocusable(false);
        kg_2.setSelectionColor(new java.awt.Color(0, 0, 0));
        jPanel9.add(kg_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 109, 85, 30));

        jLabel130.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel130.setText("kg / prep");
        jPanel9.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 75, -1, -1));

        jLabel131.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel131.setText("Pigment Name :");
        jPanel9.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 75, -1, -1));

        jLabel132.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel132.setText("%");
        jPanel9.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(678, 10, 15, 34));

        jLabel133.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel133.setText("Coverage :");
        jPanel9.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 10, -1, 34));

        weigh_kg.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        weigh_kg.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                weigh_kgPropertyChange(evt);
            }
        });
        weigh_kg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                weigh_kgKeyReleased(evt);
            }
        });
        jPanel9.add(weigh_kg, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 10, 60, 34));

        jLabel134.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel134.setText("Pigment Name :");
        jPanel9.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 112, -1, -1));

        name2.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        name2.setName("pigment_name"); // NOI18N
        jPanel9.add(name2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 109, 165, 30));

        percentage2.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        percentage2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                percentage2KeyReleased(evt);
            }
        });
        jPanel9.add(percentage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 109, 61, 30));

        jLabel135.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel135.setText("%");
        jPanel9.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 111, 31, 22));

        jLabel136.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel136.setText("kg / prep");
        jPanel9.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 112, -1, -1));

        jLabel137.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel137.setText("Pigment Name :");
        jPanel9.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 149, -1, -1));

        name3.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        name3.setName("pigment_name"); // NOI18N
        jPanel9.add(name3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 146, 165, 30));

        percentage3.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        percentage3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                percentage3KeyReleased(evt);
            }
        });
        jPanel9.add(percentage3, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 146, 61, 30));

        jLabel138.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel138.setText("%");
        jPanel9.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 148, 31, 22));

        kg_3.setEditable(false);
        kg_3.setBackground(new java.awt.Color(204, 204, 204));
        kg_3.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        kg_3.setFocusable(false);
        kg_3.setSelectionColor(new java.awt.Color(0, 0, 0));
        jPanel9.add(kg_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 146, 85, 30));

        jLabel139.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel139.setText("kg / prep");
        jPanel9.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 149, -1, -1));
        jPanel9.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 255, 775, 10));

        binder.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        binder.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3.5", "4.0", "5.5", "8.0" }));
        binder.setName(""); // NOI18N
        binder.setNextFocusableComponent(jTabbedPane2);
        jPanel9.add(binder, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 200, 61, 30));

        jLabel143.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel143.setText("Binder :");
        jPanel9.add(jLabel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 205, -1, -1));

        jLabel144.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel144.setText("%");
        jPanel9.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 205, -1, 22));

        kg_1.setEditable(false);
        kg_1.setBackground(new java.awt.Color(204, 204, 204));
        kg_1.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        kg_1.setFocusable(false);
        kg_1.setSelectionColor(new java.awt.Color(0, 0, 0));
        jPanel9.add(kg_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 72, 85, 30));

        coverage1.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        coverage1.setToolTipText("Input the coverage in percent here");
        coverage1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                coverage1KeyReleased(evt);
            }
        });
        jPanel9.add(coverage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 10, 60, 34));

        jLabel140.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel140.setText("Kilograms / KGS :");
        jPanel9.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 10, -1, 34));

        jLabel153.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel153.setText("%");
        jPanel9.add(jLabel153, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 74, 31, 22));

        pig13.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig13.setText("+");
        pig13.setFocusable(false);
        pig13.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig13ActionPerformed(evt);
            }
        });
        jPanel9.add(pig13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 148, 25, 25));

        bind_add1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        bind_add1.setText("+");
        bind_add1.setFocusable(false);
        bind_add1.setMargin(new java.awt.Insets(2, 0, 2, 0));
        bind_add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bind_add1ActionPerformed(evt);
            }
        });
        jPanel9.add(bind_add1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 203, 25, 25));

        pig11.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig11.setText("+");
        pig11.setFocusable(false);
        pig11.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig11ActionPerformed(evt);
            }
        });
        jPanel9.add(pig11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 74, 25, 25));

        pig12.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig12.setText("+");
        pig12.setFocusable(false);
        pig12.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig12ActionPerformed(evt);
            }
        });
        jPanel9.add(pig12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 25, 25));

        jTabbedPane2.addTab("1", jPanel9);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel4MouseExited(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        colorway_name3.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jPanel4.add(colorway_name3, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 10, 180, 34));

        name5.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        name5.setName("pigment_name"); // NOI18N
        jPanel4.add(name5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 72, 165, 30));

        percentage5.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        percentage5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                percentage5KeyReleased(evt);
            }
        });
        jPanel4.add(percentage5, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 72, 61, 30));
        jPanel4.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 51, 743, 10));

        kg_5.setEditable(false);
        kg_5.setBackground(new java.awt.Color(204, 204, 204));
        kg_5.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        kg_5.setFocusable(false);
        jPanel4.add(kg_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 72, 85, 30));

        jLabel50.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel50.setText("kg / prep");
        jPanel4.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 75, -1, -1));

        jLabel51.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel51.setText("Pigment Name :");
        jPanel4.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 75, -1, -1));

        jLabel52.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel52.setText("%");
        jPanel4.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 74, 31, 22));

        weigh_kg3.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        weigh_kg3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                weigh_kg3KeyReleased(evt);
            }
        });
        jPanel4.add(weigh_kg3, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 10, 60, 34));

        jLabel54.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel54.setText("Pigment Name :");
        jPanel4.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 112, -1, -1));

        name6.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        name6.setName("pigment_name"); // NOI18N
        jPanel4.add(name6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 109, 165, 30));

        percentage6.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        percentage6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                percentage6KeyReleased(evt);
            }
        });
        jPanel4.add(percentage6, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 109, 61, 30));

        jLabel55.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel55.setText("%");
        jPanel4.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 111, 31, 22));

        kg_6.setEditable(false);
        kg_6.setBackground(new java.awt.Color(204, 204, 204));
        kg_6.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        kg_6.setFocusable(false);
        kg_6.setSelectionColor(new java.awt.Color(0, 0, 0));
        jPanel4.add(kg_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 109, 85, 30));

        jLabel56.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel56.setText("kg / prep");
        jPanel4.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 112, -1, -1));

        jLabel57.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel57.setText("Pigment Name :");
        jPanel4.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 149, -1, -1));

        name7.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        name7.setName("pigment_name"); // NOI18N
        jPanel4.add(name7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 146, 165, 30));

        percentage7.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        percentage7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                percentage7KeyReleased(evt);
            }
        });
        jPanel4.add(percentage7, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 146, 61, 30));

        jLabel58.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel58.setText("%");
        jPanel4.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 148, 31, 22));

        kg_7.setEditable(false);
        kg_7.setBackground(new java.awt.Color(204, 204, 204));
        kg_7.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        kg_7.setFocusable(false);
        jPanel4.add(kg_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 146, 85, 30));

        jLabel59.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel59.setText("kg / prep");
        jPanel4.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 149, -1, -1));
        jPanel4.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 255, 743, 10));

        binder2.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        binder2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3.5", "4", "5.5", "8" }));
        binder2.setNextFocusableComponent(jTabbedPane2);
        jPanel4.add(binder2, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 200, 61, 30));

        jLabel63.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel63.setText("Binder :");
        jPanel4.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 205, -1, -1));

        jLabel64.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel64.setText("%");
        jPanel4.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 205, -1, 22));

        jLabel145.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel145.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel145.setText("Screen Name 2 :");
        jPanel4.add(jLabel145, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 120, 34));

        jLabel156.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel156.setText("%");
        jPanel4.add(jLabel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(678, 10, 15, 34));

        coverage3.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        coverage3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                coverage3KeyReleased(evt);
            }
        });
        jPanel4.add(coverage3, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 10, 60, 34));

        jLabel157.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel157.setText("Coverage :");
        jPanel4.add(jLabel157, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 10, -1, 34));

        jLabel164.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel164.setText("Kilograms / KGS :");
        jPanel4.add(jLabel164, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 10, -1, 34));

        pig21.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig21.setText("+");
        pig21.setFocusable(false);
        pig21.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig21ActionPerformed(evt);
            }
        });
        jPanel4.add(pig21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 74, 25, 25));

        pig22.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig22.setText("+");
        pig22.setFocusable(false);
        pig22.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig22ActionPerformed(evt);
            }
        });
        jPanel4.add(pig22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 25, 25));

        pig23.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig23.setText("+");
        pig23.setFocusable(false);
        pig23.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig23ActionPerformed(evt);
            }
        });
        jPanel4.add(pig23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 148, 25, 25));

        bind_add2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        bind_add2.setText("+");
        bind_add2.setFocusable(false);
        bind_add2.setMargin(new java.awt.Insets(2, 0, 2, 0));
        bind_add2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bind_add2ActionPerformed(evt);
            }
        });
        jPanel4.add(bind_add2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 203, 25, 25));

        jTabbedPane2.addTab("2", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel5MouseExited(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        colorway_name4.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jPanel5.add(colorway_name4, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 10, 180, 34));

        name9.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        name9.setName("pigment_name"); // NOI18N
        jPanel5.add(name9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 72, 165, 30));

        percentage9.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        percentage9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                percentage9KeyReleased(evt);
            }
        });
        jPanel5.add(percentage9, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 72, 61, 30));
        jPanel5.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 51, 743, 10));

        kg_9.setBackground(new java.awt.Color(204, 204, 204));
        kg_9.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        kg_9.setFocusable(false);
        jPanel5.add(kg_9, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 72, 85, 30));

        jLabel66.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel66.setText("kg / prep");
        jPanel5.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 75, -1, -1));

        jLabel67.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel67.setText("Pigment Name :");
        jPanel5.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 75, -1, -1));

        jLabel68.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel68.setText("%");
        jPanel5.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 74, 31, 22));

        weigh_kg4.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        weigh_kg4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                weigh_kg4KeyReleased(evt);
            }
        });
        jPanel5.add(weigh_kg4, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 10, 60, 34));

        jLabel70.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel70.setText("Pigment Name :");
        jPanel5.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 112, -1, -1));

        name10.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        name10.setName("pigment_name"); // NOI18N
        jPanel5.add(name10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 109, 165, 30));

        percentage10.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        percentage10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                percentage10KeyReleased(evt);
            }
        });
        jPanel5.add(percentage10, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 109, 61, 30));

        jLabel71.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel71.setText("%");
        jPanel5.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 111, 31, 22));

        kg_10.setBackground(new java.awt.Color(204, 204, 204));
        kg_10.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        kg_10.setFocusable(false);
        kg_10.setSelectionColor(new java.awt.Color(0, 0, 0));
        jPanel5.add(kg_10, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 109, 85, 30));

        jLabel72.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel72.setText("kg / prep");
        jPanel5.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 112, -1, -1));

        jLabel73.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel73.setText("Pigment Name :");
        jPanel5.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 149, -1, -1));

        name11.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        name11.setName("pigment_name"); // NOI18N
        jPanel5.add(name11, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 146, 165, 30));

        percentage11.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        percentage11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                percentage11KeyReleased(evt);
            }
        });
        jPanel5.add(percentage11, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 146, 61, 30));

        jLabel74.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel74.setText("%");
        jPanel5.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 148, 31, 22));

        kg_11.setBackground(new java.awt.Color(204, 204, 204));
        kg_11.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        kg_11.setFocusable(false);
        jPanel5.add(kg_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 146, 85, 30));

        jLabel75.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel75.setText("kg / prep");
        jPanel5.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 149, -1, -1));
        jPanel5.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 255, 743, 10));

        binder3.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        binder3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3.5", "4", "5.5", "8" }));
        binder3.setNextFocusableComponent(jTabbedPane2);
        jPanel5.add(binder3, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 200, 61, 30));

        jLabel79.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel79.setText("Binder :");
        jPanel5.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 205, -1, -1));

        jLabel80.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel80.setText("%");
        jPanel5.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 205, -1, 22));

        jLabel146.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel146.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel146.setText("Screen Name 3 :");
        jPanel5.add(jLabel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 120, 34));

        jLabel158.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel158.setText("%");
        jPanel5.add(jLabel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(678, 10, 15, 34));

        coverage4.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        coverage4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                coverage4KeyReleased(evt);
            }
        });
        jPanel5.add(coverage4, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 10, 60, 34));

        jLabel159.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel159.setText("Coverage :");
        jPanel5.add(jLabel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 10, -1, 34));

        jLabel165.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel165.setText("Kilograms / KGS :");
        jPanel5.add(jLabel165, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 10, -1, 34));

        pig31.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig31.setText("+");
        pig31.setFocusable(false);
        pig31.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig31ActionPerformed(evt);
            }
        });
        jPanel5.add(pig31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 74, 25, 25));

        pig32.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig32.setText("+");
        pig32.setFocusable(false);
        pig32.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig32ActionPerformed(evt);
            }
        });
        jPanel5.add(pig32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 25, 25));

        pig33.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig33.setText("+");
        pig33.setFocusable(false);
        pig33.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig33ActionPerformed(evt);
            }
        });
        jPanel5.add(pig33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 148, 25, 25));

        bind_add3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        bind_add3.setText("+");
        bind_add3.setFocusable(false);
        bind_add3.setMargin(new java.awt.Insets(2, 0, 2, 0));
        bind_add3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bind_add3ActionPerformed(evt);
            }
        });
        jPanel5.add(bind_add3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 203, 25, 25));

        jTabbedPane2.addTab("3", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel6MouseExited(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        colorway_name5.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jPanel6.add(colorway_name5, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 10, 180, 34));

        name13.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        name13.setName("pigment_name"); // NOI18N
        jPanel6.add(name13, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 72, 165, 30));

        percentage13.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        percentage13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                percentage13KeyReleased(evt);
            }
        });
        jPanel6.add(percentage13, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 72, 61, 30));
        jPanel6.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 51, 743, 10));

        kg_13.setBackground(new java.awt.Color(204, 204, 204));
        kg_13.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        kg_13.setFocusable(false);
        jPanel6.add(kg_13, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 72, 85, 30));

        jLabel82.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel82.setText("kg / prep");
        jPanel6.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 75, -1, -1));

        jLabel83.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel83.setText("Pigment Name :");
        jPanel6.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 75, -1, -1));

        jLabel84.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel84.setText("%");
        jPanel6.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 74, 31, 22));

        weigh_kg5.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        weigh_kg5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                weigh_kg5KeyReleased(evt);
            }
        });
        jPanel6.add(weigh_kg5, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 10, 60, 34));

        jLabel86.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel86.setText("Pigment Name :");
        jPanel6.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 112, -1, -1));

        name14.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        name14.setName("pigment_name"); // NOI18N
        jPanel6.add(name14, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 109, 165, 30));

        percentage14.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        percentage14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                percentage14KeyReleased(evt);
            }
        });
        jPanel6.add(percentage14, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 109, 61, 30));

        jLabel87.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel87.setText("%");
        jPanel6.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 111, 31, 22));

        kg_14.setBackground(new java.awt.Color(204, 204, 204));
        kg_14.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        kg_14.setFocusable(false);
        jPanel6.add(kg_14, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 109, 85, 30));

        jLabel88.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel88.setText("kg / prep");
        jPanel6.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 112, -1, -1));

        jLabel89.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel89.setText("Pigment Name :");
        jPanel6.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 149, -1, -1));

        name15.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        name15.setName("pigment_name"); // NOI18N
        jPanel6.add(name15, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 146, 165, 30));

        percentage15.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        percentage15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                percentage15KeyReleased(evt);
            }
        });
        jPanel6.add(percentage15, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 146, 61, 30));

        jLabel90.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel90.setText("%");
        jPanel6.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 148, 31, 22));

        kg_15.setBackground(new java.awt.Color(204, 204, 204));
        kg_15.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        kg_15.setFocusable(false);
        jPanel6.add(kg_15, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 146, 85, 30));

        jLabel91.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel91.setText("kg / prep");
        jPanel6.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 149, -1, -1));
        jPanel6.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 255, 743, 10));

        binder4.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        binder4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3.5", "4", "5.5", "8" }));
        binder4.setNextFocusableComponent(jTabbedPane2);
        jPanel6.add(binder4, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 200, 61, 30));

        jLabel95.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel95.setText("Binder :");
        jPanel6.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 205, -1, -1));

        jLabel96.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel96.setText("%");
        jPanel6.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 205, -1, 22));

        jLabel147.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel147.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel147.setText("Screen Name 4 :");
        jPanel6.add(jLabel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 120, 34));

        jLabel160.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel160.setText("%");
        jPanel6.add(jLabel160, new org.netbeans.lib.awtextra.AbsoluteConstraints(678, 10, 15, 34));

        coverage5.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        coverage5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                coverage5KeyReleased(evt);
            }
        });
        jPanel6.add(coverage5, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 10, 60, 34));

        jLabel161.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel161.setText("Coverage :");
        jPanel6.add(jLabel161, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 10, -1, 34));

        jLabel166.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel166.setText("Kilograms / KGS :");
        jPanel6.add(jLabel166, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 10, -1, 34));

        pig41.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig41.setText("+");
        pig41.setFocusable(false);
        pig41.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig41ActionPerformed(evt);
            }
        });
        jPanel6.add(pig41, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 74, 25, 25));

        pig42.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig42.setText("+");
        pig42.setFocusable(false);
        pig42.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig42ActionPerformed(evt);
            }
        });
        jPanel6.add(pig42, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 25, 25));

        pig43.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig43.setText("+");
        pig43.setFocusable(false);
        pig43.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig43ActionPerformed(evt);
            }
        });
        jPanel6.add(pig43, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 148, 25, 25));

        bind_add4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        bind_add4.setText("+");
        bind_add4.setFocusable(false);
        bind_add4.setMargin(new java.awt.Insets(2, 0, 2, 0));
        bind_add4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bind_add4ActionPerformed(evt);
            }
        });
        jPanel6.add(bind_add4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 203, 25, 25));

        jTabbedPane2.addTab("4", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel7MouseExited(evt);
            }
        });
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        colorway_name6.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jPanel7.add(colorway_name6, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 10, 180, 34));

        name17.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        name17.setName("pigment_name"); // NOI18N
        jPanel7.add(name17, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 72, 165, 30));

        percentage17.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        percentage17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                percentage17KeyReleased(evt);
            }
        });
        jPanel7.add(percentage17, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 72, 61, 30));
        jPanel7.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 51, 743, 10));

        kg_17.setBackground(new java.awt.Color(204, 204, 204));
        kg_17.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        jPanel7.add(kg_17, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 72, 85, 30));

        jLabel98.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel98.setText("kg / prep");
        jPanel7.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 75, -1, -1));

        jLabel99.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel99.setText("Pigment Name :");
        jPanel7.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 75, -1, -1));

        jLabel100.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel100.setText("%");
        jPanel7.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 74, 31, 22));

        weigh_kg6.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        weigh_kg6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                weigh_kg6KeyReleased(evt);
            }
        });
        jPanel7.add(weigh_kg6, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 10, 60, 34));

        jLabel102.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel102.setText("Pigment Name :");
        jPanel7.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 112, -1, -1));

        name18.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        name18.setName("pigment_name"); // NOI18N
        jPanel7.add(name18, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 109, 165, 30));

        percentage18.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        percentage18.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                percentage18KeyReleased(evt);
            }
        });
        jPanel7.add(percentage18, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 109, 61, 30));

        jLabel103.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel103.setText("%");
        jPanel7.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 111, 31, 22));

        kg_18.setBackground(new java.awt.Color(204, 204, 204));
        kg_18.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        jPanel7.add(kg_18, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 109, 85, 30));

        jLabel104.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel104.setText("kg / prep");
        jPanel7.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 112, -1, -1));

        jLabel105.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel105.setText("Pigment Name :");
        jPanel7.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 149, -1, -1));

        name19.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        name19.setName("pigment_name"); // NOI18N
        jPanel7.add(name19, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 146, 165, 30));

        percentage19.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        percentage19.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                percentage19KeyReleased(evt);
            }
        });
        jPanel7.add(percentage19, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 146, 61, 30));

        jLabel106.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel106.setText("%");
        jPanel7.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 148, 31, 22));

        kg_19.setBackground(new java.awt.Color(204, 204, 204));
        kg_19.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        jPanel7.add(kg_19, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 146, 85, 30));

        jLabel107.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel107.setText("kg / prep");
        jPanel7.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 149, -1, -1));
        jPanel7.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 255, 743, 10));

        binder5.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        binder5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3.5", "4", "5.5", "8" }));
        binder5.setNextFocusableComponent(jTabbedPane2);
        jPanel7.add(binder5, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 200, 61, 30));

        jLabel111.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel111.setText("Binder :");
        jPanel7.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 205, -1, -1));

        jLabel112.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel112.setText("%");
        jPanel7.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 205, -1, 22));

        jLabel148.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel148.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel148.setText("Screen Name 5 :");
        jPanel7.add(jLabel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 120, 34));

        jLabel162.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel162.setText("%");
        jPanel7.add(jLabel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(678, 10, 15, 34));

        coverage6.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        coverage6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                coverage6KeyReleased(evt);
            }
        });
        jPanel7.add(coverage6, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 10, 60, 34));

        jLabel163.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel163.setText("Coverage :");
        jPanel7.add(jLabel163, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 10, -1, 34));

        jLabel167.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel167.setText("Kilograms / KGS :");
        jPanel7.add(jLabel167, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 10, -1, 34));

        pig51.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig51.setText("+");
        pig51.setFocusable(false);
        pig51.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig51ActionPerformed(evt);
            }
        });
        jPanel7.add(pig51, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 74, 25, 25));

        pig52.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig52.setText("+");
        pig52.setFocusable(false);
        pig52.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig52ActionPerformed(evt);
            }
        });
        jPanel7.add(pig52, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 25, 25));

        pig53.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig53.setText("+");
        pig53.setFocusable(false);
        pig53.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig53ActionPerformed(evt);
            }
        });
        jPanel7.add(pig53, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 148, 25, 25));

        bind_add5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        bind_add5.setText("+");
        bind_add5.setFocusable(false);
        bind_add5.setMargin(new java.awt.Insets(2, 0, 2, 0));
        bind_add5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bind_add5ActionPerformed(evt);
            }
        });
        jPanel7.add(bind_add5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 203, 25, 25));

        jTabbedPane2.addTab("5", jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel8MouseExited(evt);
            }
        });
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        colorway_name7.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jPanel8.add(colorway_name7, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 10, 180, 34));

        name21.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        name21.setName("pigment_name"); // NOI18N
        jPanel8.add(name21, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 72, 165, 30));

        percentage21.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        percentage21.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                percentage21KeyReleased(evt);
            }
        });
        jPanel8.add(percentage21, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 72, 61, 30));
        jPanel8.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 51, 775, 10));

        kg_21.setBackground(new java.awt.Color(204, 204, 204));
        kg_21.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        kg_21.setFocusable(false);
        jPanel8.add(kg_21, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 72, 85, 30));

        jLabel114.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel114.setText("kg / prep");
        jPanel8.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 75, -1, -1));

        jLabel115.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel115.setText("Pigment Name :");
        jPanel8.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 75, -1, -1));

        jLabel116.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel116.setText("%");
        jPanel8.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 74, 31, 22));

        weigh_kg7.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        weigh_kg7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                weigh_kg7KeyReleased(evt);
            }
        });
        jPanel8.add(weigh_kg7, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 10, 60, 34));

        jLabel118.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel118.setText("Pigment Name :");
        jPanel8.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 112, -1, -1));

        name22.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        name22.setName("pigment_name"); // NOI18N
        jPanel8.add(name22, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 109, 165, 30));

        percentage22.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        percentage22.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                percentage22KeyReleased(evt);
            }
        });
        jPanel8.add(percentage22, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 109, 61, 30));

        jLabel119.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel119.setText("%");
        jPanel8.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 111, 31, 22));

        kg_22.setBackground(new java.awt.Color(204, 204, 204));
        kg_22.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        kg_22.setFocusable(false);
        jPanel8.add(kg_22, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 109, 85, 30));

        jLabel120.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel120.setText("kg / prep");
        jPanel8.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 112, -1, -1));

        jLabel121.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel121.setText("Pigment Name :");
        jPanel8.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 149, -1, -1));

        name23.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        name23.setName("pigment_name"); // NOI18N
        jPanel8.add(name23, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 146, 165, 30));

        percentage23.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        percentage23.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                percentage23KeyReleased(evt);
            }
        });
        jPanel8.add(percentage23, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 146, 61, 30));

        jLabel122.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel122.setText("%");
        jPanel8.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 148, 31, 22));

        kg_23.setBackground(new java.awt.Color(204, 204, 204));
        kg_23.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        kg_23.setFocusable(false);
        jPanel8.add(kg_23, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 146, 85, 30));

        jLabel123.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel123.setText("kg / prep");
        jPanel8.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 149, -1, -1));
        jPanel8.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 255, 775, 10));

        binder6.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        binder6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3.5", "4", "5.5", "8" }));
        binder6.setNextFocusableComponent(jTabbedPane2);
        jPanel8.add(binder6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 61, 30));

        jLabel127.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel127.setText("Binder :");
        jPanel8.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 205, -1, -1));

        jLabel128.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel128.setText("%");
        jPanel8.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 205, -1, 22));

        jLabel149.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel149.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel149.setText("Screen Name 6 :");
        jPanel8.add(jLabel149, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 120, 34));

        jLabel154.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel154.setText("%");
        jPanel8.add(jLabel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(678, 10, 15, 34));

        coverage2.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        coverage2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                coverage2KeyReleased(evt);
            }
        });
        jPanel8.add(coverage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 10, 60, 34));

        jLabel155.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel155.setText("Coverage :");
        jPanel8.add(jLabel155, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 10, -1, 34));

        jLabel168.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel168.setText("Kilograms / KGS :");
        jPanel8.add(jLabel168, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 10, -1, 34));

        pig61.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig61.setText("+");
        pig61.setFocusable(false);
        pig61.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig61ActionPerformed(evt);
            }
        });
        jPanel8.add(pig61, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 74, 25, 25));

        pig62.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig62.setText("+");
        pig62.setFocusable(false);
        pig62.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig62ActionPerformed(evt);
            }
        });
        jPanel8.add(pig62, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 25, 25));

        pig63.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig63.setText("+");
        pig63.setFocusable(false);
        pig63.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig63ActionPerformed(evt);
            }
        });
        jPanel8.add(pig63, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 148, 25, 25));

        bind_add6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        bind_add6.setText("+");
        bind_add6.setFocusable(false);
        bind_add6.setMargin(new java.awt.Insets(2, 0, 2, 0));
        bind_add6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bind_add6ActionPerformed(evt);
            }
        });
        jPanel8.add(bind_add6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 203, 25, 25));

        jTabbedPane2.addTab("6", jPanel8);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel15MouseExited(evt);
            }
        });
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        colorway_name8.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jPanel15.add(colorway_name8, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 10, 180, 34));

        name24.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        name24.setName("pigment_name"); // NOI18N
        jPanel15.add(name24, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 72, 165, 30));

        percentage24.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        percentage24.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                percentage24KeyReleased(evt);
            }
        });
        jPanel15.add(percentage24, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 72, 61, 30));
        jPanel15.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 51, 775, 10));

        kg_24.setBackground(new java.awt.Color(204, 204, 204));
        kg_24.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        kg_24.setFocusable(false);
        jPanel15.add(kg_24, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 72, 85, 30));

        jLabel117.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel117.setText("kg / prep");
        jPanel15.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 75, -1, -1));

        jLabel124.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel124.setText("Pigment Name :");
        jPanel15.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 75, -1, -1));

        jLabel125.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel125.setText("%");
        jPanel15.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 74, 31, 22));

        weigh_kg8.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        weigh_kg8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                weigh_kg8KeyReleased(evt);
            }
        });
        jPanel15.add(weigh_kg8, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 10, 60, 34));

        jLabel126.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel126.setText("Pigment Name :");
        jPanel15.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 112, -1, -1));

        name25.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        name25.setName("pigment_name"); // NOI18N
        jPanel15.add(name25, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 109, 165, 30));

        percentage25.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        percentage25.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                percentage25KeyReleased(evt);
            }
        });
        jPanel15.add(percentage25, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 109, 61, 30));

        jLabel141.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel141.setText("%");
        jPanel15.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 111, 31, 22));

        kg_25.setBackground(new java.awt.Color(204, 204, 204));
        kg_25.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        kg_25.setFocusable(false);
        jPanel15.add(kg_25, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 109, 85, 30));

        jLabel142.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel142.setText("kg / prep");
        jPanel15.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 112, -1, -1));

        jLabel150.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel150.setText("Pigment Name :");
        jPanel15.add(jLabel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 149, -1, -1));

        name26.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        name26.setName("pigment_name"); // NOI18N
        jPanel15.add(name26, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 146, 165, 30));

        percentage26.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        percentage26.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                percentage26KeyReleased(evt);
            }
        });
        jPanel15.add(percentage26, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 146, 61, 30));

        jLabel151.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel151.setText("%");
        jPanel15.add(jLabel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 148, 31, 22));

        kg_26.setBackground(new java.awt.Color(204, 204, 204));
        kg_26.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        kg_26.setFocusable(false);
        jPanel15.add(kg_26, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 146, 85, 30));

        jLabel152.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel152.setText("kg / prep");
        jPanel15.add(jLabel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 149, -1, -1));
        jPanel15.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 255, 775, 10));

        binder7.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        binder7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3.5", "4", "5.5", "8" }));
        binder7.setNextFocusableComponent(add_fabric);
        jPanel15.add(binder7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 61, 30));

        jLabel169.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel169.setText("Binder :");
        jPanel15.add(jLabel169, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 205, -1, -1));

        jLabel170.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel170.setText("%");
        jPanel15.add(jLabel170, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 205, -1, 22));

        jLabel171.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel171.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel171.setText("Screen Name 7 :");
        jPanel15.add(jLabel171, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 120, 34));

        jLabel172.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel172.setText("%");
        jPanel15.add(jLabel172, new org.netbeans.lib.awtextra.AbsoluteConstraints(678, 10, 15, 34));

        coverage8.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        coverage8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                coverage8KeyReleased(evt);
            }
        });
        jPanel15.add(coverage8, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 10, 60, 34));

        jLabel173.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel173.setText("Coverage :");
        jPanel15.add(jLabel173, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 10, -1, 34));

        jLabel174.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel174.setText("Kilograms / KGS :");
        jPanel15.add(jLabel174, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 10, -1, 34));

        pig71.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig71.setText("+");
        pig71.setFocusable(false);
        pig71.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig71ActionPerformed(evt);
            }
        });
        jPanel15.add(pig71, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 74, 25, 25));

        pig72.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig72.setText("+");
        pig72.setFocusable(false);
        pig72.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig72ActionPerformed(evt);
            }
        });
        jPanel15.add(pig72, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 25, 25));

        pig_73.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig_73.setText("+");
        pig_73.setFocusable(false);
        pig_73.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig_73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig_73ActionPerformed(evt);
            }
        });
        jPanel15.add(pig_73, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 148, 25, 25));

        bind_add7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        bind_add7.setText("+");
        bind_add7.setFocusable(false);
        bind_add7.setMargin(new java.awt.Insets(2, 0, 2, 0));
        bind_add7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bind_add7ActionPerformed(evt);
            }
        });
        jPanel15.add(bind_add7, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 203, 25, 25));

        jTabbedPane2.addTab("7", jPanel15);

        jPanel11.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 44, 748, 246));

        add_order.setBackground(new java.awt.Color(255, 255, 255));
        add_order.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        add_order.setText("Add this Purchase");
        add_order.setToolTipText("");
        add_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_orderActionPerformed(evt);
            }
        });
        jPanel11.add(add_order, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 296, 240, 42));
        add_order.getAccessibleContext().setAccessibleDescription("Add this design and print it");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Screens");
        jLabel8.setFocusable(false);
        jPanel11.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 0, 150, -1));

        preview_but.setBackground(new java.awt.Color(255, 255, 255));
        preview_but.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        preview_but.setText("Preview this Purchase");
        preview_but.setToolTipText("");
        preview_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preview_butActionPerformed(evt);
            }
        });
        jPanel11.add(preview_but, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 296, 240, 42));
        preview_but.getAccessibleContext().setAccessibleDescription("Show a previous of the design's details");

        cancel_but.setBackground(new java.awt.Color(255, 255, 255));
        cancel_but.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        cancel_but.setText("Cancel and Exit");
        cancel_but.setToolTipText("");
        cancel_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_butActionPerformed(evt);
            }
        });
        jPanel11.add(cancel_but, new org.netbeans.lib.awtextra.AbsoluteConstraints(516, 296, 240, 42));
        cancel_but.getAccessibleContext().setAccessibleDescription("Cancel the addition of this design");

        getContentPane().add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 790, 360));

        setSize(new java.awt.Dimension(809, 752));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * 
     * @param pigment_name -Declared pigment name
     * @param pigment_percent - percentage of pigment in variable float
     */
    public String get_pigment_name(int pigment_no){
        pigment pigment = new pigment();
        pigment.setPigment_id(pigment_no);
        pigment.get_pigment_name_from_id();
        
        return pigment.getPigment_name();
    }
    
    private void setTextValues_screens(JComboBox pigment_name, JTextField percentage, Pigment_with_screen_connect screen_p)
    {
        pigment_name.setSelectedItem(screen_p.getPigment_name());
        percentage.setText(Float.toString(screen_p.getPigment_percentage()));
    }
    private void setTextValues_colorway(JTextField colorway, JTextField weight, JComboBox binder, Colorway_with_pigment this_c_and_s)
    {
        colorway.setText(this_c_and_s.getColorway_name());
        weight.setText(Integer.toString(Math.round(this_c_and_s.getWeight_kg())));
        binder.setSelectedItem(this_c_and_s.getBinder());
    }
    
    private void set_all_textbox_colorways(List<Colorway_with_pigment> this_color_and_screen)
    {
        for(int x = 0 ; x<this_color_and_screen.size(); x++)
        {
            List<Pigment_with_screen_connect> current_screen = this_color_and_screen.get(x).getThis_screens();
            
            if(x == 0)
            {
                setTextValues_colorway(colorway_name,weigh_kg, binder, this_color_and_screen.get(x));
                
                for(int temp_loop2 = 0; temp_loop2 < current_screen.size(); temp_loop2++ )
                {
                    if(temp_loop2 == 0)
                    {
                            setTextValues_screens(name1, percentage1, current_screen.get(temp_loop2));
                    }
                    else if(temp_loop2 == 1)
                    {
                            setTextValues_screens(name2, percentage2, current_screen.get(temp_loop2));
                    }
                    else if(temp_loop2 == 2)
                    {
                            setTextValues_screens(name3, percentage3, current_screen.get(temp_loop2));
                    }
                }
            }
            else if( x == 1)
            {
                setTextValues_colorway(colorway_name3,weigh_kg3, binder2, this_color_and_screen.get(x));
                
                for(int temp_loop2 = 0; temp_loop2 < current_screen.size(); temp_loop2++ )
                {
                    if(temp_loop2 == 0)
                    {
                            setTextValues_screens(name5, percentage5, current_screen.get(temp_loop2));
                    }
                    else if(temp_loop2 == 1)
                    {
                            setTextValues_screens(name6, percentage6, current_screen.get(temp_loop2));
                    }
                    else if(temp_loop2 == 2)
                    {
                            setTextValues_screens(name7, percentage7, current_screen.get(temp_loop2));
                    }
                }
            }
            else if( x == 2)
            {
                setTextValues_colorway(colorway_name4,weigh_kg4, binder3, this_color_and_screen.get(x));
                
                for(int temp_loop2 = 0; temp_loop2 < current_screen.size(); temp_loop2++ )
                {
                    if(temp_loop2 == 0)
                            setTextValues_screens(name9, percentage9, current_screen.get(temp_loop2));
                    else if(temp_loop2 == 1)
                            setTextValues_screens(name10, percentage10, current_screen.get(temp_loop2));
                    else if(temp_loop2 == 2)
                            setTextValues_screens(name11, percentage11, current_screen.get(temp_loop2));
                }
            }
            else if( x == 3)
            {
                setTextValues_colorway(colorway_name5,weigh_kg5, binder4, this_color_and_screen.get(x));
                
                for(int temp_loop2 = 0; temp_loop2 < current_screen.size(); temp_loop2++ )
                {
                    if(temp_loop2 == 0)
                            setTextValues_screens(name13, percentage13, current_screen.get(temp_loop2));
                    else if(temp_loop2 == 1)
                            setTextValues_screens(name14, percentage14, current_screen.get(temp_loop2));
                    else if(temp_loop2 == 2)
                            setTextValues_screens(name15, percentage15, current_screen.get(temp_loop2));
                }
            }
            else if( x == 4)
            {
                setTextValues_colorway(colorway_name6,weigh_kg6, binder5, this_color_and_screen.get(x));
                
                for(int temp_loop2 = 0; temp_loop2 < current_screen.size(); temp_loop2++ )
                {
                    if(temp_loop2 == 0)
                            setTextValues_screens(name17, percentage17, current_screen.get(temp_loop2));
                    else if(temp_loop2 == 1)
                            setTextValues_screens(name18, percentage18, current_screen.get(temp_loop2));
                    else if(temp_loop2 == 2)
                            setTextValues_screens(name19, percentage19, current_screen.get(temp_loop2));
                }
            }
            
            else if( x == 5)
            {
                setTextValues_colorway(colorway_name7,weigh_kg7, binder6, this_color_and_screen.get(x));
                
                for(int temp_loop2 = 0; temp_loop2 < current_screen.size(); temp_loop2++ )
                {
                    if(temp_loop2 == 0)
                            setTextValues_screens(name21, percentage21, current_screen.get(temp_loop2));
                    else if(temp_loop2 == 1)
                            setTextValues_screens(name22, percentage22, current_screen.get(temp_loop2));
                    else if(temp_loop2 == 2)
                            setTextValues_screens(name23, percentage23, current_screen.get(temp_loop2));
                }
            }
            else if( x == 6)
            {
                setTextValues_colorway(colorway_name8,weigh_kg8, binder7, this_color_and_screen.get(x));
                
                for(int temp_loop2 = 0; temp_loop2 < current_screen.size(); temp_loop2++ )
                {
                    if(temp_loop2 == 0)
                            setTextValues_screens(name24, percentage24, current_screen.get(temp_loop2));
                    else if(temp_loop2 == 1)
                            setTextValues_screens(name25, percentage25, current_screen.get(temp_loop2));
                    else if(temp_loop2 == 2)
                            setTextValues_screens(name26, percentage26, current_screen.get(temp_loop2));
                }
            }
        }
    }
    
    public void set_design_and_colorway_textbox(Design_with_colorway this_design)
    {
        this.design_name.setText(this_design.getDesign_name());
            //design colorway
        this.design_color.setText(this_design.getColor_name());
            //fabric style
        this.fab_style_comb.setSelectedItem(this_design.getFabric_style());
        //this.set_all_textbox_colorways(this_d);
        set_all_textbox_colorways(this_design.getAll_colorways());
    }
    
    public void fill_info2(int purchase_order)
    {
        this.edit_recipe = true;
        this_recipe.set_all_details_from_purchase_order_id(purchase_order);
        this.set_design_and_colorway_textbox(this_recipe);
        this.previous_quantity_total = 1000;
    }
    
    private void fill_customer_list()
    {
        this.customer_combo_list.removeAllItems();
        this.customer_combo_list.addItem(" ");
        customer list = new customer();
        list.get_customer_list();
        for ( String name : list.getCustomer_names() )
        {
            this.customer_combo_list.addItem(name);
        }
    }
    
    private List<purchase_order> get_all_purchase_details(int design_code)
    {
        List<purchase_order> all_purchase = new ArrayList<>();
        
        for (int i = 0; i < this_list.getJob_list().size(); i++) 
        {
            purchase_order purchase = new purchase_order();
            purchase.setDesign_code(design_code);
            purchase.setJob_order_id(this_list.getJob_list().get(i).toString()); 
            purchase.setQuantity(Integer.parseInt(this_list.getQuantity_list().get(i).toString()));
        
            all_purchase.add(purchase);
        }
        return all_purchase;
    }
    
    private List<job_order> get_job_details()
    {    
        List<job_order> all_job_orders = new ArrayList<>();
        for (int i = 0; i < this_list.getJob_list().size(); i++) 
        {
            job_order job = new job_order();
            job.setJob_id(this_list.getJob_list().get(i).toString());
            job.setCustomer_name(this_list.getCustomer_list().get(i).toString().toUpperCase());//job.set_customer_id_from_name();
            job.setDate(use_func.get_date_from_spinner(spinner_date));
            all_job_orders.add(job);
        }
        return all_job_orders;
    }
    
    private int add_this_design_and_colorway()
    {
        production_recipe this_design = get_design_details();
        this_design.setDesign_code(-1);
        if(design_name.getText().length() != 0 && design_color.getText().length() != 0 )
        {
            System.out.println(this_design.getDesign_code());
            if(this_design.get_design_code_using_variables())
            {
                
            ////Design has already been added, just access design code;
                int reply = JOptionPane.showConfirmDialog(null,"The design with this name, color and fabric has already been added. (Yes to use this design, No to change name of design , color or fabric) "
                    + "Do you want to use the existing design?","Use existing design?", JOptionPane.YES_NO_OPTION);
                if(reply == JOptionPane.YES_OPTION)
                {
                //this_design.setDesign_code(reply);
                }
                else
                    this_design.setDesign_code(-1);
                
            }
            else{
                this_design.add_new_design_and_set_design_code();
                this.add_all_this_colorways(this_design.getDesign_code());
            }
        }
        
        return this_design.getDesign_code();
        
    }
    
    private production_recipe get_design_details()
    {
        //Constructor instead of setting items
        colortextile_class.production_recipe new_design = new colortextile_class.production_recipe(design_name.getText(),
                design_color.getText(),
                fab_style_comb.getSelectedItem().toString(),
                use_func.get_date_from_spinner(spinner_date));
        
        List<Colorway_with_pigment> all_color_screen = this.get_all_colorway_inputs();
        new_design.setAll_colorways(all_color_screen);
        //new_design.view_all_colorway_details();
        if (this.jList1.getModel().getSize() != 0)
        {
            new_design.setJobs_for_this(this.get_job_details());
            //Adds purchase order and design
            new_design.setAll_purchase(get_all_purchase_details(1));
            new_design.view_all_job_order_details();
        }
        
        return new_design; 
    }
    
    private List<Colorway_with_pigment> get_all_colorway_inputs()
    {
        List<Colorway_with_pigment> all_colorway = new ArrayList<>();
        
        for(int interval = 0 ; interval < 7; interval++ )
        {
            Colorway_with_pigment this_colorway_screen;
            
            if(interval==0)
            {
                //Individual Colorway
                this_colorway_screen = new Colorway_with_pigment(colorway_name.getText(), 
                             Float.parseFloat(binder.getSelectedItem().toString()),
                             weigh_kg.getText());
        
                this_colorway_screen.add_screen(use_func.get_pigment_screen_details_from_input(name1, percentage1));
                this_colorway_screen.add_screen(use_func.get_pigment_screen_details_from_input(name2, percentage2));
                this_colorway_screen.add_screen(use_func.get_pigment_screen_details_from_input(name3, percentage3));
        
                //All Colorways to be stacked in List
                all_colorway.add(this_colorway_screen);
            }
            else if(interval==1)
            {
                this_colorway_screen = new Colorway_with_pigment(colorway_name3.getText(), 
                             Float.parseFloat(binder2.getSelectedItem().toString()),
                             weigh_kg3.getText());
                
                this_colorway_screen.add_screen(use_func.get_pigment_screen_details_from_input(name5, percentage5));
                this_colorway_screen.add_screen(use_func.get_pigment_screen_details_from_input(name6, percentage6));
                this_colorway_screen.add_screen(use_func.get_pigment_screen_details_from_input(name7, percentage7));
        
                all_colorway.add(this_colorway_screen);
            }
            else if(interval == 2)
            {
                this_colorway_screen = new Colorway_with_pigment(colorway_name4.getText(), 
                             Float.parseFloat(binder3.getSelectedItem().toString()),
                             weigh_kg4.getText());
                
                this_colorway_screen.add_screen(use_func.get_pigment_screen_details_from_input(name9, percentage9));
                this_colorway_screen.add_screen(use_func.get_pigment_screen_details_from_input(name10, percentage10));
                this_colorway_screen.add_screen(use_func.get_pigment_screen_details_from_input(name11, percentage11));
        
                all_colorway.add(this_colorway_screen);
            }
            else if(interval == 3)
            {
                this_colorway_screen = new Colorway_with_pigment(colorway_name5.getText(), 
                             Float.parseFloat(binder4.getSelectedItem().toString()),
                             weigh_kg5.getText());
                
                this_colorway_screen.add_screen(use_func.get_pigment_screen_details_from_input(name13, percentage13));
                this_colorway_screen.add_screen(use_func.get_pigment_screen_details_from_input(name14, percentage14));
                this_colorway_screen.add_screen(use_func.get_pigment_screen_details_from_input(name15, percentage15));
        
                all_colorway.add(this_colorway_screen);
            }
            else if(interval == 4)
            {
                this_colorway_screen = new Colorway_with_pigment(colorway_name6.getText(), 
                             Float.parseFloat(binder5.getSelectedItem().toString()),
                             weigh_kg6.getText());
                
                this_colorway_screen.add_screen(use_func.get_pigment_screen_details_from_input(name17, percentage17));
                this_colorway_screen.add_screen(use_func.get_pigment_screen_details_from_input(name18, percentage18));
                this_colorway_screen.add_screen(use_func.get_pigment_screen_details_from_input(name19, percentage19));
        
                all_colorway.add(this_colorway_screen);
            }
            else if(interval == 5)
            {
             this_colorway_screen = new Colorway_with_pigment(colorway_name7.getText(), 
                             Float.parseFloat(binder6.getSelectedItem().toString()),
                             weigh_kg7.getText());
                
                this_colorway_screen.add_screen(use_func.get_pigment_screen_details_from_input(name21, percentage21));
                this_colorway_screen.add_screen(use_func.get_pigment_screen_details_from_input(name22, percentage22));
                this_colorway_screen.add_screen(use_func.get_pigment_screen_details_from_input(name23, percentage23));
        
                all_colorway.add(this_colorway_screen);   
            }
            else if(interval == 6)
            {
                this_colorway_screen = new Colorway_with_pigment(colorway_name8.getText(), 
                             Float.parseFloat(binder7.getSelectedItem().toString()),
                             weigh_kg8.getText());
                
                this_colorway_screen.add_screen(use_func.get_pigment_screen_details_from_input(name24, percentage24));
                this_colorway_screen.add_screen(use_func.get_pigment_screen_details_from_input(name25, percentage25));
                this_colorway_screen.add_screen(use_func.get_pigment_screen_details_from_input(name26, percentage26));
        
                all_colorway.add(this_colorway_screen); 
            }
        }
        return all_colorway;
    }
    
    
    
    private void add_all_this_colorways(int design_code)
    {
        //1st Colorway if it exists
        int colorway_id = use_func.add_this_colorway(colorway_name.getText(), 
                             Float.parseFloat(binder.getSelectedItem().toString()),
                             weigh_kg.getText(), design_code, this.fab_style_comb.getSelectedItem().toString(), this.quantity_total.getText());
        //System.out.println("COLORWAY id 1 = " +colorway_id);
        if(colorway_id != -1 )
        {   
            use_func.add_this_pigment_screen(use_func.get_pigment_screen_details_from_input(name1,percentage1), 
                    colorway_id );
            
            use_func.add_this_pigment_screen(use_func.get_pigment_screen_details_from_input(name2,percentage2), 
                    colorway_id );
            
            use_func.add_this_pigment_screen(use_func.get_pigment_screen_details_from_input(name3,percentage3), 
                    colorway_id );
        }
        
        //2nd Colorway if it exists
        int colorway_id2 = use_func.add_this_colorway(colorway_name3.getText(), 
                             Float.parseFloat(binder2.getSelectedItem().toString()),
                             weigh_kg3.getText(), design_code, this.fab_style_comb.getSelectedItem().toString(), this.quantity_total.getText());
        //System.out.println("COLORWAY id 2 = " +colorway_id2);
        if(colorway_id2 != -1 )
        {
            use_func.add_this_pigment_screen(use_func.get_pigment_screen_details_from_input(name5,percentage5), 
                    colorway_id2 );
            
            use_func.add_this_pigment_screen(use_func.get_pigment_screen_details_from_input(name6,percentage6), 
                    colorway_id2 );
            
            use_func.add_this_pigment_screen(use_func.get_pigment_screen_details_from_input(name7,percentage7), 
                    colorway_id2 );
        }
        
        //3rd Colorway if it exists
        int colorway_id3 = use_func.add_this_colorway(colorway_name4.getText(), 
                             Float.parseFloat(binder3.getSelectedItem().toString()),
                             weigh_kg4.getText() , design_code, this.fab_style_comb.getSelectedItem().toString(), this.quantity_total.getText());
        //System.out.println("COLORWAY id 3 = " +colorway_id3);
        if(colorway_id3 != -1 )
        {
            use_func.add_this_pigment_screen(use_func.get_pigment_screen_details_from_input(name9,percentage9), 
                    colorway_id3 );
            
            use_func.add_this_pigment_screen(use_func.get_pigment_screen_details_from_input(name10,percentage10),
                    colorway_id3 );
            
            use_func.add_this_pigment_screen(use_func.get_pigment_screen_details_from_input(name11,percentage11), 
                    colorway_id3 );
           
        }
        //4th Colorway if it exists
        int colorway_id4 = use_func.add_this_colorway(colorway_name5.getText(), 
                             Float.parseFloat(binder4.getSelectedItem().toString()),
                             weigh_kg5.getText(), design_code, this.fab_style_comb.getSelectedItem().toString(), this.quantity_total.getText());
        //System.out.println("COLORWAY id 4 = " +colorway_id4);
        if(colorway_id4 != -1 )
        {
            use_func.add_this_pigment_screen(use_func.get_pigment_screen_details_from_input(name13,percentage13),
                    colorway_id4 );
            
            use_func.add_this_pigment_screen(use_func.get_pigment_screen_details_from_input(name14,percentage14), 
                    colorway_id4 );
            
            use_func.add_this_pigment_screen(use_func.get_pigment_screen_details_from_input(name15,percentage15), 
                    colorway_id4 );
        }
        
        //5th Colorway if it exists
        int colorway_id5 = use_func.add_this_colorway(colorway_name6.getText(), 
                             Float.parseFloat(binder5.getSelectedItem().toString()),
                             weigh_kg6.getText() , design_code, this.fab_style_comb.getSelectedItem().toString(), this.quantity_total.getText());
        //System.out.println("COLORWAY id 5 = " +colorway_id5);
        if(colorway_id5 != -1 )
        {
            use_func.add_this_pigment_screen(use_func.get_pigment_screen_details_from_input(name17,percentage17), 
                    colorway_id5 );
            
            use_func.add_this_pigment_screen(use_func.get_pigment_screen_details_from_input(name18,percentage18), 
                    colorway_id5 );
            
            use_func.add_this_pigment_screen(use_func.get_pigment_screen_details_from_input(name19,percentage19), 
                    colorway_id5 );
        }
        
        //6th Colorway if it exists
        int colorway_id6 = use_func.add_this_colorway(colorway_name7.getText(), 
                             Float.parseFloat(binder6.getSelectedItem().toString()),
                             weigh_kg7.getText(), design_code, this.fab_style_comb.getSelectedItem().toString(), this.quantity_total.getText());
        //System.out.println("COLORWAY id 6 = " +colorway_id6);
        if( colorway_id6 != -1 )
        {
            use_func.add_this_pigment_screen(use_func.get_pigment_screen_details_from_input(name21,percentage21), 
                    colorway_id6 );
            
            use_func.add_this_pigment_screen(use_func.get_pigment_screen_details_from_input(name22,percentage22), 
                    colorway_id6 );
            
            use_func.add_this_pigment_screen(use_func.get_pigment_screen_details_from_input(name23,percentage23), 
                    colorway_id6 );
        }
        
        //7th Colorway if it exists
        int colorway_id7 = use_func.add_this_colorway(colorway_name8.getText(), 
                             Float.parseFloat(binder7.getSelectedItem().toString()),
                             weigh_kg8.getText(), design_code, this.fab_style_comb.getSelectedItem().toString(), this.quantity_total.getText());
        //System.out.println("COLORWAY id 7 = " +colorway_id6);
        if( colorway_id7 != -1 )
        {
            use_func.add_this_pigment_screen(use_func.get_pigment_screen_details_from_input(name24,percentage24), 
                    colorway_id7 );
            
            use_func.add_this_pigment_screen(use_func.get_pigment_screen_details_from_input(name25,percentage25), 
                    colorway_id7 );
            
            use_func.add_this_pigment_screen(use_func.get_pigment_screen_details_from_input(name26,percentage26), 
                    colorway_id7 );
        }
    }

    private void include()
    {   
        String job_order = this.job_ord_label.getText() + this.text_job_order.getText();
        this_list.add_customer_job_quantity_in_list(customer_name_text.getText(), 
                                                        job_order, 
                                                        quantity.getText());
        //refresh Textbox to add items
        this.jList1.setModel(this_list.get_items_in_list());
        
        
        //if(this.customer_check_box.isSelected())
        //{
        
        //customer_list.add(this.customer_name_text.getText());
        /*}
        else
        {
            this_list.add_customer_job_quantity_in_list(customer_combo_list.getSelectedItem().toString(), 
                    job_order, 
                    quantity.getText());
        }
        //job_list.add(this.job_ord_label.getText() + this.text_job_order.getText());
        //quantity_list.add(this.quantity.getText());
        
        */
    }
    
    private void adjust_weights()
    {
        check_and_adjust_weights(weigh_kg);
        check_and_adjust_weights(weigh_kg3);
        check_and_adjust_weights(weigh_kg4);
        check_and_adjust_weights(weigh_kg5);
        check_and_adjust_weights(weigh_kg6);
        check_and_adjust_weights(weigh_kg7);
        check_and_adjust_weights(weigh_kg8);
        this.previous_quantity_total = this_list.get_quantity_total();
        
    }
    
    private void check_and_adjust_weights(JTextField this_weight_field){
        
        if(this_weight_field.getText().length()>0 && previous_quantity_total != 0)
        {
            Float coverage_of_this = this_recipe.compute_this_coverage(Float.parseFloat(this_weight_field.getText()), this.previous_quantity_total);
            //System.out.println(coverage_of_this.toString());
            Float computation = this_recipe.compute_this_kg(coverage_of_this, this_list.get_quantity_total());
            //System.out.println(computation);
            this_weight_field.setText(Integer.toString(Math.round(computation)));
        } 
    }
    
    private void add_orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_orderActionPerformed
        // TODO add your handling code here:
        if (this.jList1.getModel().getSize() == 0){
            JOptionPane.showMessageDialog(null,"Please add a customer and a job order");
        }
        else 
        {   //Adds purchase order and design
            int des_code = this.add_this_design_and_colorway();
            if(des_code != -1)
            {
                this.add_purchase(des_code);
                this.add_job();
                
                int CloseorNoreply = JOptionPane.showConfirmDialog(null,"Successfully Added this Recipe! Close Window? "
                    + "(Yes to close this window) ", "Close this Window?", JOptionPane.YES_NO_OPTION);
                if(CloseorNoreply == JOptionPane.YES_OPTION)
                this.dispose();
            }
            else
                JOptionPane.showMessageDialog(null, "Please input a design name and/or design color.");
            
            //production_recipe prod_recipe = this.get_design_details();
            //this.this_purchase.setPurchase_Id_from_Date_and_code();
            //prod_recipe.set_design_details_from_purchase_order_id();
            //this.this_purchase.set_job_order_list_using_purchase_order_id();
            //SpreadsheetTrial printFile = new SpreadsheetTrial();
            //printFile.print_this_job2(prod_recipe);
            
            
        }
    }//GEN-LAST:event_add_orderActionPerformed
    
    private void add_job()
    {  
        this_recipe.setJobs_for_this(get_job_details());
        this_recipe.add_all_job_order();
    }
    
    private void add_purchase(int design_code)
    {
        this_recipe.setAll_purchase(this.get_all_purchase_details(design_code));
        this_recipe.add_all_purchase_order_to_database();
    }
    
    private void clear_all(){
        
    }
    
    private void text_job_orderKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_job_orderKeyTyped
        // TODO add your handling code here:
        if (this.text_job_order.getText().length() >= 4 )
            this.text_job_order.setText(text_job_order.getText().substring(0, 3));
    }//GEN-LAST:event_text_job_orderKeyTyped

    private void coverage1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_coverage1KeyReleased
         // TODO add your handling code here:
        if(use_func.check_this_textbox(coverage1))
        {
            compute_kg(weigh_kg, coverage1);
            use_func.update_kg_prep(percentage1.getText(), weigh_kg.getText(), kg_1);
            use_func.update_kg_prep(percentage2.getText(), weigh_kg.getText(), kg_2);
            use_func.update_kg_prep(percentage3.getText(), weigh_kg.getText(), kg_3);
        }    
        
    }//GEN-LAST:event_coverage1KeyReleased

    private void coverage2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_coverage2KeyReleased
        // TODO add your handling code here:
        if(use_func.check_this_textbox(coverage2)){
            compute_kg(weigh_kg7, coverage2);     
            use_func.update_kg_prep(percentage21.getText(), weigh_kg7.getText(), kg_21);
            use_func.update_kg_prep(percentage22.getText(), weigh_kg7.getText(), kg_22);
            use_func.update_kg_prep(percentage23.getText(), weigh_kg7.getText(), kg_23);
        }
    }//GEN-LAST:event_coverage2KeyReleased

    private void coverage3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_coverage3KeyReleased
        // TODO add your handling code here: 
        if(use_func.check_this_textbox(coverage3)){
            compute_kg(weigh_kg3, coverage3);
            use_func.update_kg_prep(percentage5.getText(), weigh_kg3.getText(), kg_5);
            use_func.update_kg_prep(percentage6.getText(), weigh_kg3.getText(), kg_6);
            use_func.update_kg_prep(percentage7.getText(), weigh_kg3.getText(), kg_7);
        }
    }//GEN-LAST:event_coverage3KeyReleased

    private void coverage4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_coverage4KeyReleased
        // TODO add your handling code here:
        if(use_func.check_this_textbox(coverage4)){
            compute_kg(weigh_kg4, coverage4);       
            use_func.update_kg_prep(percentage9.getText(), weigh_kg4.getText(), kg_9);
            use_func.update_kg_prep(percentage10.getText(), weigh_kg4.getText(), kg_10);
            use_func.update_kg_prep(percentage11.getText(), weigh_kg4.getText(), kg_11);
        }
    }//GEN-LAST:event_coverage4KeyReleased

    private void coverage5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_coverage5KeyReleased
        // TODO add your handling code here:
        if(use_func.check_this_textbox(coverage5)){
            compute_kg(weigh_kg5, coverage5);
            use_func.update_kg_prep(percentage13.getText(), weigh_kg5.getText(), kg_13);
            use_func.update_kg_prep(percentage14.getText(), weigh_kg5.getText(), kg_14);
            use_func.update_kg_prep(percentage15.getText(), weigh_kg5.getText(), kg_15);
        }
            
    }//GEN-LAST:event_coverage5KeyReleased

    private void coverage6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_coverage6KeyReleased
        // TODO add your handling code here:
        if(use_func.check_this_textbox(coverage6))
        {
            compute_kg(weigh_kg6, coverage6);
            use_func.update_kg_prep(percentage17.getText(), weigh_kg6.getText(), kg_17);
            use_func.update_kg_prep(percentage18.getText(), weigh_kg6.getText(), kg_18);
            use_func.update_kg_prep(percentage19.getText(), weigh_kg6.getText(), kg_19);
        }
    }//GEN-LAST:event_coverage6KeyReleased

    private void percentage1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage1KeyReleased
        // TODO add your handling code here:
        if(use_func.check_this_textbox(percentage1))
            use_func.update_kg_prep(percentage1.getText(), weigh_kg.getText(), kg_1);
    }//GEN-LAST:event_percentage1KeyReleased

    private void percentage2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage2KeyReleased
        // TODO add your handling code here:
        if(use_func.check_this_textbox(percentage2))
            use_func.update_kg_prep(percentage2.getText(), weigh_kg.getText(), kg_2);
    }//GEN-LAST:event_percentage2KeyReleased

    private void percentage3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage3KeyReleased
        // TODO add your handling code here:
        if(use_func.check_this_textbox(percentage3))
            use_func.update_kg_prep(percentage3.getText(), weigh_kg.getText(), kg_3);
    }//GEN-LAST:event_percentage3KeyReleased

    private void weigh_kgKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_weigh_kgKeyReleased
        // TODO add your handling code here:
        if(use_func.check_this_textbox(weigh_kg))
        {        
            use_func.update_kg_prep(percentage1.getText(), weigh_kg.getText(), kg_1);
            use_func.update_kg_prep(percentage2.getText(), weigh_kg.getText(), kg_2);
            use_func.update_kg_prep(percentage3.getText(), weigh_kg.getText(), kg_3);
        }
    }//GEN-LAST:event_weigh_kgKeyReleased

    private void percentage5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage5KeyReleased
        // TODO add your handling code here:
        if(use_func.check_this_textbox(percentage5))
            use_func.update_kg_prep(percentage5.getText(), weigh_kg3.getText(), kg_5);
    }//GEN-LAST:event_percentage5KeyReleased

    private void percentage6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage6KeyReleased
        // TODO add your handling code here:
        if(use_func.check_this_textbox(percentage6))
            use_func.update_kg_prep(percentage6.getText(), weigh_kg3.getText(), kg_6);
    }//GEN-LAST:event_percentage6KeyReleased

    private void percentage7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage7KeyReleased
        // TODO add your handling code here:
        if(use_func.check_this_textbox(percentage7))
            use_func.update_kg_prep(percentage7.getText(), weigh_kg3.getText(), kg_7);
    }//GEN-LAST:event_percentage7KeyReleased

    private void weigh_kg3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_weigh_kg3KeyReleased
        // TODO add your handling code here:
        if(use_func.check_this_textbox(weigh_kg3))
        {        
            use_func.update_kg_prep(percentage5.getText(), weigh_kg3.getText(), kg_5);
            use_func.update_kg_prep(percentage6.getText(), weigh_kg3.getText(), kg_6);
            use_func.update_kg_prep(percentage7.getText(), weigh_kg3.getText(), kg_7);
        }
    }//GEN-LAST:event_weigh_kg3KeyReleased

    private void percentage9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage9KeyReleased
        // TODO add your handling code here:
        if(use_func.check_this_textbox(percentage9))
            use_func.update_kg_prep(percentage9.getText(), weigh_kg4.getText(), kg_9);
    }//GEN-LAST:event_percentage9KeyReleased

    private void percentage10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage10KeyReleased
        // TODO add your handling code here:
        if(use_func.check_this_textbox(percentage10))
            use_func.update_kg_prep(percentage10.getText(), weigh_kg4.getText(), kg_10);
    }//GEN-LAST:event_percentage10KeyReleased

    private void percentage11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage11KeyReleased
        // TODO add your handling code here:
        if(use_func.check_this_textbox(percentage11))
            use_func.update_kg_prep(percentage11.getText(), weigh_kg4.getText(), kg_11);
    }//GEN-LAST:event_percentage11KeyReleased

    private void weigh_kg4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_weigh_kg4KeyReleased
        // TODO add your handling code here:
        if(use_func.check_this_textbox(weigh_kg4))
        {
            use_func.update_kg_prep(percentage9.getText(), weigh_kg4.getText(), kg_9);
            use_func.update_kg_prep(percentage10.getText(), weigh_kg4.getText(), kg_10);
            use_func.update_kg_prep(percentage11.getText(), weigh_kg4.getText(), kg_11);
        }
        
    }//GEN-LAST:event_weigh_kg4KeyReleased

    private void percentage13KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage13KeyReleased
        // TODO add your handling code here:
        if(use_func.check_this_textbox(percentage13))
            use_func.update_kg_prep(percentage13.getText(), weigh_kg5.getText(), kg_13);
    }//GEN-LAST:event_percentage13KeyReleased

    private void percentage14KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage14KeyReleased
        // TODO add your handling code here:
        if(use_func.check_this_textbox(percentage14)) 
            use_func.update_kg_prep(percentage14.getText(), weigh_kg5.getText(), kg_14);
    }//GEN-LAST:event_percentage14KeyReleased

    private void percentage15KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage15KeyReleased
        // TODO add your handling code here:
        if(use_func.check_this_textbox(percentage15))
            use_func.update_kg_prep(percentage15.getText(), weigh_kg5.getText(), kg_15);
    }//GEN-LAST:event_percentage15KeyReleased

    private void weigh_kg5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_weigh_kg5KeyReleased
        // TODO add your handling code here:
        if(use_func.check_this_textbox(weigh_kg5)){
            use_func.update_kg_prep(percentage13.getText(), weigh_kg5.getText(), kg_13);
            use_func.update_kg_prep(percentage14.getText(), weigh_kg5.getText(), kg_14);
            use_func.update_kg_prep(percentage15.getText(), weigh_kg5.getText(), kg_15);
        }
    }//GEN-LAST:event_weigh_kg5KeyReleased

    private void percentage17KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage17KeyReleased
        // TODO add your handling code here:
        if(use_func.check_this_textbox(percentage17))
            use_func.update_kg_prep(percentage17.getText(), weigh_kg6.getText(), kg_17);
    }//GEN-LAST:event_percentage17KeyReleased

    private void percentage18KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage18KeyReleased
        // TODO add your handling code here:
        if(use_func.check_this_textbox(percentage18))
            use_func.update_kg_prep(percentage18.getText(), weigh_kg6.getText(), kg_18);
    }//GEN-LAST:event_percentage18KeyReleased

    private void percentage19KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage19KeyReleased
        // TODO add your handling code here:
        if(use_func.check_this_textbox(percentage19))
            use_func.update_kg_prep(percentage19.getText(), weigh_kg6.getText(), kg_19);
    }//GEN-LAST:event_percentage19KeyReleased

    private void weigh_kg6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_weigh_kg6KeyReleased
        // TODO add your handling code here:
        if(use_func.check_this_textbox(weigh_kg6))
        {
            use_func.update_kg_prep(percentage17.getText(), weigh_kg6.getText(), kg_17);
            use_func.update_kg_prep(percentage18.getText(), weigh_kg6.getText(), kg_18);
            use_func.update_kg_prep(percentage19.getText(), weigh_kg6.getText(), kg_19);
        }                
        
    }//GEN-LAST:event_weigh_kg6KeyReleased

    private void percentage21KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage21KeyReleased
        // TODO add your handling code here:
        if(use_func.check_this_textbox(percentage21)){
            use_func.update_kg_prep(percentage21.getText(), weigh_kg7.getText(), kg_21);
        }
    }//GEN-LAST:event_percentage21KeyReleased

    private void percentage22KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage22KeyReleased
        // TODO add your handling code here:
        if(use_func.check_this_textbox(percentage22))
            use_func.update_kg_prep(percentage22.getText(), weigh_kg7.getText(), kg_22);
    }//GEN-LAST:event_percentage22KeyReleased

    private void percentage23KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage23KeyReleased
        // TODO add your handling code here:
        if(use_func.check_this_textbox(percentage23))
            use_func.update_kg_prep(percentage23.getText(), weigh_kg7.getText(), kg_23);
    }//GEN-LAST:event_percentage23KeyReleased

    private void weigh_kg7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_weigh_kg7KeyReleased
        // TODO add your handling code here:
        if(use_func.check_this_textbox(weigh_kg7)){
            use_func.update_kg_prep(percentage21.getText(), weigh_kg7.getText(), kg_21);
            use_func.update_kg_prep(percentage22.getText(), weigh_kg7.getText(), kg_22);
            use_func.update_kg_prep(percentage23.getText(), weigh_kg7.getText(), kg_23);
        }
    }//GEN-LAST:event_weigh_kg7KeyReleased

    private void percentage24KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage24KeyReleased
        // TODO add your handling code here:
        if(use_func.check_this_textbox(percentage24))
        {
            use_func.update_kg_prep(percentage24.getText(), weigh_kg8.getText(), kg_24);
        }
    }//GEN-LAST:event_percentage24KeyReleased

    private void weigh_kg8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_weigh_kg8KeyReleased
        // TODO add your handling code here:
        if(use_func.check_this_textbox(weigh_kg8))
        {        
            use_func.update_kg_prep(percentage24.getText(), weigh_kg8.getText(), kg_24);
            use_func.update_kg_prep(percentage25.getText(), weigh_kg8.getText(), kg_25);
            use_func.update_kg_prep(percentage26.getText(), weigh_kg8.getText(), kg_26);
        }
    }//GEN-LAST:event_weigh_kg8KeyReleased

    private void percentage25KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage25KeyReleased
        // TODO add your handling code here:
        if(use_func.check_this_textbox(percentage25))
            use_func.update_kg_prep(percentage25.getText(), weigh_kg8.getText(), kg_25);
    }//GEN-LAST:event_percentage25KeyReleased

    private void percentage26KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage26KeyReleased
        // TODO add your handling code here:
        if(use_func.check_this_textbox(percentage26))
            use_func.update_kg_prep(percentage26.getText(), weigh_kg8.getText(), kg_26);
    }//GEN-LAST:event_percentage26KeyReleased

    private void coverage8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_coverage8KeyReleased
        // TODO add your handling code here:
        if(use_func.check_this_textbox(coverage8)){
            compute_kg(weigh_kg8, coverage8);
            use_func.update_kg_prep(percentage24.getText(), weigh_kg8.getText(), kg_24);
            use_func.update_kg_prep(percentage25.getText(), weigh_kg8.getText(), kg_25);
            use_func.update_kg_prep(percentage26.getText(), weigh_kg8.getText(), kg_26);
        }
    }//GEN-LAST:event_coverage8KeyReleased
    
    private void button_include_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_include_customerActionPerformed
        // TODO add your handling code here:
        String job_order_text = this.job_ord_label.getText() + this.text_job_order.getText();
        
        if(this_list.check_if_job_is_good(job_order_text) 
                && this_list.check_customer_if_is_in_database_and_has_text(customer_name_text.getText())
                && this_list.check_if_quantity_is_good(quantity.getText()))
        {
            include();
            quantity.setText("");
            customer_name_text.setText("");
            text_job_order.setText("");
            
            this.quantity_total.setText(Integer.toString(this_list.get_quantity_total()));
            adjust_weights();
            if(edit_purchase.getText().equals("Cancel Edit"))
            {
                edit_purchase.setText("Edit Order");
                this.temporary_list.clear_all_items();
            }
        }
    }//GEN-LAST:event_button_include_customerActionPerformed

    private void button_remove_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_remove_customerActionPerformed
        // TODO add your handling code here:
        if(jList1.getSelectedIndex() != -1)
        {
        jList1.setModel(this_list.remove_this_item(this.jList1.getSelectedIndex()));
        quantity_total.setText(Integer.toString(this_list.get_quantity_total()));
        }
        //this.customer_list.remove(selected);
        //this.job_list.remove(selected);
        //this.quantity_list.remove(selected);
        //fill_list();
        
    }//GEN-LAST:event_button_remove_customerActionPerformed

    private void preview_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preview_butActionPerformed
        // TODO add your handling code here:
        production_recipe prod_recipe = this.get_design_details();
        Preview_form this_preview = new Preview_form(prod_recipe);
        this_preview.setVisible(true);
    }//GEN-LAST:event_preview_butActionPerformed

    private void cancel_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_butActionPerformed
        // TODO add your handling code here:
        int CloseorNoreply = JOptionPane.showConfirmDialog(null,"Cancel the order and Close this Window? "
                    + "(Yes to close this window) ", "Close this Window?", JOptionPane.YES_NO_OPTION);
            if(CloseorNoreply == JOptionPane.YES_OPTION)
            {
                this.dispose();
            }
    }//GEN-LAST:event_cancel_butActionPerformed

    private void quantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityKeyReleased
        // TODO add your handling code here:
        use_func.check_this_textbox(quantity);
    }//GEN-LAST:event_quantityKeyReleased

    private void pig11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig11ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
        this.pigment_button_check = 1;
    }//GEN-LAST:event_pig11ActionPerformed

    private void pig12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig12ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
        this.pigment_button_check = 2;
    }//GEN-LAST:event_pig12ActionPerformed

    private void pig13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig13ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
        this.pigment_button_check = 3;
    }//GEN-LAST:event_pig13ActionPerformed

    private void pig21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig21ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
        this.pigment_button_check = 4;
    }//GEN-LAST:event_pig21ActionPerformed

    private void pig22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig22ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
        this.pigment_button_check = 5;
    }//GEN-LAST:event_pig22ActionPerformed

    private void pig23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig23ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
        this.pigment_button_check = 6;
    }//GEN-LAST:event_pig23ActionPerformed

    private void pig31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig31ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
        this.pigment_button_check = 7;
    }//GEN-LAST:event_pig31ActionPerformed

    private void pig32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig32ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
        this.pigment_button_check = 8;
    }//GEN-LAST:event_pig32ActionPerformed

    private void pig33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig33ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
        this.pigment_button_check = 9;
    }//GEN-LAST:event_pig33ActionPerformed

    private void pig41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig41ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
        this.pigment_button_check = 10;
    }//GEN-LAST:event_pig41ActionPerformed

    private void pig42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig42ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
        this.pigment_button_check = 11;
    }//GEN-LAST:event_pig42ActionPerformed

    private void pig43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig43ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
        this.pigment_button_check = 12;
    }//GEN-LAST:event_pig43ActionPerformed

    private void pig51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig51ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
        this.pigment_button_check = 13;
    }//GEN-LAST:event_pig51ActionPerformed

    private void pig52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig52ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
        this.pigment_button_check = 14;
    }//GEN-LAST:event_pig52ActionPerformed

    private void pig53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig53ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
        this.pigment_button_check = 15;
    }//GEN-LAST:event_pig53ActionPerformed

    private void pig63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig63ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
        this.pigment_button_check = 18;
    }//GEN-LAST:event_pig63ActionPerformed

    private void pig61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig61ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
        this.pigment_button_check = 16;
    }//GEN-LAST:event_pig61ActionPerformed

    private void pig62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig62ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
        this.pigment_button_check = 17;
    }//GEN-LAST:event_pig62ActionPerformed

    private void pig_73ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig_73ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
        this.pigment_button_check = 21;
    }//GEN-LAST:event_pig_73ActionPerformed

    private void pig72ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig72ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
        this.pigment_button_check = 20;
    }//GEN-LAST:event_pig72ActionPerformed

    private void pig71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig71ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
        this.pigment_button_check = 19;
    }//GEN-LAST:event_pig71ActionPerformed

    private void show_add_pigment()
    {
        add_pigment_form add_pigment = new add_pigment_form();
        add_pigment.setVisible(true);
        this.pigment_screen_showed = true;
    }
    
    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        if(this.pigment_screen_showed)
        {
            pigment this_pigment = new pigment();
            if(this_pigment.get_last_pigment_id() != this.last_added_pigment_no)
            {
                this.registerSelectedItem();
                this.change_pigment_to_last_added_pigment();
            }
            pigment_screen_showed = false;
            last_added_pigment_no = this_pigment.get_last_pigment_id();
        }
        else if(this.fabric_style_screen_showed)
            this.use_func.check_and_add_new_fabrics(this.fab_style_comb);
        else if(this.binder_screen_showed){
            
            if(this.binder.getItemCount() != new colorway().get_all_binder().size())
            {    
                this.register_binder_selected_item();
                this.change_binder_to_last_added_binder();
            }
            binder_screen_showed = false;
        }
    }//GEN-LAST:event_formWindowGainedFocus

    
    private void edit_purchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_purchaseActionPerformed
        // TODO add your handling code here:
        
        if(edit_purchase.getText().equals("Edit Order"))
        {
            if(jList1.getSelectedIndex() != -1)
            {
                int selected = this.jList1.getSelectedIndex();
                //customer_combo_list.setSelectedItem(this_list.getCustomer_list().get(selected));
                //if(customer_combo_list.getSelectedItem().toString().equals(this_list.getCustomer_list().get(selected)))
                //{
                //   customer_combo_list.setVisible(true);
                //    this.customer_name_text.setVisible(false);
                //}
                //else
                //{
                //    customer_name_text.setVisible(true);
                //    customer_combo_list.setVisible(false);
                    customer_name_text.setText(this_list.getCustomer_list().get(selected).toString());
                //}
                
                int start_index = this_list.getJob_list().get(selected).toString().length() - 4;
                text_job_order.setText(this_list.getJob_list().get(selected).toString().substring(start_index));
                job_ord_label.setText(this_list.getJob_list().get(selected).toString().substring(0, start_index));
                quantity.setText(this_list.getQuantity_list().get(selected).toString());
                
                this.temporary_list.add_customer_job_quantity_in_list(
                        this_list.getCustomer_list().get(selected).toString(), 
                        this_list.getJob_list().get(selected).toString(), 
                        this_list.getQuantity_list().get(selected).toString());
                
                jList1.setModel(this_list.remove_this_item(selected));
                quantity_total.setText(Integer.toString(this_list.get_quantity_total()));
                this.adjust_weights();
                edit_purchase.setText("Cancel Edit");
            }
            else
                JOptionPane.showMessageDialog(null,"Please select an Item from the List");
        }
        else if(edit_purchase.getText().equals("Cancel Edit"))
        {
            this.this_list.add_customer_job_quantity_in_list(
                        temporary_list.getCustomer_list().get(0).toString(), 
                        temporary_list.getJob_list().get(0).toString(), 
                        temporary_list.getQuantity_list().get(0).toString());
            
            quantity.setText("");
            customer_name_text.setText("");
            text_job_order.setText("");
            temporary_list.clear_all_items();
            quantity_total.setText(Integer.toString(this_list.get_quantity_total())); 
            jList1.setModel(this_list.get_items_in_list());
            this.adjust_weights();
            edit_purchase.setText("Edit Order");
        }
        //this.customer_list.remove(selected);
        //this.job_list.remove(selected);
        //this.quantity_list.remove(selected);
        //fill_list();
    }//GEN-LAST:event_edit_purchaseActionPerformed

    private void clear_customers_textbox(){
        quantity.setText("");
        customer_name_text.setText("");
        text_job_order.setText("");
    }
    private void spinner_dateStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinner_dateStateChanged
        // TODO add your handling code here:
        if(!use_func.change_job_order_prefix(spinner_date).equals(job_ord_label.getText()))
        {
            job_ord_label.setText(use_func.change_job_order_prefix(spinner_date));
            if(!this_list.getJob_list().isEmpty())
            {
                ArrayList<String> job_list = this_list.getJob_list();
                for(int list_iterate= 0; list_iterate<job_list.size(); list_iterate++)
                {
                    job_list.set(list_iterate, job_ord_label.getText()+ job_list.get(list_iterate).substring(7, job_list.get(list_iterate).length()));
                }
                this_list.setJob_list(job_list);
                jList1.setModel(this_list.get_items_in_list());
            }
        }
    }//GEN-LAST:event_spinner_dateStateChanged

    private void check_this_panels_colorway_and_weight(JTextField colorway_textbox, JTextField weight_textbox, int tabbedpane_index)
    {
        if(colorway_textbox.getText().length() > 0 && weight_textbox.getText().length() == 0
         || colorway_textbox.getText().length() == 0 && weight_textbox.getText().length() > 0)
        {
            if(!jTabbedPane2.getForegroundAt(tabbedpane_index).equals(Color.red))
            {
                jTabbedPane2.setForegroundAt(tabbedpane_index, Color.red);
                add_order.setEnabled(false);
            }
        }
        else
        {
            if(jTabbedPane2.getForegroundAt(tabbedpane_index) == Color.red)
            {
                jTabbedPane2.setForegroundAt(tabbedpane_index, Color.BLACK);
                add_order.setEnabled(true);
            }
        }
    }
    
    
    private void jPanel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseExited
        // TODO add your handling code here:
        check_this_panels_colorway_and_weight(colorway_name, weigh_kg, 0);
    }//GEN-LAST:event_jPanel9MouseExited

    private void jPanel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseExited
        // TODO add your handling code here:
        check_this_panels_colorway_and_weight(colorway_name3, weigh_kg3, 1);
    }//GEN-LAST:event_jPanel4MouseExited

    private void jPanel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseExited
        // TODO add your handling code here:
        check_this_panels_colorway_and_weight(colorway_name4, weigh_kg4, 2);
    }//GEN-LAST:event_jPanel5MouseExited

    private void jPanel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseExited
        // TODO add your handling code here:
        check_this_panels_colorway_and_weight(colorway_name5, weigh_kg5, 3);
    }//GEN-LAST:event_jPanel6MouseExited

    private void jPanel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseExited
        // TODO add your handling code here:
        check_this_panels_colorway_and_weight(colorway_name6, weigh_kg6, 4);
    }//GEN-LAST:event_jPanel7MouseExited

    private void jPanel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseExited
        // TODO add your handling code here:
        check_this_panels_colorway_and_weight(colorway_name7, weigh_kg7, 5);
    }//GEN-LAST:event_jPanel8MouseExited

    private void jPanel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseExited
        // TODO add your handling code here:
        check_this_panels_colorway_and_weight(colorway_name8, weigh_kg8, 6);
    }//GEN-LAST:event_jPanel15MouseExited

    private void fab_style_combPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_fab_style_combPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        this_recipe.setFabric_style(this.fab_style_comb.getSelectedItem().toString());
        if(!current_style.equals(this.fab_style_comb.getSelectedItem().toString()))
        {
            compute_kg(weigh_kg, coverage1);
            compute_kg(weigh_kg3, coverage3);
            compute_kg(weigh_kg4, coverage4);
            compute_kg(weigh_kg5, coverage5);
            compute_kg(weigh_kg6, coverage6);
            compute_kg(weigh_kg7, coverage2); //6th Window
            compute_kg(weigh_kg8, coverage8); //7th Window
            current_style = fab_style_comb.getSelectedItem().toString();
        }
    }//GEN-LAST:event_fab_style_combPopupMenuWillBecomeInvisible

    private void quantity_totalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_quantity_totalPropertyChange
        // TODO add your handling code here:
        compute_kg_from_coverage(weigh_kg7);
    }//GEN-LAST:event_quantity_totalPropertyChange

    private void text_job_orderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_job_orderKeyReleased
        // TODO add your handling code here:
        
        if (use_func.check_this_textbox(text_job_order) && this.text_job_order.getText().length() == 4 )
        {
            String job_order_text = this.job_ord_label.getText() + this.text_job_order.getText();
            job_order new_job_order = new job_order(job_order_text);
            
            if(new_job_order.set_job_order_details_if_available())
            {
                this.customer_name_text.setText(new_job_order.getCustomer_name());
                //this.customer_name_text.setEditable(false);
                //this.customer_name_text.validate();
                Robot robot; 
                try 
                {
                    robot = new Robot();
                    customer_name_text.requestFocusInWindow();
                    robot.keyPress(KeyEvent.VK_ENTER); 
                    robot.keyRelease(KeyEvent.VK_ENTER);
                } catch (AWTException ex) {
                    Logger.getLogger(Add_new_design.class.getName()).log(Level.SEVERE, null, ex);
                }
                //this.customer_name_text.setEditable(false);
                //    quantity.requestFocusInWindow();
                
            }
        //    else
        //        this.customer_name_text.setEditable(true);
        }
        //else if(!customer_name_text.isEditable())
        //    this.customer_name_text.setEditable(true);
        
    }//GEN-LAST:event_text_job_orderKeyReleased

    private void add_fabricActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_fabricActionPerformed
        // TODO add your handling code here:
        fabric_style new_fab_window = new fabric_style();
        new_fab_window.setVisible(true);
        this.fabric_style_screen_showed = true;
    }//GEN-LAST:event_add_fabricActionPerformed

    private void bind_add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bind_add1ActionPerformed
        // TODO add your handling code here:
        show_binder_form();
        this.binder_button_check = 1;
    }//GEN-LAST:event_bind_add1ActionPerformed

    private void bind_add2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bind_add2ActionPerformed
        // TODO add your handling code here:
        show_binder_form();
        this.binder_button_check = 2;
    }//GEN-LAST:event_bind_add2ActionPerformed

    private void bind_add3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bind_add3ActionPerformed
        // TODO add your handling code here:
        show_binder_form();
        this.binder_button_check = 3;
    }//GEN-LAST:event_bind_add3ActionPerformed

    private void bind_add4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bind_add4ActionPerformed
        // TODO add your handling code here:
        show_binder_form();
        this.binder_button_check = 4;
    }//GEN-LAST:event_bind_add4ActionPerformed

    private void bind_add5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bind_add5ActionPerformed
        // TODO add your handling code here:
        show_binder_form();
        this.binder_button_check = 5;
    }//GEN-LAST:event_bind_add5ActionPerformed

    private void bind_add6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bind_add6ActionPerformed
        // TODO add your handling code here:
        show_binder_form();
        this.binder_button_check = 6;
    }//GEN-LAST:event_bind_add6ActionPerformed

    private void bind_add7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bind_add7ActionPerformed
        // TODO add your handling code here:
        show_binder_form();
        this.binder_button_check = 7;
    }//GEN-LAST:event_bind_add7ActionPerformed

    private void show_binder_form()
    {
        add_binder_form new_binder = new add_binder_form();
        new_binder.setVisible(true);
        this.binder_screen_showed = true;
    }
    private void weigh_kgPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_weigh_kgPropertyChange
        // TODO add your handling code here:
        if(use_func.check_this_textbox(weigh_kg))
        {        
            use_func.update_kg_prep(percentage1.getText(), weigh_kg.getText(), kg_1);
            use_func.update_kg_prep(percentage2.getText(), weigh_kg.getText(), kg_2);
            use_func.update_kg_prep(percentage3.getText(), weigh_kg.getText(), kg_3);
        }
    }//GEN-LAST:event_weigh_kgPropertyChange

    private void compute_kg_from_coverage(JTextField weigh_kg)
    {
        if(!use_func.checkText2(weigh_kg.getText()) && quantity_total.getText().length()>0 )
        {
            //System.out.println("Hello");
            float kg_conversion = Float.parseFloat(weigh_kg.getText());
            float coverage_computation = use_func.compute_this_coverage(kg_conversion, fab_style_comb.getSelectedItem().toString(), quantity_total.getText());
            float the_computation = use_func.compute_this_kg(coverage_computation, fab_style_comb.getSelectedItem().toString(), quantity_total.getText());
            weigh_kg.setText(String.format("%.0f", the_computation));
        }
    }
    private void compute_kg(JTextField weigh_kg, JTextField coverage)
    {
        if(!use_func.checkText2(coverage.getText()) && quantity_total.getText().length()>0)
        {
            float cov_conversion = Float.parseFloat(coverage.getText());
            float this_computation = use_func.compute_this_kg(cov_conversion, fab_style_comb.getSelectedItem().toString(), quantity_total.getText());
            weigh_kg.setText(String.format("%.0f", this_computation));
        }
    }
    /**
     * Checks if text can be parsed to float or int
     * @param this_text
     * @return true if text contains any character not 0-9
     */
    
    
    
    private void addBlankSpace()
    {
            name1.addItem("");
            name2.addItem("");
            name3.addItem("");
            name5.addItem("");
            name6.addItem("");
            name7.addItem("");
            name9.addItem("");
            name10.addItem("");
            name11.addItem("");
            name13.addItem("");
            name14.addItem("");
            name15.addItem("");
            name17.addItem("");   
            name18.addItem("");   
            name19.addItem("");   
            name21.addItem("");   
            name22.addItem("");   
            name23.addItem("");   
            name24.addItem("");   
            name25.addItem("");   
            name26.addItem("");   
    }
    private void register_binder_selected_item()
    {
        String[] all_binder = new String[7];
        all_binder[0] = binder.getSelectedItem().toString();
        all_binder[1] = binder2.getSelectedItem().toString();
        all_binder[2] = binder3.getSelectedItem().toString();
        all_binder[3] = binder4.getSelectedItem().toString();
        all_binder[4] = binder5.getSelectedItem().toString();
        all_binder[5] = binder6.getSelectedItem().toString();
        all_binder[6] = binder7.getSelectedItem().toString();
        
        this.remove_and_add_all_binders();
        
        binder.setSelectedItem(all_binder[0]);
        binder2.setSelectedItem(all_binder[1]);
        binder3.setSelectedItem(all_binder[2]);
        binder4.setSelectedItem(all_binder[3]);
        binder5.setSelectedItem(all_binder[4]);
        binder6.setSelectedItem(all_binder[5]);
        binder7.setSelectedItem(all_binder[6]);
    }
    private void registerSelectedItem()
    {
        String[] allitems = new String[21];
        allitems[0] = name1.getSelectedItem().toString();
        allitems[1] = name2.getSelectedItem().toString();
        allitems[2] = name3.getSelectedItem().toString();
        allitems[3] = name5.getSelectedItem().toString();
        allitems[4] = name6.getSelectedItem().toString();
        allitems[5] = name7.getSelectedItem().toString();
        allitems[6] = name9.getSelectedItem().toString();
        allitems[7] = name10.getSelectedItem().toString();
        allitems[8] = name11.getSelectedItem().toString();
        allitems[9] = name13.getSelectedItem().toString();
        allitems[10] = name14.getSelectedItem().toString();
        allitems[11] = name15.getSelectedItem().toString();
        allitems[12] = name17.getSelectedItem().toString();
        allitems[13] = name18.getSelectedItem().toString();
        allitems[14] = name19.getSelectedItem().toString();
        allitems[15] = name21.getSelectedItem().toString();
        allitems[16] = name22.getSelectedItem().toString();
        allitems[17] = name23.getSelectedItem().toString();
        allitems[18] = name24.getSelectedItem().toString();
        allitems[19] = name25.getSelectedItem().toString();
        allitems[20] = name26.getSelectedItem().toString();
        
        this.clearItem();
        this.addListItems();
        
        name1.setSelectedItem(allitems[0]);
        name2.setSelectedItem(allitems[1]);
        name3.setSelectedItem(allitems[2]);
        name5.setSelectedItem(allitems[3]);
        name6.setSelectedItem(allitems[4]);
        name7.setSelectedItem(allitems[5]);
        name9.setSelectedItem(allitems[6]);
        name10.setSelectedItem(allitems[7]);
        name11.setSelectedItem(allitems[8]);
        name13.setSelectedItem(allitems[9]);
        name14.setSelectedItem(allitems[10]);
        name15.setSelectedItem(allitems[11]);
        name17.setSelectedItem(allitems[12]);
        name18.setSelectedItem(allitems[13]);
        name19.setSelectedItem(allitems[14]);
        name21.setSelectedItem(allitems[15]);
        name22.setSelectedItem(allitems[16]);
        name23.setSelectedItem(allitems[17]);
        name24.setSelectedItem(allitems[18]);
        name25.setSelectedItem(allitems[19]);
        name26.setSelectedItem(allitems[20]);
    }
    
    private void clearItem()
    {
            name1.removeAllItems();
            name2.removeAllItems();
            name3.removeAllItems();
            name5.removeAllItems();
            name6.removeAllItems();
            name7.removeAllItems();
            name9.removeAllItems();
            name10.removeAllItems();
            name11.removeAllItems();
            name13.removeAllItems();
            name14.removeAllItems();
            name15.removeAllItems();
            name17.removeAllItems();   
            name18.removeAllItems();   
            name19.removeAllItems();  
            name21.removeAllItems();
            name22.removeAllItems();
            name23.removeAllItems();
            name24.removeAllItems();
            name25.removeAllItems();
            name26.removeAllItems();
    }
    
    public void addListItems()
    {
        colortextile_class.pigment list_pigment = new colortextile_class.pigment();
        ArrayList<String> pigment_list = list_pigment.get_all_pigment_name();
        addBlankSpace();
        
        for (String pigment_list1 : pigment_list) {
            name1.addItem(pigment_list1);
            name2.addItem(pigment_list1);
            name3.addItem(pigment_list1);
            name5.addItem(pigment_list1);
            name6.addItem(pigment_list1);
            name7.addItem(pigment_list1);
            name9.addItem(pigment_list1);
            name10.addItem(pigment_list1);
            name11.addItem(pigment_list1);
            name13.addItem(pigment_list1);
            name14.addItem(pigment_list1);
            name15.addItem(pigment_list1);
            name17.addItem(pigment_list1);
            name18.addItem(pigment_list1);
            name19.addItem(pigment_list1);
            name21.addItem(pigment_list1);
            name22.addItem(pigment_list1);
            name23.addItem(pigment_list1);
            name24.addItem(pigment_list1);
            name25.addItem(pigment_list1);
            name26.addItem(pigment_list1);
        }
        this.last_added_pigment_no = list_pigment.get_last_pigment_id();
        setJobString();   
    }
    
    private void change_binder_to_last_added_binder()
    {
        float last_added_binder = new colorway().get_last_binder();
        switch(binder_button_check)
        {
            case 1:
                binder.setSelectedItem(last_added_binder);
                break;
            case 2:
                binder2.setSelectedItem(last_added_binder);
                break;
            case 3:
                binder3.setSelectedItem(last_added_binder);
                break;
            case 4:
                binder4.setSelectedItem(last_added_binder);
                break;
            case 5:
                binder5.setSelectedItem(last_added_binder);
                break;
            case 6:
                binder6.setSelectedItem(last_added_binder);
                break;
            case 7:
                binder7.setSelectedItem(last_added_binder);
                break;
        }
    }
    
    private void change_pigment_to_last_added_pigment()
    {
        pigment added_pigment = new pigment();
        added_pigment.set_name_and_id_from_last_added_pigment();
        switch(pigment_button_check)
        {
            case 1:
                name1.setSelectedItem(added_pigment.getPigment_name());
                break;
            case 2:
                name2.setSelectedItem(added_pigment.getPigment_name());
                break;
            case 3:
                name3.setSelectedItem(added_pigment.getPigment_name());
                break;
            case 4:
                name5.setSelectedItem(added_pigment.getPigment_name());
                break;
            case 5:
                name6.setSelectedItem(added_pigment.getPigment_name());
                break;
            case 6:
                name7.setSelectedItem(added_pigment.getPigment_name());
                break;
            case 7:
                name9.setSelectedItem(added_pigment.getPigment_name());
                break;
            case 8:
                name10.setSelectedItem(added_pigment.getPigment_name());
                break;
            case 9:
                name11.setSelectedItem(added_pigment.getPigment_name());
                break;
            case 10:
                name13.setSelectedItem(added_pigment.getPigment_name());
                break;
            case 11:
                name14.setSelectedItem(added_pigment.getPigment_name());
                break;
            case 12:
                name15.setSelectedItem(added_pigment.getPigment_name());
                break;
            case 13:
                name17.setSelectedItem(added_pigment.getPigment_name());
                break;
            case 14:
                name18.setSelectedItem(added_pigment.getPigment_name());
                break;
            case 15:
                name19.setSelectedItem(added_pigment.getPigment_name());
                break;
            case 16:
                name21.setSelectedItem(added_pigment.getPigment_name());
                break;
            case 17:
                name22.setSelectedItem(added_pigment.getPigment_name());
                break;
            case 18:
                name23.setSelectedItem(added_pigment.getPigment_name());
                break;
            case 19:
                name24.setSelectedItem(added_pigment.getPigment_name());
                break;
            case 20:
                name25.setSelectedItem(added_pigment.getPigment_name());
                break;
            case 21:
                name26.setSelectedItem(added_pigment.getPigment_name());
                break;  
        }
        
    }
    
    public void setJobString()
    {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        String Year = Integer.toString(cal.get(Calendar.YEAR));
        
        int Month = cal.get(Calendar.MONTH);
        String Fabric = fab_style_comb.getSelectedItem().toString();
        job_ord_label.setText(Year.substring(2, 4) +"P-" + Month +"-");
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
            java.util.logging.Logger.getLogger(Add_new_design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_new_design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_new_design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_new_design.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Add_new_design().setVisible(true);
            }
        });
    }
    public void unused(){
    /*
    public void fill_info(int design_id){
        
        try {
            
            //design DB
            Design_with_colorway design_info = new Design_with_colorway();
            design_info.setDesign_code(design_id);
            design_info.setDesign_details_from_des_code();
            design_info.set_all_colorway_from_design_code();
            this.set_all_textbox_colorways(design_info.getAll_colorways());
            // testing comit ----------------------------------------------------------------------------------------------------------------------
            // get design result set from design code
            ResultSet rs_design = design_info.search_design();  
            //design result set move to first
            rs_design.first(); 
            this.design_name.setText(rs_design.getString("design_name"));
            //design colorway
        this.design_color.setText(rs_design.getString("color_name"));
            //fabric style
        this.fab_style_comb.addItem(rs_design.getString("fabric_style"));  this.fab_style_comb.setSelectedItem(rs_design.getString("fabric_style"));
         
            //colorway DB
            colorway color = new colorway();
            color.setDesign_code(design_id);
            color.setId_colorway(-1);
            // get colorway result set form design code
            ResultSet rs_colorway = color.Search_colorway();
            
            Colorway_and_pigment screen = new Colorway_and_pigment();
            
            //fill textboxes  +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
            //design name
            ResultSet rs_colorway_screen;
            while (rs_colorway.next()){
                int xyz = 0;
                System.out.println(xyz);
                xyz++;
            }
            // 11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111
            if(rs_colorway.first()){
            screen.setId_colorway(rs_colorway.getInt("id_colorway"));
            screen.setId_color_screen(-1);
            rs_colorway_screen = screen.Search_colorway_screen_connect();
            
            
            //Screen Name
            this.colorway_name.setText(rs_colorway.getString("colorway_name"));
            //Kilograms/KGS
            this.weigh_kg.setText(rs_colorway.getString("weight_kg"));
            //Coverage
            //this.coverage1.setText("");
            //binder
            this.binder.addItem(rs_colorway.getString("binder")); this.binder.setSelectedItem(rs_colorway.getString("binder"));
            //Pigment Name                     Percentage                        KG/Prep
            if(rs_colorway_screen.first()){
            this.name1.addItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no"))); this.name1.setSelectedItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no")));      this.percentage1.setText(rs_colorway_screen.getString("pigment_percentage"));
            }
            if(rs_colorway_screen.next()){
            this.name2.addItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no"))); this.name2.setSelectedItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no")));      this.percentage2.setText(rs_colorway_screen.getString("pigment_percentage"));
            }
            if(rs_colorway_screen.next()){
            this.name3.addItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no"))); this.name3.setSelectedItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no")));      this.percentage3.setText(rs_colorway_screen.getString("pigment_percentage"));
            }
            
            }
            //222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222
            if(rs_colorway.next()){
                screen.setId_colorway(rs_colorway.getInt("id_colorway"));
            screen.setId_color_screen(-1);
            rs_colorway_screen = screen.Search_colorway_screen_connect();
            
            //Screen Name
            this.colorway_name3.setText(rs_colorway.getString("colorway_name"));
            //Kilograms/KGS
            this.weigh_kg3.setText(rs_colorway.getString("weight_kg"));
            //Coverage
            //this.coverage3.setText("");
            this.binder3.addItem(rs_colorway.getString("binder")); this.binder3.setSelectedItem(rs_colorway.getString("binder"));
            //
            //Pigment Name    Percentage     KG/Prep
            if(rs_colorway_screen.first()){
            this.name5.addItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no"))); this.name5.setSelectedItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no")));      this.percentage5.setText(rs_colorway_screen.getString("pigment_percentage"));
            }
            if(rs_colorway_screen.next()){
            this.name6.addItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no"))); this.name6.setSelectedItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no")));      this.percentage6.setText(rs_colorway_screen.getString("pigment_percentage"));
            }
            if(rs_colorway_screen.next()){
            this.name7.addItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no"))); this.name7.setSelectedItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no")));      this.percentage7.setText(rs_colorway_screen.getString("pigment_percentage"));
            }
            
            
            } else { System.out.println("2 no "); }
            //333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333
            if(rs_colorway.next()){
                screen.setId_colorway(rs_colorway.getInt("id_colorway"));
            screen.setId_color_screen(-1);
            rs_colorway_screen = screen.Search_colorway_screen_connect();
            //Screen Name
            this.colorway_name4.setText(rs_colorway.getString("colorway_name"));
            //Kilograms/KGS
            this.weigh_kg4.setText(rs_colorway.getString("weight_kg"));
            //Coverage
            //this.coverage4.setText("");
            this.binder3.addItem(rs_colorway.getString("binder")); this.binder3.setSelectedItem(rs_colorway.getString("binder"));
            //
            //Pigment Name    Percentage     KG/Prep
            if(rs_colorway_screen.first()){
            this.name9.addItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no"))); this.name9.setSelectedItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no")));      this.percentage9.setText(rs_colorway_screen.getString("pigment_percentage"));
            }
            if(rs_colorway_screen.next()){
            this.name10.addItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no"))); this.name10.setSelectedItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no")));      this.percentage10.setText(rs_colorway_screen.getString("pigment_percentage"));
            }
            if(rs_colorway_screen.next()){
            this.name11.addItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no"))); this.name11.setSelectedItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no")));      this.percentage11.setText(rs_colorway_screen.getString("pigment_percentage"));
            }
            
            }
            
            //444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444
            if(rs_colorway.next()){
                
                screen.setId_colorway(rs_colorway.getInt("id_colorway"));
            screen.setId_color_screen(-1);
            rs_colorway_screen = screen.Search_colorway_screen_connect();
            
            //Screen Name
            this.colorway_name5.setText(rs_colorway.getString("colorway_name"));
            //Kilograms/KGS
            this.weigh_kg5.setText(rs_colorway.getString("weight_kg"));
            //Coverage
            //this.coverage5.setText("");
            this.binder5.addItem(rs_colorway.getString("binder")); this.binder5.setSelectedItem(rs_colorway.getString("binder"));
            //
            //Pigment Name    Percentage     KG/Prep
            if(rs_colorway_screen.first()){
            this.name13.addItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no"))); this.name13.setSelectedItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no")));      this.percentage13.setText(rs_colorway_screen.getString("pigment_percentage"));
            }
            if(rs_colorway_screen.next()){
            this.name14.addItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no"))); this.name14.setSelectedItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no")));      this.percentage14.setText(rs_colorway_screen.getString("pigment_percentage"));
            }
            if(rs_colorway_screen.next()){
            this.name15.addItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no"))); this.name15.setSelectedItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no")));      this.percentage15.setText(rs_colorway_screen.getString("pigment_percentage"));
            }
            
            }
            //5555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555
            if(rs_colorway.next()){
                
                screen.setId_colorway(rs_colorway.getInt("id_colorway"));
            screen.setId_color_screen(-1);
            rs_colorway_screen = screen.Search_colorway_screen_connect();
            
            //Screen Name
            this.colorway_name6.setText(rs_colorway.getString("colorway_name"));
            //Kilograms/KGS
            this.weigh_kg6.setText(rs_colorway.getString("weight_kg"));
            //Coverage
            //this.coverage6.setText("");
            this.binder6.addItem(rs_colorway.getString("binder")); this.binder6.setSelectedItem(rs_colorway.getString("binder"));
            //
            //Pigment Name    Percentage     KG/Prep
            if(rs_colorway_screen.first()){
            this.name17.addItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no"))); this.name17.setSelectedItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no")));      this.percentage17.setText(rs_colorway_screen.getString("pigment_percentage"));
            }
            if(rs_colorway_screen.next()){
            this.name18.addItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no"))); this.name18.setSelectedItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no")));      this.percentage18.setText(rs_colorway_screen.getString("pigment_percentage"));
            }
            if(rs_colorway_screen.next()){
            this.name19.addItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no"))); this.name19.setSelectedItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no")));      this.percentage19.setText(rs_colorway_screen.getString("pigment_percentage"));
            }
            
            }
            //66666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666
            if(rs_colorway.next()){
                
                screen.setId_colorway(rs_colorway.getInt("id_colorway"));
            screen.setId_color_screen(-1);
            rs_colorway_screen = screen.Search_colorway_screen_connect();
            
            //Screen Name
            this.colorway_name7.setText(rs_colorway.getString("colorway_name"));
            //Kilograms/KGS
            this.weigh_kg7.setText(rs_colorway.getString("weight_kg"));
            //Coverage
           //this.coverage2.setText("");
            this.binder7.addItem(rs_colorway.getString("binder")); this.binder7.setSelectedItem(rs_colorway.getString("binder"));
            //
            //Pigment Name    Percentage     KG/Prep
            if(rs_colorway_screen.first()){
            this.name21.addItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no"))); this.name21.setSelectedItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no")));      this.percentage21.setText(rs_colorway_screen.getString("pigment_percentage"));
            }
            if(rs_colorway_screen.next()){
            this.name22.addItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no"))); this.name22.setSelectedItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no")));      this.percentage22.setText(rs_colorway_screen.getString("pigment_percentage"));
            }
            if(rs_colorway_screen.next()){
            this.name23.addItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no"))); this.name23.setSelectedItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no")));      this.percentage23.setText(rs_colorway_screen.getString("pigment_percentage"));
            }
            
            }
            //77777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777777
            if(rs_colorway.next()){
                
                screen.setId_colorway(rs_colorway.getInt("id_colorway"));
            screen.setId_color_screen(-1);
            rs_colorway_screen = screen.Search_colorway_screen_connect();
            
            //Screen Name
            this.colorway_name8.setText(rs_colorway.getString("colorway_name"));
            //Kilograms/KGS
            this.weigh_kg8.setText(rs_colorway.getString("weight_kg"));
            //Coverage
            //this.coverage7.setText("");
            this.binder8.addItem(rs_colorway.getString("binder")); this.binder8.setSelectedItem(rs_colorway.getString("binder"));
            //
            //Pigment Name    Percentage     KG/Prep
            if(rs_colorway_screen.first()){
            this.name24.addItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no"))); this.name24.setSelectedItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no")));      this.percentage24.setText(rs_colorway_screen.getString("pigment_percentage"));
            }
            if(rs_colorway_screen.next()){
            this.name25.addItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no"))); this.name25.setSelectedItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no")));      this.percentage25.setText(rs_colorway_screen.getString("pigment_percentage"));
            }
            if(rs_colorway_screen.next()){
            this.name26.addItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no"))); this.name26.setSelectedItem(this.get_pigment_name(rs_colorway_screen.getInt("pigment_no")));      this.percentage26.setText(rs_colorway_screen.getString("pigment_percentage"));
            }
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(Add_new_design.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    */
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_fabric;
    private javax.swing.JButton add_order;
    private javax.swing.JButton bind_add1;
    private javax.swing.JButton bind_add2;
    private javax.swing.JButton bind_add3;
    private javax.swing.JButton bind_add4;
    private javax.swing.JButton bind_add5;
    private javax.swing.JButton bind_add6;
    private javax.swing.JButton bind_add7;
    private javax.swing.JComboBox binder;
    private javax.swing.JComboBox binder2;
    private javax.swing.JComboBox binder3;
    private javax.swing.JComboBox binder4;
    private javax.swing.JComboBox binder5;
    private javax.swing.JComboBox binder6;
    private javax.swing.JComboBox binder7;
    private javax.swing.JButton button_include_customer;
    private javax.swing.JButton button_remove_customer;
    private javax.swing.JButton cancel_but;
    private javax.swing.JTextField colorway_name;
    private javax.swing.JTextField colorway_name3;
    private javax.swing.JTextField colorway_name4;
    private javax.swing.JTextField colorway_name5;
    private javax.swing.JTextField colorway_name6;
    private javax.swing.JTextField colorway_name7;
    private javax.swing.JTextField colorway_name8;
    private javax.swing.JTextField coverage1;
    private javax.swing.JTextField coverage2;
    private javax.swing.JTextField coverage3;
    private javax.swing.JTextField coverage4;
    private javax.swing.JTextField coverage5;
    private javax.swing.JTextField coverage6;
    private javax.swing.JTextField coverage8;
    private javax.swing.JComboBox customer_combo_list;
    private javax.swing.JTextField customer_name_text;
    private javax.swing.JTextField design_color;
    private javax.swing.JTextField design_name;
    private javax.swing.JButton edit_purchase;
    private javax.swing.JComboBox fab_style_comb;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel job_ord_label;
    private javax.swing.JTextField kg_1;
    private javax.swing.JTextField kg_10;
    private javax.swing.JTextField kg_11;
    private javax.swing.JTextField kg_13;
    private javax.swing.JTextField kg_14;
    private javax.swing.JTextField kg_15;
    private javax.swing.JTextField kg_17;
    private javax.swing.JTextField kg_18;
    private javax.swing.JTextField kg_19;
    private javax.swing.JTextField kg_2;
    private javax.swing.JTextField kg_21;
    private javax.swing.JTextField kg_22;
    private javax.swing.JTextField kg_23;
    private javax.swing.JTextField kg_24;
    private javax.swing.JTextField kg_25;
    private javax.swing.JTextField kg_26;
    private javax.swing.JTextField kg_3;
    private javax.swing.JTextField kg_5;
    private javax.swing.JTextField kg_6;
    private javax.swing.JTextField kg_7;
    private javax.swing.JTextField kg_9;
    private javax.swing.JComboBox name1;
    private javax.swing.JComboBox name10;
    private javax.swing.JComboBox name11;
    private javax.swing.JComboBox name13;
    private javax.swing.JComboBox name14;
    private javax.swing.JComboBox name15;
    private javax.swing.JComboBox name17;
    private javax.swing.JComboBox name18;
    private javax.swing.JComboBox name19;
    private javax.swing.JComboBox name2;
    private javax.swing.JComboBox name21;
    private javax.swing.JComboBox name22;
    private javax.swing.JComboBox name23;
    private javax.swing.JComboBox name24;
    private javax.swing.JComboBox name25;
    private javax.swing.JComboBox name26;
    private javax.swing.JComboBox name3;
    private javax.swing.JComboBox name5;
    private javax.swing.JComboBox name6;
    private javax.swing.JComboBox name7;
    private javax.swing.JComboBox name9;
    private javax.swing.JTextField percentage1;
    private javax.swing.JTextField percentage10;
    private javax.swing.JTextField percentage11;
    private javax.swing.JTextField percentage13;
    private javax.swing.JTextField percentage14;
    private javax.swing.JTextField percentage15;
    private javax.swing.JTextField percentage17;
    private javax.swing.JTextField percentage18;
    private javax.swing.JTextField percentage19;
    private javax.swing.JTextField percentage2;
    private javax.swing.JTextField percentage21;
    private javax.swing.JTextField percentage22;
    private javax.swing.JTextField percentage23;
    private javax.swing.JTextField percentage24;
    private javax.swing.JTextField percentage25;
    private javax.swing.JTextField percentage26;
    private javax.swing.JTextField percentage3;
    private javax.swing.JTextField percentage5;
    private javax.swing.JTextField percentage6;
    private javax.swing.JTextField percentage7;
    private javax.swing.JTextField percentage9;
    private javax.swing.JButton pig11;
    private javax.swing.JButton pig12;
    private javax.swing.JButton pig13;
    private javax.swing.JButton pig21;
    private javax.swing.JButton pig22;
    private javax.swing.JButton pig23;
    private javax.swing.JButton pig31;
    private javax.swing.JButton pig32;
    private javax.swing.JButton pig33;
    private javax.swing.JButton pig41;
    private javax.swing.JButton pig42;
    private javax.swing.JButton pig43;
    private javax.swing.JButton pig51;
    private javax.swing.JButton pig52;
    private javax.swing.JButton pig53;
    private javax.swing.JButton pig61;
    private javax.swing.JButton pig62;
    private javax.swing.JButton pig63;
    private javax.swing.JButton pig71;
    private javax.swing.JButton pig72;
    private javax.swing.JButton pig_73;
    private javax.swing.JButton preview_but;
    private javax.swing.JTextField quantity;
    private javax.swing.JTextField quantity_total;
    private javax.swing.JSpinner spinner_date;
    private javax.swing.JTextField text_job_order;
    private javax.swing.JTextField weigh_kg;
    private javax.swing.JTextField weigh_kg3;
    private javax.swing.JTextField weigh_kg4;
    private javax.swing.JTextField weigh_kg5;
    private javax.swing.JTextField weigh_kg6;
    private javax.swing.JTextField weigh_kg7;
    private javax.swing.JTextField weigh_kg8;
    // End of variables declaration//GEN-END:variables

    
}
