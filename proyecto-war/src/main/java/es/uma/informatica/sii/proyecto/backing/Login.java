
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.uma.informatica.sii.proyecto.backing;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import es.uma.informatica.ejb.proyecto.excepciones.SecretariaException;
import es.uma.informatica.jpa.proyecto.Usuario;
import es.uma.informatica.ejb.proyecto.GestionUsuario;
import es.uma.informatica.ejb.proyecto.excepciones.ContraseniaInvalidaException;
import es.uma.informatica.ejb.proyecto.excepciones.CuentaInactivaException;
import es.uma.informatica.ejb.proyecto.excepciones.CuentaInexistenteException;


@Named(value = "login")
@RequestScoped
public class Login {

    @Inject
    private GestionUsuario gestionUsuario;

    @Inject
    private InfoSesion sesion;

    private Usuario usuario;

    /**
     * Creates a new instance of login
     */
    public Login() {
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String entrar() {
        try {
            gestionUsuario.compruebaLogin(usuario);
            if(usuario.getCuenta().equals("Secretaria")) {
            	return "indexSecretaria.xhtml";
            }
            sesion.setUsuario(gestionUsuario.refrescarUsuario(usuario));
            return "Encuesta.xhtml";

        } catch (CuentaInexistenteException e) {
            FacesMessage fm = new FacesMessage("La cuenta no existe");
            FacesContext.getCurrentInstance().addMessage("login:user", fm);
        } catch (ContraseniaInvalidaException e) {
            FacesMessage fm = new FacesMessage("La contraseña no es correcta");
            FacesContext.getCurrentInstance().addMessage("login:pass", fm);
        } catch (CuentaInactivaException e) {
            FacesMessage fm = new FacesMessage("La cuenta existe pero no estÃ¡ activa");
            FacesContext.getCurrentInstance().addMessage("login:user", fm);
        } catch (SecretariaException e) {
            FacesMessage fm = new FacesMessage("Error: " + e);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        return null;
    }

   
}


