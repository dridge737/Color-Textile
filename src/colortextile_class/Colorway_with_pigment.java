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
public class Colorway_with_pigment extends colorway implements Comparable<Colorway_with_pigment>{
    
    private List<Pigment_with_screen_connect> this_screens = new ArrayList<>();
    
    public Colorway_with_pigment(){}
    
    public Colorway_with_pigment(String name, float bind, float weight)
    {
        super(name,bind,weight);
    }
    
    public Colorway_with_pigment(String name, float bind, String weight)
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
     
    public void add_screen(Pigment_with_screen_connect this_screen)
    {
        this.this_screens.add(this_screen);
    }
    
    public void add_all_screens_from_colorway()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        setThis_screens(new_conn.set_all_colorway_and_screen_from_colorway_id(this.getId_colorway()));
        //Collections.sort(getThis_screens());
        
    }
    
    public void delete_all_screen_and_this_colorway_from_colorway_id()
    {
        for(Pigment_with_screen_connect delete_screen :this.getThis_screens())
        {
            delete_screen.delete_id_coloray_screen_from_id_colorway();
        }
        this.delete_this_colorway();
        
    }
    
    public void update_this_colorway()
    {
        Database.DB_Manager new_conn = new Database.DB_Manager();
        new_conn.update_colorway(this);
    }
    
    public void view_all_screen_pigment_details()
    {
        this.view_colorway_details();
        for (Pigment_with_screen_connect this_screen : getThis_screens()) {
            this_screen.view_this_colorway_screen_details();
        }
               
    }
    
    @Override
    public int compareTo(Colorway_with_pigment o) {
        int compareTo = this.getColorway_name().compareTo(o.getColorway_name());
        return compareTo;
    }

    /**
     * @return the this_screens
     */
    public List<Pigment_with_screen_connect> getThis_screens() {
        return this_screens;
    }

    /**
     * @param this_screens the this_screens to set
     */
    public void setThis_screens(List<Pigment_with_screen_connect> this_screens) {
        this.this_screens = this_screens;
    }



    
}