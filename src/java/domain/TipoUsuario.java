/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author AJAV06
 */

@Entity
@Table(name = "tipo_usuario")
@NamedQueries({
    @NamedQuery(name = "TipoUsuario.findAll", query = "SELECT tu FROM TipoUsuario tu"),
    @NamedQuery(name = "TipoUsuario.findAllActive", query = "SELECT tu FROM TipoUsuario tu WHERE tu.estatus = 'a'"),
    @NamedQuery(name = "TipoUsuario.findById", query = "SELECT tu FROM TipoUsuario tu WHERE tu.estatus = 'a' AND tu.idTipoUsuario = :idTipoUsuario"),
    @NamedQuery(name = "TipoUsuario.findByName", query = "SELECT tu FROM TipoUsuario tu WHERE tu.estatus = 'a' AND tu.nombre = :nombre"),
})
public class TipoUsuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "codigo")
    private Integer idTipoUsuario;
    
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre", unique = true)
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estatus", columnDefinition = "character default 'a'")
    private Character estatus;

    public TipoUsuario() {
    }

    public TipoUsuario(String nombre, Character estatus) {
        this.nombre = nombre;
        this.estatus = estatus;
    }

    public TipoUsuario(Integer idTipoUsuario, String nombre, Character estatus) {
        this.idTipoUsuario = idTipoUsuario;
        this.nombre = nombre;
        this.estatus = estatus;
    }

    public Integer getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public void setIdTipoUsuario(Integer idTipoUsuario) {
        this.idTipoUsuario = idTipoUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Character getEstatus() {
        return estatus;
    }

    public void setEstatus(Character estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "TipoUsuario{" + "idTipoUsuario=" + idTipoUsuario + ", nombre=" + nombre + ", estatus=" + estatus + '}';
    }    
}
