package co.edu.uniandes.csw.viajes.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ReservaEntity implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer pasajeros;
	private Double precio;
	private Double comision;
	
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
	
	@Override
    public boolean equals(Object obj) {
        if (this.getId() != null) {
            return this.getId().equals(((ReservaEntity) obj).getId());
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        if (this.getId() != null) {
            return this.getId().hashCode();
        }
        return super.hashCode();
    }
}