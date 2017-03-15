package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.ReservaEntity;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
public class ReservaDTO implements Serializable{

    protected Long id;
    protected Integer pasajeros;
    protected Double precio;
    protected Double comision;

    public ReservaDTO() {}

    /**
     * Crea un objeto ReservaDTO a partir de un objeto ReservaEntity.
     *
     * @param entity Entidad ReservaEntity desde la cual se va a crear el nuevo objeto.
     */
    public ReservaDTO(ReservaEntity entity){
	if (entity!=null){
        id = entity.getId();
        pasajeros = entity.getPasajeros();
        precio = entity.getPrecio();
        comision = entity.getComision();
       }
    }

    /**
     * Convierte un objeto ReservaDTO a ReservaEntity.
     *
     * @return Nueva objeto ReservaEntity.
     */
    public ReservaEntity toEntity(){
        ReservaEntity entity = new ReservaEntity();
        entity.setId(id);
        entity.setPasajeros(pasajeros);
        entity.setPrecio(precio);
        entity.setComision(comision);
        return entity;
    }
	
	public Long getId(){
            return id;
	}
	
	public void setId(Long id){
            this.id = id;
	}
	
	public Integer getPasajeros(){
		return pasajeros;
	}
	
	public void setPasajeros(Integer pasajeros){
		this.pasajeros = pasajeros;
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
