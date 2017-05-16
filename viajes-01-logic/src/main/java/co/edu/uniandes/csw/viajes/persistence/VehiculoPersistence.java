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
package co.edu.uniandes.csw.viajes.persistence;

import co.edu.uniandes.csw.viajes.entities.VehiculoEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author ca.nieto11
 */
@Stateless
public class VehiculoPersistence {
    @PersistenceContext(unitName="viajesPU")
    protected EntityManager em;
    
    public VehiculoEntity find(Long id) {
        return em.find(VehiculoEntity.class, id);
    }

    public List<VehiculoEntity> findAll() {
        TypedQuery<VehiculoEntity> q = em.createQuery("select c from VehiculoEntity c",VehiculoEntity.class);
        return q.getResultList();
    }

    public VehiculoEntity create(VehiculoEntity vehiculo) {
        em.persist(vehiculo);
        return vehiculo;
    }

    public VehiculoEntity update(VehiculoEntity vehiculo) {
        return em.merge(vehiculo);
    }

    public void delete(Long id) {
        VehiculoEntity c = em.find(VehiculoEntity.class, id);
        em.remove(c);
    }
}
