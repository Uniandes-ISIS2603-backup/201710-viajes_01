
package co.edu.uniandes.csw.viajes.entities;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ViajeEntity extends BaseEntity{
    
    @ManyToOne
    private CiudadEntity ciudadOrigen;
    @ManyToOne
    private CiudadEntity ciudadDestino;
    private String direccionRecoger;
    private String direccionDejar;
    
    @Temporal(TemporalType.DATE)
    private Date fechaPartida;
    
    @Temporal(TemporalType.DATE)
    private Date fechaLlegada;
    
    private double kilometros;
    private double gastoGasolina;
    private double gastoPeaje;
    private double gastoOtros;
    private int numPasajeros;
    
    @Temporal(TemporalType.DATE)
    private Date horaSalida;
    
    @Temporal(TemporalType.DATE)
    private Date horaLlegada;
    
    @ManyToOne
    private VehiculoEntity vehiculo;
    
    @OneToMany(mappedBy ="viaje")
    private List<ReservaEntity> pasajeros;
    

    public CiudadEntity getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(CiudadEntity ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public CiudadEntity getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(CiudadEntity ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public String getDireccionRecoger() {
        return direccionRecoger;
    }

    public void setDireccionRecoger(String direccionRecoger) {
        this.direccionRecoger = direccionRecoger;
    }

    public String getDireccionDejar() {
        return direccionDejar;
    }

    public void setDireccionDejar(String direccionDejar) {
        this.direccionDejar = direccionDejar;
    }

    public Date getFechaPartida() {
        return fechaPartida;
    }

    public void setFechaPartida(Date fechaPartida) {
        this.fechaPartida = fechaPartida;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public double getGastoGasolina() {
        return gastoGasolina;
    }

    public void setGastoGasolina(double gastoGasolina) {
        this.gastoGasolina = gastoGasolina;
    }

    public double getGastoOtros() {
        return gastoOtros;
    }

    public void setGastoOtros(double gastoOtros) {
        this.gastoOtros = gastoOtros;
    }

    public double getGastoPeaje() {
        return gastoPeaje;
    }

    public void setGastoPeaje(double gastoPeaje) {
        this.gastoPeaje = gastoPeaje;
    }

    public Date getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(Date horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public double getKilometros() {
        return kilometros;
    }

    public void setKilometros(double kilometros) {
        this.kilometros = kilometros;
    }

    public int getNumPasajeros() {
        return numPasajeros;
    }

    public void setNumPasajeros(int numPasajeros) {
        this.numPasajeros = numPasajeros;
    }

    public VehiculoEntity getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoEntity vehiculo) {
        this.vehiculo = vehiculo;
    }

    public List<ReservaEntity> getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(List<ReservaEntity> pasajeros) {
        this.pasajeros = pasajeros;
    }
    
  
    
    public boolean equals(Object obj) {
        if (this.getId() != null) {
            return this.getId().equals(((ViajeEntity) obj).getId());
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
