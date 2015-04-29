/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colortextile_class;

import Database.DB_Manager;
import java.sql.ResultSet;

/**
 *
 * @author Eldridge
 */
public class purchase_order {
    private int id_purchase;
    private int design_code;
    private String job_order_id;
    private int quantity;
    
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
    
    /**
     * @return the design_code
     */
    public int getDesign_code() {
        return design_code;
    }

    /**
     * @param design_code the design_code to set
     */
    public void setDesign_code(int design_code) {
        this.design_code = design_code;
    }
    
    /**
     * @return the job_order_id
     */
    public String getJob_order_id() {
        return job_order_id;
    }

    /**
     * @param job_order_id the job_order_id to set
     */
    public void setJob_order_id(String job_order_id) {
        this.job_order_id = job_order_id;
    }

    public boolean add_new_purchase()
    {
        DB_Manager new_conn = new DB_Manager();
         return new_conn.add_purchase_order(this);
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
    
    public ResultSet Search_purchase_info(){
        DB_Manager new_conn = new DB_Manager();
       return new_conn.Search_id_purchase(this);
    }

    public int getPurchase_Id_Last(){
        DB_Manager new_conn = new DB_Manager();
        return new_conn.get_id_purchase_last(this);
    }
    
    public void setPurchase_Id_from_Date_and_code()
    {
        DB_Manager new_conn = new DB_Manager();
        id_purchase = new_conn.get_id_purchase(this);
    }
    
    public void set_this_Purchase_details_from_purchase_id()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        purchase_order temp_purchase = new_conn.get_purchase_details(id_purchase);
        this.design_code = temp_purchase.getDesign_code();
        this.job_order_id = temp_purchase.getJob_order_id();
        this.quantity = temp_purchase.getQuantity();
    }
    
    public void set_this_purchase_details_from_job_order_and_design_code()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        purchase_order temp_purchase = new_conn.get_purchase_details_from_job_order_and_design_code(job_order_id, design_code);
        this.id_purchase = temp_purchase.getId_purchase();
        this.quantity = temp_purchase.getQuantity();
    }
    
    public void update_purchase_order()
    {
        Database.DB_Manager this_conn = new DB_Manager();
        this_conn.update_purchase_order_quantity(this);
    }
    
    public void delete_purchase_order()
    {
        Database.DB_Manager this_conn = new DB_Manager();
        this_conn.delete_purchase_order(this);
    }

}
