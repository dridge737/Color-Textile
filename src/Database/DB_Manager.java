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
            if(conn!=null)
                conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(ps!=null)
                try {
                    ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    // OVERLOAD
    private void closeConn(Connection conn, PreparedStatement ps, ResultSet rs)
    {
        try {
            if(conn!=null)
                conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(ps!=null)
                try {
                    ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(rs!=null)
                try {
                    rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //ADD START
    ///Add functions for sql
    ///Start function names with add_*
    
    public boolean add_fabric_style(String fabric_name, float fab_kilogram)
    {
        DBConnection dbc = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        boolean added = false;
        try {
             
            conn = dbc.getConnection();
            conn.prepareStatement("INSERT INTO fabric_style (fabric_name, kilogram) "
                                            + "VALUES (?, ?)");
            
            int item = 1;
            ps.setString(item++, fabric_name.toUpperCase());
            ps.setFloat(item++, fab_kilogram);
            ps.executeUpdate();

            added = true;
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps);
        return added;
    }
    
    public int count_number_of_pigment()
    {
        DBConnection dbc = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int total = -1;
        try {
            conn = dbc.getConnection();
            ps = conn.prepareStatement("SELECT COUNT(pigment_no) AS 'Total' FROM pigment");
            rs = ps.executeQuery();
            
            rs.first();
            total = rs.getInt("Total");
            
        } 
        catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps, rs);
        return total;
    }
    
    public int count_number_of_fabric_style()
    {
        DBConnection dbc = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int total = -1;
        
        try {
            conn = dbc.getConnection();
            ps = conn.prepareStatement("SELECT COUNT(id_fabric) AS 'Total' FROM fabric_style");
            rs = ps.executeQuery();
            
            rs.first();
            total = rs.getInt("Total");
            
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps, rs);
        return total;
    }
    
    public boolean add_pigment(colortextile_class.pigment this_pigment)
    {
        DBConnection dbc = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        boolean added = false;
        
        try {
            conn = dbc.getConnection();
            ps = conn.prepareStatement("INSERT INTO pigment(pigment_name) VALUES (?)");

            int item = 1;
            ps.setString(item++, this_pigment.getPigment_name().toUpperCase());

            ps.executeUpdate();
            added =true;
            
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps, null);
        return added;
    }
    
    public int check_if_binder_exists(Float binder)
    {
        DBConnection dbc = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int checkTest = 0;
        
        try {
            conn = dbc.getConnection();
            ps = conn.prepareStatement("SELECT EXISTS "
                    + " (SELECT binder_id "
                    + " FROM binders WHERE "
                    + " binder_percent = ?) "
                    + " AS 'CheckTest'");

            int item = 1;
            ps.setFloat(item++, binder);
            
            rs = ps.executeQuery();
            if(rs.first())
                checkTest = rs.getInt("CheckTest");
            
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.closeConn(conn, ps, rs);
        return checkTest;
    }
    
    public int check_if_customer_exists(String customer_name)
    {
        DBConnection dbc = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int checkTest = 0;
        try 
        {
            conn = dbc.getConnection();
            ps = conn.prepareStatement("SELECT EXISTS "
                    + " (SELECT id_customer "
                    + " FROM customer WHERE "
                    + " customer_name = ?) "
                    + " AS 'CheckTest'");

            int item = 1;
            ps.setString(item++, customer_name);
            rs = ps.executeQuery();
            if(rs.first())
                checkTest = rs.getInt("CheckTest");
            
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.closeConn(conn, ps, rs);
        return checkTest;
    }
    
    public int check_if_job_order_exists(colortextile_class.job_order this_job)
    {
        DBConnection dbc = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int checkTest = 0;
        try {
            conn = dbc.getConnection();
            ps = conn.prepareStatement("SELECT EXISTS "
                    + " (SELECT job_order_id "
                    + " FROM job_order WHERE "
                    + " job_order_id = ?) "
                    + " AS 'CheckTest'");

            int item = 1;
            ps.setString(item++, this_job.getJob_id());

            rs = ps.executeQuery();
            if(rs.first())
            checkTest = rs.getInt("CheckTest");
            
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps, rs);
        return checkTest;
    }
    
    public int check_if_pigment_exists(colortextile_class.pigment this_pigment)
    {
        DBConnection dbc = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int checkTest = 0;
        try {
            conn = dbc.getConnection();
            ps = conn.prepareStatement("SELECT EXISTS "
                    + " (SELECT pigment_no "
                    + " FROM pigment WHERE "
                    + " pigment_name = ?) "
                    + " AS 'CheckTest'");

            int item = 1;
            ps.setString(item++, this_pigment.getPigment_name());
            rs = ps.executeQuery();
            
            if(rs.first())
                checkTest = rs.getInt("CheckTest");
            
        } 
        catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps);
        return checkTest;
            
    }
    
    public boolean add_fabric_style(design this_design)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        boolean added = false;
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement("INSERT INTO fabric_style (fabric_name, percent) VALUES (?, ?)");

            int item = 1;
            ps.setString(item++, this_design.getFabric_style());
            ps.setFloat(item++, this_design.getPercent());

            ps.execute();
            added = true;
            
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps);
        return added;
    }
    
    public boolean add_binder(Float binder)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        boolean added = false;
        try {
            conn = db.getConnection();
            String query = "INSERT INTO binders (binder_percent) VALUES (?)";
            ps = conn.prepareStatement(query);
            ps.setFloat(1, binder);

            ps.execute();
            added = true;
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps);
        return added;
    }
    
    public boolean add_customer(colortextile_class.customer new_customer) {
        
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement preparedStmt = null;
        boolean added = false;
        try {
            conn = db.getConnection();
            String query = "INSERT INTO customer (customer_name) VALUES (?)";

            preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, new_customer.getCustomer_name().toUpperCase());
            preparedStmt.execute();
            
            added = true;
        } 
        catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.closeConn(conn, preparedStmt);
        return added;
    }
    
    public boolean add_purchase_order(colortextile_class.purchase_order new_purchase) {
        
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement preparedStmt = null;
        boolean added = false;
        try {
            conn = db.getConnection();
            String query = "INSERT INTO purchase_order (quantity, design_code, job_order_id) VALUES (?, ?, ?)";
            
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, new_purchase.getQuantity());
            preparedStmt.setInt(2, new_purchase.getDesign_code());
            preparedStmt.setString(3, new_purchase.getJob_order_id());
            preparedStmt.execute();
            added = true;
            
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
              
        }
        this.closeConn(conn, preparedStmt);
        return added;
    }
    
    public boolean add_colorway(colortextile_class.colorway new_colorway)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        boolean added = false;
        
        try{
            conn = db.getConnection();
            ps = conn.prepareStatement("INSERT INTO colorway (colorway_name, binder, weight_kg, design_code)"
                                                       + "VALUES (? , ROUND(?, 2) , ROUND(?, 2) , ?)");
            int item =1;
            ps.setString(item++, new_colorway.getColorway_name().toUpperCase());
            ps.setFloat(item++, new_colorway.getBinder());
            ps.setFloat(item++, new_colorway.getWeight_kg());
            ps.setInt(item++, new_colorway.getDesign_code());
            ps.executeUpdate(); 
            added = true;
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        this.closeConn(conn, ps);
        return added;
    }
    
    public boolean add_colorway_and_screen_connect(int id_pigment, int id_colorway, float pigment_percentage)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        boolean added = false;
        try{
            conn = db.getConnection();
            ps = conn.prepareStatement("INSERT INTO colorway_screen_connect"
                                                       + "(pigment_no, id_colorway, pigment_percentage)"
                                                       + "VALUES (?, ?, ?);");
            int item =1;
            ps.setInt(item++, id_pigment);
            ps.setInt(item++, id_colorway);
            ps.setFloat(item++, pigment_percentage);
            ps.executeUpdate();
            added =true;
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        this.closeConn(conn, ps);
        return added;
    }
    
    public boolean add_design(colortextile_class.design new_design)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        boolean added = false;
        try
        {
            conn = db.getConnection();
            ps = conn.prepareStatement("INSERT INTO design (design_name, color_name, fabric_style) "
                                                        + "VALUES ( ? , ? , ? )");
            int item = 1;
            ps.setString(item++, new_design.getDesign_name().toUpperCase()); 
            ps.setString(item++, new_design.getColor_name().toUpperCase());
            ps.setString(item++, new_design.getFabric_style().toUpperCase());
            ps.executeUpdate();
            
            added = true;
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
         this.closeConn(conn, ps);
         return added;
    }
    
    public boolean add_job_order(colortextile_class.job_order new_job)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement preparedStmt = null;
        boolean added = false;
        try
        {
            conn = db.getConnection();
            
            String query = "INSERT INTO job_order (job_order_id, date, customer_id) VALUES (?, ?, ?)";
            preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, new_job.getJob_id());
            preparedStmt.setString(2, new_job.getDate());
            preparedStmt.setInt(3, new_job.getCustomer_id());
            preparedStmt.execute();
            
            added = true;
        }
        catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, preparedStmt);
        return added;
    }
    //ADD END
    
    //DELETE START
    ///DELETE function here
    ///Start every function with delete_*
    public boolean delete_design_and_colorway_con_from_id_colorway(int id_colorway)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        boolean deleted = false;
        try {
            
            conn = db.getConnection();
            ps = conn.prepareStatement("DELETE FROM colorway_screen_connect WHERE id_colorway = ?");
            int item = 1;
            ps.setInt(item++, id_colorway);
            ps.executeUpdate();
            deleted = true;
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps);
        return deleted;      
        
    }
    
    ///////////////////////////////////////////////////////////////////////////////////////////
        
    //GET START
    ///GET and search function here
    ///Start every function with get_* or search_*

    public int get_id_pigment(String pigment_name)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int pigment_id = -1;
        try 
        {
            conn = db.getConnection();
            ps = conn.prepareStatement("SELECT pigment_no "
                    + "FROM pigment "
                    + "WHERE pigment_name = ?");
            int item = 1;
            ps.setString(item++, pigment_name);
            rs = ps.executeQuery();
            
            if(rs.first())
            {
                pigment_id = rs.getInt("pigment_no");
            }   
            
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.closeConn(conn, ps, rs);
        return pigment_id;
    }
    
    public int get_id_screen(int pigment_no, float pigment_percentage)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id_screen = -1;
        try
        {
            conn = db.getConnection();
            ps = conn.prepareStatement("SELECT id_screen "
                                + "FROM screen_pigment "
                                + "WHERE pigment_no = ? "
                                + "AND pigment_percentage BETWEEN ? AND ?");
            int item = 1;
            ps.setInt(item++, pigment_no);
            ps.setFloat(item++, pigment_percentage);
            ps.setFloat(item++, pigment_percentage);
            rs = ps.executeQuery();
            if(rs.first())
            {
                id_screen = rs.getInt("id_screen");
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps, rs);
        return id_screen;
    }
    
    public List<Screen_and_colorway_link> set_all_colorway_from_design_code(int this_design_code)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Screen_and_colorway_link> all_color_screen = new ArrayList<>();
        try{
            conn = db.getConnection();
            ps = conn.prepareStatement("SELECT * " 
                                + "FROM colorway "
                                + "WHERE design_code = ? "
                                + " ORDER BY id_colorway");
            /*                  + "IN (SELECT id_colorway "
                                    + " FROM design_colorway_connect "
                                    + " WHERE design_code = ?) ");*/          
            int item = 1;
            ps.setInt(item++, this_design_code);
            rs = ps.executeQuery();
            
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
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps, rs);
        return all_color_screen;
        
    }
    
    public List<Colorway_and_pigment> set_all_colorway_and_screen_from_colorway_id(int colorway_id)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet screen_rs = null;
        List<Colorway_and_pigment> this_screen = new ArrayList<>();
        
        try{
            conn = db.getConnection();
            
            ps = conn.prepareStatement("SELECT id_color_screen, p.pigment_no, pigment_percentage, p.pigment_name " 
                                 + " FROM colorway_screen_connect s_p, pigment p" 
                                 + " WHERE id_colorway = ? "
                                 + " AND s_p.pigment_no = p.pigment_no "
                                 + " ORDER BY id_color_screen ASC");
            int item = 1;
            ps.setInt(item++, colorway_id);
            
            screen_rs = ps.executeQuery();
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
            
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps, screen_rs);
        return this_screen;

    }
    
    //Get all colorway details using the colorway_id
    public colorway set_colorway_details_from_colorway_id(int id_colorway)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        colorway this_colorway = null;
        
        try
        {
            conn = db.getConnection();
            
            ps = conn.prepareStatement("SELECT colorway_name,  binder, weight_kg, design_code "
                                + "FROM colorway "
                                + "WHERE id_colorway = ?");
            int item = 1;
            
            ps.setInt(item++, id_colorway);
            rs = ps.executeQuery();
            
            if(rs.first())
            {
                this_colorway = new colorway();
                this_colorway.setId_colorway(id_colorway);
                this_colorway.setDesign_code(rs.getInt("design_code"));
                this_colorway.setColorway_name(rs.getString("colorway_name"));
                this_colorway.setBinder(rs.getFloat("binder"));
                this_colorway.setWeight_kg(rs.getFloat("weight_kg"));
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.closeConn(conn, ps, rs);
        return this_colorway;
    }
    
    public float get_last_binder_percent(){
        
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        float binder_percent = -1;
        try
        {
            conn = db.getConnection();
            ps = conn.prepareStatement("SELECT binder_percent FROM binders WHERE binder_id = (SELECT MAX(binder_id) FROM binders);");
            
            rs = ps.executeQuery();
            
            if(rs.first())
                binder_percent = rs.getFloat("binder_percent");
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps, rs);
        return binder_percent;
    }
    
    public pigment get_last_pigment_id_and_name()
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        pigment last_added_pigment = null;
        
        try
        {
            conn = db.getConnection();
            
            ps = conn.prepareStatement("SELECT pigment_name, pigment_no FROM pigment WHERE pigment_no = (SELECT MAX(pigment_no) FROM pigment);");
            rs = ps.executeQuery();
            
            if(rs.first())
            {   
                last_added_pigment = new pigment();
                last_added_pigment.setPigment_no(rs.getInt("pigment_no"));
                last_added_pigment.setPigment_name(rs.getString("pigment_name"));
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps, rs);
        return last_added_pigment;
    }
    
    public int get_id_color_screen(int id_screen, int id_colorway , float pigment_percentage)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id_color_screen = -1;
        try{
            conn = db.getConnection();
            
            ps = 
            conn.prepareStatement("SELECT id_color_screen "
                                + " FROM colorway_screen_connect "
                                + " WHERE id_screen = ? "
                                + " AND id_colorway = ?"
                                + " AND pigment_percentage = ?");
            int item = 1;
            ps.setInt(item++, id_screen);
            ps.setInt(item++, id_colorway);
            ps.setFloat(item++, pigment_percentage);
            rs = ps.executeQuery();
            
            if(rs.first())
            {
                id_color_screen = rs.getInt("id_color_screen");
            }
            
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.closeConn(conn, ps, rs);
        return id_color_screen;
    }
    
    public int get_id_colorway(colortextile_class.colorway existing_colorway)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id_colorway = -1;
        
        try{
            conn = db.getConnection();
            
            ps = conn.prepareStatement("SELECT id_colorway "
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

            rs = ps.executeQuery();
            if(rs.first())
            {
                id_colorway= rs.getInt("id_colorway");
             //   System.out.println(id_colorway);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps, rs);
        return id_colorway;
    }
    
    public design set_design_details_from_des_code(int code_design)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        design this_design = null;
        
        try{
            conn = db.getConnection();
            
            ps = conn.prepareStatement("SELECT * FROM design WHERE design_code = ?");
            int item = 1;
            ps.setInt(item++, code_design);
            
            rs = ps.executeQuery();
            
            if(rs.first())
            {
                this_design = new design();
                this_design.setColor_name(rs.getString("color_name"));
                this_design.setDesign_name(rs.getString("design_name"));
                this_design.setFabric_style(rs.getString("fabric_style"));
            }
            
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps, rs);
        return this_design;
    }
    
    
    public int get_design_code(colortextile_class.design new_design)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int design_code = -1;
        
        try{
            conn = db.getConnection();
            
            ps = conn.prepareStatement("SELECT design_code "
                    + "FROM design "
                    + "WHERE design_name = ? "
                    + "AND color_name = ? "
                    + "AND fabric_style = ?");
            int item = 1;
            ps.setString(item++, new_design.getDesign_name());
            ps.setString(item++, new_design.getColor_name());
            ps.setString(item++, new_design.getFabric_style());
            rs = ps.executeQuery();
            
            if(rs.first())
            {
                design_code = rs.getInt("design_code");
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps, rs);
        return design_code;
    }
    
    public ArrayList<String> get_all_pigment_name()
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<String> pigment_list = new ArrayList<String>();
        
        try
        {
            conn = db.getConnection();
            ps = conn.prepareStatement("SELECT pigment_name FROM pigment ORDER BY pigment_name asc");
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                pigment_list.add(rs.getString(1));
            }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.closeConn(conn, ps, rs);
        return pigment_list;
        
    }
    
    /**
     * 
     * @param id_pigment
     * @return pigment_name
     */
    public String get_pigment_name(int id_pigment)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String pigment_name = null;
        try{
            
            conn = db.getConnection();
            
            ps = conn.prepareStatement("SELECT pigment_name "
                                 + "FROM pigment "
                                 + "WHERE pigment_no = ? ");
            
            int item = 1;
            ps.setInt(item++, id_pigment);
            
            rs = ps.executeQuery();
            if(rs.first())
            {
                pigment_name = rs.getString("pigment_name");
            }
            
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
            this.closeConn(conn, ps, rs);
            return pigment_name;
    }
    
    //EDITING
    /**
     * Get the pigment id and percentage from screen_pigment table
     * @param id_screen
     * @return 
     */
    
    public int get_pigment_percentage(int id_screen)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int pigment_percentage = -1;
        try{
            
            conn = db.getConnection();
            ps = conn.prepareStatement("SELECT pigment_percentage "
                                 + "FROM screen_pigment "
                                 + "WHERE id_screen = ? ");
            
            int item = 1;
            ps.setInt(item++, id_screen);
            rs = ps.executeQuery();
            
            if(rs.first())
            {
                pigment_percentage = rs.getInt("pigment_percentage");
            }
            
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.closeConn(conn, ps, rs);
        return pigment_percentage;
    }
    
    //SKELETON TO COPY ONLY. Not usable
    public void get_skeleton()
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = db.getConnection();
            
            ps = 
            conn.prepareStatement("SELECT  FROM  WHERE ");
            int item = 1;
            
            rs = ps.executeQuery();
            rs.next();
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //returns id_purchase
    public int get_id_customer_name(colortextile_class.customer id_customer)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id_cus = -1;
        
        try{
            conn = db.getConnection();
            ps = conn.prepareStatement("SELECT id_customer "
                                 + "FROM customer "
                                 + "WHERE customer_name = ? ");
            
            ps.setString(1, id_customer.getCustomer_name());
            
            rs = ps.executeQuery();
            if(rs.first())
            {
                id_cus = rs.getInt("id_customer");
            }
            
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps, rs);
        return id_cus;
        
    }
    /***
     * 
     * @param customer_name
     * @return 0 if customer id is not found, else returns customer id taken from database
     */
    public int get_id_customer(String customer_name)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int customer_id = 0;
        try
        {
            conn = db.getConnection();
            ps = conn.prepareStatement("SELECT id_customer "
                    + "FROM customer "
                    + "WHERE customer_name = '"+ customer_name + "'");
            rs = ps.executeQuery();
            
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
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String customer_name = null;
        try
        {
            conn = db.getConnection();
            ps = conn.prepareStatement("SELECT customer_name "
                                                        + "FROM customer "
                                                        + "WHERE id_customer = ?");
            
            int item = 1;
            ps.setInt(item++, customer_id);
            
            rs = ps.executeQuery();
            
            if(rs.first())
            {
                customer_name = rs.getString("customer_name");
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps, rs);
        return customer_name;
    }
    
    public int get_fabric_style_id(String fabric_name)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int fabric_id = -1;
        
        try{
            conn = db.getConnection();
            ps = conn.prepareStatement("SELECT id_fabric FROM fabric_style WHERE fabric_name = ?");
            
            int item = 1;
            ps.setString(item++, fabric_name);
            rs = ps.executeQuery();
            if(rs.first())
            {
                fabric_id = rs.getInt("id_fabric");
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps, rs);
        return fabric_id;
    }
    public ArrayList<Float> get_all_binder()
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Float> binder_list = new ArrayList<>();
        try
        {    
            conn = db.getConnection();
            ps = conn.prepareStatement("SELECT binder_percent FROM binders ORDER BY binder_percent ASC ");
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                binder_list.add(rs.getFloat("binder_percent"));
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps, rs);
        return binder_list;
    }
    public ArrayList<String> get_all_fabric_styles()
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<String> fabric_style = new ArrayList<>();
        try
        {
            conn = db.getConnection(); 
            
            ps = conn.prepareStatement("SELECT fabric_name FROM fabric_style ORDER BY fabric_name ASC ");
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                fabric_style.add(rs.getString("fabric_name"));
            }
            
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps, rs);
        return fabric_style;
    }
    
    public ArrayList<String> get_customer_list(colortextile_class.customer customer_name) 
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<String> names = new ArrayList<>();
        try
        {
            conn = db.getConnection();  
          
            ps = conn.prepareStatement("SELECT * FROM customer ORDER BY customer_name ASC ");
            rs = ps.executeQuery();
            
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

        this.closeConn(conn, ps, rs);
        return names;
    }
    
    public List<purchase_order> get_all_purchase_for_this_job_order(colortextile_class.job_order this_job_order)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<purchase_order> all_purchase_this_job = new ArrayList<purchase_order>();
        try
        {
            conn = db.getConnection();
            ps = conn.prepareStatement("SELECT * FROM puchase_order WHERE job_order_id = ?");
            
            int item = 1;
            ps.setString(item++, this_job_order.getJob_id());
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                purchase_order this_purchase = new purchase_order();
                this_purchase.setQuantity(rs.getInt("quantity"));
                this_purchase.setDesign_code(rs.getInt("design_code"));
                this_purchase.setJob_order_id(this_job_order.getJob_id());
                this_purchase.setId_purchase(rs.getInt("id_purchase"));
                all_purchase_this_job.add(this_purchase);
            }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps, rs);
        return all_purchase_this_job;
    }
    
    
    public ResultSet get_all_job_order(colortextile_class.job_order job_order)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //error
        try
        {
            conn = db.getConnection();
            ps = conn.prepareStatement("SELECT * FROM job_order");
            rs = ps.executeQuery();
            if (rs.first()){
            ResultSet rs2 = rs;
            this.closeConn(conn, ps, rs);
            return rs2;
            }
            
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
        
    }
    
    public colortextile_class.job_order get_job_order_details(String job_order_id)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        colortextile_class.job_order this_job = new colortextile_class.job_order();
        this_job.setJob_id("-1");
        try
        {
            conn = db.getConnection(); 
            ps = conn.prepareStatement("SELECT * "
                                                        + " FROM job_order jo , customer cu "
                                                        + " WHERE job_order_id = ? "
                                                        + " AND jo.customer_id = cu.id_customer");
            int item = 1;
            ps.setString(item++, job_order_id);
            rs = ps.executeQuery();
            
            if(rs.first())
            {
                //this_job.setJob_id(job_order_id);
                this_job.setCustomer_id(rs.getInt("customer_id"));
                this_job.setDate(rs.getString("date"));
                this_job.setCustomer_name(rs.getString("customer_name"));
            }
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps, rs);
        return this_job;
    }
    
    public List<job_order> set_job_order_info_from_purchase_id(int purchase_id){
        
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<job_order> job_list = new ArrayList<job_order>();
        try
        {
            conn = db.getConnection(); 
            ps = conn.prepareStatement("SELECT * FROM job_order WHERE id_purchase = ?");
            
            int item = 1;
            ps.setInt(item++, purchase_id);
            rs = ps.executeQuery();
            while(rs.next())
            {
                job_order this_job = new job_order();
                
                this_job.setCustomer_id(rs.getInt("customer_id"));                
                this_job.setJob_id(rs.getString("job_order_id"));
                this_job.setDate(rs.getString("date"));
                //this_job.setQuantity(rs.getInt("quantity"));

                job_list.add(this_job);
            }
            
            /*
            for(job_order all_jobs : job_list)
            {
                all_jobs.display_details();
            }
            */
            
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps, rs);
        return job_list;
    }
    
    public List<purchase_order> get_all_purchase_details_from_date_and_design(String date, int des_code)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<purchase_order> all_purchase_this_job = new ArrayList<purchase_order>();
        try
        {
            conn = db.getConnection();
            ps = conn.prepareStatement("SELECT jo.job_order_id, date, customer_id, id_purchase, quantity, design_code "
                    + " FROM purchase_order po, "
                    + "     job_order jo "
                    + " WHERE jo.job_order_id = po.job_order_id"
                    + " AND date = ? "
                    + " AND design_code = ?");
            
            int item = 1;
            ps.setString(item++, date);
            ps.setInt(item++, des_code);
            
            rs = ps.executeQuery();
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
            
            
            
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps, rs);
        return all_purchase_this_job;
    }
    
    public List<job_order> get_all_job_order_and_details_from_design_and_purchase_id(int design_code, int purchase_id)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<job_order> all_job_this_purchase = new ArrayList<job_order>();
        try
        { 
            conn = db.getConnection();
            ps = conn.prepareStatement("SELECT p.job_order_id, customer_id, date , customer_name "
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
            
            rs = ps.executeQuery();
            while(rs.next())
            {
                job_order this_order = new job_order();
                this_order.setJob_id(rs.getString("job_order_id"));
                this_order.setCustomer_id(rs.getInt("customer_id"));
                this_order.setDate(rs.getString("date"));
                this_order.setCustomer_name(rs.getString("customer_name"));
                all_job_this_purchase.add(this_order);
             }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);   
        }
        this.closeConn(conn, ps, rs);
        return all_job_this_purchase;
    }
    
    public Blob get_design_picture_using_design_id(int design_code)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Blob design_picture = null;
        try
        {
            conn = db.getConnection();
            ps = conn.prepareStatement("SELECT design_picture FROM design_picture WHERE design_code = ? ");
            int item = 1;
            ps.setInt(item++, design_code);
            rs = ps.executeQuery();
            if(rs.first()){
                design_picture = rs.getBlob(1);
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);  
        }
        this.closeConn(conn, ps,rs);
        return design_picture;
    }
    
    public ResultSet get_picture_from_design_id(colortextile_class.design this_picture)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //error
        try
        {
            conn = db.getConnection();  
          
            ps = conn.prepareStatement("SELECT design_picture FROM design_picture WHERE design_code = '"+ this_picture.getDesign_code()+"' ");
            rs = ps.executeQuery();
            
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
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Integer> design_codes = new ArrayList<>();
        try
        {
            conn = db.getConnection();
            ps = conn.prepareStatement(" SELECT DISTINCT(design_code)" +
                                                         " FROM job_order jo, purchase_order po " +
                                                         " WHERE jo.job_order_id = po.job_order_id" +
                                                         " AND DATE = ?;");
            
            int item = 1;
            ps.setString(item++, date);
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                design_codes.add(rs.getInt("design_code"));
            }
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps, rs);
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
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DefaultTableModel model = get_column_table_for_merged_date();
        
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement("SELECT date, " +
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
            rs = ps.executeQuery();
            
            if (rs.next())
            {
                rs.previous();
                while(rs.next())
                {
                    String get_job_prefix = rs.getString("All Job Order").substring(0, 7);
                    String get_job_string = rs.getString("All Job Order").replaceAll(get_job_prefix,"");
                    get_job_string = get_job_prefix+ get_job_string;
                    
                    String[] this_set = {
                        rs.getString("date"),
                        rs.getString("Design Name/s"),
                        rs.getString("Color/s"),
                        rs.getString("Fabric Style/s"),
                        rs.getString("Customer/s"),
                        get_job_string
                        //rs.getString("All Job Order")
                    };
                    model.addRow(this_set);
                }
            }
            else {
                JOptionPane.showMessageDialog(null,"No Record");
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps, rs);
        return model;
    
    }
    
    public DefaultTableModel get_table_job_order_purchase_design()
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DefaultTableModel model = new DefaultTableModel();
        
        try {
            
            conn = db.getConnection();
            ps = conn.prepareStatement("SELECT design_name , date, "
                    + " group_concat(jord.job_order_id SEPARATOR ', ') AS 'All Jobs' " 
                    + " FROM job_order jord, purchase_order purch, design des  " 
                    + " WHERE jord.job_order_id = purch.job_order_id "
                    + " AND des.design_code = purch.design_code"
                    + " GROUP BY date, des.design_code; ");
            
            rs = ps.executeQuery();
            
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
            }
            else {
                JOptionPane.showMessageDialog(null,"No Record");
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps, rs);
        return model;
    }
    
    public DefaultTableModel get_column_for_design_customer_job_order()
    {
        DefaultTableModel model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
            return false;
            }
        };
        
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
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DefaultTableModel model = get_column_for_design_customer_job_order();
        
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement("SELECT design_name, color_name, fabric_style, Sum(Quantity) as 'Total', date, " +
                            " group_concat(customer_name) AS 'Customer', " +
                            " group_concat(jord.job_order_id SEPARATOR ', ') AS 'All Jobs' " +
                            " FROM job_order jord, purchase_order purch, design des, customer cust " +
                            " WHERE jord.job_order_id = purch.job_order_id " +
                            " AND des.design_code = purch.design_code " +
                            " AND cust.id_customer= jord.customer_id " +
                            " GROUP BY date, des.design_code"+ 
                            " ORDER BY design_name ASC; ");
            rs = ps.executeQuery();
            
            if (rs.first()){
                
               rs.previous();
                while (rs.next())
                {   
                    String get_job_prefix = rs.getString("All Jobs").substring(0, 7);
                    String get_job_string = rs.getString("All Jobs").replaceAll(get_job_prefix,"");
                    get_job_string = get_job_prefix+ get_job_string;
                    
                    String[] this_set = {
                        rs.getString("date"),
                        rs.getString("design_name"),
                        rs.getString("color_name"),
                        rs.getString("fabric_style"),
                        rs.getString("Total"),
                        rs.getString("Customer"),
                        get_job_string
                    };
                    model.addRow(this_set);
                }
                
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
        this.closeConn(conn, ps, rs);
        return model;
    }
    
    public DefaultTableModel get_table_all_design()
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("Design");  
        model.addColumn("Color");   
        model.addColumn("Fabric Style");    
        
        try 
        {
            conn = db.getConnection();
            ps = conn.prepareStatement("SELECT design_name, color_name, fabric_style " +
                            " FROM design des " + 
                            " ORDER BY design_name ASC; ");
            
            rs = ps.executeQuery();
            
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
        this.closeConn(conn, ps, rs);
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
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int last_purchase_id = -1;
        try
        {
            conn = db.getConnection();
            ps = conn.prepareStatement("SELECT MAX(id_purchase) AS last FROM purchase_order");
            
            rs = ps.executeQuery();
            if (rs.next()) {
                last_purchase_id = rs.getInt("last");
            }
        } 
        catch(SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps, rs);
        return last_purchase_id;
    }
    public int get_id_purchase(colortextile_class.purchase_order new_purchase){
       
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id_purchase = -1;
        try{
            conn = db.getConnection();
            
            ps = conn.prepareStatement("SELECT id_purchase "
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
            rs = ps.executeQuery();
            if(rs.first())
            {
                 id_purchase = rs.getInt("id_purchase");
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps, rs);
        return id_purchase;
    }
    
    public purchase_order get_purchase_details_from_job_order_and_design_code(String id_job_order, int design_code )
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        purchase_order current_purchase = new purchase_order();
        try
         {
            conn = db.getConnection();
            ps = conn.prepareStatement("SELECT *"
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
            rs = ps.executeQuery();
            if(rs.first())
            {
                current_purchase.setQuantity(rs.getInt("quantity"));
                current_purchase.setDesign_code(rs.getInt("design_code"));
                current_purchase.setJob_order_id(rs.getString("job_order_id"));
                current_purchase.setId_purchase(rs.getInt("id_purchase"));
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
         this.closeConn(conn, ps, rs);
         return current_purchase;
    }
    
    public purchase_order get_purchase_details(int purchase_id)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        purchase_order current_purchase = new purchase_order();
         try
         {
            conn = db.getConnection();
            ps = conn.prepareStatement("SELECT design_code, job_order_id, quantity "
                                 + "FROM purchase_order "
                                 + "WHERE id_purchase = ? ");
            
            int item = 1;
            ps.setInt(item++, purchase_id);
            /*  //FOR CHECKING/DEBUGGING
            System.out.println("Date :" +new_purchase.getDate());
            System.out.println("Colorway Id :"  new_purchase.getDesign_code);
            */
            rs = ps.executeQuery();
            if(rs.first())
            {
                current_purchase.setQuantity(rs.getInt("quantity"));
                current_purchase.setDesign_code(rs.getInt("design_code"));
                current_purchase.setJob_order_id(rs.getString("job_order_id"));
            }
            
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
         this.closeConn(conn, ps, rs);
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
        
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<String> names = new ArrayList<>();
        try
        {
            conn = db.getConnection();
            ps = conn.prepareStatement("SELECT * FROM customer WHERE customer_name= '"+ customer_name.getCustomer_name() +"'");
            rs = ps.executeQuery();
            
            while(rs.next())
            {
                names.add(rs.getString("customer_name"));
            }
            customer_name.setCustomer_names(names);
            this.closeConn(conn, ps, rs);
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps, rs);
        
    }
    public ResultSet Search_job(String id){
        
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            //error
            conn = db.getConnection();
            String sql = "SELECT * FROM job_order WHERE job_order_id = '" + id + "'";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            job_order results = new job_order();
            if(rs.first()){
            
            ResultSet rs2 = rs;
            this.closeConn(conn, ps, rs);
            return rs2;
            }
            
        }catch(Exception e){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    public boolean Search_job_id(colortextile_class.job_order job){
        
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean found = false;
        try{
          
            db = new DBConnection();
            conn = db.getConnection();
            String sql = "SELECT * FROM job_order WHERE job_order_id = '" + job.getJob_id() + "'";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if(rs.first()){
                String id = rs.getString("job_order_id");
                found = true;
            }
            this.closeConn(conn, ps, rs);
           
        }catch(Exception e){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, e);
        }
        return found;
    }
    
    public ResultSet Search_colorway(colortextile_class.colorway color){
        //error
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try
        {
            conn = db.getConnection();
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
          
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.first()){
            ResultSet rs2 = rs;
            this.closeConn(conn, ps, rs);
            return rs2;
            }
            
          }
          
        }
        catch (Exception ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }
        return null;
    }
    
    public ResultSet Search_colorway_screen_connect(colortextile_class.Colorway_and_pigment connect){
        try
        {
          DBConnection db = new DBConnection();
          Connection conn = db.getConnection();  
          
          String sql = "SELECT * FROM colorway_screen_connect WHERE";
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
            if(rs.first()){
            ResultSet rs2 = rs;
            this.closeConn(conn, ps, rs);
            return rs2;
            }
            
          }
        }
        catch (Exception ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }
        return null;
    }
    
    public ResultSet Search_id_purchase(colortextile_class.purchase_order purchase){     // in use at (purchase order class.  SearchJOGui //  get_design_code_from_table_selected()
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
            if (rs.first()){
            ResultSet rs2 = rs;
            this.closeConn(conn, ps, rs);
            return rs2;
            }
          
          }
        }
        catch (Exception ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }
        return null;
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
            if (rs.first()){
            ResultSet rs2 = rs;
            this.closeConn(conn, ps, rs);
            return rs2;
            }
            
          }
        }
        catch (Exception ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public ResultSet Search_Design(colortextile_class.design design) { // still in use
        
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
            if (rs.first()){
            ResultSet rs2 = rs;
            this.closeConn(conn, ps, rs);
            return rs2;
            }
        
          }
        }
        catch (Exception ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }
         return null;
    }
    //SEARCH END
    public int check_if_design_picture_has_already_been_added(int design_code)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int checkTest = 0;
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement("SELECT EXISTS "
                    + " (SELECT design_code "
                    + " FROM design_picture WHERE "
                    + " design_code = ?) "
                    + " AS 'CheckTest'");

            int item = 1;
            ps.setInt(item++, design_code);
            rs = ps.executeQuery();
            
            rs.first();
            checkTest = rs.getInt("CheckTest");
            
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps);
        return checkTest;
    }
    
    public void update_or_insert_design_picture(design this_design)
    {
        //error
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        File file = new File("New.jpg");
        try
        {
            conn = db.getConnection();
            FileInputStream fis = new FileInputStream(file);
            //System.out.println(file.exists());
            if(file.exists())
            {
                int item =1;
                if(this.check_if_design_picture_has_already_been_added(this_design.getDesign_code()) == 0)
                {
                    ps = conn.prepareStatement("INSERT design_picture "
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
        this.closeConn(conn, ps, rs);
        
    }
    
    public void update_design(design this_design)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        int item = 1;
        try
        { 
            conn = db.getConnection();
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
            
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);    
        }
        this.closeConn(conn, ps); 
        this.update_or_insert_design_picture(this_design);
    }
    
    public void update_colorway_screen(Colorway_and_pigment this_color_screen)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        try{
           /*
           UPDATE colorway_screen_connect SET pigment_no = (SELECT pigment_no FROM pigment WHERE pigment_name LIKE "L. PINK"), 
           pigment_percentage= 56
            WHERE id_color_screen = 33;
           */
           ps = conn.prepareStatement("UPDATE colorway_screen_connect "
                                                        + " SET pigment_no = ?, "
                                                        + " pigment_percentage = ? "
                                                        + " WHERE id_color_screen = ?");
           int item = 1;
           ps.setInt(item++, this_color_screen.getPigment_no());
           ps.setFloat(item++, this_color_screen.getPigment_percentage());
           ps.setInt(item++, this_color_screen.getId_color_screen());
           ps.executeUpdate();
           
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps);
    }
    
    public void update_pigment(pigment this_pigment)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        int item = 1;
        
        try {
            conn = db.getConnection();
            ps = conn.prepareStatement("UPDATE pigment "
                    + " SET pigment_name=? "
                    + " WHERE pigment_no = ?;");
            
            ps.setString(item++, this_pigment.getPigment_name().toUpperCase());
            ps.setInt(item++, this_pigment.getPigment_no());
            ps.executeUpdate();
            
        } catch (SQLException ex) 
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps);
          
    }
    
    public void update_colorway(colorway this_colorway)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try
        {
            conn = db.getConnection();
            ps = conn.prepareStatement("UPDATE colorway "
                                                        + " SET colorway_name = ?, binder = ?, weight_kg = ? "
                                                        + " WHERE id_colorway = ?");
            int item = 1;
          //this_colorway.view_colorway_details();
            ps.setString(item++, this_colorway.getColorway_name().toUpperCase());
            ps.setFloat(item++, this_colorway.getBinder());
            ps.setFloat(item++, this_colorway.getWeight_kg());
            ps.setInt(item++, this_colorway.getId_colorway());
            ps.executeUpdate();
          
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps);
    }
    
    public int count_job_order_usage(String job_order_id)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int total = 0;
        try{
            conn = db.getConnection();
            ps = conn.prepareStatement("SELECT COUNT(id_purchase) AS 'Total' "
                                                        + " FROM purchase_order "
                                                        + " WHERE job_order_id = ?");
            int item = 1;
            ps.setString(item++, job_order_id);
            rs = ps.executeQuery();
            if(rs.first())
                total = rs.getInt("Total");
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps, rs);
        return total;
    }
    
    public void update_job_order(job_order this_job_order)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try
        {
            conn = db.getConnection();
            ps = conn.prepareStatement("UPDATE job_order "
                                                        + " SET customer_id  = ?, "
                                                        + " date = ?"
                                                        + " WHERE job_order_id = ?");
            int item = 1;
            ps.setInt(item++, this_job_order.getCustomer_id());
            ps.setString(item++, this_job_order.getDate());
            ps.setString(item++, this_job_order.getJob_id());
            ps.executeUpdate();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps);
    }
    
    public void update_purchase_order_quantity(purchase_order this_purchase)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try
        {
            conn = db.getConnection();
            ps = conn.prepareStatement("UPDATE purchase_order "
                                                        + " SET quantity  = ? "
                                                        + " WHERE id_purchase = ?");
            int item = 1;
            ps.setFloat(item++, this_purchase.getQuantity());
            ps.setInt(item++, this_purchase.getId_purchase());
            ps.executeUpdate();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps);
    }
    
    public void delete_colorway_screen_connect(int id_colorway)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try
        {
            conn = db.getConnection();
            ps = conn.prepareStatement("DELETE FROM colorway_screen_connect "
                                                        + "WHERE id_colorway = ?");
            int item = 1;
            ps.setInt(item++, id_colorway);
          //ps.setInt(item++, connection_del.getPigment_no());
            ps.executeUpdate();
        }
        catch (SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.closeConn(conn, ps);
    }
    
    public void delete_purchase_order(purchase_order this_purchase)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try
        {
          conn = db.getConnection();
          ps = conn.prepareStatement("DELETE FROM purchase_order "
                                                        +" WHERE id_purchase = ?");
          int item = 1;
          ps.setInt(item++, this_purchase.getId_purchase());
          ps.executeUpdate();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex); 
        }
        this.closeConn(conn, ps);
    }
    
    public void delete_pigment(int pigment_no)
    {
        
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        
        try
        {
            conn = db.getConnection();
            ps = conn.prepareStatement("DELETE FROM pigment"
                                                        +" WHERE pigment_no = ?");
            int item = 1;
            ps.setInt(item++, pigment_no);
            
            ps.executeUpdate();
            
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex); 
        }
        this.closeConn(conn, ps);
    }
    
    public void delete_job_order(job_order this_job)
    {
        DBConnection db = new DBConnection();
        Connection conn = null;
        PreparedStatement ps = null;
        try
        {
            conn = db.getConnection();
            ps = conn.prepareStatement("DELETE FROM job_order "
                                                        +" WHERE job_order_id = ?");
            int item = 1;
            ps.setString(item++, this_job.getJob_id());
            ps.executeUpdate();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex); 
        }
        this.closeConn(conn, ps);
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
    
   

