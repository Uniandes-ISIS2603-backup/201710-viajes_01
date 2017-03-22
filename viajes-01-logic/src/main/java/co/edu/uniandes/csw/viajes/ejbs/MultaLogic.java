// TODO: eliminar mensajes por defecto
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.ejbs;

import co.edu.uniandes.csw.viajes.entities.MultaEntity;
import co.edu.uniandes.csw.viajes.persistence.MultaPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class MultaLogic {
    
  @Inject private MultaPersistence persistence;
  
  public List<MultaEntity> getMultas() {
        return persistence.findAll();
    }


    public MultaEntity getMulta(Long id) {
        return persistence.find(id);
    }

    
    public MultaEntity createMulta(MultaEntity entity) {
        persistence.create(entity);
        return entity;
    }

   
    public MultaEntity updateMulta(MultaEntity entity) {
        return persistence.update(entity);
    }

   
    public void deleteMulta(Long id) {
        persistence.delete(id);
    }
  
}
