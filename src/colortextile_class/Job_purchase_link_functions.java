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
    
    private List<job_order> jobs_for_this = new ArrayList<>();
    private Design_colorway_link_functions new_des_col_link = new Design_colorway_link_functions();
    
    //For job_order get job_order_list using purchase order
    
    public void set_job_order_list_using_purchase_order_id()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        
        setJobs_for_this(new_conn.set_job_order_info_from_purchase_id(this.getId_purchase()));
        
    }
    
    public void set_design_details_from_purchase_order_id()
    {
        getNew_des_col_link().setDesign_code(this.getDesign_code());
        getNew_des_col_link().setDesign_details_from_des_code();
        getNew_des_col_link().add_all_colorway_from_design_code();
    }
    
    public void view_all_job_order_details()
    {
        for(job_order all_jobs : jobs_for_this)
        {
            System.out.println("Job Order ID : "+all_jobs.getJob_id());
            System.out.println("Job Order ID : "+all_jobs.getCustomer_id());
            System.out.println("Job Order ID : "+all_jobs.getJob_id());
            System.out.println("Job Order ID : "+all_jobs.getJob_id());
        }
    }
   
    /**
     * @return the jobs_for_this
     */
    public List<job_order> getJobs_for_this() {
        return jobs_for_this;
    }

    /**
     * @param jobs_for_this the jobs_for_this to set
     */
    public void setJobs_for_this(List<job_order> jobs_for_this) {
        this.jobs_for_this = jobs_for_this;
    }

    /**
     * @return the new_des_col_link
     */
    public Design_colorway_link_functions getNew_des_col_link() {
        return new_des_col_link;
    }

    /**
     * @param new_des_col_link the new_des_col_link to set
     */
    public void setNew_des_col_link(Design_colorway_link_functions new_des_col_link) {
        this.new_des_col_link = new_des_col_link;
    }
    
    public void print_this_job()
    {
        
    }
    
}
