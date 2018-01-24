/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.PersonalCellar;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author wilson.mora
 */
@Local
public interface PersonalCellarFacadeLocal {

    void create(PersonalCellar personalCellar);

    void edit(PersonalCellar personalCellar);

    void remove(PersonalCellar personalCellar);

    PersonalCellar find(Object id);

    List<PersonalCellar> findAll();

    List<PersonalCellar> findRange(int[] range);

    int count();
    
}
