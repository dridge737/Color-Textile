/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package colortextile_class;

import java.sql.Blob;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eldridge
 */
public class design{
    private int design_code;
    private String design_name;
    private String color_name;
    private String fabric_style;
    private Blob design_image;
    private int total_quantity;
    private float percent;
    private float fabric_kilogram;
    
    public design(){}
    
    public design(String design, String color, String fabric )
    {
        this.design_name = design;
        this.color_name = color;
        this.fabric_style = fabric;
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
    public void setDesign_code(int the_design_code) {
        this.design_code = the_design_code;
    }

    /**
     * @return the design_name
     */
    public String getDesign_name() {
        return design_name;
    }

    /**
     * @param design_name the design_name to set
     */
    public void setDesign_name(String design_name) {
        this.design_name = design_name;
    }

    public boolean add_new_design_and_set_design_code()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        //if(!get_design_code_using_variables())
        //{   //Design has not yet been added in the database
            //ADD this design
        if(new_conn.add_design(this))
            this.set_design_code_using_variables();
        else
        {
            this.design_code = -1;
            return false;
        }
        //}
        return true;
    }
    
    public boolean get_design_code_using_variables()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        int temp_design_code = new_conn.get_design_code(this);
        if(temp_design_code != -1)
        {   //Design code exists
            this.design_code = temp_design_code;
            return true;
        }
        return false;
    }
   /* 
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
    
    public ArrayList<String> get_all_fabric_styles()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        return new_conn.get_all_fabric_styles();
    }
    */
    
    public boolean set_design_code_using_variables()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        int temp_design_code = new_conn.get_design_code(this);
        
        if(temp_design_code != -1)
        {
            this.design_code = temp_design_code;
            return true;
        }
       return false;
    }

    /**
     * @return the color_name
     */
    public String getColor_name() {
        return color_name;
    }

    /**
     * @param colorway_name the color_name to set
     */
    public void setColor_name(String this_color_name) {
        this.color_name = this_color_name;
    }
    
    public void setDesign_details_from_des_code()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        design new_design = new_conn.set_design_details_from_des_code(this.design_code);
        if(new_design != null)
        {
            this.color_name = new_design.getColor_name();
            this.design_name = new_design.getDesign_name();
            this.setFabric_style(new_design.getFabric_style());
        }
    }
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
    
    /**
     * @return the design_image
     */
    public Blob getDesign_image() {
        return design_image;
    }

    /**
     * @param design_image the design_image to set
     */
    public void setDesign_image(Blob design_image) {
        this.design_image = design_image;
    }
    
    public DefaultTableModel get_all_design_details(){
        Database.DB_Manager new_conn = new Database.DB_Manager();
        return new_conn.get_table_all_design();
    }
    
    public ResultSet search_design(){
        Database.DB_Manager new_conn = new Database.DB_Manager();
        return new_conn.Search_Design(this);
    }
    
   public ResultSet get_picture_from_design_code(){
       Database.DB_Manager new_conn = new Database.DB_Manager();       
       return new_conn.get_picture_from_design_id(this);
   }
   
   public void set_design_picture_from_design_code()
   {
       Database.DB_Manager new_conn = new Database.DB_Manager();
       this.design_image = new_conn.get_design_picture_using_design_id(design_code);
   }

   public void update_design()
   {
       Database.DB_Manager new_conn = new Database.DB_Manager();
       new_conn.update_design(this);
   }

    /**
     * @return the total_quantity
     */
    public int getTotal_quantity() {
        return total_quantity;
    }

    /**
     * @param total_quantity the total_quantity to set
     */
    public void setTotal_quantity(int total_quantity) {
        this.total_quantity = total_quantity;
    }
    
    public boolean add_fabric_style()
    {
        if(get_fabric_style_id() == -1)
        {
            Database.DB_Manager new_conn = new Database.DB_Manager();
            new_conn.add_fabric_style(fabric_style, this.fabric_kilogram);
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
    
    public void view_design_details()
    {
        System.out.println("Design_code : " +this.getDesign_code());
        System.out.println("Color Name :"  +this.getColor_name());
        System.out.println("Design_name : " +this.getDesign_name());
        System.out.println("Fabric Style : " +this.getFabric_style());
    }
    
    public int count_all_fabric_style()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        return new_conn.count_number_of_fabric_style();
    }

    /**
     * @return the percent
     */
    public float getPercent() {
        return percent;
    }

    /**
     * @param percent the percent to set
     */
    public void setPercent(float percent) {
        this.percent = percent;
    }

    /**
     * @return the fabric_kilogram
     */
    public float getFabric_kilogram() {
        return fabric_kilogram;
    }

    /**
     * @param fabric_kilogram the fabric_kilogram to set
     */
    public void setFabric_kilogram(float fabric_kilogram) {
        this.fabric_kilogram = fabric_kilogram;
    }
    
    
}
