/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.PersonalCellar;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author wilson.mora
 */
@Stateless
public class PersonalCellarFacade extends AbstractFacade<PersonalCellar> implements PersonalCellarFacadeLocal {

    @PersistenceContext(unitName = "APIPasswordHoldPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonalCellarFacade() {
        super(PersonalCellar.class);
    }
    
}
