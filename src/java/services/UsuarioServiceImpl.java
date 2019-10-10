/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Usuario;
import eis.UsuarioDao;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

/**
 *
 * @author Scorpion
 */

@Stateless
public class UsuarioServiceImpl implements UsuarioService{
    
    @Resource
    private SessionContext contexto;
    
    @EJB
    private UsuarioDao usuarioDao;

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioDao.findAllUsuarios();
    }

    @Override
    public Usuario buscarUsuarioPorNombreUsuario(Usuario usuario) {
        return usuarioDao.findUsuarioByUsername(usuario);
    }

    @Override
    public Usuario buscarUsuarioPorNombreUsuario(String nombreUsuario) {
        return usuarioDao.findUsuarioByUsername(nombreUsuario);
    }

    @Override
    public Usuario buscarUsuarioPorCedula(Usuario usuario) {
        return usuarioDao.findUsuarioByCedula(usuario);
    }

    @Override
    public void registrarUsuario(Usuario usuario) {
        usuarioDao.insertUsuario(usuario);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        try {
            usuarioDao.updateUsuario(usuario);
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarUsuario(Usuario usuario) {
        usuarioDao.deleteUsuario(usuario);
    }
    
}
