/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.rest;

import domain.EquipoDepartamento;
import domain.Equipo;
import services.EquipoDepartamentoService;

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
 * @author Cobos
 */
@Path("/equiposDpto")
@Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes(value = {MediaType.APPLICATION_JSON})
@Stateless

public class EquipoDepartamentoServiceRS {
    
    @Inject 
    private EquipoDepartamentoService equipoDepartamentoService;
    
    @GET
    public List<EquipoDepartamento> listarEquipoDpto()
    {
        return equipoDepartamentoService.listarEquipoDptoActivo();
    }
    
    @GET
    @Path("{codigo}") //hace referencia a /equiposDpto/{codigo}
    public EquipoDepartamento buscarEquipoPorCodigo(@PathParam("codigo") int codigo){
        return equipoDepartamentoService.buscarEquipoPorCodigo(new EquipoDepartamento(codigo));
    }
    
    @POST
    public Response registrarEquipoDpto(EquipoDepartamento equipoDepartamento){
        try{
            equipoDepartamentoService.regritrarEquipoDpto(equipoDepartamento);
            return Response.ok().entity(equipoDepartamento).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Path("{codigo}")
    public Response actualizarDecanato(@PathParam("codigo") int codigo, EquipoDepartamento equipoDepartamentoActualizado){
        try{
            EquipoDepartamento equipoDepartamento = equipoDepartamentoService.buscarEquipoPorCodigo(new EquipoDepartamento(codigo));
            if (equipoDepartamento != null) {
                equipoDepartamentoService.actualizarEquipoDpto(equipoDepartamentoActualizado);
                return Response.ok().entity(equipoDepartamentoActualizado).build();
            } else{
                return Response.status(Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DELETE
    @Path("{codigo}")
    public Response eliminarDecanato(@PathParam("codigo") int codigo){
        try{
            equipoDepartamentoService.eliminarEquipoDpto(new EquipoDepartamento(codigo));
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(404).build();
        }
    }
}
