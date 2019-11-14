/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.rest;

import java.util.List;
import domain.Solicitudes;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import services.SolicitudesService;

/**
 *
 * @author marielbax
 */
@Path("/solicitudes")
@Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes(value = {MediaType.APPLICATION_JSON})
@Stateless
public class SolicitudesServiceRS {
    
    @Inject
    private SolicitudesService solicitudesService;
    
    @GET
    public List<Solicitudes> listarSolicitudes(){
        return solicitudesService.listarSolicitudesActivos();
    }
    
    @GET
    @Path("{id}")
    public Solicitudes buscarSolicitudPorCodigo(@PathParam("id") int id){
        return solicitudesService.buscarSolicitudPorCodigo(new Solicitudes(id));
    }
    
    @GET
    @Path("tipo_solicitud/{id}") 
    public Solicitudes buscarSolicitudPorTipo(@PathParam("tipo") int tipo){
        return solicitudesService.buscarSolicitudPorTipo(new Solicitudes(tipo));
    }
   
      @POST
    public Response registrarSolicitud(Solicitudes solicitudes){
        try{
            solicitudesService.registrarSolicitud(solicitudes);
            return Response.ok().entity(solicitudes).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Path("aceptar/{id}")
    public Response aceptarSolicitud(@PathParam("id") int id, Solicitudes solicitudAceptada){
        try{
            Solicitudes solicitudes = solicitudesService.buscarSolicitudPorCodigo(new Solicitudes(id));
            if (solicitudes != null) {
                solicitudesService.aceptarSolicitud(solicitudAceptada);
                return Response.ok().entity(solicitudAceptada).build();
            } else{
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Path("rechazar/{id}")
    public Response rechazarSolicitud(@PathParam("id") int id, Solicitudes solicitudRechazada){
        try{
            Solicitudes solicitudes = solicitudesService.buscarSolicitudPorCodigo(new Solicitudes(id));
            if (solicitudes != null) {
                solicitudesService.rechazarSolicitud(solicitudRechazada);
                return Response.ok().entity(solicitudRechazada).build();
            } else{
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}
