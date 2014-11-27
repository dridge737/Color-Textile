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
public class Job_purchase_link_functions {
    
    job_order this_job = new job_order();
    String customer_name;
    
    //For job_order get job_order_list using purchase order
    
    public List<job_order> get_job_order_list_using_purchase_order_id()
    {
        
        Database.DB_Manager new_conn = new Database.DB_Manager();
        //return from query
        
        List<job_order> job_list = new_conn.get_job_order_info_from_purchase_id(this_job);
        //add job order
       
        return job_list;
    }
    
    //
    
}
