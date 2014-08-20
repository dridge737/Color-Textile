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
        
        return false;
    }
    
    public boolean add_screen_pigment(colortextile_class.screen_pigment new_screen_pigment)
    {
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();
        
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("INSERT INTO screen_pigment (pigment_no, pigment_percentage, id_colorway) VALUES (?,?,?)");
        
        int item = 1;
        
        ps.setInt(item++, new_screen_pigment.getPigment_no());
        ps.setFloat(item++, new_screen_pigment.getPigment_percentage());
        ps.setInt(item++, new_screen_pigment.getId_colorway());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    public int get_pigment_id(String pigment_name)
    {
        try 
        {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
    
        
            PreparedStatement ps = conn.prepareStatement("SELECT pigment_no FROM pigment WHERE pigment_name = ?");
            int item = 1;
            
            ps.setString(item++, pigment_name);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int pigment_id = rs.getInt("pigment_no");
            return pigment_id;
            
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return 0;
    }
    
    public void add_customer_data(String name) {
        try {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();

            String query = "insert into simpledb (customer_name) values (?)";

            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, name);

            preparedStmt.execute();

        } catch (Exception ex) {
            System.out.println(ex);

        }

    }
           
    public int trial_Commit()
    {
        return 0;
    }
    
                
}
