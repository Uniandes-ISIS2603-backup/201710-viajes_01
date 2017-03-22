// TODO: eliminar mensajes por defecto
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.resources;

import co.edu.uniandes.csw.viajes.dtos.ViajeDTO;
import co.edu.uniandes.csw.viajes.ejbs.ViajeLogic;
import co.edu.uniandes.csw.viajes.entities.ViajeEntity;
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

@Path("/viajes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ViajeResource {
    @Inject 
    private ViajeLogic viajeLogic;
    
    
    @GET
    public List<ViajeDTO> getViajes(){   
    
        List<ViajeDTO> viajeDTOs = new ArrayList<>();

        List<ViajeEntity> viajes = viajeLogic.getViajes();
        for(ViajeEntity company : viajes){
            ViajeDTO dto = new ViajeDTO(company);
            viajeDTOs.add(dto);
        }
        return viajeDTOs;
    }
    
    @GET
    @Path("{id: \\d+}")
    // TODO: retornar una excepción / codigo 404 si no existe
    public ViajeDTO getViaje(@PathParam("id") Long id) {
        return new ViajeDTO(viajeLogic.getViaje(id));
    }
    
    @POST
    public ViajeDTO createViaje(ViajeDTO viajeDTO) throws Exception{
        
       
        ViajeEntity viaje = viajeDTO.toEntity();
        ViajeEntity stored = viajeLogic.createViaje(viaje);  
        return new ViajeDTO(stored);
      
    }
    
    @PUT
    @Path("{id: \\d+}")
    public ViajeDTO updateViaje(@PathParam("id") Long id, ViajeDTO dto) {
        ViajeEntity entity = dto.toEntity();
        entity.setId(id);
        return new ViajeDTO(viajeLogic.updateViaje(entity));
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteViaje(@PathParam("id") Long id) {
        viajeLogic.deleteViaje(id);
    }
           
  
    
}
