/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eis;

import domain.TipoUsuario;
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
public class TipoUsuarioDaoImpl implements TipoUsuarioDao{
    @PersistenceContext(unitName = "ZeusPU")
    private EntityManager em;

    @Override
    public List<TipoUsuario> findAllTipoUsuario() {
        return em.createNamedQuery("TipoUsuario.findAll").getResultList();
    }

    @Override
    public List<TipoUsuario> findAllActiveTipoUsuario() {
     return em.createNamedQuery("TipoUsuario.findAllActive").getResultList();
    }

    @Override
    public TipoUsuario findTipoUsuarioById(TipoUsuario tipoUsario) {
        Query query=em.createNamedQuery("TipoUsuario.findByCodigo");
        query.setParameter("codigo",tipoUsario.getCodigo());
        return (TipoUsuario) query.getSingleResult();
    }

}
