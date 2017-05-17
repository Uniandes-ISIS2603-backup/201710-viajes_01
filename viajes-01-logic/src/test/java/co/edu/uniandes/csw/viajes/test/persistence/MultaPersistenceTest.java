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

import co.edu.uniandes.csw.viajes.entities.MultaEntity;
import co.edu.uniandes.csw.viajes.persistence.MultaPersistence;
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

@RunWith(Arquillian.class)
public class MultaPersistenceTest {
    
    public static final String DEPLOY = "Prueba";
    
     private static final double VALOR = 1e-15;
    
 @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(MultaEntity.class.getPackage())
                .addPackage(MultaPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    @Inject
    private MultaPersistence multaPersistence;

    @PersistenceContext
    private EntityManager em;

    @Inject
    UserTransaction utx;

    /**
     * Configuración inicial de la prueba.
     *
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
     */
    private void clearData() {
        em.createQuery("delete from MultaEntity").executeUpdate();
    }

    private List<MultaEntity> data = new ArrayList<MultaEntity>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PodamFactory factory = new PodamFactoryImpl();
            MultaEntity entity = factory.manufacturePojo(MultaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear una multa
     *
     */
    @Test
    public void createMultaTest() {
        try{
            PodamFactory factory = new PodamFactoryImpl();
        MultaEntity newEntity = factory.manufacturePojo(MultaEntity.class);
        MultaEntity result = multaPersistence.create(newEntity);

        Assert.assertNotNull(result);

        MultaEntity entity = em.find(MultaEntity.class, result.getId());

        Assert.assertEquals(result.getValor(), entity.getValor(), VALOR);
        Assert.assertEquals(result.getDescripcion(), entity.getDescripcion());
        Assert.assertEquals(result.getEstado(), entity.getEstado());
        }
        catch(Exception e){
            System.out.println("Error en la prueba para crear una multa" + e.getMessage());
        }
    }

    /**
     * Prueba para consultar la lista de Multa.
     *
     */
    @Test
    public void getMultasTest() {
        try{
        List<MultaEntity> list = multaPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (MultaEntity ent : list) {
            boolean found = false;
            for (MultaEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
        }
        catch(Exception e){
             System.out.println("ERROR EN GET MULTAS" + e.getMessage());
        }
    }

    /**
     * Prueba para consultar un Multa.
     *
     */
    @Test
    public void getMultaTest() {
        try{
            MultaEntity entity = data.get(0);
            MultaEntity newEntity = multaPersistence.find(entity.getId());
            Assert.assertNotNull(newEntity);
            Assert.assertEquals(entity.getValor(), newEntity.getValor(), VALOR);
            Assert.assertEquals(entity.getDescripcion(), newEntity.getDescripcion());
            Assert.assertEquals(newEntity.getEstado(), entity.getEstado());     
        }
        catch(Exception e){
             System.out.println("Error en getMultaTest: " + e.getMessage());
        }
    }

    /**
     * Prueba para eliminar una multa.
     *
     */
    @Test
    public void deleteMultaTest() {
        try{
        MultaEntity entity = data.get(0);
        multaPersistence.delete(entity.getId());
        MultaEntity deleted = em.find(MultaEntity.class, entity.getId());
        Assert.assertNull(deleted);
        }
        catch(Exception e){
             System.out.println("Error en la prueba de elimina una multa" + e.getMessage());
        }
    }

    /**
     * Prueba para actualizar una multa.
     *
     */
    @Test
    public void updateMultaTest() {
        try{
            MultaEntity entity = data.get(0);
            PodamFactory factory = new PodamFactoryImpl();
            MultaEntity newEntity = factory.manufacturePojo(MultaEntity.class);
            newEntity.setId(entity.getId());

            multaPersistence.update(newEntity);
            
            MultaEntity resp = em.find(MultaEntity.class, entity.getId());

            Assert.assertEquals(newEntity.getValor(), resp.getValor(), VALOR);
            Assert.assertEquals(newEntity.getDescripcion(), resp.getDescripcion());       
            Assert.assertEquals(newEntity.getEstado(), resp.getEstado());
        }
        catch(Exception e){
            System.out.println("Error en MultaPersistenceTest - updateMultaTest: " + e.getMessage());
        }
        
            

        
    }
    
}