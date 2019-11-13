/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Scorpion
 */
@Local
public interface UsuarioService {
    
    public List<Usuario> listarUsuarios();
    
    public List<Usuario> listarUsuariosActivos();
    
    public Usuario buscarUsuarioPorNombreUsuario(String nombreUsuario);
    
    public Usuario buscarUsuarioPorCedula(Usuario usuario);
    
    public void registrarUsuario(Usuario usuario);
    
    public void actualizarUsuario(Usuario usuario);
    
    public void eliminarUsuario(Usuario usuario);
    
}
