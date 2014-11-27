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
    private String date;
    private String design_code;
    
    private String date_from;
    private String date_to;
    
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
    
    public boolean add_new_purchase()
    {
        DB_Manager new_conn = new DB_Manager();
         return new_conn.add_purchase_order(this);
    }
    
    public int get_id_purchase_last()
    {
        DB_Manager new_conn = new DB_Manager();
       return new_conn.get_id_purchase(this);
    }
    
    public ResultSet get_purchase_info(int purchase_id){
        DB_Manager new_conn = new DB_Manager();
        this.setId_purchase(id_purchase);
       return new_conn.get_single_purchase_info(this);
    }
    
    public ResultSet Search_purchase_info(){
        DB_Manager new_conn = new DB_Manager();
        
       return new_conn.Search_id_purchase(this);
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
    
    public void getPurchase_Id_Last(){
        DB_Manager new_conn = new DB_Manager();
        new_conn.get_id_purchase_last(this);
    }
    
}
