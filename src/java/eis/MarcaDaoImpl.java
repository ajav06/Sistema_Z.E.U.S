/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eis;

import domain.Marca;
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
public class MarcaDaoImpl implements MarcaDao{
    
    @PersistenceContext(unitName = "ZeusPU")
    private EntityManager em;
    
    @Override
    public List<Marca> findAllMarcas() {
        return em.createNamedQuery("Marca.findAll").getResultList();
    }

    @Override
    public List<Marca> findAllActiveMarcas() {
        return em.createNamedQuery("Marca.findAllActive").getResultList();
    }

    @Override
    public Marca findMarcaById(Marca marca) {
        Query query = em.createNamedQuery("Marca.findByCodigo");
        query.setParameter("codigo", marca.getCodigo());
        return (Marca) query.getSingleResult();
    }

    @Override
    public Marca findMarcaByName(Marca marca) {
        Query query = em.createNamedQuery("Marca.findByNombre");
        query.setParameter("nombre", marca.getNombre());
        return (Marca) query.getSingleResult();
    }

    @Override
    public void insertMarca(Marca marca) {
        em.persist(marca);
    }

    @Override
    public void updateMarca(Marca marca) {
        em.merge(marca);
    }

    @Override
    public void deleteMarca(Marca marca) {
        em.merge(marca);
        em.remove(marca);
    }
    
}
