/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author wilson.mora
 */
@Stateless
public class UserFacade extends AbstractFacade<User> implements UserFacadeLocal {

    @PersistenceContext(unitName = "APIPasswordHoldPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserFacade() {
        super(User.class);
    }

    @Override
    public User login(String nameUser, String passwordUser) {
        try {
            TypedQuery<User> q = getEntityManager().createNamedQuery("User.findLogin", User.class);
            q.setParameter("nameUser", nameUser);
            q.setParameter("passwordUser", passwordUser);
            return q.getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }
    
}
