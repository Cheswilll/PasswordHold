/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PasswordHold.login;

import DAO.UserFacadeLocal;
import Entities.User;
import Entities.Role;
import PasswordHold.util.MessageUtil;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Ismael
 */
@Stateless
public class SessionRule {

    @EJB
    private UserFacadeLocal pfl;

    public User iniciar(String nameUser, String passwordUser) {
        User p = null;
        if (nameUser != null && nameUser.length() > 0
                && passwordUser != null && passwordUser.length() > 0) {
            p = pfl.login(nameUser, passwordUser);
            if (p != null) {
                if (p.getState() == 2) {
                    p = null;
                    MessageUtil.enviarMensajeErrorGlobal(
                            "Usuario bloqueado",
                            "Contacte al administrador par que solucione el incoveniente.");

                }
            } else {
                MessageUtil.enviarMensajeErrorGlobal(
                        "Datos incorrectos",
                        "Documento y/o clave invalidos");
            }
        } else {
            MessageUtil.enviarMensajeErrorGlobal(
                    "Datos obligatorios",
                    "Documento y/o clave son necesarios para iniciar sesión");
        }
        return p;
    }

    public Role validarRol(User p) {
        Role r = null;
        if (p.getRoles() != null && p.getRoles().size() > 0) {
            r = p.getRoles().get(0);
        } else {
            MessageUtil.enviarMensajeErrorGlobal(
                    "Rol no asignado",
                    "Debe esperar a que se le asigne un rol dentro del sistema");
        }
        return r;
    }

}
