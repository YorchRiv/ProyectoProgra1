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
@Table(name = "Carros", catalog = "vehiculos", schema = "dbo")
@NamedQueries({
    @NamedQuery(name = "Carros.findAll", query = "SELECT c FROM Carros c"),
    @NamedQuery(name = "Carros.findByCarroID", query = "SELECT c FROM Carros c WHERE c.carroID = :carroID"),
    @NamedQuery(name = "Carros.findByMarca", query = "SELECT c FROM Carros c WHERE c.marca = :marca"),
    @NamedQuery(name = "Carros.findByNombre", query = "SELECT c FROM Carros c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Carros.findByAnio", query = "SELECT c FROM Carros c WHERE c.anio = :anio"),
    @NamedQuery(name = "Carros.findByPlaca", query = "SELECT c FROM Carros c WHERE c.placa = :placa"),
    @NamedQuery(name = "Carros.findByTipoCombustible", query = "SELECT c FROM Carros c WHERE c.tipoCombustible = :tipoCombustible")})
public class Carros implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CarroID", nullable = false)
    private Integer carroID;
    @Column(name = "Marca", length = 100)
    private String marca;
    @Column(name = "Nombre", length = 200)
    private String nombre;
    @Column(name = "Anio")
    private Integer anio;
    @Column(name = "Placa", length = 100)
    private String placa;
    @Column(name = "TipoCombustible")
    private Integer tipoCombustible;

    public Carros() {
    }

    public Carros(Integer carroID) {
        this.carroID = carroID;
    }

    public Integer getCarroID() {
        return carroID;
    }

    public void setCarroID(Integer carroID) {
        this.carroID = carroID;
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

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
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
        hash += (carroID != null ? carroID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carros)) {
            return false;
        }
        Carros other = (Carros) object;
        if ((this.carroID == null && other.carroID != null) || (this.carroID != null && !this.carroID.equals(other.carroID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "proyectofinal.db.Carros[ carroID=" + carroID + " ]";
    }
    
}
