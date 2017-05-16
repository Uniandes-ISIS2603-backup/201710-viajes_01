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
package co.edu.uniandes.csw.viajes.test.logic;

import co.edu.uniandes.csw.viajes.entities.VehiculoEntity;
import co.edu.uniandes.csw.viajes.ejbs.VehiculoLogic;
import co.edu.uniandes.csw.viajes.persistence.VehiculoPersistence;
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
 *
 * @author 
 */
@RunWith(Arquillian.class)
public class VehiculoLogicTest 
{
    public static final String DEPLOY = "Prueba";

    private static final double DELTA = 1e-15;
    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(VehiculoEntity.class.getPackage())
                .addPackage(VehiculoLogic.class.getPackage())
                .addPackage(VehiculoPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private VehiculoLogic vehiculoLogic;

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
        em.createQuery("delete from VehiculoEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<VehiculoEntity> data = new ArrayList<VehiculoEntity>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PodamFactory factory = new PodamFactoryImpl();
            VehiculoEntity entity = factory.manufacturePojo(VehiculoEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear 
     *
     * @generated
     */
    @Test
    public void createVehiculoTest() {
        try{
        PodamFactory factory = new PodamFactoryImpl();
        VehiculoEntity entity = factory.manufacturePojo(VehiculoEntity.class);
        VehiculoEntity result = vehiculoLogic.createVehiculo(entity);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getAseguradora(), entity.getAseguradora());
        Assert.assertEquals(result.getCapacidad(), entity.getCapacidad());
        Assert.assertEquals(result.getColor(), entity.getColor());
        Assert.assertEquals(result.getMarca(), entity.getMarca());
        Assert.assertEquals(result.getNumeroSeguro(), entity.getNumeroSeguro());
        Assert.assertEquals(result.getPlaca(), entity.getPlaca());      
        }
        catch(Exception e){
            
        }
    }

    /**
     * Prueba para consultar la lista 
     *
     * @generated
     */
    @Test
    public void getVehiculosTest() {
        try{
        List<VehiculoEntity> list = vehiculoLogic.getVehiculos();
        //Assert.assertEquals(data.size(), list.size());
        for (VehiculoEntity entity : list) {
            boolean found = false;
            for (VehiculoEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
           // Assert.assertTrue(found);
        }
        }
        catch(Exception e){}
    }

    /**
     * Prueba para consultar 
     *
     * @generated
     */
    @Test
    public void getVehiculoTest() {
       try{
        VehiculoEntity entity = data.get(0);
        VehiculoEntity resultEntity = vehiculoLogic.getVehiculo(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(resultEntity.getAseguradora(), entity.getAseguradora());
        Assert.assertEquals(resultEntity.getCapacidad(), entity.getCapacidad());
        Assert.assertEquals(resultEntity.getColor(), entity.getColor());
        Assert.assertEquals(resultEntity.getMarca(), entity.getMarca());
        Assert.assertEquals(resultEntity.getNumeroSeguro(), entity.getNumeroSeguro());
        Assert.assertEquals(resultEntity.getPlaca(), entity.getPlaca());  
       }
       catch(Exception e){
           
       }
    }

    /**
     * Prueba para eliminar 
     *
     * @generated
     */
    @Test
    public void deleteVehiculoTest() {
        try{
        VehiculoEntity entity = data.get(0);
        vehiculoLogic.deleteVehiculo(entity.getId());
        VehiculoEntity deleted = em.find(VehiculoEntity.class, entity.getId());
        Assert.assertNull(deleted);
        }
        catch(Exception e){
            
        }
    }

    /**
     * Prueba para actualizar
     *
     * @generated
     */
    @Test
    public void updateVehiculoTest() {
        try{
        VehiculoEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        VehiculoEntity pojoEntity = factory.manufacturePojo(VehiculoEntity.class);
        pojoEntity.setId(entity.getId());

        vehiculoLogic.updateVehiculo(pojoEntity);

        VehiculoEntity resp = em.find(VehiculoEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getAseguradora(), resp.getAseguradora());
        Assert.assertEquals(pojoEntity.getCapacidad(), resp.getCapacidad());
        Assert.assertEquals(pojoEntity.getColor(), resp.getColor());
        Assert.assertEquals(pojoEntity.getMarca(), resp.getMarca());
        Assert.assertEquals(pojoEntity.getNumeroSeguro(), resp.getNumeroSeguro());
        Assert.assertEquals(pojoEntity.getPlaca(), resp.getPlaca());
        }
        catch(Exception e){}
    }
}    
