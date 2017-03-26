
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.UsuarioEntity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jp.perez12
 */
@XmlRootElement
public class UsuarioDetailDTO extends UsuarioDTO
{
    
   
    public UsuarioDetailDTO() {
        super();
    }

    public UsuarioDetailDTO(UsuarioEntity entity) {
        super(entity);
    }

    @Override
    public UsuarioEntity toEntity() {
        UsuarioEntity entity = super.toEntity();
        return entity;
    }
}
