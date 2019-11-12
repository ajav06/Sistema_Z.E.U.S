/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import domain.Solicitudes;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import services.ReportesService;

/**
 *
 * @author gabriel
 */

@Named
@RequestScoped
public class ReportesBean {
    
    @Inject
    private ReportesService reportesService;
    
    List<Solicitudes> solicitudes;

    public ReportesBean() {
    }
    
    @PostConstruct
    public void inicializar() {
        solicitudes = reportesService.listadoSolicitudes();
    }

    public List <Solicitudes> listadoSolicitudesFiltradas(int mes, int anno){
        return reportesService.listadoSolicitudesFiltradas(mes, anno);
    }
}
