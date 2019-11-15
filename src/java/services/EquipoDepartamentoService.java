/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Equipo;
import domain.EquipoDepartamento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Cobos
 */
@Local
public interface EquipoDepartamentoService {
    
    public List<EquipoDepartamento> listarEquipoDpto();
    
    public List<EquipoDepartamento> listarEquipoDptoActivo();
    
    public List<EquipoDepartamento> listarEquiposReparados();
    
    public List<EquipoDepartamento> listarEquiposDesincorporados();
    
    public EquipoDepartamento buscarEquipoPorCodigo(EquipoDepartamento equipoDpto);
    
    public void regritrarEquipoDpto(EquipoDepartamento equipoDpto);
    
    public void actualizarEquipoDpto(EquipoDepartamento equipoDpto);
    
    public void eliminarEquipoDpto(EquipoDepartamento equipoDpto);
}

