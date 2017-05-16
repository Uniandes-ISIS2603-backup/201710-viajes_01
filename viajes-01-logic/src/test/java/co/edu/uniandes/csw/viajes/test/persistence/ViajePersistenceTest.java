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

import co.edu.uniandes.csw.viajes.entities.ViajeEntity;
import co.edu.uniandes.csw.viajes.persistence.ViajePersistence;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class ViajePersistenceTest {

    public static final String DEPLOY = "Prueba";

    private static final double DELTA = 1e-15;
    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(ViajeEntity.class.getPackage())
                .addPackage(ViajePersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private ViajePersistence viajePersistence;

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
        em.createQuery("delete from ViajeEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<ViajeEntity> data = new ArrayList<ViajeEntity>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PodamFactory factory = new PodamFactoryImpl();
            ViajeEntity entity = factory.manufacturePojo(ViajeEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear un Book.
     *
     * @generated
     */
    @Test
    public void createBookTest() {
        PodamFactory factory = new PodamFactoryImpl();
        ViajeEntity newEntity = factory.manufacturePojo(ViajeEntity.class);
        ViajeEntity result = viajePersistence.create(newEntity);

        Assert.assertNotNull(result);

        ViajeEntity entity = em.find(ViajeEntity.class, result.getId());

        Assert.assertEquals(result.getCiudadDestino(), entity.getCiudadDestino());
        Assert.assertEquals(result.getCiudadOrigen(), entity.getCiudadOrigen());
        Assert.assertEquals(result.getDireccionDejar(), entity.getDireccionDejar());
        Assert.assertEquals(result.getDireccionRecoger(), entity.getDireccionRecoger());
        Assert.assertEquals(result.getGastoGasolina(), entity.getGastoGasolina(),DELTA);
        Assert.assertEquals(result.getGastoOtros(), entity.getGastoOtros(),DELTA);
        Assert.assertEquals(result.getGastoPeaje(), entity.getGastoPeaje(),DELTA);
        Assert.assertEquals(result.getKilometros(), entity.getKilometros(),DELTA);
        Assert.assertEquals(result.getNumPasajeros(), entity.getNumPasajeros(),DELTA);

    }

    /**
     * Prueba para consultar la lista de Books.
     *
     * @generated
     */
    @Test
    public void getCiudadesTest() {
        List<ViajeEntity> list = viajePersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (ViajeEntity ent : list) {
            boolean found = false;
            for (ViajeEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un Book.
     *
     * @generated
     */
    @Test
    public void getViajeTest() {
        ViajeEntity entity = data.get(0);
        ViajeEntity newEntity = viajePersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(newEntity.getCiudadDestino(), entity.getCiudadDestino());
        Assert.assertEquals(newEntity.getCiudadOrigen(), entity.getCiudadOrigen());
        Assert.assertEquals(newEntity.getDireccionDejar(), entity.getDireccionDejar());
        Assert.assertEquals(newEntity.getDireccionRecoger(), entity.getDireccionRecoger());
        Assert.assertEquals(newEntity.getGastoGasolina(), entity.getGastoGasolina(),DELTA);
        Assert.assertEquals(newEntity.getGastoOtros(), entity.getGastoOtros(),DELTA);
        Assert.assertEquals(newEntity.getGastoPeaje(), entity.getGastoPeaje(),DELTA);
        Assert.assertEquals(newEntity.getKilometros(), entity.getKilometros(),DELTA);
        Assert.assertEquals(newEntity.getNumPasajeros(), entity.getNumPasajeros(),DELTA);
    }

    /**
     * Prueba para eliminar un Book.
     *
     * @generated
     */
    @Test
    public void deleteViajeTest() {
        ViajeEntity entity = data.get(0);
        viajePersistence.delete(entity.getId());
        ViajeEntity deleted = em.find(ViajeEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un Book.
     *
     * @generated
     */
    @Test
    public void updateCiudadTest() {
        ViajeEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ViajeEntity newEntity = factory.manufacturePojo(ViajeEntity.class);
        newEntity.setId(entity.getId());

        viajePersistence.update(newEntity);

        ViajeEntity resp = em.find(ViajeEntity.class, entity.getId());

        Assert.assertEquals(resp.getCiudadDestino(), newEntity.getCiudadDestino());
        Assert.assertEquals(resp.getCiudadOrigen(), newEntity.getCiudadOrigen());
        Assert.assertEquals(resp.getDireccionDejar(), newEntity.getDireccionDejar());
        Assert.assertEquals(resp.getDireccionRecoger(), newEntity.getDireccionRecoger());
        Assert.assertEquals(resp.getGastoGasolina(), newEntity.getGastoGasolina(),DELTA);
        Assert.assertEquals(resp.getGastoOtros(), newEntity.getGastoOtros(),DELTA);
        Assert.assertEquals(resp.getGastoPeaje(), newEntity.getGastoPeaje(),DELTA);
        Assert.assertEquals(resp.getKilometros(), newEntity.getKilometros(),DELTA);
        Assert.assertEquals(resp.getNumPasajeros(), newEntity.getNumPasajeros(),DELTA);
    }
}


