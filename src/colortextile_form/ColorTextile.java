/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package colortextile_form;

import colortextile_class.Design_and_colorway;
import colortextile_class.Job_purchase_link_functions;
import colortextile_class.SpreadsheetTrial;
import javax.swing.JFrame;
import org.jopendocument.model.OpenDocument;
import org.jopendocument.panel.ODSViewerPanel;
import org.jopendocument.print.DefaultDocumentPrinter;

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
        
        //Database.DB_Manager newManager = new Database.DB_Manager();
        //colortextile_class.deletedClass.screen_pigment this_screen = new colortextile_class.deletedClass.screen_pigment();
        //this_screen.setPigment_no(2);
        //this_screen.setPigment_percentage((float)56.7);
        //int trial_get_pigment_id =  newManager.check_if_id_screen_exists(this_screen);
        //System.out.println("Result = :" +trial_get_pigment_id);
        
        EditRecipe edit_form = new EditRecipe(13);
        edit_form.setVisible(true);
        
        /*
        
        Main_Menu new_menu = new Main_Menu();
        new_menu.setVisible(true);
        Add_new_design newDesign = new Add_new_design();
        newDesign.setVisible(true);
        
       // System.out.println(trial_get_pigment_id);
        
        Design_colorway_link_functions get_des_details = new Design_colorway_link_functions();
        Job_purchase_link_functions this_purchase = new Job_purchase_link_functions();
        //this_purchase.setId_purchase(25);
        //this_purchase.set_this_Purchase_details_from_purchase_id();
        //this_purchase.set_design_details_from_purchase_order_id();
        //this_purchase.setPurchase_Id_from_Date_and_code();
        //this_purchase.set_design_details_from_purchase_order_id();
        //this_purchase.set_job_order_list_using_purchase_order_id();
        //this_purchase.view_all_job_order_details();
        SpreadsheetTrial newTrial = new SpreadsheetTrial();
        //newTrial.print_this_job(this_purchase);
        
        EditRecipe EditRecipeForm = new EditRecipe(14);
        EditRecipeForm.setVisible(true);
        //get_des_details.setDesign_code("df343");
       // get_des_details.setDesign_details_from_des_code();
        //get_des_details.add_all_colorway_from_design_code();
       // get_des_details.view_all_colorway_details();
        */
        colortextile_class.design this_design = new colortextile_class.design();
        this_design.setColor_name("GREEN");
        this_design.setDesign_name("MICRTG");
        this_design.setFabric_style("KATUNIA");
        this_design.setTotal_quantity((int)50660);
        this_design.add_new_design();
 
    }
    
}
