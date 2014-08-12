/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eldridge
 */
public class DB_Manager {
   
    public boolean add_textile(String customer_name)
    {
        DBConnection dbc = new DBConnection();
        Connection conn = dbc.getConnection();
        
        ResultSet rs = null;
        return rs;
    }
    
    public boolean add_screen_pigment()
    {
        
    }
    
    public int get_pigment_id(String pigment_name)
    {
        try 
        {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
    
        
            PreparedStatement ps =
            conn.prepareStatement("SELECT pigment_id FROM pigment WHERE pigment_id = ?");
            int item = 1;
            
            ps.setString(item++, pigment_name);
            ResultSet rs = ps.executeQuery();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
            
                
}
