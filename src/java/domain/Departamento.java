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
import javax.persistence.SequenceGenerator;
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
@Table(name = "departamento")
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d"),
    @NamedQuery(name = "Departamento.findAllActive", query = "SELECT d FROM Departamento d WHERE d.estatus = 'a' ORDER BY d.codigo ASC"),
    @NamedQuery(name = "Departamento.findByCodigo", query = "SELECT d FROM Departamento d WHERE d.codigo = :codigo AND d.estatus = 'a'"),
    @NamedQuery(name = "Departamento.findByCodigoDca", query = "SELECT d FROM Departamento d WHERE d.codigoDecanato.codigo = :codigo AND d.estatus = 'a'"),
    @NamedQuery(name = "Departamento.findByNombre", query = "SELECT d FROM Departamento d WHERE d.nombre = :nombre AND d.estatus = 'a'"),
    @NamedQuery(name = "Departamento.findByDescripcion", query = "SELECT d FROM Departamento d WHERE d.descripcion = :descripcion AND d.estatus = 'a'"),
    @NamedQuery(name = "Departamento.findByEstatus", query = "SELECT d FROM Departamento d WHERE d.estatus = :estatus"),
    
    //PARA EL REPORTE DE MAYOR Y MENOR POR UNIVERSIDAD
    @NamedQuery(name = "Departamento.mostItems",
            query = "SELECT d.codigoDecanato, "
                    + "d.nombre, "
                    + "(SELECT COUNT(e.codigo) "
                        + "FROM EquipoDepartamento e "
                        + "WHERE d.codigo = e.codigoDepartamento.codigo "
                        + "AND e.codigoEstadoEquipo.codigo != 2) as cantidad "
                    + "FROM Departamento d "
                    + "WHERE d.estatus = 'a' "
                    + "ORDER BY cantidad DESC"),
    //PARA EL REPORTE DE MAYOR Y MENOR POR DECANATO
    @NamedQuery(name = "Departamento.mostItemsDean",
            query = "SELECT "
                    + "d.nombre, "
                    + "(SELECT COUNT(e.codigo) "
                        + "FROM EquipoDepartamento e "
                        + "WHERE d.codigo = e.codigoDepartamento.codigo "
                        + "AND e.codigoEstadoEquipo.codigo != 2 "
                        + ") as cantidad "
                    + "FROM Departamento d "
                    + "WHERE d.codigoDecanato.codigo = :decanato "
                    + "AND d.estatus = 'a' "
                    + "ORDER BY cantidad DESC")})
@XmlRootElement
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "id_departamento")
    @SequenceGenerator(name="id_departamento", 
                       sequenceName = "departamento_codigo_seq",
                       allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1)
    @Column(name = "nombre")
    private String nombre;
    
    @Size(max = 2147483647)
    @Column(name = "descripcion")
    private String descripcion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "estatus")
    private String estatus;
    
    @JoinColumn(name = "codigo_decanato", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
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

    public Departamento(Integer codigo, String nombre, String estatus) {
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

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Decanato getCodigoDecanato() {
        return codigoDecanato;
    }

    public void setCodigoDecanato(Decanato codigoDecanato) {
        this.codigoDecanato = codigoDecanato;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
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
