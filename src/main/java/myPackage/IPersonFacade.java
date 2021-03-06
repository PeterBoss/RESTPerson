package myPackage;

import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Peter
 */
public interface IPersonFacade {
    
    public void addEntityManagerFactory(EntityManagerFactory emf);
    public Person addPerson(Person p);
    public Person deletePerson(int id);
    public Person getPerson(int id);
    public List<Person> getPersons();
    public Person editPerson(Person p);
    
}
