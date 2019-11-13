/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.rest;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import services.ReportesService;
import domain.Decanato;
import domain.Departamento;
import domain.Usuario;
import domain.Solicitudes;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gabriel
 */
@Path("/reportes")
@Produces(value = {MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes(value = {MediaType.APPLICATION_JSON})
@Stateless
public class ReportesServiceRS{
    
    @PersistenceContext(name = "ZeusBD")
    EntityManager em;
    
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
    
    @GET
    @Path("/totales/decanato/{dec}")
    public Response reporteTotalesDecanato(@PathParam("dec") int dec){
        Long a = reportesService.totalEquiposDecanato(new Decanato(dec));
        Long r = reportesService.totalEquiposReparacionDecanato(new Decanato(dec));
        Long d = reportesService.totalEquiposDesincorporadosDecanato(new Decanato(dec));
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
    
    @GET
    @Path("/totales/departamento/{dep}")
    public Response reporteTotalesDepartamento(@PathParam("dep") int dep){
        Long a = reportesService.totalEquiposDepartamento(new Departamento(dep));
        Long r = reportesService.totalEquiposReparacionDepartamento(new Departamento(dep));
        Long d = reportesService.totalEquiposDesincorporadosDepartamento(new Departamento(dep));
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
    
    @GET
    @Path("/mayor_menor/universidad")
    public Response mayorMenorUniversidad(){
        List<?> lista;
        lista = reportesService.mayorEquiposUniversidad();
        Object[] mayor = (Object[]) lista.get(0);
        Decanato decmayor = (Decanato) mayor[0];
        String depmayor = (String) mayor[1];
        Long cantmayor = (Long) mayor[2];
        Object[] menor = (Object[]) lista.get(lista.size()-1);
        Decanato decmenor = (Decanato) menor[0];
        String depmenor = (String) menor[1];
        Long cantmenor = (Long) menor[2];
        String json = 
        "{"+
            "\"decmayuni\":\""+decmayor.getNombre()+"\"," +
            "\"depmayuni\":\""+depmayor+"\","+
            "\"mayuni\":\""+cantmayor.toString()+"\","+
            "\"decmenuni\":\""+decmenor.getNombre()+"\"," +
            "\"depmenuni\":\""+depmenor+"\","+
            "\"menuni\":\""+cantmenor.toString()+"\""+
        "}";
        return Response.ok(json,MediaType.APPLICATION_JSON).build();
    }
    
    @GET
    @Path("/mayor_menor/decanato/{id}")
    public Response mayorMenorDecanato(@PathParam("id") int dec){
        List<?> lista;
        lista = reportesService.mayorEquiposDecanato(new Decanato(dec));
        String json;
        if (lista.size()>1){
            Object[] mayor = (Object[]) lista.get(0);
            String depmayor = (String) mayor[0];
            Long cantmayor = (Long) mayor[1];
            Object[] menor = (Object[]) lista.get(lista.size()-1);
            String depmenor = (String) menor[0];
            Long cantmenor = (Long) menor[1];
            json = 
            "{"+
                "\"depmaydec\":\""+depmayor+"\","+
                "\"maydec\":\""+cantmayor.toString()+"\","+
                "\"depmendec\":\""+depmenor+"\","+
                "\"mendec\":\""+cantmenor.toString()+"\""+
            "}";
        } else {
            json = 
            "{"+
                "\"error\":\"¡El decanato tiene sólo un departamento!\"" +
            "}";            
        }
        return Response.ok(json,MediaType.APPLICATION_JSON).build();
    }
    
    @GET
    @Produces(value = {MediaType.APPLICATION_JSON})
    @Path("/solicitudes/{anno}/{mes}/")
    public List<Solicitudes> reporteSolicitudesFiltrado(@PathParam("anno") int anno, @PathParam("mes") int mes){
        List<Solicitudes> lista = reportesService.listadoSolicitudesFiltradas(mes, anno);
        List<Solicitudes> lista2 = new ArrayList<Solicitudes>();
        for(Solicitudes s:lista){
            Solicitudes o = new Solicitudes();
            Usuario nvo_u = new Usuario(s.getNombreUsuario().getNombre(),s.getNombreUsuario().getApellido());
            o.setCodigo(s.getCodigo());
            o.setCodigoEquipoDepartamento(s.getCodigoEquipoDepartamento());
            o.setEstatus(s.getEstatus());
            o.setFechaAtencion(s.getFechaAtencion());
            o.setFechaInicio(s.getFechaInicio());
            o.setNombreUsuario(nvo_u);
            o.setTipoSolicitud(s.getTipoSolicitud());
            lista2.add(o);
        }
        return lista2;
    }

}