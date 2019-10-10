/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Equipo;
import eis.EquipoDao;
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
public class EquipoServiceImpl implements EquipoService{
    
    @Resource
    private SessionContext contexto;
    
    @EJB
    EquipoDao equipoDao;

    @Override
    public List<Equipo> listarEquipos() {
        return equipoDao.findAllEquipos();
    }

    @Override
    public List<Equipo> listarEquiposActivos() {
        return equipoDao.findAllActiveEquipos();
    }

    @Override
    public Equipo buscarEquipoPorCodigo(Equipo equipo) {
        return equipoDao.findEquipoById(equipo);
    }

    @Override
    public Equipo buscarEquipoPorNombre(Equipo equipo) {
        return equipoDao.findEquipoByName(equipo);
    }

    @Override
    public void registrarEquipo(Equipo equipo) {
        equipoDao.insertEquipo(equipo);
    }

    @Override
    public void actualizarEquipo(Equipo equipo) {
        try {
            equipoDao.updateEquipo(equipo);
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarEquipo(Equipo equipo) {
        equipoDao.deleteEquipo(equipo);
    }
    
}
