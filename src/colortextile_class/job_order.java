/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package colortextile_class;

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
    
    public String get_job_id()
    {
        return this.job_id;
    }
    
    public Date get_date(){
        return this.date;
    }
    
    public int get_quantity(){
        return this.quantity;
    }
    
    public String get_fabric_style(){
        return this.fabric_style;
    }
    
    public int get_customer_id(){
        return this.customer_id;
    }
    
    public String get_design_code(){
        return this.design_code;
    }
    
    public void set_date(Date job_date){
        this.date = job_date;
    }
    
    public void set_quantity(int quantity){
        this.quantity = quantity;
    }
    
    public void set_fabric_style(String fabric_style){
        this.fabric_style = fabric_style;
    }
    
    public void set_customer_id(int customer_id){
        this.customer_id = customer_id;
    }
    
    public void set_design_code(String design_code){
        this.design_code = design_code;
    }
    
    
}
