/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PasswordHold.login;

import DAO.UserFacade;
import Entities.Permission;
import Entities.User;
import Entities.Role;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Ismael
 */
@Named(value = "sessionController")
@SessionScoped
public class SessionController implements Serializable {

    @EJB
    private SessionRule sr;
    
    private UserFacade ufl;
   
    
    private String passwordUser;
    private String nameUser;
    private Role rolSeleccionado;
    private User persona;
    /**
     * Creates a new instance of SessionController
     */
    public SessionController() {
    }
    
    @PostConstruct
    public void init(){
    }

    public SessionRule getSr() {
        return sr;
    }

    public void setSr(SessionRule sr) {
        this.sr = sr;
    }

    public UserFacade getUfl() {
        return ufl;
    }

    public void setUfl(UserFacade ufl) {
        this.ufl = ufl;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }


    public Role getRolSeleccionado() {
        return rolSeleccionado;
    }

    public void setRolSeleccionado(Role rolSeleccionado) {
        this.rolSeleccionado = rolSeleccionado;
    }

    public User getPersona() {
        return persona;
    }

    public void setPersona(User persona) {
        this.persona = persona;
    }

    
    public String iniciarSesion(){
        String urlDestino = "";
        persona = sr.iniciar(nameUser, passwordUser);
        if(persona != null){
            rolSeleccionado = sr.validarRol(persona);
            if(rolSeleccionado != null){
                urlDestino = "/index.xhtml?faces-redirect=true";
            } else{
                persona = null;
            }
        }
        return urlDestino;
    }
    
    public User usuarioSesion(){
        persona.getNameUser();
        return persona;
    }
    
    
    public String cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        persona = null;
        rolSeleccionado = null;
        passwordUser = "";
        nameUser = null;
        return "/index.xhtml?faces-redirect=true";
    }
    
    public Boolean inicioSesion(){
        return (persona != null);
    }
    
    
    public Boolean tienePermiso(String urlRecurso){
        if(urlRecurso.endsWith("app/index.xhtml")){
            return true;
        }
        for (Permission p : rolSeleccionado.getPermissions()) {
            if(p.getUrl() != null && urlRecurso.endsWith(p.getUrl())){
                return true;
            }
        }
        return false;
    }
    
    
    @PreDestroy
    public void perDestroy(){
        cerrarSesion();
    }
}
