/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    public CiudadEntity toEntity() {
        CiudadEntity entity = super.toEntity();
        return entity;
    }
    
    
}
