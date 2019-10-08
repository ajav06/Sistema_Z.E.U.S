/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Marca;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Scorpion
 */

@Local
public interface MarcaService {
    
    public List<Marca> listarMarcas();
    
    public List<Marca> listarMarcasActivas();
    
    public Marca buscarMarcaPorCodigo(Marca marca);
    
    public Marca buscarMarcaPorNombre(Marca marca);
    
    public void registrarMarca(Marca marca);
    
    public void actualizarMarca(Marca marca);
    
    public void eliminarMarca(Marca marca);
    
}
