/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eis;

import domain.Marca;
import java.util.List;

/**
 *
 * @author Scorpion
 */

public interface MarcaDao {
    
    public List<Marca> findAllMarcas();
    
    public List<Marca> findAllActiveMarcas();
    
    public Marca findMarcaById(Marca marca);
    
    public Marca findMarcaByName(Marca marca);
    
    public void insertMarca(Marca marca);
    
    public void updateMarca(Marca marca);
    
    public void deleteMarca(Marca marca);
}
