/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author AJAV06
 */

@Entity
@Table(name = "grupo_usuario")
@NamedQueries({
    @NamedQuery(name = "GrupoUsuario.findAll", query = "SELECT gu FROM GrupoUsuario gu"),
    @NamedQuery(name = "GrupoUsuario.findByType", query = "SELECT gu FROM GrupoUsuario gu WHERE gu.tipoUsuario.idTipoUsuario = :tipoUsuario"),
    @NamedQuery(name = "GrupoUsuario.findByName", query = "SELECT gu FROM GrupoUsuario gu WHERE gu.Usuario.nombreUsuario = :nombreUsuario"),
})
public class GrupoUsuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @JoinColumn(name = "nombre_usuario", referencedColumnName = "nombre_usuario")
    @ManyToOne(cascade = CascadeType.ALL)
    private Usuario Usuario;
    
    @JoinColumn(name = "codigo_tipo_usuario", referencedColumnName = "codigo")
    @ManyToOne(cascade = CascadeType.ALL)
    private TipoUsuario tipoUsuario;
    
    

    public GrupoUsuario() {
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public GrupoUsuario(Usuario Usuario, TipoUsuario tipoUsuario) {
        this.Usuario = Usuario;
        this.tipoUsuario = tipoUsuario;
    }
 
    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return "GrupoUsuario{" + "Usuario=" + Usuario + ", tipoUsuario=" + tipoUsuario + '}';
    }
 
}
