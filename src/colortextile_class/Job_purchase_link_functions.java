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
    public void set_job_order_list_using_purchase_order_id()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        //Get the List of job order from the purchase order id
        setJobs_for_this(new_conn.set_job_order_info_from_purchase_id(this.getId_purchase()));
        
    }
    
    
    
    public void view_all_job_order_details()
    {
        System.out.println("Size of this job is = "+jobs_for_this.size());
        for(job_order all_jobs : jobs_for_this)
        {
            System.out.println("Job Order ID  : "+all_jobs.getJob_id());
            System.out.println("Customer ID   : "+all_jobs.getCustomer_id());
            System.out.println("Customer Name : "+all_jobs.getCustomer_name());
            //System.out.println("Quantity      : "+all_jobs.getQuantity());
        }
    }
   
    /**
     * @return the jobs_for_this
     */
    public List<job_order> getJobs_for_this() {
        return jobs_for_this;
    }

    /**
     * @param jobs_for_this the jobs_for_this to set
     */
    public void setJobs_for_this(List<job_order> jobs_for_this) {
        this.jobs_for_this = jobs_for_this;
        set_customer_name_for_jobs();

        
    }
    
    public void set_customer_name_for_jobs()
    {
        for(int x = 0; x < jobs_for_this.size(); x++ )
        {
             jobs_for_this.get(x).set_customer_name_from_id();
        }
    }

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
        for(int x = 0 ; x < jobs_for_this.size(); x++)
        {
            if(x == jobs_for_this.size()-1)
                quantity_all += Integer.toString(jobs_for_this.get(x).getQuantity());
            else
                quantity_all += Integer.toString(jobs_for_this.get(x).getQuantity()) + "+";
                
        }
        return quantity_all;
    }
    public int get_quantity_sum()
    {
        int quantity_sum = 0;
        for(int x = 0 ; x < jobs_for_this.size(); x++)
        {
            quantity_sum += jobs_for_this.get(x).getQuantity();
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
