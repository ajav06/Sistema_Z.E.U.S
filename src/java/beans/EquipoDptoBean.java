/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import domain.EquipoDepartamento;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.util.Faces;
import services.EquipoDepartamentoService;

/**
 *
 * @author Cobos
 */
@Named
@RequestScoped
public class EquipoDptoBean {
    
    @Inject
    private EquipoDepartamentoService equipoDepartamentoService;
    
    List<EquipoDepartamento> equiposDpto;
        
    List<EquipoDepartamento> equiposDptoReparados;
    
    List<EquipoDepartamento> equiposDptoDesincorporado;
    
    public EquipoDptoBean(){
    }
    
    @PostConstruct
    public void inicializar(){
        equiposDpto = equipoDepartamentoService.listarEquipoDptoActivo();
        equiposDptoDesincorporado = equipoDepartamentoService.listarEquiposDesincorporados();
        equiposDptoReparados = equipoDepartamentoService.listarEquiposReparados();
    }

    public List<EquipoDepartamento> getEquiposDepartamento() {
        return equiposDpto;
    }

    public void setEquiposDepartamento(List<EquipoDepartamento> equipos) {
        this.equiposDpto = equipos;
    }

    public List<EquipoDepartamento> getEquiposDptoReparados() {
        return equiposDptoReparados;
    }

    public void setEquiposDptoReparados(List<EquipoDepartamento> equiposDptoReparados) {
        this.equiposDptoReparados = equiposDptoReparados;
    }

    public List<EquipoDepartamento> getEquiposDptoDesincorporado() {
        return equiposDptoDesincorporado;
    }

    public void setEquiposDptoDesincorporado(List<EquipoDepartamento> equiposDptoDesincorporado) {
        this.equiposDptoDesincorporado = equiposDptoDesincorporado;
    }
    
}
