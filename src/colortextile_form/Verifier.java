/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package colortextile_form;

import java.awt.Color;
import java.util.regex.Pattern;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.InputVerifier;
/**
 *
 * @author Eldridge
 */
public class Verifier extends InputVerifier{
    public Verifier(){}
    
    @Override
    public boolean verify(JComponent input)
    {
        JTextField textField = (JTextField) input;
        
        String regex = "\\D";
        Pattern p = Pattern.compile(regex);
        if(textField.getText().matches(regex))
        {
            input.setBackground(Color.red);
            return true;
        }
        input.setBackground(Color.white);
        return false;
    }
}
