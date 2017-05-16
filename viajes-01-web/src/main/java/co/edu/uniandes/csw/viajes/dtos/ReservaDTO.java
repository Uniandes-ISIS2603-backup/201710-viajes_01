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
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.ReservaEntity;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class ReservaDTO implements Serializable{

    protected Long id;
    protected Integer pasajeros;
    protected Double precio;
    protected Double comision;

    public ReservaDTO() {}

    /**
     * Crea un objeto ReservaDTO a partir de un objeto ReservaEntity.
     *
     * @param entity Entidad ReservaEntity desde la cual se va a crear el nuevo objeto.
     */
    public ReservaDTO(ReservaEntity entity){
	if (entity!=null){
        id = entity.getId();
        pasajeros = entity.getPasajeros();
        precio = entity.getPrecio();
        comision = entity.getComision();
       }
    }

    /**
     * Convierte un objeto ReservaDTO a ReservaEntity.
     *
     * @return Nueva objeto ReservaEntity.
     */
    public ReservaEntity toEntity(){
        ReservaEntity entity = new ReservaEntity();
        entity.setId(id);
        entity.setPasajeros(pasajeros);
        entity.setPrecio(precio);
        entity.setComision(comision);
        return entity;
    }
	
	public Long getId(){
            return id;
	}
	
	public void setId(Long id){
            this.id = id;
	}
	
	public Integer getPasajeros(){
		return pasajeros;
	}
	
	public void setPasajeros(Integer pasajeros){
		this.pasajeros = pasajeros;
	}
        
        public Double getPrecio(){
		return precio;
	}
        
        public void setPrecio(Double precio){
		this.precio = precio;
	}
        
        public Double getComision(){
		return comision;
	}
        
        public void setComision(Double comision){
		this.comision = comision;
	}
}
