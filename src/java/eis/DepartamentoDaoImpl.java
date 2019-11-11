/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eis;

import domain.Departamento;
import domain.Decanato;
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
public class DepartamentoDaoImpl implements DepartamentoDao{
    
    @PersistenceContext(unitName = "ZeusPU")
    private EntityManager em;

    @Override
    public List<Departamento> findAllDepartamentos() {
        return em.createNamedQuery("Departamento.findAll").getResultList();
    }

    @Override
    public List<Departamento> findAllActiveDepartamentos() {
        return em.createNamedQuery("Departamento.findAllActive").getResultList();
    }

    @Override
    public Departamento findDepartamentoById(Departamento departamento) {
        Query query = em.createNamedQuery("Departamento.findByCodigo");
        query.setParameter("codigo", departamento.getCodigo());
        return (Departamento) query.getSingleResult();
    }
    
    @Override
    public void insertDepartamento(Departamento departamento) {
        em.persist(departamento);
    }

    @Override
    public void updateDepartamento(Departamento departamento) {
        em.merge(departamento);
    }

    @Override
    public void deleteDepartamento(Departamento departamento) {
        em.merge(departamento);
        em.remove(departamento);
    }

    @Override
    public List<Departamento> findAllDepartamentosDecanatos(int id) {
        Query query = em.createNamedQuery("Departamento.findByCodigoDca");
        query.setParameter("codigo", id);
        return query.getResultList();
    }
    
    @Override
    public List<?> mostItems(){
        return em.createNamedQuery("Departamento.mostItems").getResultList();
    }
    
    @Override
    public List<?> mostItemsDean(Decanato decanato){
        Query query = em.createNamedQuery("Departamento.mostItemsDean");
        query.setParameter("decanato", decanato.getCodigo());
        return query.getResultList();
    }
}
