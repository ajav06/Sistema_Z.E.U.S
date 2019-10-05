/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import domain.Decanato;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
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
    
    @EJB
    private DecanatoService decanatoService;
    
    List<Decanato> decanatos;
    
    public DecanatoBean() {
    }
    
    @PostConstruct
    public void inicializar() {
        decanatos = decanatoService.listarDecanatos();
    }

    public List<Decanato> getDecanatos() {
        return decanatos;
    }

    public void setDecanatos(List<Decanato> decanatos) {
        this.decanatos = decanatos;
    }
    
    
}
