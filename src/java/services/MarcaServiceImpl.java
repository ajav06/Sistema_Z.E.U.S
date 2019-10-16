/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import domain.Marca;
import eis.MarcaDao;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.jws.WebService;

/**
 *
 * @author Scorpion
 */
@Stateless
@WebService(endpointInterface = "services.MarcaServiceWS")
public class MarcaServiceImpl implements MarcaService, MarcaServiceWS{
    
    @Resource
    private SessionContext contexto;
    
    @EJB
    private MarcaDao marcaDao;

    @Override
    public List<Marca> listarMarcas() {
        return marcaDao.findAllMarcas();
    }

    @Override
    public List<Marca> listarMarcasActivas() {
        return marcaDao.findAllActiveMarcas();
    }

    @Override
    public Marca buscarMarcaPorCodigo(Marca marca) {
        return marcaDao.findMarcaById(marca);
    }

    @Override
    public Marca buscarMarcaPorNombre(Marca marca) {
        return marcaDao.findMarcaByName(marca);
    }

    @Override
    public void registrarMarca(Marca marca) {
        marcaDao.insertMarca(marca);
    }

    @Override
    public void actualizarMarca(Marca marca) {
        try {
            marcaDao.updateMarca(marca);
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarMarca(Marca marca) {
        marcaDao.deleteMarca(marca);
    }
    
}
