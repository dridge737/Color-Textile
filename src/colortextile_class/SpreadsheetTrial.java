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
import org.jopendocument.dom.ODSingleXMLDocument;
import org.jopendocument.dom.OOXML;
import org.jopendocument.dom.XMLVersion;
import org.jopendocument.dom.template.JavaScriptTemplate;
import org.jopendocument.util.JDOMUtils;
import org.jdom.Attribute;
import org.jdom.Element;
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
            
            final List<Map<String, String>> print = new ArrayList<Map<String, String>>();
            int y = 1;
            
            for(Colorway_screen_link_functions current_colorway : this_colorway)
            {
                print.add(createMap2(current_colorway));
                y++;
            }
            
            while(y<7)
            {
                print.add(fakeMap2());
                y++;
            }
            screen_count = 2;
            template.setField("print", print);
            // Save to file.
            /*final String bcfile = "New.jpg";
            
            File image = new File(bcfile);
            if (image.exists() && image.canRead()) {
            final ODSingleXMLDocument ddoc = template.createDocument();
            File tmp = copyFileToTmp(image);
            
            ddoc.getDescendantByName("draw:frame", "graphics1").setAttribute("href", tmp.toURI().toURL().toString(), ns); 
            ddoc.saveToPackageAs(outFile); 
            }
            else
                
            */
            template.saveAs(outFile);
            
         }
         catch (Exception e) {
            e.printStackTrace();
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
