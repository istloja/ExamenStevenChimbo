/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Steven Chimbo
 */
@Entity
@Table(name = "provincias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Provincias.findAll", query = "SELECT p FROM Provincias p")
    , @NamedQuery(name = "Provincias.findByIdProvincias", query = "SELECT p FROM Provincias p WHERE p.idProvincias = :idProvincias")
    , @NamedQuery(name = "Provincias.findByNroCantones", query = "SELECT p FROM Provincias p WHERE p.nroCantones = :nroCantones")
    , @NamedQuery(name = "Provincias.findBySuperficie", query = "SELECT p FROM Provincias p WHERE p.superficie = :superficie")
    , @NamedQuery(name = "Provincias.findByRegion", query = "SELECT p FROM Provincias p WHERE p.region = :region")})
public class Provincias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProvincias")
    private Integer idProvincias;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nroCantones")
    private int nroCantones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "superficie")
    private double superficie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "region")
    private String region;
    @JoinColumn(name = "idProvincias", referencedColumnName = "idPais", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Pais pais;

    public Provincias() {
    }

    public Provincias(Integer idProvincias) {
        this.idProvincias = idProvincias;
    }

    public Provincias(Integer idProvincias, int nroCantones, double superficie, String region) {
        this.idProvincias = idProvincias;
        this.nroCantones = nroCantones;
        this.superficie = superficie;
        this.region = region;
    }

    public Integer getIdProvincias() {
        return idProvincias;
    }

    public void setIdProvincias(Integer idProvincias) {
        this.idProvincias = idProvincias;
    }

    public int getNroCantones() {
        return nroCantones;
    }

    public void setNroCantones(int nroCantones) {
        this.nroCantones = nroCantones;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProvincias != null ? idProvincias.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provincias)) {
            return false;
        }
        Provincias other = (Provincias) object;
        if ((this.idProvincias == null && other.idProvincias != null) || (this.idProvincias != null && !this.idProvincias.equals(other.idProvincias))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Provincias[ idProvincias=" + idProvincias + " ]";
    }
    
}
