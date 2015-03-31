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
public class production_recipe extends Design_and_colorway{
    
     private String Date;
     private List<job_order> jobs_for_this = new ArrayList<>();
     private List<purchase_order> all_purchase = new ArrayList<>();
     
     public production_recipe(){}
     
     public production_recipe(String design, String color, String fabric, String set_date)
     {
         super(design,color,fabric);
         this.Date = set_date;
     }
     public void set_job_order_list_using_date_and_design_code()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        //GET all the job_order_id from the Date and design_code
        //purchase_order = new_conn.get_all_purchase_details_from_date_and_design(Date, design_code);
        
        //new_conn.get_all_job_order_from_date_and_design(Date, design_code);
        //Get the List of job order from the purchase order id
        //setJobs_for_this(new_conn.set_job_order_info_from_purchase_id(this.getId_purchase()));
    }
    
    public void view_all_job_order_details(){
        System.out.println("Size of this job is = "+jobs_for_this.size());
        for(job_order all_jobs : jobs_for_this)
        {
            System.out.println("Job Order ID  : "+all_jobs.getJob_id());
            System.out.println("Customer ID   : "+all_jobs.getCustomer_id());
            System.out.println("Customer Name : "+all_jobs.getCustomer_name());
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
        //set_customer_name_for_jobs();
    }
    
    public void set_customer_name_for_jobs(){
        for(int x = 0; x < jobs_for_this.size(); x++ )
             jobs_for_this.get(x).set_customer_name_from_id();
    }
    
    public String get_all_customers()
    {
        String all_customers = "";
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

    /**
     * @return the Date
     */
    public String getDate() {
        return Date;
    }

    /**
     * @param Date the Date to set
     */
    public void setDate(String Date) {
        this.Date = Date;
    }
    
    public void add_all_purchase_order()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        setAll_purchase(new_conn.get_all_purchase_for_this_job_order(this.jobs_for_this.get(0)));
    }
    
    public void view_all_puchase_order()
     {
        for (purchase_order all_purchase1 : getAll_purchase()) {
            System.out.println("Purchase id = " + all_purchase1.getId_purchase());
            System.out.println("Job Order = " + all_purchase1.getJob_order_id());
            System.out.println("Design code= " + all_purchase1.getDesign_code());
            System.out.println("Quantity = " + all_purchase1.getQuantity());
        }
     }
    
    /***
     * Gets all the quantity in a string ex: 143 +153 +245 =
     * @return 
     */
    public String get_all_quantity()
    {
        String quantity_all = "";
        for(int x = 0 ; x < getAll_purchase().size(); x++)
        {
            if(x == getAll_purchase().size()-1)
                quantity_all += Integer.toString(getAll_purchase().get(x).getQuantity());
            else
                quantity_all += Integer.toString(getAll_purchase().get(x).getQuantity()) + " +";
                
        }
        quantity_all += "= ";
        return quantity_all;
    }
    
    public int get_quantity_sum()
    {
        int quantity_sum = 0;
        for(int x = 0 ; x < getAll_purchase().size(); x++)
        {
            quantity_sum += getAll_purchase().get(x).getQuantity();
        }
        //System.out.println(quantity_sum);
        return quantity_sum;
    }

    /**
     * @return the all_purchase
     */
    public List<purchase_order> getAll_purchase() {
        return all_purchase;
    }

    /**
     * @param all_purchase the all_purchase to set
     */
    public void setAll_purchase(List<purchase_order> all_purchase) {
        this.all_purchase = all_purchase;
    }
    
    /**
     * Set 
     */
    public void set_design_details_from_design_code()
    {
        this.setDesign_details_from_des_code();
        this.add_all_colorway_from_design_code();
    }
    
    
    
}
