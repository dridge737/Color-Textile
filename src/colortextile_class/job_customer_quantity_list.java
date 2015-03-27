/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colortextile_class;

import java.util.ArrayList;

/**
 *
 * @author Eldridge
 */
public class job_customer_quantity_list {
    private ArrayList quantity_list = new ArrayList();
    private ArrayList job_list = new ArrayList();
    private ArrayList customer_list = new ArrayList();
    private int total = 0;
    
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
    
    public String get_quantity_total()
    {
        total = total + Integer.parseInt(this.quantity_list.get(x).toString());
    }

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
