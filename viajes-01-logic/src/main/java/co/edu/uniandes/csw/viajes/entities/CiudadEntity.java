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
package co.edu.uniandes.csw.viajes.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import uk.co.jemos.podam.common.PodamExclude;

@Entity
public class CiudadEntity extends BaseEntity{
    
    @PodamExclude
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;
    
    private String nombre;
    
    // TODO: implementar las relaciones con otras clases
    
    //@PodamExclude
    //@OneToMany(mappedBy ="ciudadOrigen")
    //private List<ViajeEntity> viajeIda;
    
    //@PodamExclude
    //@OneToMany(mappedBy ="ciudadDestino")
    //private List<ViajeEntity> viajeVuelta;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /*
    public List<ViajeEntity> getViajeIda() {
        return viajeIda;
    }

    public void setViajeIda(List<ViajeEntity> viajeIda) {
        this.viajeIda = viajeIda;
    }

    public List<ViajeEntity> getViajeVuelta() {
        return viajeVuelta;
    }

    public void setViajeVuelta(List<ViajeEntity> viajeVuelta) {
        this.viajeVuelta = viajeVuelta;
    }
*/
    
     public boolean equals(Object obj) {
        if (this.getId() != null) {
            return this.getId().equals(((CiudadEntity) obj).getId());
}
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        if (this.getId() != null) {
            return this.getId().hashCode();
        }
        return super.hashCode();
    }
    
}
