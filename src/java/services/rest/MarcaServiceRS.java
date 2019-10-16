/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.rest;

import domain.Marca;
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
import services.MarcaService;

/**
 *
 * @author Scorpion
 */
@Path("/marcas")
@Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes(value = {MediaType.APPLICATION_JSON})
@Stateless
public class MarcaServiceRS {
    
    @Inject
    private MarcaService marcaService;
    
    @GET
    public List<Marca> listarMarcas(){
        return marcaService.listarMarcas();
    }
    
    @GET
    @Path("{id}") //hace referencia a /marcas/{id}
    public Marca buscarMarcaPorCodigo(@PathParam("id") int id) {
        return marcaService.buscarMarcaPorCodigo(new Marca(id));
    }
    
    @GET
    @Path("nombre/{nom}") //hace referencia a /marcas/{id}
    public Marca buscarMarcaPorNombre(@PathParam("nom") String nom) {
        return marcaService.buscarMarcaPorNombre(new Marca(nom));
    }
    
    @POST
    public Response registrarMarca(Marca marca){
        try {
            marcaService.registrarMarca(marca);
            return Response.ok().entity(marca).build();
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Path("{id}")
    public Response actualizarMarca(@PathParam("id") int id, Marca marcaActualizada){
        try{
            Marca marca = marcaService.buscarMarcaPorCodigo(new Marca(id));
            if(marca == null){
                marcaService.actualizarMarca(marcaActualizada);
                return Response.ok().entity(marcaActualizada).build();
            } else{
                return Response.status(Status.NOT_FOUND).build();
            }
            
        } catch (Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DELETE
    @Path("{id}")
    public Response eliminarMarca(@PathParam("id") int id){
        try {
            marcaService.eliminarMarca(new Marca(id));
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(404).build();
        }
    }
    
}
