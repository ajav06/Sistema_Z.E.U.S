/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eis;

/**
 *
 * @author gabriel
 */
public interface ReportesDao {
    
    public Long totalActiveItems();
    public Long totalRepairingItems();
    public Long totalDesincorporatedItems();
    
}
