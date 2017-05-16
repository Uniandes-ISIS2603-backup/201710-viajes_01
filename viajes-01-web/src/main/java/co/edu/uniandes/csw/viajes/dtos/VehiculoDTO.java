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

import co.edu.uniandes.csw.viajes.entities.VehiculoEntity;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ca.nieto11
 */
@XmlRootElement
public class VehiculoDTO implements Serializable{
    
    private Long id;  
    private String placa;
    private String marca;
    private String color;
    private String aseguradora;
    private int capacidad;
    private int numeroSeguro;

    public VehiculoDTO() {
    }

    public VehiculoDTO(VehiculoEntity entity) {
        if(entity!=null){
            this.id = entity.getId();
            this.placa = entity.getPlaca();
            this.marca = entity.getMarca();
            this.color = entity.getColor();
            this.aseguradora = entity.getAseguradora();
            this.capacidad = entity.getCapacidad();
            this.numeroSeguro = entity.getCapacidad();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAseguradora() {
        return aseguradora;
    }

    public void setAseguradora(String aseguradora) {
        this.aseguradora = aseguradora;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getNumeroSeguro() {
        return numeroSeguro;
    }

    public void setNumeroSeguro(int numeroSeguro) {
        this.numeroSeguro = numeroSeguro;
    }
    
    public VehiculoEntity toEntity(){
        VehiculoEntity entity = new VehiculoEntity();
        entity.setId(this.getId());
        entity.setPlaca(this.getPlaca());
        entity.setColor(this.getColor());
        entity.setCapacidad(this.getCapacidad());
        entity.setAseguradora(this.getAseguradora());
        entity.setNumeroSeguro(this.getNumeroSeguro());
        entity.setMarca(this.getMarca());
        return entity;
    }
    
}
