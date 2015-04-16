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
public class Pigment_screen_and_colorway extends pigment{
    private int id_color_screen;
    private int id_colorway;
    private float pigment_percentage;

    public Pigment_screen_and_colorway(){}
    
    public Pigment_screen_and_colorway(String pig_name){
        this.setPigment_name(pig_name);
    }
    
    public Pigment_screen_and_colorway(String pig_name, float pigment_percentage)
    {
        this.setPigment_name(pig_name);
        this.setPigment_percentage(pigment_percentage);
    }
    /**
     * @return the id_color_screen
     */
    public int getId_color_screen() {
        return id_color_screen;
    }

    /**
     * @param id_color_screen the id_color_screen to set
     */
    public void setId_color_screen(int id_color_screen) {
        this.id_color_screen = id_color_screen;
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
    public void setId_colorway(int the_id_colorway) {
        this.id_colorway = the_id_colorway;
    }
    
    public boolean add_colorway_and_screen()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        //if(set_id_colorway_and_screen_from_variables())
        //return true;
        return new_conn.add_colorway_and_screen_connect(this.getPigment_no(), this.id_colorway, this.getPigment_percentage());
    }
    
    public void update_colorway_and_screen()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        new_conn.update_colorway_screen(this);
    }
    
    public boolean set_id_colorway_and_screen_from_variables()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        int temp_id_colorway_screen = new_conn.get_id_color_screen(this.getPigment_no(), this.id_colorway, this.getPigment_percentage());
        if(temp_id_colorway_screen != -1)
        {
            this.id_color_screen = temp_id_colorway_screen;
            return true;
        }
        return false;
    }
    
    public boolean delete_id_coloray_from_id_colorway()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        return new_conn.delete_design_and_colorway_con_from_id_colorway(id_colorway);
    }

    
    public String compute_kg_prep(float weight_kg)
    {
        float weight_prep = weight_kg * getPigment_percentage() / 100;
        return String.format("%.2f", weight_prep);
        //return weight_prep;
    }

    /**
     * @return the pigment_percentage
     */
    public float getPigment_percentage() {
        return pigment_percentage;
    }

    /**
     * @param pigment_percentage the pigment_percentage to set
     */
    public void setPigment_percentage(float pigment_percentage) {
        this.pigment_percentage = pigment_percentage;
    }
    
    public ResultSet Search_colorway_screen_connect(){
        Database.DB_Manager new_conn = new Database.DB_Manager();
        return new_conn.Search_colorway_screen_connect(this);
    }
}
