/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colortextile_class;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Eldridge
 */
public class job_customer_quantity_list {
    private ArrayList quantity_list = new ArrayList();
    private ArrayList job_list = new ArrayList();
    private ArrayList customer_list = new ArrayList();
    
    public void add_customer_job_quantity_in_list(String customer_name, String job_order, String quantity)
    {
        customer_list.add(customer_name);
        job_list.add(job_order);
        quantity_list.add(quantity);
    }
    
    public String get_quant_job_customer_in_index(int x)
    {
        String combine = (x+1) +  "    " + 
                this.job_list.get(x) + "    " + 
                this.customer_list.get(x) + "    " +  
                this.quantity_list.get(x);
        
        return combine;
    }
    
    public int get_quantity_total()
    {
        int total = 0;
        for(int x = 0; x<quantity_list.size(); x++)
        {
            total +=Integer.parseInt(quantity_list.get(x).toString());
        }
        return total;
    }
    
    public void clear_all_items()
    {
        quantity_list.clear();
        job_list.clear();
        customer_list.clear();
    }
    
    public DefaultListModel get_items_in_list()
    {
        DefaultListModel list = new DefaultListModel();
        for(int x = 0; x < this.getJob_list().size(); x++)
        {
            //String combine = (x+1) +  "    " + 
            //    this.job_list.get(x) + "    " + 
            //    this.customer_list.get(x) + "    " +  
            //    this.quantity_list.get(x);
            list.addElement(this.get_quant_job_customer_in_index(x));
        }
        return list;
    }
    
    public DefaultListModel remove_this_item(int index)
    {
        quantity_list.remove(index);
        job_list.remove(index);
        customer_list.remove(index);
        return get_items_in_list();
    }
    
    public boolean check_if_job_is_good(String job_order_text)
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
    
        /*
    private void fill_list()
    {
        int x = 0;
        int total = 0;
        list.removeAllElements();
        
        while(x <= this.this_list.getJob_list().size() - 1)
        {
            //String combine = (x+1) +  "    " + 
            //    this.job_list.get(x) + "    " + 
            //    this.customer_list.get(x) + "    " +  
            //    this.quantity_list.get(x);
            
            list.addElement(this_list.get_quant_job_customer_in_index(x));
            
            x++;
        }
        this.jList1.setModel(list);
        //this.quantity_total.setText(null);
        this.quantity_total.setText(Integer.toString(this_list.get_quantity_total()));
    }
*/

    /**
     * @return the quantity_list
     */
    public ArrayList getQuantity_list() {
        return quantity_list;
    }

    /**
     * @param quantity_list the quantity_list to set
     */
    public void setQuantity_list(ArrayList quantity_list) {
        this.quantity_list = quantity_list;
    }

    /**
     * @return the job_list
     */
    public ArrayList getJob_list() {
        return job_list;
    }

    /**
     * @param job_list the job_list to set
     */
    public void setJob_list(ArrayList job_list) {
        this.job_list = job_list;
    }

    /**
     * @return the customer_list
     */
    public ArrayList getCustomer_list() {
        return customer_list;
    }

    /**
     * @param customer_list the customer_list to set
     */
    public void setCustomer_list(ArrayList customer_list) {
        this.customer_list = customer_list;
    }
}
