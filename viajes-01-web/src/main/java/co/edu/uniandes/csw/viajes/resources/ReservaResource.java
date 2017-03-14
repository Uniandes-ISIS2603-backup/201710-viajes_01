package co.edu.uniandes.csw.viajes.resources;

import co.edu.uniandes.csw.viajes.dtos.ReservaDTO;
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
    public List<ReservaDetailDTO> getReservas(){
        List<ReservaEntity> reservaEntities = reservaLogic.getReservas();
        return reservaEntities.stream()
            .map(ReservaDetailDTO::new)
            .collect(Collectors.toList());
    }
    
    @POST
    public ReservaDetailDTO createReserva(ReservaDetailDTO ReservaDTO) throws BusinessLogicException{
        ReservaEntity reservaEntity = ReservaDTO.toEntity();
        ReservaEntity createdReserva = reservaLogic.createReserva(reservaEntity);
        return new ReservaDetailDTO(createdReserva);
    }
    
    @PUT
    @Path("{id: \\d+}")
    public ReservaDetailDTO updateReserva(@PathParam("id") Long id, ReservaDetailDTO ReservaDTO) throws BusinessLogicException{
        ReservaEntity reservaEntity = ReservaDTO.toEntity();
        reservaEntity.setId(id);
        return new ReservaDetailDTO(reservaLogic.updateReserva(reservaEntity));
    }
    
    @GET
    @Path("{id: \\d+}")
    public ReservaDetailDTO getReserva(@PathParam("id") Long id){
        return new ReservaDetailDTO(reservaLogic.getReserva(id));
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteReserva(@PathParam("id") Long id){
        reservaLogic.deleteReserva(id);
    }
}
