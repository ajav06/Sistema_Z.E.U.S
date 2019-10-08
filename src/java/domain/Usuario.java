/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author AJAV06
 */

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "nombre_usuario")
    private String nombreUsuario;
    
    @NotNull
    @Size(min = 1)
    @Column(name = "contrasenna")
    private String password;
     
    @JoinColumn(name = "codigo_departamento", referencedColumnName = "codigo")
    @ManyToOne(cascade = CascadeType.ALL)
    private Departamento departamento;
    
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "cedula", unique = true)
    private String cedula;
    
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apellido")
    private String apellido;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "telefono", unique = true)
    private Integer telefono;
    
    @Column(name = "correo", unique = true)
    private String correo;
    
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "estatus", columnDefinition = "character default 'a'")
    private Character estatus;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String password,Departamento departamento, String cedula, String nombre, String apellido, String direccion, Integer telefono, String correo) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.departamento = departamento;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Usuario(String nombreUsuario, String password, Departamento departamento, String cedula, String nombre, String apellido, String direccion, Integer telefono, String correo, Character estatus) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.departamento = departamento;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.estatus = estatus;
    }

    public Usuario(String nombreUsuario, String password, Departamento departamento, String cedula, String nombre, String apellido) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.departamento = departamento;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Character getEstatus() {
        return estatus;
    }

    public void setEstatus(Character estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombreUsuario=" + nombreUsuario + ", password=" + password + ", departamento=" + departamento + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", telefono=" + telefono + ", correo=" + correo + ", estatus=" + estatus + '}';
    }
    
    /**
    * Invalida la Sesión y redigiré a la página de inicio
    */
   public void logout() {
     ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
     ec.invalidateSession();
     try {
       ec.redirect(ec.getRequestContextPath());
     } catch (IOException ex) {
       Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
     }
   }
}
