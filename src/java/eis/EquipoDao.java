/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eis;

import domain.Equipo;
import java.util.List;

/**
 *
 * @author Scorpion
 */

public interface EquipoDao {
    
    public List<Equipo> findAllEquipos();
    
    public List<Equipo> findAllActiveEquipos();
    
    public Equipo findEquipoById(Equipo equipo);
    
    public Equipo findEquipoByName(Equipo equipo);
    
    public void insertEquipo(Equipo equipo);
    
    public void updateEquipo(Equipo equipo);
    
    public void deleteEquipo(Equipo equipo);
    
}
