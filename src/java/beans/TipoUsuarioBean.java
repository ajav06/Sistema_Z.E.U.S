/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import domain.TipoUsuario;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import services.TipoUsuarioService;

@Named
@RequestScoped
public class TipoUsuarioBean {
    
    @Inject
    private TipoUsuarioService tipoUsuarioService;
    
    List<TipoUsuario> tiposUsuario;
    
    public TipoUsuarioBean() {
    }

    @PostConstruct
    public void inicializar(){
        this.tiposUsuario = this.tipoUsuarioService.listarTipoUsuariosActivos();
    }

    public List<TipoUsuario> getTiposUsuario() {
        return tiposUsuario;
    }

    public void setTiposUsuario(List<TipoUsuario> tiposUsuario) {
        this.tiposUsuario = tiposUsuario;
    }
    
}
