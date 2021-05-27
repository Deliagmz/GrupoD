
package es.uma.informatica.ejb.proyecto;

import javax.ejb.Local;
import javax.ws.rs.core.UriBuilder;

import es.uma.informatica.ejb.proyecto.excepciones.SecretariaException;
import es.uma.informatica.sii.agendaee.entidades.Contacto;
import es.uma.informatica.sii.agendaee.entidades.Usuario;

@Local
public interface GestionUsuario {
    public void registrarUsuario(Usuario u, UriBuilder uriBuilder) throws SecretariaException;
    public void validarCuenta(String cuenta, String validacion) throws SecretariaException;
    public void compruebaLogin(Usuario u) throws SecretariaException;
    public Usuario refrescarUsuario(Usuario u) throws SecretariaException;
//    public void modificar(Contacto c) throws SecretariaException;
//    public void insertar(Contacto c) throws SecretariaException;
//    public void eliminarContacto(Contacto c) throws SecretariaException;
//    public Contacto obtenerContacto(Usuario usuario, Long id) throws SecretariaException;
}

