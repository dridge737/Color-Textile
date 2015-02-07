/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colortextile_class;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eldridge
 */
public class Job_purchase_link_functions extends job_order{
    
    private List<purchase_order> all_purchase = new ArrayList<>();
    
    //For job_order get job_order_list using purchase order
    //Using the purchase_order_id the job_order_list is taken
    
   
    

    /**
     * @return the new_des_col_link
     */
    public Design_colorway_link_functions getNew_des_col_link() {
        return new_des_col_link;
    }

    /**
     * @param new_des_col_link the new_des_col_link to set
     */
    public void setNew_des_col_link(Design_colorway_link_functions new_des_col_link) {
        this.new_des_col_link = new_des_col_link;
    }
   
    public String get_all_quantity()
    {
        String quantity_all = "";
        for(int x = 0 ; x < all_purchase.size(); x++)
        {
            if(x == all_purchase.size()-1)
                quantity_all += Integer.toString(all_purchase.get(x).getQuantity());
            else
                quantity_all += Integer.toString(all_purchase.get(x).getQuantity()) + "+";
                
        }
        return quantity_all;
    }
    public int get_quantity_sum()
    {
        int quantity_sum = 0;
        for(int x = 0 ; x < all_purchase.size(); x++)
        {
            quantity_sum += all_purchase.get(x).getQuantity();
        }
        //System.out.println(quantity_sum);
        return quantity_sum;
    }
    
    
    public String get_all_customers()
    {
        String all_customers = "";
        //System.out.println("Number of customers is = "+jobs_for_this.size());
        for(int x = 0 ; x < jobs_for_this.size(); x++)
        {
            //System.out.println("Customer name = " +jobs_for_this.get(x).getCustomer_name());
            if(x == (jobs_for_this.size()-1))
                all_customers += jobs_for_this.get(x).getCustomer_name();
            else
                all_customers += jobs_for_this.get(x).getCustomer_name() + ", ";
                
        }
        return all_customers;
    }
    
    public String get_all_job_id()
    {
        String all_job_order_id = "";
        for(int x = 0 ; x < jobs_for_this.size(); x++)
        {
            if(x == (jobs_for_this.size()-1))
                all_job_order_id += jobs_for_this.get(x).getJob_id();
            else
                all_job_order_id += jobs_for_this.get(x).getJob_id() + ", ";
        }
        //System.out.println(all_job_order_id);
        return all_job_order_id;
    }
    
}
