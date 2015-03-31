/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colortextile_class;

import colortextile_form.add_pigment_form;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
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
    
    public String get_date_from_spinner(JSpinner this_spinner)
    {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
        return formater.format(this_spinner.getValue());
    }
    
    /*
    private String get_date_from_spinner()
    {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
        String spinnerValue = formater.format(this.spinner_date.getValue());
        return spinnerValue;
    }
    */
}
