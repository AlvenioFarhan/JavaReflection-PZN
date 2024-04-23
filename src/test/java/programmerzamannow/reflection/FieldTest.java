package programmerzamannow.reflection;

import org.junit.jupiter.api.Test;
import programmerzamannow.reflection.data.Person;

import java.lang.reflect.Field;

public class FieldTest {

    @Test
    void testGetFields() {

        Class<Person> personClass = Person.class;

        Field[] fields = personClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName() + " : " + field.getType().getName());
        }
    }

    @Test
    void testGetFieldValue() throws NoSuchFieldException, IllegalAccessException {

        Class<Person> personClass = Person.class;
        Field firstname = personClass.getDeclaredField("firstname");
        firstname.setAccessible(true);

        Person person1 = new Person("Alvenio", "Farhan");

        Object result = firstname.get(person1);
        System.out.println(result);

        Person person2 = new Person("Joko", "Anwar");
        String result2 = (String) firstname.get(person2);
        System.out.println(result2);
    }

    @Test
    void testSetFieldValue() throws NoSuchFieldException, IllegalAccessException {

        Class<Person> personClass = Person.class;
        Field firstname = personClass.getDeclaredField("firstname");
        firstname.setAccessible(true);

        Person person1 = new Person("Alvenio", "Farhan");
        firstname.set(person1, "Putra"); // person1.setFirstname("Putra");
        System.out.println(person1.getFirstname());

        Person person2 = new Person("Joko", "Anwar");
        firstname.set(person2, "Budi"); //person2.setFirstname("Budi");
        System.out.println(firstname.get(person2));
    }
}
