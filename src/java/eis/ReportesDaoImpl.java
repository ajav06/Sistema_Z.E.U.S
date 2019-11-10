/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eis;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import domain.Decanato;
import domain.Departamento;

/**
 *
 * @author gabriel
 */

@Stateless
public class ReportesDaoImpl implements ReportesDao{
    
    @PersistenceContext(unitName = "ZeusPU")
    private EntityManager em;
    
    @Override
    public Long totalActiveItems(){
        return (Long) em.createNamedQuery("EquipoDepartamento.totalActiveItems").getSingleResult();
    }
    
    @Override
    public Long totalRepairingItems(){
        return (Long) em.createNamedQuery("EquipoDepartamento.totalRepairingItems").getSingleResult();
    }
    
    @Override
    public Long totalDesincorporatedItems(){
        return (Long) em.createNamedQuery("EquipoDepartamento.totalDesincorporatedItems").getSingleResult();
    }
    
    //DECANATO
    @Override
    public Long totalActiveItemsDean(Decanato dec){
        Query query = em.createNamedQuery("EquipoDepartamento.totalActiveItemsDean");
        query.setParameter("decanato", dec.getCodigo());
        return (Long) query.getSingleResult();
    }
    
    @Override
    public Long totalRepairingItemsDean(Decanato dec){
        Query query = em.createNamedQuery("EquipoDepartamento.totalRepairingItemsDean");
        query.setParameter("decanato", dec.getCodigo());
        return (Long) query.getSingleResult();        
    }
    
    @Override
    public Long totalDesincorporatedItemsDean(Decanato dec){
        Query query = em.createNamedQuery("EquipoDepartamento.totalDesincorporatedItemsDean");
        query.setParameter("decanato", dec.getCodigo());
        return (Long) query.getSingleResult();        
    }
    
    @Override
    public Long totalActiveItemsDepartment(Departamento dep){
        Query query = em.createNamedQuery("EquipoDepartamento.totalActiveItemsDepartment");
        query.setParameter("departamento", dep.getCodigo());
        return (Long) query.getSingleResult();
    }
    
    @Override
    public Long totalReparingItemsDepartment(Departamento dep){
        Query query = em.createNamedQuery("EquipoDepartamento.totalRepairingItemsDepartment");
        query.setParameter("departamento", dep.getCodigo());
        return (Long) query.getSingleResult();
    }
    
    @Override
    public Long totalDesincorporatedItemsDepartment(Departamento dep){
        Query query = em.createNamedQuery("EquipoDepartamento.totalDesincorporatedItemsDepartment");
        query.setParameter("departamento", dep.getCodigo());
        return (Long) query.getSingleResult();
    }
}
