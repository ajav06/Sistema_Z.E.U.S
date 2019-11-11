/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eis;

import domain.Departamento;
import domain.Decanato;
import java.util.List;

/**
 *
 * @author Scorpion
 */
public interface DepartamentoDao {
    
    public List<Departamento> findAllDepartamentos();
    
    public List<Departamento> findAllActiveDepartamentos();
    
    public List<Departamento> findAllDepartamentosDecanatos(int id);
    
    public Departamento findDepartamentoById(Departamento departamento);
    
    public void insertDepartamento(Departamento departamento);
    
    public void updateDepartamento(Departamento departamento);
    
    public void deleteDepartamento(Departamento departamento);    
    
    public List<?> mostItems();
    
    public List<?> mostItemsDean(Decanato decanato);
}
