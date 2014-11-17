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
public class job_order {
    private String job_id;
    //private String date;
    private int quantity;
    private int customer_id;
    private int id_purchase;
    private ResultSet job_order_resultset;

    public void job_order(String job_order_id)
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        job_order details = new_conn.get_job_order_details(job_order_id);
        this.job_id = job_order_id;
        //this.date = details.date;
        //this.design_code = details.design_code;
        //this.fabric_style = details.fabric_style;
        
    }
    
    public job_order get_details(String job_order_id)
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        return new_conn.get_job_order_details(job_order_id);
        
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
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public void add_new_job_order()
    {
        DB_Manager new_conn = new DB_Manager();
        new_conn.add_job_order(this);
    }
    
    
    
    public ResultSet job_order_all()
    {
        DB_Manager new_conn = new DB_Manager();
        return new_conn.get_all_job_order(this);
    }

    
    
    public void set_details_from_job_order_id()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        // = new_conn.get_job_order_details(job_id); 
    }

    /**
     * @return the id_purchase
     */
    public int getId_purchase() {
        return id_purchase;
    }

    /**
     * @param id_purchase the id_purchase to set
     */
    public void setId_purchase(int id_purchase) {
        this.id_purchase = id_purchase;
    }
    
    public String check_job_id(String JobId){
        this.setJob_id(JobId);
        DB_Manager new_conn = new DB_Manager();
        return new_conn.Search_job_id(this);
        
        
    }


  
    
    
    
}
