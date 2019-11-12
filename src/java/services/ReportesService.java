/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.ejb.Local;
import java.util.List;
import domain.Decanato;
import domain.Departamento;
import domain.Solicitudes;

/**
 *
 * @author gabriel
 */
@Local
public interface ReportesService {
    
    //TOTALES UNIVERSIDAD
    public Long totalEquiposUniversidad();
    public Long totalEquiposReparacionUniversidad();
    public Long totalEquiposDesincorporadosUniversidad();
    
    //TOTALES DECANATO
    public Long totalEquiposDecanato(Decanato dec);
    public Long totalEquiposReparacionDecanato(Decanato dec);
    public Long totalEquiposDesincorporadosDecanato(Decanato dec);
    
    //TOTALES DEPARTAMENTO
    public Long totalEquiposDepartamento(Departamento dep);
    public Long totalEquiposReparacionDepartamento(Departamento dep);
    public Long totalEquiposDesincorporadosDepartamento(Departamento dep);
 
    //DEPARTAMENTOS MAYOR Y MENOR GLOBAL (UNIVERSIDAD)
    public List<?> mayorEquiposUniversidad();
    public List<?> mayorEquiposDecanato(Decanato dec);
    
    //REPORTE DE SOLICITUDES
    public List<Solicitudes> listadoSolicitudes();
    public List<Solicitudes> listadoSolicitudesFiltradas(int mes, int anno);
}
