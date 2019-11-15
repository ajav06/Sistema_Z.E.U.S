/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.TipoUsuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Maria
 */
@Local
public interface TipoUsuarioService {
    
    public List<TipoUsuario> listarTipoUsuarios();
    
    public List<TipoUsuario> listarTipoUsuariosActivos(); 
    
    public TipoUsuario buscarTipoUsuarioPorCodigo(int codigo);
    
}
