package co.edu.uniandes.csw.viajes.ejbs;

import co.edu.uniandes.csw.viajes.persistence.ReservaPersistence;
import co.edu.uniandes.csw.viajes.entities.ReservaEntity;
import co.edu.uniandes.csw.viajes.exceptions.BusinessLogicException;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class ReservaLogic {

    @Inject
    private ReservaPersistence persistence;

    /**
     * Obtiene la lista de los registros de Reservas.
     *
     * @return Colección de objetos de ReservaEntity.
     * 
     */
   
    public List<ReservaEntity> getReservas(){
        return persistence.findAll();
    }


    /**
     * Obtiene los datos de una instancia de Reserva a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de ReservaEntity con los datos del Reserva consultado.
     *
     */
    public ReservaEntity getReserva(Long id){
		if(id == null){
			throw new NullPointerException("El id de la reserva a consultar no puede ser nulo.");
		}
        return persistence.find(id);
    }

    /**
     * Se encarga de crear una Reserva en la base de datos.
     *
     * @param entity Objeto de ReservaEntity con los datos nuevos
     * @return Objeto de ReservaEntity con los datos nuevos y su ID.
     * @generated
     */
    
    public ReservaEntity createReserva(ReservaEntity entity) throws BusinessLogicException{
	//validarReserva(entity);
        persistence.create(entity);
        return entity;
    }

    /**
     * Actualiza la información de una instancia de Reserva.
     *
     * @param entity Instancia de ReservaEntity con los nuevos datos.
     * @return Instancia de ReservaEntity con los datos actualizados.
     * 
     */
   
    public ReservaEntity updateReserva(ReservaEntity entity) throws BusinessLogicException{
        validarReserva(entity);
        return persistence.update(entity);
    }

    /**
     * Elimina una instancia de Reserva de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     *
     */
   
    public void deleteReserva(Long id){
		if(id == null){
			throw new NullPointerException("El id de la reserva a eliminar no puede ser nulo.");
		}
        persistence.delete(id);
    }
	
	public void validarReserva(ReservaEntity r) throws BusinessLogicException{
		if(r == null){
			throw new NullPointerException("El objeto de ReservaEntity no puede ser nulo.");
		}
		if(r.getPasajeros() == null){
			throw new NullPointerException("El numero de pasajeros de la reserva no puede ser nulo.");
		}
		if(r.getPasajeros() < 1){
			throw new BusinessLogicException("El numero de pasajeros de la reserva debe ser mayor a 0. Valor recibido: " + r.getPasajeros());
		}
		if(r.getPrecio() == null){
			throw new NullPointerException("El precio de la reserva no puede ser nulo.");
		}
		if(r.getPrecio() < 0){
			throw new BusinessLogicException("El precio de la reserva debe ser un numero positivo. Valor recibido: " + r.getPrecio());
		}
		if(r.getComision() == null){
			throw new NullPointerException("El valor de la comision de la reserva no puede ser nulo.");
		}
		if(r.getComision() < 0){
			throw new BusinessLogicException("La comision de la reserva debe ser un numero positivo. Valor recibido: " + r.getComision());
		}
	}
}
