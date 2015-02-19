/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colortextile_class;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Eldridge
 */
public class Colorway_screen_link_functions extends colorway implements Comparable<Colorway_screen_link_functions>{
    
    private List<colorway_and_screen> this_screens = new ArrayList<>();
    
    public void add_screen(colorway_and_screen this_screen)
    {
        getThis_screens().add(this_screen);
    }
    
    public void add_all_screens_from_colorway()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        setThis_screens(new_conn.set_all_colorway_and_screen_from_colorway_id(this.getId_colorway()));
        Collections.sort(getThis_screens());
        /*
        for (screen_pigment this_screen : getThis_screens()) {
            System.out.println("Screen_id : " + this_screen.getId_screen());
            System.out.println("Pigment no :" + this_screen.getPigment_no());
            System.out.println("Pigment name:" + this_screen.getPigment_name());
            System.out.println("Pigment perentage  :" + this_screen.getPigment_percentage());
            System.out.println("END");
        }
        */
        
    }
    
    public void view_all_screen_pigment_details()
    {
        System.out.println("Colorway_name : " +getColorway_name());
        System.out.println("Binder : " +getBinder());     
        System.out.println("Weight : " +getWeight_kg());
        
        for (colorway_and_screen this_screen : getThis_screens()) {
            //System.out.println("Screen_id : " + this_screen.getId_screen());
            System.out.println("Pigment no :" + this_screen.getPigment_no());
            System.out.println("Pigment name:" + this_screen.getPigment_no());
            System.out.println("Pigment perentage  :" + this_screen.getPigment_percentage());
        }
               
    }
    
    public void delete_all_screen_and_colorway_link()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        //new_conn.delete_colorway_screen_connect(null);
    }

    
    @Override
    public int compareTo(Colorway_screen_link_functions o) {
        int compareTo = this.getColorway_name().compareTo(o.getColorway_name());
        return compareTo;
    }

    /**
     * @return the this_screens
     */
    public List<colorway_and_screen> getThis_screens() {
        return this_screens;
    }

    /**
     * @param this_screens the this_screens to set
     */
    public void setThis_screens(List<colorway_and_screen> this_screens) {
        this.this_screens = this_screens;
    }



    
}
