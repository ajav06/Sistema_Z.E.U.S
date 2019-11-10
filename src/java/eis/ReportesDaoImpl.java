/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eis;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
