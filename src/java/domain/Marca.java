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
@Table(name = "marca")
@NamedQueries({
    @NamedQuery(name = "Marca.findAll", query = "SELECT m FROM Marca m"),
    @NamedQuery(name = "Marca.findAllActive", query = "SELECT m FROM Marca m WHERE m.estatus = 'a' ORDER BY m.codigo ASC"),
    @NamedQuery(name = "Marca.findByCodigo", query = "SELECT m FROM Marca m WHERE m.codigo = :codigo AND m.estatus = 'a'"),
    @NamedQuery(name = "Marca.findByNombre", query = "SELECT m FROM Marca m WHERE m.nombre = :nombre AND m.estatus = 'a'"),
    @NamedQuery(name = "Marca.findByEstatus", query = "SELECT m FROM Marca m WHERE m.estatus = :estatus")})
@XmlRootElement
public class Marca implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "id_marca")
    @SequenceGenerator(name="id_marca", 
                       sequenceName = "marca_codigo_seq",
                       allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "estatus")
    private String estatus;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoMarca")
    private List<Equipo> equipoList;

    public Marca() {
    }

    public Marca(Integer codigo) {
        this.codigo = codigo;
    }

    public Marca(String nombre) {
        this.nombre = nombre;
    }
    
    public Marca(Integer codigo, String nombre, String estatus) {
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

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @XmlTransient
    public List<Equipo> getEquipoList() {
        return equipoList;
    }

    public void setEquipoList(List<Equipo> equipoList) {
        this.equipoList = equipoList;
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
        if (!(object instanceof Marca)) {
            return false;
        }
        Marca other = (Marca) object;
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
