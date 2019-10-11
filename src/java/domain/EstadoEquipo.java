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

/**
 *
 * @author Scorpion
 */
@Entity
@Table(name = "estado_equipo")
@NamedQueries({
    @NamedQuery(name = "EstadoEquipo.findAll", query = "SELECT e FROM EstadoEquipo e"),
    @NamedQuery(name = "EstadoEquipo.findByCodigo", query = "SELECT e FROM EstadoEquipo e WHERE e.codigo = :codigo"),
    @NamedQuery(name = "EstadoEquipo.findByNombre", query = "SELECT e FROM EstadoEquipo e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EstadoEquipo.findByDescripcion", query = "SELECT e FROM EstadoEquipo e WHERE e.descripcion = :descripcion"),
    @NamedQuery(name = "EstadoEquipo.findByEstatus", query = "SELECT e FROM EstadoEquipo e WHERE e.estatus = :estatus")})
@XmlRootElement
public class EstadoEquipo implements Serializable {

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
    
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "estatus")
    private Character estatus;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoEstadoEquipo")
    private List<EquipoDepartamento> equipoDepartamentoList;

    public EstadoEquipo() {
    }

    public EstadoEquipo(Integer codigo) {
        this.codigo = codigo;
    }

    public EstadoEquipo(Integer codigo, String nombre, Character estatus) {
        this.codigo = codigo;
        this.nombre = nombre;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getEstatus() {
        return estatus;
    }

    public void setEstatus(Character estatus) {
        this.estatus = estatus;
    }

    public List<EquipoDepartamento> getEquipoDepartamentoList() {
        return equipoDepartamentoList;
    }

    public void setEquipoDepartamentoList(List<EquipoDepartamento> equipoDepartamentoList) {
        this.equipoDepartamentoList = equipoDepartamentoList;
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
        if (!(object instanceof EstadoEquipo)) {
            return false;
        }
        EstadoEquipo other = (EstadoEquipo) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.EstadoEquipo[ codigo=" + codigo + " ]";
    }
    
}
