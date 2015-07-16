/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;

import Unused.screen_pigment;
import colortextile_class.*;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eldridge
 */
public class DB_Manager {
   
   //Close Connection; 
    private void closeConn(Connection conn, PreparedStatement ps)
    {
        try {
            conn.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    // OVERLOAD
    private void closeConn(Connection conn, PreparedStatement ps, ResultSet rs)
    {
        try {
            conn.close();
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //ADD START
    ///Add functions for sql
    ///Start function names with add_*
    
    public boolean add_fabric_style(String fabric_name)
    {
        DBConnection dbc = new DBConnection();
        Connection conn = dbc.getConnection();
        
        try {
             PreparedStatement ps = 
                     conn.prepareStatement("INSERT INTO fabric_style (fabric_name) "
                                            + "VALUES (?)");
        
        int item = 1;
        
        ps.setString(item++, fabric_name.toUpperCase());
        ps.executeUpdate();
        
        this.closeConn(conn, ps);
        
        return true;
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    public int count_number_of_pigment()
    {
        int total = -1;
        try {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT COUNT(pigment_no) AS 'Total' FROM pigment");
           
            ResultSet rs = ps.executeQuery();
            
            rs.first();
            total = rs.getInt("Total");
            this.closeConn(conn, ps, rs);
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }
    
    public boolean add_pigment(colortextile_class.pigment this_pigment)
    {
        try {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO pigment(pigment_name) VALUES (?)");

            int item = 1;
            ps.setString(item++, this_pigment.getPigment_name().toUpperCase());

            ps.executeUpdate();
            this.closeConn(conn, ps);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    
    public int check_if_customer_exists(String customer_name)
    {
        try {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT EXISTS "
                    + " (SELECT id_customer "
                    + " FROM customer WHERE "
                    + " customer_name = ?) "
                    + " AS 'CheckTest'");

            int item = 1;
            ps.setString(item++, customer_name);

            ResultSet rs = ps.executeQuery();
            
            rs.first();
            int checkTest = rs.getInt("CheckTest");
            
            this.closeConn(conn, ps, rs);
            return checkTest;
            
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public int check_if_job_order_exists(colortextile_class.job_order this_job)
    {
        try {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT EXISTS "
                    + " (SELECT job_order_id "
                    + " FROM job_order WHERE "
                    + " job_order_id = ?) "
                    + " AS 'CheckTest'");

            int item = 1;
            ps.setString(item++, this_job.getJob_id());

            ResultSet rs = ps.executeQuery();
            
            rs.first();
            int checkTest = rs.getInt("CheckTest");
            this.closeConn(conn, ps, rs);
            return checkTest;
            
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public int check_if_pigment_exists(colortextile_class.pigment this_pigment)
    {
        try {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT EXISTS "
                    + " (SELECT pigment_no "
                    + " FROM pigment WHERE "
                    + " pigment_name = ?) "
                    + " AS 'CheckTest'");

            int item = 1;
            ps.setString(item++, this_pigment.getPigment_name());

            ResultSet rs = ps.executeQuery();
            
            rs.first();
            int checkTest = rs.getInt("CheckTest");
            
            this.closeConn(conn, ps);
            return checkTest;
            
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public boolean add_customer(colortextile_class.customer new_customer) {
        try {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();

            String query = "INSERT INTO customer (customer_name) VALUES (?)";

            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, new_customer.getCustomer_name().toUpperCase());

            preparedStmt.execute();
            
            this.closeConn(conn, preparedStmt);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean add_purchase_order(colortextile_class.purchase_order new_purchase) {
        try {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
        
            String query = "INSERT INTO purchase_order (quantity, design_code, job_order_id) VALUES (?, ?, ?)";
            
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, new_purchase.getQuantity());
            preparedStmt.setInt(2, new_purchase.getDesign_code());
            preparedStmt.setString(3, new_purchase.getJob_order_id());
            
            preparedStmt.execute();
            
            this.closeConn(conn, preparedStmt);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
               return false;
        }
    }
    
    public boolean add_colorway(colortextile_class.colorway new_colorway)
    {
        try{
        
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = conn.prepareStatement("INSERT INTO colorway (colorway_name, binder, weight_kg, design_code)"
                                                       + "VALUES (? , ROUND(?, 2) , ROUND(?, 2) , ?)");
            int item =1;
            ps.setString(item++, new_colorway.getColorway_name().toUpperCase());
            ps.setFloat(item++, new_colorway.getBinder());
            ps.setFloat(item++, new_colorway.getWeight_kg());
            ps.setInt(item++, new_colorway.getDesign_code());
            
            ps.executeUpdate(); 
            
            this.closeConn(conn, ps);
            return true;
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        return false;
    }
    
    public boolean add_colorway_and_screen_connect(int id_pigment, int id_colorway, float pigment_percentage)
    {
        try{
        
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = conn.prepareStatement("INSERT INTO colorway_and_pigment "
                                                       + "(pigment_no, id_colorway, pigment_percentage)"
                                                       + "VALUES (?, ?, ?);");
            int item =1;
            ps.setInt(item++, id_pigment);
            ps.setInt(item++, id_colorway);
            ps.setFloat(item++, pigment_percentage);
            ps.executeUpdate();
            
            this.closeConn(conn, ps);
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
            
            PreparedStatement ps = conn.prepareStatement("INSERT INTO design (design_name, color_name, fabric_style) "
                                                        + "VALUES ( ? , ? , ? )");
            int item = 1;
            ps.setString(item++, new_design.getDesign_name().toUpperCase()); 
            ps.setString(item++, new_design.getColor_name().toUpperCase());
            ps.setString(item++, new_design.getFabric_style().toUpperCase());
          
            ps.executeUpdate();
            //System.out.println("Another Result = " +hello);
            this.closeConn(conn, ps);
            return true;
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        return false;
    }
    
    public boolean add_job_order(colortextile_class.job_order new_job)
    {
            try 
            {
                DBConnection db = new DBConnection();
                Connection conn = db.getConnection();
            
                String query = "INSERT INTO job_order (job_order_id, date, customer_id) VALUES (?, ?, ?)";

                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, new_job.getJob_id());
                preparedStmt.setString(2, new_job.getDate());
                preparedStmt.setInt(3, new_job.getCustomer_id());
                
                preparedStmt.execute();
                
                this.closeConn(conn, preparedStmt);
                return true;
            } 
            catch (SQLException ex) {
                Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return false;
    }
    //ADD END
    
    //DELETE START
    ///DELETE function here
    ///Start every function with delete_*
    public boolean delete_design_and_colorway_con_from_id_colorway(int id_colorway)
    {
        try {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();  
        
            PreparedStatement ps = conn.prepareStatement("DELETE FROM colorway_and_pigment WHERE id_colorway = ?");
        
            int item = 1;
            ps.setInt(item++, id_colorway);
            ps.executeUpdate();
            
            this.closeConn(conn, ps);
            return true;
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;      
        
    }
    
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
    
            PreparedStatement ps = 
                    conn.prepareStatement("SELECT pigment_no "
                    + "FROM pigment "
                    + "WHERE pigment_name = ?");
            int item = 1;
            ps.setString(item++, pigment_name);
            
            ResultSet rs = ps.executeQuery();
            if(rs.first())
            {
                int pigment_id = rs.getInt("pigment_no");
                //System.out.println(pigment_id);
                this.closeConn(conn, ps, rs);
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
            conn.prepareStatement("SELECT id_screen "
                                + "FROM screen_pigment "
                                + "WHERE pigment_no = ? "
                                + "AND pigment_percentage BETWEEN ? AND ?");
            int item = 1;
            ps.setInt(item++, pigment_no);
            ps.setFloat(item++, pigment_percentage);
            ps.setFloat(item++, pigment_percentage);
            ResultSet rs = ps.executeQuery();
            if(rs.first())
            {
                int id_screen = rs.getInt("id_screen");
                
                this.closeConn(conn, ps, rs);
                return id_screen;
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return -1;
    }
    
    public List<Screen_and_colorway_link> set_all_colorway_from_design_code(int this_design_code)
    {
        try{
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = 
            conn.prepareStatement("SELECT * " 
                                + "FROM colorway "
                                + "WHERE design_code = ? "
                                + " ORDER BY id_colorway");
/*                                + "IN (SELECT id_colorway "
                                    + " FROM design_colorway_connect "
                                    + " WHERE design_code = ?) ");
  */          
            int item = 1;
            ps.setInt(item++, this_design_code);
            
            List<Screen_and_colorway_link> all_color_screen = new ArrayList<>();
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                Screen_and_colorway_link current_colorway = new Screen_and_colorway_link();
                
                current_colorway.setBinder(rs.getFloat("binder"));
                current_colorway.setColorway_name(rs.getString("colorway_name"));
                current_colorway.setWeight_kg(rs.getFloat("weight_kg"));
                current_colorway.setId_colorway(rs.getInt("id_colorway"));
                current_colorway.setDesign_code(this_design_code);
                all_color_screen.add(current_colorway);
                //System.out.println(rs.getString("colorway_name"));
            }
            
            this.closeConn(conn, ps, rs);
            return all_color_screen;
            
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Colorway_and_pigment> set_all_colorway_and_screen_from_colorway_id(int colorway_id)
    {
        try{
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = 
            conn.prepareStatement("SELECT id_color_screen, p.pigment_no, pigment_percentage, p.pigment_name " 
                                 + " FROM colorway_and_pigment s_p, pigment p" 
                                 + " WHERE id_colorway = ? "
                                 + " AND s_p.pigment_no = p.pigment_no "
                                 + " ORDER BY id_color_screen ASC");
            int item = 1;
            ps.setInt(item++, colorway_id);
            
            ResultSet screen_rs = ps.executeQuery();
            List<Colorway_and_pigment> this_screen = new ArrayList<>();
            
            while(screen_rs.next())
            {
                Colorway_and_pigment this_s_pigment = new Colorway_and_pigment();
                
                this_s_pigment.setId_color_screen(screen_rs.getInt("id_color_screen"));
                this_s_pigment.setId_colorway(colorway_id);
                this_s_pigment.setPigment_no(screen_rs.getInt("p.pigment_no"));
                this_s_pigment.setPigment_percentage(screen_rs.getFloat("pigment_percentage"));
                this_s_pigment.setPigment_name(screen_rs.getString("p.pigment_name"));
                this_screen.add(this_s_pigment);
            }
            
            this.closeConn(conn, ps, screen_rs);
            return this_screen;
            
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    //Get all colorway details using the colorway_id
    public colorway set_colorway_details_from_colorway_id(int id_colorway)
    {
        try{
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = 
            conn.prepareStatement("SELECT colorway_name,  binder, weight_kg, design_code "
                                + "FROM colorway "
                                + "WHERE id_colorway = ?");
            int item = 1;
            
            ps.setInt(item++, id_colorway);
            ResultSet rs = ps.executeQuery();
            
            colorway this_colorway = new colorway();
            if(rs.first())
            {
                this_colorway.setId_colorway(id_colorway);
                this_colorway.setDesign_code(rs.getInt("design_code"));
                this_colorway.setColorway_name(rs.getString("colorway_name"));
                this_colorway.setBinder(rs.getFloat("binder"));
                this_colorway.setWeight_kg(rs.getFloat("weight_kg"));
            }
            
            this.closeConn(conn, ps, rs);
            return this_colorway;
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
    }
    
    public pigment get_last_pigment_id_and_name()
    {
        pigment last_added_pigment = new pigment();
        try
        {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = conn.prepareStatement("SELECT pigment_name, pigment_no FROM pigment WHERE pigment_no = (SELECT MAX(pigment_no) FROM pigment);");
            
            ResultSet rs = ps.executeQuery();
            
             if(rs.first())
            {
                last_added_pigment.setPigment_no(rs.getInt("pigment_no"));
                last_added_pigment.setPigment_name(rs.getString("pigment_name"));
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return last_added_pigment;
    }
    
    public int get_id_color_screen(int id_screen, int id_colorway , float pigment_percentage)
    {
        int id_color_screen = -1;
        try{
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = 
            conn.prepareStatement("SELECT id_color_screen "
                                + " FROM colorway_and_pigment "
                                + " WHERE id_screen = ? "
                                + " AND id_colorway = ?"
                                + " AND pigment_percentage = ?");
            int item = 1;
            
            ps.setInt(item++, id_screen);
            ps.setInt(item++, id_colorway);
            ps.setFloat(item++, pigment_percentage);
            ResultSet rs = ps.executeQuery();
            
            if(rs.first())
            {
                id_color_screen = rs.getInt("id_color_screen");
            }
            
            this.closeConn(conn, ps, rs);
            return id_color_screen;
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id_color_screen;
    }
    
    public int get_id_colorway(colortextile_class.colorway existing_colorway)
    {
        int id_colorway = -1;
        try{
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = 
            conn.prepareStatement("SELECT id_colorway "
                                 + " FROM colorway "
                                 + " WHERE colorway_name LIKE ? "
                                 + " AND binder <=> ROUND (?, 2) "
                                 + " AND design_code = ?"
                                 + " AND weight_kg BETWEEN ? AND ?");
            
            int item = 1;
            ps.setString(item++, existing_colorway.getColorway_name());
            ps.setFloat(item++, existing_colorway.getBinder());
            ps.setInt(item++, existing_colorway.getDesign_code());
            ps.setFloat(item++, existing_colorway.getWeight_kg()- (float) 0.01);
            ps.setFloat(item++, existing_colorway.getWeight_kg()+ (float) 0.01);
            
            //System.out.println("Colorway name :" +existing_colorway.getColorway_name());
            //System.out.println("Binder :" +existing_colorway.getBinder());
            //System.out.println("Weight Kg :" +existing_colorway.getWeight_kg());
            
            ResultSet rs = ps.executeQuery();
            if(rs.first())
            {
                id_colorway= rs.getInt("id_colorway");
             //   System.out.println(id_colorway);
            }
            this.closeConn(conn, ps, rs);
            return id_colorway;
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return -1;
    }
    
    public design set_design_details_from_des_code(int code_design)
    {
        try{
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = 
            conn.prepareStatement("SELECT * FROM design WHERE design_code = ?");
            int item = 1;
            ps.setInt(item++, code_design);
            
            ResultSet rs = ps.executeQuery();
            
            design this_design = new design();
            if(rs.first())
            {
                this_design.setColor_name(rs.getString("color_name"));
                this_design.setDesign_name(rs.getString("design_name"));
                this_design.setFabric_style(rs.getString("fabric_style"));
            }
            
            this.closeConn(conn, ps, rs);
            return this_design;
            
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public int get_design_code(colortextile_class.design new_design)
    {
        int design_code = -1;
        try{
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = 
            conn.prepareStatement("SELECT design_code "
                    + "FROM design "
                    + "WHERE design_name = ? "
                    + "AND color_name = ? "
                    + "AND fabric_style = ?");
            int item = 1;
            ps.setString(item++, new_design.getDesign_name());
            ps.setString(item++, new_design.getColor_name());
            ps.setString(item++, new_design.getFabric_style());
            ResultSet rs = ps.executeQuery();
            
            if(rs.first())
            {
                design_code = rs.getInt("design_code");
            }
            this.closeConn(conn, ps, rs);
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return design_code;
    }
    
    public ArrayList<String> get_all_pigment_name()
    {
        try
        {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT pigment_name FROM pigment ORDER BY pigment_name asc");
            ResultSet rs = ps.executeQuery();
            ArrayList<String> pigment_list = new ArrayList<String>();
            while(rs.next())
            {
                pigment_list.add(rs.getString(1));
            }
            this.closeConn(conn, ps, rs);
            return pigment_list;
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
    }
    
    /**
     * 
     * @param id_pigment
     * @return pigment_name
     */
    public String get_pigment_name(int id_pigment)
    {
        try{
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = 
            conn.prepareStatement("SELECT pigment_name "
                                 + "FROM pigment "
                                 + "WHERE pigment_no = ? ");
            
            int item = 1;
            ps.setInt(item++, id_pigment);
            
            ResultSet rs = ps.executeQuery();
            String pigment_name = null;
            if(rs.first())
            {
                pigment_name = rs.getString("pigment_name");
            }
            this.closeConn(conn, ps, rs);
            return pigment_name;
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
            return null;
    }
    
    //EDITING
    /**
     * Get the pigment id and percentage from screen_pigment table
     * @param id_screen
     * @return 
     */
    
    public int get_pigment_percentage(int id_screen)
    {
        int pigment_percentage = -1;
        try{
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = 
            conn.prepareStatement("SELECT pigment_percentage "
                                 + "FROM screen_pigment "
                                 + "WHERE id_screen = ? ");
            
            int item = 1;
            ps.setInt(item++, id_screen);
            ResultSet rs = ps.executeQuery();
            
            if(rs.first())
            {
                pigment_percentage = rs.getInt("pigment_percentage");
            }
            this.closeConn(conn, ps, rs);
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
            return pigment_percentage;
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
    //returns id_purchase
    public int get_id_customer_name(colortextile_class.customer id_customer){
        
        int id_cus = -1;
        try{
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = 
            conn.prepareStatement("SELECT id_customer "
                                 + "FROM customer "
                                 + "WHERE customer_name = ? ");
            
            ps.setString(1, id_customer.getCustomer_name());
            
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                id_cus = rs.getInt("id_customer");
            }
            this.closeConn(conn, ps, rs);
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id_cus;
        
    }
    /***
     * 
     * @param customer_name
     * @return 0 if customer id is not found, else returns customer id taken from database
     */
    public int get_id_customer(String customer_name)
    {
        int customer_id = 0;
        try
        {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
        
            PreparedStatement ps = 
                    conn.prepareStatement("SELECT id_customer "
                    + "FROM customer "
                    + "WHERE customer_name = '"+ customer_name + "'");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                customer_id = rs.getInt("id_customer");
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer_id;
    }
    
    //EDITING
    //GET CUSTOMER NAME 
    /**
     * 
     * @param customer_id the primary key of customer
     * @return return a single customer name
     */    
    public String get_customer_name(int customer_id)
    {
        String customer_name = null;
        try
        {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
        
            PreparedStatement ps = conn.prepareStatement("SELECT customer_name "
                                                        + "FROM customer "
                                                        + "WHERE id_customer = ?");
            
            int item = 1;
            ps.setInt(item++, customer_id);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                customer_name = rs.getString("customer_name");
            }
            this.closeConn(conn, ps, rs);
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer_name;
    }
    
    public int get_fabric_style_id(String fabric_name)
    {
        int fabric_id = -1;
        
        try{
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = 
            conn.prepareStatement("SELECT id_fabric FROM fabric_style WHERE fabric_name = ?");
            
            int item = 1;
            ps.setString(item++, fabric_name);
            
            ResultSet rs = ps.executeQuery();
            if(rs.first())
            {
                fabric_id = rs.getInt("id_fabric");
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fabric_id;
    }
    
    public ArrayList<String> get_all_fabric_styles()
    {
        try
        {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection(); 
            
            PreparedStatement ps = conn.prepareStatement("SELECT fabric_name FROM fabric_style ORDER BY fabric_style ASC ");
            ResultSet rs = ps.executeQuery();
            ArrayList<String> fabric_style = new ArrayList<>();
            while(rs.next())
            {
                fabric_style.add(rs.getString("fabric_name"));
            }
            this.closeConn(conn, ps, rs);
            return fabric_style;
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<String> get_customer_list(colortextile_class.customer customer_name) 
    {
        try
        {
          DBConnection db = new DBConnection();
          Connection conn = db.getConnection();  
          
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM customer ORDER BY customer_name ASC ");
            ResultSet rs = ps.executeQuery();
            ArrayList<String> names = new ArrayList<>();
            while(rs.next())
            {
                names.add(rs.getString("customer_name"));
            }
            customer_name.setCustomer_names(names);
            this.closeConn(conn, ps, rs);
            return names;
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
        
    }
    
    public List<purchase_order> get_all_purchase_for_this_job_order(colortextile_class.job_order this_job_order)
    {
        try
        {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection(); 
            
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM puchase_order WHERE job_order_id = ?");
            
            int item = 1;
            ps.setString(item++, this_job_order.getJob_id());
            
            ResultSet rs = ps.executeQuery();
            
            List<purchase_order> all_purchase_this_job = new ArrayList<purchase_order>();
            
            while(rs.next())
            {
                purchase_order this_purchase = new purchase_order();
                
                this_purchase.setQuantity(rs.getInt("quantity"));
                this_purchase.setDesign_code(rs.getInt("design_code"));
                this_purchase.setJob_order_id(this_job_order.getJob_id());
                this_purchase.setId_purchase(rs.getInt("id_purchase"));
                
                all_purchase_this_job.add(this_purchase);
            }
            this.closeConn(conn, ps, rs);
            return all_purchase_this_job;
            
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public ResultSet get_all_job_order(colortextile_class.job_order job_order)
    {
        try
        {
          DBConnection db = new DBConnection();
          Connection conn = db.getConnection();  
          
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM job_order");
            ResultSet rs = ps.executeQuery();
            
            return rs;
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
        
    }
    
    public colortextile_class.job_order get_job_order_details(String job_order_id)
    {
        colortextile_class.job_order this_job = new colortextile_class.job_order();
        this_job.setJob_id("-1");
        try
        {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection(); 
            PreparedStatement ps = conn.prepareStatement("SELECT * "
                                                        + " FROM job_order jo , customer cu "
                                                        + " WHERE job_order_id = ? "
                                                        + " AND jo.customer_id = cu.id_customer");
            int item = 1;
            ps.setString(item++, job_order_id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.first())
            {
                //this_job.setJob_id(job_order_id);
                this_job.setCustomer_id(rs.getInt("customer_id"));
                this_job.setDate(rs.getString("date"));
                this_job.setCustomer_name(rs.getString("customer_name"));
            }
            this.closeConn(conn, ps, rs);
            
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this_job;
    }
    
    public List<job_order> set_job_order_info_from_purchase_id(int purchase_id){
        try
        {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection(); 
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM job_order WHERE id_purchase = ?");
            
            int item = 1;
            ps.setInt(item++, purchase_id);
            
            ResultSet rs = ps.executeQuery();
            List<job_order> job_list = new ArrayList<job_order>();
            
            while(rs.next())
            {
                job_order this_job = new job_order();
                /*
                //FOR Debugging this job
                //System.out.println("Customer id = "+ rs.getInt("customer_id"));
                //System.out.println("Job Order = "+ rs.getString("job_order_id"));
                //System.out.println("Quantity = " +rs.getInt("quantity"));
                */
                this_job.setCustomer_id(rs.getInt("customer_id"));                
                this_job.setJob_id(rs.getString("job_order_id"));
                this_job.setDate(rs.getString("date"));
                //this_job.setQuantity(rs.getInt("quantity"));
                
                job_list.add(this_job);
            }
            this.closeConn(conn, ps, rs);
            /*
            for(job_order all_jobs : job_list)
            {
                all_jobs.display_details();
            }
            */
            return job_list;
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<purchase_order> get_all_purchase_details_from_date_and_design(String date, int des_code)
    {
        try
        {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection(); 
            
            PreparedStatement ps = 
                    conn.prepareStatement("SELECT jo.job_order_id, date, customer_id, id_purchase, quantity, design_code "
                    + " FROM purchase_order po, "
                    + "     job_order jo "
                    + " WHERE jo.job_order_id = po.job_order_id"
                    + " AND date = ? "
                    + " AND design_code = ?");
            
            int item = 1;
            ps.setString(item++, date);
            ps.setInt(item++, des_code);
            
            ResultSet rs = ps.executeQuery();
            
            List<purchase_order> all_purchase_this_job = new ArrayList<purchase_order>();
            
            while(rs.next())
            {
                purchase_order this_purchase = new purchase_order();
                
                //FOR Debugging this all the purchase order
                //System.out.println("Purchase id = "+ rs.getInt("id_purchase"));
                //System.out.println("Job Order = "+ rs.getString("job_order_id"));
                //System.out.println("Design code= "+ rs.getInt("design_code"));
                //System.out.println("Quantity = " +rs.getInt("quantity"));
                
                this_purchase.setQuantity(rs.getInt("quantity"));
                this_purchase.setDesign_code(rs.getInt("design_code"));
                this_purchase.setJob_order_id(rs.getString("job_order_id"));
                this_purchase.setId_purchase(rs.getInt("id_purchase"));
                
                all_purchase_this_job.add(this_purchase);
            }
            
            return all_purchase_this_job;
            
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<job_order> get_all_job_order_and_details_from_design_and_purchase_id(int design_code, int purchase_id)
    {
        try
        {   
          DBConnection db = new DBConnection();
          Connection conn = db.getConnection();  
          
          List<job_order> all_job_this_purchase = new ArrayList<job_order>();
            PreparedStatement ps = conn.prepareStatement("SELECT p.job_order_id, customer_id, date , customer_name "
                    + "FROM purchase_order p , job_order j, customer c "
                    + " WHERE j.job_order_id = p.job_order_id "
                    + " AND c.id_customer = j.customer_id "
                    + " AND design_code = ? "
                    + " AND date = (SELECT j2.date "
                            + "FROM purchase_order p2, job_order j2 "
                            + "WHERE id_purchase = ? "
                            + "AND j2.job_order_id = p2.job_order_id)");
            
            int item = 1;
            ps.setInt(item++, design_code);
            ps.setInt(item++, purchase_id);
            
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                job_order this_order = new job_order();
                this_order.setJob_id(rs.getString("job_order_id"));
                this_order.setCustomer_id(rs.getInt("customer_id"));
                this_order.setDate(rs.getString("date"));
                this_order.setCustomer_name(rs.getString("customer_name"));
                all_job_this_purchase.add(this_order);
             }
            
            this.closeConn(conn, ps, rs);
            return all_job_this_purchase;
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);   
        }
        return null;
    }
    
    public ResultSet get_picture_from_design_id(colortextile_class.design this_picture){
        try
        {
          DBConnection db = new DBConnection();
          Connection conn = db.getConnection();  
          
            PreparedStatement ps = conn.prepareStatement("SELECT design_picture FROM design_picture WHERE design_code = '"+ this_picture.getDesign_code()+"' ");
            ResultSet rs = ps.executeQuery();
            
                return rs;
            
           //this.closeConn(conn, ps, rs);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);  
        }
        return null;
    }
    
    public ArrayList<Integer> get_all_design_code_from_date(String date)
    {
        ArrayList<Integer> design_codes = new ArrayList<>();
        try
        {
          DBConnection db = new DBConnection();
          Connection conn = db.getConnection();  
          
            PreparedStatement ps = conn.prepareStatement(" SELECT DISTINCT(design_code)" +
                                                         " FROM job_order jo, purchase_order po " +
                                                         " WHERE jo.job_order_id = po.job_order_id" +
                                                         " AND DATE = ?;");
            
            int item = 1;
            ps.setString(item++, date);
                                                       
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                design_codes.add(rs.getInt("design_code"));
            }
            this.closeConn(conn, ps, rs);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return design_codes;
        
    }
    
    public DefaultTableModel get_column_table_for_merged_date()
    {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Date");
        model.addColumn("Design Name/s");
        model.addColumn("Color/s");
        model.addColumn("Fabric Style/s");
        model.addColumn("Customer/s");
        model.addColumn("Job Order/s");
        
        return model;
    }
    
    public DefaultTableModel get_table_merged_date()
    {
        DefaultTableModel model = get_column_table_for_merged_date();
        
        try {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = conn.prepareStatement("SELECT date, " +
                    " group_concat(DISTINCT(design_name)) AS 'Design Name/s', " +
                    " group_concat(DISTINCT(color_name)) AS 'Color/s', " +
                    " group_concat(DISTINCT(fabric_style)) AS 'Fabric Style/s', " +
                    " group_concat(customer_name) AS 'Customer/s', " +
                    " group_concat(jord.job_order_id SEPARATOR ', ') AS 'All Job Order'" +
                    " FROM job_order jord, purchase_order purch, design des, customer cust" +
                    " WHERE jord.job_order_id = purch.job_order_id " +
                    " AND des.design_code = purch.design_code " +
                    " AND cust.id_customer= jord.customer_id " +
                    " GROUP BY date " +
                    " ORDER BY date ASC; ");
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next())
            {
                rs.previous();
                while(rs.next())
                {
                    String[] this_set = {
                        rs.getString("date"),
                        rs.getString("Design Name/s"),
                        rs.getString("Color/s"),
                        rs.getString("Fabric Style/s"),
                        rs.getString("Customer/s"),
                        rs.getString("All Job Order")
                    };
                    model.addRow(this_set);
                }
                this.closeConn(conn, ps, rs);
            }
            else {
                JOptionPane.showMessageDialog(null,"No Record");
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    
    }
    
    public DefaultTableModel get_table_job_order_purchase_design()
    {
        DefaultTableModel model = new DefaultTableModel();
        
        try {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = conn.prepareStatement("SELECT design_name , date, "
                    + " group_concat(jord.job_order_id SEPARATOR ', ') AS 'All Jobs' " 
                    + " FROM job_order jord, purchase_order purch, design des  " 
                    + " WHERE jord.job_order_id = purch.job_order_id "
                    + " AND des.design_code = purch.design_code"
                    + " GROUP BY date, des.design_code; ");
            
            ResultSet rs = ps.executeQuery();
            
            model.addColumn("Design Name");
            model.addColumn("Date");
            model.addColumn("Job Order");
        
            if (rs.next())
            {
                rs.previous();
                while(rs.next())
                {
                    String[] this_set = {
                        rs.getString("design_name"),
                        rs.getString("date"),
                        rs.getString("All Jobs")
                    };
                    model.addRow(this_set);
                }
                this.closeConn(conn, ps, rs);
            }
            else {
                JOptionPane.showMessageDialog(null,"No Record");
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
    
    public DefaultTableModel get_column_for_design_customer_job_order()
    {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Date");  
        model.addColumn("Design");  
        model.addColumn("Color");   
        model.addColumn("Fabric Style");    
        model.addColumn("Total Quantity");
        model.addColumn("Customers");  
        model.addColumn("Job Orders");
        
        return model;
    }
    
    public DefaultTableModel get_table_design_customer_job_order()
    {
        DefaultTableModel model = get_column_for_design_customer_job_order();
        
        try {
            
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();  
          
            PreparedStatement ps = 
                    conn.prepareStatement("SELECT design_name, color_name, fabric_style, Sum(Quantity) as 'Total', date, " +
                            " group_concat(customer_name) AS 'Customer', " +
                            " group_concat(jord.job_order_id SEPARATOR ', ') AS 'All Jobs' " +
                            " FROM job_order jord, purchase_order purch, design des, customer cust " +
                            " WHERE jord.job_order_id = purch.job_order_id " +
                            " AND des.design_code = purch.design_code " +
                            " AND cust.id_customer= jord.customer_id " +
                            " GROUP BY date, des.design_code"+ 
                            " ORDER BY design_name ASC; ");
            ResultSet rs = ps.executeQuery();
            
            if (rs.first()){
                
               rs.previous();
                while (rs.next())
                {   
                    String[] this_set = {
                        rs.getString("date"),
                        rs.getString("design_name"),
                        rs.getString("color_name"),
                        rs.getString("fabric_style"),
                        rs.getString("Total"),
                        rs.getString("Customer"),
                        rs.getString("All Jobs")
                    };
                    model.addRow(this_set);
                }
                this.closeConn(conn, ps, rs);
            } 
            else 
            {
            JOptionPane.showMessageDialog(null,"No Record");
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
    
    public DefaultTableModel get_table_all_design()
    {
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("Design");  
        model.addColumn("Color");   
        model.addColumn("Fabric Style");    
        
        try 
        {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();  
          
            PreparedStatement ps = 
                    conn.prepareStatement("SELECT design_name, color_name, fabric_style " +
                            " FROM design des " + 
                            " ORDER BY design_name ASC; ");
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.first()){
                
               rs.previous();
                while (rs.next())
                {   
                    String[] this_set = {
                        rs.getString("design_name"),
                        rs.getString("color_name"),
                        rs.getString("fabric_style"),
                    };
                    model.addRow(this_set);
                }
                this.closeConn(conn, ps, rs);
            } 
            else 
            {
            JOptionPane.showMessageDialog(null,"No Record");
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
    
    //public DefaultTableModel get_table_
    
    public DefaultTableModel get_table_all_job_order()
    {
        DefaultTableModel model = new DefaultTableModel();
        return model;
    }
   
    public int get_id_purchase_last(colortextile_class.purchase_order last_purchase)
    {    
        int last_purchase_id = -1;
        try
        {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = conn.prepareStatement("SELECT MAX(id_purchase) AS last FROM purchase_order");
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                last_purchase_id = rs.getInt("last");
            }
            
            this.closeConn(conn, ps, rs);
        
        } catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return last_purchase_id;
    }
    public int get_id_purchase(colortextile_class.purchase_order new_purchase){
       
        int id_purchase = -1;
        try{
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = 
            conn.prepareStatement("SELECT id_purchase "
                                 + "FROM purchase_order "
                                 + "WHERE design_code = ? "
                                 + "AND job_order_id = ? ");
            
            int item = 1;
            ps.setInt(item++, new_purchase.getDesign_code());
            ps.setString(item++, new_purchase.getJob_order_id());
            /* //FOR CHECKING/DEBUGGING
            System.out.println("Date :" +new_purchase.getDate());
            System.out.println("Colorway Id :"  new_purchase.getDesign_code);
            */
            ResultSet rs = ps.executeQuery();
            if(rs.first())
            {
                 id_purchase = rs.getInt("id_purchase");
            }
            this.closeConn(conn, ps, rs);
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id_purchase;
    }
    
    public purchase_order get_purchase_details_from_job_order_and_design_code(String id_job_order, int design_code )
    {
        purchase_order current_purchase = new purchase_order();
        try
         {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
         
            PreparedStatement ps = 
            conn.prepareStatement("SELECT *"
                                 + " FROM purchase_order "
                                 + " WHERE job_order_id = ? "
                                 + " AND design_code = ?");
            
            int item = 1;
            ps.setString(item++, id_job_order);
            ps.setInt(item++, design_code);
            /* //FOR CHECKING/DEBUGGING
            System.out.println("Date :" +new_purchase.getDate());
            System.out.println("Colorway Id :"  new_purchase.getDesign_code);
            */
            ResultSet rs = ps.executeQuery();
            if(rs.first())
            {
                current_purchase.setQuantity(rs.getInt("quantity"));
                current_purchase.setDesign_code(rs.getInt("design_code"));
                current_purchase.setJob_order_id(rs.getString("job_order_id"));
                current_purchase.setId_purchase(rs.getInt("id_purchase"));
            }
            this.closeConn(conn, ps, rs);
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return current_purchase;
    }
    
    public purchase_order get_purchase_details(int purchase_id)
    {
        purchase_order current_purchase = new purchase_order();
         try
         {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
         
            PreparedStatement ps = 
            conn.prepareStatement("SELECT design_code, job_order_id, quantity "
                                 + "FROM purchase_order "
                                 + "WHERE id_purchase = ? ");
            
            int item = 1;
            ps.setInt(item++, purchase_id);
            /*  //FOR CHECKING/DEBUGGING
            System.out.println("Date :" +new_purchase.getDate());
            System.out.println("Colorway Id :"  new_purchase.getDesign_code);
            */
            ResultSet rs = ps.executeQuery();
            if(rs.first())
            {
                current_purchase.setQuantity(rs.getInt("quantity"));
                current_purchase.setDesign_code(rs.getInt("design_code"));
                current_purchase.setJob_order_id(rs.getString("job_order_id"));
            
                
            }
            this.closeConn(conn, ps, rs);
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return current_purchase;
         
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
     
    //SEARCH START
    //SEARCH function for SQL
    //START all functions here with search_*
    
    public void Search_Customer_Name(colortextile_class.customer customer_name){
        
         ArrayList<String> names = new ArrayList<>();
        try
        {
          DBConnection db = new DBConnection();
          Connection conn = db.getConnection();  
          
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM customer WHERE customer_name= '"+ customer_name.getCustomer_name() +"'");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                names.add(rs.getString("customer_name"));
            }
            customer_name.setCustomer_names(names);
            
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet Search_job(String id){
        try{
            DBConnection db = new DBConnection();
          Connection conn = db.getConnection();  
          
          String sql = "SELECT * FROM job_order WHERE job_order_id = '" + id + "'";
          
          PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            job_order results = new job_order();
            return rs;
            
        }catch(Exception e){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    public boolean Search_job_id(colortextile_class.job_order job){
        
        try{
            DBConnection db = new DBConnection();
          Connection conn = db.getConnection();  
          
          String sql = "SELECT * FROM job_order WHERE job_order_id = '" + job.getJob_id() + "'";
          
          PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.first()){
                String id = rs.getString("job_order_id");
                return true;
            }
           
        }catch(Exception e){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, e);
            
        }
        return false;
    }
    
    public ResultSet Search_colorway(colortextile_class.colorway color){
            try
        {
          DBConnection db = new DBConnection();
          Connection conn = db.getConnection();  
          
          String sql ="SELECT * FROM colorway WHERE";
          int increment = 0;
          
          if (color.getDesign_code() != -1){
              sql = sql + " design_code = '"+color.getDesign_code()+"'";
              increment++;
          } 
          
          if (color.getId_colorway() != -1){
              if(increment > 0)
              { sql = sql + " AND";
              }
              sql = sql + " id_colorway= '"+color.getId_colorway()+"'";
              increment++;
          }
                  
          if (color.getColorway_name() != null){
              if(increment > 0)
              { sql = sql + " AND";
              }
              sql = sql + " colorway_name= '"+color.getColorway_name()+"'";
              
          }
          
          //System.out.println(sql);
          
          if (increment == 0)
          {
             // System.out.print("nothing to be searched");
              return null;
          } else {
          
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
           
            
          }
        }
        catch (Exception ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }
    }
    
    public ResultSet Search_colorway_screen_connect(colortextile_class.Colorway_and_pigment connect){
        try
        {
          DBConnection db = new DBConnection();
          Connection conn = db.getConnection();  
          
          String sql = "SELECT * FROM colorway_and_pigment WHERE";
          int increment = 0;
          
          if (connect.getId_color_screen() != -1){
              sql = sql + " id_color_screen = '"+connect.getId_color_screen()+"'";
              increment++;
          } 
          
          if (connect.getId_colorway() != -1){
              if(increment > 0)
              { sql = sql + " AND";
              }
              sql = sql + " id_colorway= '"+connect.getId_colorway()+"'";
              increment++;
          }
          //System.out.println(sql);
          
          if (increment == 0)
          {
            //  System.out.print("nothing to be searched");
              return null;
          } else {
          
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
            
          }
        }
        catch (Exception ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }
        
    }
    
    public ResultSet Search_id_purchase(colortextile_class.purchase_order purchase){
        try
        {
          DBConnection db = new DBConnection();
          Connection conn = db.getConnection();  
          
          String sql = "SELECT * FROM purchase_order WHERE";
          int increment = 0;
          
          if (purchase.getId_purchase() != -1 && purchase.getId_purchase() != 0 ) {
              sql = sql + " id_purchase = '"+purchase.getId_purchase()+"'";
              increment++;
          } 
         // System.out.println(sql);
          
          if (purchase.getDesign_code()!= -1){
              
              if(increment > 0)
              { sql = sql + " AND";
              }
              
              sql = sql + " design_code = '"+purchase.getDesign_code()+"' ";
              increment++;
          }
          
          if (purchase.getJob_order_id() != null){
              
              if(increment > 0)
              { sql = sql + " AND";
              }
              
              sql = sql + " job_order_id = '"+purchase.getJob_order_id()+"' ";
              increment++;
          }
          
         // System.out.println(sql);
          
          if (increment == 0)
          {
            //  System.out.print("nothing to be searched");
              return null;
          } else {
          
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            return rs;
           
            
          }
        }
        catch (Exception ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }
    }
    
    public ResultSet Search_Job_Order(colortextile_class.job_order job ){
        
         try
        {
          DBConnection db = new DBConnection();
          Connection conn = db.getConnection();  
          
          String sql ="SELECT * FROM job_order WHERE";
          int increment = 0;
          
          if (job.getCustomer_id() != -1){
              sql = sql + " customer_id = '"+job.getCustomer_id()+"'";
              increment++;
          } 
          
          if (job.getDate() != null){
              if(increment > 0)
              { sql = sql + " AND";
              }
              sql = sql + " date= '"+job.getDate()+"'";
              increment++;
          }
                  
          if (job.getJob_id() != null){
              if(increment > 0)
              { sql = sql + " AND";
              }
              sql = sql + " job_order_id= '"+job.getJob_id()+"'";
              
          }
          
          //System.out.println(sql);
          
          if (increment == 0)
          {
             // System.out.print("nothing to be searched");
              return null;
          } else {
          
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
            
          }
        }
        catch (Exception ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ResultSet Search_Design(colortextile_class.design design) {
        
         try
        {
          DBConnection db = new DBConnection();
          Connection conn = db.getConnection();  
          
          String sql ="SELECT * FROM design WHERE";
          int increment = 0;
          
          if (design.getDesign_name() != null){
              sql = sql + " design_name = '"+design.getDesign_name()+"'";
              increment++;
          } 
          if (design.getDesign_code()!= -1){
              if(increment > 0)
              { sql = sql + " AND";
              }
              sql = sql + " design_code= '"+design.getDesign_code()+"'";
              increment++;
          }
          if (design.getColor_name()!= null){
              if(increment > 0)
              { sql = sql + " AND";
              }
              sql = sql + " color_name= '"+design.getColor_name()+"'";
              increment++;
          }
          
          if (design.getFabric_style()!= null){
              if(increment > 0)
              { sql = sql + " AND";
              }
              sql = sql + " fabric_style= '"+design.getFabric_style()+"'";
              increment++;
          }
          
         // System.out.println(sql);
          
          if (increment == 0)
          {
            //  System.out.print("nothing to be searched");
              return null;
          } else {
          
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            return rs;
          }
        }
        catch (Exception ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }
    }
    //SEARCH END
    public int check_if_design_picture_has_already_been_added(int design_code)
    {
        try {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT EXISTS "
                    + " (SELECT design_code "
                    + " FROM design_picture WHERE "
                    + " design_code = ?) "
                    + " AS 'CheckTest'");

            int item = 1;
            ps.setInt(item++, design_code);

            ResultSet rs = ps.executeQuery();
            
            rs.first();
            int checkTest = rs.getInt("CheckTest");
            
            this.closeConn(conn, ps);
            return checkTest;
            
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public void update_design_picture(design this_design)
    {
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();
        File file = new File("New.jpg");
        try
        {
            FileInputStream fis = new FileInputStream(file);
            //System.out.println(file.exists());
            if(file.exists())
            {
                PreparedStatement ps;
                int item =1;
                if(this.check_if_design_picture_has_already_been_added(this_design.getDesign_code()) == 0)
                {
                    ps= conn.prepareStatement("INSERT design_picture "
                            + "SET design_code = ?, " +
                            "design_picture = ?");
                    ps.setInt(item++, this_design.getDesign_code());
                    ps.setBinaryStream(item++, fis, fis.available());
                    ps.executeUpdate();
                }
                else
                {
                    ps = conn.prepareStatement("UPDATE design_picture "
                          + "SET design_picture = ? " +
                            "WHERE design_code = ?");
                    
                    ps.setBinaryStream(item++, fis, fis.available());
                    ps.setInt(item++, this_design.getDesign_code());
                    ps.executeUpdate();
                }
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);    
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void update_design(design this_design)
    {
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();
        PreparedStatement ps;
        int item = 1;
        try
        { 
            ps = conn.prepareStatement("UPDATE design "
                                            + "SET design_name = ?, "
                                            + "color_name = ?, "
                                            + "fabric_style = ? "
                                            + "WHERE design_code = ?");
           
            
            ps.setString(item++, this_design.getDesign_name().toUpperCase());
            ps.setString(item++, this_design.getColor_name().toUpperCase());
            ps.setString(item++, this_design.getFabric_style().toUpperCase());
            ps.setInt(item++, this_design.getDesign_code());
            // System.out.println(ps);
            ps.executeUpdate();
            this.closeConn(conn, ps);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);    
        } 
        this.update_design_picture(this_design);
    }
    
    public void update_colorway_screen(Colorway_and_pigment this_color_screen)
    {
        try{
           DBConnection db = new DBConnection();
           Connection conn = db.getConnection();  
        
           /*
           UPDATE colorway_screen_connect SET pigment_no = (SELECT pigment_no FROM pigment WHERE pigment_name LIKE "L. PINK"), 
           pigment_percentage= 56
            WHERE id_color_screen = 33;
           */
           PreparedStatement ps = conn.prepareStatement("UPDATE colorway_and_pigment "
                                                        + " SET pigment_no = ?, "
                                                        + " pigment_percentage = ? "
                                                        + " WHERE id_color_screen = ?");
          int item = 1;
          ps.setInt(item++, this_color_screen.getPigment_no());
          ps.setFloat(item++, this_color_screen.getPigment_percentage());
          ps.setInt(item++, this_color_screen.getId_color_screen());
          
          ps.executeUpdate();
          this.closeConn(conn, ps);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update_pigment(pigment this_pigment)
    {
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection(); 
         int item = 1;
        try {
            PreparedStatement ps = conn.prepareStatement("UPDATE pigment "
                    + " SET pigment_name=? "
                    + " WHERE pigment_no = ?;");
            
            ps.setString(item++, this_pigment.getPigment_name());
            ps.setInt(item++, this_pigment.getPigment_no());
            ps.executeUpdate();
            this.closeConn(conn, ps);
            
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }
    
    public void update_colorway(colorway this_colorway)
    {
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection(); 
        
        try
        {
          PreparedStatement ps = conn.prepareStatement("UPDATE colorway "
                                                        + " SET colorway_name = ?, binder = ?, weight_kg = ? "
                                                        + " WHERE id_colorway = ?");
          int item = 1;
          //this_colorway.view_colorway_details();
          ps.setString(item++, this_colorway.getColorway_name().toUpperCase());
          ps.setFloat(item++, this_colorway.getBinder());
          ps.setFloat(item++, this_colorway.getWeight_kg());
          ps.setInt(item++, this_colorway.getId_colorway());
          
          ps.executeUpdate();
          this.closeConn(conn, ps);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int count_job_order_usage(String job_order_id)
    {
        int total = 0;
        try{
            
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection(); 
            
            PreparedStatement ps = conn.prepareStatement("SELECT COUNT(id_purchase) AS 'Total' "
                                                        + " FROM purchase_order "
                                                        + " WHERE job_order_id = ?");
          int item = 1;
          
          ps.setString(item++, job_order_id);
          
          ResultSet rs = ps.executeQuery();
          rs.first();
          total = rs.getInt("Total");
          this.closeConn(conn, ps, rs);
          
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }
    
    public void update_job_order(job_order this_job_order)
    {
        try
        {
          DBConnection db = new DBConnection();
          Connection conn = db.getConnection(); 
          
          PreparedStatement ps = conn.prepareStatement("UPDATE job_order "
                                                        + " SET customer_id  = ?, "
                                                        + " date = ?"
                                                        + " WHERE job_order_id = ?");
          int item = 1;
          
          ps.setInt(item++, this_job_order.getCustomer_id());
          ps.setString(item++, this_job_order.getDate());
          ps.setString(item++, this_job_order.getJob_id());
          
          ps.executeUpdate();
          this.closeConn(conn, ps);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update_purchase_order_quantity(purchase_order this_purchase)
    {
        try
        {
          DBConnection db = new DBConnection();
          Connection conn = db.getConnection(); 
          
          PreparedStatement ps = conn.prepareStatement("UPDATE purchase_order "
                                                        + " SET quantity  = ? "
                                                        + " WHERE id_purchase = ?");
          int item = 1;
          
          ps.setFloat(item++, this_purchase.getQuantity());
          ps.setInt(item++, this_purchase.getId_purchase());
          
          ps.executeUpdate();
          this.closeConn(conn, ps);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete_colorway_screen_connect(int id_colorway)
    {
         try
        {
          DBConnection db = new DBConnection();
          Connection conn = db.getConnection(); 
          
          PreparedStatement ps = conn.prepareStatement("DELETE FROM colorway_and_pigment "
                                                        + "WHERE id_colorway = ?");
          int item = 1;
          ps.setInt(item++, id_colorway);
          //ps.setInt(item++, connection_del.getPigment_no());
          ps.executeUpdate();
          this.closeConn(conn, ps);
        }
        catch (SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void delete_purchase_order(purchase_order this_purchase)
    {
        try
        {
          DBConnection db = new DBConnection();
          Connection conn = db.getConnection(); 
          
          PreparedStatement ps = conn.prepareStatement("DELETE FROM purchase_order "
                                                        +" WHERE id_purchase = ?");
          int item = 1;
          ps.setInt(item++, this_purchase.getId_purchase());
          
          ps.executeUpdate();
          this.closeConn(conn, ps);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex); 
        }
    }
    
    public void delete_job_order(job_order this_job)
    {
        try
        {
          DBConnection db = new DBConnection();
          Connection conn = db.getConnection(); 
          
          PreparedStatement ps = conn.prepareStatement("DELETE FROM job_order "
                                                        +" WHERE job_order_id = ?");
          int item = 1;
          ps.setString(item++, this_job.getJob_id());
          
          ps.executeUpdate();
          this.closeConn(conn, ps);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex); 
        }
    }
    
    ////////////////////////UNUSED
    private void not_used_classes(){
        
    /*
        
    public boolean add_screen_pigment(colortextile_class.deletedClass.screen_pigment new_screen_pigment)
    {
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();
       
        try {
             PreparedStatement ps = 
                     conn.prepareStatement("INSERT INTO screen_pigment (pigment_no, pigment_percentage) "
                                            + "SELECT ?, ? FROM DUAL"
                                            + "WHERE NOT EXISTS "
                                            + "(SELECT 1 FROM screen_pigment "
                                            + " WHERE pigment_no = ? AND pigment_percentage = ?");
        
        int item = 1;
        
        ps.setInt(item++, new_screen_pigment.getPigment_no());
        ps.setFloat(item++, new_screen_pigment.getPigment_percentage());
        ps.setInt(item++, new_screen_pigment.getPigment_no());
        ps.setFloat(item++, new_screen_pigment.getPigment_percentage());
        ps.executeUpdate();
        
        this.closeConn(conn, ps);
        return true;
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
        
        
    public screen_pigment get_pigment_id_and_percentage(int id_screen)
    {
        
        try{
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = 
            conn.prepareStatement("SELECT pigment_percentage, pigment_no "
                                 + "FROM screen_pigment "
                                 + "WHERE id_screen = ? ");
            
            int item = 1;
            ps.setInt(item++, id_screen);
            
            ResultSet rs = ps.executeQuery();
            screen_pigment new_screen = new screen_pigment();
            if(rs.first())
            {
                new_screen.setPigment_no(rs.getInt("pigment_no"));
                new_screen.setPigment_percentage(rs.getInt("pigment_percentage"));
                this.closeConn(conn, ps, rs);
                return new_screen;
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
            return null;
    }
    */
    
    /*
    public ResultSet get_job_order_list_from_purchase_id(colortextile_class.job_order this_job){
        
        try
        {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection(); 
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM job_order WHERE id_purchase = ?");
            int item = 1;
            ps.setInt(item++, this_job.getId_purchase());
            ResultSet rs = ps.executeQuery();
            return rs;
            
            
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    */
    
    
    //DELETED **NEVER USE!
    /*
    public List<screen_pigment> set_all_screen_pigment_from_colorway_id(int colorway_id)
    {
        try{
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            System.out.println("Colorway_id = " +colorway_id);
            PreparedStatement ps = 
            conn.prepareStatement("SELECT id_screen, p.pigment_no, pigment_percentage, p.pigment_name " 
                                 + " FROM screen_pigment s_p, pigment p" 
                                 + " WHERE id_screen "
                                 + " IN (SELECT id_screen "
                                     + " FROM colorway_screen_connect "
                                     + " WHERE id_colorway = ?)"
                                 + " AND s_p.pigment_no = p.pigment_no");
            int item = 1;
            ps.setInt(item++, colorway_id);
            ResultSet screen_rs = ps.executeQuery();
            
            List<screen_pigment> this_screen = new ArrayList<>();
            
            while(screen_rs.next())
            {
                screen_pigment this_s_pigment = new screen_pigment();
                
                this_s_pigment.setPigment_no(screen_rs.getInt("p.pigment_no"));
                this_s_pigment.setPigment_percentage(screen_rs.getFloat("pigment_percentage"));
                this_s_pigment.setPigment_name(screen_rs.getString("p.pigment_name"));
                this_screen.add(this_s_pigment);
            }
            
            this.closeConn(conn, ps, screen_rs);
            
            return this_screen;
            
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    */
    
    
    
     /*
    public ResultSet get_single_purchase_info_from_id_purchase(colortextile_class.purchase_order purchase_id){
        try {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();  
          
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM purchase_order WHERE id_purchase = ?");
            
            int item = 1;
            ps.setInt(item++, purchase_id.getId_purchase());
            
            ResultSet rs = ps.executeQuery();
            System.out.println(ps + "found");
            return rs;
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    */
    /*
    public ResultSet get_all_design(){
        try
        {
          DBConnection db = new DBConnection();
          Connection conn = db.getConnection();  
          
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM design ORDER BY design_code ASC ");
            ResultSet rs = ps.executeQuery();
            //this.closeConn(conn, ps, rs);
            return rs;
            
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    */
    }
    
    public int check_if_id_screen_exists(screen_pigment this_screen)
    {
         try{
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = 
            conn.prepareStatement("SELECT EXISTS (SELECT id_screen "
                                + "FROM screen_pigment "
                                + "WHERE pigment_no = ? "
                                + "AND pigment_percentage BETWEEN ? AND ?) "
                                + " AS CheckTest");
                    
                    
            int item = 1;
            ps.setInt(item++, this_screen.getPigment_no());
            ps.setFloat(item++, this_screen.getPigment_percentage() -(float) 0.01);
            ps.setFloat(item++, this_screen.getPigment_percentage() +(float) 0.01);
            //System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            
            rs.first();
            int checkTest = rs.getInt("CheckTest");
            
            this.closeConn(conn, ps, rs);
            return checkTest;
            
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
}
    
   

