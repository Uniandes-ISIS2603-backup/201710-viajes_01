
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.CiudadEntity;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ac.fandino10
 */
@XmlRootElement
public class CiudadDetailDTO extends CiudadDTO{
    
    public CiudadDetailDTO() {
        super();
    }

    public CiudadDetailDTO(CiudadEntity entity) {
        super(entity);
    }

    @Override
    public CiudadEntity toEntity() {
        CiudadEntity entity = super.toEntity();
        return entity;
    }
    
    
}
