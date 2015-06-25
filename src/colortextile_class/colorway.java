/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package colortextile_class;

import java.sql.ResultSet;

/**
 *
 * @author Eldridge
 */
public class colorway {
    private int id_colorway;
    private String colorway_name;
    private float binder;
    private float weight_kg;
    private int design_code;
    private float coverage;
    
    public colorway(){
        id_colorway = 0;
    }
    
    public colorway(String name, float set_binder , float set_weight_kg){
        this.colorway_name = name;
        this.binder = set_binder;
        this.weight_kg = set_weight_kg;
    }
    
    public colorway(String name, float set_binder , float set_weight_kg, int set_design_code){
        this.colorway_name = name;
        this.binder = set_binder;
        this.weight_kg = set_weight_kg;
        this.design_code = set_design_code;
    }
    
    public colorway(String name, float set_binder , float set_weight_kg, int set_design_code, float set_coverage){
        this.colorway_name = name;
        this.binder = set_binder;
        this.weight_kg = set_weight_kg;
        this.design_code = set_design_code;
        this.coverage = set_coverage;
    }

    /**
     * @return the id_colorway
     */
    public int getId_colorway() {
        return id_colorway;
    }

    /**
     * @param id_colorway the id_colorway to set
     */
    public void setId_colorway(int colorway_id) {
        this.id_colorway = colorway_id;
    }

    /**
     * @return the colorway_name
     */
    public String getColorway_name() {
        return colorway_name;
    }

    /**
     * @param colorway_name the colorway_name to set
     */
    public void setColorway_name(String colorway_name) {
        this.colorway_name = colorway_name;
    }

    /**
     * @return the binder
     */
    public float getBinder() {
        return binder;
    }

    /**
     * @param binder the binder to set
     */
    public void setBinder(float binder) {
        this.binder = binder;
    }

    /**
     * @return the weight_kg
     */
    public float getWeight_kg() {
        return weight_kg;
    }

    /**
     * @param weight_kg the weight_kg to set
     */
    public void setWeight_kg(float weight_kg) {
        this.weight_kg = weight_kg;
    }
    
    public boolean add_new_colorway()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        
        if(set_id_colorway_from_variables())
            return true;
        
        return new_conn.add_colorway(this);
        
    }
    
    public boolean set_id_colorway_from_variables()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        int temp_colorway_id = new_conn.get_id_colorway(this);
        //System.out.println(temp_colorway_id);
        if(temp_colorway_id != -1)
        {
            this.id_colorway = temp_colorway_id;
            return true;
        }
        return false;
        
    }
    
    public void get_colorway_details_from_colorway_id()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        colorway temp_colorway = new_conn.set_colorway_details_from_colorway_id(this.getId_colorway());
        
        this.setBinder(temp_colorway.getBinder());
        this.setColorway_name(temp_colorway.getColorway_name());
        this.setWeight_kg(temp_colorway.getWeight_kg());
        this.setDesign_code(temp_colorway.getDesign_code());
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
    public void setDesign_code(int design_code) {
        this.design_code = design_code;
    }
    
    public ResultSet Search_colorway(){
        Database.DB_Manager new_conn = new Database.DB_Manager();
        return new_conn.Search_colorway(this);
    }
}
