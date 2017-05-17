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

  private List<ReservaEntity> reservasEnBaseDatos = new ArrayList<>();

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
      reservasEnBaseDatos.add(entity);
    }
  }

  // Pruebas
  // =======  
  /*
     * Prueba para agregar una reserva
   */
  @Test
  public void agregaReserva() {

    // crear una reserva de prueba   
    PodamFactory factory = new PodamFactoryImpl();

    try {
      // crea una reserva de prueba
      ReservaEntity reserva = factory.manufacturePojo(ReservaEntity.class);
      // asigna la fecha inicio y final

      // almacena la reserva usando la lógica de negocio
      ReservaEntity resultado = reservaLogic.createReserva(reserva);

      // verifica que los datos coincidan
      Assert.assertEquals(reserva.getPasajeros(), resultado.getPasajeros());

    } catch (Exception e) {
      Assert.fail("Excepcion no esperada : " + e.getMessage());
    }
  }

  /*
   * Prueba agregando una reserva con la misma fecha de inicio y fin
   */
  @Test
  public void agregaReservaConMismaFechaInicioYFinal() {
    // TODO: Quitar el Assert.fail()
     // TODO: crear una reserva de prueba
    // TODO: asignar un cliente y un salon que existe en la base de datos
    
    // TODO: asignar fecha de inicio y fecha final iguales
    // TODO: almacena la reserva usando la lógica de negocio
    // TODO: debe ocurrir una excepción
    
    // crear una reserva de prueba   
    PodamFactory factory = new PodamFactoryImpl();

    try {
      // crea una reserva de prueba
      ReservaEntity reserva = factory.manufacturePojo(ReservaEntity.class);
      // asigna la fecha inicio y final

      // almacena la reserva usando la lógica de negocio
      ReservaEntity resultado = reservaLogic.createReserva(reserva);

      // verifica que los datos coincidan
      Assert.assertEquals(reserva.getPasajeros(), resultado.getPasajeros());

    } catch (Exception e) {
      
    }
  }

  /*
   * Prueba agregando una reserva con fecha de inicio mayor a fecha final
   */
  @Test
  public void agregaReservaConFechaInicioMayorAFinal() {
    // TODO: Quitar el Assert.fail()
    // TODO: crear una reserva de prueba
    // TODO: asignar un cliente y un salon que existe en la base de datos
    // TODO: asignar fecha de inicio mayor a la fecha final
    // TODO: almacena la reserva usando la lógica de negocio
    // TODO: debe ocurrir una excepción
    
    // crear una reserva de prueba   
    PodamFactory factory = new PodamFactoryImpl();
    Date hoy = new Date();

    try {
      // crea una reserva de prueba
      Reserva reserva = factory.manufacturePojo(Reserva.class);
      // asigna la fecha inicio y final
      reserva.setFechaInicio(agregaDias(hoy, 5));
      reserva.setFechaFinal(hoy);
      // asigna cliente y salon que existen en la base de datos
      reserva.setCliente(clienteEnBaseDatos);
      reserva.setSalon(salonEnBaseDatos);

      // almacena la reserva usando la lógica de negocio
      Reserva resultado = reservaLogic.create(reserva);
      
      Assert.fail("EL metodo debe lanzar excepcion");

      // verifica que los datos coincidan
      Assert.assertEquals(reserva.getDescripcion(), resultado.getDescripcion());
      Assert.assertEquals(reserva.getCliente(), resultado.getCliente());
      Assert.assertEquals(reserva.getSalon(), resultado.getSalon());

    } catch (Exception e) {
      
    }
  }

  /*
   * Prueba agregando una reserva con un cliente que no existen en la base datos
   */
  @Test
  public void agregaReservaConClienteQueNoExiste() {
    // TODO: Quitar el Assert.fail()

    // TODO: crear una reserva de prueba
    // TODO: asignar un cliente que no existe en la base de datos
    // TODO: asignar un salon que existe en la base de datos
    // TODO: asignar fecha de inicio mayor a la fecha final
    // TODO: almacena la reserva usando la lógica de negocio
    // TODO: debe ocurrir una excepción
    
    // crear una reserva de prueba   
    PodamFactory factory = new PodamFactoryImpl();
    Date hoy = new Date();

    try {
      // crea una reserva de prueba
      Reserva reserva = factory.manufacturePojo(Reserva.class);
      // asigna la fecha inicio y final
      reserva.setFechaInicio(hoy);
      reserva.setFechaFinal(agregaDias(hoy, 5));
      
      Cliente clienteNoEnBD = factory.manufacturePojo(Cliente.class);
      // asigna cliente y salon que existen en la base de datos
      reserva.setCliente(clienteNoEnBD);
      reserva.setSalon(salonEnBaseDatos);

      // almacena la reserva usando la lógica de negocio
      Reserva resultado = reservaLogic.create(reserva);
      
      Assert.fail("El metodo debe lanzar excepcion");

      // verifica que los datos coincidan
      Assert.assertEquals(reserva.getDescripcion(), resultado.getDescripcion());
      Assert.assertEquals(reserva.getCliente(), resultado.getCliente());
      Assert.assertEquals(reserva.getSalon(), resultado.getSalon());

    } catch (Exception e) {
      
    }
  }
  
  /*
   * Prueba agregando una reserva con un cliente que no existen en la base datos
   */
  @Test
  public void agregaReservaConClienteEnNull() {
    // TODO: Quitar el Assert.fail()

    // TODO: crear una reserva de prueba
    // TODO: asignar null como cliente
    // TODO: asignar un salon que existe en la base de datos
    // TODO: asignar fecha de inicio mayor a la fecha final
    // TODO: almacena la reserva usando la lógica de negocio
    // TODO: debe ocurrir una excepción
    
    // crear una reserva de prueba   
    PodamFactory factory = new PodamFactoryImpl();
    Date hoy = new Date();

    try {
      // crea una reserva de prueba
      Reserva reserva = factory.manufacturePojo(Reserva.class);
      // asigna la fecha inicio y final
      reserva.setFechaInicio(hoy);
      reserva.setFechaFinal(agregaDias(hoy, 5));
      
      // asigna cliente y salon que existen en la base de datos
      reserva.setCliente(null);
      reserva.setSalon(salonEnBaseDatos);

      // almacena la reserva usando la lógica de negocio
      Reserva resultado = reservaLogic.create(reserva);
      
      Assert.fail("El metodo debe lanzar excepcion");

      // verifica que los datos coincidan
      Assert.assertEquals(reserva.getDescripcion(), resultado.getDescripcion());
      Assert.assertEquals(reserva.getCliente(), resultado.getCliente());
      Assert.assertEquals(reserva.getSalon(), resultado.getSalon());

    } catch (Exception e) {
      
    }
  }

  /*
   * Prueba agregando una reserva con un salón que no existen en la base datos
   */
  @Test
  public void agregaReservaConSalonQueNoExiste() {
    // TODO: Quitar el Assert.fail()
    // TODO: crear una reserva de prueba
    // TODO: asignar un cliente que existe en la base de datos
    // TODO: asignar un salon que no existe en la base de datos
    // TODO: asignar fecha de inicio mayor a la fecha final
    // TODO: almacena la reserva usando la lógica de negocio
    // TODO: debe ocurrir una excepción
    
    // crear una reserva de prueba   
    PodamFactory factory = new PodamFactoryImpl();
    Date hoy = new Date();

    try {
      // crea una reserva de prueba
      Reserva reserva = factory.manufacturePojo(Reserva.class);
      // asigna la fecha inicio y final
      reserva.setFechaInicio(hoy);
      reserva.setFechaFinal(agregaDias(hoy, 5));
      
      Salon salon = factory.manufacturePojo(Salon.class);
      // asigna cliente y salon que existen en la base de datos
      reserva.setCliente(clienteEnBaseDatos);
      reserva.setSalon(salon);

      // almacena la reserva usando la lógica de negocio
      Reserva resultado = reservaLogic.create(reserva);
      
      Assert.fail("El metodo debe lanzar excepcion");

      // verifica que los datos coincidan
      Assert.assertEquals(reserva.getDescripcion(), resultado.getDescripcion());
      Assert.assertEquals(reserva.getCliente(), resultado.getCliente());
      Assert.assertEquals(reserva.getSalon(), resultado.getSalon());

    } catch (Exception e) {
      
    }
  }
  
  /*
   * Prueba agregando una reserva con un salón que no existen en la base datos
   */
  @Test
  public void agregaReservaConSalonEnNull() {
    // TODO: Quitar el Assert.fail()
     // TODO: crear una reserva de prueba
    // TODO: asignar un cliente que existe en la base de datos
    // TODO: asignar null al salon
    // TODO: asignar fecha de inicio mayor a la fecha final
    // TODO: almacena la reserva usando la lógica de negocio
    // TODO: debe ocurrir una excepción
    
    // crear una reserva de prueba   
    PodamFactory factory = new PodamFactoryImpl();
    Date hoy = new Date();

    try {
      // crea una reserva de prueba
      Reserva reserva = factory.manufacturePojo(Reserva.class);
      // asigna la fecha inicio y final
      reserva.setFechaInicio(hoy);
      reserva.setFechaFinal(agregaDias(hoy, 5));
      
      // asigna cliente y salon que existen en la base de datos
      reserva.setCliente(clienteEnBaseDatos);
      reserva.setSalon(null);

      // almacena la reserva usando la lógica de negocio
      Reserva resultado = reservaLogic.create(reserva);
      
      Assert.fail("El metodo debe lanzar excepcion");

      // verifica que los datos coincidan
      Assert.assertEquals(reserva.getDescripcion(), resultado.getDescripcion());
      Assert.assertEquals(reserva.getCliente(), resultado.getCliente());
      Assert.assertEquals(reserva.getSalon(), resultado.getSalon());

    } catch (Exception e) {
      
    }
  }  

}
