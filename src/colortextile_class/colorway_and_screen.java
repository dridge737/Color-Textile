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
public class colorway_and_screen {
    private int id_color_screen;
    private int id_screen;
    private int id_colorway;

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
    
    public boolean add_colorway_and_screen()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        if(set_id_colorway_and_screen_from_variables())
            return true;
        
        return new_conn.add_colorway_and_screen_connect(this.id_screen, this.id_colorway);
        
    }
    
    public boolean set_id_colorway_and_screen_from_variables()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        int temp_id_colorway_screen = new_conn.get_id_color_screen(this.id_screen, this.id_colorway);
        if(temp_id_colorway_screen != -1)
        {
            this.id_color_screen = temp_id_colorway_screen;
            return true;
        }
        return false;
    }
    
}
