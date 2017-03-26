
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.VehiculoEntity;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VehiculoDetailDTO extends VehiculoDTO{

   
    public VehiculoDetailDTO() {
        super();
    }

    public VehiculoDetailDTO(VehiculoEntity entity) {
        super(entity);
    }

    @Override
    public VehiculoEntity toEntity() {
        VehiculoEntity entity = super.toEntity();
        return entity;
    }
}
