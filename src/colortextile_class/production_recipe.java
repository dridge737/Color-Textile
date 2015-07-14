/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colortextile_class;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JSpinner;

/**
 *
 * @author Eldridge
 */
public class production_recipe extends Design_and_colorway{
    
     private String Date;
     private List<job_order> jobs_for_this = new ArrayList<>();
     private List<purchase_order> all_purchase = new ArrayList<>();
     
     public production_recipe(){}
     
     public production_recipe(String design, String color, String fabric, String set_date)
     {
         super(design,color,fabric);
         this.Date = set_date;
     }
     
     public void set_all_details_from_purchase_order_id(int purchase_order_id)
     {
         this.set_purchase_details_from_purchase_id(purchase_order_id);
         this.set_design_details_from_first_purchase_order();
         this.set_purchase_details();
     }
     
     public void set_design_details_from_first_purchase_order()
     {
        if(this.getAll_purchase().size() != 0)
        {
            this.setDesign_code(this.getAll_purchase().get(0).getDesign_code());
            this.setDesign_details_from_des_code();
            this.set_all_colorway_from_design_code();
        }
     }
     
     public void set_purchase_details_from_purchase_id(int purchase_order_id)
     {
        // USING GLOBAL VARIABLE
        purchase_order this_purchase = new purchase_order();
        //Set Details
        this_purchase.setId_purchase(purchase_order_id);
        this_purchase.set_this_Purchase_details_from_purchase_id();
        this.add_purchase(this_purchase);
     }
     
     public void set_purchase_details()
    {
        this.set_job_order_list_using_design_code_and_purchase_id();
        this.set_purchase_order_list_from_job_list();  
        this.setDate(jobs_for_this.get(0).getDate());
    }
     
     public void set_job_order_list_using_design_code_and_purchase_id()
     {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        //GET all the job_order_id from the Date and design_code
        if(all_purchase.size() > 0)
        {
            jobs_for_this = new_conn.get_all_job_order_and_details_from_design_and_purchase_id(all_purchase.get(0).getDesign_code(), all_purchase.get(0).getId_purchase());
            //new_conn.get_all_job_order_from_date_and_design(Date, design_code);
            //Get the List of job order from the purchase order id
            //setJobs_for_this(new_conn.set_job_order_info_from_purchase_id(this.getId_purchase()));
        }
     }
     
     public int get_job_order_index(String this_job_order_id)
     {
         int job_order_index = -1;
         for(int job_index = 0; job_index < jobs_for_this.size(); job_index++)
         {
             if(jobs_for_this.get(job_index).getJob_id().equals(this_job_order_id))
             {
                 job_order_index = job_index;
                 job_index = jobs_for_this.size();
             }
         }
         return job_order_index;
     }
     
     public void set_purchase_order_list_from_job_list()
     {
         this.all_purchase.clear();
         for(job_order this_job_order : jobs_for_this)
         {
             purchase_order current_purchase = new purchase_order();
             current_purchase.setJob_order_id(this_job_order.getJob_id());
             current_purchase.setDesign_code(this.getDesign_code());
             current_purchase.set_this_purchase_details_from_job_order_and_design_code();
             all_purchase.add(current_purchase);
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
        //set_customer_name_for_jobs();
    }
    
    public void set_customer_name_for_jobs(){
        for(int x = 0; x < jobs_for_this.size(); x++ )
             jobs_for_this.get(x).set_customer_name_from_id();
    }
    
    public String get_all_customers()
    {
        String all_customers = "";
        for(int x = 0 ; x < jobs_for_this.size(); x++)
        {
            //System.out.println("Customer name = " +jobs_for_this.get(x).getCustomer_name());
            if(x == (jobs_for_this.size()-1))
                all_customers += jobs_for_this.get(x).getCustomer_name();
            else
                all_customers += jobs_for_this.get(x).getCustomer_name() + ", ";                
        }
        return all_customers;
    }
    
    public String get_all_job_id()
    {
        String all_job_order_id = "";
        for(int x = 0 ; x < jobs_for_this.size(); x++)
        {
            if(x == (jobs_for_this.size()-1))
                all_job_order_id += jobs_for_this.get(x).getJob_id();
            else
                all_job_order_id += jobs_for_this.get(x).getJob_id() + ", ";
        }
        //System.out.println(all_job_order_id);
        return all_job_order_id;
    }

    /**
     * @return the Date
     */
    public String getDate() {
        return Date;
    }

    /**
     * @param Date the Date to set
     */
    public void setDate(String Date) {
        this.Date = Date;
    }
    
    public void add_all_purchase_order()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        setAll_purchase(new_conn.get_all_purchase_for_this_job_order(this.jobs_for_this.get(0)));
    }
    
