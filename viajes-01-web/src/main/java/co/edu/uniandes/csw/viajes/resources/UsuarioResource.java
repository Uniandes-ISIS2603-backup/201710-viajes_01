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
import javax.xml.ws.http.HTTPException;

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
    public UsuarioDTO getUsuario(@PathParam("id") Long id) throws HTTPException{
        UsuarioEntity toGet = usuarioLogic.getUsuario(id);
        if(toGet==null) throw new HTTPException(404);
        return new UsuarioDTO(toGet);
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
