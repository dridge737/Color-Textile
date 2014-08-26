/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package colortextile_class;

import Database.DB_Manager;

/**
 *
 * @author Eldridge
 */
public class customer {
    private int Customer_id;
    private String Customer_name;

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
   
}
