/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.rest;

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
import javax.ws.rs.core.Response.Status;
import services.UsuarioService;

@Path("/usuarios")
@Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes(value = {MediaType.APPLICATION_JSON})
@Stateless
public class UsuarioServiceRS {
    
    @Inject
    private UsuarioService usuarioService;
    
    @GET
    public List<Usuario> listarUsuariosActivados(){
        return usuarioService.listarUsuarios();
    }
            
    @GET
    @Path("{nom}") //hace referencia a /marcas/{id}
    public Usuario buscarUsuarioPorNombre(@PathParam("nom") String nom) {
        return usuarioService.buscarUsuarioPorNombreUsuario(nom);
    }
    
    @POST
    public Response registrarUsuario(Usuario usuario){
        try {
            usuarioService.registrarUsuario(usuario);
            return Response.ok().entity(usuario).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Path("{id}")
    public Response actualizarUsuario(@PathParam("id") String id, Usuario usuarioActualizado){
        try{
            Usuario usuario = usuarioService.buscarUsuarioPorNombreUsuario(id);
            if(usuario != null){
                usuarioService.actualizarUsuario(usuarioActualizado);
                return Response.ok().entity(usuarioActualizado).build();
            } else{
                return Response.status(Status.NOT_FOUND).build();
            }
            
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DELETE
    @Path("{id}")
    public Response eliminarUsuario(@PathParam("id") String id){
        try {
            usuarioService.eliminarUsuario(new Usuario(id));
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(404).build();
        }
    }
    
    
}
