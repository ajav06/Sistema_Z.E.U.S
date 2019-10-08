/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import domain.Marca;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import services.MarcaService;

/**
 *
 * @author Scorpion
 */

@Named
@RequestScoped
public class MarcaBean {
    
    @EJB
    private MarcaService marcaService;
    
    private Marca marcaSeleccionada;
    
    List<Marca> marcas;

    public MarcaBean() {
    }
    
    @PostConstruct
    public void inicializar() {
        marcas = marcaService.listarMarcasActivas();
        marcaSeleccionada = new Marca();
    }

    public Marca getMarcaSeleccionada() {
        return marcaSeleccionada;
    }

    public void setMarcaSeleccionada(Marca marcaSeleccionada) {
        this.marcaSeleccionada = marcaSeleccionada;
    }

    public List<Marca> getMarcas() {
        return marcas;
    }

    public void setMarcas(List<Marca> marcas) {
        this.marcas = marcas;
    }
    
    public void reiniciarMarcaSeleccionada(){
        this.marcaSeleccionada = new Marca();
    }
    
    public void agregarMarca() {
        marcaService.registrarMarca(marcaSeleccionada);
        this.marcaSeleccionada = null;
    }
    
    public void modificarMarca() {
        marcaService.actualizarMarca(marcaSeleccionada);
        this.marcaSeleccionada = null;
    }
    
    public void eliminarMarca() {
        marcaService.eliminarMarca(marcaSeleccionada);
        this.marcaSeleccionada = null;
    }
}
