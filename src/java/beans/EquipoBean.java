/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import domain.Equipo;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.util.Faces;
import services.EquipoService;

/**
 *
 * @author Scorpion
 */

@Named
@RequestScoped
public class EquipoBean {
    
    @Inject
    private EquipoService equipoService;
    
    private Equipo equipoSeleccionado;
    
    List<Equipo> equipos;

    public EquipoBean() {
    }
    
    @PostConstruct
    public void inicializar(){
        equipos = equipoService.listarEquiposActivos();
        equipoSeleccionado = new Equipo();
    }

    public Equipo getEquipoSeleccionado() {
        return equipoSeleccionado;
    }

    public void setEquipoSeleccionado(Equipo equipoSeleccionado) {
        this.equipoSeleccionado = equipoSeleccionado;
    }
    
    public void vaciarEquipoSeleccionado() {
        this.equipoSeleccionado = null;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }
    
    public void reiniciarEquipoSeleccionado() {
        this.equipoSeleccionado = new Equipo();
    }
    
    public void actualizarListado(){
        this.equipos = equipoService.listarEquipos();
    }
    
    public void agregarEquipo(){
        this.equipoSeleccionado.setEstatus("a");
        equipoService.registrarEquipo(equipoSeleccionado);
        this.equipoSeleccionado = null;
        this.actualizarListado();
        // Faces.redirect("?faces-redirect=true/index.xhtml");
    }
    
    public void modificarEquipo() {
        equipoService.actualizarEquipo(equipoSeleccionado);
        this.equipoSeleccionado = null;
        this.actualizarListado();
    }
    
    public void eliminarEquipo() {
        equipoService.eliminarEquipo(equipoSeleccionado);
        this.equipoSeleccionado = null;
        this.actualizarListado();
    }
}
