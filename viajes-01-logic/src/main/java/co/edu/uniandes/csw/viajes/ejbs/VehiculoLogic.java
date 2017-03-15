/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.ejbs;

import co.edu.uniandes.csw.viajes.entities.VehiculoEntity;
import co.edu.uniandes.csw.viajes.persistence.VehiculoPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author ca.nieto11
 */
@Stateless
public class VehiculoLogic {
    @Inject private VehiculoPersistence persistence;
    
    public List<VehiculoEntity> getVehiculos(){
        return persistence.findAll();
    }
    
    public VehiculoEntity getVehiculo(Long id){
        return persistence.find(id);
    }
    
    public VehiculoEntity createVehiculo(VehiculoEntity entity){
        return persistence.create(entity);
    }
    
    public VehiculoEntity updateVehiculo(VehiculoEntity entity){
        return persistence.update(entity);
    }
    
    public void deleteVehiculo(Long id){
        persistence.delete(id);
    }
}
