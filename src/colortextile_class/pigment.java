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
public class pigment {
    private int pigment_id;
    private String pigment_name;
    private int tingi;
    private int stock;

    /**
     * @return the pigment_id
     */
    public int getPigment_id() {
        return pigment_id;
    }

    /**
     * @param pigment_id the pigment_id to set
     */
    public void setPigment_id(int pigment_id) {
        this.pigment_id = pigment_id;
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
    
    public void get_id_pigment_from_name()
    {
        DB_Manager newDbManager = new DB_Manager();
        pigment_id = newDbManager.get_id_pigment(pigment_name);
    }
    
    public ArrayList<String> get_all_pigment_name()
    {
        DB_Manager new_conn = new DB_Manager();
        return new_conn.get_all_pigment_name();
        
    }
    
    
    
}
