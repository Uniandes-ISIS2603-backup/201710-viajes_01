
package co.edu.uniandes.csw.viajes.persistence;

import co.edu.uniandes.csw.viajes.entities.VehiculoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author ca.nieto11
 */
@Stateless
public class VehiculoPersistence {
    @PersistenceContext(unitName="viajesPU")
    protected EntityManager em;
    
    public VehiculoEntity find(Long id) {
        return em.find(VehiculoEntity.class, id);
    }

    public List<VehiculoEntity> findAll() {
        TypedQuery<VehiculoEntity> q = em.createQuery("select c from VehiculoEntity c",VehiculoEntity.class);
        return q.getResultList();
    }

    public VehiculoEntity create(VehiculoEntity vehiculo) {
        em.persist(vehiculo);
        return vehiculo;
    }

    public VehiculoEntity update(VehiculoEntity vehiculo) {
        return em.merge(vehiculo);
    }

    public void delete(Long id) {
        VehiculoEntity c = em.find(VehiculoEntity.class, id);
        em.remove(c);
    }
}
