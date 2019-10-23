/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.rest;

import domain.EstadoEquipo;
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
import services.EstadoEquipoService;

/**
 *
 * @author Scorpion
 */
@Path("/estadosEquipo")
@Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes(value = {MediaType.APPLICATION_JSON})
@Stateless
public class EstadoEquipoServiceRS {
    
    @Inject
    private EstadoEquipoService estadoEquipoService;
    
    @GET
    public List<EstadoEquipo> listarEstadoEquipos(){
        return estadoEquipoService.listarEstadoEquiposActivas();
    }
    
    @GET
    @Path("{id}") //hace referencia a /estadoEquipos/{id}
    public EstadoEquipo buscarEstadoEquipoPorCodigo(@PathParam("id") int id) {
        return estadoEquipoService.buscarEstadoEquipoPorCodigo(new EstadoEquipo(id));
    }
    
    @POST
    public Response registrarEstadoEquipo(EstadoEquipo estadoEquipo){
        try {
            estadoEquipoService.registrarEstadoEquipo(estadoEquipo);
            return Response.ok().entity(estadoEquipo).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Path("{id}")
    public Response actualizarEstadoEquipo(@PathParam("id") int id, EstadoEquipo estadoEquipoActualizada){
        try{
            EstadoEquipo estadoEquipo = estadoEquipoService.buscarEstadoEquipoPorCodigo(new EstadoEquipo(id));
            if(estadoEquipo != null){
                estadoEquipoService.actualizarEstadoEquipo(estadoEquipoActualizada);
                return Response.ok().entity(estadoEquipoActualizada).build();
            } else{
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DELETE
    @Path("{id}")
    public Response eliminarEstadoEquipo(@PathParam("id") int id){
        try {
            estadoEquipoService.eliminarEstadoEquipo(new EstadoEquipo(id));
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(404).build();
        }
    } 
}
