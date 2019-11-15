/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.TipoUsuario;
import eis.TipoUsuarioDao;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
/**
 *
 * @author Maria
 */
@Stateless
public class TipoUsuarioServiceImpl implements TipoUsuarioService {

    @EJB
    private TipoUsuarioDao tipoUsuarioDao;
    
    @Override
    public List<TipoUsuario> listarTipoUsuarios() {
        return tipoUsuarioDao.findAllTipoUsuario();
    }

    @Override
    public List<TipoUsuario> listarTipoUsuariosActivos() {
        return tipoUsuarioDao.findAllActiveTipoUsuario();
    }

    @Override
    public TipoUsuario buscarTipoUsuarioPorCodigo(int codigo) {
        return tipoUsuarioDao.findTipoUsuarioById(new TipoUsuario(codigo));
    }
   
}
