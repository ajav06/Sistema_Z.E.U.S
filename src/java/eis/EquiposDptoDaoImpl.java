/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eis;

import java.util.List;
import javax.ejb.Stateless;

import domain.EquipoDepartamento;
import domain.Equipo;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Cobos
 */

@Stateless
public class EquiposDptoDaoImpl implements EquiposDptoDao{
    
    @PersistenceContext(unitName = "ZeusPU")
    private EntityManager em;
    

    @Override
    public List<EquipoDepartamento> findAllEquipoDpto() {
    return em.createNamedQuery("EquipoDepartamento.findAll").getResultList();
    }

    @Override
    public List<EquipoDepartamento> findAllActiveEquipoDpto() {
    return em.createNamedQuery("EquipoDepartamento.findAllActive").getResultList();
    }

    @Override
    public EquipoDepartamento findEquipoById(EquipoDepartamento equipoDpto) {
        Query query = em.createNamedQuery("EquipoDepartamento.findById");
        query.setParameter("codigo", equipoDpto.getCodigo());
        return (EquipoDepartamento) query.getSingleResult();
    }
    
    //@Override
    //public EquipoDepartamento findEquipoByName(Equipo equipo) {
       // Query query = em.createNamedQuery("EquipoDepartamento.findByName");
       // query.setParameter("nombre", equipo.getNombre());
      //  return (EquipoDepartamento) query.getSingleResult();
   // }

    @Override
    public void insertEquipoDpto(EquipoDepartamento equipoDpto) {
        em.persist(equipoDpto);
    }

    @Override
    public void updateEquipoDpto(EquipoDepartamento equipoDpto) {
        em.merge(equipoDpto);
    }

    @Override
    public void deleteEquipoDpto(EquipoDepartamento equipoDpto) {
        em.merge(equipoDpto);
        em.remove(equipoDpto);
    }
}
