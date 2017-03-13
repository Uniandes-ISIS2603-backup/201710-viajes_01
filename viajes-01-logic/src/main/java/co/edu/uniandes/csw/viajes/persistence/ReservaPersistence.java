package co.edu.uniandes.csw.viajes.persistence;

import co.edu.uniandes.csw.viajes.entities.ReservaEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.Query;

@Stateless
public class ReservaPersistence{

    @PersistenceContext(unitName="viajesPU")
    protected EntityManager em;

    public ReservaEntity find(Long id) {
        return em.find(ReservaEntity.class, id);
    }

    public List<ReservaEntity> findAll() {
        Query q = em.createQuery("select u from ReservaEntity u");
        return q.getResultList();
    }

    public ReservaEntity create(ReservaEntity entity) {
        em.persist(entity);
        return entity;
    }

    public ReservaEntity update(ReservaEntity entity) {
        return em.merge(entity);
    }

    public void delete(Long id) {
        ReservaEntity entity = em.find(ReservaEntity.class, id);
        em.remove(entity);
    }
}