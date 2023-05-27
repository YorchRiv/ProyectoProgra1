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
@Table(name = "Aviones", catalog = "vehiculos", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Aviones.findAll", query = "SELECT a FROM Aviones a"),
    @NamedQuery(name = "Aviones.findByAvionesID", query = "SELECT a FROM Aviones a WHERE a.avionesID = :avionesID"),
    @NamedQuery(name = "Aviones.findByMarca", query = "SELECT a FROM Aviones a WHERE a.marca = :marca"),
    @NamedQuery(name = "Aviones.findByNombre", query = "SELECT a FROM Aviones a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Aviones.findByAnio", query = "SELECT a FROM Aviones a WHERE a.anio = :anio"),
    @NamedQuery(name = "Aviones.findByCantidadPasajeros", query = "SELECT a FROM Aviones a WHERE a.cantidadPasajeros = :cantidadPasajeros")})
public class Aviones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AvionesID", nullable = false)
    private Integer avionesID;
    @Column(name = "Marca", length = 100)
    private String marca;
    @Column(name = "Nombre", length = 200)
    private String nombre;
    @Column(name = "Anio")
    private Integer anio;
    @Column(name = "CantidadPasajeros")
    private Integer cantidadPasajeros;

    public Aviones() {
    }

    public Aviones(Integer avionesID) {
        this.avionesID = avionesID;
    }

    public Integer getAvionesID() {
        return avionesID;
    }

    public void setAvionesID(Integer avionesID) {
        this.avionesID = avionesID;
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

    public Integer getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(Integer cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (avionesID != null ? avionesID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aviones)) {
            return false;
        }
        Aviones other = (Aviones) object;
        if ((this.avionesID == null && other.avionesID != null) || (this.avionesID != null && !this.avionesID.equals(other.avionesID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectofinal.db.Aviones[ avionesID=" + avionesID + " ]";
    }
    
}
