/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colortextile_class;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eldridge
 */
public class Colorway_screen_link_functions extends colorway{
    
    List<screen_pigment> this_screens = new ArrayList<>();
    
    public void add_screen(screen_pigment this_screen)
    {
        this_screens.add(this_screen);
    }
    
    public void add_all_screens_from_colorway()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        this_screens = new_conn.get_all_screen_pigment_from_colorway_id(this.getId_colorway());
    }
    
}
