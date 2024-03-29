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

import co.edu.uniandes.csw.viajes.entities.ReservaEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.persistence.Query;

@Stateless
public class ReservaPersistence{

    @PersistenceContext(unitName="viajesPU")
    protected EntityManager em;

    public ReservaEntity find(Long id) {
        return em.find(ReservaEntity.class, id);
    }

    public List<ReservaEntity> findAll() {
        Query q = em.createQuery("Select u from ReservaEntity u");
        return q.getResultList();
    }

    public ReservaEntity create(ReservaEntity entity) {
        em.persist(entity);
        return entity;
    }

    public ReservaEntity update(ReservaEntity entity) {
        return em.merge(entity);
    }

    public void delete(Long id) {
        ReservaEntity entity = em.find(ReservaEntity.class, id);
        em.remove(entity);
    }
}