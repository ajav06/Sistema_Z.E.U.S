/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eis;
import domain.Solicitudes;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author gabriel
 */
@Stateless
public class SolicitudesDaoImpl implements SolicitudesDao{
    @PersistenceContext(name = "ZeusBD")
    EntityManager em;
    
    @Override
    public List<Solicitudes> listadoSolicitudes(){
        Query query = em.createNamedQuery("Solicitudes.findByFechaInicioInterval");
        Calendar c = Calendar.getInstance();
        int mes = c.get(Calendar.MONTH);
        int anno = c.get(Calendar.YEAR);
        Calendar primero_mes = new GregorianCalendar(anno, mes, 1);
        Calendar ultimo_mes = new GregorianCalendar(anno, mes+1, 1);
        Date primero = primero_mes.getTime();
        Date ultimo = ultimo_mes.getTime();
        query.setParameter("primeroMes", primero);
        query.setParameter("finMes", ultimo);
        return query.getResultList();
    }
    
    @Override
    public List<Solicitudes> listadoSolicitudesFiltradas(int mes, int anno){
        Query query = em.createNamedQuery("Solicitudes.findByFechaInicioInterval");
        mes--;
        Calendar primero_mes = new GregorianCalendar(anno, mes, 1);
        Calendar ultimo_mes = new GregorianCalendar(anno, mes+1, 1);
        Date primero = primero_mes.getTime();
        Date ultimo = ultimo_mes.getTime();
        query.setParameter("primeroMes", primero);
        query.setParameter("finMes", ultimo);
        return query.getResultList();
    }
}
