package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.Reserva.entities.ReservaEntity;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ReservaDetailDTO extends ReservaDTO{



    public ReservaDetailDTO(){
        super();
    }

    /**
     * Crea un objeto ReservaDetailDTO a partir de un objeto ReservaEntity incluyendo los atributos de ReservaDTO.
     *
     * @param entity Entidad ReservaEntity desde la cual se va a crear el nuevo objeto.
     * @generated
     */
    public ReservaDetailDTO(ReservaEntity entity) {
        super(entity);
		this.precio=entity.getPrecio();
        this.comision=entity.getComision();
    }

    /**
     * Convierte un objeto ReservaDetailDTO a ReservaEntity incluyendo los atributos de ReservaDTO.
     *
     * @return Nueva objeto ReservaEntity.
     * @generated
     */
    @Override
    public ReservaEntity toEntity() {
        ReservaEntity entity = new ReservaEntity();
        entity.setId(this.getId());
        entity.setPasajeros(this.getPasajeros());
		entity.setPrecio(this.getPrecio());
		entity.setComision(this.getComision());
		return entity;
    }
	
	public Double getPrecio(){
		return precio;
	}
	
	public void setPrecio(Double precio){
		this.precio = precio;
	}
	
	public Double getComision(){
		return comision;
	}
	
	public void setComision(Double comision){
		this.comision = comision;
	}
}
