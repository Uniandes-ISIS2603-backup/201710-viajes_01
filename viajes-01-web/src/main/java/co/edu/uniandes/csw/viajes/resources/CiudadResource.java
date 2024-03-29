/* 
 * The MIT License
 *
 * Copyright 2017 ca.nieto11.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
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
import javax.xml.ws.http.HTTPException;

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
    public List<CiudadDTO> getCiudad(){   
    
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
    public CiudadDTO getCiudad(@PathParam("id") Long id) throws HTTPException {
        CiudadEntity toGet = ciudadLogic.getCiudad(id);
        if(toGet==null) throw new HTTPException(404);
        return new CiudadDTO(toGet);
    }
    
    @POST
    public CiudadDTO createCiudad(CiudadDTO ciudadDTO){
        
       
        CiudadEntity ciudad = ciudadDTO.toEntity();
        CiudadEntity entity = ciudadLogic.createCiudad(ciudad);  
        return new CiudadDTO(entity);
      
    }
    
    @PUT
    @Path("{id: \\d+}")
    public CiudadDTO updateCiudad(@PathParam("id") Long id, CiudadDTO dto) {
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

