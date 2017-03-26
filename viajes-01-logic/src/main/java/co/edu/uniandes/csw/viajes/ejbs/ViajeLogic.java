
package co.edu.uniandes.csw.viajes.ejbs;

import co.edu.uniandes.csw.viajes.entities.ViajeEntity;
import co.edu.uniandes.csw.viajes.persistence.ViajePersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ViajeLogic {

    @Inject private ViajePersistence persistence;
    
    public List<ViajeEntity> getViajes() {
        return persistence.findAll();
    }

    public ViajeEntity getViaje(Long id) {
        return persistence.find(id);
    }

    
    public ViajeEntity createViaje(ViajeEntity entity) {
        
        persistence.create(entity);
        return entity;
    }

   
    public ViajeEntity updateViaje(ViajeEntity entity) {
        return persistence.update(entity);
    }

   
    public void deleteViaje(Long id) {
        persistence.delete(id);
    }

    
    
}
