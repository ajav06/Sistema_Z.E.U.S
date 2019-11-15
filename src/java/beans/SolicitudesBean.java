/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import domain.Solicitudes;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import services.SolicitudesService;
/**
 *
 * @author marielbax
 */
@Named
@RequestScoped
public class SolicitudesBean {
    @Inject
    private SolicitudesService solicitudesService;
    
    private Solicitudes solicitudesSeleccionadas;
    
    List<Solicitudes> solicitudes;
        
    List<Solicitudes> solicitudesReparados;
    
    List<Solicitudes> solicitudesDesincorporado;
    
    public SolicitudesBean() {
    }
    
    @PostConstruct
    public void inicializar() {
        solicitudes = solicitudesService.listarSolicitudesActivos();
        solicitudesDesincorporado = solicitudesService.listarSolicitudesDesincorporado();
        solicitudesReparados = solicitudesService.listarSolicitudesReparacion();
        solicitudesSeleccionadas = new Solicitudes();
    }

    public List<Solicitudes> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<Solicitudes> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public Solicitudes getSolicitudSeleccionada() {
        return solicitudesSeleccionadas;
    }

    public List<Solicitudes> getSolicitudesReparados() {
        return solicitudesReparados;
    }

    public void setSolicitudesReparados(List<Solicitudes> solicitudesReparados) {
        this.solicitudesReparados = solicitudesReparados;
    }

    public List<Solicitudes> getSolicitudesDesincorporado() {
        return solicitudesDesincorporado;
    }

    public void setSolicitudesDesincorporado(List<Solicitudes> solicitudesDesincorporado) {
        this.solicitudesDesincorporado = solicitudesDesincorporado;
    }

    public void setSolicitudSeleccionada(Solicitudes solicitudesSeleccionadas) {
        this.solicitudesSeleccionadas = solicitudesSeleccionadas;
    }
    
    public Solicitudes buscarSolicitud(int id){
        this.solicitudesSeleccionadas = this.solicitudesService.buscarSolicitudPorCodigo(new Solicitudes(id));
        return this.solicitudesSeleccionadas;
    }
    
    public void reiniciarSolicitudSeleccionado(){
        this.solicitudesSeleccionadas = new Solicitudes();
    }
    
    public void agregarSolicitud() {
        solicitudesService.registrarSolicitud(this.solicitudesSeleccionadas);
        this.solicitudesSeleccionadas = null;
    }
    
     public void aceptarSolicitud() {
        solicitudesService.aceptarSolicitud(this.solicitudesSeleccionadas);
        this.solicitudesSeleccionadas = null;
    }
     public void rechazarSolicitud() {
        solicitudesService.rechazarSolicitud(this.solicitudesSeleccionadas);
        this.solicitudesSeleccionadas = null;
    }
    
    
}
