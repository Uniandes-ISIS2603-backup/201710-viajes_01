package co.edu.uniandes.csw.viajes.resources;

import co.edu.uniandes.csw.viajes.dtos.ReservaDTO;
// TODO: eliminar los import que no se usan
import co.edu.uniandes.csw.viajes.dtos.ReservaDetailDTO;
import co.edu.uniandes.csw.viajes.ejbs.ReservaLogic;
import co.edu.uniandes.csw.viajes.entities.ReservaEntity;
import co.edu.uniandes.csw.viajes.exceptions.BusinessLogicException;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/reservas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReservaResource {
    
   
    @Inject
    private ReservaLogic reservaLogic;
    
    @GET
    public List<ReservaDTO> getReservas(){
        List<ReservaEntity> reservaEntities = reservaLogic.getReservas();
        return reservaEntities.stream()
            .map(ReservaDTO::new)
            .collect(Collectors.toList());
    }
    
    @POST
    public ReservaDTO createReserva(ReservaDTO ReservaDTO) throws BusinessLogicException{
        ReservaEntity reservaEntity = ReservaDTO.toEntity();
        ReservaEntity createdReserva = reservaLogic.createReserva(reservaEntity);
        return new ReservaDTO(createdReserva);
    }
    
    @PUT
    @Path("{id: \\d+}")
    public ReservaDTO updateReserva(@PathParam("id") Long id, ReservaDTO ReservaDTO) throws BusinessLogicException{
        ReservaEntity reservaEntity = ReservaDTO.toEntity();
        reservaEntity.setId(id);
        return new ReservaDTO(reservaLogic.updateReserva(reservaEntity));
    }
    
    @GET
    @Path("{id: \\d+}")
    // TODO. retornar una excepción / código 404 si no existe
    public ReservaDTO getReserva(@PathParam("id") Long id){
        return new ReservaDTO(reservaLogic.getReserva(id));
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteReserva(@PathParam("id") Long id){
        reservaLogic.deleteReserva(id);
    }
}
