/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eis;

import java.util.List;
import javax.ejb.Stateless;

import domain.Decanato;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author AJAV06
 */

@Stateless
public class DecanatoDaoImpl implements DecanatoDao{
    
    @PersistenceContext(unitName = "ZeusPU")
    EntityManager em;

    @Override
    public List<Decanato> findAllDecanatos() {
        return em.createNamedQuery("Decanato.findAll").getResultList();
    }

    @Override
    public List<Decanato> findAllActiveDecanatos() {
        return em.createNamedQuery("Decanato.findAllActive").getResultList();
    }

    @Override
    public Decanato findDecanatoById(Decanato decanato) {
        Query query = em.createNamedQuery("Decanato.findByCodigo");
        query.setParameter("codigo", decanato.getCodigo());
        return (Decanato) query.getSingleResult();
    }

    @Override
    public Decanato findDecanatoByName(Decanato decanato) {
        Query query = em.createNamedQuery("Decanato.findByNombre");
        query.setParameter("nombre", decanato.getNombre());
        return (Decanato) query.getSingleResult();
    }

    @Override
    public void insertDecanato(Decanato decanato) {
        em.persist(decanato);
    }

    @Override
    public void updateDecanato(Decanato decanato) {
        em.merge(decanato);
    }

    @Override
    public void deleteDecanato(Decanato decanato) {
        em.merge(decanato);
        em.remove(decanato);
    }
    
}
