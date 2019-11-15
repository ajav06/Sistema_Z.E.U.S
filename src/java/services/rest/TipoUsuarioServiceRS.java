/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.rest;

import domain.TipoUsuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import services.TipoUsuarioService;

/**
 *
 * @author Maria
 */
@Path("/tipoUsuarios")
@Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes(value = {MediaType.APPLICATION_JSON})
@Stateless
public class TipoUsuarioServiceRS {
    @Inject
    private TipoUsuarioService tipoUsuarioService;
    
    @GET
    public List<TipoUsuario> listarTipoUsuariosActivados(){
        return tipoUsuarioService.listarTipoUsuariosActivos();
    }
            
    @GET
    @Path("{nom}") //hace referencia a /marcas/{id}
    public TipoUsuario buscarTipoUsuarioPorCodigo(@PathParam("nom") int cod) {
        return tipoUsuarioService.buscarTipoUsuarioPorCodigo(cod);
    }
}
