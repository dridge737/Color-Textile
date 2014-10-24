/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package colortextile_class;

/**
 *
 * @author Eldridge
 */
public class design {
    private String design_code;
    private String design_name;
    private String colorway_name;

    /**
     * @return the design_code
     */
    public String getDesign_code() {
        return design_code;
    }

    /**
     * @param design_code the design_code to set
     */
    public void setDesign_code(String design_code) {
        this.design_code = design_code;
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

    
}
