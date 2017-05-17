	/* 
 * The MIT License
 *
 * Copyright 2017 ca.nieto11.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package co.edu.uniandes.csw.viajes.test.persistence;

import co.edu.uniandes.csw.viajes.entities.ReservaEntity;
import co.edu.uniandes.csw.viajes.persistence.ReservaPersistence;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class ReservaPersistenceTest {

    public static final String DEPLOY = "Prueba";

    private static final double DELTA = 1e-15;
    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(ReservaEntity.class.getPackage())
                .addPackage(ReservaPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private ReservaPersistence reservaPersistence;

    /**
     * @generated
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * @generated
     */
    @Inject
    UserTransaction utx;

    /**
     * Configuración inicial de la prueba.
     *
     * @generated
     */
   @Before
    public void configTest() {
        try {
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
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

    /**
     * @generated
     */
    private List<ReservaEntity> data = new ArrayList<ReservaEntity>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PodamFactory factory = new PodamFactoryImpl();
            ReservaEntity entity = factory.manufacturePojo(ReservaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    @Test
    public void crearReservaTest() {
        try{
        PodamFactory factory = new PodamFactoryImpl();
        ReservaEntity newEntity = factory.manufacturePojo(ReservaEntity.class);
        ReservaEntity result = reservaPersistence.create(newEntity);
        
        Assert.assertNotNull("al grabar no retornó objeto",
            result);

        ReservaEntity entity = em.find(ReservaEntity.class, result.getId());
        
        Assert.assertEquals("no retorna los mismos datos grabados", newEntity.getPrecio(), entity.getPrecio(), DELTA);
        Assert.assertEquals("no retorna los mismos datos grabados", newEntity.getComision(), entity.getComision(), DELTA);
        Assert.assertEquals("no retorna los mismos datos grabados", newEntity.getPasajeros(), entity.getPasajeros());
        }catch(Exception e){
            
        }
    }
    
    /*
     * Prueba para consultar todas las reservas
   */
    @Test
    public void obtenerTodasLasReservas() {
        // TODO: Quitar el Assert.fail()
        try{
        List<ReservaEntity> list = reservaPersistence.findAll();
        for(ReservaEntity r1 : list) {
            boolean enc = false;
            for (ReservaEntity r2 : data) {
                enc |= r1.getId().equals(r2.getId());
            }
            Assert.assertTrue(enc);
        }
        }catch(Exception e){
            
        }
    }

    @Test
    public void obtenerUnaReserva() {
    try{
    ReservaEntity resPrueba = data.get(1);
    ReservaEntity ret = reservaPersistence.find(resPrueba.getId());
    Assert.assertEquals("La reserva retornada no es la buscada",
            resPrueba.getId(),
            ret.getId());
    }catch(Exception e){
     
    }
  }
    
    /*
     * Prueba para eliminar una reserva
   */
  @Test
  public void eliminarReserva() {
    try{
    ReservaEntity resPrueba = data.get(1);
    long idPrueba = resPrueba.getId();
    
    reservaPersistence.delete(idPrueba);
    ReservaEntity ret = em.find(ReservaEntity.class, idPrueba);
    Assert.assertNull("No elimino la reserva", ret);
    }catch(Exception e){
        
    }
  }
}


