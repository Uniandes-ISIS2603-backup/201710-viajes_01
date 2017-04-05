
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.CiudadEntity;
import co.edu.uniandes.csw.viajes.entities.ViajeEntity;
import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ac.fandino10
 */
@XmlRootElement
public class CiudadDTO implements Serializable{
    
    private Long id;
    private String nombre;   
    private List<ViajeEntity> viajeIda;   
    private List<ViajeEntity> viajeVuelta;
    
    public CiudadDTO(){
    
    }
    
    public CiudadDTO(CiudadEntity entity){
    if(entity != null){
        this.id = entity.getId();
        this.nombre = entity.getNombre();
//        this.viajeIda = entity.getViajeIda();
//        this.viajeVuelta = entity.getViajeVuelta();
    }
    
}

public CiudadEntity toEntity(){
    CiudadEntity entity = new CiudadEntity();
    entity.setId(id);
    entity.setNombre(nombre);
//    entity.setViajeIda(viajeIda);
//    entity.setViajeVuelta(viajeVuelta);
    return entity;
}

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

    
}
