/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import domain.EstadoEquipo;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import services.EstadoEquipoService;

/**
 *
 * @author Scorpion
 */
@Named
@RequestScoped
public class EstadoEquipoBean {
    
    @Inject
    private EstadoEquipoService estadoEquipoService;
    
    private EstadoEquipo estadoEquipoSeleccionado;
    
    List<EstadoEquipo> estadosEquipos;
    
    public EstadoEquipoBean(){
    }
    
    @PostConstruct
    public void inicializar(){
        this.estadosEquipos = estadoEquipoService.listarEstadoEquiposActivas();
        this.estadoEquipoSeleccionado = new EstadoEquipo();
    }

    public EstadoEquipo getEstadoEquipoSeleccionado() {
        return estadoEquipoSeleccionado;
    }

    public void setEstadoEquipoSeleccionado(EstadoEquipo estadoEquipoSeleccionado) {
        this.estadoEquipoSeleccionado = estadoEquipoSeleccionado;
    }

    public List<EstadoEquipo> getEstadosEquipos() {
        return estadosEquipos;
    }

    public void setEstadosEquipos(List<EstadoEquipo> estadosEquipos) {
        this.estadosEquipos = estadosEquipos;
    }
    
}
