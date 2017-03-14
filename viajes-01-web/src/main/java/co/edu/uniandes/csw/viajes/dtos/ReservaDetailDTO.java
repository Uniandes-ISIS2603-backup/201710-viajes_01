package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.ReservaEntity;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ReservaDetailDTO extends ReservaDTO{

    public ReservaDetailDTO() {
        super();
    }

    public ReservaDetailDTO(ReservaEntity entity) {
        super(entity);
    }

    @Override
    public ReservaEntity toEntity() {
        ReservaEntity entity = super.toEntity();
        return entity;
    }
}