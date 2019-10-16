/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Equipo;
import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author Scorpion
 */

@WebService
public interface EquipoServiceWS {
    
    public List<Equipo> listarEquipos();
    
    public List<Equipo> listarEquiposActivos();
    
    public Equipo buscarEquipoPorCodigo(Equipo equipo);
    
    public Equipo buscarEquipoPorNombre(Equipo equipo);
    
    public void registrarEquipo(Equipo equipo);
    
    public void actualizarEquipo(Equipo equipo);
    
    public void eliminarEquipo(Equipo equipo);
    
}
