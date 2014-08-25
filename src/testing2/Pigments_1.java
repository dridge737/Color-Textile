/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package testing2;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author asakanaboy_00
 */
@Entity
@Table(name = "pigments", catalog = "color_textile", schema = "")
@NamedQueries({
    @NamedQuery(name = "Pigments_1.findAll", query = "SELECT p FROM Pigments_1 p"),
    @NamedQuery(name = "Pigments_1.findByIdPigment", query = "SELECT p FROM Pigments_1 p WHERE p.idPigment = :idPigment"),
    @NamedQuery(name = "Pigments_1.findByPigmentName", query = "SELECT p FROM Pigments_1 p WHERE p.pigmentName = :pigmentName"),
    @NamedQuery(name = "Pigments_1.findByStock", query = "SELECT p FROM Pigments_1 p WHERE p.stock = :stock"),
    @NamedQuery(name = "Pigments_1.findByTingi", query = "SELECT p FROM Pigments_1 p WHERE p.tingi = :tingi")})
public class Pigments_1 implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pigment")
    private Integer idPigment;
    @Basic(optional = false)
    @Column(name = "pigment_name")
    private String pigmentName;
    @Basic(optional = false)
    @Column(name = "stock")
    private int stock;
    @Basic(optional = false)
    @Column(name = "tingi")
    private int tingi;

    public Pigments_1() {
    }

    public Pigments_1(Integer idPigment) {
        this.idPigment = idPigment;
    }

    public Pigments_1(Integer idPigment, String pigmentName, int stock, int tingi) {
        this.idPigment = idPigment;
        this.pigmentName = pigmentName;
        this.stock = stock;
        this.tingi = tingi;
    }

    public Integer getIdPigment() {
        return idPigment;
    }

    public void setIdPigment(Integer idPigment) {
        Integer oldIdPigment = this.idPigment;
        this.idPigment = idPigment;
        changeSupport.firePropertyChange("idPigment", oldIdPigment, idPigment);
    }

    public String getPigmentName() {
        return pigmentName;
    }

    public void setPigmentName(String pigmentName) {
        String oldPigmentName = this.pigmentName;
        this.pigmentName = pigmentName;
        changeSupport.firePropertyChange("pigmentName", oldPigmentName, pigmentName);
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        int oldStock = this.stock;
        this.stock = stock;
        changeSupport.firePropertyChange("stock", oldStock, stock);
    }

    public int getTingi() {
        return tingi;
    }

    public void setTingi(int tingi) {
        int oldTingi = this.tingi;
        this.tingi = tingi;
        changeSupport.firePropertyChange("tingi", oldTingi, tingi);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPigment != null ? idPigment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pigments_1)) {
            return false;
        }
        Pigments_1 other = (Pigments_1) object;
        if ((this.idPigment == null && other.idPigment != null) || (this.idPigment != null && !this.idPigment.equals(other.idPigment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Testing2.Pigments_1[ idPigment=" + idPigment + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
