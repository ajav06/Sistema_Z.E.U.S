package eis;

import domain.GrupoUsuario;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maria
 */
public interface GrupoUsuarioDao {
    
    public List<GrupoUsuario> findAllGrupoUsuario();
    
    public List<GrupoUsuario> findAllActiveGrupoUsuario();
    
    public GrupoUsuario findGrupoUsuarioById(GrupoUsuario grupoUsario);
    
    public void insertGrupoUsuario(GrupoUsuario grupoUsario);
    
    public void updateGrupoUsuario(GrupoUsuario grupoUsario);
    
    public void deleteGrupoUsuario(GrupoUsuario grupoUsario);
}
