/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Departamento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Scorpion
 */

@Local
public interface DepartamentoService {
    
    public List<Departamento> listarDepartamentos();
    
    public List<Departamento> listarDepartamentosActivos();
    
    public List<Departamento> listarDepartamentosPorDecanatos(int id);
    
    public Departamento buscarDepartamentoPorCodigo(Departamento departamento);
    
    public void registrarDepartamento(Departamento departamento);
    
    public void actualizarDepartamento(Departamento departamento);
    
    public void eliminarDepartamento(Departamento departamento);
    
}
