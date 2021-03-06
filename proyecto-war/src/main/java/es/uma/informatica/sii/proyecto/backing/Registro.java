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
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.UriBuilder;

import es.uma.informatica.ejb.proyecto.GestionUsuario;
import es.uma.informatica.ejb.proyecto.excepciones.CuentaRepetidaException;
import es.uma.informatica.ejb.proyecto.excepciones.SecretariaException;
import es.uma.informatica.jpa.proyecto.Usuario;


@Named(value = "registro")
@RequestScoped
public class Registro {
	
	private static final String PARAM_VALIDACION="codigoValidacion";
	private static final String PARAM_CUENTA = "cuenta";

    @Inject
    private GestionUsuario usuarioEJB;
    
    private Usuario usuario;
    private String repass;

    private String cuenta;
    private String codigoValidacion;

    private String mensajeValidacion;
    private boolean validacionOK;

    private boolean registroOK;

    public boolean isRegistroOK() {
        return registroOK;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getCodigoValidacion() {
        return codigoValidacion;
    }

    public void setCodigoValidacion(String codigoValidacion) {
        this.codigoValidacion = codigoValidacion;
    }

    public Registro() {
        usuario = new Usuario();
    }

    public String getRepass() {
        return repass;
    }

    public void setRepass(String repass) {
        this.repass = repass;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String registrarUsuario() {
        try {
            if (!usuario.getContrasena().equals(repass)) {
                FacesMessage fm = new FacesMessage("Las contrase??as deben coincidir");
                FacesContext.getCurrentInstance().addMessage("registro:repass", fm);
                return null;
            }

            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance()
            		.getExternalContext()
            		.getRequest();
            
            String thisUri = request.getRequestURL().toString();
            
            int ultimaBarra = thisUri.lastIndexOf('/');
            if (ultimaBarra < 0) {
            	FacesMessage fm = new FacesMessage("Error interno de URL");
                FacesContext.getCurrentInstance().addMessage(null, fm);
                return null;
            }
            
            UriBuilder uriBuilder = UriBuilder.fromUri(thisUri.substring(0, ultimaBarra))
            		.path("validarCuenta.xhtml")
            		.queryParam(PARAM_CUENTA, "{cuenta}")
            		.queryParam(PARAM_VALIDACION, "{validacion}");
            usuarioEJB.registrarUsuario(usuario, uriBuilder);
            registroOK = true;
            return "exitoRegistro.xhtml";
            
        } catch (CuentaRepetidaException e) {
            FacesMessage fm = new FacesMessage("Existe un usuario con la misma cuenta");
            FacesContext.getCurrentInstance().addMessage("registro:user", fm);
            
        } catch (SecretariaException e) {
        }
        return null;
    }

    public String validarCuenta() {
        try {
            if (cuenta != null && codigoValidacion != null) {
            	usuarioEJB.validarCuenta(cuenta, codigoValidacion);
            }
            mensajeValidacion = "La validaci??n ha sido correcta, ahora puede acceder con este usuario.";
            validacionOK = true;
        } catch (SecretariaException e) {
            mensajeValidacion = "Ha habido un error con la validaci??n, compruebe que la URL es correcta.";
            validacionOK = false;
        }
        return null;
    }

    public String getMensajeValidacion() {
        return mensajeValidacion;
    }

    public boolean isValidacionOK() {
        return validacionOK;
    }

}
