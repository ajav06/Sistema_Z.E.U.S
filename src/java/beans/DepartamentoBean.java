/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import domain.Departamento;
import services.DepartamentoService;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


/**
 *
 * @author Scorpion
 */

@Named
@RequestScoped
public class DepartamentoBean {
    
    @Inject
    private DepartamentoService departamentoService;
    
    private Departamento departamentoSeleccionado;
    
    List<Departamento> departamentos;
    
    public DepartamentoBean(){
    }
    
    @PostConstruct
    public void inicializar(){
        this.departamentos = departamentoService.listarDepartamentosActivos();
        this.departamentoSeleccionado = new Departamento();
    }

    public Departamento getDepartamentoSeleccionado() {
        return departamentoSeleccionado;
    }

    public void setDepartamentoSeleccionado(Departamento departamentoSeleccionado) {
        this.departamentoSeleccionado = departamentoSeleccionado;
    }

    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<Departamento> departamentos) {
        this.departamentos = departamentos;
    }
    
    public List<Departamento> buscarDepartamentosPorDca(int cod){
        return this.departamentoService.listarDepartamentosPorDecanatos(cod);
    }
}
