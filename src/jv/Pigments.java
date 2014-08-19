package jv;

import java.sql.*;
/**
 *
 * @author asakanaboy_00
 */
public class Pigments 
{
    ConnectToDB test = new ConnectToDB();
    
    private String pigment_name;
    private int id_pigment, stock, tingi;
      
    public int getId_pigment() 
    {
        return id_pigment;
    }

    public void setId_pigment(int id_pigment) 
    {
        this.id_pigment = id_pigment;
    }

    public String getPigment_name() 
    {
        return pigment_name;
    }

    public void setPigment_name(String pigment_name) 
    {
        this.pigment_name = pigment_name;
    }

    public int getStock() 
    {
        return stock;
    }

    public void setStock(int stock) 
    {
        this.stock = stock;
    }

    public int getTingi() 
    {
        return tingi;
    }

    public void setTingi(int tingi) 
    {
        this.tingi = tingi;
    }
    
    public void addPigment()
    {
        try
        {
            PreparedStatement st = test.connection.prepareStatement("INSERT INTO pigments (pigment_name,stock,tingi) VALUES ('"+pigment_name+"','"+stock+"','"+tingi+"')");       
            st.execute();
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public ResultSet updateTable()
    {
        try
        {
            PreparedStatement st2 = test.connection.prepareStatement("SELECT * FROM pigments");       
            ResultSet rs = st2.executeQuery("SELECT * FROM pigments");
            return rs;
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public ResultSet searchTable()
    {
        try
        {
            PreparedStatement st3 = test.connection.prepareStatement("SELECT * FROM pigments WHERE pigment_name LIKE '%"+pigment_name+"%'");
            ResultSet rs = st3.executeQuery("SELECT * FROM pigments WHERE pigment_name LIKE '%"+pigment_name+"%'");
            return rs;
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public ResultSet searchPigment()
    {
        try
        {
            PreparedStatement st3 = test.connection.prepareStatement("SELECT * FROM pigments WHERE pigment_name LIKE '%"+pigment_name+"%'");
            ResultSet rs = st3.executeQuery("SELECT * FROM pigments WHERE pigment_name = '"+pigment_name+"'");
            return rs;
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        return null;
    }
}
