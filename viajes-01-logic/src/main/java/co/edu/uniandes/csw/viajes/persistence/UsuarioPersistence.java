
package co.edu.uniandes.csw.viajes.persistence;

import co.edu.uniandes.csw.viajes.entities.UsuarioEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author jp.perez12
 */
@Stateless
public class UsuarioPersistence 
{
    @PersistenceContext(unitName="viajesPU")
    protected EntityManager em;
    
    public UsuarioEntity find(Long id) {
        return em.find(UsuarioEntity.class, id);
    }

    public List<UsuarioEntity> findAll() {
        TypedQuery<UsuarioEntity> q = em.createQuery("select c from UsuarioEntity c",UsuarioEntity.class);
        return q.getResultList();
    }

    public UsuarioEntity create(UsuarioEntity usuario) {
        em.persist(usuario);
        return usuario;
    }

    public UsuarioEntity update(UsuarioEntity usuario) {
        return em.merge(usuario);
    }

    public void delete(Long id) {
        UsuarioEntity us = em.find(UsuarioEntity.class, id);
        em.remove(us);
    }
}
