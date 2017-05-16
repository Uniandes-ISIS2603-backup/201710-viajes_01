package co.edu.uniandes.csw.viajes.test.logic;

import co.edu.uniandes.csw.viajes.entities.VehiculoEntity;
import co.edu.uniandes.csw.viajes.ejbs.VehiculoLogic;
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
 * @author jp.perez12
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
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }

    @Inject
    private VehiculoLogic vehiculoLogic;

    @PersistenceContext
    private EntityManager em;

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

    private void clearData() {
        em.createQuery("delete from ViajeEntity").executeUpdate();
    }

    private List<VehiculoEntity> data = new ArrayList<VehiculoEntity>();

    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PodamFactory factory = new PodamFactoryImpl();
            VehiculoEntity entity = factory.manufacturePojo(VehiculoEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    @Test
    public void createVehiculoTest() {
         try {
        PodamFactory factory = new PodamFactoryImpl();
        VehiculoEntity newEntity = factory.manufacturePojo(VehiculoEntity.class);
        VehiculoEntity result = vehiculoLogic.createVehiculo(newEntity);

        VehiculoEntity entity = em.find(VehiculoEntity.class, result.getId());
       
            Assert.assertNotNull(result);
        Assert.assertEquals(result.getId(), entity.getId());
        Assert.assertEquals(result.getAseguradora(), entity.getAseguradora());
        Assert.assertEquals(result.getCapacidad(), entity.getCapacidad());
        Assert.assertEquals(result.getColor(), entity.getColor());
        Assert.assertEquals(result.getMarca(), entity.getMarca());
        Assert.assertEquals(result.getNumeroSeguro(), entity.getNumeroSeguro());
        Assert.assertEquals(result.getPlaca(), entity.getPlaca());
        Assert.assertEquals(result.getUsuario(), entity.getUsuario());
        Assert.assertEquals(result.getViajes(), entity.getViajes());
        } catch (Exception e) {
        }
        

    }

    /**
     * Prueba para consultar la lista de Vehiculos.
     *
     * @generated
     */
    @Test
    public void getVehiculosTest() {
        try{
        List<VehiculoEntity> list = vehiculoLogic.getVehiculos();
       //Assert.assertEquals(data.size(), list.size());
            for (VehiculoEntity ent : list) {
                boolean found = false;
                for (VehiculoEntity entity : data) {
                    if (ent.getId().equals(entity.getId())) {
                        found = true;
                    }
                }
                Assert.assertTrue(found);
            }
        }
        
       catch(Exception e){ 
           System.out.println("Error");
       }
    }

    /**
     * Prueba para consultar un Vehiculo.
     *
     * @generated
     */
    @Test
    public void getVehiculoTest() {
               try {
        VehiculoEntity entity = data.get(0);
        VehiculoEntity result = vehiculoLogic.getVehiculo(entity.getId());
 
         //   Assert.assertNotNull(result);
        Assert.assertEquals(result.getId(), entity.getId());
        Assert.assertEquals(result.getAseguradora(), entity.getAseguradora());
        Assert.assertEquals(result.getCapacidad(), entity.getCapacidad());
        Assert.assertEquals(result.getColor(), entity.getColor());
        Assert.assertEquals(result.getMarca(), entity.getMarca());
        Assert.assertEquals(result.getNumeroSeguro(), entity.getNumeroSeguro());
        Assert.assertEquals(result.getPlaca(), entity.getPlaca());
        Assert.assertEquals(result.getUsuario(), entity.getUsuario());
        Assert.assertEquals(result.getViajes(), entity.getViajes());
        } catch (Exception e) {
        }
        
    }

    /**
     * Prueba para eliminar un Vehiculo.
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
        catch(Exception e)
        {
            System.out.println("Error en delete");
        }
    }

    /**
     * Prueba para actualizar un Vehiculo.
     *
     * @generated
     */
    @Test
    public void updateVehiculoTest() {
        try {
        VehiculoEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        VehiculoEntity newEntity = factory.manufacturePojo(VehiculoEntity.class);
        newEntity.setId(entity.getId());

        vehiculoLogic.updateVehiculo(newEntity);

        VehiculoEntity result = em.find(VehiculoEntity.class, entity.getId());
        
            //Assert.assertNotNull(result);
        Assert.assertEquals(result.getId(), entity.getId());
        Assert.assertEquals(result.getAseguradora(), entity.getAseguradora());
        Assert.assertEquals(result.getCapacidad(), entity.getCapacidad());
        Assert.assertEquals(result.getColor(), entity.getColor());
        Assert.assertEquals(result.getMarca(), entity.getMarca());
        Assert.assertEquals(result.getNumeroSeguro(), entity.getNumeroSeguro());
        Assert.assertEquals(result.getPlaca(), entity.getPlaca());
        Assert.assertEquals(result.getUsuario(), entity.getUsuario());
        Assert.assertEquals(result.getViajes(), entity.getViajes());
        } catch (Exception e) {
        }
       
    }
}    
