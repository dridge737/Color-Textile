/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colortextile_class;
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

   
	//static Namespace ns = Namespace.getNamespace("xlink", "http://www.w3.org/1999/xlink");
        
        static String in = "Printext.odt";

	static final String out = "sample_out2.odt";
        
        static Namespace ns = Namespace.getNamespace("xlink", "http://www.w3.org/1999/xlink");
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
         
        try {
           
            File templateFile = new File(in);
            File outFile = new File(out);
            
            // Load the template.
            RhinoTemplate template = new RhinoTemplate(templateFile);

            // Fill with sample values.
            template.setField("customer", "CustomerName");
            template.setField("job", "JobId");
            template.setField("desCode", "");
            template.setField("desName", "Design Name");
            template.setField("date", "Date");
            template.setField("fabStyle", "Fabric Style");
            template.setField("quant", "2");
            template.setField("speed", "");
            
             template.showSection("sec1");
             template.setField("screen1", "Temp");
            template.setField("kilo1", "12");
            template.setField("bind1", "Helo");
            //template.hideSection("sec1");
            final List<Map<String, String>> print = new ArrayList<Map<String, String>>();
            print.add(createMap("January", "-12", "3", "", "5", ""));
            print.add(createMap("February", "-8", "5", "", "65", ""));

            template.setField("print", print);
            
            
           
            template.hideSection("sec1");
            template.hideSection("sec3");
            template.hideSection("sec4");
            template.hideSection("sec5");
            template.hideSection("sec6");
            template.hideSection("sec7");
            // Save to file.
            final String bcfile = "Book3d.jpg";
            
            File image = new File(bcfile);

            final ODSingleXMLDocument ddoc = template.createDocument();
            File tmp = copyFileToTmp(image);
            
            
            ddoc.getDescendantByName("draw:frame", "graphics1").setAttribute("href", tmp.toURI().toURL().toString(), ns); 
            
                
            ddoc.saveToPackageAs(outFile); 
            

           
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    private static Map<String, String> createMap(String n, String min, String max, String screen, String kilo, String bind) {
        final Map<String, String> res = new HashMap<String, String>();
        res.put("name", n);
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
        res.put("screen2", min);
        res.put("kil2", max);
        res.put("bind2", max);
        return res;
    }
    

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
