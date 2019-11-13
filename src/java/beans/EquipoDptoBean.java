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
    
    public EquipoDptoBean(){
    }
    
    @PostConstruct
    public void inicializar(){
        equiposDpto = equipoDepartamentoService.listarEquipoDptoActivo();
    }

    public List<EquipoDepartamento> getEquiposDepartamento() {
        return equiposDpto;
    }

    public void setEquiposDepartamento(List<EquipoDepartamento> equipos) {
        this.equiposDpto = equipos;
    }
}
