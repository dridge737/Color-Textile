/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Unused;

/**
 *
 * @author Eldridge
 */
public class design_colorway {
    private int id_design_colorway;
    private int design_code;
    private int id_colorway;

    /**
     * @return the id_design_colorway
     */
    public int getId_design_colorway() {
        return id_design_colorway;
    }

    /**
     * @param id_design_colorway the id_design_colorway to set
     */
    public void setId_design_colorway(int the_id_design_colorway) {
        this.id_design_colorway = the_id_design_colorway;
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

    /**
     * @return the id_colorway
     */
    public int getId_colorway() {
        return id_colorway;
    }

    /**
     * @param id_colorway the id_colorway to set
     */
    public void setId_colorway(int id_colorway) {
        this.id_colorway = id_colorway;
    }
    
    public boolean add_new_design_and_colorway_using_variables()
    {
        UnusedCodes new_conn = new UnusedCodes();
        if(!get_this_design_and_colorway_id_using_variables())
        {
            return new_conn.add_design_colorway_connect(this.design_code, this.id_colorway);
        }
            return true;
        
            
    }
    
    public boolean get_this_design_and_colorway_id_using_variables()
    {
        UnusedCodes new_conn = new UnusedCodes();
        int temp_design_id = new_conn.get_id_design_colorway(this);
        if(temp_design_id == -1)
        {
            return false;
        }
        this.id_design_colorway = temp_design_id;
        return true;
    }
}
