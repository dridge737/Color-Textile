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
public class screen_pigment_functions {
    private screen_pigment this_screen;
    private String pigmet_name;

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
        this_screen.getPigment_no();
    }

    /**
     * @return the pigmet_name
     */
    public String getPigmet_name() {
        return pigmet_name;
    }


    
    
}
