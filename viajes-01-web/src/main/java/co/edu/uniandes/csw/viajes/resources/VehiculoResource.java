
package co.edu.uniandes.csw.viajes.resources;

import co.edu.uniandes.csw.viajes.ejbs.VehiculoLogic;
import co.edu.uniandes.csw.viajes.entities.VehiculoEntity;
import co.edu.uniandes.csw.viajes.dtos.VehiculoDTO;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.xml.ws.http.HTTPException;

/**
 *
 * @author ca.nieto11
 */
@Path("/vehiculos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VehiculoResource {
    @Inject private VehiculoLogic vehiculoLogic;
    @Context private HttpServletResponse repsonse;
    
    @GET
    public List<VehiculoDTO> getVehiculos(){
        List<VehiculoDTO> vehiculoDTOs = new ArrayList<VehiculoDTO>();
        List<VehiculoEntity> vehiculos = vehiculoLogic.getVehiculos();
        for (VehiculoEntity vehiculo : vehiculos) {
            VehiculoDTO dto = new VehiculoDTO(vehiculo);
            vehiculoDTOs.add(dto);
        }
        return vehiculoDTOs;
    }
    
    @GET
    @Path("{id: \\d+}")
    public VehiculoDTO getVehiculo(@PathParam("id") Long id) throws HTTPException{
        VehiculoEntity toGet = vehiculoLogic.getVehiculo(id);
        if(toGet==null) throw new HTTPException(404);
        return new VehiculoDTO(toGet);
    }
    
    @POST
    public VehiculoDTO createVehiculo(VehiculoDTO dto) throws HTTPException{
        if(dto==null) throw new HTTPException(404);
        return new VehiculoDTO(vehiculoLogic.createVehiculo(dto.toEntity()));
    }
    
    @PUT
    @Path("{id: \\d+}")
    public VehiculoDTO updateVehiculo(@PathParam("id") Long id, VehiculoDTO dto){
        VehiculoEntity entity = dto.toEntity();
        entity.setId(id);
        return new VehiculoDTO(vehiculoLogic.updateVehiculo(entity));
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteVehiculo(@PathParam("id") Long id){
        vehiculoLogic.deleteVehiculo(id);
    }
}
