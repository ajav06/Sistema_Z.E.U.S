/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eis;

import domain.Equipo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Scorpion
 */

@Stateless
public class EquipoDaoImpl implements EquipoDao{
    
    @PersistenceContext(name = "ZeusBD")
    EntityManager em;

    @Override
    public List<Equipo> findAllEquipos() {
        return em.createNamedQuery("Equipo.findAll").getResultList();
    }

    @Override
    public List<Equipo> findAllActiveEquipos() {
        return em.createNamedQuery("Equipo.findAllActive").getResultList();
    }

    @Override
    public Equipo findEquipoById(Equipo equipo) {
        Query query = em.createNamedQuery("Equipo.findByCodigo");
        query.setParameter("codigo", equipo.getCodigo());
        return (Equipo) query.getSingleResult();
    }

    @Override
    public Equipo findEquipoByName(Equipo equipo) {
        Query query = em.createNamedQuery("Equipo.findByNombre");
        query.setParameter("nombre", equipo.getNombre());
        return (Equipo) query.getSingleResult();
    }

    @Override
    public void insertEquipo(Equipo equipo) {
        em.persist(equipo);
    }

    @Override
    public void updateEquipo(Equipo equipo) {
        em.merge(equipo);
    }

    @Override
    public void deleteEquipo(Equipo equipo) {
        em.merge(equipo);
        em.remove(equipo);
    }
    
}
