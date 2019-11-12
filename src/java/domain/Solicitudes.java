/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Scorpion
 */
@Entity
@Table(name = "solicitudes")
@NamedQueries({
    @NamedQuery(name = "Solicitudes.findAll", query = "SELECT s FROM Solicitudes s"),
    @NamedQuery(name = "Solicitudes.findByCodigo", query = "SELECT s FROM Solicitudes s WHERE s.codigo = :codigo"),
    @NamedQuery(name = "Solicitudes.findByTipoSolicitud", query = "SELECT s FROM Solicitudes s WHERE s.tipoSolicitud = :tipoSolicitud"),
    @NamedQuery(name = "Solicitudes.findByFechaInicio", query = "SELECT s FROM Solicitudes s WHERE s.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Solicitudes.findByFechaAtencion", query = "SELECT s FROM Solicitudes s WHERE s.fechaAtencion = :fechaAtencion"),
    @NamedQuery(name = "Solicitudes.findByFechaInicioInterval", query = "SELECT s FROM Solicitudes s WHERE s.fechaInicio BETWEEN :primeroMes AND :finMes")})
@XmlRootElement
public class Solicitudes implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "id_solicitud")
    @SequenceGenerator(name="id_solicitud", 
                       sequenceName = "solicitudes_codigo_seq",
                       allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "tipo_solicitud")
    private String tipoSolicitud;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    
    @Column(name = "fecha_atencion")
    private Integer fechaAtencion;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "estatus")
    private String estatus;
    
    @JoinColumn(name = "codigo_equipo_departamento", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private EquipoDepartamento codigoEquipoDepartamento;
    
    @JoinColumn(name = "nombre_usuario", referencedColumnName = "nombre_usuario")
    @ManyToOne(optional = false)
    private Usuario nombreUsuario;

    public Solicitudes() {
    }

    public Solicitudes(Integer codigo) {
        this.codigo = codigo;
    }

    public Solicitudes(Integer codigo, String tipoSolicitud, Date fechaInicio, String estatus) {
        this.codigo = codigo;
        this.tipoSolicitud = tipoSolicitud;
        this.fechaInicio = fechaInicio;
        this.estatus = estatus;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Integer getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(Integer fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public EquipoDepartamento getCodigoEquipoDepartamento() {
        return codigoEquipoDepartamento;
    }

    public void setCodigoEquipoDepartamento(EquipoDepartamento codigoEquipoDepartamento) {
        this.codigoEquipoDepartamento = codigoEquipoDepartamento;
    }

    public Usuario getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(Usuario nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
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
        if (!(object instanceof Solicitudes)) {
            return false;
        }
        Solicitudes other = (Solicitudes) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domain.Solicitudes[ codigo=" + codigo + " ]";
    }
    
    public String tipoSolicitudString(){
        String tipo;
        if (!"R".equals(this.tipoSolicitud)){
            tipo = "Desincorporación";
        } else {
            tipo = "Reparación";
        }
        return tipo;
    }
    
    public String fechaEmision(){
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return format.format(this.fechaInicio);
    }
    
    //public String fechaAtencionString(){
      //  String fecha;
        //if (this.fechaAtencion)
    //}    
}
