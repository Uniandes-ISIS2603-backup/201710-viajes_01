/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.persistence;

import co.edu.uniandes.csw.viajes.entities.MultaEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class MultaPersistence {

  @PersistenceContext(unitName = "viajesPU")  
  protected EntityManager em; 
  
  public MultaEntity find(Long id){
     return em.find(MultaEntity.class, id);      
  }
  
  public List<MultaEntity> findAll(){
      Query q = em.createQuery("Select u from MultaEntity u");
      return q.getResultList();
  }
  
  public MultaEntity create(MultaEntity entity){
      em.persist(entity);
      return entity;
  }
  
  public MultaEntity update(MultaEntity entity){
      return em.merge(entity);
  }
  
  public void delete(Long id){
      MultaEntity entity = em.find(MultaEntity.class, id);
      em.remove(entity);
  }
          
}
