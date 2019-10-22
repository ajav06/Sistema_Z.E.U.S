/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.EstadoEquipo;
import eis.EstadoEquipoDao;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

/**
 *
 * @author Scorpion
 */

@Stateless
public class EstadoEquipoServiceImpl implements EstadoEquipoService{
    
    @Resource
    private SessionContext contexto;
    
    @EJB
    private EstadoEquipoDao estadoEquipoDao;
    
    @Override
    public List<EstadoEquipo> listarEstadoEquipos() {
        return estadoEquipoDao.findAllEstadoEquipos();
    }

    @Override
    public List<EstadoEquipo> listarEstadoEquiposActivas() {
        return estadoEquipoDao.findAllActiveEstadoEquipos();
    }

    @Override
    public EstadoEquipo buscarEstadoEquipoPorCodigo(EstadoEquipo estadoEquipo) {
        return estadoEquipoDao.findEstadoEquipoById(estadoEquipo);
    }

    @Override
    public void registrarEstadoEquipo(EstadoEquipo estadoEquipo) {
        estadoEquipoDao.insertEstadoEquipo(estadoEquipo);
    }

    @Override
    public void actualizarEstadoEquipo(EstadoEquipo estadoEquipo) {
        try {
            estadoEquipoDao.updateEstadoEquipo(estadoEquipo);
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarEstadoEquipo(EstadoEquipo estadoEquipo) {
        estadoEquipoDao.deleteEstadoEquipo(estadoEquipo);
    }
    
}
