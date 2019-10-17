/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Scorpion
 */
@Entity
@Table(name = "decanato")
@NamedQueries({
    @NamedQuery(name = "Decanato.findAll", query = "SELECT d FROM Decanato d"),
    @NamedQuery(name = "Decanato.findAllActive", query = "SELECT d FROM Decanato d WHERE d.estatus = 'a' ORDER BY d.codigo ASC"),
    @NamedQuery(name = "Decanato.findByCodigo", query = "SELECT d FROM Decanato d WHERE d.codigo = :codigo AND d.estatus = 'a'"),
    @NamedQuery(name = "Decanato.findByNombre", query = "SELECT d FROM Decanato d WHERE d.nombre = :nombre AND d.estatus = 'a'"),
    @NamedQuery(name = "Decanato.findBySiglas", query = "SELECT d FROM Decanato d WHERE d.siglas = :siglas AND d.estatus = 'a'"),
    @NamedQuery(name = "Decanato.findByDireccion", query = "SELECT d FROM Decanato d WHERE d.direccion = :direccion AND d.estatus = 'a'"),
    @NamedQuery(name = "Decanato.findByCorreo", query = "SELECT d FROM Decanato d WHERE d.correo = :correo AND d.estatus = 'a'"),
    @NamedQuery(name = "Decanato.findByTelefono", query = "SELECT d FROM Decanato d WHERE d.telefono = :telefono AND d.estatus = 'a'"),
    @NamedQuery(name = "Decanato.findByEstatus", query = "SELECT d FROM Decanato d WHERE d.estatus = :estatus")})
@XmlRootElement
public class Decanato implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre")
    private String nombre;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "siglas")
    private String siglas;
    
    @Size(max = 2147483647)
    @Column(name = "direccion")
    private String direccion;
    
    @Size(max = 50)
    @Column(name = "correo")
    private String correo;
    
    @Column(name = "telefono")
    private Integer telefono;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "estatus")
    private String estatus;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoDecanato")
    private List<Departamento> departamentoList;

    public Decanato() {
    }

    public Decanato(Integer codigo) {
        this.codigo = codigo;
    }

    public Decanato(Integer codigo, String nombre, String siglas, String estatus) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.siglas = siglas;
        this.estatus = estatus;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @XmlTransient
    public List<Departamento> getDepartamentoList() {
        return departamentoList;
    }

    public void setDepartamentoList(List<Departamento> departamentoList) {
        this.departamentoList = departamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Decanato)) {
            return false;
        }
        Decanato other = (Decanato) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
