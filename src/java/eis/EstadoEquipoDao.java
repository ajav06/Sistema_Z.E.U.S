/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eis;

import domain.EstadoEquipo;
import java.util.List;

/**
 *
 * @author Scorpion
 */
public interface EstadoEquipoDao {
    
    public List<EstadoEquipo> findAllEstadoEquipos();
    
    public List<EstadoEquipo> findAllActiveEstadoEquipos();
    
    public EstadoEquipo findEstadoEquipoById(EstadoEquipo estadoEquipo);
    
    public void insertEstadoEquipo(EstadoEquipo estadoEquipo);
    
    public void updateEstadoEquipo(EstadoEquipo estadoEquipo);
    
    public void deleteEstadoEquipo(EstadoEquipo estadoEquipo);
    
}
