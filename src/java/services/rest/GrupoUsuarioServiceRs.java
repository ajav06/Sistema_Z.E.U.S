/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.rest;

import domain.GrupoUsuario;
import domain.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import services.GrupoUsuarioService;

@Path("/grupoUsuarios")
@Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes(value = {MediaType.APPLICATION_JSON})
@Stateless
public class GrupoUsuarioServiceRs {
    
    @Inject
    private GrupoUsuarioService grupoUsuarioService;
    
    @GET
    public List<GrupoUsuario> listarGrupoUsuariosActivados(){
        return grupoUsuarioService.listarGrupoUsuariosActivos();
    }
            
    @GET
    @Path("{nom}") //hace referencia a /marcas/{id}
    public GrupoUsuario buscarUsuarioPorNombre(@PathParam("nom") String nom) {
        return grupoUsuarioService.buscarUsuarioPorNombreUsuario(nom);
    }
    
    @POST
    public Response registrarGrupoUsuario(GrupoUsuario grupoUsuario){
        try {
            grupoUsuarioService.registrarGrupoUsuario(grupoUsuario);
            return Response.ok().entity(grupoUsuario).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Path("{id}")
    public Response actualizarUsuario(@PathParam("id") String id, GrupoUsuario grupoUsuarioActualizado){
        try{
            GrupoUsuario grupousuario = grupoUsuarioService.buscarUsuarioPorNombreUsuario(id);
            if(grupousuario != null){
                grupoUsuarioService.actualizarGrupoUsuario(grupoUsuarioActualizado);
                return Response.ok().entity(grupoUsuarioActualizado).build();
            } else{
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DELETE
    @Path("{id}")
    public Response eliminarGrupoUsuario(@PathParam("id") String id){
        try {
            grupoUsuarioService.eliminarGrupoUsuario(new GrupoUsuario(id));
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(404).build();
        }
    }
}
