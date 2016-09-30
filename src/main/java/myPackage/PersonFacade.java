package myPackage;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Peter
 */
public class PersonFacade implements IPersonFacade {

    EntityManagerFactory emf;

    @Override
    public void addEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Person addPerson(Person p) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        return p;
    }

    @Override
    public Person deletePerson(int id) {
        Person p;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        p = em.find(Person.class, id);
        em.remove(p);
        em.getTransaction().commit();
        em.close();
        return p;
    }

    @Override
    public Person getPerson(int id) {
        Person p;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        p = em.find(Person.class, id);
        em.getTransaction().commit();
        em.close();
        return p;
    }

    @Override
    public List<Person> getPersons() {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        List<Person> listPersons = em.createQuery("SELECT p FROM Person p").getResultList();
        em.getTransaction().commit();
        em.close();
        return listPersons;
    }

    @Override
    public Person editPerson(Person p) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
        em.close();
        return p;
    }

}
