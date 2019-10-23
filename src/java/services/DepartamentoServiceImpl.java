/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Departamento;
import eis.DepartamentoDao;
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
public class DepartamentoServiceImpl implements DepartamentoService{
    
    @Resource
    private SessionContext contexto;
    
    @EJB
    private DepartamentoDao departamentoDao;

    @Override
    public List<Departamento> listarDepartamentos() {
        return departamentoDao.findAllDepartamentos();
    }

    @Override
    public List<Departamento> listarDepartamentosActivos() {
        return departamentoDao.findAllActiveDepartamentos();
    }

    @Override
    public Departamento buscarDepartamentoPorCodigo(Departamento departamento) {
        return departamentoDao.findDepartamentoById(departamento);
    }

    @Override
    public void registrarDepartamento(Departamento departamento) {
        departamentoDao.insertDepartamento(departamento);
    }

    @Override
    public void actualizarDepartamento(Departamento departamento) {
        try {
            departamentoDao.updateDepartamento(departamento);
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarDepartamento(Departamento departamento) {
        departamentoDao.deleteDepartamento(departamento);
    }

    @Override
    public List<Departamento> listarDepartamentosPorDecanatos(int id) {
        return departamentoDao.findAllDepartamentosDecanatos(id);
    }
    
}
