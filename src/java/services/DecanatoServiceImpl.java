/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;

import domain.Decanato;
import eis.DecanatoDao;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author AJAV06
 */

@Stateless
public class DecanatoServiceImpl implements DecanatoService{
    
    @Resource
    private SessionContext contexto;
    
    @EJB
    private DecanatoDao decanatoDao;

    @Override
    public List<Decanato> listarDecanatos() {
        return decanatoDao.findAllDecanatos();
    }

    @Override
    public List<Decanato> listarDecanatosActivos() {
        return decanatoDao.findAllActiveDecanatos();
    }

    @Override
    public Decanato buscarDecanatoPorCodigo(Decanato decanato) {
        return decanatoDao.findDecanatoById(decanato);
    }

    @Override
    public Decanato buscarDecanatoPorSiglas(Decanato decanato) {
        return decanatoDao.findDecanatoBySiglas(decanato);
    }

    @Override
    public void registrarDecanato(Decanato decanato) {
        decanatoDao.insertDecanato(decanato);
    }

    @Override
    public void actualizarDecanato(Decanato decanato) {
        try {
            decanatoDao.updateDecanato(decanato);
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarDecanato(Decanato decanato) {
        decanatoDao.deleteDecanato(decanato);
    }
    
}
