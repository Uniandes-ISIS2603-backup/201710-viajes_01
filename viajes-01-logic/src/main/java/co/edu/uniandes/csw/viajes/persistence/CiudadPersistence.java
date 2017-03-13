/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.persistence;

import co.edu.uniandes.csw.viajes.entities.CiudadEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class CiudadPersistence {
     @PersistenceContext(unitName = "viajesPU")  
  protected EntityManager em; 
  
  public CiudadEntity find(Long id){
     return em.find(CiudadEntity.class, id);      
  }
  
  public List<CiudadEntity> findAll(){
      Query q = em.createQuery("Select u from CiudadEntity u");
      return q.getResultList();
  }
  
  public CiudadEntity create(CiudadEntity entity){
      em.persist(entity);
      return entity;
  }
  
  public CiudadEntity update(CiudadEntity entity){
      return em.merge(entity);
  }
  
  public void delete(Long id){
      CiudadEntity entity = em.find(CiudadEntity.class, id);
      em.remove(entity);
  }
    
    
    
}
