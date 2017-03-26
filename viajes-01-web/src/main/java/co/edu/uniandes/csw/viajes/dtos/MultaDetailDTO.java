
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.MultaEntity;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MultaDetailDTO extends MultaDTO{

   
    public MultaDetailDTO() {
        super();
    }

    public MultaDetailDTO(MultaEntity entity) {
        super(entity);
    }

    @Override
    public MultaEntity toEntity() {
        MultaEntity entity = super.toEntity();
        return entity;
    }
}
