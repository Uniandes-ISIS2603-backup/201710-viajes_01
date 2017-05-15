/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.test.logic;

import co.edu.uniandes.csw.viajes.ejbs.UsuarioLogic;
import co.edu.uniandes.csw.viajes.entities.UsuarioEntity;
import co.edu.uniandes.csw.viajes.persistence.UsuarioPersistence;
import java.util.List;
import java.util.ArrayList;
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
public class UsuarioLogicTest
{

    public static final String DEPLOY = "Prueba";

    /**
     * @generated
     */
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, DEPLOY + ".war")
                .addPackage(UsuarioEntity.class.getPackage())
                .addPackage(UsuarioLogic.class.getPackage())
                .addPackage(UsuarioPersistence.class.getPackage())
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("META-INF/beans.xml", "beans.xml");
    }
        /**
     * @generated
     */
    @Inject
    private UsuarioLogic usuarioLogic;

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
        em.createQuery("delete from UsuarioEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<UsuarioEntity> data = new ArrayList<UsuarioEntity>();

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     *
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            PodamFactory factory = new PodamFactoryImpl();
            UsuarioEntity entity = factory.manufacturePojo(UsuarioEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
    
    @Test
    public void createUsuarioTest() {
        PodamFactory factory = new PodamFactoryImpl();
        UsuarioEntity entity = factory.manufacturePojo(UsuarioEntity.class);
        UsuarioEntity result = usuarioLogic.createUsuario(entity);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getId(), entity.getId());
        Assert.assertEquals(result.getEmail(), entity.getEmail());
        Assert.assertEquals(result.getLicencia(), entity.getLicencia());
        Assert.assertEquals(result.getMulta(), entity.getMulta());
        Assert.assertEquals(result.getNombre(), entity.getNombre());
        Assert.assertEquals(result.getNumero(), entity.getNumero());
        Assert.assertEquals(result.getReservas(), entity.getReservas());
        Assert.assertEquals(result.getTelefono(), entity.getTelefono());
        Assert.assertEquals(result.getVehiculos(), entity.getVehiculos());
    }
    
    @Test
    public void getUsuariosTest() {
        List<UsuarioEntity> list = usuarioLogic.getUsuarios();
        Assert.assertEquals(data.size(), list.size());
        for (UsuarioEntity entity : list) {
            boolean found = false;
            for (UsuarioEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void getViajeTest() {
        UsuarioEntity entity = data.get(0);
        UsuarioEntity result = usuarioLogic.getUsuario(entity.getId());
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getId(), entity.getId());
        Assert.assertEquals(result.getEmail(), entity.getEmail());
        Assert.assertEquals(result.getLicencia(), entity.getLicencia());
        Assert.assertEquals(result.getMulta(), entity.getMulta());
        Assert.assertEquals(result.getNombre(), entity.getNombre());
        Assert.assertEquals(result.getNumero(), entity.getNumero());
        Assert.assertEquals(result.getReservas(), entity.getReservas());
        Assert.assertEquals(result.getTelefono(), entity.getTelefono());
        Assert.assertEquals(result.getVehiculos(), entity.getVehiculos());
    }
    
    @Test
    public void deleteCiudadTest() {
        UsuarioEntity entity = data.get(0);
        usuarioLogic.deleteUsuario(entity.getId());
        UsuarioEntity deleted = em.find(UsuarioEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    
    @Test
    public void updateUsuarioTest() {
        UsuarioEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        UsuarioEntity pojoEntity = factory.manufacturePojo(UsuarioEntity.class);
        pojoEntity.setId(entity.getId());

        usuarioLogic.updateUsuario(pojoEntity);

        UsuarioEntity resp = em.find(UsuarioEntity.class, entity.getId());
        Assert.assertNotNull(resp);
        Assert.assertEquals(resp.getId(), entity.getId());
        Assert.assertEquals(resp.getEmail(), entity.getEmail());
        Assert.assertEquals(resp.getLicencia(), entity.getLicencia());
        Assert.assertEquals(resp.getMulta(), entity.getMulta());
        Assert.assertEquals(resp.getNombre(), entity.getNombre());
        Assert.assertEquals(resp.getNumero(), entity.getNumero());
        Assert.assertEquals(resp.getReservas(), entity.getReservas());
        Assert.assertEquals(resp.getTelefono(), entity.getTelefono());
        Assert.assertEquals(resp.getVehiculos(), entity.getVehiculos());
    }

}


