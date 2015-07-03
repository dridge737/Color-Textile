/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colortextile_class;
//import colortextile_class.deletedClass.screen_pigment;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Pattern;

import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jopendocument.dom.ODSingleXMLDocument;
import org.jopendocument.dom.OOXML;
import org.jopendocument.dom.XMLVersion;
import org.jopendocument.dom.template.JavaScriptTemplate;
import org.jopendocument.util.JDOMUtils;
import org.jdom.Attribute;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jopendocument.dom.template.RhinoTemplate;
//import static spreadsheettrial.TestTemplate.copyFileToTmp;


/**
 *
 * @author Eldridge
 */
public class SpreadsheetTrial {

        static String in = "Printext_change3.odt";
	static final String out = "print_out.odt";
        static Namespace ns = Namespace.getNamespace("xlink", "http://www.w3.org/1999/xlink");
        static int screen_count =2;
       
    public void print_this_job2(colortextile_class.production_recipe this_purchase, String file_name)
    {
         try {
            File templateFile = new File(in);
            File outFile = new File(file_name);
            RhinoTemplate template = new RhinoTemplate(templateFile);
        
            String all_job_id = this_purchase.get_all_job_id();
            //System.out.println(all_job_id);
            String all_customer = this_purchase.get_all_customers();
            String quantity_all = this_purchase.get_all_quantity();
            int quantity_sum = this_purchase.get_quantity_sum();
            quantity_all = quantity_all.replace("=", "");
            // Fill with sample values.
            template.setField("customer", all_customer);
            template.setField("job", all_job_id);
            template.setField("desName", this_purchase.getDesign_name());
            template.setField("date", this_purchase.getDate());
            template.setField("fabStyle", this_purchase.getFabric_style());
            template.setField("quant", quantity_all);
            template.setField("total", quantity_sum);
            template.setField("color", this_purchase.getColor_name());
            
            List<Colorway_screen_link_functions> this_colorway = this_purchase.getAll_colorways();
            
            Colorway_screen_link_functions first_colorway = this_colorway.get(0);
            
            template.setField("screen1", first_colorway.getColorway_name());
            template.setField("kilo1", first_colorway.getWeight_kg());
            template.setField("bind1", first_colorway.getBinder());
            //FOR COLORWAY SCREEN
            List<Pigment_screen_and_colorway> the_screens = first_colorway.getThis_screens();
            int x = 1;
            while( x<=the_screens.size())
            {
                template.setField("screen1_"+x, the_screens.get(x-1).getPigment_name() );
                template.setField("per1_"+x, the_screens.get(x-1).getPigment_percentage() );
                template.setField("kg1_"+x, the_screens.get(x-1).compute_kg_prep(first_colorway.getWeight_kg()));
                x++;
            }
            while(x<=3)
            {
                template.setField("screen1_"+x, "");
                template.setField("per1_"+x, "");
                template.setField("kg1_"+x, "");
                x++;
            }
            this_colorway.remove(0);
            
            final List<Map<String, String>> Colorway_Map = new ArrayList<Map<String, String>>();
            int y = 1;
            
            for(Colorway_screen_link_functions current_colorway : this_colorway)
            {
                Colorway_Map.add(createMap2(current_colorway));
                y++;
            }
            
            while(y<7)
            {
                Colorway_Map.add(fakeMap2());
                y++;
            }
            //reset Screen count
            screen_count = 2;
            template.setField("print", Colorway_Map);
            // Save to file.
            /*final String bcfile = "New.jpg";
            
            File image = new File(bcfile);
            if (image.exists() && image.canRead()) {
            final ODSingleXMLDocument ddoc = template.createDocument();
            File tmp = copyFileToTmp(image);
            
            ddoc.getDescendantByName("draw:frame", "graphics1").setAttribute("href", tmp.toURI().toURL().toString(), ns); 
            ddoc.saveToPackageAs(outFile); 
            }                
            */
            template.saveAs(outFile);
            
         }
         catch (Exception e) {
            e.printStackTrace();
        }
         
    }
    
