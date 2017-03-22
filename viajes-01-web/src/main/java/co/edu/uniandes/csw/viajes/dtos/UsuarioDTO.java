// TODO: eliminar mensajes por defecto
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
 * @author jp.perez11
 */
@XmlRootElement
public class UsuarioDTO implements Serializable{
    
    private Long id;  
    private String numero;
    private String nombre;
    private String email;
    private int telefono;
    private String licencia;

    public UsuarioDTO() {
    }
    
    public UsuarioDTO(UsuarioEntity entity){
    if(entity != null){
        this.id = entity.getId();
        this.numero = entity.getNumero();
        this.nombre = entity.getNombre();
        this.email = entity.getEmail();
        this.telefono = entity.getTelefono();
        this.licencia = entity.getLicencia();
    }
    
}
    
    public UsuarioEntity toEntity()
    {
        UsuarioEntity entity = new UsuarioEntity();
        entity.setId(id);
        entity.setNumero(numero);
        entity.setNombre(nombre);
        entity.setEmail(email);
        entity.setTelefono(telefono);
        entity.setLicencia(licencia);
        return entity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    
    
}
