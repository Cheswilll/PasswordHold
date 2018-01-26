/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PasswordHold.login;

import DAO.RoleFacadeLocal;
import Entities.Role;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Ismael
 */
@FacesConverter(forClass = Role.class, value = "rolConverter")
public class RolConverter implements Converter{
    
    private RoleFacadeLocal rfl;
    
    public RolConverter() {
        rfl = CDI.current().select(RoleFacadeLocal.class).get();
    }
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.length() > 0){
            return rfl.find(Integer.valueOf(value));
        }
         return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value != null && value instanceof Role){
            Role r = (Role) value;
            return r.getIdRole().toString();
        }
        return null;
    }
    
}
