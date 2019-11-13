/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eis;

import java.util.List;

import domain.EquipoDepartamento;
import domain.Equipo;
/**
 *
 * @author Cobos
 */
public interface EquiposDptoDao {
    
    public List<EquipoDepartamento> findAllEquipoDpto();
    
    public List<EquipoDepartamento> findAllActiveEquipoDpto();
    
    public EquipoDepartamento findEquipoById(EquipoDepartamento equipoDpto);
    
    public EquipoDepartamento findEquipoByName(Equipo equipo);
    
    public void insertEquipoDpto(EquipoDepartamento equipoDpto);
    
    public void updateEquipoDpto(EquipoDepartamento equipoDpto);
    
    public void deleteEquipoDpto(EquipoDepartamento equipoDpto);
}
