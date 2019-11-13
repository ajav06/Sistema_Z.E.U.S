/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eis;

import domain.GrupoUsuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Maria
 */
@Stateless
public class GrupoUsuarioDaoImpl implements GrupoUsuarioDao{
    @PersistenceContext(unitName = "ZeusPU")
    private EntityManager em;

    @Override
    public List<GrupoUsuario> findAllGrupoUsuario() {
        return em.createNamedQuery("GrupoUsuario.findAll").getResultList();
    }

    @Override
    public List<GrupoUsuario> findAllActiveGrupoUsuario() {
     return em.createNamedQuery("GrupoUsuario.findAllActive").getResultList();
    }

    @Override
    public GrupoUsuario findGrupoUsuarioById(GrupoUsuario grupoUsario) {
        Query query=em.createNamedQuery("GrupoUsuario.findByNombreUsuario");
        query.setParameter("nombreUsuario",grupoUsario.getNombreUsuario());
        return (GrupoUsuario) query.getSingleResult();
    }

    @Override
    public void insertGrupoUsuario(GrupoUsuario grupoUsario) {
        em.persist(grupoUsario);
    }

    @Override
    public void updateGrupoUsuario(GrupoUsuario grupoUsuario) {
        em.merge(grupoUsuario);
                
    }
    

    @Override
    public void deleteGrupoUsuario(GrupoUsuario grupoUsuario) {
        em.merge(grupoUsuario);
        em.remove(grupoUsuario);
    }
    
}
