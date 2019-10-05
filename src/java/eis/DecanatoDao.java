/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eis;

import java.util.List;

import domain.Decanato;

/**
 *
 * @author AJAV06
 */
public interface DecanatoDao {
    
    public List<Decanato> findAllDecanatos();
    
    public List<Decanato> findAllActiveDecanatos();
    
    public Decanato findDecanatoById(Decanato decanato);
    
    public Decanato findDecanatoByName(Decanato decanato);
    
    public void insertDecanato(Decanato decanato);
    
    public void updateDecanato(Decanato decanato);
    
    public void deleteDecanato(Decanato decanato);
    
}
