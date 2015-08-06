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
import java.util.regex.Pattern;
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
    
    public float normalize_to_onek_kilo()
    {
        return 0;
    }
    
    public float recompute_to_total_quantity()
    {
        return 0;
    }
    
    public float compute_this_coverage(float kg, String fabric_style, String quantity_total)
    {
        float computation = 0;
        float this_quant = Float.parseFloat(quantity_total);
        if(fabric_style.equals("PONGEE"))
        {
            computation = (kg*1000/this_quant)*10/8;
        }
        else if(fabric_style.equals("COTTON") || fabric_style.equals("KATUNIA"))
        {
            computation = (kg*1000/this_quant)*10/12;
        }
        else if (fabric_style.equals("MICROPEACH") || fabric_style.equals("TC") || fabric_style.equals("TROPICANA"))
        {
            computation = (kg*1000/this_quant);
        }
        
        return computation;
    }
    
    public float compute_this_kg(float coverage, String fabric_style, String quantity_total)
    {
        float computation = 0;
        
        if(fabric_style.equals("PONGEE")){
        
            float this_quant = Float.parseFloat(quantity_total);
            computation = (8*coverage/10*this_quant)/1000;
        }
        else if(fabric_style.equals("COTTON") || fabric_style.equals("KATUNIA"))
        {
            float this_quant = Float.parseFloat(quantity_total);
            computation = (12*coverage/10*this_quant)/1000;
        }
        else if (fabric_style.equals("MICROPEACH") || fabric_style.equals("TC") || fabric_style.equals("TROPICANA"))
        {
            float this_quant = Float.parseFloat(quantity_total);
            computation = (10*coverage/10*this_quant)/1000;
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
    
    public String change_job_order_prefix(JSpinner this_date_spinner)
    {
        String spinnerValue = this.get_date_from_spinner(this_date_spinner);
        
        String Year = spinnerValue.substring(2, 4);
        String Month = spinnerValue.substring(5,7);
        
        return Year+ "P-" + Month + "-";
    }
    
    public void update_kg_prep(String percentage_text, String weight_kg , JTextField this_textfield)
    {
        if(percentage_text.length()>0 && weight_kg.length()>0)
        {
            if(!this.checkText2(weight_kg) && !this.checkText2(percentage_text))
            {      
                    //float temp_percentage = Float.parseFloat(percentage_text);
                    //float temp_weight = Float.parseFloat(weight_kg);
                    float weight_prep = this.update_kg_and_prep(percentage_text, weight_kg);
                    //Make this 2 Decimal digits
                    if(weight_prep < 0.01)
                    {   
                        //this_textfield.setText(Float.toString( (float) next_weight/1000));
                        this_textfield.setText(String.format("%.3f", (float) Math.round(weight_prep* 1000)/1000));
                    }
                    else
                        //this_textfield.setText(Float.toString((Math.floor(weight_prep* 100)/100));
                        this_textfield.setText(String.format("%.2f", Math.floor(weight_prep* 100)/100));
            }
            else
            {
                this_textfield.setText("Error!");
            }
        }
    }
    /*
    private String get_date_from_spinner()
    {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
        String spinnerValue = formater.format(this.spinner_date.getValue());
        return spinnerValue;
    }
    */
    
    public boolean checkText2(String this_text)
    {
        if(this_text.isEmpty())
            return true;
        String regex = "[^0-9]";
        Pattern p = Pattern.compile(regex);
        this_text = this_text.replaceFirst("[.]", "");
        
        return p.matcher(this_text).find();
    }
    
    public boolean check_this_textbox(JTextField the_textfield)
    {
        if(checkText2(the_textfield.getText()))
        { 
            //this.text_job_order.setText(text_job_order.getText().substring(0, 3));
            the_textfield.setText(the_textfield.getText().replaceAll("[^0-9]", ""));
            
            //if(!the_textfield.getBackground().equals(Color.pink) )
            //{
            //    the_textfield.setBackground(Color.pink);
            //    count_screen_1++;
            //}
            //check_screen();
            return false;
        }
        return true;
        //else
        //{
        //    if(the_textfield.getBackground().equals(Color.pink))
        //    {
        //        the_textfield.setBackground(Color.white);           
        //        count_screen_1--;
        //    }
        //    check_screen();
        //    return true;
        //}
    }
    
    public void check_and_add_new_fabrics(JComboBox fabric_style)
    {
        if(new design().count_all_fabric_style() != fabric_style.getItemCount()-4)
            {
                fabric_style.removeAllItems();
                fabric_style.addItem("PONGEE");
                fabric_style.addItem("COTTON");
                fabric_style.addItem("KATUNIA");
                fabric_style.addItem("MICROPEACH");
                fabric_style.addItem("TC");
                fabric_style.addItem("TROPICANA");
                
                for(String this_fabric : new design().get_all_fabric_styles())
                {
                    fabric_style.addItem(this_fabric);
                }
            }
    }
    
    
    
    
}
