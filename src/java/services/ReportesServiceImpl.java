/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import eis.ReportesDao;
import eis.DepartamentoDao;
import eis.SolicitudesDao;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import domain.Decanato;
import domain.Departamento;
import domain.Solicitudes;
import java.util.List;

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
    
    @EJB
    private DepartamentoDao departamentoDao;
    
    @EJB
    private SolicitudesDao solicitudesDao;
    
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
    
    //TOTALES DECANATO
    @Override
    public Long totalEquiposDecanato(Decanato dec){
        return reportesDao.totalActiveItemsDean(dec);
    }
    
    @Override
    public Long totalEquiposReparacionDecanato(Decanato dec){
        return reportesDao.totalRepairingItemsDean(dec);
    }
    
    @Override
    public Long totalEquiposDesincorporadosDecanato(Decanato dec){
        return reportesDao.totalDesincorporatedItemsDean(dec);
    }
    
    //TOTALES DEPARTAMENTO
    @Override
    public Long totalEquiposDepartamento(Departamento dep){
        return reportesDao.totalActiveItemsDepartment(dep);
    }
    
    @Override
    public Long totalEquiposReparacionDepartamento(Departamento dep){
        return reportesDao.totalReparingItemsDepartment(dep);
    }
    
    @Override
    public Long totalEquiposDesincorporadosDepartamento(Departamento dep){
        return reportesDao.totalDesincorporatedItemsDepartment(dep);
    }
    
    @Override
    public List<?> mayorEquiposUniversidad(){
        return departamentoDao.mostItems();
    }
    
    @Override
    public List<?> mayorEquiposDecanato(Decanato dec){
        return departamentoDao.mostItemsDean(dec);
    }
    
    @Override
    public List<Solicitudes> listadoSolicitudes(){
        return solicitudesDao.listadoSolicitudes();
    }
    
    @Override
    public List<Solicitudes> listadoSolicitudesFiltradas(int mes, int anno){
        return solicitudesDao.listadoSolicitudesFiltradas(mes, anno);
    }
}
