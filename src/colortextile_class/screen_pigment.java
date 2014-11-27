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
public class screen_pigment extends pigment {
    private int id_screen;
    //private int pigment_no;
    private float pigment_percentage;
    //private pigment pigment_content;

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

    //DELETED as this class extends pigment.java class
    /**
     * @return the pigment_no
     
    public int getPigment_no() {
        return pigment_no;
    }

    /**
     * @param pigment_no the pigment_no to set
     
    public void setPigment_no(int pigment_no) {
        this.pigment_no = pigment_no;
    }
*/
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
        int temp_id_screen = new_conn.get_id_screen(this.getPigment_no(), pigment_percentage);
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
        this.setPigment_no( this_screen.getPigment_no() );
        
    }

    public void setThis_pigment_name()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        this.setPigment_name( new_conn.get_pigment_name(this.getPigment_no()) );
    }

    

}
