/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colortextile_class;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eldridge
 */
public class Job_purchase_link_functions extends purchase_order{
    
    List<job_order> jobs_for_this = new ArrayList<>();
    Design_colorway_link_functions new_des_col_link = new Design_colorway_link_functions();
    
    //For job_order get job_order_list using purchase order
    
    public void set_job_order_list_using_purchase_order_id()
    {
        
        Database.DB_Manager new_conn = new Database.DB_Manager();
        //return from query
        
        jobs_for_this = new_conn.get_job_order_info_from_purchase_id(this.getId_purchase());
        //add job order
    }
    
    public void get_design_details_from_purchase_order_id()
    {
        
    }
    
    //
    
}
