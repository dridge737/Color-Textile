/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;

import colortextile_class.deletedClass.screen_pigment;
import colortextile_class.*;
import java.awt.Image;
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

/**
 *
 * @author Eldridge
 */
public class DB_Manager {
   
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
        
        ps.setString(item++, fabric_name);
        ps.executeUpdate();
        
        return true;
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
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
        

        return true;
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public int count_number_of_pigment()
    {
        try {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("SELECT COUNT(pigment_no) AS 'Total' FROM pigment");
           
            ResultSet rs = ps.executeQuery();
            
            rs.first();
            return rs.getInt("Total");
            
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    public boolean add_pigment(colortextile_class.pigment this_pigment)
    {
        try {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO pigment(pigment_name) VALUES (?)");

            int item = 1;
            ps.setString(item++, this_pigment.getPigment_name());

            ps.executeUpdate();
            
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
            return rs.getInt("CheckTest");
            
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
            return rs.getInt("CheckTest");
            
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
            return rs.getInt("CheckTest");
            
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
            preparedStmt.setString(1, new_customer.getCustomer_name());

            preparedStmt.execute();
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
                                                       + "VALUES (? , ? , ? , ?)");
            int item =1;
            ps.setString(item++, new_colorway.getColorway_name());
            ps.setFloat(item++, new_colorway.getBinder());
            ps.setFloat(item++, new_colorway.getWeight_kg());
            ps.setInt(item++, new_colorway.getDesign_code());
            
            ps.executeUpdate(); 
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
            
            PreparedStatement ps = conn.prepareStatement("INSERT INTO colorway_screen_connect (pigment_no, id_colorway, pigment_percentage)"
                                                       + "VALUES (?, ?, ?);");
            int item =1;
            ps.setInt(item++, id_pigment);
            ps.setInt(item++, id_colorway);
            ps.setFloat(item++, pigment_percentage);
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
            
            PreparedStatement ps = conn.prepareStatement("INSERT INTO design (design_name, color_name, fabric_style) "
                                                        + "VALUES ( ? , ? , ? )");
            int item = 1;
            ps.setString(item++, new_design.getDesign_name()); 
            ps.setString(item++, new_design.getColor_name());
            ps.setString(item++, new_design.getFabric_style());
          
            ps.executeUpdate();
            //System.out.println("Another Result = " +hello);
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
        
            PreparedStatement ps = conn.prepareStatement("DELETE FROM colorway_screen_connect WHERE id_colorway = ?");
        
            int item = 1;
            ps.setInt(item++, id_colorway);
            ps.executeUpdate();
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
                System.out.println(pigment_id);
                return pigment_id;
            }   
            
        } catch (SQLException ex) {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return -1;
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
            return rs.getInt("CheckTest");
            
        }
        catch(SQLException ex){
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
                return id_screen;
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return -1;
    }
    
    public List<Colorway_screen_link_functions> set_all_colorway_from_design_code(int this_design_code)
    {
        try{
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = 
            conn.prepareStatement("SELECT * " 
                                + "FROM colorway "
                                + "WHERE design_code = ? ");
                    
/*                                + "IN (SELECT id_colorway "
                                    + " FROM design_colorway_connect "
                                    + " WHERE design_code = ?) ");
  */          
            int item = 1;
            ps.setInt(item++, this_design_code);
            
            List<Colorway_screen_link_functions> all_color_screen = new ArrayList<>();
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                Colorway_screen_link_functions current_colorway = new Colorway_screen_link_functions();
                current_colorway.setBinder(rs.getFloat("binder"));
                current_colorway.setColorway_name(rs.getString("colorway_name"));
                current_colorway.setWeight_kg(rs.getFloat("weight_kg"));
                current_colorway.setId_colorway(rs.getInt("id_colorway"));
                current_colorway.setDesign_code(this_design_code);
                all_color_screen.add(current_colorway);
            }
            rs.close();
            conn.close();
            
            return all_color_screen;
            
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<colorway_and_screen> set_all_colorway_and_screen_from_colorway_id(int colorway_id)
    {
        try{
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = 
            conn.prepareStatement("SELECT p.pigment_no, pigment_percentage, p.pigment_name " 
                                 + " FROM colorway_screen_connect s_p, pigment p" 
                                 + " WHERE id_colorway = ? "
                                 + " AND s_p.pigment_no = p.pigment_no");
            int item = 1;
            ps.setInt(item++, colorway_id);
            
            ResultSet screen_rs = ps.executeQuery();
            
            List<colorway_and_screen> this_screen = new ArrayList<>();
           
            
            while(screen_rs.next())
            {
                colorway_and_screen this_s_pigment = new colorway_and_screen();
                
                this_s_pigment.setId_colorway(colorway_id);
                this_s_pigment.setPigment_no(screen_rs.getInt("p.pigment_no"));
                this_s_pigment.setPigment_percentage(screen_rs.getFloat("pigment_percentage"));
                this_s_pigment.setPigment_name(screen_rs.getString("p.pigment_name"));
                this_screen.add(this_s_pigment);
            }
            
            screen_rs.close();
            conn.close();
            
            return this_screen;
            
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    //DELETED **NEVER USE!
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
                /*
                System.out.println("Screen id = "+screen_rs.getInt("id_screen"));
                System.out.println("Pigment no = "+screen_rs.getInt("p.pigment_no"));
                System.out.println("Pigment percentage = "+screen_rs.getFloat("pigment_percentage"));
                System.out.println("Pigment name= "+screen_rs.getString("p.pigment_name"));
                */
                //this_s_pigment.setId_screen(screen_rs.getInt("id_screen"));
                this_s_pigment.setPigment_no(screen_rs.getInt("p.pigment_no"));
                this_s_pigment.setPigment_percentage(screen_rs.getFloat("pigment_percentage"));
                this_s_pigment.setPigment_name(screen_rs.getString("p.pigment_name"));
                this_screen.add(this_s_pigment);
            }
            /*
            for(screen_pigment thisscreens : this_screen)
            {
                System.out.println("Screen id = "+thisscreens.getId_screen());
                System.out.println("Pigment no = "+thisscreens.getPigment_no());
                System.out.println("Pigment percentage = "+thisscreens.getPigment_percentage());
                System.out.println("Pigment name= "+thisscreens.getPigment_name());
            }
            */
            screen_rs.close();
            conn.close();
            
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
            rs.close();
            conn.close();
            return this_colorway;
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
        
    }
    
    public int get_id_color_screen(int id_screen, int id_colorway , float pigment_percentage)
    {
        int id_color_screen = -1;
        try{
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = 
            conn.prepareStatement("SELECT id_color_screen "
                                + " FROM colorway_screen_connect "
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
            
            rs.close();
                conn.close();
                return id_color_screen;
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id_color_screen;
    }
    
    public int get_id_colorway(colortextile_class.colorway existing_colorway)
    {
        try{
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = 
            conn.prepareStatement("SELECT id_colorway "
                                 + "FROM colorway "
                                 + "WHERE colorway_name LIKE ? "
                                 + "AND binder LIKE ? "
                                 + "AND weight_kg BETWEEN ? AND ?");
            
            int item = 1;
            ps.setString(item++, existing_colorway.getColorway_name());
            ps.setFloat(item++, existing_colorway.getBinder());
            ps.setFloat(item++, existing_colorway.getWeight_kg()- (float) 0.01);
            ps.setFloat(item++, existing_colorway.getWeight_kg()+ (float) 0.01);
            
            System.out.println("Colorway name :" +existing_colorway.getColorway_name());
            System.out.println("Binder :" +existing_colorway.getBinder());
            System.out.println("Weight Kg :" +existing_colorway.getWeight_kg());
            
            ResultSet rs = ps.executeQuery();
            if(rs.first())
            {
                int id_colorway = rs.getInt("id_colorway");
             //   System.out.println(id_colorway);
                return id_colorway;
            }
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
            
            if(rs.first())
            {
                design this_design = new design();
                this_design.setColor_name(rs.getString("color_name"));
                this_design.setDesign_name(rs.getString("design_name"));
                this_design.setFabric_style(rs.getString("fabric_style"));
                
                conn.close();
                rs.close();
                return this_design;
            }
            
            
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public int get_design_code(colortextile_class.design new_design)
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
                int design_code = rs.getInt("design_code");
                return design_code;
            }
            
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return -1;
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
            if(rs.first())
            {
                String pigment_name = rs.getString("pigment_name");
             //   System.out.println(id_colorway);
                return pigment_name;
            }
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
            if(rs.first())
            {
                screen_pigment new_screen = new screen_pigment();
                new_screen.setPigment_no(rs.getInt("pigment_no"));
                new_screen.setPigment_percentage(rs.getInt("pigment_percentage"));

                return new_screen;
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
            return null;
    }
    
    public int get_pigment_percentage(int id_screen)
    {
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
                int pigment_percentage = rs.getInt("pigment_percentage");
                return pigment_percentage;
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
            return -1;
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
        
        try{
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = 
            conn.prepareStatement("SELECT id_purchase "
                                 + "FROM customer "
                                 + "WHERE customer_name = ? ");
            
            ps.setString(1, id_customer.getCustomer_name());
            
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                int id_cus = rs.getInt("id_customer");
                return id_cus;
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
        
    }
    
    public int get_id_customer(String customer_name)
    {
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
    
    //EDITING
    //GET CUSTOMER NAME 
    /**
     * 
     * @param customer_id the primary key of customer
     * @return return a single customer name
     */    
    public String get_customer_name(int customer_id)
    {
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
                String customer_name = rs.getString("customer_name");
                return customer_name;
            }
            
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public int get_fabric_style_id(String fabric_name)
    {
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
                return rs.getInt("id_fabric");
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return -1;
    }
    
    public ArrayList<String> get_all_fabric_styles()
    {
        ArrayList<String> fabric_style = new ArrayList<>();
        try
        {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection(); 
            
            PreparedStatement ps = conn.prepareStatement("SELECT fabric_name FROM fabric_style ORDER BY fabric_style ASC ");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                fabric_style.add(rs.getString("fabric_name"));
            }
            
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
       
        
        ArrayList<String> names = new ArrayList<>();
        try
        {
          DBConnection db = new DBConnection();
          Connection conn = db.getConnection();  
          
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM customer ORDER BY customer_name ASC ");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                names.add(rs.getString("customer_name"));
            }
            customer_name.setCustomer_names(names);
            
            return names;
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
        
    }
    
    public ArrayList<purchase_order> get_all_purchase_details_from_date_and_design(String date, int des_code)
    {
        try
        {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection(); 
            
            PreparedStatement ps = 
                    conn.prepareStatement("SELECT jo.job_order_id, date, customer_id, id_purchase, quantity, design_code "
                    + " FROM puchase_order AS po, "
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
            
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    
    public ArrayList<purchase_order> get_all_purchase_for_this_job_order(colortextile_class.job_order this_job_order)
    {
        try{
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
                
                //FOR Debugging this all the purchase order
                //System.out.println("Purchase id = "+ rs.getInt("id_purchase"));
                //System.out.println("Job Order = "+ rs.getString("job_order_id"));
                //System.out.println("Design code= "+ rs.getInt("design_code"));
                //System.out.println("Quantity = " +rs.getInt("quantity"));
                
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
    
    public colortextile_class.job_order get_job_order_details(String job_order_id)
    {
        colortextile_class.job_order this_job = new colortextile_class.job_order();
        this_job.setJob_id("-1");
        try
        {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection(); 
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM job_order WHERE job_order_id = ?");
            int item = 1;
            ps.setString(item++, job_order_id);
            ResultSet rs = ps.executeQuery();
            
            if(rs.first())
            {
                this_job.setJob_id(job_order_id);
                this_job.setCustomer_id(rs.getInt("customer_id"));
                this_job.setDate(rs.getString("date"));
            
            }
            
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
            return this_job;
        }
        return this_job;
    }
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
            
            for(job_order all_jobs : job_list)
            {
                all_jobs.display_details();
            }
            
            return job_list;
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    
    public Blob get_picture_from_design_id(colortextile_class.design this_picture){
        try
        {
          DBConnection db = new DBConnection();
          Connection conn = db.getConnection();  
          
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM design_picture WHERE design_code = '"+ this_picture.getDesign_code()+"' ");
            ResultSet rs = ps.executeQuery();
            while(rs.first())
            {
                this_picture.setDesign_image(rs.getBlob("design_picture"));
                return rs.getBlob("design_picture");
            }
           
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return null;
    }
    
    
    public ResultSet get_all_design(){
        try
        {
          DBConnection db = new DBConnection();
          Connection conn = db.getConnection();  
          
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM design ORDER BY design_code ASC ");
            ResultSet rs = ps.executeQuery();
            
            return rs;
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        
    }
    public int get_id_purchase_last(colortextile_class.purchase_order last_purchase){
        try
        {
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();
        
        PreparedStatement ps = conn.prepareStatement("SELECT MAX(id_purchase) AS last FROM purchase_order");
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
           return rs.getInt("last");
           
           
        
        }
        } catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    public int get_id_purchase(colortextile_class.purchase_order new_purchase){
       try{
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = 
            conn.prepareStatement("SELECT id_purchase "
                                 + "FROM purchase_order "
                                 + "WHERE design_code = ? "
                                 + "AND job_order_id = ? ");
            
            int item = 1;
            //ps.setInt(item++, new_purchase.getQuantity());
            ps.setInt(item++, new_purchase.getDesign_code());
            ps.setString(item++, new_purchase.getJob_order_id());
            /* 
            System.out.println("Date :" +new_purchase.getDate());
            System.out.println("Colorway Id :"  new_purchase.getDesign_code);
            */
            ResultSet rs = ps.executeQuery();
            if(rs.first())
            {
                int id_purchase = rs.getInt("id_purchase");
             //   System.out.println(id_colorway);
                return id_purchase;
            }
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
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
            /* 
            System.out.println("Date :" +new_purchase.getDate());
            System.out.println("Colorway Id :"  new_purchase.getDesign_code);
            */
            ResultSet rs = ps.executeQuery();
            if(rs.first())
            {
                current_purchase.setQuantity(rs.getInt("quantity"));
                current_purchase.setDesign_code(rs.getInt("design_code"));
                current_purchase.setJob_order_id(rs.getString("job_order_id"));
            
                return current_purchase;
            }
            
            
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
    public void Update_Job_Order(colortextile_class.job_order job_order){
        
        try
        {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();  
          
          
        //    PreparedStatement st = conn.prepareStatement("UPDATE job_order SET job_order_id='"+stock+"', date='"+tingi+"' , quantity='"+tingi+"' , fabric_style='"+tingi+"' , design_code='"+tingi+"' WHERE pigment_name='"+pigment_name+"'");       
        //    st.execute();
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
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
            return null;
        }
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
          
          System.out.println(sql);
          
          if (sql == "SELECT * FROM colorway WHERE")
          {
              System.out.print("nothing to be searched");
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
    
    public ResultSet Search_colorway_screen_connect(colortextile_class.colorway_and_screen connect){
        try
        {
          DBConnection db = new DBConnection();
          Connection conn = db.getConnection();  
          
          String sql ="SELECT * FROM colorway_screen_connect WHERE";
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
                  
         
          
          System.out.println(sql);
          
          if (sql == "SELECT * FROM colorway_screen_connect WHERE")
          {
              System.out.print("nothing to be searched");
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
          System.out.println(sql);
          
          /*if (purchase.getDate_from() != null){
              
              if(increment > 0)
              { sql = sql + " AND";
              }
              sql = sql + " date BETWEEN '"+purchase.getDate_from()+"' AND '" + purchase.getDate_to()+"'";
              increment++;
          }*/
          /*
          if (purchase.getQuantity() != 0){
              
              if(increment > 0)
              { sql = sql + " AND";
              }
              
              sql = sql + " quantity = '"+purchase.getQuantity()+"' ";
              increment++;
          }
          */
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
          
          System.out.println(sql);
          
          if (sql == "SELECT * FROM purchase_order WHERE")
          {
              System.out.print("nothing to be searched");
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
          
          /*
          if (job.getDate_from() != null){
              
              if(increment > 0)
              { sql = sql + " AND";
              }
              sql = sql + " date BETWEEN '"+job.getDate_from()+"' AND '" + job.getDate_to()+"'";
              increment++;
          } */
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
          
          System.out.println(sql);
          
          if (sql == "SELECT * FROM job_order WHERE")
          {
              System.out.print("nothing to be searched");
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
          
          System.out.println(sql);
          
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
          
          System.out.println(sql);
          
          if (increment == 0)
          {
              System.out.print("nothing to be searched");
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
    
    public void update_design(design this_design)
    {
        try
        {
          DBConnection db = new DBConnection();
          Connection conn = db.getConnection();  
          
          PreparedStatement ps = conn.prepareStatement("UPDATE design "
                                            + "SET design_name = ?, "
                                            + "color_name = ?, "
                                            + "fabric_style = ? "
                                            + "WHERE design_code = ?");
           int item = 1;
           ps.setString(item++, this_design.getDesign_name());
           ps.setString(item++, this_design.getColor_name());
           ps.setString(item++, this_design.getFabric_style());
           ps.setInt(item++, this_design.getDesign_code());
          
          ps.executeUpdate();
          
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    public void update_colorway(colorway this_colorway)
    {
        try
        {
          DBConnection db = new DBConnection();
          Connection conn = db.getConnection(); 
          
          PreparedStatement ps = conn.prepareStatement("UPDATE colorway "
                                                        + "SET colorway_name = ?, binder = ?, weight_kg = ?"
                                                        + "WHERE id_colorway = ?");
          int item = 1;
          ps.setString(item++, this_colorway.getColorway_name());
          ps.setFloat(item++, this_colorway.getBinder());
          ps.setFloat(item++, this_colorway.getWeight_kg());
          ps.setInt(item++, this_colorway.getId_colorway());
          
          ps.executeUpdate();
          
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
          
          PreparedStatement ps = conn.prepareStatement("DELETE FROM colorway_screen_connect "
                                                        + "WHERE id_colorway = ?");
          int item = 1;
          ps.setInt(item++, id_colorway);
          //ps.setInt(item++, connection_del.getPigment_no());
          ps.executeUpdate();
          
        }
        catch (SQLException ex){
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
          
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
}
    
   

