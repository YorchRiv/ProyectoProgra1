/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal.db;

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

/**
 *
 * @author Jorge Mejicanos
 */
@Entity
@Table(name = "Balsas", catalog = "vehiculos", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Balsas.findAll", query = "SELECT b FROM Balsas b"),
    @NamedQuery(name = "Balsas.findByBalsaID", query = "SELECT b FROM Balsas b WHERE b.balsaID = :balsaID"),
    @NamedQuery(name = "Balsas.findByMarca", query = "SELECT b FROM Balsas b WHERE b.marca = :marca"),
    @NamedQuery(name = "Balsas.findByNombre", query = "SELECT b FROM Balsas b WHERE b.nombre = :nombre"),
    @NamedQuery(name = "Balsas.findByAnio", query = "SELECT b FROM Balsas b WHERE b.anio = :anio"),
    @NamedQuery(name = "Balsas.findByTipoCombustible", query = "SELECT b FROM Balsas b WHERE b.tipoCombustible = :tipoCombustible")})
public class Balsas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BalsaID", nullable = false)
    private Integer balsaID;
    @Column(name = "Marca", length = 100)
    private String marca;
    @Column(name = "Nombre", length = 200)
    private String nombre;
    @Column(name = "Anio")
    private Integer anio;
    @Column(name = "TipoCombustible")
    private Integer tipoCombustible;

    public Balsas() {
    }

    public Balsas(Integer balsaID) {
        this.balsaID = balsaID;
    }

    public Integer getBalsaID() {
        return balsaID;
    }

    public void setBalsaID(Integer balsaID) {
        this.balsaID = balsaID;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(Integer tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (balsaID != null ? balsaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Balsas)) {
            return false;
        }
        Balsas other = (Balsas) object;
        if ((this.balsaID == null && other.balsaID != null) || (this.balsaID != null && !this.balsaID.equals(other.balsaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectofinal.db.Balsas[ balsaID=" + balsaID + " ]";
    }
    
}
