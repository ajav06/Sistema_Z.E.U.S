/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eis;

import domain.Usuario;
import java.util.List;

/**
 *
 * @author Scorpion
 */

public interface UsuarioDao {
    
    public List<Usuario> findAllUsuarios();
    
    public List<Usuario> findAllActiveUsuarios();
    
    public Usuario findUsuarioByUsername(String nombreUsuario);
    
    public Usuario findUsuarioByCedula(Usuario usuario);
    
    public void insertUsuario(Usuario usuario);
    
    public void updateUsuario(Usuario usuario);
    
    public void deleteUsuario(Usuario usuario);
    
}
