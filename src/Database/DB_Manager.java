/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;

import colortextile_class.*;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    
    public boolean add_customer(colortextile_class.customer new_customer) {
        try {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();

            String query = "INSERT INTO customer (customer_name) VALUES (?)";

            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, new_customer.getCustomer_name());

            preparedStmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    public boolean add_colorway(colortextile_class.colorway new_colorway)
    {
        try{
        
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = conn.prepareStatement("INSERT INTO colorway (colorway_name, binder, weight_kg)"
                                                       + "VALUES (?, ?, ?);");
            int item =1;
            ps.setString(item++, new_colorway.getColorway_name());
            ps.setFloat(item++, new_colorway.getBinder());
            ps.setFloat(item++, new_colorway.getWeight_kg());
            
            ps.executeUpdate(); 
            return true;
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        return false;
    }
    
    public boolean add_colorway_and_screen_connect(int id_screen, int id_colorway)
    {
        try{
        
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = conn.prepareStatement("INSERT INTO colorway_and_screen_screen (id_screen, id_colorway)"
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
    
    public boolean add_design_colorway_connect(String design_code, int id_colorway)
    {
        try{
        
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = conn.prepareStatement("INSERT INTO design_colorway_connect(design_code, id_colorway)"
                                                       + "VALUES (?, ?);");
            int item = 1;
            ps.setString(item++, design_code);
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

    public boolean add_design(colortextile_class.design new_design)
    {
         try{
        
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = conn.prepareStatement("INSERT INTO design (design_code, design_name) VALUES (?, ?);");
            
            int item = 1;
            ps.setString(item++, new_design.getDesign_code());
            ps.setString(item++, new_design.getDesign_name()); 
            
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
    
    ///////////////////////////////////////////////////////////////////////////////////////////
        
    //GET START
    ///GET and search function here
    ///Start every function with get_* or search_*
  

    public int get_id_pigment(String pigment_name)
    {
        try 
        {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
    
            PreparedStatement ps = conn.prepareStatement("SELECT pigment_no FROM pigment WHERE pigment_name = ?");
            int item = 1;
            ps.setString(item++, pigment_name);
            ResultSet rs = ps.executeQuery();
            if(rs.first())
            {
                rs.next();
                int pigment_id = rs.getInt("pigment_no");
                return pigment_id;
            }   
            
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return -1;
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
            if(rs.first())
            {
                rs.next();
                int id_screen = rs.getInt("id_screen");
                return id_screen;
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return -1;
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
            if(rs.first())
            {
                rs.next();
                int id_color_screen = rs.getInt("id_color_screen");
                return id_color_screen;
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return -1;
    }
    
    public int get_id_colorway(colortextile_class.colorway existing_colorway)
    {
        try{
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = 
            conn.prepareStatement("SELECT id_colorway FROM colorway WHERE colorway_name = ? AND binder = ? AND weight_kg = ?;");
            
            int item = 1;
            ps.setString(item++, existing_colorway.getColorway_name());
            ps.setFloat(item++, existing_colorway.getBinder());
            ps.setFloat(item++, existing_colorway.getWeight_kg());
            
            ResultSet rs = ps.executeQuery();
            if(rs.first())
            {
                rs.next();
                int id_colorway = rs.getInt("id_colorway");
                return id_colorway;
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return -1;
    }
    
    public String get_design_code(colortextile_class.design new_design)
    {
        try{
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = 
            conn.prepareStatement("SELECT design_code FROM design WHERE design_name = ?");
            int item = 1;
            ps.setString(item++, new_design.getDesign_name());
            ResultSet rs = ps.executeQuery();
            if(rs.first())
            {
                rs.next();
                String design_code = rs.getString("design_code");
                return design_code;
            }
            
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public ArrayList<String> get_all_pigment_name()
    {
        try
        {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT pigment_name FROM pigment");
            ResultSet rs = ps.executeQuery();
            ArrayList<String> pigment_list = new ArrayList<String>();
            while(rs.next())
            {
                pigment_list.add(rs.getString(1));
            }
            return pigment_list;
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
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
    
    public int get_id_customer(String customer_name)
    {
        try
        {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
        
            PreparedStatement ps = conn.prepareStatement("SELECT id_customer FROM customer WHERE customer_name = ?");
            int item = 1;
            
            ps.setString(item++, customer_name);
            ResultSet rs = ps.executeQuery();
            if(rs.first())
            {
                rs.next();
                int customer_id = rs.getInt("id_customer");
                return customer_id;
            }
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public ArrayList<String> get_customer_list() 
    {
        //winston: is this right?
        
        ArrayList<String> names = new ArrayList<>();
        try
        {
          DBConnection db = new DBConnection();
          Connection conn = db.getConnection();  
          
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM customer ");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                names.add(rs.getString("customer_name"));
            }
            return names;
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
            
    
    //GET END
    
    ///////////////////////////////////////////////////////////////////////////////////////////
    
    //UPDATE START
    ///EDIT and UPDATE function for SQL
    ///START all functions here with update_*
    
    //UPDATE END
    
    ///////////////////////////////////////////////////////////////////////////////////////////
    
    //DELETE START
    ///DELETE function for SQL
    ///START all function here with delete_*
    
    //DELETE END
     
}
