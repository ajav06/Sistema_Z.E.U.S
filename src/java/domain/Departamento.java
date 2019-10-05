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
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author AJAV06
 */

@Entity
@Table(name = "departamento")
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT d FROM Departamento d"),
    @NamedQuery(name = "Departamento.findAllActive", query = "SELECT d FROM Departamento d WHERE d.estatus = 'a'"),
    @NamedQuery(name = "Departamento.findById", query = "SELECT d FROM Departamento d WHERE d.estatus = 'a' and d.idDepartameto = :idDepartameto"),
    @NamedQuery(name = "Departamento.findByName", query = "SELECT d FROM Departamento d WHERE d.estatus = 'a' and d.nombre = :nombre "),
    @NamedQuery(name = "Departamento.findByDecanato", query = "SELECT d FROM Departamento d WHERE d.estatus = 'a' and d.decanato.idDecanato = :idDecanato "),
})
public class Departamento implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "codigo")
    private Integer idDepartameto;
    
    @NotNull
    @JoinColumn(name = "codigo_decanato", referencedColumnName = "codigo")
    @ManyToOne(cascade = CascadeType.ALL)
    private Decanato decanato;
    
    @NotNull
    @Size(max = 15)
    @Column(name = "nombre")
    private String nombre;
    
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estatus", columnDefinition = "character default 'a'")
    private Character estatus;

    public Departamento() {
    }

    public Departamento(Integer idDepartameto, Decanato decanato, String nombre, String descripcion, Character estatus) {
        this.idDepartameto = idDepartameto;
        this.decanato = decanato;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estatus = estatus;
    }

    public Departamento(Integer idDepartameto, Decanato decanato, String nombre, String descripcion) {
        this.idDepartameto = idDepartameto;
        this.decanato = decanato;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Departamento(Decanato decanato, String nombre, String descripcion, Character estatus) {
        this.decanato = decanato;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estatus = estatus;
    }

    public Departamento(Decanato decanato, String nombre) {
        this.decanato = decanato;
        this.nombre = nombre;
    }

    public Integer getIdDepartameto() {
        return idDepartameto;
    }

    public void setIdDepartameto(Integer idDepartameto) {
        this.idDepartameto = idDepartameto;
    }

    public Decanato getDecanato() {
        return decanato;
    }

    public void setDecanato(Decanato decanato) {
        this.decanato = decanato;
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

    @Override
    public String toString() {
        return "Departamento{" + "idDepartameto=" + idDepartameto + ", decanato=" + decanato + ", nombre=" + nombre + ", descripcion=" + descripcion + ", estatus=" + estatus + '}';
    }
}
