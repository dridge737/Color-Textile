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
        this_screens = new_conn.set_all_screen_pigment_from_colorway_id(this.getId_colorway());
        
        for (screen_pigment this_screen : this_screens) {
            System.out.println("Screen_id : " + this_screen.getId_screen());
            System.out.println("Pigment no :" + this_screen.getPigment_no());
            System.out.println("Pigment name:" + this_screen.getPigment_name());
            System.out.println("Pigment perentage  :" + this_screen.getPigment_percentage());
        }
    }
    
    public void view_all_screen_pigment_details()
    {
        System.out.println("Colorway_name : " +getColorway_name());
        System.out.println("Binder : " +getBinder());     
        System.out.println("Weight : " +getWeight_kg());
        
        for (screen_pigment this_screen : this_screens) {
            System.out.println("Screen_id : " + this_screen.getId_screen());
            System.out.println("Pigment no :" + this_screen.getPigment_no());
            System.out.println("Pigment name:" + this_screen.getPigment_no());
            System.out.println("Pigment perentage  :" + this_screen.getPigment_percentage());
        }
               
    }
    
}
