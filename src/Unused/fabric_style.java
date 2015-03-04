/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unused;

import java.util.ArrayList;

/**
 *
 * @author Eldridge
 */
public class fabric_style {
     private String fabric_style;

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
    
    public boolean add_fabric_style()
    {
        if(get_fabric_style_id() == -1)
        {
            Database.DB_Manager new_conn = new Database.DB_Manager();
            new_conn.add_fabric_style(fabric_style);
            return true;
        }
        return false;
    }
    
    public int get_fabric_style_id()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        return new_conn.get_fabric_style_id(this.fabric_style);
    }
    
    public ArrayList<String> get_all_fabric_styles()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        return new_conn.get_all_fabric_styles();
    }
}
