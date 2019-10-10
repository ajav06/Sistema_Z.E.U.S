/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import domain.Decanato;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import services.DecanatoService;

/**
 *
 * @author AJAV06
 */
@Named
@RequestScoped
public class DecanatoBean {
    
    @Inject
    private DecanatoService decanatoService;
    
    private Decanato decanatoSeleccionado;
    
    List<Decanato> decanatos;
    
    public DecanatoBean() {
    }
    
    @PostConstruct
    public void inicializar() {
        decanatos = decanatoService.listarDecanatosActivos();
        decanatoSeleccionado = new Decanato();
    }

    public List<Decanato> getDecanatos() {
        return decanatos;
    }

    public void setDecanatos(List<Decanato> decanatos) {
        this.decanatos = decanatos;
    }

    public Decanato getDecanatoSeleccionado() {
        return decanatoSeleccionado;
    }

    public void setDecanatoSeleccionado(Decanato decanatoSeleccionado) {
        this.decanatoSeleccionado = decanatoSeleccionado;
    }
    
    public void reiniciarDecanatoSeleccionado(){
        this.decanatoSeleccionado = new Decanato();
    }
    
    public void modificarDecanato() {
        decanatoService.actualizarDecanato(this.decanatoSeleccionado);
        this.decanatoSeleccionado = null;
    }
    
    public void agregarDecanato() {
        decanatoService.registrarDecanato(this.decanatoSeleccionado);
        this.decanatoSeleccionado = null;
    }
    
    public void eliminarDecanato() {
        decanatoService.eliminarDecanato(this.decanatoSeleccionado);
        this.decanatoSeleccionado = null;
    }
    
}
