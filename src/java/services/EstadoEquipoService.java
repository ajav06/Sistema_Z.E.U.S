/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.EstadoEquipo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Scorpion
 */
@Local
public interface EstadoEquipoService {
    
    public List<EstadoEquipo> listarEstadoEquipos();
    
    public List<EstadoEquipo> listarEstadoEquiposActivas();
    
    public EstadoEquipo buscarEstadoEquipoPorCodigo(EstadoEquipo estadoEquipo);
    
    public void registrarEstadoEquipo(EstadoEquipo estadoEquipo);
    
    public void actualizarEstadoEquipo(EstadoEquipo estadoEquipo);
    
    public void eliminarEstadoEquipo(EstadoEquipo estadoEquipo);
    
}
