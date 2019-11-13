/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Solicitudes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author AJAV06
 */

@Local
public interface SolicitudesService {
    
    public List<Solicitudes> listarSolicitudes();
    
    public List<Solicitudes> listarSolicitudesActivos();
    
    public Solicitudes buscarSolicitudPorCodigo(Solicitudes solicitudes);
    
    public Solicitudes buscarSolicitudPorTipo(Solicitudes solicitudes);
    
    public void aceptarSolicitud(Solicitudes solicitudes);
    
    public void rechazarSolicitud(Solicitudes solicitudes);
}
