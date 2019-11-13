/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.GrupoUsuario;
import java.util.List;
import javax.ejb.Local;




@Local
public interface GrupoUsuarioService {
    
    public List<GrupoUsuario> listarGrupoUsuarios();
    
    public List<GrupoUsuario> listarGrupoUsuariosActivos(); 
    
    public GrupoUsuario buscarUsuarioPorNombreUsuario(String nombreUsuario);
    
    public void registrarGrupoUsuario(GrupoUsuario usuario);
    
    public void actualizarGrupoUsuario(GrupoUsuario usuario);
    
    public void eliminarGrupoUsuario(GrupoUsuario usuario);
    
}

    
