
package co.edu.uniandes.csw.viajes.dtos;

import co.edu.uniandes.csw.viajes.entities.ViajeEntity;
import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ViajeDTO implements Serializable{
 
    private Long id; 
    private String ciudadOrigen;
    private String  ciudadDestino;
    private String direccionRecoger;
    private String direccionDejar;
    private Date fechaPartida;
    private Date fechaLlegada;  
    private double kilometros;
    private double gastoGasolina;
    private double gastoPeaje;
    private double gastoOtros;
    private int numPasajeros;
    private Date horaSalida;
    private Date horaLlegada;

  public ViajeDTO(){
      
  }  
  
  public ViajeDTO(ViajeEntity entity){
       if(entity != null){
        this.id = entity.getId();
        this.ciudadOrigen = entity.getCiudadOrigen();
        this.ciudadDestino = entity.getCiudadDestino();
        this.direccionRecoger = entity.getDireccionRecoger();
        this.direccionDejar = entity.getDireccionDejar();
        this.fechaPartida = entity.getFechaPartida();
        this.fechaLlegada = entity.getFechaLlegada();
        this.kilometros = entity.getKilometros();
        this.gastoGasolina = entity.getGastoGasolina();
        this.gastoPeaje = entity.getGastoPeaje();
        this.gastoOtros = entity.getGastoOtros();
        this.numPasajeros = entity.getNumPasajeros();
        this.horaSalida = entity.getHoraSalida();
        this.horaLlegada = entity.getHoraLlegada();
    }
  }
    
  public ViajeEntity toEntity(){
    ViajeEntity entity = new ViajeEntity();
    entity.setId(id);
    entity.setCiudadOrigen(ciudadOrigen);
    entity.setCiudadDestino(ciudadDestino);
    entity.setDireccionRecoger(direccionRecoger);
    entity.setFechaPartida(fechaPartida);
    entity.setFechaLlegada(fechaLlegada);
    entity.setKilometros(kilometros);
    entity.setGastoGasolina(gastoGasolina);
    entity.setGastoPeaje(gastoPeaje);
    entity.setGastoOtros(gastoOtros);
    entity.setNumPasajeros(numPasajeros);
    entity.setHoraSalida(horaSalida);
    entity.setHoraLlegada(horaLlegada);
   return entity;
}
    
    
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
    
    
}
