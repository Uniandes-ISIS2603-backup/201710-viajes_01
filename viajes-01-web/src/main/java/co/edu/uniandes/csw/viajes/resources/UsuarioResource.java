// TODO: eliminar mensajes por defecto
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.viajes.resources;

import co.edu.uniandes.csw.viajes.dtos.UsuarioDTO;
import co.edu.uniandes.csw.viajes.ejbs.UsuarioLogic;
import co.edu.uniandes.csw.viajes.entities.UsuarioEntity;
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

@Path("/usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {
    
    @Inject 
    private UsuarioLogic usuarioLogic;
    
    
    @GET
    public List<UsuarioDTO> getUsuarios(){   
    
        List<UsuarioDTO> usuariosDTOs = new ArrayList<>();

        List<UsuarioEntity> usuarios = usuarioLogic.getUsuarios();
        for(UsuarioEntity usuario : usuarios){
            UsuarioDTO dto = new UsuarioDTO(usuario);
            usuariosDTOs.add(dto);
        }
        return usuariosDTOs;
    }
    
    @GET
    @Path("{id: \\d+}")
    // TODO: retornar una excepción / código 404 si no existe
    public UsuarioDTO getUsuario(@PathParam("id") Long id) {
        return new UsuarioDTO(usuarioLogic.getUsuario(id));
    }
    
    @POST
    public UsuarioDTO createMulta(UsuarioDTO usuarioDTO){
        
       
        UsuarioEntity usuario = usuarioDTO.toEntity();
        UsuarioEntity entity = usuarioLogic.createUsuario(usuario);  
        return new UsuarioDTO(entity);
      
    }
    
    @PUT
    @Path("{id: \\d+}")
    public UsuarioDTO updateUsuario(@PathParam("id") Long id, UsuarioDTO dto) {
        UsuarioEntity entity = dto.toEntity();
        entity.setId(id);
        return new UsuarioDTO(usuarioLogic.updateUsuario(entity));
    }
    
    @DELETE
    @Path("{id: \\d+}")
    public void deleteUsuario(@PathParam("id") Long id) {
        usuarioLogic.deleteUsuario(id);
    }
              
    
}
