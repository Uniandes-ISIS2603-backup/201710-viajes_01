
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
