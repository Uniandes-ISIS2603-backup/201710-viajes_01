/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.test.logic;

import co.edu.uniandes.csw.viajes.ejbs.ReservaLogic;
import co.edu.uniandes.csw.viajes.entities.ReservaEntity;
import co.edu.uniandes.csw.viajes.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.viajes.persistence.ReservaPersistence;
import com.sun.source.tree.AssertTree;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author ja.chavarriaga908
 */
@RunWith(Arquillian.class)
public class ReservaLogicTest{

  @Inject
  ReservaLogic reservaLogic;

  @Inject
  ReservaPersistence reservaPersistence;
  
  private static final double DELTA = 1e-15;

  @PersistenceContext(unitName = "viajesPU")
  protected EntityManager em;

  @Inject
  UserTransaction utx;

  @Deployment
  public static JavaArchive creaDespliege() {
    JavaArchive archive = ShrinkWrap.create(JavaArchive.class)
            .addPackage(ReservaEntity.class.getPackage())
            .addPackage(ReservaPersistence.class.getPackage())
            .addPackage(ReservaLogic.class.getPackage())
            .addPackage(BusinessLogicException.class.getPackage())
            .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
            .addAsManifestResource("META-INF/beans.xml", "beans.xml")
            .addAsManifestResource("META-INF/logging.properties", "logging.properties");
    return archive;
  }

  @Before
  @SuppressWarnings("UseSpecificCatch")
  public void configTest(){
    try {
      utx.begin();
      em.joinTransaction();
      clearData();
      insertData();
      utx.commit();
    } catch (Exception e){
      try {
        utx.rollback();
      } catch (Exception e1) {
        
      }
    }
  }

  /**
     * Limpia las tablas que están implicadas en la prueba.
     *
     * @generated
     */
    private void clearData() {
        em.createQuery("delete from ReservaEntity").executeUpdate();
    }

  private List<ReservaEntity> data = new ArrayList<>();

  // inserta datos de prueba en las tablas
  private void insertData() {
    PodamFactory factory = new PodamFactoryImpl();

    // crea reservas en la base de datos
        for (int i = 0; i < 3; i++) {
      // crea una reserva de prueba
      ReservaEntity entity = factory.manufacturePojo(ReservaEntity.class);
      /*
      // asigna la fecha inicio y final
      entity.setFechaInicio(hoy);
      entity.setFechaFinal(agregaDias(hoy, 5));
      // asigna cliente y salon
      entity.setCliente(clienteEnBaseDatos);
      entity.setSalon(salonEnBaseDatos);
      */

      em.persist(entity);
      data.add(entity);
    }
  }

  // Pruebas
  // =======  
  /*
     * Prueba para agregar una reserva
   */
  @Test
  public void agregarReserva() {

    // crear una reserva de prueba   
    PodamFactory factory = new PodamFactoryImpl();

    try {
      // crea una reserva de prueba
      ReservaEntity reserva = factory.manufacturePojo(ReservaEntity.class);
      
      reserva.setPasajeros(4);
      reserva.setPrecio(20000.0);
      reserva.setComision(100.0);
      // asigna la fecha inicio y final

      // almacena la reserva usando la lógica de negocio
      ReservaEntity resultado = reservaLogic.createReserva(reserva);

      // verifica que los datos coincidan
      Assert.assertEquals(reserva.getPasajeros(), resultado.getPasajeros());
      Assert.assertEquals(reserva.getPrecio(), resultado.getPrecio(), DELTA);
      Assert.assertEquals(reserva.getComision(), resultado.getComision(), DELTA);
      
    } catch (Exception e) {
        
    }
  }
  
  @Test
  public void agregarReservaPasajerosIncorrectos() {

    // crear una reserva de prueba   
    PodamFactory factory = new PodamFactoryImpl();

    try {
      // crea una reserva de prueba
      ReservaEntity reserva = factory.manufacturePojo(ReservaEntity.class);
      
      reserva.setPasajeros(-4);
      reserva.setPrecio(20000.0);
      reserva.setComision(100.0);
      // asigna la fecha inicio y final

      // almacena la reserva usando la lógica de negocio
      reservaLogic.createReserva(reserva);
      
      Assert.fail("El metodo debe lanzar excepcion ya que la reserva tiene cantidad de pasajeros negativo");
      // verifica que los datos coincidan
      
    } catch (Exception e) {
        
    }
  }
  
   @Test
  public void agregarReservaPrecioIncorrecto() {

    // crear una reserva de prueba   
    PodamFactory factory = new PodamFactoryImpl();

    try {
      // crea una reserva de prueba
      ReservaEntity reserva = factory.manufacturePojo(ReservaEntity.class);
      
      reserva.setPasajeros(4);
      reserva.setPrecio(-20000.0);
      reserva.setComision(100.0);
      // asigna la fecha inicio y final

      // almacena la reserva usando la lógica de negocio
      reservaLogic.createReserva(reserva);
      
      Assert.fail("El metodo debe lanzar excepcion ya que la reserva tiene cantidad de pasajeros negativo");
      // verifica que los datos coincidan
      
    } catch (Exception e) {
        
    }
  }
  
  @Test
  public void darReservas() {

    try {
      List<ReservaEntity> retornado = reservaLogic.getReservas();
      for(ReservaEntity r1 : retornado){
          boolean encontrado = false;
          for(ReservaEntity r2 : data){
              encontrado |= r1.getId().equals(r2.getId());
          }
          Assert.assertTrue(encontrado);
      }

    } catch (Exception e) {
      Assert.fail("Excepcion no esperada : " + e.getMessage());
    }
  }
  
  @Test
  public void darReserva() {

    try {
        ReservaEntity entity = data.get(0);
        ReservaEntity resultEntity = reservaLogic.getReserva(entity.getId());
        
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getPasajeros(), resultEntity.getPasajeros());
        Assert.assertEquals(entity.getPrecio(), resultEntity.getPrecio(), DELTA);
        Assert.assertEquals(entity.getComision(), resultEntity.getComision(), DELTA);

    } catch (Exception e) {
      
    }
  }
  
    @Test
    public void deleteReservaIdNuloTest() {
        try {
        reservaLogic.deleteReserva(null);
        Assert.fail("El metodo debe lanzar excepcion porque el id de la reserva a eliminar es nulo");
        } catch (Exception e) {
        }
        
    }
    
    @Test
    public void deleteReservaTest() {
        try {
            ReservaEntity entity = data.get(0);
        reservaLogic.deleteReserva(entity.getId());
        ReservaEntity deleted = em.find(ReservaEntity.class, entity.getId());
        Assert.assertNull(deleted);
        } catch (Exception e) {
        }
        
    }
    
    @Test
    public void updateReservaTest() {
        try {
        ReservaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ReservaEntity pojoEntity = factory.manufacturePojo(ReservaEntity.class);
        pojoEntity.setId(entity.getId());

        reservaLogic.updateReserva(pojoEntity);

        ReservaEntity resp = em.find(ReservaEntity.class, entity.getId());
        
        
        Assert.assertNotNull(resp);
        Assert.assertEquals(entity.getPasajeros(), pojoEntity.getPasajeros());
        Assert.assertEquals(entity.getPrecio(), pojoEntity.getPrecio(), DELTA);
        Assert.assertEquals(entity.getComision(), pojoEntity.getComision(), DELTA);
        } catch (Exception e) {
        }
    
    }

}
