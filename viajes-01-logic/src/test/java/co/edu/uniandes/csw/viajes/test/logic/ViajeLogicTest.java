/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.test.logic;

import co.edu.uniandes.csw.viajes.ejbs.ViajeLogic;
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
public class ViajeLogicTest {

    public static final String DEPLOY = "Prueba";

    private static final double DELTA = 1e-15;
    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(ViajeEntity.class.getPackage())
                .addPackage(ViajeLogic.class.getPackage())
                .addPackage(ViajePersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private ViajeLogic viajeLogic;

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
     * Prueba para crear un Viaje
     *
     * @generated
     */
    @Test
    public void createCiudadTest() {
        PodamFactory factory = new PodamFactoryImpl();
        ViajeEntity entity = factory.manufacturePojo(ViajeEntity.class);
        ViajeEntity result = viajeLogic.createViaje(entity);
        Assert.assertNotNull(result);
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
     * Prueba para consultar la lista de Viajes
     *
     * @generated
     */
    @Test
    public void getViajesTest() {
        List<ViajeEntity> list = viajeLogic.getViajes();
        Assert.assertEquals(data.size(), list.size());
        for (ViajeEntity entity : list) {
            boolean found = false;
            for (ViajeEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
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
        ViajeEntity resultEntity = viajeLogic.getViaje(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(resultEntity.getCiudadDestino(), entity.getCiudadDestino());
        Assert.assertEquals(resultEntity.getCiudadOrigen(), entity.getCiudadOrigen());
        Assert.assertEquals(resultEntity.getDireccionDejar(), entity.getDireccionDejar());
        Assert.assertEquals(resultEntity.getDireccionRecoger(), entity.getDireccionRecoger());
        Assert.assertEquals(resultEntity.getGastoGasolina(), entity.getGastoGasolina(),DELTA);
        Assert.assertEquals(resultEntity.getGastoOtros(), entity.getGastoOtros(),DELTA);
        Assert.assertEquals(resultEntity.getGastoPeaje(), entity.getGastoPeaje(),DELTA);
        Assert.assertEquals(resultEntity.getKilometros(), entity.getKilometros(),DELTA);
        Assert.assertEquals(resultEntity.getNumPasajeros(), entity.getNumPasajeros(),DELTA);
    }

    /**
     * Prueba para eliminar un Book.
     *
     * @generated
     */
    @Test
    public void deleteCiudadTest() {
        ViajeEntity entity = data.get(0);
        viajeLogic.deleteViaje(entity.getId());
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
        ViajeEntity pojoEntity = factory.manufacturePojo(ViajeEntity.class);
        pojoEntity.setId(entity.getId());

        viajeLogic.updateViaje(pojoEntity);

        ViajeEntity resp = em.find(ViajeEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getCiudadDestino(), resp.getCiudadDestino());
        Assert.assertEquals(pojoEntity.getCiudadOrigen(), resp.getCiudadOrigen());
        Assert.assertEquals(pojoEntity.getDireccionDejar(), resp.getDireccionDejar());
        Assert.assertEquals(pojoEntity.getDireccionRecoger(), resp.getDireccionRecoger());
        Assert.assertEquals(pojoEntity.getGastoGasolina(), resp.getGastoGasolina(),DELTA);
        Assert.assertEquals(pojoEntity.getGastoOtros(), resp.getGastoOtros(),DELTA);
        Assert.assertEquals(pojoEntity.getGastoPeaje(), resp.getGastoPeaje(),DELTA);
        Assert.assertEquals(pojoEntity.getKilometros(), resp.getKilometros(),DELTA);
        Assert.assertEquals(pojoEntity.getNumPasajeros(), resp.getNumPasajeros(),DELTA);
    }

}

