/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.resources;

import co.edu.uniandes.csw.viajes.dtos.CiudadDTO;
import co.edu.uniandes.csw.viajes.ejbs.CiudadLogic;
import co.edu.uniandes.csw.viajes.entities.CiudadEntity;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Path;

/**
 *
 * @author ac.fandino10
 */
@Path("/ciudades")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CiudadResource {
    
     @Inject 
    private CiudadLogic ciudadLogic;
    
    
    @GET
    public List<CiudadDTO> getMultas(){   
    
        List<CiudadDTO> ciudadDTOs = new ArrayList<>();

        List<CiudadEntity> ciudades = ciudadLogic.getCiudades();
        for(CiudadEntity ciudad : ciudades){
            CiudadDTO dto = new CiudadDTO(ciudad);
            ciudadDTOs.add(dto);
        }
        return ciudadDTOs;
    }
    
    @GET
    @Path("{id: \\d+}")
    public CiudadDTO getMulta(@PathParam("id") Long id) {
        return new CiudadDTO(ciudadLogic.getCiudad(id));
    }
    
    @POST
    public CiudadDTO createMulta(CiudadDTO ciudadDTO){
        
       
        CiudadEntity ciudad = ciudadDTO.toEntity();
        CiudadEntity entity = ciudadLogic.createCiudad(ciudad);  
        return new CiudadDTO(entity);
      
    }
    
    @PUT
    @Path("{id: \\d+}")
    public CiudadDTO updateMulta(@PathParam("id") Long id, CiudadDTO dto) {
        CiudadEntity entity = dto.toEntity();
        entity.setId(id);
        return new CiudadDTO(ciudadLogic.updateCiudad(entity));
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCiudad(@PathParam("id") Long id) {
        ciudadLogic.deleteCiudad(id);
    }
              
    
}