    private ArrayList<production_recipe> merge_design_colorways(List<production_recipe> bulk_recipe)
    {
        int loop_size = bulk_recipe.size();
        ArrayList<production_recipe> temp_bulk_recipe = new ArrayList<production_recipe>();
        for(int iterate =0; iterate< loop_size-1; iterate++)
        {
            //Place first Item of list in a temporary recipe
            production_recipe recipe_1 = bulk_recipe.get(0);
            //Remove first Item from the List
            bulk_recipe.remove(0);
            System.out.println("Design name 1st Item= "+recipe_1.getDesign_name());
            for (production_recipe recipe_2 : bulk_recipe) 
            {
                System.out.println("Design name 2nd Item= "+recipe_2.getDesign_name());
                //Loop in the List to check if there is the same Design Name
                if (recipe_1.getDesign_name().equals(recipe_2.getDesign_name())) 
                {
                    //if There is the same design name check for all the colorways 
                    
                    //colorway_to_update    
                    //Loop to find same colorway name
                    for(int colorway1_iterate = 0; colorway1_iterate< recipe_1.getAll_colorways().size(); colorway1_iterate++)
                    {
                        //First get all the colorways and the size
                        // Loop through the 2nd Items colorway
                        for(int colorway2_iterate = 0; colorway2_iterate < recipe_2.getAll_colorways().size(); colorway2_iterate++)
                        {
                            System.out.println("Colorway #"+colorway2_iterate+ " is :" +recipe_2.getAll_colorways().get(colorway2_iterate).getColorway_name());
                            if(recipe_1.getAll_colorways().get(colorway1_iterate).getColorway_name().
                                    equals(recipe_2.getAll_colorways().get(colorway2_iterate).getColorway_name())
                             && recipe_1.getAll_colorways().get(colorway1_iterate).getThis_screens().size() == 
                                        recipe_2.getAll_colorways().get(colorway2_iterate).getThis_screens().size())
                            {    
                                    recipe_1.getAll_colorways().get(colorway1_iterate).setWeight_kg(recipe_1.getAll_colorways().get(colorway1_iterate).getWeight_kg()+recipe_2.getAll_colorways().get(colorway2_iterate).getWeight_kg());
                                    recipe_2.getAll_colorways().get(colorway2_iterate).setWeight_kg(0);
                            }
                            
                        }
                    }
                }
            }
            recipe_1.view_all_colorway_details();
            temp_bulk_recipe.add(recipe_1);
        }
        temp_bulk_recipe.add(bulk_recipe.get(0));
        return temp_bulk_recipe;
    }
    
    
    