    public void view_all_puchase_order()
     {
         System.out.println("Size of this purchase is :" +this.getAll_purchase().size());
        for (purchase_order all_purchase1 : getAll_purchase()) {
            System.out.println("Purchase id = " + all_purchase1.getId_purchase());
            System.out.println("Job Order = " + all_purchase1.getJob_order_id());
            System.out.println("Design code= " + all_purchase1.getDesign_code());
            System.out.println("Quantity = " + all_purchase1.getQuantity());
        }
     }
    
    public void view_all_job_order_details(){
        System.out.println("Size of this job is = "+jobs_for_this.size());
        for(job_order all_jobs : jobs_for_this)
        {
            System.out.println("Job Order ID  : "+all_jobs.getJob_id());
            System.out.println("Customer ID   : "+all_jobs.getCustomer_id());
            System.out.println("Customer Name : "+all_jobs.getCustomer_name());
        }
    }
    
    /***
     * Gets all the quantity in a string ex: 143 +153 +245 =
     * @return 
     */
    public String get_all_quantity()
    {
        String quantity_all = "";
        for(int x = 0 ; x < getAll_purchase().size(); x++)
        {
            if(x == getAll_purchase().size()-1)
                quantity_all += Integer.toString(getAll_purchase().get(x).getQuantity());
            else
                quantity_all += Integer.toString(getAll_purchase().get(x).getQuantity()) + " +";
                
        }
        quantity_all += "= ";
        return quantity_all;
    }
    
    public int get_quantity_sum()
    {
        int quantity_sum = 0;
        for(int x = 0 ; x < getAll_purchase().size(); x++)
        {
            quantity_sum += getAll_purchase().get(x).getQuantity();
        }
        //System.out.println(quantity_sum);
        return quantity_sum;
    }

    /**
     * @return the all_purchase
     */
    public List<purchase_order> getAll_purchase() {
        return all_purchase;
    }

    /**
     * @param all_purchase the all_purchase to set
     */
    public void setAll_purchase(List<purchase_order> all_purchase) {
        this.all_purchase = all_purchase;
    }
    
    public void add_purchase(purchase_order this_purchase)
    {
        all_purchase.add(this_purchase);
    }
    
    public void add_job(job_order this_job)
    {
        jobs_for_this.add(this_job);
    }
    /**
     * Set 
     */
    
    public void set_design_details_and_colorway_details_from_design_code()
    {
        this.setDesign_details_from_des_code();
        this.set_all_colorway_from_design_code();
    }
    
