
package co.edu.uniandes.csw.viajes.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author ca.nieto11
 */
@Entity
public class VehiculoEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;
    
    private String placa;
    private String marca;
    private String color;
    private String aseguradora;
    private int capacidad;
    private int numeroSeguro;
    
   
    @OneToMany(mappedBy = "vehiculo")
    private List<ViajeEntity> viajes;
    
    @PodamExclude
    @ManyToOne
    private UsuarioEntity usuario;
       
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAseguradora() {
        return aseguradora;
    }

    public void setAseguradora(String aseguradora) {
        this.aseguradora = aseguradora;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getNumeroSeguro() {
        return numeroSeguro;
    }

    public void setNumeroSeguro(int numeroSeguro) {
        this.numeroSeguro = numeroSeguro;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public List<ViajeEntity> getViajes() {
        return viajes;
    }

    public void setViajes(List<ViajeEntity> viajes) {
        this.viajes = viajes;
    }
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehiculoEntity)) {
            return false;
        }
        VehiculoEntity other = (VehiculoEntity) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniandes.csw.viajes.entities.VehiculoEntity[ id=" + getId() + " ]";
    }
    
}
