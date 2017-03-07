/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.MultaEntity;
import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MultaDTO implements Serializable{
    
private Long id;
private Double valor;
private Date fecha;
private String descripcion;

public MultaDTO(){
    
}

public MultaDTO(MultaEntity entity){
    if(entity != null){
        this.id = entity.getId();
        this.valor = entity.getValor();
        this.fecha = entity.getFecha();
        this.descripcion = entity.getDescripcion();
    }
    
}

public MultaEntity toEntity(){
    MultaEntity entity = new MultaEntity();
    entity.setId(id);
    entity.setValor(valor);
    entity.setFecha(fecha);
    entity.setDescripcion(descripcion);
    return entity;
}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

      
    
}
