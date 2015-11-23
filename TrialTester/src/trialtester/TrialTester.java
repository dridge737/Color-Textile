/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trialtester;

/**
 *
 * @author Eldridge
 */
public class TrialTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello");
        
        String trialString[] = new String[2];
        trialString[0] = "1335.4";
        trialString[1] = "12245.6.";
        
        for(int x= 0; x <trialString.length; x++)
        {    
            if(trialString[x].indexOf(".") != trialString[x].lastIndexOf("."))
            {
                StringBuilder textfield_sb = new StringBuilder(trialString[x]);
                int last_index_of_point = textfield_sb.lastIndexOf(".");
                textfield_sb.deleteCharAt(last_index_of_point);
                trialString[x]= textfield_sb.toString();
            }
                System.out.println("2 Decimals present index = "+x+" value is = " +trialString[x]);
        }
        
    }
    
}
