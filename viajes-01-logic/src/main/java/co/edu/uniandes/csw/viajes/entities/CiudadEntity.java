
package co.edu.uniandes.csw.viajes.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class CiudadEntity extends BaseEntity{
    
    
    private String nombre;
        
    @OneToMany(mappedBy ="ciudadOrigen")
    private List<ViajeEntity> viajeIda;
    
    @OneToMany(mappedBy ="ciudadDestino")
    private List<ViajeEntity> viajeVuelta;


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
