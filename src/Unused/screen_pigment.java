/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Unused;
import Database.DB_Manager;
import colortextile_class.pigment;
/**
 *
 * @author Eldridge
 */
///Comparable is used to compare and organize the pigment name
public class screen_pigment extends pigment /*implements Comparable<screen_pigment>*/ {
    
    //private int pigment_no;
    private float pigment_percentage;
    private int id_screen;
    
    //DELETED as this class extends pigment.java class

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
    
    public boolean add_new_screen_pigment()
    {
        DB_Manager new_conn = new DB_Manager();
        if(!check_screen_pigment_exists())
        {
            //new_conn.add_screen_pigment(this);
            return true;
        }
        return false;
    }
    
    public boolean check_screen_pigment_exists()
    {
        DB_Manager new_conn = new DB_Manager();
        //if(new_conn.check_if_id_screen_exists(this) == 0)
        //    return false;
        
        return true;
    }
    
    public boolean get_screen_pigment_id_from_pigment_no_and_pigment_percentage()
    {
        DB_Manager new_conn = new DB_Manager();
        int temp_id_screen = new_conn.get_id_screen(this.getPigment_id(), pigment_percentage);
        if(temp_id_screen == -1)
        {
            return false;
        }
        
        id_screen = temp_id_screen;
        return true;
    }
    
    /**
     * @param this_screen the this_screen to set
     */
    public void setThis_screen_from_id_screen(screen_pigment this_screen) {
        this.id_screen = this_screen.id_screen;
        this.pigment_percentage = this_screen.pigment_percentage;
        this.setPigment_id( this_screen.getPigment_id() );
    }

    public void setThis_pigment_name()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        this.setPigment_name( new_conn.get_pigment_name(this.getPigment_id()) );
    }
    
    public float compute_kg_prep(float weight_kg)
    {
        float weight_prep = weight_kg * pigment_percentage / 100;
        return weight_prep;
    }
    /*
    @Override
    public int compareTo(screen_pigment o) {
        int compareTo = this.getPigment_name().compareTo(o.getPigment_name());
        return compareTo;
        
    }
    
    */

}
