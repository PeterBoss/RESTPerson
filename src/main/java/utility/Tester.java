/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.util.List;
import javax.persistence.Persistence;
import myPackage.Person;
import myPackage.PersonFacade;

/**
 *
 * @author Peter
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PersonFacade fac = new PersonFacade();
        fac.addEntityManagerFactory(Persistence.createEntityManagerFactory("myPU"));
        Person p1 = fac.addPerson(new Person("Peter", "Thomsen", "29917834"));
        Person p2 = fac.addPerson(new Person("Michael", "Boss", "6133   7834"));
        
        
        
        
    }
    
}
