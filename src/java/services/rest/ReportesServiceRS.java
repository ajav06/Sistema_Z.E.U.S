/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.rest;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import services.ReportesService;

/**
 *
 * @author gabriel
 */
@Path("/reportes")
@Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes(value = {MediaType.APPLICATION_JSON})
@Stateless
public class ReportesServiceRS {
    
    private Set<Integer> totalesUniversidad;
    
    @Inject
    private ReportesService reportesService;
    
    @GET
    @Path("/totales/universidad")
    public Response reporteTotalesUniversidad(){
        Long a = reportesService.totalEquiposUniversidad();
        Long r = reportesService.totalEquiposReparacionUniversidad();
        Long d = reportesService.totalEquiposDesincorporadosUniversidad();
        Long t = a+r+d;
        String json = 
                "{"+
                "\"activos\":\""+a.toString()+"\"," +
                "\"reparados\":\""+r.toString()+"\","+
                "\"desincorporados\":\""+d.toString()+"\","+
                "\"totales\":\""+t.toString()+"\""+
                "}";
        return Response.ok(json,MediaType.APPLICATION_JSON).build();
    }
}
