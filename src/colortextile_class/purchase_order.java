/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colortextile_class;

/**
 *
 * @author Eldridge
 */
public class purchase_order {
    private int id_purchase;
    private String date;
    private String design_code;
    
    /**
     * @return the id_purchase
     */
    public int getId_purchase() {
        return id_purchase;
    }

    /**
     * @param id_purchase the id_purchase to set
     */
    public void setId_purchase(int id_purchase) {
        this.id_purchase = id_purchase;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the design_code
     */
    public String getDesign_code() {
        return design_code;
    }

    /**
     * @param design_code the design_code to set
     */
    public void setDesign_code(String design_code) {
        this.design_code = design_code;
    }
}
