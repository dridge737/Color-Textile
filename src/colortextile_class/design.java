/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package colortextile_class;

import java.sql.Blob;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Eldridge
 */
public class design {
    private String design_code;
    private String design_name;
    private String color_name;
    private String fabric_style;
    private Blob design_image;

    
    /**
     * @return the design_code
     */
    public String getDesign_code() {
        return design_code;
    }

    /**
     * @param design_code the design_code to set
     */
    public void setDesign_code(String the_design_code) {
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

    public boolean add_new_design()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        if(!get_design_code_using_variables())
        {
            new_conn.add_design(this);
            return true;
        }
        return false;
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
    
    public boolean get_design_code_using_variables()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        String temp_design_code = new_conn.get_design_code(this);
        if(temp_design_code != null)
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

        this.color_name = new_design.color_name;
        this.design_name = new_design.design_name;
        this.fabric_style = new_design.fabric_style;
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
    
    public ResultSet get_all_design_details(){
        Database.DB_Manager new_conn = new Database.DB_Manager();
        return new_conn.get_all_design();
    }
    
    public ResultSet search_design(){
        Database.DB_Manager new_conn = new Database.DB_Manager();
        return new_conn.Search_Design(this);
    }

    
}
