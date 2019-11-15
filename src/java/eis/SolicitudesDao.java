/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eis;
import domain.Solicitudes;
import java.util.List;

/**
 *
 * @author gabriel
 */
public interface SolicitudesDao {
    
    public List<Solicitudes> findAllSolicitudes();
    
    public List<Solicitudes> listadoSolicitudes();
    
    public List<Solicitudes> listadoSolicitudesFiltradas(int mes, int anno);
    
    public List<Solicitudes> findAllActiveSolicitudes();
    
    public List<Solicitudes> findSolicitudesReparacion();
    
    public List<Solicitudes> findSolicitudesDesincorporado();
    
    public Solicitudes findSolicitudById(Solicitudes solicitudes);
    
    public Solicitudes findSolicitudByTipo(Solicitudes solicitudes);
    
    public void insertSolicitud(Solicitudes solicitudes);
    
    public void aceptSolicitud(Solicitudes solicitudes);
    
    public void refuseSolicitud(Solicitudes solicitudes);
    
}
