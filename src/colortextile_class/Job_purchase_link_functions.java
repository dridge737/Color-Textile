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
   
    //Add all designs purchased from this job order
    public void add_all_purchase_order()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        all_purchase = new_conn.get_all_purchase_for_this_job_order(this);
    }
    
    public void view_all_puchase_order()
     {
         
        for (purchase_order all_purchase1 : all_purchase) {
            System.out.println("Purchase id = " + all_purchase1.getId_purchase());
            System.out.println("Job Order = " + all_purchase1.getJob_order_id());
            System.out.println("Design code= " + all_purchase1.getDesign_code());
            System.out.println("Quantity = " + all_purchase1.getQuantity());
        }
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
    
    
    
}
