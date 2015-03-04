/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Unused;

import Database.DBConnection;
import Database.DB_Manager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eldridge
 */
public class UnusedCodes {
    public boolean add_design_colorway_connect(int design_code, int id_colorway)
    {
        try{
        
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = conn.prepareStatement("INSERT INTO design_colorway_connect(design_code, id_colorway)"
                                                       + "VALUES (?, ?);");
            int item = 1;
            ps.setInt(item++, design_code);
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
    public int get_id_design_colorway(design_colorway new_des_color)
    {
        try{
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = 
            conn.prepareStatement("SELECT id_design_colorway "
                                 + "FROM design_colorway_connect "
                                 + "WHERE design_code = ? "
                                 + "AND id_colorway = ? ");
            
            int item = 1;
            ps.setInt(item++, new_des_color.getDesign_code());
            ps.setFloat(item++, new_des_color.getId_colorway());
            /* 
            System.out.println("Design Code :" +new_des_color.getDesign_code());
            System.out.println("Colorway Id :"  new_des_color.getId_colorway());
            */
            ResultSet rs = ps.executeQuery();
            if(rs.first())
            {
                int id_design_colorway = rs.getInt("id_design_colorway");
             //   System.out.println(id_colorway);
                return id_design_colorway;
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public void delete_design_colorway_connect(design_colorway connection_Del)
    {
         try
        {
          DBConnection db = new DBConnection();
          Connection conn = db.getConnection(); 
          
          PreparedStatement ps = conn.prepareStatement("DELETE FROM design_colorway_connect "
                                                        +" WHERE id_colorway = ? AND design_code = ?");
          int item = 1;
          ps.setInt(item++, connection_Del.getId_colorway());
          ps.setInt(item++, connection_Del.getDesign_code());
          
          ps.executeUpdate();
          
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
}
