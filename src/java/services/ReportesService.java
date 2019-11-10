/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.ejb.Local;

/**
 *
 * @author gabriel
 */
@Local
public interface ReportesService {
    
    public Long totalEquiposUniversidad();
    public Long totalEquiposReparacionUniversidad();
    public Long totalEquiposDesincorporadosUniversidad();
    
}
