/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;


import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CiudadEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;
    
    @OneToMany(mappedBy ="ciudadOrigen")
    private List<ViajeEntity> viajeIda;
    
    @OneToMany(mappedBy ="ciudadDestino")
    private List<ViajeEntity> viajeVuelta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

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
