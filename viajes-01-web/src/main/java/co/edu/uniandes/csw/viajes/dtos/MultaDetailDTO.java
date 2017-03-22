// TODO: eliminar mensajes por defecto
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
