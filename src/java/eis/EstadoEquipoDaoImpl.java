/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eis;

import domain.EstadoEquipo;
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
public class EstadoEquipoDaoImpl implements EstadoEquipoDao{
    
    @PersistenceContext(unitName = "ZeusPU")
    private EntityManager em;

    @Override
    public List<EstadoEquipo> findAllEstadoEquipos() {
        return em.createNamedQuery("EstadoEquipo.findAll").getResultList();
    }

    @Override
    public List<EstadoEquipo> findAllActiveEstadoEquipos() {
        return em.createNamedQuery("EstadoEquipo.findAllActive").getResultList();
    }

    @Override
    public EstadoEquipo findEstadoEquipoById(EstadoEquipo estadoEquipo) {
        Query query = em.createNamedQuery("EstadoEquipo.findByCodigo");
        query.setParameter("codigo", estadoEquipo.getCodigo());
        return (EstadoEquipo) query.getSingleResult();
    }

    @Override
    public void insertEstadoEquipo(EstadoEquipo estadoEquipo) {
        em.persist(estadoEquipo);
    }

    @Override
    public void updateEstadoEquipo(EstadoEquipo estadoEquipo) {
        em.merge(estadoEquipo);
    }

    @Override
    public void deleteEstadoEquipo(EstadoEquipo estadoEquipo) {
        em.merge(estadoEquipo);
        em.remove(estadoEquipo);
    }
    
}
