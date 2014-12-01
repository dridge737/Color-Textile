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
    
     private List<Colorway_screen_link_functions> all_colorways = new ArrayList<>();
     
     public void add_colorway(Colorway_screen_link_functions this_color_screen_link)
     {
         getAll_colorways().add(this_color_screen_link);
     }
     
     public void add_all_colorway_from_design_code()
     {
         Database.DB_Manager new_conn = new Database.DB_Manager();
         setAll_colorways(new_conn.set_all_colorway_from_design_code(this.getDesign_code()));
         
         for(int x = 0; x < getAll_colorways().size(); x++ )
         {
             getAll_colorways().get(x).add_all_screens_from_colorway();
         }
         
     }
     
     public void view_all_colorway_details()
     {
         System.out.println("Design_code : " +this.getDesign_code());
         System.out.println("Color Name :"  +this.getColor_name());
         System.out.println("Design_name : " +this.getDesign_name());
         System.out.println("Fabric Style : " +this.getFabric_style());
         
         for(int x = 0; x < getAll_colorways().size(); x++ )
         {
             getAll_colorways().get(x).view_all_screen_pigment_details();
         }
     }

    /**
     * @return the all_colorways
     */
    public List<Colorway_screen_link_functions> getAll_colorways() {
        return all_colorways;
    }

    /**
     * @param all_colorways the all_colorways to set
     */
    public void setAll_colorways(List<Colorway_screen_link_functions> all_colorways) {
        this.all_colorways = all_colorways;
    }
     
     
    
    
}
