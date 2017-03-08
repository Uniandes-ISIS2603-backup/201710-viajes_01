/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ViajeEntity implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String ciudadOrigen;
    private String  ciudadDestino;
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
    
    //@ManyToOne
    //private Vehiculo vehiculo;
    
    //@OneToMany(mappedBy ="viaje")
    //private List<Reserva> pasajeros;
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
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
