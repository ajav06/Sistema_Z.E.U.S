/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eis;

import domain.Usuario;
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
public class UsuarioDaoImpl implements UsuarioDao{
    
    @PersistenceContext(unitName = "ZeusPU")
    private EntityManager em;

    @Override
    public List<Usuario> findAllUsuarios()
    {
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }
    
    @Override
    public List<Usuario> findAllActiveUsuarios() {
        return em.createNamedQuery("Usuario.findAllActive").getResultList();
    }

    @Override
    public Usuario findUsuarioByUsername(String nombreUsuario) {
        Query query = em.createNamedQuery("Usuario.findByNombreUsuario");
        query.setParameter("nombreUsuario", nombreUsuario);
        return (Usuario) query.getSingleResult();
    }

    @Override
    public Usuario findUsuarioByCedula(Usuario usuario) {
        Query query = em.createNamedQuery("Usuario.findByCedula");
        query.setParameter("cedula", usuario.getCedula());
        return (Usuario) query.getSingleResult();
    }

    @Override
    public void insertUsuario(Usuario usuario) {
        em.persist(usuario);
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        em.merge(usuario);
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        em.merge(usuario);
        em.remove(usuario);
    }
    
}
