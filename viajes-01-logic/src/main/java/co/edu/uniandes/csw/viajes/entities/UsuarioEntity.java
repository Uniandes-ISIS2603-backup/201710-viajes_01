
package co.edu.uniandes.csw.viajes.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author jp.perez12
 */

@Entity
public class UsuarioEntity extends BaseEntity{
    
    private static final long serialVersionUID = 1L;
    private String numero;
    private String nombre;
    private String email;
    private int telefono;
    private String licencia;
    
    @OneToMany(mappedBy = "usuario")
    private List<MultaEntity> multas;
    
    @OneToMany(mappedBy = "usuario")
    private List<VehiculoEntity> vehiculos;
    
    @OneToMany(mappedBy = "usuario")
    private List<ReservaEntity> reservas; 
    

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public List<MultaEntity> getMulta() {
        return multas;
    }

    public void setMulta(List<MultaEntity> multas) {
        this.multas = multas;
    }

    public List<VehiculoEntity> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<VehiculoEntity> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public List<ReservaEntity> getReservas() {
        return reservas;
    }

    public void setReservas(List<ReservaEntity> reservas) {
        this.reservas = reservas;
    }        
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof UsuarioEntity)) {
            return false;
        }
        UsuarioEntity other = (UsuarioEntity) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.uniandes.csw.viajes.entities.UsuarioEntity[ id=" + getId() + " ]";
    }
    
    
}
