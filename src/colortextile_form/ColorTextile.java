/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package colortextile_form;

/**
 *
 * @author Eldridge
 */
public class ColorTextile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Database.DB_Manager newManager = new Database.DB_Manager();
        int trial_get_pigment_id =  newManager.get_pigment_id("VIOLET_MFB");
        
        System.out.println(trial_get_pigment_id);
 
    }
    
}
