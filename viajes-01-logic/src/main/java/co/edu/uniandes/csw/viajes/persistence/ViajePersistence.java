/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.persistence;

import co.edu.uniandes.csw.viajes.entities.ViajeEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ViajePersistence {
    @PersistenceContext(unitName = "viajesPU")  
  protected EntityManager em; 
  
  public ViajeEntity find(Long id){
     return em.find(ViajeEntity.class, id);      
  }
  
  public List<ViajeEntity> findAll(){
      Query q = em.createQuery("Select u from ViajeEntity u");
      return q.getResultList();
  }
  
  public ViajeEntity create(ViajeEntity entity){
      em.persist(entity);
      return entity;
  }
  
  public ViajeEntity update(ViajeEntity entity){
      return em.merge(entity);
  }
  
  public void delete(Long id){
      ViajeEntity entity = em.find(ViajeEntity.class, id);
      em.remove(entity);
  }
          

}
