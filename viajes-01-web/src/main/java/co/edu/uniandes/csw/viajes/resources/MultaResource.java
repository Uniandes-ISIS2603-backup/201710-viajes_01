
package co.edu.uniandes.csw.viajes.resources;

import co.edu.uniandes.csw.viajes.dtos.MultaDTO;
import co.edu.uniandes.csw.viajes.ejbs.MultaLogic;
import co.edu.uniandes.csw.viajes.entities.MultaEntity;
import java.util.ArrayList;
import java.util.List;
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
import javax.xml.ws.http.HTTPException;

@Path("/usuarios/id: \\d+/multas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MultaResource {
    
     @Inject 
    private MultaLogic multaLogic;
    
    
    @GET
    public List<MultaDTO> getMultas(){   
    
        List<MultaDTO> multasDTOs = new ArrayList<>();

        List<MultaEntity> multas = multaLogic.getMultas();
        for(MultaEntity multa : multas){
            MultaDTO dto = new MultaDTO(multa);
            multasDTOs.add(dto);
        }
        return multasDTOs;
    }
    
    @GET
    @Path("{id: \\d+}")
    public MultaDTO getMulta(@PathParam("id") Long id) throws HTTPException{
        MultaEntity toGet = multaLogic.getMulta(id);
        if(toGet==null) throw new HTTPException(404);
        return new MultaDTO(toGet);
    }
    
    @POST
    public MultaDTO createMulta(MultaDTO multaDTO){
        
       
        MultaEntity multa = multaDTO.toEntity();
        MultaEntity entity = multaLogic.createMulta(multa);  
        return new MultaDTO(entity);
      
    }
    
    @PUT
    @Path("{id: \\d+}")
    public MultaDTO updateMulta(@PathParam("id") Long id, MultaDTO dto) {
        MultaEntity entity = dto.toEntity();
        entity.setId(id);
        return new MultaDTO(multaLogic.updateMulta(entity));
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteMulta(@PathParam("id") Long id) {
        multaLogic.deleteMulta(id);
    }
              
    
}
