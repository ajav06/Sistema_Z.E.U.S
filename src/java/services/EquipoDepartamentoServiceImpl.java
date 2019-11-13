/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Equipo;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;

import domain.EquipoDepartamento;
import eis.EquiposDptoDao;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Cobos
 */
@Stateless
public class EquipoDepartamentoServiceImpl implements EquipoDepartamentoService{
    
    @Resource
    private SessionContext contexto;
    
    @EJB
    private EquiposDptoDao equiposDptoDao;

    @Override
    public List<EquipoDepartamento> listarEquipoDpto() {
        return equiposDptoDao.findAllEquipoDpto();
    }

    @Override
    public List<EquipoDepartamento> listarEquipoDptoActivo() {
        return equiposDptoDao.findAllActiveEquipoDpto();
    }

    @Override
    public EquipoDepartamento buscarEquipoPorCodigo(EquipoDepartamento equipoDpto) {
        return equiposDptoDao.findEquipoById(equipoDpto);
    }

    @Override
    public EquipoDepartamento buscarEquipoPorNombre(Equipo equipo) {
        return equiposDptoDao.findEquipoByName(equipo);
    }

    @Override
    public void regritrarEquipoDpto(EquipoDepartamento equipoDpto) {
        equiposDptoDao.insertEquipoDpto(equipoDpto);
    }

    @Override
    public void actualizarEquipoDpto(EquipoDepartamento equipoDpto) {
        try {
            equiposDptoDao.updateEquipoDpto(equipoDpto);
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarEquipoDpto(EquipoDepartamento equipoDpto) {
        equiposDptoDao.deleteEquipoDpto(equipoDpto);
    }
    
}
