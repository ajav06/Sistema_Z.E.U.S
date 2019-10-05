/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Decanato;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Scorpion
 */

@Remote
public interface DecanatoServiceRemote {
    
    public List<Decanato> listarDecanatos();
    
    public List<Decanato> listarDecanatosActivos();
    
    public Decanato encontrarDecanatoPorId(Decanato decanato);
    
    public Decanato encontrarDecanatoPorNombre(Decanato decanato);
    
    public void registrarDecanato(Decanato decanato);
    
    public void actualizarDecanato(Decanato decanato);
    
    public void eliminarDecanato(Decanato decanato);
    
}
