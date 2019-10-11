/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.rest;

import domain.Equipo;
import domain.Marca;
import services.EquipoService;

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

/**
 *
 * @author Scorpion
 */
@Path("/equipos")
@Stateless
public class EquipoServiceRS {
    
    @Inject
    private EquipoService equipoService;
    
    @GET
    @Produces(value={MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Equipo> listarEquipos(){
        return equipoService.listarEquiposActivos();
    }
    
    @GET
    @Produces(value={MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}") //hace referencia a /equipos/{id}
    public Equipo buscarEquipoPorCodigo(@PathParam("id") int id) {
        return equipoService.buscarEquipoPorCodigo(new Equipo(id));
    }
    
    @POST
    @Produces(value={MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes(value={MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response registrarEquipo(Equipo equipo){
        try {
            equipoService.registrarEquipo(equipo);
            return Response.ok().entity(equipo).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Produces(value={MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes(value={MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response actualizarEquipo(@PathParam("id") int id, Equipo equipoActualizada){
        try{
            Equipo equipo = equipoService.buscarEquipoPorCodigo(new Equipo(id));
            if(equipo == null){
                equipoService.actualizarEquipo(equipoActualizada);
                return Response.ok().entity(equipoActualizada).build();
            } else{
                return Response.status(Status.NOT_FOUND).build();
            }
            
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DELETE
    @Path("{id}")
    public Response eliminarEquipo(@PathParam("id") int id){
        try {
            equipoService.eliminarEquipo(new Equipo(id));
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(404).build();
        }
    }
    
}
