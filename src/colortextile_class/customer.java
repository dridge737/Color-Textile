/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package colortextile_class;

import Database.DB_Manager;
import java.util.ArrayList;

/**
 *
 * @author Eldridge
 */
public class customer {
    private int Customer_id;
    private String Customer_name;
    private ArrayList<String> Customer_names = new ArrayList<String>();

    /**
     * @return the Customer_id
     */
    public int getCustomer_id() {
        return Customer_id;
    }

    /**
     * @param Customer_id the Customer_id to set
     */
    public void setCustomer_id(int Customer_id) {
        this.Customer_id = Customer_id;
    }

    /**
     * @return the Customer_name
     */
    public String getCustomer_name() {
        return Customer_name;
    }

    /**
     * @param Customer_name the Customer_name to set
     */
    public void setCustomer_name(String Customer_name) {
        this.Customer_name = Customer_name;
    }
    
    public void add_new_customer()
    {
        DB_Manager new_conn = new DB_Manager();
        new_conn.add_customer(this);
    }

    /**
     * @return the Customer_names
     */
    public ArrayList<String> getCustomer_names() {
        return Customer_names;
    }

    /**
     * @param Customer_names the Customer_names to set
     */
    public void setCustomer_names(ArrayList<String> Customer_names) {
        this.Customer_names = Customer_names;
    }
    
    public void searchCustomer_name() {
        DB_Manager new_conn = new DB_Manager();
        new_conn.Search_Customer_Name(this);
        
    }
    
    public void get_customer_list() {
        DB_Manager new_conn = new DB_Manager();
        new_conn.get_customer_list(this);
    }

    public int get_customer_id_from_name() {
        DB_Manager new_conn = new DB_Manager();
        return new_conn.get_id_customer_name(this);
        
    }
    
    
   
}
