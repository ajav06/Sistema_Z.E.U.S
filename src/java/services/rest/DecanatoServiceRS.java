/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.rest;

import domain.Decanato;
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
import services.DecanatoService;

/**
 *
 * @author Scorpion
 */
@Path("/decanatos")
@Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes(value = {MediaType.APPLICATION_JSON})
@Stateless
public class DecanatoServiceRS {
    
    @Inject
    private DecanatoService decanatoService;
    
    @GET
    public List<Decanato> listarDecanatos(){
        return decanatoService.listarDecanatosActivos();
    }
    
    @GET
    @Path("{id}") //hace referencia a /decanatos/{id}
    public Decanato buscarDecanatoPorCodigo(@PathParam("id") int id){
        return decanatoService.buscarDecanatoPorCodigo(new Decanato(id));
    }
    
    @POST
    public Response registrarDecanato(Decanato decanato){
        try{
            decanatoService.registrarDecanato(decanato);
            return Response.ok().entity(decanato).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Path("{id}")
    public Response actualizarDecanato(@PathParam("id") int id, Decanato decanatoActualizado){
        try{
            Decanato decanato = decanatoService.buscarDecanatoPorCodigo(new Decanato(id));
            if (decanato != null) {
                decanatoService.actualizarDecanato(decanatoActualizado);
                return Response.ok().entity(decanatoActualizado).build();
            } else{
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DELETE
    @Path("{id}")
    public Response eliminarDecanato(@PathParam("id") int id){
        try{
            decanatoService.eliminarDecanato(new Decanato(id));
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(404).build();
        }
    }
}
