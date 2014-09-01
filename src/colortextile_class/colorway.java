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
public class colorway {
    private int id_colorway;
    private String colorway_name;
    private float binder;
    private float weight_kg;

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
        return new_conn.add_colorway(this);
    }
    
    public boolean get_id_colorway()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        new_conn.get_id_colorway(this);
        return true;
    }
}
