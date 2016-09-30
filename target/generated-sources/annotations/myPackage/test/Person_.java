package myPackage.test;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import myPackage.Person;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-29T14:03:18")
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SingularAttribute<Person, String> lName;
    public static volatile SingularAttribute<Person, String> fName;
    public static volatile SingularAttribute<Person, String> phone;
    public static volatile SingularAttribute<Person, Integer> id;

}