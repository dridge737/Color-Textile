/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colortextile_class;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eldridge
 */
public class production_recipe {
     private List<Job_purchase_link_functions> jobs_for_this = new ArrayList<>();
     
     
     public void set_job_order_list_using_job_order_and_design_code()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        //Get the List of job order from the purchase order id
        //setJobs_for_this(new_conn.set_job_order_info_from_purchase_id(this.getId_purchase()));
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
    public List<Job_purchase_link_functions> getJobs_for_this() {
        return jobs_for_this;
    }

    /**
     * @param jobs_for_this the jobs_for_this to set
     */
    public void setJobs_for_this(List<Job_purchase_link_functions> jobs_for_this) {
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
}