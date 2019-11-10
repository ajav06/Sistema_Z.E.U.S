/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import eis.ReportesDao;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

/**
 *
 * @author gabriel
 */
@Stateless
public class ReportesServiceImpl implements ReportesService{
    
    @Resource
    private SessionContext contexto;
    
    @EJB
    private ReportesDao reportesDao;
    
    @Override
    public Long totalEquiposUniversidad(){
        return reportesDao.totalActiveItems();
    }
    
    @Override
    public Long totalEquiposReparacionUniversidad(){
        return reportesDao.totalRepairingItems();
    }
    
    @Override
    public Long totalEquiposDesincorporadosUniversidad(){
        return reportesDao.totalDesincorporatedItems();
    }
}
