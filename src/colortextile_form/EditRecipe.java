/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package colortextile_form;
//import colortextile_class.deletedClass.screen_pigment;
import Database.DB_Manager;
import colortextile_class.*;
import com.github.sarxos.webcam.Webcam;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import com.github.sarxos.webcam.Webcam;
/**
 *
 * @author Eldridge
 */
public class EditRecipe extends javax.swing.JFrame {

    private int count_screen_1 = 0;
    private boolean web_cam_opened = false;
    private boolean pigment_screen_showed = false;
    private production_recipe prod_recipe  = new production_recipe();
    
    private Recipe_functions use_func = new Recipe_functions();
    private job_customer_quantity_list this_list = new job_customer_quantity_list();
    /**
     * Creates new form Add_new_design
     */
    public EditRecipe() {
        initComponents();
        initialize();
    }
    
    public EditRecipe(int purchase_order_id)
    {
        initComponents();
        initialize();
        this.set_purchase_details_from_id(purchase_order_id);
        this.set_design_details_from_first_purchase_order();
        this.set_design_and_colorway_textbox_details();
        this.set_purchase_details();
    }
    
    private void initialize()
    {
        addListItems();
        //Center the form
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        //int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x,0);
        
        fill_customer_list();
        this.customer_name_text.setVisible(false);
        this.fabric_style.setVisible(false);
        
        List<Webcam> webcam = Webcam.getWebcams();
        for(Webcam all_web : webcam)
        {
            web_cams.addItem(all_web.getName());
        }
    }
    
    private void set_purchase_details()
    {
        prod_recipe.set_job_order_list_using_design_code_and_purchase_id();
        prod_recipe.set_purchase_order_list_from_job_list();
        this.set_purchase_and_job_list_textbox();
    }
    
    private void set_purchase_details_from_id(int purchase_order_id)
    {
        // USING GLOBAL VARIABLE
        //production_recipe this_purchase = new production_recipe();
        purchase_order this_purchase = new purchase_order();
        //Set Details
        this_purchase.setId_purchase(purchase_order_id);
        this_purchase.set_this_Purchase_details_from_purchase_id();
        prod_recipe.add_purchase(this_purchase);
    }
    
    private void set_design_details_from_first_purchase_order()
    {
        if(prod_recipe.getAll_purchase().size() >0)
        {
            prod_recipe.setDesign_code(prod_recipe.getAll_purchase().get(0).getDesign_code());
            prod_recipe.setDesign_details_from_des_code();
            prod_recipe.set_all_colorway_from_design_code();
        }
    }
    
