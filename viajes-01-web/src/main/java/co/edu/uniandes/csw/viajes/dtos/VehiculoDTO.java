/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.UsuarioEntity;
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
    private UsuarioEntity usuario;

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
            this.usuario = entity.getUsuario();
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
    
    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }
    
    public UsuarioEntity getUsuario(){
        return usuario;
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
        entity.setUsuario(this.getUsuario());
        return entity;
    }
    
}
