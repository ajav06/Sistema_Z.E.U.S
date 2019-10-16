/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.rest;

import domain.Equipo;
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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 *
 * @author Scorpion
 */
@Path("/equipos")
@Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes(value = {MediaType.APPLICATION_JSON})
@Stateless
public class EquipoServiceRS {
    
    static Logger log = LogManager.getRootLogger();
    
    @Inject
    private EquipoService equipoService;
    
    @GET
    public List<Equipo> listarEquipos(){
        return equipoService.listarEquiposActivos();
    }
    
    @GET
    @Path("{id}") //hace referencia a /equipos/{id}
    public Equipo buscarEquipoPorCodigo(@PathParam("id") int id) {
        return equipoService.buscarEquipoPorCodigo(new Equipo(id));
    }
    
    @POST
    public Response registrarEquipo(Equipo equipo){
        try {
            equipoService.registrarEquipo(equipo);
            return Response.ok().entity(equipo).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Path("{id}")
    public Response actualizarEquipo(@PathParam("id") int id, Equipo equipoActualizada){
        log.debug(id);
        log.debug(equipoActualizada);
        try{
            Equipo equipo = equipoService.buscarEquipoPorCodigo(new Equipo(id));
            if(equipo != null){
                equipo.setCodigoMarca(equipoActualizada.getCodigoMarca());
                equipo.setNombre(equipoActualizada.getNombre());
                equipo.setDescripcion(equipoActualizada.getDescripcion());
                equipoService.actualizarEquipo(equipo);
                return Response.ok().entity(equipo).build();
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
