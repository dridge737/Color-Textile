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
    private String date;
    private String date_from;
    private String date_to;
    private int quantity;
    private String fabric_style;
    private int customer_id;
    private String design_code;
    private ResultSet job_order_resultset;

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
     * @return the fabric_style
     */
    public String getFabric_style() {
        return fabric_style;
    }

    /**
     * @param fabric_style the fabric_style to set
     */
    public void setFabric_style(String fabric_style) {
        this.fabric_style = fabric_style;
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

    /**
     * @return the design_code
     */
    public String getDesign_code() {
        return design_code;
    }

    /**
     * @param design_code the design_code to set
     */
    public void setDesign_code(String design_code) {
        this.design_code = design_code;
    }
    
    public void add_new_job_order()
    {
        DB_Manager new_conn = new DB_Manager();
        new_conn.add_job_order(this);
    }
    
    public void search_job_order()
    {
        DB_Manager new_conn = new DB_Manager();
        this.setJob_order_resultset(new_conn.Search_Job_Order(this));
        
    }
    
    public void job_order_all()
    {
        DB_Manager new_conn = new DB_Manager();
        this.setJob_order_resultset(new_conn.get_all_job_order(this));
    }

    /**
     * @return the date_from
     */
    public String getDate_from() {
        return date_from;
    }

    /**
     * @param date_from the date_from to set
     */
    public void setDate_from(String date_from) {
        this.date_from = date_from;
    }

    /**
     * @return the date_to
     */
    public String getDate_to() {
        return date_to;
    }

    /**
     * @param date_to the date_to to set
     */
    public void setDate_to(String date_to) {
        this.date_to = date_to;
    }

    /**
     * @return the job_order_resultset
     */
    public ResultSet getJob_order_resultset() {
        return job_order_resultset;
    }

    /**
     * @param job_order_resultset the job_order_resultset to set
     */
    public void setJob_order_resultset(ResultSet job_order_resultset) {
        this.job_order_resultset = job_order_resultset;
    }
    
    public void set_details_from_job_order_id()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        //new_conn
    }



  
    
    
    
}