    private void set_purchase_and_job_list_textbox()
    {
        int list;
        if(prod_recipe.getAll_purchase().size() < prod_recipe.getJobs_for_this().size())
            list = prod_recipe.getAll_purchase().size();
        else
            list = prod_recipe.getJobs_for_this().size();
        
        if( list>0 )
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                spinner_date.setValue(sdf.parse(prod_recipe.getJobs_for_this().get(0).getDate()));
            } catch (ParseException ex) {
                Logger.getLogger(EditRecipe.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        for(int interval = 0; interval < list; interval++)
        {
            this_list.add_customer_job_quantity_in_list(
                    prod_recipe.getJobs_for_this().get(interval).getCustomer_name(), 
                    prod_recipe.getJobs_for_this().get(interval).getJob_id(), 
                    Integer.toString(prod_recipe.getAll_purchase().get(interval).getQuantity()));
        }
        this.jList1.setModel(this_list.get_items_in_list());
        quantity_total.setText(Integer.toString(this_list.get_quantity_total()));
    }
    
    public void set_design_and_colorway_textbox_details()
    {
        set_all_textbox_colorways(prod_recipe.getAll_colorways());
        
        //Set details to Text boxes
        design_name.setText(prod_recipe.getDesign_name());
        //design_code.setText(get_des_details.getDesign_code());
        fabric_style.setText(prod_recipe.getFabric_style());
        design_color.setText(prod_recipe.getColor_name());
    }
    
    private void set_all_textbox_colorways(List<Colorway_screen_link_functions> this_color_and_screen)
    {
        for(int x = 0 ; x<this_color_and_screen.size();x++)
        {
            List<Pigment_screen_and_colorway> current_screen = this_color_and_screen.get(x).getThis_screens();
            
            if(x == 0)
            {
                setTextValues_colorway(colorway_name2,weigh_kg8, binder8, this_color_and_screen.get(x));
                
                for(int temp_loop2 = 0; temp_loop2 < current_screen.size(); temp_loop2++ )
                {
                    if(temp_loop2 == 0)
                    {
                            setTextValues_screens(name1, percentage1, current_screen.get(temp_loop2));
                            update_kg_prep(percentage1.getText(), weigh_kg8.getText(), kg_1);
                    }
                    else if(temp_loop2 == 1)
                    {
                            setTextValues_screens(name2, percentage2, current_screen.get(temp_loop2));
                            update_kg_prep(percentage2.getText(), weigh_kg8.getText(), kg_2);
                    }
                    else if(temp_loop2 == 2)
                    {
                            setTextValues_screens(name3, percentage3, current_screen.get(temp_loop2));
                            update_kg_prep(percentage3.getText(), weigh_kg8.getText(), kg_3);
                    }
                }
            }
            else if( x == 1)
            {
                setTextValues_colorway(colorway_name3,weigh_kg3, binder3, this_color_and_screen.get(x));
                
                for(int temp_loop2 = 0; temp_loop2 < current_screen.size(); temp_loop2++ )
                {
                    if(temp_loop2 == 0)
                    {
                            setTextValues_screens(name5, percentage5, current_screen.get(temp_loop2));
                            update_kg_prep(percentage5.getText(), weigh_kg3.getText(), kg_5);
                    }
                    else if(temp_loop2 == 1)
                    {
                            setTextValues_screens(name6, percentage6, current_screen.get(temp_loop2));
                            update_kg_prep(percentage6.getText(), weigh_kg3.getText(), kg_6);
                    }
                    else if(temp_loop2 == 2)
                    {
                            setTextValues_screens(name7, percentage7, current_screen.get(temp_loop2));
                            update_kg_prep(percentage7.getText(), weigh_kg3.getText(), kg_7);
                    }
                }
            }
            else if( x == 2)
            {
                setTextValues_colorway(colorway_name4,weigh_kg4, binder4, this_color_and_screen.get(x));
                
                for(int temp_loop2 = 0; temp_loop2 < current_screen.size(); temp_loop2++ )
                {
                    if(temp_loop2 == 0)
                    {
                            setTextValues_screens(name9, percentage9, current_screen.get(temp_loop2));
                            update_kg_prep(percentage9.getText(), weigh_kg4.getText(), kg_9);
                    }
                    else if(temp_loop2 == 1){
                            setTextValues_screens(name10, percentage10, current_screen.get(temp_loop2));
                            update_kg_prep(percentage10.getText(), weigh_kg4.getText(), kg_10);
                    }
                    else if(temp_loop2 == 2){
                            setTextValues_screens(name11, percentage11, current_screen.get(temp_loop2));
                            update_kg_prep(percentage11.getText(), weigh_kg4.getText(), kg_11);
                    }
                }
            }
            else if( x == 3)
            {
                setTextValues_colorway(colorway_name5,weigh_kg5, binder5, this_color_and_screen.get(x));
                
                for(int temp_loop2 = 0; temp_loop2 < current_screen.size(); temp_loop2++ )
                {
                    if(temp_loop2 == 0)
                    {
                            setTextValues_screens(name13, percentage13, current_screen.get(temp_loop2));
                            update_kg_prep(percentage13.getText(), weigh_kg5.getText(), kg_13);
                    }
                    else if(temp_loop2 == 1){
                            setTextValues_screens(name14, percentage14, current_screen.get(temp_loop2));
                            update_kg_prep(percentage14.getText(), weigh_kg5.getText(), kg_14);
                    }
                    else if(temp_loop2 == 2){
                            setTextValues_screens(name15, percentage15, current_screen.get(temp_loop2));
                            update_kg_prep(percentage15.getText(), weigh_kg5.getText(), kg_15);
                    }
                }
            }
            else if( x == 4)
            {
                setTextValues_colorway(colorway_name6,weigh_kg6, binder6, this_color_and_screen.get(x));
                
                for(int temp_loop2 = 0; temp_loop2 < current_screen.size(); temp_loop2++ )
                {
                    if(temp_loop2 == 0){
                            setTextValues_screens(name17, percentage17, current_screen.get(temp_loop2));
                            update_kg_prep(percentage17.getText(), weigh_kg6.getText(), kg_17);
        
                    }
                    else if(temp_loop2 == 1){
                            setTextValues_screens(name18, percentage18, current_screen.get(temp_loop2));
                            update_kg_prep(percentage18.getText(), weigh_kg6.getText(), kg_18);
                    }
                    else if(temp_loop2 == 2){
                            setTextValues_screens(name19, percentage19, current_screen.get(temp_loop2));
                            update_kg_prep(percentage19.getText(), weigh_kg6.getText(), kg_19);
                    }
                }
            }
       
            else if( x == 5)
            {
                setTextValues_colorway(colorway_name7,weigh_kg7, binder7, this_color_and_screen.get(x));
                
                for(int temp_loop2 = 0; temp_loop2 < current_screen.size(); temp_loop2++ )
                {
                    if(temp_loop2 == 0){
                            setTextValues_screens(name21, percentage21, current_screen.get(temp_loop2));
                            update_kg_prep(percentage21.getText(), weigh_kg7.getText(), kg_21);
                    }
                    else if(temp_loop2 == 1){
                            setTextValues_screens(name22, percentage22, current_screen.get(temp_loop2));
                            update_kg_prep(percentage22.getText(), weigh_kg7.getText(), kg_22);
                    }
                    else if(temp_loop2 == 2){
                            setTextValues_screens(name23, percentage23, current_screen.get(temp_loop2));
                            update_kg_prep(percentage23.getText(), weigh_kg7.getText(), kg_23);
                    }
                }
            }
            else if( x == 6)
            {
                setTextValues_colorway(colorway_name8,weigh_kg9, binder9, this_color_and_screen.get(x));
                
                for(int temp_loop2 = 0; temp_loop2 < current_screen.size(); temp_loop2++ )
                {
                    if(temp_loop2 == 0){
                            setTextValues_screens(name24, percentage24, current_screen.get(temp_loop2));
                            update_kg_prep(percentage24.getText(), weigh_kg9.getText(), kg_24);
                    }
                    else if(temp_loop2 == 1){
                            setTextValues_screens(name25, percentage25, current_screen.get(temp_loop2));
                            update_kg_prep(percentage25.getText(), weigh_kg9.getText(), kg_25);
                    }
                    else if(temp_loop2 == 2){
                            setTextValues_screens(name26, percentage26, current_screen.get(temp_loop2));
                            update_kg_prep(percentage26.getText(), weigh_kg9.getText(), kg_26);
                    }
                }
            }
            
        }
    }
    
    private void setTextValues_screens(JComboBox pigment_name, JTextField percentage, Pigment_screen_and_colorway screen_p)
    {
        pigment_name.setSelectedItem(screen_p.getPigment_name());
        percentage.setText(Float.toString(screen_p.getPigment_percentage()));
    }
    private void setTextValues_colorway(JTextField colorway, JTextField weight, JComboBox binder, Colorway_screen_link_functions this_c_and_s)
    {
        colorway.setText(this_c_and_s.getColorway_name());
        weight.setText(Float.toString(this_c_and_s.getWeight_kg()));
        binder.setSelectedItem(this_c_and_s.getBinder());
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
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        spinner_date = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        design_name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fabric_style = new javax.swing.JTextField();
        fab_style_comb = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        design_color = new javax.swing.JTextField();
        fabric_check_box = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        quantity_total = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        quantity = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        customer_combo_list = new javax.swing.JComboBox();
        button_include_customer = new javax.swing.JButton();
        button_remove_customer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        text_job_order = new javax.swing.JTextField();
        customer_check_box = new javax.swing.JCheckBox();
        customer_name_text = new javax.swing.JTextField();
        job_ord_label = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        web_cams = new javax.swing.JComboBox();
        jPanel11 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jLabel129 = new javax.swing.JLabel();
        colorway_name2 = new javax.swing.JTextField();
        name1 = new javax.swing.JComboBox();
        percentage1 = new javax.swing.JTextField();
        jSeparator17 = new javax.swing.JSeparator();
        kg_2 = new javax.swing.JTextField();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        weigh_kg8 = new javax.swing.JTextField();
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
        binder8 = new javax.swing.JComboBox();
        jLabel143 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        kg_1 = new javax.swing.JTextField();
        coverage1 = new javax.swing.JTextField();
        jLabel140 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        pig11 = new javax.swing.JButton();
        pig12 = new javax.swing.JButton();
        pig13 = new javax.swing.JButton();
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
        binder3 = new javax.swing.JComboBox();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        coverage3 = new javax.swing.JTextField();
        jLabel157 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        pig14 = new javax.swing.JButton();
        pig15 = new javax.swing.JButton();
        pig16 = new javax.swing.JButton();
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
        binder4 = new javax.swing.JComboBox();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        coverage4 = new javax.swing.JTextField();
        jLabel159 = new javax.swing.JLabel();
        jLabel165 = new javax.swing.JLabel();
        pig17 = new javax.swing.JButton();
        pig18 = new javax.swing.JButton();
        pig19 = new javax.swing.JButton();
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
        binder5 = new javax.swing.JComboBox();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        coverage5 = new javax.swing.JTextField();
        jLabel161 = new javax.swing.JLabel();
        jLabel166 = new javax.swing.JLabel();
        pig20 = new javax.swing.JButton();
        pig21 = new javax.swing.JButton();
        pig22 = new javax.swing.JButton();
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
        binder6 = new javax.swing.JComboBox();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        coverage6 = new javax.swing.JTextField();
        jLabel163 = new javax.swing.JLabel();
        jLabel167 = new javax.swing.JLabel();
        pig23 = new javax.swing.JButton();
        pig24 = new javax.swing.JButton();
        pig25 = new javax.swing.JButton();
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
        binder7 = new javax.swing.JComboBox();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        coverage2 = new javax.swing.JTextField();
        jLabel155 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        pig26 = new javax.swing.JButton();
        pig27 = new javax.swing.JButton();
        pig28 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        colorway_name8 = new javax.swing.JTextField();
        name24 = new javax.swing.JComboBox();
        percentage24 = new javax.swing.JTextField();
        jSeparator19 = new javax.swing.JSeparator();
        kg_24 = new javax.swing.JTextField();
        jLabel117 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        weigh_kg9 = new javax.swing.JTextField();
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
        binder9 = new javax.swing.JComboBox();
        jLabel169 = new javax.swing.JLabel();
        jLabel170 = new javax.swing.JLabel();
        jLabel171 = new javax.swing.JLabel();
        jLabel172 = new javax.swing.JLabel();
        coverage7 = new javax.swing.JTextField();
        jLabel173 = new javax.swing.JLabel();
        jLabel174 = new javax.swing.JLabel();
        pig29 = new javax.swing.JButton();
        pig30 = new javax.swing.JButton();
        pig31 = new javax.swing.JButton();
        save_edit_but = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        preview_but = new javax.swing.JButton();
        cancel_but = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edit this design");
        setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        setForeground(java.awt.Color.white);
        setIconImages(null);
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(790, 732));
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

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 15, 790));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(777, 0, 20, 790));

        jPanel14.setBackground(new java.awt.Color(51, 153, 255));
        jPanel14.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Edit Recipe");
        jPanel14.add(jLabel7);
        jLabel7.setBounds(53, 11, 196, 45);

        spinner_date.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        spinner_date.setModel(new javax.swing.SpinnerDateModel());
        spinner_date.setToolTipText("Day, Month and Year");
        jPanel14.add(spinner_date);
        spinner_date.setBounds(616, 20, 130, 34);
        spinner_date.setEditor(new JSpinner.DateEditor(spinner_date, "dd/MM/yyyy"));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Date Ordered :");
        jLabel6.setToolTipText("");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel14.add(jLabel6);
        jLabel6.setBounds(470, 20, 140, 30);
        jLabel6.getAccessibleContext().setAccessibleName("date");

        getContentPane().add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 770, 60));

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setLayout(null);

        design_name.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel1.add(design_name);
        design_name.setBounds(172, 212, 200, 32);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Design Name :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 210, 150, 34);

        fabric_style.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel1.add(fabric_style);
        fabric_style.setBounds(520, 230, 150, 34);

        fab_style_comb.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        fab_style_comb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "PONGEE", "COTTON", "KATUNIA", "MICROPEACH", "TC", "TROPICANA" }));
        jPanel1.add(fab_style_comb);
        fab_style_comb.setBounds(520, 230, 150, 34);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(220, -40, 100, 40);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(350, -40, 440, 40);

        jPanel10.setBackground(new java.awt.Color(204, 0, 102));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel10);
        jPanel10.setBounds(370, -40, 100, 40);

        design_color.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jPanel1.add(design_color);
        design_color.setBounds(172, 253, 200, 32);

        fabric_check_box.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        fabric_check_box.setForeground(new java.awt.Color(255, 255, 255));
        fabric_check_box.setText("New ?");
        fabric_check_box.setOpaque(false);
        fabric_check_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fabric_check_boxActionPerformed(evt);
            }
        });
        jPanel1.add(fabric_check_box);
        fabric_check_box.setBounds(610, 210, 63, 25);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Fabric Style :");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(410, 230, 100, 34);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Design Color :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 250, 150, 34);

        jPanel16.setBackground(new java.awt.Color(51, 51, 51));
        jPanel16.setOpaque(false);
        jPanel16.setLayout(null);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Total Quantity :");
        jPanel16.add(jLabel3);
        jLabel3.setBounds(320, 120, 130, 34);

        quantity_total.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        quantity_total.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        quantity_total.setEnabled(false);
        jPanel16.add(quantity_total);
        quantity_total.setBounds(460, 120, 100, 34);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("m");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel16.add(jLabel5);
        jLabel5.setBounds(560, 120, 13, 34);

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("m");
        jLabel13.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel16.add(jLabel13);
        jLabel13.setBounds(295, 120, 13, 34);

        quantity.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        quantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                quantityFocusLost(evt);
            }
        });
        jPanel16.add(quantity);
        quantity.setBounds(150, 120, 143, 34);

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Quantity :");
        jPanel16.add(jLabel12);
        jLabel12.setBounds(0, 120, 140, 34);

        customer_combo_list.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        customer_combo_list.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel16.add(customer_combo_list);
        customer_combo_list.setBounds(150, 70, 160, 34);

        button_include_customer.setBackground(new java.awt.Color(255, 255, 255));
        button_include_customer.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        button_include_customer.setText("Add ");
        button_include_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_include_customerActionPerformed(evt);
            }
        });
        jPanel16.add(button_include_customer);
        button_include_customer.setBounds(10, 170, 290, 30);

        button_remove_customer.setBackground(new java.awt.Color(255, 255, 255));
        button_remove_customer.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        button_remove_customer.setText("Delete");
        button_remove_customer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_remove_customerActionPerformed(evt);
            }
        });
        jPanel16.add(button_remove_customer);
        button_remove_customer.setBounds(310, 170, 270, 30);

        jScrollPane1.setViewportView(jList1);

        jPanel16.add(jScrollPane1);
        jScrollPane1.setBounds(320, 20, 260, 90);

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Customer Name :");
        jPanel16.add(jLabel9);
        jLabel9.setBounds(0, 70, 140, 34);

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(247, 241, 241));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Job Order :");
        jPanel16.add(jLabel10);
        jLabel10.setBounds(0, 18, 140, 34);

        text_job_order.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                text_job_orderKeyTyped(evt);
            }
        });
        jPanel16.add(text_job_order);
        text_job_order.setBounds(220, 20, 90, 30);

        customer_check_box.setBackground(new java.awt.Color(51, 153, 255));
        customer_check_box.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        customer_check_box.setForeground(java.awt.SystemColor.controlLtHighlight);
        customer_check_box.setText("New?");
        customer_check_box.setOpaque(false);
        customer_check_box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customer_check_boxActionPerformed(evt);
            }
        });
        jPanel16.add(customer_check_box);
        customer_check_box.setBounds(250, 50, 59, 20);

        customer_name_text.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jPanel16.add(customer_name_text);
        customer_name_text.setBounds(150, 70, 160, 34);

        job_ord_label.setBackground(new java.awt.Color(255, 255, 255));
        job_ord_label.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        job_ord_label.setForeground(new java.awt.Color(255, 255, 255));
        job_ord_label.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        job_ord_label.setText("15P-10-");
        jPanel16.add(job_ord_label);
        job_ord_label.setBounds(150, 20, 70, 30);

        jPanel1.add(jPanel16);
        jPanel16.setBounds(14, 0, 590, 210);

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        jLabel14.setText("INSERT PICTURE HERE");
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(jLabel14);
        jLabel14.setBounds(610, 0, 140, 130);

        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jButton1.setText("Add Picture");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(610, 170, 140, 30);

        web_cams.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jPanel1.add(web_cams);
        web_cams.setBounds(610, 137, 140, 25);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 770, 295));

        jPanel11.setBackground(new java.awt.Color(51, 153, 255));

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane2.setToolTipText("");
        jTabbedPane2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel129.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel129.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel129.setText("Screen Name :");
        jPanel9.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 120, 34));

        colorway_name2.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jPanel9.add(colorway_name2, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 10, 180, 34));

        name1.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        name1.setName("pigment_name"); // NOI18N
        jPanel9.add(name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 72, 165, 30));

        percentage1.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        percentage1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                percentage1KeyReleased(evt);
            }
        });
        jPanel9.add(percentage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 72, 61, 30));
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

        weigh_kg8.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        weigh_kg8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                weigh_kg8KeyReleased(evt);
            }
        });
        jPanel9.add(weigh_kg8, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 10, 60, 34));

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
        jPanel9.add(percentage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 109, 61, 30));

        jLabel135.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel135.setText("%");
        jPanel9.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 111, 31, 22));

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
        jPanel9.add(percentage3, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 146, 61, 30));

        jLabel138.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel138.setText("%");
        jPanel9.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 148, 31, 22));

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

        binder8.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        binder8.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3.5", "4", "5.5", "8" }));
        jPanel9.add(binder8, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 200, 61, 30));

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
        jPanel9.add(jLabel153, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 74, 31, 22));

        jButton2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jButton2.setText("+");
        jButton2.setMargin(new java.awt.Insets(2, 0, 2, 0));
        jPanel9.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 30, 34));

        pig11.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig11.setText("+");
        pig11.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig11ActionPerformed(evt);
            }
        });
        jPanel9.add(pig11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 148, 25, 25));

        pig12.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig12.setText("+");
        pig12.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig12ActionPerformed(evt);
            }
        });
        jPanel9.add(pig12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 74, 25, 25));

        pig13.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig13.setText("+");
        pig13.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig13ActionPerformed(evt);
            }
        });
        jPanel9.add(pig13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 25, 25));

        jTabbedPane2.addTab("1", jPanel9);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
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
        jPanel4.add(percentage5, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 72, 61, 30));
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
        jPanel4.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 74, 31, 22));

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
        jPanel4.add(percentage6, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 109, 61, 30));

        jLabel55.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel55.setText("%");
        jPanel4.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 111, 31, 22));

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
        jPanel4.add(percentage7, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 146, 61, 30));

        jLabel58.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel58.setText("%");
        jPanel4.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 148, 31, 22));

        kg_7.setEditable(false);
        kg_7.setBackground(new java.awt.Color(204, 204, 204));
        kg_7.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        kg_7.setFocusable(false);
        jPanel4.add(kg_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 146, 85, 30));

        jLabel59.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel59.setText("kg / prep");
        jPanel4.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 149, -1, -1));
        jPanel4.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 255, 743, 10));

        binder3.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        binder3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3.5", "4", "5.5", "8" }));
        jPanel4.add(binder3, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 200, 61, 30));

        jLabel63.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel63.setText("Binder :");
        jPanel4.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 205, -1, -1));

        jLabel64.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel64.setText("%");
        jPanel4.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 205, -1, 22));

        jLabel145.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel145.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel145.setText("Screen Name :");
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

        pig14.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig14.setText("+");
        pig14.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig14ActionPerformed(evt);
            }
        });
        jPanel4.add(pig14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 74, 25, 25));

        pig15.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig15.setText("+");
        pig15.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig15ActionPerformed(evt);
            }
        });
        jPanel4.add(pig15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 25, 25));

        pig16.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig16.setText("+");
        pig16.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig16ActionPerformed(evt);
            }
        });
        jPanel4.add(pig16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 148, 25, 25));

        jTabbedPane2.addTab("2", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
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
        jPanel5.add(percentage9, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 72, 61, 30));
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
        jPanel5.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 74, 31, 22));

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
        jPanel5.add(percentage10, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 109, 61, 30));

        jLabel71.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel71.setText("%");
        jPanel5.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 111, 31, 22));

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
        jPanel5.add(percentage11, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 146, 61, 30));

        jLabel74.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel74.setText("%");
        jPanel5.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 148, 31, 22));

        kg_11.setBackground(new java.awt.Color(204, 204, 204));
        kg_11.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        kg_11.setFocusable(false);
        jPanel5.add(kg_11, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 146, 85, 30));

        jLabel75.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel75.setText("kg / prep");
        jPanel5.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 149, -1, -1));
        jPanel5.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 255, 743, 10));

        binder4.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        binder4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3.5", "4", "5.5", "8" }));
        jPanel5.add(binder4, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 200, 61, 30));

        jLabel79.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel79.setText("Binder :");
        jPanel5.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 205, -1, -1));

        jLabel80.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel80.setText("%");
        jPanel5.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 205, -1, 22));

        jLabel146.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel146.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel146.setText("Screen Name :");
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

        pig17.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig17.setText("+");
        pig17.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig17ActionPerformed(evt);
            }
        });
        jPanel5.add(pig17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 74, 25, 25));

        pig18.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig18.setText("+");
        pig18.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig18ActionPerformed(evt);
            }
        });
        jPanel5.add(pig18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 25, 25));

        pig19.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig19.setText("+");
        pig19.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig19ActionPerformed(evt);
            }
        });
        jPanel5.add(pig19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 148, 25, 25));

        jTabbedPane2.addTab("3", jPanel5);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
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
        jPanel6.add(percentage13, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 72, 61, 30));
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
        jPanel6.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 74, 31, 22));

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
        jPanel6.add(percentage14, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 109, 61, 30));

        jLabel87.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel87.setText("%");
        jPanel6.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 111, 31, 22));

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
        jPanel6.add(percentage15, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 146, 61, 30));

        jLabel90.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel90.setText("%");
        jPanel6.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 148, 31, 22));

        kg_15.setBackground(new java.awt.Color(204, 204, 204));
        kg_15.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        kg_15.setFocusable(false);
        jPanel6.add(kg_15, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 146, 85, 30));

        jLabel91.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel91.setText("kg / prep");
        jPanel6.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 149, -1, -1));
        jPanel6.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 255, 743, 10));

        binder5.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        binder5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3.5", "4", "5.5", "8" }));
        jPanel6.add(binder5, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 200, 61, 30));

        jLabel95.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel95.setText("Binder :");
        jPanel6.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 205, -1, -1));

        jLabel96.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel96.setText("%");
        jPanel6.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 205, -1, 22));

        jLabel147.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel147.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel147.setText("Screen Name :");
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

        pig20.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig20.setText("+");
        pig20.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig20ActionPerformed(evt);
            }
        });
        jPanel6.add(pig20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 74, 25, 25));

        pig21.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig21.setText("+");
        pig21.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig21ActionPerformed(evt);
            }
        });
        jPanel6.add(pig21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 25, 25));

        pig22.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig22.setText("+");
        pig22.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig22ActionPerformed(evt);
            }
        });
        jPanel6.add(pig22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 148, 25, 25));

        jTabbedPane2.addTab("4", jPanel6);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
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
        jPanel7.add(percentage17, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 72, 61, 30));
        jPanel7.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 51, 743, 10));

        kg_17.setBackground(new java.awt.Color(204, 204, 204));
        kg_17.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        kg_17.setFocusable(false);
        jPanel7.add(kg_17, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 72, 85, 30));

        jLabel98.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel98.setText("kg / prep");
        jPanel7.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 75, -1, -1));

        jLabel99.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel99.setText("Pigment Name :");
        jPanel7.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(55, 75, -1, -1));

        jLabel100.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel100.setText("%");
        jPanel7.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 74, 31, 22));

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
        jPanel7.add(percentage18, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 109, 61, 30));

        jLabel103.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel103.setText("%");
        jPanel7.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 111, 31, 22));

        kg_18.setBackground(new java.awt.Color(204, 204, 204));
        kg_18.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        kg_18.setFocusable(false);
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
        jPanel7.add(percentage19, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 146, 61, 30));

        jLabel106.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel106.setText("%");
        jPanel7.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 148, 31, 22));

        kg_19.setBackground(new java.awt.Color(204, 204, 204));
        kg_19.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        kg_19.setFocusable(false);
        jPanel7.add(kg_19, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 146, 85, 30));

        jLabel107.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel107.setText("kg / prep");
        jPanel7.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 149, -1, -1));
        jPanel7.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 255, 743, 10));

        binder6.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        binder6.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3.5", "4", "5.5", "8" }));
        jPanel7.add(binder6, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 200, 61, 30));

        jLabel111.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel111.setText("Binder :");
        jPanel7.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 205, -1, -1));

        jLabel112.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel112.setText("%");
        jPanel7.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 205, -1, 22));

        jLabel148.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel148.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel148.setText("Screen Name :");
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

        pig23.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig23.setText("+");
        pig23.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig23ActionPerformed(evt);
            }
        });
        jPanel7.add(pig23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 74, 25, 25));

        pig24.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig24.setText("+");
        pig24.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig24ActionPerformed(evt);
            }
        });
        jPanel7.add(pig24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 25, 25));

        pig25.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig25.setText("+");
        pig25.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig25ActionPerformed(evt);
            }
        });
        jPanel7.add(pig25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 148, 25, 25));

        jTabbedPane2.addTab("5", jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
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
        jPanel8.add(percentage21, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 72, 61, 30));
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
        jPanel8.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 74, 31, 22));

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
        jPanel8.add(percentage22, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 109, 61, 30));

        jLabel119.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel119.setText("%");
        jPanel8.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 111, 31, 22));

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
        jPanel8.add(percentage23, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 146, 61, 30));

        jLabel122.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel122.setText("%");
        jPanel8.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 148, 31, 22));

        kg_23.setBackground(new java.awt.Color(204, 204, 204));
        kg_23.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        kg_23.setFocusable(false);
        jPanel8.add(kg_23, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 146, 85, 30));

        jLabel123.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel123.setText("kg / prep");
        jPanel8.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 149, -1, -1));
        jPanel8.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 255, 775, 10));

        binder7.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        binder7.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3.5", "4", "5.5", "8" }));
        jPanel8.add(binder7, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 61, 30));

        jLabel127.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel127.setText("Binder :");
        jPanel8.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 205, -1, -1));

        jLabel128.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel128.setText("%");
        jPanel8.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 205, -1, 22));

        jLabel149.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel149.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel149.setText("Screen Name :");
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

        pig26.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig26.setText("+");
        pig26.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig26ActionPerformed(evt);
            }
        });
        jPanel8.add(pig26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 74, 25, 25));

        pig27.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig27.setText("+");
        pig27.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig27ActionPerformed(evt);
            }
        });
        jPanel8.add(pig27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 25, 25));

        pig28.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig28.setText("+");
        pig28.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig28ActionPerformed(evt);
            }
        });
        jPanel8.add(pig28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 148, 25, 25));

        jTabbedPane2.addTab("6", jPanel8);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
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
        jPanel15.add(percentage24, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 72, 61, 30));
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
        jPanel15.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 74, 31, 22));

        weigh_kg9.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        weigh_kg9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                weigh_kg9KeyReleased(evt);
            }
        });
        jPanel15.add(weigh_kg9, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 10, 60, 34));

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
        jPanel15.add(percentage25, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 109, 61, 30));

        jLabel141.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel141.setText("%");
        jPanel15.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 111, 31, 22));

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
        jPanel15.add(percentage26, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 146, 61, 30));

        jLabel151.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel151.setText("%");
        jPanel15.add(jLabel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 148, 31, 22));

        kg_26.setBackground(new java.awt.Color(204, 204, 204));
        kg_26.setFont(new java.awt.Font("Century Gothic", 1, 15)); // NOI18N
        kg_26.setFocusable(false);
        jPanel15.add(kg_26, new org.netbeans.lib.awtextra.AbsoluteConstraints(451, 146, 85, 30));

        jLabel152.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel152.setText("kg / prep");
        jPanel15.add(jLabel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 149, -1, -1));
        jPanel15.add(jSeparator20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 255, 775, 10));

        binder9.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        binder9.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3.5", "4", "5.5", "8" }));
        jPanel15.add(binder9, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 61, 30));

        jLabel169.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel169.setText("Binder :");
        jPanel15.add(jLabel169, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 205, -1, -1));

        jLabel170.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel170.setText("%");
        jPanel15.add(jLabel170, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 205, -1, 22));

        jLabel171.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel171.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel171.setText("Screen Name :");
        jPanel15.add(jLabel171, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 10, 120, 34));

        jLabel172.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel172.setText("%");
        jPanel15.add(jLabel172, new org.netbeans.lib.awtextra.AbsoluteConstraints(678, 10, 15, 34));

        coverage7.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        coverage7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                coverage7KeyReleased(evt);
            }
        });
        jPanel15.add(coverage7, new org.netbeans.lib.awtextra.AbsoluteConstraints(615, 10, 60, 34));

        jLabel173.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel173.setText("Coverage :");
        jPanel15.add(jLabel173, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 10, -1, 34));

        jLabel174.setFont(new java.awt.Font("Century Gothic", 0, 15)); // NOI18N
        jLabel174.setText("Kilograms / KGS :");
        jPanel15.add(jLabel174, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 10, -1, 34));

        pig29.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig29.setText("+");
        pig29.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig29ActionPerformed(evt);
            }
        });
        jPanel15.add(pig29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 74, 25, 25));

        pig30.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig30.setText("+");
        pig30.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig30ActionPerformed(evt);
            }
        });
        jPanel15.add(pig30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 25, 25));

        pig31.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        pig31.setText("+");
        pig31.setMargin(new java.awt.Insets(0, 0, 0, 0));
        pig31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pig31ActionPerformed(evt);
            }
        });
        jPanel15.add(pig31, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 148, 25, 25));

        jTabbedPane2.addTab("7", jPanel15);

        save_edit_but.setBackground(new java.awt.Color(255, 255, 255));
        save_edit_but.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        save_edit_but.setText("Save & Print");
        save_edit_but.setToolTipText("");
        save_edit_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_edit_butActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Screens");

        preview_but.setBackground(new java.awt.Color(255, 255, 255));
        preview_but.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        preview_but.setText("Preview");
        preview_but.setToolTipText("");
        preview_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                preview_butActionPerformed(evt);
            }
        });

        cancel_but.setBackground(new java.awt.Color(255, 255, 255));
        cancel_but.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        cancel_but.setText("Cancel");
        cancel_but.setToolTipText("");
        cancel_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_butActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(save_edit_but, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(preview_but, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancel_but, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(save_edit_but, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(preview_but, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancel_but, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        getContentPane().add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 770, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * 
     * @param pigment_name -Declared pigment name
     * @param pigment_percent - percentage of pigment in variable float
     */
    private void add_purchase(){
        
        SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
                String spinnerValue = formater.format(this.spinner_date.getValue());
                System.out.println(spinnerValue);
                
        purchase_order purchase = new purchase_order();

        Boolean test1 = purchase.add_new_purchase();
        if (test1 == true){
            JOptionPane.showMessageDialog(null,"This Purchase has been edited");
        } else {
            JOptionPane.showMessageDialog(null,"Puchase not changed");
        }
        
            JOptionPane.showMessageDialog(null,purchase.getPurchase_Id_Last());
            
    }
    private void add_job(int id_purchase)
    {
        /*
        for (int i = 0; i < job_list.size(); i++)
        {
            job_order job = new job_order();
            DB_Manager new_conn = new DB_Manager();
            
            job.setCustomer_id(new_conn.get_id_customer(this.customer_list.get(i).toString()));
            //job.setQuantity(Integer.parseInt(this.quantity_list.get(i).toString()));
            job.setJob_id(this.job_list.get(i).toString());
            //job.setId_purchase(id_purchase);

            job.add_new_job_order();
        }
        */
        List<job_order> all_jobs = get_job_details();
        for(int x = 0; x < all_jobs.size() ; x++ )
        {
            all_jobs.get(x).add_new_job_order();
        }
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
    
    private int update_this_colorway(int colorway_num, String colorway_name, float binder_percent, String temp_weight_kg)
    {
        if(colorway_name.length()>0)
        {
            if(temp_weight_kg.length()>0)
            {
                float weight_kg = Float.parseFloat(temp_weight_kg);
                if(prod_recipe.getAll_colorways().size()> colorway_num)
                {
                    prod_recipe.getAll_colorways().get(colorway_num).setColorway_name(colorway_name);
                    prod_recipe.getAll_colorways().get(colorway_num).setBinder(binder_percent);
                    prod_recipe.getAll_colorways().get(colorway_num).setWeight_kg(weight_kg);
                    // new_colorway.add_new_colorway();
                    //new_colorway.set_id_colorway_from_variables();
                    prod_recipe.getAll_colorways().get(colorway_num).update_this_colorway();
                    return prod_recipe.getAll_colorways().get(colorway_num).getId_colorway();
                }
                else
                {
                    Colorway_screen_link_functions this_color_screen = new Colorway_screen_link_functions();
                    this_color_screen.setColorway_name(colorway_name);
                    this_color_screen.setBinder(binder_percent);
                    this_color_screen.setWeight_kg(weight_kg);
                    
                    if(this_color_screen.add_new_colorway())
                    {
                        prod_recipe.add_colorway(this_color_screen);
                        return this_color_screen.getId_colorway();
                    }
                }
            }
        }
        return -1;
    }
    
    private int update_this_design()
    {
        colortextile_class.design new_design = new colortextile_class.design();
        new_design.setDesign_name(design_name.getText());
        new_design.setColor_name(design_color.getText());
        if(fabric_check_box.isSelected())
        {
            new_design.setFabric_style(fabric_style.getText().toUpperCase());
            new_design.add_fabric_style();
        }
        else
        {
            new_design.setFabric_style(fab_style_comb.getSelectedItem().toString());
        }
        
        new_design.update_design();
           
        return new_design.getDesign_code();
    }
    
    private int update_or_add_this_screen_pigment(int interval, int pig_num, String pigment_name, String pigment_percent, int colorway_id)
    {
        if(pigment_name.length()> 0 && pigment_percent.length() > 0 && !pigment_percent.isEmpty())
        {
            float this_pigment_percent = Float.parseFloat(pigment_percent);
            
            if(this.prod_recipe.getAll_colorways().get(interval).getThis_screens().size() < pig_num)
            {
                this.prod_recipe.getAll_colorways().get(interval).getThis_screens().get(pig_num).setPigment_name(pigment_name);
                this.prod_recipe.getAll_colorways().get(interval).getThis_screens().get(pig_num).set_pigment_id_from_name();
                this.prod_recipe.getAll_colorways().get(interval).getThis_screens().get(pig_num).setPigment_percentage(this_pigment_percent);
                this.prod_recipe.getAll_colorways().get(interval).getThis_screens().get(pig_num).update_colorway_and_screen();
            }
            else
            {
                Pigment_screen_and_colorway new_screen_pigment = new Pigment_screen_and_colorway();
                new_screen_pigment.setPigment_name(pigment_name);
                new_screen_pigment.set_pigment_id_from_name();
                new_screen_pigment.setPigment_percentage(this_pigment_percent);
                new_screen_pigment.setId_colorway(colorway_id);
                new_screen_pigment.add_colorway_and_screen();
                this.prod_recipe.getAll_colorways().get(interval).add_screen(new_screen_pigment);
                //new_screen_pigment.get_screen_pigment_id_from_pigment_no_and_pigment_percentage();
            }
            //return new_screen_pigment.getId_screen();
        }
        return -1;
    }
   
    
    private void save_edit_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_edit_butActionPerformed
        // TODO add your handling code here:
       
        if (this.jList1.getModel().getSize() == 0)
        {
            JOptionPane.showMessageDialog(null,"Please include a customer");
        } else {
            
            add_purchase();
        }
        
        update_this_design();
        for(int interval = 0; interval <7 ; interval++)
        {
            int colorway_id, colorway_id2;
            /////////Colorway 1
            if(interval == 0)
            {
                colorway_id = update_this_colorway(interval,colorway_name2.getText(), 
                             Float.parseFloat(binder8.getSelectedItem().toString()),
                             weigh_kg8.getText());
                if(colorway_id != -1)
                {
                    update_or_add_this_screen_pigment(interval,0,name1.getSelectedItem().toString(),
                                      percentage1.getText(), colorway_id );
                    
                    update_or_add_this_screen_pigment(interval,1, name2.getSelectedItem().toString(),
                                      percentage2.getText(), colorway_id );
                    
                    update_or_add_this_screen_pigment(interval,2, name3.getSelectedItem().toString(),
                                      percentage3.getText(), colorway_id );
                } 
            }
            ////////////Colorway 2
            else if(interval == 1)
            {
                colorway_id2 = update_this_colorway(interval,colorway_name3.getText(), 
                             Float.parseFloat(binder3.getSelectedItem().toString()),
                             weigh_kg3.getText());
                
                if(colorway_id2 != -1 )
                {
                    update_or_add_this_screen_pigment(interval, 0, name5.getSelectedItem().toString(),
                                      percentage5.getText(), colorway_id2 );
                    
                    update_or_add_this_screen_pigment(interval, 1, name6.getSelectedItem().toString(),
                                      percentage6.getText(), colorway_id2 );
                    
                    update_or_add_this_screen_pigment(interval, 2, name7.getSelectedItem().toString(),
                                      percentage7.getText(), colorway_id2 );
                }
            }
            ////////////Colorway 3
            else if(interval == 2)
            {
                colorway_id = update_this_colorway(interval,colorway_name4.getText(), 
                             Float.parseFloat(binder4.getSelectedItem().toString()),
                             weigh_kg4.getText());
                
                if(colorway_id != -1 )
                {
                    update_or_add_this_screen_pigment(interval, 0, name9.getSelectedItem().toString(),
                                      percentage9.getText(), colorway_id );
                    
                    update_or_add_this_screen_pigment(interval, 1, name10.getSelectedItem().toString(),
                                      percentage10.getText(), colorway_id );
                    
                    update_or_add_this_screen_pigment(interval, 2, name11.getSelectedItem().toString(),
                                      percentage11.getText(), colorway_id );
                }
            }
            ////////////Colorway 4
            else if(interval == 3)
            {
                colorway_id2 = update_this_colorway(interval,colorway_name5.getText(), 
                             Float.parseFloat(binder5.getSelectedItem().toString()),
                             weigh_kg5.getText());
                
                if(colorway_id2 != -1 )
                {
                    update_or_add_this_screen_pigment(interval, 0, name13.getSelectedItem().toString(),
                                      percentage13.getText(), colorway_id2 );
                    
                    update_or_add_this_screen_pigment(interval, 1, name14.getSelectedItem().toString(),
                                      percentage14.getText(), colorway_id2 );
                    
                    update_or_add_this_screen_pigment(interval, 2, name15.getSelectedItem().toString(),
                                      percentage15.getText(), colorway_id2 );
                }
            }
            ////////////Colorway 5
            else if(interval == 4)
            {
                colorway_id = update_this_colorway(interval,colorway_name6.getText(), 
                             Float.parseFloat(binder6.getSelectedItem().toString()),
                             weigh_kg6.getText());
                
                if(colorway_id != -1 )
                {
                    update_or_add_this_screen_pigment(interval, 0, name17.getSelectedItem().toString(),
                                      percentage17.getText(), colorway_id );
                    
                    update_or_add_this_screen_pigment(interval, 1, name18.getSelectedItem().toString(),
                                      percentage18.getText(), colorway_id );
                    
                    update_or_add_this_screen_pigment(interval, 2, name19.getSelectedItem().toString(),
                                      percentage19.getText(), colorway_id );
                }
            }
            ////////////Colorway 6
            else if(interval == 5)
            {
             
                colorway_id2 = update_this_colorway(interval,colorway_name7.getText(), 
                             Float.parseFloat(binder7.getSelectedItem().toString()),
                             weigh_kg7.getText());
                
                if( colorway_id2 != -1 )
                {
                    update_or_add_this_screen_pigment(interval, 0, name21.getSelectedItem().toString(),
                                      percentage21.getText(), colorway_id2 );
                    
                    update_or_add_this_screen_pigment(interval, 1, name22.getSelectedItem().toString(),
                                      percentage22.getText(), colorway_id2 );
                    
                    update_or_add_this_screen_pigment(interval, 2, name23.getSelectedItem().toString(),
                                      percentage23.getText(), colorway_id2 );
                }
            }
            //////////// Colorway 7
            else if(interval == 6)
            {
                colorway_id = update_this_colorway(interval,colorway_name8.getText(), 
                             Float.parseFloat(binder9.getSelectedItem().toString()),
                             weigh_kg9.getText());
                if(colorway_id != -1 )
                {
                    update_or_add_this_screen_pigment(interval, 0, name24.getSelectedItem().toString(),
                                      percentage24.getText(), colorway_id );
                    
                    update_or_add_this_screen_pigment(interval, 1, name25.getSelectedItem().toString(),
                                      percentage25.getText(), colorway_id );
                    
                    update_or_add_this_screen_pigment(interval, 2, name26.getSelectedItem().toString(),
                                      percentage26.getText(), colorway_id );
                }
            }
        }
        JOptionPane.showMessageDialog(null,"Successfully Edited this Recipe");
         
    }//GEN-LAST:event_save_edit_butActionPerformed
    
    private void customer_check_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customer_check_boxActionPerformed
        if(this.customer_check_box.isSelected()){
            this.customer_name_text.setVisible(true);
            this.customer_combo_list.setVisible(false);
        } else {
            this.customer_name_text.setVisible(false);
            this.customer_combo_list.setVisible(true);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_customer_check_boxActionPerformed
             
    private void text_job_orderKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text_job_orderKeyTyped
        // TODO add your handling code here:
        if (this.text_job_order.getText().length() >= 4 )
            this.text_job_order.setText(text_job_order.getText().substring(0, 3));
    }//GEN-LAST:event_text_job_orderKeyTyped

    private void fabric_check_boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fabric_check_boxActionPerformed
        // TODO add your handling code here:
        if(this.fabric_check_box.isSelected()){
            this.fab_style_comb.setVisible(false);
            this.fabric_style.setVisible(true);
        } else {
            this.fab_style_comb.setVisible(true);
            this.fabric_style.setVisible(false);
        }
    }//GEN-LAST:event_fabric_check_boxActionPerformed

    private void quantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_quantityFocusLost
        // TODO add your handling code here:
        check_this_textbox(quantity);
    }//GEN-LAST:event_quantityFocusLost

    private void coverage1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_coverage1KeyReleased
        // TODO add your handling code here:
        if(coverage1.getText().length()>0)
        {
            if(!use_func.checkText2(coverage1.getText()))
            {
                compute_kg(weigh_kg8, Float.parseFloat(coverage1.getText()));
            }
        }
    }//GEN-LAST:event_coverage1KeyReleased

    private void coverage2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_coverage2KeyReleased
        // TODO add your handling code here:
        if(coverage2.getText().length()>0)
        {
            if(!use_func.checkText2(coverage2.getText()))
            {
                compute_kg(weigh_kg7, Float.parseFloat(coverage2.getText()));
            }
        }
    }//GEN-LAST:event_coverage2KeyReleased

    private void coverage3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_coverage3KeyReleased
        // TODO add your handling code here:
        if(coverage3.getText().length()>0)
        {
            if(!use_func.checkText2(coverage3.getText()))
            {
                compute_kg(weigh_kg3, Float.parseFloat(coverage3.getText()));
            }
        }
    }//GEN-LAST:event_coverage3KeyReleased

    private void coverage4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_coverage4KeyReleased
        // TODO add your handling code here:
        if(coverage4.getText().length()>0)
        {
            if(!use_func.checkText2(coverage4.getText()))
            {
                compute_kg(weigh_kg4, Float.parseFloat(coverage4.getText()));
            }
        }
    }//GEN-LAST:event_coverage4KeyReleased

    private void coverage5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_coverage5KeyReleased
        // TODO add your handling code here:
        if(coverage4.getText().length()>0)
        {
            if(!use_func.checkText2(coverage5.getText()))
            {
                compute_kg(weigh_kg5, Float.parseFloat(coverage5.getText()));
            }
        }
    }//GEN-LAST:event_coverage5KeyReleased

    private void coverage6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_coverage6KeyReleased
        // TODO add your handling code here:
        if(coverage6.getText().length()>0)
        {
            if(!use_func.checkText2(coverage6.getText()))
            {
                compute_kg(weigh_kg6, Float.parseFloat(coverage6.getText()));
            }
        }
    }//GEN-LAST:event_coverage6KeyReleased

    private void percentage1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage1KeyReleased
        // TODO add your handling code here:
        check_this_textbox(percentage1);
        update_kg_prep(percentage1.getText(), weigh_kg8.getText(), kg_1);
    }//GEN-LAST:event_percentage1KeyReleased

    private void percentage2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage2KeyReleased
        // TODO add your handling code here:
        check_this_textbox(percentage2);
        update_kg_prep(percentage2.getText(), weigh_kg8.getText(), kg_2);
    }//GEN-LAST:event_percentage2KeyReleased

    private void percentage3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage3KeyReleased
        // TODO add your handling code here:
        check_this_textbox(percentage3);
        update_kg_prep(percentage3.getText(), weigh_kg8.getText(), kg_3);
    }//GEN-LAST:event_percentage3KeyReleased

    private void weigh_kg8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_weigh_kg8KeyReleased
        // TODO add your handling code here:
        check_this_textbox(weigh_kg8);
        update_kg_prep(percentage1.getText(), weigh_kg8.getText(), kg_1);
        update_kg_prep(percentage2.getText(), weigh_kg8.getText(), kg_2);
        update_kg_prep(percentage3.getText(), weigh_kg8.getText(), kg_3);
    }//GEN-LAST:event_weigh_kg8KeyReleased

    private void percentage5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage5KeyReleased
        // TODO add your handling code here:
        check_this_textbox(percentage5);
        update_kg_prep(percentage5.getText(), weigh_kg8.getText(), kg_5);
    }//GEN-LAST:event_percentage5KeyReleased

    private void percentage6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage6KeyReleased
        // TODO add your handling code here:
        check_this_textbox(percentage6);
        update_kg_prep(percentage6.getText(), weigh_kg8.getText(), kg_6);
    }//GEN-LAST:event_percentage6KeyReleased

    private void percentage7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage7KeyReleased
        // TODO add your handling code here:
        check_this_textbox(percentage7);
        update_kg_prep(percentage7.getText(), weigh_kg8.getText(), kg_7);
    }//GEN-LAST:event_percentage7KeyReleased

    private void weigh_kg3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_weigh_kg3KeyReleased
        // TODO add your handling code here:
        check_this_textbox(weigh_kg3);
        update_kg_prep(percentage5.getText(), weigh_kg3.getText(), kg_5);
        update_kg_prep(percentage6.getText(), weigh_kg3.getText(), kg_6);
        update_kg_prep(percentage7.getText(), weigh_kg3.getText(), kg_7);
    }//GEN-LAST:event_weigh_kg3KeyReleased
 
    private void percentage9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage9KeyReleased
        // TODO add your handling code here:
        check_this_textbox(percentage9);
        update_kg_prep(percentage9.getText(), weigh_kg4.getText(), kg_9);
    }//GEN-LAST:event_percentage9KeyReleased

    private void percentage10KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage10KeyReleased
        // TODO add your handling code here:
        check_this_textbox(percentage10);
        update_kg_prep(percentage10.getText(), weigh_kg4.getText(), kg_10);
    }//GEN-LAST:event_percentage10KeyReleased

    private void percentage11KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage11KeyReleased
        // TODO add your handling code here:
        check_this_textbox(percentage11);        
        update_kg_prep(percentage11.getText(), weigh_kg4.getText(), kg_11);
    }//GEN-LAST:event_percentage11KeyReleased

    private void weigh_kg4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_weigh_kg4KeyReleased
        // TODO add your handling code here:
        check_this_textbox(weigh_kg4);
        update_kg_prep(percentage9.getText(), weigh_kg4.getText(), kg_9);
        update_kg_prep(percentage10.getText(), weigh_kg4.getText(), kg_10);
        update_kg_prep(percentage11.getText(), weigh_kg4.getText(), kg_11);
    }//GEN-LAST:event_weigh_kg4KeyReleased

    private void percentage13KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage13KeyReleased
        // TODO add your handling code here:
        check_this_textbox(percentage13);
        update_kg_prep(percentage13.getText(), weigh_kg5.getText(), kg_13);
    }//GEN-LAST:event_percentage13KeyReleased

    private void percentage14KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage14KeyReleased
        // TODO add your handling code here:
        check_this_textbox(percentage14); 
        update_kg_prep(percentage14.getText(), weigh_kg5.getText(), kg_14);
    }//GEN-LAST:event_percentage14KeyReleased

    private void percentage15KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage15KeyReleased
        // TODO add your handling code here:
        check_this_textbox(percentage15);
        update_kg_prep(percentage15.getText(), weigh_kg5.getText(), kg_15);
    }//GEN-LAST:event_percentage15KeyReleased

    private void weigh_kg5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_weigh_kg5KeyReleased
        // TODO add your handling code here:
        check_this_textbox(weigh_kg5);
        update_kg_prep(percentage13.getText(), weigh_kg5.getText(), kg_13);
        update_kg_prep(percentage14.getText(), weigh_kg5.getText(), kg_14);
        update_kg_prep(percentage15.getText(), weigh_kg5.getText(), kg_15);
    }//GEN-LAST:event_weigh_kg5KeyReleased

    private void percentage17KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage17KeyReleased
        // TODO add your handling code here:
        check_this_textbox(percentage17);
        update_kg_prep(percentage17.getText(), weigh_kg6.getText(), kg_17);
    }//GEN-LAST:event_percentage17KeyReleased

    private void percentage18KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage18KeyReleased
        // TODO add your handling code here:
        check_this_textbox(percentage18);
        update_kg_prep(percentage18.getText(), weigh_kg6.getText(), kg_18);
    }//GEN-LAST:event_percentage18KeyReleased

    private void percentage19KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage19KeyReleased
        // TODO add your handling code here:
        check_this_textbox(percentage19);
        update_kg_prep(percentage19.getText(), weigh_kg6.getText(), kg_19);
    }//GEN-LAST:event_percentage19KeyReleased

    private void weigh_kg6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_weigh_kg6KeyReleased
        // TODO add your handling code here:
        check_this_textbox(weigh_kg6);
        update_kg_prep(percentage17.getText(), weigh_kg6.getText(), kg_17);
        update_kg_prep(percentage18.getText(), weigh_kg6.getText(), kg_18);
        update_kg_prep(percentage19.getText(), weigh_kg6.getText(), kg_19);
    }//GEN-LAST:event_weigh_kg6KeyReleased

    private void percentage21KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage21KeyReleased
        // TODO add your handling code here:
        check_this_textbox(percentage21);
        update_kg_prep(percentage21.getText(), weigh_kg7.getText(), kg_21);
    }//GEN-LAST:event_percentage21KeyReleased

    private void percentage22KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage22KeyReleased
        // TODO add your handling code here:
        check_this_textbox(percentage22);
        update_kg_prep(percentage22.getText(), weigh_kg7.getText(), kg_22);
    }//GEN-LAST:event_percentage22KeyReleased

    private void percentage23KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage23KeyReleased
        // TODO add your handling code here:
        check_this_textbox(percentage23);
        update_kg_prep(percentage23.getText(), weigh_kg7.getText(), kg_23);
    }//GEN-LAST:event_percentage23KeyReleased

    private void weigh_kg7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_weigh_kg7KeyReleased
        // TODO add your handling code here:
        check_this_textbox(weigh_kg7);
        update_kg_prep(percentage21.getText(), weigh_kg7.getText(), kg_21);
        update_kg_prep(percentage22.getText(), weigh_kg7.getText(), kg_22);
        update_kg_prep(percentage23.getText(), weigh_kg7.getText(), kg_23);
    }//GEN-LAST:event_weigh_kg7KeyReleased
        
    private void percentage24KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage24KeyReleased
        // TODO add your handling code here:
        check_this_textbox(percentage24);
        update_kg_prep(percentage24.getText(), weigh_kg9.getText(), kg_24);
    }//GEN-LAST:event_percentage24KeyReleased

    private void weigh_kg9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_weigh_kg9KeyReleased
        // TODO add your handling code here:
        check_this_textbox(weigh_kg9);
        update_kg_prep(percentage24.getText(), weigh_kg9.getText(), kg_24);
        update_kg_prep(percentage25.getText(), weigh_kg9.getText(), kg_25);
        update_kg_prep(percentage26.getText(), weigh_kg9.getText(), kg_26);
    }//GEN-LAST:event_weigh_kg9KeyReleased

        
    private void percentage25KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage25KeyReleased
        // TODO add your handling code here:
        check_this_textbox(percentage25);
        update_kg_prep(percentage25.getText(), weigh_kg9.getText(), kg_25);
    }//GEN-LAST:event_percentage25KeyReleased

    private void percentage26KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_percentage26KeyReleased
        // TODO add your handling code here:
        check_this_textbox(percentage26);
        update_kg_prep(percentage26.getText(), weigh_kg9.getText(), kg_26);
    }//GEN-LAST:event_percentage26KeyReleased

    private void coverage7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_coverage7KeyReleased
        // TODO add your handling code here:
        if(coverage7.getText().length()>0)
        {
            if(!use_func.checkText2(coverage7.getText()))
            {
                compute_kg(weigh_kg6, Float.parseFloat(coverage7.getText()));
            }
        }
    }//GEN-LAST:event_coverage7KeyReleased
    /*
    private void fill_list(){
    
        int x=0;
        int total =0;
        list.removeAllElements();
        total = 0;
        while(x <= job_list.size() - 1)
            {
        String combine = x +  "    " + this.job_list.get(x) + "    " + this.customer_list.get(x) + "    " +  this.quantity_list.get(x);
                list.addElement(combine);
                
                total = total + Integer.parseInt(this.quantity_list.get(x).toString());
                x++;
            }
        
        this.jList1.setModel(list);
        this.quantity_total.setText(null);
        this.quantity_total.setText(total + "");
        
    }*/
    private void include(String customer_name){
        
        String job_order = this.job_ord_label.getText() + this.text_job_order.getText();
        if(this.customer_check_box.isSelected())
        {
            customer custom = new customer();       
            custom.setCustomer_name(this.customer_name_text.getText());
            custom.add_new_customer();
            this_list.add_customer_job_quantity_in_list(customer_name_text.getText(), 
                                                        job_order, 
                                                        quantity.getText());
            //customer_list.add(this.customer_name_text.getText());
        }
        else
        {
            this_list.add_customer_job_quantity_in_list(customer_combo_list.getSelectedItem().toString(), 
                    job_order, 
                    quantity.getText());
        }
        //job_list.add(this.job_ord_label.getText() + this.text_job_order.getText());
        //quantity_list.add(this.quantity.getText());
        //refresh Textbox to add items
        this.jList1.setModel(this_list.get_items_in_list());
        this.quantity_total.setText(Integer.toString(this_list.get_quantity_total()));
        
        /*
        if (this.quantity.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Please Enter a quantity!");
        } else {
        customer_list.add(customer_name);
        job_list.add(this.text_job_order.getText());
        quantity_list.add(this.quantity.getText());
                
        fill_list();
        }*/
    }
    
    private void button_include_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_include_customerActionPerformed
        // TODO add your handling code here:
       String job_order_text = this.job_ord_label.getText() + this.text_job_order.getText();
        
       if(this_list.check_if_job_is_good(job_order_text))
       {
           if(this_list.check_this_customer(customer_check_box, customer_combo_list, this.customer_name_text))
           {
               if (this_list.check_if_quantity_is_good(job_order_text))
               {
                   include();
               }    
           }
       }
       
    }//GEN-LAST:event_button_include_customerActionPerformed

    private void include()
    {   
        String job_order = this.job_ord_label.getText() + this.text_job_order.getText();
        if(this.customer_check_box.isSelected())
        {
            customer custom = new customer();       
            custom.setCustomer_name(customer_name_text.getText());
            custom.add_new_customer();
            this_list.add_customer_job_quantity_in_list(customer_name_text.getText(), 
                                                        job_order, 
                                                        quantity.getText());
            //customer_list.add(this.customer_name_text.getText());
        }
        else
        {
            this_list.add_customer_job_quantity_in_list(customer_combo_list.getSelectedItem().toString(), 
                    job_order, 
                    quantity.getText());
        }
        //job_list.add(this.job_ord_label.getText() + this.text_job_order.getText());
        //quantity_list.add(this.quantity.getText());
        //refresh Textbox to add items
        this.jList1.setModel(this_list.get_items_in_list());
        this.quantity_total.setText(Integer.toString(this_list.get_quantity_total()));
    }
    
    private void button_remove_customerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_remove_customerActionPerformed
        // TODO add your handling code here:
        if(jList1.getSelectedIndex() != -1)
        {
            int selected = this.jList1.getSelectedIndex();
            int reply = JOptionPane.showConfirmDialog(null, 
                            "Delete job order :"+this.this_list.getJob_list().get(selected).toString() + "from this design?", 
                            "DELETE?", JOptionPane.YES_NO_OPTION);
        //JOptionPane.showMessageDialog(null,a);
        //JOptionPane.showMessageDialog(null,selected);

            if(reply == JOptionPane.YES_OPTION)
            {
                job_order current_job = new job_order();
                current_job.setJob_id(this.this_list.getJob_list().get(selected).toString());
                current_job.delete_job_order_from_job_id();
                this.this_list.remove_this_item(selected);
                
                this.jList1.setModel(this_list.get_items_in_list());
            }
        }
    }//GEN-LAST:event_button_remove_customerActionPerformed

    private String getFabricStyle()
    {
        if(fabric_check_box.isSelected())
        {
            Unused.fabric_style new_fabric = new Unused.fabric_style();
            new_fabric.setFabric_style(fabric_style.getText().toUpperCase());
            new_fabric.add_fabric_style();
            
            return new_fabric.getFabric_style();
        }
        else
        {
            return fab_style_comb.getSelectedItem().toString();
        }
    }
    
     private production_recipe get_design_details()
    {
        colortextile_class.production_recipe new_design = new colortextile_class.production_recipe(design_name.getText(),
                design_color.getText(),
                getFabricStyle(), 
                use_func.get_date_from_spinner(spinner_date));
        //new_design.setDesign_name(design_name.getText());
        //new_design.setColor_name(design_color.getText());
        //new_design.setFabric_style(getFabricStyle());
        //new_design.setDate(this.get_date_from_spinner());
        
        List<Colorway_screen_link_functions> all_color_screen = this.get_all_colorway_inputs();
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
    
    private List<Colorway_screen_link_functions> get_all_colorway_inputs()
    {
        List<Colorway_screen_link_functions> all_colorway = new ArrayList<>();
        
        for(int interval = 0 ; interval < 7; interval++ )
        {
            Colorway_screen_link_functions this_colorway_screen;
            
            if(interval==0)
            {
                this_colorway_screen = new Colorway_screen_link_functions(colorway_name2.getText(), 
                             Float.parseFloat(binder8.getSelectedItem().toString()),
                             weigh_kg8.getText());
        
                this_colorway_screen.add_screen(get_colorway_details_from_input(name1, percentage1));
                this_colorway_screen.add_screen(get_colorway_details_from_input(name2, percentage2));
                this_colorway_screen.add_screen(get_colorway_details_from_input(name3, percentage3));
        
                all_colorway.add(this_colorway_screen);
            }
            else if(interval==1)
            {
                this_colorway_screen = new Colorway_screen_link_functions(colorway_name3.getText(), 
                             Float.parseFloat(binder3.getSelectedItem().toString()),
                             weigh_kg3.getText());
                
                this_colorway_screen.add_screen(get_colorway_details_from_input(name5, percentage5));
                this_colorway_screen.add_screen(get_colorway_details_from_input(name6, percentage6));
                this_colorway_screen.add_screen(get_colorway_details_from_input(name7, percentage7));
        
                all_colorway.add(this_colorway_screen);
            }
            else if(interval == 2)
            {
                this_colorway_screen = new Colorway_screen_link_functions(colorway_name4.getText(), 
                             Float.parseFloat(binder4.getSelectedItem().toString()),
                             weigh_kg4.getText());
                
                this_colorway_screen.add_screen(get_colorway_details_from_input(name9, percentage9));
                this_colorway_screen.add_screen(get_colorway_details_from_input(name10, percentage10));
                this_colorway_screen.add_screen(get_colorway_details_from_input(name11, percentage11));
        
                all_colorway.add(this_colorway_screen);
            }
            else if(interval == 3)
            {
                this_colorway_screen = new Colorway_screen_link_functions(colorway_name5.getText(), 
                             Float.parseFloat(binder5.getSelectedItem().toString()),
                             weigh_kg5.getText());
                
                this_colorway_screen.add_screen(get_colorway_details_from_input(name13, percentage13));
                this_colorway_screen.add_screen(get_colorway_details_from_input(name14, percentage14));
                this_colorway_screen.add_screen(get_colorway_details_from_input(name15, percentage15));
        
                all_colorway.add(this_colorway_screen);
            }
            else if(interval == 4)
            {
                this_colorway_screen = new Colorway_screen_link_functions(colorway_name6.getText(), 
                             Float.parseFloat(binder6.getSelectedItem().toString()),
                             weigh_kg6.getText());
                
                this_colorway_screen.add_screen(get_colorway_details_from_input(name17, percentage17));
                this_colorway_screen.add_screen(get_colorway_details_from_input(name18, percentage18));
                this_colorway_screen.add_screen(get_colorway_details_from_input(name19, percentage19));
        
                all_colorway.add(this_colorway_screen);
            }
            else if(interval == 5)
            {
             this_colorway_screen = new Colorway_screen_link_functions(colorway_name7.getText(), 
                             Float.parseFloat(binder7.getSelectedItem().toString()),
                             weigh_kg7.getText());
                
                this_colorway_screen.add_screen(get_colorway_details_from_input(name21, percentage21));
                this_colorway_screen.add_screen(get_colorway_details_from_input(name22, percentage22));
                this_colorway_screen.add_screen(get_colorway_details_from_input(name23, percentage23));
        
                all_colorway.add(this_colorway_screen);   
            }
            else if(interval == 6)
            {
                this_colorway_screen = new Colorway_screen_link_functions(colorway_name8.getText(), 
                             Float.parseFloat(binder9.getSelectedItem().toString()),
                             weigh_kg9.getText());
                
                this_colorway_screen.add_screen(get_colorway_details_from_input(name24, percentage24));
                this_colorway_screen.add_screen(get_colorway_details_from_input(name25, percentage25));
                this_colorway_screen.add_screen(get_colorway_details_from_input(name26, percentage26));
        
                all_colorway.add(this_colorway_screen); 
            }
        }
        return all_colorway;
    }
    
    private List<job_order> get_job_details()
    {    
        List<job_order> all_job_orders = new ArrayList<>();
        for (int i = 0; i < this_list.getJob_list().size(); i++) 
        {
            job_order job = new job_order();
            DB_Manager new_conn = new DB_Manager();
            job.setJob_id(this_list.getJob_list().get(i).toString());
            job.setCustomer_name(this_list.getCustomer_list().get(i).toString());
            job.setCustomer_id(new_conn.get_id_customer(this_list.getCustomer_list().get(i).toString()));
            job.setDate(use_func.get_date_from_spinner(spinner_date));
            all_job_orders.add(job);
        }
        return all_job_orders;
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
    
    private Pigment_screen_and_colorway get_colorway_details_from_input(JComboBox pigment_text, JTextField percentageText )
    {
        Pigment_screen_and_colorway this_colorway;
        if(!use_func.checkText2(percentageText.getText()))
        this_colorway = new Pigment_screen_and_colorway(pigment_text.getSelectedItem().toString(), Float.parseFloat(percentageText.getText()));
        else
        this_colorway = new Pigment_screen_and_colorway(pigment_text.getSelectedItem().toString());
        
        return this_colorway;
    }
    
    private void preview_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_preview_butActionPerformed
        // TODO add your handling code here:
        production_recipe prod_recipe = this.get_design_details();
        
        Preview_form this_preview = new Preview_form(prod_recipe);
        this_preview.setVisible(true);
    }//GEN-LAST:event_preview_butActionPerformed

    private void cancel_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_butActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cancel_butActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new ImageCapture("New", web_cams.getSelectedIndex()).setVisible(true); 
        this.web_cam_opened = true;
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        if(this.web_cam_opened)
        {
            //Webcam webcam = Webcam.getWebcams().get(this.web_cams.getSelectedIndex());
            //webcam.close()
            File f = new File("New.jpg");
            System.out.println(f.exists());
            if (f.exists() && f.canRead()) {
                try {
                    jLabel14.setIcon( new ImageIcon(ImageIO.read(f).getScaledInstance(140, 140, java.awt.Image.SCALE_SMOOTH) ) );
                }  catch (IOException e) {
                    e.printStackTrace();
                }
            }
            this.web_cam_opened = false;
        }
        
        if(this.pigment_screen_showed)
        {
        pigment this_pigment = new pigment();
        if(this_pigment.count_all_pigment() != (name1.getItemCount()-1))
            this.registerSelectedItem();
        pigment_screen_showed = false;
        }
    }//GEN-LAST:event_formWindowGainedFocus

    
    
    private void pig11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig11ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
    }//GEN-LAST:event_pig11ActionPerformed

    private void pig12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig12ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
    }//GEN-LAST:event_pig12ActionPerformed

    private void pig13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig13ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
    }//GEN-LAST:event_pig13ActionPerformed

    private void pig14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig14ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
    }//GEN-LAST:event_pig14ActionPerformed

    private void pig15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig15ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
    }//GEN-LAST:event_pig15ActionPerformed

    private void pig16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig16ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
    }//GEN-LAST:event_pig16ActionPerformed

    private void pig17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig17ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
    }//GEN-LAST:event_pig17ActionPerformed

    private void pig18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig18ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
    }//GEN-LAST:event_pig18ActionPerformed

    private void pig19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig19ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
    }//GEN-LAST:event_pig19ActionPerformed

    private void pig20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig20ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
    }//GEN-LAST:event_pig20ActionPerformed

    private void pig21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig21ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
    }//GEN-LAST:event_pig21ActionPerformed

    private void pig22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig22ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
    }//GEN-LAST:event_pig22ActionPerformed

    private void pig23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig23ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
    }//GEN-LAST:event_pig23ActionPerformed

    private void pig24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig24ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
    }//GEN-LAST:event_pig24ActionPerformed

    private void pig25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig25ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
    }//GEN-LAST:event_pig25ActionPerformed

    private void pig26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig26ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
    }//GEN-LAST:event_pig26ActionPerformed

    private void pig27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig27ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
    }//GEN-LAST:event_pig27ActionPerformed

    private void pig28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig28ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
    }//GEN-LAST:event_pig28ActionPerformed

    private void pig29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig29ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
    }//GEN-LAST:event_pig29ActionPerformed

    private void pig30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig30ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
    }//GEN-LAST:event_pig30ActionPerformed

    private void pig31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pig31ActionPerformed
        // TODO add your handling code here:
        show_add_pigment();
    }//GEN-LAST:event_pig31ActionPerformed

    private void show_add_pigment()
    {
        add_pigment_form add_pigment = new add_pigment_form();
        add_pigment.setVisible(true);
        this.pigment_screen_showed = true;
    }
    
    private void compute_kg(JTextField weigh_kg, float coverage)
    {
        if(!quantity_total.getBackground().equals(Color.pink) && quantity_total.getText().length()>0)
        {
            Recipe_functions use_func = new Recipe_functions();
            float this_computation;
            if(this.fabric_check_box.isSelected())
            {
               this_computation = use_func.compute_this_kg(coverage, fabric_style.getText(), quantity_total.getText());
            }
            else{
               this_computation = use_func.compute_this_kg(coverage, fab_style_comb.getSelectedItem().toString(),quantity_total.getText());
            }
                weigh_kg.setText(String.format("%.0f", this_computation));
        }
    }
    
    private void update_kg_prep(String percentage_text, String weight_kg , JTextField this_textfield)
    {
        if(percentage_text.length()>0 && weight_kg.length()>0)
        {
            if(!use_func.checkText2(weight_kg) && !use_func.checkText2(percentage_text))
            {
                try
                {            
                    float temp_percentage = Float.parseFloat(percentage_text);
                    float temp_weight = Float.parseFloat(weight_kg);
                    float weight_prep = temp_weight * temp_percentage / 100;
                    //Make this 2 Decimal digits
                    this_textfield.setText(String.format("%.2f", weight_prep));
                }
                catch(NumberFormatException ex)
                {
                    this_textfield.setText("Error!");
                }
            }
            else
            {
                this_textfield.setText("Error!");
            }
        }
    }
    
    private boolean check_this_textbox(JTextField the_textfield)
    {
        boolean text_check = use_func.checkText2(the_textfield.getText());
        if(text_check)
        {
            if(!the_textfield.getBackground().equals(Color.pink) )
            {
                the_textfield.setBackground(Color.pink);
                count_screen_1++;
            }
        }
        else
        {
            if(the_textfield.getBackground().equals(Color.pink))
            {
                the_textfield.setBackground(Color.white);           
                count_screen_1--;
            }
        }
            
        if(count_screen_1 > 0)
        {
            save_edit_but.setEnabled(false);
            return false;
        }
        else
            save_edit_but.setEnabled(true);
        return true;
    }
    
    public void addBlankSpace()
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
    public void addListItems()
    {
        colortextile_class.pigment list_pigment = new colortextile_class.pigment();
        ArrayList<String> pigment_list = list_pigment.get_all_pigment_name();
        addBlankSpace();
        for(int temp_i = 0; temp_i < pigment_list.size(); temp_i++)
        {
            name1.addItem(pigment_list.get(temp_i));
            name2.addItem(pigment_list.get(temp_i));
            name3.addItem(pigment_list.get(temp_i));
            name5.addItem(pigment_list.get(temp_i));
            name6.addItem(pigment_list.get(temp_i));
            name7.addItem(pigment_list.get(temp_i));
            name9.addItem(pigment_list.get(temp_i));
            name10.addItem(pigment_list.get(temp_i));
            name11.addItem(pigment_list.get(temp_i));
            name13.addItem(pigment_list.get(temp_i));
            name14.addItem(pigment_list.get(temp_i));
            name15.addItem(pigment_list.get(temp_i));
            name17.addItem(pigment_list.get(temp_i));
            name18.addItem(pigment_list.get(temp_i));
            name19.addItem(pigment_list.get(temp_i));
            name21.addItem(pigment_list.get(temp_i));
            name22.addItem(pigment_list.get(temp_i));
            name23.addItem(pigment_list.get(temp_i));
            name24.addItem(pigment_list.get(temp_i));
            name25.addItem(pigment_list.get(temp_i));
            name26.addItem(pigment_list.get(temp_i));
        }
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
            java.util.logging.Logger.getLogger(EditRecipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditRecipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditRecipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditRecipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EditRecipe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox binder3;
    private javax.swing.JComboBox binder4;
    private javax.swing.JComboBox binder5;
    private javax.swing.JComboBox binder6;
    private javax.swing.JComboBox binder7;
    private javax.swing.JComboBox binder8;
    private javax.swing.JComboBox binder9;
    private javax.swing.JButton button_include_customer;
    private javax.swing.JButton button_remove_customer;
    private javax.swing.JButton cancel_but;
    private javax.swing.JTextField colorway_name2;
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
    private javax.swing.JTextField coverage7;
    private javax.swing.JCheckBox customer_check_box;
    private javax.swing.JComboBox customer_combo_list;
    private javax.swing.JTextField customer_name_text;
    private javax.swing.JTextField design_color;
    private javax.swing.JTextField design_name;
    private javax.swing.JComboBox fab_style_comb;
    private javax.swing.JCheckBox fabric_check_box;
    private javax.swing.JTextField fabric_style;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
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
    private javax.swing.JButton pig14;
    private javax.swing.JButton pig15;
    private javax.swing.JButton pig16;
    private javax.swing.JButton pig17;
    private javax.swing.JButton pig18;
    private javax.swing.JButton pig19;
    private javax.swing.JButton pig20;
    private javax.swing.JButton pig21;
    private javax.swing.JButton pig22;
    private javax.swing.JButton pig23;
    private javax.swing.JButton pig24;
    private javax.swing.JButton pig25;
    private javax.swing.JButton pig26;
    private javax.swing.JButton pig27;
    private javax.swing.JButton pig28;
    private javax.swing.JButton pig29;
    private javax.swing.JButton pig30;
    private javax.swing.JButton pig31;
    private javax.swing.JButton preview_but;
    private javax.swing.JTextField quantity;
    private javax.swing.JTextField quantity_total;
    private javax.swing.JButton save_edit_but;
    private javax.swing.JSpinner spinner_date;
    private javax.swing.JTextField text_job_order;
    private javax.swing.JComboBox web_cams;
    private javax.swing.JTextField weigh_kg3;
    private javax.swing.JTextField weigh_kg4;
    private javax.swing.JTextField weigh_kg5;
    private javax.swing.JTextField weigh_kg6;
    private javax.swing.JTextField weigh_kg7;
    private javax.swing.JTextField weigh_kg8;
    private javax.swing.JTextField weigh_kg9;
    // End of variables declaration//GEN-END:variables

    
}
