/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package colortextile_form;

import colortextile_class.*;
import javax.swing.JFrame;
//import org.jopendocument.model.OpenDocument;
//import org.jopendocument.panel.ODSViewerPanel;
//import org.jopendocument.print.DefaultDocumentPrinter;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import org.jdom.JDOMException;

//import org.jopendocument.dom.ODSingleXMLDocument;
//import org.jopendocument.dom.OOUtils;

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
        
  // Concatenate them
  // Save to file and Open the document with OpenOffice.org !
        
        //Database.DB_Manager newManager = new Database.DB_Manager();
        
        //colortextile_class.deletedClass.screen_pigment this_screen = new colortextile_class.deletedClass.screen_pigment();
        //this_screen.setPigment_no(2);
        //this_screen.setPigment_percentage((float)56.7);
        //int trial_get_pigment_id =  newManager.check_if_id_screen_exists(this_screen);
        //System.out.println("Result = :" +trial_get_pigment_id);
        
        //Add_new_design newDesign = new Add_new_design();
        //newDesign.setVisible(true);
        
        //EditRecipe edit_form = new EditRecipe(18);
        //edit_form.setVisible(true);
        
        Main_Menu new_menu = new Main_Menu();
        new_menu.setVisible(true);
        
       // System.out.println(trial_get_pigment_id);
        
        production_recipe this_purchase = new production_recipe();
        this_purchase.set_all_details_from_purchase_order_id(16);
        SpreadsheetTrial newTrial = new SpreadsheetTrial();
        newTrial.print_this_job2(this_purchase, "file1");
        
        production_recipe this_purchase2 = new production_recipe();
        SpreadsheetTrial newTrial2 = new SpreadsheetTrial();
        this_purchase2.set_all_details_from_purchase_order_id(18);
        newTrial2.print_this_job2(this_purchase2, "file2");
        
        /*
        try {
            File f1 = new File("file1.odt");
            ODSingleXMLDocument p1 = ODSingleXMLDocument.createFromPackage(f1);
            
            File f2 = new File("file2.odt");
            ODSingleXMLDocument p2 = ODSingleXMLDocument.createFromPackage(f2);
            
            p1.add(p2);
            
            //OOUtils.open(p1.saveToPackageAs(new File("cat")));
            
        } catch (JDOMException ex) {
            Logger.getLogger(ColorTextile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ColorTextile.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        
        //EditRecipe EditRecipeForm = new EditRecipe(14);
        //EditRecipeForm.setVisible(true);
        //get_des_details.setDesign_code("df343");
       // get_des_details.setDesign_details_from_des_code();
        //get_des_details.add_all_colorway_from_design_code();
       // get_des_details.view_all_colorway_details();
        
        //colortextile_class.design this_design = new colortextile_class.design();
        //this_design.setColor_name("GREEN");
        //this_design.setDesign_name("MICRTG");
        //this_design.setFabric_style("KATUNIA");
        //this_design.setTotal_quantity((int)50660);
        //this_design.add_new_design();
 
    }
    
}
