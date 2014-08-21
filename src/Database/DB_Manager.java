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
   
    //ADD START
    ///Add functions for sql
    ///Start function names with add_*
    
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
       
        try {
             PreparedStatement ps = conn.prepareStatement("INSERT INTO screen_pigment (pigment_no, pigment_percentage) VALUES (?,?)");
        
        int item = 1;
        
        ps.setInt(item++, new_screen_pigment.getPigment_no());
        ps.setFloat(item++, new_screen_pigment.getPigment_percentage());
        ps.executeUpdate();
        return true;
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public void add_customer_data(String name) {
        try {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();

            String query = "insert into customer (customer_name) values (?)";

            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, name);

            preparedStmt.execute();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public boolean add_colorway_and_screen(int id_screen, int id_colorway)
    {
        try{
        
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = conn.prepareStatement("INSERT INTO colorway_and_screen (id_screen, id_colorway)"
                                                       + "VALUES (?, ?);");
            int item =1;
            ps.setInt(item++, id_screen);
            ps.setInt(item++, id_colorway);
            ps.executeUpdate();
            return true;
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        return false;
    }
    
    public boolean add_textile(colortextile_class.textile new_textile)
    {
        try{
        
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = conn.prepareStatement("INSERT INTO textile (textile_code, textile_name) VALUES (?,?);");
            int item = 1;
            ps.setString(item++, new_textile.getTextile_code());
            ps.setString(item++, new_textile.getTextile_name());
            
            ps.executeUpdate();
            return true;
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        return false;
    }
    
    public boolean add_design(colortextile_class.design new_design)
    {
         try{
        
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = conn.prepareStatement("INSERT INTO design (design_code, textile_code) VALUES (?, ?);");
            
            int item = 1;
            ps.setString(item++, new_design.getDesign_code());
            ps.setString(item++, new_design.getTextile_code()); 
            
            ps.executeUpdate();
            return true;
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        return false;
    }
    
    //ADD END
    
    //GET START
    ///GET and search function here
    ///Start every function with get_* or search_*
  

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
    
    public int get_id_screen(int pigment_no, float pigment_percentage)
    {
        try{
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = 
            conn.prepareStatement("SELECT id_screen FROM screen_pigment WHERE pigment_no = ? AND pigment_percentage =?");
            int item = 1;
            ps.setInt(item++, pigment_no);
            ps.setFloat(item++, pigment_percentage);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int id_screen = rs.getInt("id_screen");
            
            return id_screen;
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    public int get_id_color_screen(int id_screen, int id_colorway)
    {
        try{
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = 
            conn.prepareStatement("SELECT id_color_screen FROM colorway_and_screen WHERE id_screen = ? AND id_colorway = ?");
            int item = 1;
            
            ps.setInt(item++, id_screen);
            ps.setInt(item, id_colorway);
            
            ResultSet rs = ps.executeQuery();
            rs.next();
            int id_color_screen = rs.getInt("id_color_screen");
            
            return id_color_screen;
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    public int get_id_colorway()
    {
        return 0;
    }
    
    //SKELETON TO COPY ONLY. Not usable
    public void get_skeleton()
    {
        try{
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = 
            conn.prepareStatement("SELECT  FROM  WHERE ");
            int item = 1;
            
            
            
            ResultSet rs = ps.executeQuery();
            rs.next();
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
    //GET END
    
    //UPDATE START
    ///EDIT and UPDATE function for SQL
    ///START all functions here with update_*
    
    //UPDATE END
    
    //DELETE START
    ///DELETE function for SQL
    ///START all function here with delete_*
    
    //DELETE END
     
}
