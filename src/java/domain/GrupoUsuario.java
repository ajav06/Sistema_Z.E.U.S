/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Scorpion
 */
@Entity
@Table(name = "grupo_usuario")
@NamedQueries({
    @NamedQuery(name = "GrupoUsuario.findAll", query = "SELECT g FROM GrupoUsuario g"),
    @NamedQuery(name = "GrupoUsuario.findByNombreUsuario", query = "SELECT g FROM GrupoUsuario g WHERE g.nombreUsuario = :nombreUsuario"),
    @NamedQuery(name = "GrupoUsuario.findByFechaModificacion", query = "SELECT g FROM GrupoUsuario g WHERE g.fechaModificacion = :fechaModificacion")})
public class GrupoUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;
    
    @JoinColumn(name = "codigo_tipo_usuario", referencedColumnName = "codigo")
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    private TipoUsuario codigoTipoUsuario;
    
    @JoinColumn(name = "nombre_usuario", referencedColumnName = "nombre_usuario", insertable = false, updatable = false)
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    private Usuario usuario;

    public GrupoUsuario() {
    }

    public GrupoUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public GrupoUsuario(String nombreUsuario, Date fechaModificacion) {
        this.nombreUsuario = nombreUsuario;
        this.fechaModificacion = fechaModificacion;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public TipoUsuario getCodigoTipoUsuario() {
        return codigoTipoUsuario;
    }

    public void setCodigoTipoUsuario(TipoUsuario codigoTipoUsuario) {
        this.codigoTipoUsuario = codigoTipoUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nombreUsuario != null ? nombreUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrupoUsuario)) {
            return false;
        }
        GrupoUsuario other = (GrupoUsuario) object;
        if ((this.nombreUsuario == null && other.nombreUsuario != null) || (this.nombreUsuario != null && !this.nombreUsuario.equals(other.nombreUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.GrupoUsuario[ nombreUsuario=" + nombreUsuario + " ]";
    }
    
}
