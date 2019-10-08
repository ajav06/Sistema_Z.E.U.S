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

/**
 *
 * @author Scorpion
 */

@Stateless
public class MarcaDaoImpl implements MarcaDao{
    
    @PersistenceContext(unitName = "ZeusPU")
    EntityManager em;
    
    @Override
    public List<Marca> findAllMarcas() {
        return em.createNamedQuery("Decanato.findAll").getResultList();
    }

    @Override
    public List<Marca> findAllActiveMarcas() {
        return em.createNamedQuery("Decanato.findAllActive").getResultList();
    }

    @Override
    public Marca findMarcaById(Marca marca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Marca findMarcaByName(Marca marca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertMarca(Marca marca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateMarca(Marca marca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteMarca(Marca marca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
