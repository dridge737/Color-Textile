/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;

import colortextile_class.*;
import java.sql.Array;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
       /*
        System.out.println("Pigment_no = "+new_screen_pigment.getPigment_no() 
                            +"\nPigment_percentage = " +new_screen_pigment.getPigment_percentage());
        */
        
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
    
    public boolean add_purchase_order(colortextile_class.purchase_order new_purchase) {
        try {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
        
            String query = "INSERT INTO purchase_order (date, design_code) VALUES (?, ?)";
            
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, new_purchase.getDate());
            preparedStmt.setString(2, new_purchase.getDesign_code());
            
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
            
            PreparedStatement ps = conn.prepareStatement("INSERT INTO colorway_screen_connect (id_screen, id_colorway)"
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
    
    public boolean add_job_order(colortextile_class.job_order new_job)
    {
        try {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();

            String query = "INSERT INTO job_order (job_order_id, customer_id, quantity, id_purchase) VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setString(1, new_job.getJob_id());
            preparedStmt.setInt(2, new_job.getQuantity());         
            preparedStmt.setInt(3, new_job.getCustomer_id());
            preparedStmt.setInt(4, new_job.getId_purchase());

            preparedStmt.execute();
            return true;
        } catch (SQLException ex) {
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
    
            PreparedStatement ps = conn.prepareStatement("SELECT pigment_no FROM pigment WHERE pigment_name = ?");
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
    
    public int get_id_color_screen(int id_screen, int id_colorway)
    {
        try{
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = 
            conn.prepareStatement("SELECT id_color_screen "
                                + "FROM colorway_screen_connect "
                                + "WHERE id_screen = ? "
                                + "AND id_colorway = ?");
            int item = 1;
            
            ps.setInt(item++, id_screen);
            ps.setInt(item, id_colorway);
            
            ResultSet rs = ps.executeQuery();
            if(rs.first())
            {
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
            conn.prepareStatement("SELECT id_colorway "
                                 + "FROM colorway "
                                 + "WHERE colorway_name LIKE ? "
                                 + "AND binder LIKE ? "
                                 + "AND weight_kg BETWEEN ? AND ?");
            
            int item = 1;
            ps.setString(item++, existing_colorway.getColorway_name());
            ps.setFloat(item++, existing_colorway.getBinder());
            ps.setFloat(item++, existing_colorway.getWeight_kg());
            ps.setFloat(item++, existing_colorway.getWeight_kg());
            /* 
            System.out.println("Colorway name :" +existing_colorway.getColorway_name());
            System.out.println("Binder :" +existing_colorway.getBinder());
            System.out.println("Weight Kg :" +existing_colorway.getWeight_kg());
            */
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
                String design_code = rs.getString("design_code");
                return design_code;
            }
            
        }
        catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public int get_id_design_colorway(colortextile_class.design_colorway new_des_color)
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
            ps.setString(item++, new_des_color.getDesign_code());
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
            
            int item = 1;
            ps.setString(item++, id_customer.getCustomer_name());
            
            ResultSet rs = ps.executeQuery();
            if(rs.first())
            {
                int id_cus = rs.getInt("id_customer");
             //   System.out.println(id_colorway);
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
    
    public ResultSet get_all_job_order(colortextile_class.job_order job_order){
        
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
    
    public ResultSet get_single_purchase_info(colortextile_class.purchase_order purchase_id){
        try {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();  
          
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM purchase_order WHERE id_purchase = '"+purchase_id.getId_purchase()+"'");
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
        try
        {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection(); 
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM job_order WHERE job_order_id = ?");
            int item = 1;
            ps.setString(item++, job_order_id);
            ResultSet rs = ps.executeQuery();
            rs.first();
            this_job.setJob_id(job_order_id);
            this_job.setCustomer_id(rs.getInt("customer_id"));
            this_job.setQuantity(rs.getInt("quantity"));
            this_job.setId_purchase(rs.getInt("id_purchase"));
//            this_job.set
            
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return this_job;
    }
    
    public List<job_order> get_job_order_info_from_purchase_id(colortextile_class.job_order this_job_order){
        try
        {
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection(); 
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM job_order WHERE id_purchase = ?");
            int item = 1;
            ps.setInt(item++, this_job_order.getId_purchase());
            
            ResultSet rs = ps.executeQuery();
            List<job_order> job_list = new ArrayList<job_order>();
            job_order this_job = new job_order();
            while(rs.next())
            {
                this_job.setCustomer_id(rs.getInt("customer_id"));
                this_job.setJob_id(rs.getString("job_order_id"));
                this_job.setQuantity(rs.getInt("quantity"));
                
                job_list.add(this_job);
            }
            return job_list;
            
        }
        catch(SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public ResultSet get_all_design(){
        try
        {
          DBConnection db = new DBConnection();
          Connection conn = db.getConnection();  
          
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM design ORDER BY design ASC ");
            ResultSet rs = ps.executeQuery();
            
            return rs;
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        
    }
    public void get_id_purchase_last(colortextile_class.purchase_order last_purchase){
        try
        {
        DBConnection db = new DBConnection();
        Connection conn = db.getConnection();
        
        PreparedStatement ps = conn.prepareStatement("SELECT id_purchase FROM purchase_order");
        
        ResultSet rs = ps.executeQuery();
        if (rs.last()) {
            last_purchase.setId_purchase(rs.getInt("id_purchase"));
        }
        } catch(SQLException ex){
            Logger.getLogger(DB_Manager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public int get_id_purchase(colortextile_class.purchase_order new_purchase){
       try{
            DBConnection db = new DBConnection();
            Connection conn = db.getConnection();
            
            PreparedStatement ps = 
            conn.prepareStatement("SELECT id_purchase "
                                 + "FROM purchase_order "
                                 + "WHERE date = ? "
                                 + "AND design_code = ? ");
            
            int item = 1;
            ps.setString(item++, new_purchase.getDate());
            ps.setString(item++, new_purchase.getDesign_code());
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
    public ResultSet Search_id_purchase(colortextile_class.purchase_order purchase){
        try
        {
          DBConnection db = new DBConnection();
          Connection conn = db.getConnection();  
          
          String sql ="SELECT * FROM purchase_order WHERE";
          int increment = 0;
          
          if (purchase.getDesign_code() != null){
              sql = sql + " design_code = '"+purchase.getId_purchase()+"'";
              increment++;
          } 
          System.out.println(sql);
          
          if (purchase.getDate_from() != null){
              
              if(increment > 0)
              { sql = sql + " AND";
              }
              sql = sql + " date BETWEEN '"+purchase.getDate_from()+"' AND '" + purchase.getDate_to()+"'";
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
          
          if (job.getCustomer_id() != 0){
              sql = sql + " customer_id = '"+job.getCustomer_id()+"'";
              increment++;
          } 
          System.out.println(sql);
          /*
          if (job.getDate_from() != null){
              
              if(increment > 0)
              { sql = sql + " AND";
              }
              sql = sql + " date BETWEEN '"+job.getDate_from()+"' AND '" + job.getDate_to()+"'";
              increment++;
          }
          if (job.getDesign_code() != null){
              if(increment > 0)
              { sql = sql + " AND";
              }
              sql = sql + " design_code= '"+job.getDesign_code()+"'";
              increment++;
          }
                  */
          if (job.getJob_id() != null){
              if(increment > 0)
              { sql = sql + " AND";
              }
              sql = sql + " job_order_id= '"+job.getJob_id()+"'";
              increment++;
          }
          
          System.out.println(sql);
          
          if (sql == "SELECT * FROM job_order WHERE")
          {
              System.out.print("nothing to be searched");
              return null;
          } else {
          
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            job_order results = new job_order();
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
          /*
          if (design.getColorway_name() != null){
              if(increment > 0)
              { sql = sql + " AND";
              }
              sql = sql + " colorway_name= '"+design.getColorway_name()+"'";
              increment++;
          }
          */
          
          System.out.println(sql);
          
          if (sql == "SELECT * FROM design WHERE")
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
}
