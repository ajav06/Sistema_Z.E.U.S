/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.GrupoUsuario;
import eis.GrupoUsuarioDao;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

/**
 *
 * @author Maria
 */
@Stateless
public class GrupoUsuarioServiceImpl implements GrupoUsuarioService{
    
    @Resource
    private SessionContext contexto;

    @EJB
    private GrupoUsuarioDao grupoUsuarioDao;
    
    @Override
    public List<GrupoUsuario> listarGrupoUsuarios() {
        return grupoUsuarioDao.findAllGrupoUsuario();
    }

    @Override
    public List<GrupoUsuario> listarGrupoUsuariosActivos() {
        return grupoUsuarioDao.findAllActiveGrupoUsuario();
    }

    @Override
    public GrupoUsuario buscarUsuarioPorNombreUsuario(String nombreUsuario) {
        return grupoUsuarioDao.findGrupoUsuarioById(new GrupoUsuario(nombreUsuario));
        }

    @Override
    public void registrarGrupoUsuario(GrupoUsuario usuario) {
        grupoUsuarioDao.insertGrupoUsuario(usuario);
    }

    @Override
    public void actualizarGrupoUsuario(GrupoUsuario usuario) {
          try {
           grupoUsuarioDao.updateGrupoUsuario(usuario);
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarGrupoUsuario(GrupoUsuario usuario) {
    grupoUsuarioDao.deleteGrupoUsuario(usuario);
    }
}