    public void set_all_purchase_details_from_design_code_and_date()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        this.all_purchase = new_conn.get_all_purchase_details_from_date_and_design(Date, this.getDesign_code());
    }
    
    public ArrayList<Integer> get_all_design_codes_from_date()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        return new_conn.get_all_design_code_from_date(Date);
        
    }
    
    public float compute_this_kg_for_one_kilo(float colorway_kilogram)
    {
        //COMPUTE ITEM BY FIRST GETTING THE COVERAGE AS COVERAGE IS UNIVERSAL THROUGH DIFFERENT QUANTITIES
        float coverage = this.compute_this_coverage(colorway_kilogram);
                //NORMALIZE items  
        return this.compute_this_kg_normalized(coverage);
    }
    
    public float compute_kilograms_to_total_quantity(float colorway_kilogram)
    {
        //float weight_kg = Float.parseFloat(colorway_kilo_gram);
        //COMPUTE ITEM BY FIRST GETTING THE COVERAGE AS COVERAGE IS UNIVERSAL THROUGH DIFFERENT QUANTITIES
        float coverage = this.compute_this_coverage_from_normalized_item(colorway_kilogram);
        System.out.println("Coverage = :"+coverage);
        return this.compute_this_kg(coverage);
    }
    
    private float compute_this_coverage_from_normalized_item(float kg)
    {
        float coverage = 0;
        if(this.getFabric_style().equals("PONGEE"))
        {
            coverage = Math.round((kg*1000/1000)*10/8);
        }
        else if(this.getFabric_style().equals("COTTON") || this.getFabric_style().equals("KATUNIA"))
        {
            coverage = Math.round((kg*1000/1000)*10/12);
        }
        else if (this.getFabric_style().equals("MICROPEACH") || this.getFabric_style().equals("TC") || this.getFabric_style().equals("TROPICANA"))
        {
            coverage = Math.round((kg*1000/1000));
        }
        
        return coverage;
    }
    
    public float compute_this_coverage(float kg)
    {
        float coverage = 0;
        if(this.getFabric_style().equals("PONGEE"))
        {
            coverage = Math.round((kg*1000/this.get_quantity_sum())*10/8);
        }
        else if(this.getFabric_style().equals("COTTON") || this.getFabric_style().equals("KATUNIA"))
        {
            coverage = Math.round((kg*1000/this.get_quantity_sum())*10/12);
        }
        else if (this.getFabric_style().equals("MICROPEACH") || this.getFabric_style().equals("TC") || this.getFabric_style().equals("TROPICANA"))
        {
            coverage = Math.round((kg*1000/this.get_quantity_sum()));
        }
        
        return coverage;
    }
    
    public float compute_this_kg_normalized(float coverage)
    {
        float colorway_kilogram = 0;
        //float this_quant = 1000;
        //COVERAGE SHOULD BE DIVIDED BY 100 TO BECOME DECIMAL
        //ORIGINAL SHOULD BE 80*COVERAGE/100*TOTAL QUANTITY/ 1000
        //SIMPLIFIED TO 8*COVERAGE/10*TOTAL QUANTITY /1000
        if(this.getFabric_style().equals("PONGEE")){
            colorway_kilogram = Math.round((8*coverage/10*1000)/1000);
        }
        else if(this.getFabric_style().equals("COTTON") || this.getFabric_style().equals("KATUNIA"))
        {
            colorway_kilogram = Math.round((12*coverage/10*1000)/1000);
        }
        else if (this.getFabric_style().equals("MICROPEACH") || this.getFabric_style().equals("TC") || this.getFabric_style().equals("TROPICANA"))
        {
            colorway_kilogram = Math.round((10*coverage/10*1000)/1000);
        }
        return colorway_kilogram;
    }
    
    public float compute_this_kg(float coverage)
    {
        float colorway_kilogram = 0;
        float this_quant = this.get_quantity_sum();
        System.out.println("TOTAL QUANTITY ="+this_quant);
        //COVERAGE SHOULD BE DIVIDED BY 100 TO BECOME DECIMAL
        //ORIGINAL SHOULD BE 80*COVERAGE/100*TOTAL QUANTITY/ 1000
        //SIMPLIFIED TO 8*COVERAGE/10*TOTAL QUANTITY /1000
        if(this.getFabric_style().equals("PONGEE")){
            colorway_kilogram = Math.round((8*coverage/10*this_quant)/1000);
        }
        else if(this.getFabric_style().equals("COTTON") || this.getFabric_style().equals("KATUNIA"))
        {
            colorway_kilogram = Math.round((12*coverage/10*this_quant)/1000);
        }
        else if (this.getFabric_style().equals("MICROPEACH") || this.getFabric_style().equals("TC") || this.getFabric_style().equals("TROPICANA"))
        {
            colorway_kilogram = Math.round((10*coverage/10*this_quant)/1000);
        }
        
        return colorway_kilogram;
    }
    
    public void compute_all_colorway_to_total_quantity()
    {
        for(int x = 0; x < getAll_colorways().size(); x++ )
         {
             this.getAll_colorways().get(x).setWeight_kg(this.compute_kilograms_to_total_quantity(this.getAll_colorways().get(x).getWeight_kg()));
         }
    }
    
    public String change_job_order_prefix(String spinnerValue)
    {
    //  String spinnerValue = this.get_date_from_spinner(this_date_spinner);
        
        String Year = spinnerValue.substring(2, 4);
        String Month = spinnerValue.substring(5,7);
        
        return Year+ "P-" + Month + "-";
    }
}
