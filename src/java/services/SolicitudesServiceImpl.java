/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;

import domain.Solicitudes;
import eis.SolicitudesDao;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author AJAV06
 */

@Stateless
public class SolicitudesServiceImpl implements SolicitudesService{
    
    @Resource
    private SessionContext contexto;
    
    @EJB
    private SolicitudesDao solicitudesDao;

    @Override
    public List<Solicitudes> listarSolicitudes(){
        return solicitudesDao.findAllSolicitudes();
    }

    @Override
    public List<Solicitudes> listarSolicitudesActivos(){
        return solicitudesDao.findAllActiveSolicitudes();
    }

    @Override
    public Solicitudes buscarSolicitudPorCodigo(Solicitudes solicitudes){
        return solicitudesDao.findSolicitudById(solicitudes);
    }

    @Override
    public Solicitudes buscarSolicitudPorTipo(Solicitudes solicitudes){
        return solicitudesDao.findSolicitudByTipo(solicitudes);
    }
    
    @Override
     public void aceptarSolicitud(Solicitudes solicitudes) {
        try {
            solicitudesDao.aceptSolicitud(solicitudes);
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void rechazarSolicitud(Solicitudes solicitudes) {
         try {
            solicitudesDao.refuseSolicitud(solicitudes);
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }
    
}
