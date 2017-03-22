// TODO: eliminar mensajes por defecto
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

@Path("/multas")
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
    // TODO: retornar una excepción / código 40 si no existe
    public MultaDTO getMulta(@PathParam("id") Long id) {
        return new MultaDTO(multaLogic.getMulta(id));
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
