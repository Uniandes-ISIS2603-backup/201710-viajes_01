
package co.edu.uniandes.csw.viajes.ejbs;

import co.edu.uniandes.csw.viajes.entities.UsuarioEntity;
import co.edu.uniandes.csw.viajes.persistence.UsuarioPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class UsuarioLogic {
    
  @Inject private UsuarioPersistence persistence;
  
  public List<UsuarioEntity> getUsuarios() {
        return persistence.findAll();
    }


    public UsuarioEntity getUsuario(Long id) {
        return persistence.find(id);
    }

    
    public UsuarioEntity createUsuario(UsuarioEntity entity) {
        persistence.create(entity);
        return entity;
    }

   
    public UsuarioEntity updateUsuario(UsuarioEntity entity) {
        return persistence.update(entity);
    }

   
    public void deleteUsuario(Long id) {
        persistence.delete(id);
    }
  
}
