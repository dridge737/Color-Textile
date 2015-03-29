/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colortextile_class;

import colortextile_form.add_pigment_form;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Eldridge
 */
public class Recipe_functions {
    
    public float compute_this_kg(float coverage, String fabric_style, String quantity_total)
    {
        float computation = 0;
        
        if(fabric_style.equals("PONGEE")){
        
            float this_quant = Float.parseFloat(quantity_total);
            computation = Math.round((80*coverage/100*this_quant)/1000);
        }
        else if(fabric_style.equals("COTTON") || fabric_style.equals("KATUNIA"))
        {
            float this_quant = Float.parseFloat(quantity_total);
            computation = Math.round((120*coverage/100*this_quant)/1000);
        }
        else if (fabric_style.equals("MICROPEACH") || fabric_style.equals("TC") || fabric_style.equals("TROPICANA"))
        {
            float this_quant = Float.parseFloat(quantity_total);
            computation = Math.round((100*coverage/100*this_quant)/1000);
        }
        return computation;
    }
    
    public float update_kg_and_prep(String percentage_text, String weight_kg)
    {
        try
        {
            float temp_percentage = Float.parseFloat(percentage_text);
            float temp_weight = Float.parseFloat(weight_kg);
            float weight_prep = temp_weight * temp_percentage / 100;
            return weight_prep;
        }
        catch(NumberFormatException ex)
        {
            return -1;
        }   
    }
    public void show_add_pigment()
    {
        add_pigment_form add_pigment = new add_pigment_form();
        add_pigment.setVisible(true);
    }
    
    public boolean check_if_job_is_good(String job_order_text, ArrayList job_list)
    {
        boolean duplicate = false;
        
        //job_order this_job_order = new job_order();
        //this_job_order.setJob_id(job_order_text);
        /*
        if(this_job_order.check_if_job_exists())
        {
            JOptionPane.showMessageDialog(null,"Job order number has been already added before!");
            duplicate = true;
        }
        else
        {*/
            if (job_order_text.length() != 11)
            {
                JOptionPane.showMessageDialog(null,"Please input 4 job order number!");
                duplicate = true;
            } 
            else {
                // check job order if existing
                for (int j = 0; j < job_list.size(); j++ ){
                    if (job_list.get(j).toString().trim().equals(job_order_text))
                        duplicate = true;
                }
                if( duplicate == true){
                    JOptionPane.showMessageDialog(null,"Job Order ID already Exists");
                }
            }
        
        return !duplicate;
    }
    
    public boolean check_customer_if_is_in_database_and_has_text(String text_name)
    {
        boolean good_customer = true;
        
            if (text_name.trim().length() == 0)
            {
                JOptionPane.showMessageDialog(null,"Please Type a Name!");
                good_customer = false;
            }
            else
            {
                customer custom = new customer();       
                custom.setCustomer_name(text_name);
                
                if(custom.check_if_this_customer_exists())
                {
                    JOptionPane.showMessageDialog(null,"Customer Name already Exists");
                    good_customer = false;
                }
            }
        
        return good_customer;
    }
    
    public boolean check_this_customer(JCheckBox jCheckBox1, JComboBox combo_name, JTextField customer_name_text)
    {
        if(jCheckBox1.isSelected())
        {
            return this.check_customer_if_is_in_database_and_has_text(customer_name_text.getText());
        }
        else
        {
            if (combo_name.getSelectedItem().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please Select a Customer!");
                return false;
            }
        }
        return true;
    }
 
    public boolean check_if_quantity_is_good(String quantity)
    {   boolean quantity_check = true;
        if (quantity.trim().equals(""))
        {
                JOptionPane.showMessageDialog(null,"Please Enter a quantity!");
                quantity_check = false;
        }
        return quantity_check;    
    }
}
