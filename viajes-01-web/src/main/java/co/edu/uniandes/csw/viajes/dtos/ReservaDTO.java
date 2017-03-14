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
        this.id=entity.getId();
        this.pasajeros=entity.getPasajeros();
        this.precio=entity.getPrecio();
        this.comision=entity.getComision();
       }
    }

    /**
     * Convierte un objeto ReservaDTO a ReservaEntity.
     *
     * @return Nueva objeto ReservaEntity.
     */
    public ReservaEntity toEntity(){
        ReservaEntity entity = new ReservaEntity();
        entity.setId(this.getId());
        entity.setPasajeros(this.getPasajeros());
        entity.setPrecio(this.getprecio());
        entity.setComision(this.getComision());
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
        
        public void setPrecio(Double precio){
		this.precio = precio;
	}
        
        public void setComision(Double comision){
		this.comision = comision;
	}
        
        public Double getComision(){
		return comision;
	}
        
        public Double getprecio(){
		return precio;
	}
}
