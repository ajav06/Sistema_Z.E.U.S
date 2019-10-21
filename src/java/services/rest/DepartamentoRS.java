/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.rest;

import domain.Departamento;
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
import services.DepartamentoService;

/**
 *
 * @author Scorpion
 */
@Path("/departamentos")
@Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes(value = {MediaType.APPLICATION_JSON})
@Stateless
public class DepartamentoRS {
    
    @Inject
    private DepartamentoService departamentoService;
    
    @GET
    public List<Departamento> listarDepartamentos(){
        return departamentoService.listarDepartamentosActivos();
    }
    
    @GET
    @Path("{id}") //hace referencia a /departamentos/{id}
    public Departamento buscarDepartamentoPorCodigo(@PathParam("id") int id){
        return departamentoService.buscarDepartamentoPorCodigo(new Departamento(id));
    }
    
    @POST
    public Response registrarDepartamento(Departamento departamento){
        try{
            departamentoService.registrarDepartamento(departamento);
            return Response.ok().entity(departamento).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Path("{id}")
    public Response actualizarDepartamento(@PathParam("id") int id, Departamento departamentoActualizado){
        try{
            Departamento departamento = departamentoService.buscarDepartamentoPorCodigo(new Departamento(id));
            if (departamento != null) {
                departamentoService.actualizarDepartamento(departamentoActualizado);
                return Response.ok().entity(departamentoActualizado).build();
            } else{
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DELETE
    @Path("{id}")
    public Response eliminarDepartamento(@PathParam("id") int id){
        try{
            departamentoService.eliminarDepartamento(new Departamento(id));
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(404).build();
        }
    }
    
}
