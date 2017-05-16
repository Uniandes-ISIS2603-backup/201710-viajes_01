/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.test.logic;

import co.edu.uniandes.csw.viajes.ejbs.MultaLogic;
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
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(Arquillian.class)
public class MultaLogicTest {
  
    public static final String DEPLOY = "Prueba";
    
    private static final double VALOR = 1e-15;

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(MultaEntity.class.getPackage())
                .addPackage(MultaLogic.class.getPackage())
                .addPackage(MultaPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private MultaPersistence multaPersistence;
    
    @Inject
    private MultaLogic multaLogic;

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
        em.createQuery("delete from MultaEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<MultaEntity> data = new ArrayList<MultaEntity>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     * @generated
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
     * Prueba para crear una Multa.
     *
     * @generated
     */
    @Test
    public void createMultaTest() {
        try{
        PodamFactory factory = new PodamFactoryImpl();
        MultaEntity newEntity = factory.manufacturePojo(MultaEntity.class);
        MultaEntity result = multaPersistence.create(newEntity);

        //Assert.assertNotNull(result);

        MultaEntity entity = em.find(MultaEntity.class, result.getId());

        Assert.assertEquals(result.getValor(), entity.getValor(), VALOR);
        Assert.assertEquals(result.getFecha(), entity.getFecha());
        Assert.assertEquals(result.getDescripcion(), entity.getDescripcion());
        Assert.assertEquals(result.getEstado(), entity.getEstado());
        Assert.assertEquals(result.getFechaPago(), entity.getFechaPago());  
        }
        catch(Exception e)
        {
             System.out.println("Error en la prueba de logica de crear una multa: " + e.getMessage());
        }
    }

    /**
     * Prueba para consultar la lista de Multas.
     *
     * @generated
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
           System.out.println("Error en getMultasTest de logicTest" + e.getMessage());
       }
    }

    /**
     * Prueba para consultar una Multa.
     *
     */
    @Test
    public void getMultaTest() {
        MultaEntity entity = data.get(0);
        MultaEntity newEntity = multaPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getValor(), newEntity.getValor(), VALOR);
        Assert.assertEquals(entity.getFecha(), newEntity.getFecha());
        Assert.assertEquals(entity.getDescripcion(), newEntity.getDescripcion());
        Assert.assertEquals(entity.getEstado(), newEntity.getEstado());
        Assert.assertEquals(entity.getFechaPago(), newEntity.getFechaPago());
    }

    /**
     * Prueba para eliminar una Multa.
     *
     */
    @Test
    public void deleteMultaTest() {
       try{
        MultaEntity entity = data.get(0);
        multaLogic.deleteMulta(entity.getId());
        MultaEntity deleted = em.find(MultaEntity.class, entity.getId());
        Assert.assertNull(deleted);
       }
       catch(Exception e){
           System.out.println("Error en la prueba de logica de eliminar una multa: " + e.getMessage());
       }
    }

    /**
     * Prueba para actualizar una Multa.
     *
     */
    @Test
    public void updateMultaTest() {
        try{
        MultaEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        MultaEntity pojoEntity = factory.manufacturePojo(MultaEntity.class);
        pojoEntity.setId(entity.getId());

        multaLogic.updateMulta(pojoEntity);

        MultaEntity resp = em.find(MultaEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getValor(), resp.getValor(), VALOR);
        Assert.assertEquals(pojoEntity.getFecha(), resp.getFecha());
        Assert.assertEquals(pojoEntity.getDescripcion(), resp.getDescripcion());
        Assert.assertEquals(pojoEntity.getEstado(), resp.getEstado());
        Assert.assertEquals(pojoEntity.getFechaPago(), resp.getFechaPago());
        }
        catch(Exception e){
             System.out.println("Error en la prueba de logica de actualizar una multa: " + e.getMessage());
        }
       
    }
    
}
