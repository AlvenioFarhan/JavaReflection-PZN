package programmerzamannow.reflection;

import org.junit.jupiter.api.Test;
import programmerzamannow.reflection.data.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodTest {

    @Test
    void testGetMethods() {

        Class<Person> personClass = Person.class;

        Method[] methods = personClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
            System.out.println(method.getReturnType());
            System.out.println(Arrays.toString(method.getParameterTypes()));
            System.out.println(Arrays.toString(method.getExceptionTypes()));
            System.out.println("===========");
        }
    }

    @Test
    void testGetMethodValue() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Class<Person> personClass = Person.class;
        Method getFirstname = personClass.getDeclaredMethod("getFirstname");

        Person person = new Person("Alvenio", "Farhan");
        Object firstname = getFirstname.invoke(person);
        System.out.println(firstname);
    }
}
