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
import java.util.regex.Pattern;

/**
 *
 * @author Eldridge
 */
public class Colorway_screen_link_functions extends colorway implements Comparable<Colorway_screen_link_functions>{
    
    private List<Screen_colorway> this_screens = new ArrayList<>();
    
    public Colorway_screen_link_functions(){}
    
    public Colorway_screen_link_functions(String name, float bind, float weight)
    {
        super(name,bind,weight);
    }
    
    public Colorway_screen_link_functions(String name, float bind, String weight)
    {
        this.setBinder(bind);
        this.setColorway_name(name);
        if(!checkText2(weight))
            this.setWeight_kg(Float.parseFloat(weight));
    }
    
    public String update_kg_prep(float percentage_text)
    {
        float weight_prep = this.getWeight_kg() * percentage_text / 100;
        return String.format("%.2f", weight_prep);
    }
    
    private boolean checkText2(String this_text)
    {
        if(this_text.isEmpty())
            return true;
        String regex = "[^0-9]";
        Pattern p = Pattern.compile(regex);
        this_text = this_text.replaceFirst("[.]", "");
        
        return p.matcher(this_text).find();
    }
     
    public void add_screen(Screen_colorway this_screen)
    {
        this.this_screens.add(this_screen);
    }
    
    public void add_all_screens_from_colorway()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        setThis_screens(new_conn.set_all_colorway_and_screen_from_colorway_id(this.getId_colorway()));
        //Collections.sort(getThis_screens());
        
    }
    
    public void update_this_colorway()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        new_conn.update_colorway(this);
    }
    
    public void view_all_screen_pigment_details()
    {
        System.out.println("Colorway_name : " +getColorway_name());
        System.out.println("Binder : " +getBinder());     
        System.out.println("Weight : " +getWeight_kg());
        
        for (Screen_colorway this_screen : getThis_screens()) {
            this_screen.view_this_colorway_screen_details();
        }
               
    }
    
    public void delete_all_screen_and_colorway_link()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        new_conn.delete_colorway_screen_connect(this.getId_colorway());
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
    public List<Screen_colorway> getThis_screens() {
        return this_screens;
    }

    /**
     * @param this_screens the this_screens to set
     */
    public void setThis_screens(List<Screen_colorway> this_screens) {
        this.this_screens = this_screens;
    }



    
}
