/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package colortextile_class;

import Database.DB_Manager;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Winston
 */
public class job_order extends customer {
    //Table Elements
    private String job_id;
    private String date;
    private int customer_id;
    private ResultSet job_order_resultset;

    public job_order(){}
    public job_order(String job_order_id)
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        job_order details = new_conn.get_job_order_details(job_order_id);
        this.job_id = job_order_id;
        //this.date = details.date;
        //this.design_code = details.design_code;
        //this.fabric_style = details.fabric_style;
    }
    
    public boolean set_job_order_details_if_available()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        if(new_conn.check_if_job_order_exists(this) == 1)
        {
            job_order temporary_job = new_conn.get_job_order_details(this.job_id);
            this.customer_id = temporary_job.getCustomer_id();
            this.date = temporary_job.getDate();
            this.setCustomer_name(temporary_job.getCustomer_name());
            return true;
        }
        return false;
        
    }
    /**
     * @return the job_id
     */
    public String getJob_id() {
        return job_id;
    }

    /**
     * @param job_id the job_id to set
     */
    public void setJob_id(String job_id) {
        this.job_id = job_id;
    }
 
     /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the customer_id
     */
    public int getCustomer_id() {
        return customer_id;
    }

    /**
     * @param customer_id the customer_id to set
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public boolean add_new_job_order()
    {
        DB_Manager new_conn = new DB_Manager();
        if(!this.check_if_job_exists())
        return new_conn.add_job_order(this);
        
        return false;
    }
    
    public ResultSet job_order_all()
    {
        DB_Manager new_conn = new DB_Manager();
        return new_conn.get_all_job_order(this);
    }

    public void get_job_order_list()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
    }

    public boolean check_job_id(String JobId){
        this.setJob_id(JobId);
        DB_Manager new_conn = new DB_Manager();
        return new_conn.Search_job_id(this);
    }
    /**
     * Checks if the Job_order_Id has already been added in the database (NOT USED)
     * @return 
     */
    public boolean check_if_job_exists()
    {
        DB_Manager new_conn = new DB_Manager();
        if(new_conn.check_if_job_order_exists(this)== 1)
        return true;
        
        return false;
    }
    
    public ResultSet Search_job_info(){
       
        DB_Manager new_conn = new DB_Manager();
        return new_conn.Search_Job_Order(this);
    }
    
    public void delete_job_order_from_job_id()
    {
        DB_Manager new_conn = new DB_Manager();
        new_conn.delete_job_order(this);
    }
    
    public void check_and_delete_if_job_id_not_used()
    {
        DB_Manager new_conn = new DB_Manager();
        if(new_conn.count_job_order_usage(job_id) <=1)
            delete_job_order_from_job_id();
    }
    
    public void display_details()
    {
        System.out.println("Job Order ID  : "+this.getJob_id());
        System.out.println("Customer ID   : "+this.getCustomer_id());
        System.out.println("Customer Name : "+this.getCustomer_name());
        System.out.println("Date          : "+this.getDate());
            
    }
    
    public void update_job_order_using_job_id()
    {
        DB_Manager new_conn = new DB_Manager();
        new_conn.update_job_order(this);
    }
        
}
