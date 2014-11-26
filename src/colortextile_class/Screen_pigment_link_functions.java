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
public class Screen_pigment_link_functions {
    private screen_pigment this_screen;
    private String pigment_name;

    /**
     * @return the this_screen
     */
    public screen_pigment getThis_screen() {
        return this_screen;
    }

    /**
     * @param this_screen the this_screen to set
     */
    public void setThis_screen(screen_pigment this_screen) {
        this.this_screen = this_screen;
    }

    public void setThis_pigment_name()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        new_conn.get_pigment_name(this_screen.getPigment_no());
    }

    /**
     * @return the pigment_name
     */
    public String getPigment_name() {
        return pigment_name;
    }


    
    
}