    public void bulk_print_item(List<production_recipe> recipe_to_be_printed)
    {
        System.out.println("RECIPE SIZE = "+recipe_to_be_printed.size());
        
        if(recipe_to_be_printed.size()>1)
        {
            recipe_to_be_printed = this.merge_design_colorways(recipe_to_be_printed);
            for(int iterate =0; iterate<recipe_to_be_printed.size(); iterate++)
            {
                if(iterate ==0 )
                {
                    SpreadsheetTrial newTrial2 = new SpreadsheetTrial();
                    newTrial2.print_this_job2(recipe_to_be_printed.get(iterate), "file1");
                }
                else
                {
                    File f1 = new File("file1.odt");
                    File f2 = new File("file2.odt");
                    ODSingleXMLDocument p1;
                    try {
                        p1 = ODSingleXMLDocument.createFromPackage(f1);
                        this.print_this_job2(recipe_to_be_printed.get(iterate), "file2");
                        ODSingleXMLDocument p2 = ODSingleXMLDocument.createFromPackage(f2);
                        p1.add(p2);
                        p1.saveToPackageAs(new File("PrintFile"));
                    } catch (JDOMException ex) {
                    Logger.getLogger(SpreadsheetTrial.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(SpreadsheetTrial.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        else
        {
            SpreadsheetTrial newTrial2 = new SpreadsheetTrial();
            newTrial2.print_this_job2(recipe_to_be_printed.get(0), "PrintFile");
        }
    }
        
    /**
     * @param this_purchase
     */
    /*
    public void print_this_job(Job_purchase_link_functions this_purchase, production_recipe for_production){
        // TODO code application logic here
         
        try {
            File templateFile = new File(in);
            File outFile = new File(out);
            RhinoTemplate template = new RhinoTemplate(templateFile);
            
            String all_job_id = this_purchase.get_all_job_id();
            //System.out.println(all_job_id);
            String all_customer = this_purchase.get_all_customers();
            String quantity_all = this_purchase.get_all_quantity();
            int quantity_sum = this_purchase.get_quantity_sum();
            quantity_all = quantity_all +"="+Integer.toString(quantity_sum);
            
           //FOR DESIGN
            //Design_colorway_link_functions this_design = this_purchase.getNew_des_col_link();
            
            // Fill with sample values.
            template.setField("customer", all_customer);
            template.setField("job", all_job_id);
            template.setField("desCode", this_purchase.getDesign_code());
            //template.setField("desName", this_design.getDesign_name());
            template.setField("date", this_purchase.getDate());
            //template.setField("fabStyle", this_design.getFabric_style());
            template.setField("quant", quantity_all);
            //template.setField("color", this_design.getColor_name());
// FOR COLORWAY
            
        }  
    }
    */
    private static Map<String, String> createMap2(Colorway_screen_link_functions this_color_screen)
    {
         final Map<String, String> res = new HashMap<String, String>();
         res.put("no", Integer.toString(screen_count++));
         res.put("screen2", this_color_screen.getColorway_name());
         res.put("kil2"   , Float.toString(this_color_screen.getWeight_kg()));
         res.put("bind2"  , Float.toString(this_color_screen.getBinder()));
         
         List<Pigment_screen_and_colorway> the_screens = this_color_screen.getThis_screens();
         int x = 1;
         while(x<=the_screens.size())
            {
                res.put("name"+x, the_screens.get(x-1).getPigment_name() );
                res.put("per"+x, Float.toString(the_screens.get(x-1).getPigment_percentage() ));
                res.put("kilo"+x, the_screens.get(x-1).compute_kg_prep(this_color_screen.getWeight_kg()));
                x++;
            }
         
         while(x<=3)
            {
                res.put("name"+x, "");
                res.put("per"+x, "");
                res.put("kilo"+x, "");
                x++;
            }
         
        return res;
    }
    private static Map<String, String> fakeMap2()
    {
         final Map<String, String> res = new HashMap<String, String>();
         res.put("no", Integer.toString(screen_count++));
         res.put("screen2", "");
         res.put("kil2"   , "");
         res.put("bind2"  , "___");
         int x=1;
         while(x<=3)
            {
                res.put("name"+x, "");
                res.put("per"+x, "");
                res.put("kilo"+x, "");
                x++;
            }
         
        return res;
    }
    /*
    private static Map<String, String> createMap(String screen_name, String prep_kilo, String max, String screen, String kilo, String bind) {
        final Map<String, String> res = new HashMap<String, String>();
        res.put("name", screen_name);
        res.put("name2", "Hello");
        res.put("name3", "Hello2");
        res.put("kilo1", kilo);
        res.put("kilo2", kilo);
        res.put("kilo3", kilo);
        res.put("per1", kilo);
        res.put("per2", kilo);
        res.put("per3", kilo);
                
        //res.put("min", min);
        //res.put("max", max);
        res.put("screen2", prep_kilo);
        res.put("kil2", max);
        res.put("bind2", max);
        return res;
    }
    */
    
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
    

    static File copyFileToTmp(File in) throws IOException {
		File out = File.createTempFile(UUID.randomUUID().toString(), null);
		try (FileInputStream inStream = new FileInputStream(in);
				FileOutputStream outStream = new FileOutputStream(out);
				FileChannel inChannel = inStream.getChannel();
				FileChannel outChannel = outStream.getChannel();) {
			inChannel.transferTo(0, inChannel.size(), outChannel);
		} catch (IOException e) {
			throw e;
		}
		return out;
	}
}
