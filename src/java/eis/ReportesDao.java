/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eis;

import domain.Decanato;
import domain.Departamento;

/**
 *
 * @author gabriel
 */
public interface ReportesDao {
    
    //TOTALES DE UNIVERSIDAD
    public Long totalActiveItems();
    public Long totalRepairingItems();
    public Long totalDesincorporatedItems();
    
    //TOTALES POR DECANATO
    public Long totalActiveItemsDean(Decanato dec);
    public Long totalRepairingItemsDean(Decanato dec);
    public Long totalDesincorporatedItemsDean(Decanato dec);
    
    //TOTALES POR DEPARTAMENTO
    public Long totalActiveItemsDepartment(Departamento dep);
    public Long totalReparingItemsDepartment(Departamento dep);
    public Long totalDesincorporatedItemsDepartment(Departamento dep);
}
