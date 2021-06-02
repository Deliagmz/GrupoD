<<<<<<< HEAD
package es.uma.informatica.sii.proyecto.backing;

package es.uma.informatica.sii.agendaee.vista;

import es.uma.informatica.jpa.proyecto.Usuario;

import es.uma.informatica.ejb.proyecto.excepciones.SecretariaException;
import es.uma.informatica.ejb.proyecto.GestionUsuario;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author francis
 */
@Named(value = "infoSesion")
@SessionScoped
public class InfoSesion implements Serializable {

    @Inject
    private GestionUsuario gestionUsuario;
    private Usuario usuario;
    
    /**
     * Creates a new instance of InfoSesion
     */
    public InfoSesion() {
    }

    public synchronized void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public synchronized Usuario getUsuario() {
        return usuario;
    }
    
//    public synchronized List<Contacto> getContactos()
//    {
//        if (usuario != null)
//        {
//            return usuario.getContactos();
//        }
//        return null;
//    }
    
    public synchronized String invalidarSesion()
    {
        if (usuario != null)
        {
            usuario = null;
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        }
        return "login.xhtml";
    }
    
    public synchronized void refrescarUsuario()
    {
        try {
        if (usuario != null)
        {
            usuario = negocio.refrescarUsuario(usuario);
            System.out.println(usuario.getContactos().size());
        } 
        }
        catch (SecretariaException e) {
            // TODO
        }
    }
    
}
=======
package es.uma.informatica.sii.proyecto.backing;


import es.uma.informatica.jpa.proyecto.Usuario;

import es.uma.informatica.ejb.proyecto.excepciones.SecretariaException;
import es.uma.informatica.ejb.proyecto.GestionUsuario;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "infoSesion")
@SessionScoped
public class InfoSesion implements Serializable {

    @Inject
    private GestionUsuario gestionUsuario;
    private Usuario usuario;
    
    /**
     * Creates a new instance of InfoSesion
     */
    public InfoSesion() {
    }

    public synchronized void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public synchronized Usuario getUsuario() {
        return usuario;
    }

    public synchronized String invalidarSesion()
    {
        if (usuario != null)
        {
            usuario = null;
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        }
        return "login.xhtml";
    }
    
   public synchronized void refrescarUsuario()
    {
        try {
        if (usuario != null)
        {
            usuario = gestionUsuario.refrescarUsuario(usuario);
            //System.out.println(usuario.getEncuestas().size());
        } 
        }
        catch (SecretariaException e) {
            // TODO
        }
    }
    
}
>>>>>>> origin/master
