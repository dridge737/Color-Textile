/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package colortextile_class;
import Database.DB_Manager;
/**
 *
 * @author Eldridge
 */
public class screen_pigment {
    private int id_screen;
    private int pigment_no;
    private float pigment_percentage;

    /**
     * @return the id_screen
     */
    public int getId_screen() {
        return id_screen;
    }

    /**
     * @param id_screen the id_screen to set
     */
    public void setId_screen(int id_screen) {
        this.id_screen = id_screen;
    }

    /**
     * @return the pigment_no
     */
    public int getPigment_no() {
        return pigment_no;
    }

    /**
     * @param pigment_no the pigment_no to set
     */
    public void setPigment_no(int pigment_no) {
        this.pigment_no = pigment_no;
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
    
    public boolean add_new_screen_pigment()
    {
        DB_Manager new_conn = new DB_Manager();
        if(!get_screen_pigment_id_from_pigment_no_and_pigment_percentage())
        {
            new_conn.add_screen_pigment(this);
            return true;
        }
        return false;
    }
    
    public boolean get_screen_pigment_id_from_pigment_no_and_pigment_percentage()
    {
        DB_Manager new_conn = new DB_Manager();
        int temp_id_screen = new_conn.get_id_screen(pigment_no, pigment_percentage);
        if(temp_id_screen == -1)
        {
            return false;
        }
        
        id_screen = temp_id_screen;
        return true;
    }
    

}
