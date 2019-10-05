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
@Table(name = "decanato")
@NamedQueries({
    @NamedQuery(name = "Decanato.findAll", query = "SELECT d FROM Decanato d"),
    @NamedQuery(name = "Decanato.findAllActive", query = "SELECT d FROM Decanato d WHERE d.estatus = 'a'"),
    @NamedQuery(name = "Decanato.findById", query = "SELECT d FROM Decanato d WHERE d.estatus = 'a' and d.idDecanato = :idDecanato"),
    @NamedQuery(name = "Decanato.findByName", query = "SELECT d FROM Decanato d WHERE d.estatus = 'a' and d.nombre = :nombre"),
})
public class Decanato implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "codigo")
    private Integer idDecanato;
    
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre", unique = true, nullable = true)
    private String nombre;
    
    @NotNull
    @Column(name = "siglas", unique = true)
    private String siglas;
    
    @Size(max = 100)
    @Column(name = "direccion")
    private String direccion;
    
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "correo")
    private String correo;
    
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "telefono")
    private Integer telefono;
    
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estatus", columnDefinition = "character default 'a'")
    private Character estatus;

    public Decanato() {
    }
    
    public Decanato(Integer idDecanato, String nombre, String siglas, String direccion, String correo, Integer telefono, Character estatus) {
        this.idDecanato = idDecanato;
        this.nombre = nombre;
        this.siglas = siglas;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.estatus = estatus;
    }

    public Decanato(String nombre, String siglas, String direccion, String correo, Integer telefono) {
        this.nombre = nombre;
        this.siglas = siglas;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Decanato(Integer idDecanato, String nombre, String siglas, String correo, Integer telefono) {
        this.idDecanato = idDecanato;
        this.nombre = nombre;
        this.siglas = siglas;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Decanato(String nombre, String siglas, String correo, Integer telefono) {
        this.nombre = nombre;
        this.siglas = siglas;
        this.correo = correo;
        this.telefono = telefono;
    }
    
    public Integer getIdDecanato() {
        return idDecanato;
    }

    public void setIdDecanato(Integer idDecanato) {
        this.idDecanato = idDecanato;
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

    public Character getEstatus() {
        return estatus;
    }

    public void setEstatus(Character estatus) {
        this.estatus = estatus;
    }
  
    @Override
    public String toString() {
        return "Decanato{" + "idDecanato=" + idDecanato + ", nombre=" + nombre + ", siglas=" + siglas + ", direccion=" + direccion + ", correo=" + correo + ", telefono=" + telefono + ", estatus=" + estatus + '}';
    }
}