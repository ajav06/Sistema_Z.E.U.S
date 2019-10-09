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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Scorpion
 */
@Entity
@Table(name = "departamento")
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d"),
    @NamedQuery(name = "Departamento.findByCodigo", query = "SELECT d FROM Departamento d WHERE d.codigo = :codigo"),
    @NamedQuery(name = "Departamento.findByNombre", query = "SELECT d FROM Departamento d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "Departamento.findByDescripcion", query = "SELECT d FROM Departamento d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "Departamento.findByEstatus", query = "SELECT d FROM Departamento d WHERE d.estatus = :estatus")})
public class Departamento implements Serializable {

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
    
    @JoinColumn(name = "codigo_decanato", referencedColumnName = "codigo")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private Decanato codigoDecanato;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoDepartamento")
    private List<Usuario> usuarioList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoDepartamento")
    private List<EquipoDepartamento> equipoDepartamentoList;

    public Departamento() {
    }

    public Departamento(Integer codigo) {
        this.codigo = codigo;
    }

    public Departamento(Integer codigo, String nombre, Character estatus) {
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

    public Decanato getCodigoDecanato() {
        return codigoDecanato;
    }

    public void setCodigoDecanato(Decanato codigoDecanato) {
        this.codigoDecanato = codigoDecanato;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
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
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Departamento[ codigo=" + codigo + " ]";
    }
    
}
