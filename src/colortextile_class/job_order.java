/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package colortextile_class;

import Database.DB_Manager;
import java.util.Date;

/**
 *
 * @author Winston
 */
public class job_order {
    private String job_id;
    private Date date;
    private int quantity;
    private String fabric_style;
    private int customer_id;
    private String design_code;

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
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
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

  
    
    
    
}
