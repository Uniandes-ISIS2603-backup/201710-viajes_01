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

import co.edu.uniandes.csw.viajes.entities.CiudadEntity;
import co.edu.uniandes.csw.viajes.persistence.CiudadPersistence;
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
public class CiudadPersistenceTest {

    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(CiudadEntity.class.getPackage())
                .addPackage(CiudadPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private CiudadPersistence ciudadPersistence;

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
        em.createQuery("delete from CiudadEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<CiudadEntity> data = new ArrayList<CiudadEntity>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PodamFactory factory = new PodamFactoryImpl();
            CiudadEntity entity = factory.manufacturePojo(CiudadEntity.class);
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
       try{
        PodamFactory factory = new PodamFactoryImpl();
        CiudadEntity newEntity = factory.manufacturePojo(CiudadEntity.class);
        CiudadEntity result = ciudadPersistence.create(newEntity);

        Assert.assertNotNull(result);

        CiudadEntity entity = em.find(CiudadEntity.class, result.getId());

        Assert.assertEquals(newEntity.getNombre(), entity.getNombre());
       }
       catch(Exception e){}

    }

    /**
     * Prueba para consultar la lista de Books.
     *
     * @generated
     */
    @Test
    public void getCiudadesTest() {
      try{
        List<CiudadEntity> list = ciudadPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (CiudadEntity ent : list) {
            boolean found = false;
            for (CiudadEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
      }
      catch(Exception e){}
    }

    /**
     * Prueba para consultar un Book.
     *
     * @generated
     */
    @Test
    public void getCiudadTest() {
        try{
        CiudadEntity entity = data.get(0);
        CiudadEntity newEntity = ciudadPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getNombre(), newEntity.getNombre());
        }
        catch(Exception e){}
    }

    /**
     * Prueba para eliminar un Book.
     *
     * @generated
     */
    @Test
    public void deleteCiudadTest() {
        try{
        CiudadEntity entity = data.get(0);
        ciudadPersistence.delete(entity.getId());
        CiudadEntity deleted = em.find(CiudadEntity.class, entity.getId());
        Assert.assertNull(deleted);
        }catch(Exception e){}
    }

    /**
     * Prueba para actualizar un Book.
     *
     * @generated
     */
    @Test
    public void updateCiudadTest() {
        try{
        CiudadEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        CiudadEntity newEntity = factory.manufacturePojo(CiudadEntity.class);
        newEntity.setId(entity.getId());

        ciudadPersistence.update(newEntity);

        CiudadEntity resp = em.find(CiudadEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getNombre(), resp.getNombre());
        }catch(Exception e){}
    }
}

