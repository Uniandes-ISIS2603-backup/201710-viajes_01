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

import co.edu.uniandes.csw.viajes.dtos.ReservaDTO;
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
import javax.xml.ws.http.HTTPException;

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
    public ReservaDTO getReserva(@PathParam("id") Long id) throws HTTPException{
        ReservaEntity toGet = reservaLogic.getReserva(id);
        if(toGet == null) throw new HTTPException(404);
        return new ReservaDTO(toGet);
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteReserva(@PathParam("id") Long id){
        reservaLogic.deleteReserva(id);
    }
}
