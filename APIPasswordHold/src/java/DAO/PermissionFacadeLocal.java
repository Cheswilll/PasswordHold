/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Permission;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author wilson.mora
 */
@Local
public interface PermissionFacadeLocal {

    void create(Permission permission);

    void edit(Permission permission);

    void remove(Permission permission);

    Permission find(Object id);

    List<Permission> findAll();

    List<Permission> findRange(int[] range);

    int count();
    
}
