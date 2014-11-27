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
public class Design_colorway_link_functions extends design{
    
     List<Colorway_screen_link_functions> all_colorways = new ArrayList<>();
     
     public void add_colorway(Colorway_screen_link_functions this_color_screen_link)
     {
         all_colorways.add(this_color_screen_link);
     }
     
     public void add_all_colorway_from_design_code()
     {
         Database.DB_Manager new_conn = new Database.DB_Manager();
         //new_conn.set
     }
    
    
}
