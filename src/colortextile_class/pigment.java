/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package colortextile_class;
import Database.DB_Manager;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author Eldridge
 */
public class pigment implements Comparable<pigment>{
    private int pigment_no;
    private String pigment_name;
    private int tingi;
    private int stock;

    /**
     * @return the pigment_id
     */
    public int getPigment_no() {
        return pigment_no;
    }

    /**
     * @param pigment_id the pigment_id to set
     */
    public void setPigment_no(int pigment_id) {
        this.pigment_no = pigment_id;
    }

    /**
     * @return the pigment_name
     */
    public String getPigment_name() {
        return pigment_name;
    }

    /**
     * @param pigment_name the pigment_name to set
     */
    public void setPigment_name(String pigment_name) {
        this.pigment_name = pigment_name;
    }

    /**
     * @return the tingi
     */
    public int getTingi() {
        return tingi;
    }

    /**
     * @param tingi the tingi to set
     */
    public void setTingi(int tingi) {
        this.tingi = tingi;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    public void set_pigment_id_from_name()
    {
        DB_Manager newDbManager = new DB_Manager();
        pigment_no = newDbManager.get_id_pigment(this.pigment_name);
    }
    
    public ArrayList<String> get_all_pigment_name()
    {
        DB_Manager new_conn = new DB_Manager();
        return new_conn.get_all_pigment_name();
    }
    
    public void get_pigment_name_from_id()
    {
        DB_Manager newDbManager = new DB_Manager();
        pigment_name = newDbManager.get_pigment_name(pigment_no); 
    }
    
    public boolean add_pigment()
    {
        DB_Manager new_conn = new DB_Manager();
        if(!check_pigment_exists())
            return new_conn.add_pigment(this);
        
        return false;
        
    }
    
    public boolean check_pigment_exists()
    {
        DB_Manager new_conn = new DB_Manager();
        if(new_conn.check_if_pigment_exists(this) == 0)
            return false;
        
        return true;
    }
    
    @Override
    public int compareTo(pigment o) {
        int compareTo = this.getPigment_name().compareTo(o.getPigment_name());
        return compareTo;
        
    }
    
    public int count_all_pigment()
    {
        DB_Manager new_conn = new DB_Manager();
        int total = new_conn.count_number_of_pigment();
        return total;
    }
    
    
    
    
    
}
