package es.uma.informatica.sii.proyecto.rest;

import java.net.URI;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import es.uma.informatica.ejb.proyecto.GestionUsuario;
//import es.uma.informatica.sii.agendaee.entidades.Contacto;
import es.uma.informatica.ejb.proyecto.excepciones.SecretariaException;
import es.uma.informatica.jpa.proyecto.Usuario;

@Path("/agenda")
public class ServicioREST {
	@EJB
	private GestionUsuario gestionUsuario;
	@Context
	private UriInfo uriInfo;
	
	@HeaderParam("User-auth")
	private String autorizacion;
	
	@Path("/contactos")
	@GET
	@Produces ({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getContactos() {
		Usuario usuario = getUsuario();
		if (usuario == null) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		
		try {	
			usuario = gestionUsuario.refrescarUsuario(usuario);
			return Response.ok(usuario).build();
		} catch (SecretariaException e) {
			return Response.status(Status.UNAUTHORIZED).build();
		}
	}
	
	
	/*@Path("/contactos")
	@POST
	@Consumes ({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response aniadirContacto(Contacto contacto) {
		// TODO
		Usuario usuario = getUsuario();
	 	 if (usuario == null) {
	 	 	 return Response.status(Status.BAD_REQUEST).build();
	 	 }
	 	 contacto.setUsuario(usuario);
		

	 	 try {
	 	 	 gestionUsuario.insertar(contacto);
	 	 	 URI uri =
uriInfo.getBaseUriBuilder().path(contacto.getId().toString()).build();
	 	 	 return Response.created(uri).build();
	 	 } catch (SecretariaException e) {
	 	 	 return Response.status(Status.UNAUTHORIZED).build();
	 	 }
		
	}
	*/
	/*@Path("/contacto/{id}")
	@GET
	@Produces ({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getContacto(@PathParam("id") Long id) {
		 	 Usuario user = getUsuario();
		 	 if (user == null) {
		 	 	 return Response.status(Status.BAD_REQUEST).build();
		 	 }
			

		 	 try {	 

		 	 	 Contacto c = gestionUsuario.obtenerContacto(user, id);
		 	 	 return Response.ok(c).build();
		 	 } catch (SecretariaException e) {
		 	 	 return Response.status(Status.UNAUTHORIZED).build();
		 	 }
	}
		 

	@Path("/contacto/{id}")
	@PUT
	@Consumes ({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response modificarContacto(@PathParam("id") Long id, Contacto contacto) {
		 	 Usuario user = getUsuario();
		 	 if (user == null) {
		 	 	 return Response.status(Status.BAD_REQUEST).build();
		 	 }
		 	 contacto.setUsuario(user);
		 	 contacto.setId(id);
			

		 	 try {	 

		 		gestionUsuario.modificar(contacto);
		 	 	 return Response.ok(contacto).build();
		 	 } catch (SecretariaException e) {
		 	 	 return Response.status(Status.UNAUTHORIZED).build();
		 	 }
	}
		 

	@Path("/contacto/{id}")
	@DELETE
	@Consumes ({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response eliminarContacto(@PathParam("id") Long id) {
		 	 Usuario usuario = getUsuario();
		 	 if (usuario == null) {
		 	 	 return Response.status(Status.BAD_REQUEST).build();
		 	 }
			

		 	 try {
		 	 	 Contacto contacto = gestionUsuario.obtenerContacto(usuario, id);
		 	 	 gestionUsuario.eliminarContacto(contacto);
		 	 	 return Response.ok(contacto).build();
		 	 } catch (SecretariaException e) {
		 	 	 return Response.status(Status.UNAUTHORIZED).build();
		 	 }
	}
		 
*/
	
	
	
	
	private Usuario getUsuario() {
		if (autorizacion == null) {
			return null;
		}
		
		String [] partesAutorizacion = autorizacion.split(":");
		if (partesAutorizacion.length != 2) {
			return null;
		}
		
		Usuario usuario = new Usuario();
		//usuario.setCuenta(partesAutorizacion[0]);
		usuario.setContrasena(partesAutorizacion[1]);
		
		return usuario;
	}

}
