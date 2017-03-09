package example.java;

/**
 * Created by breandanconsidine on 3/7/17.
 */
public class Person {
    private final String firstName;
    private final String lastName;
    private final int age;

    private Person(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }


    @Override
    public String toString() {
        return "firstName: " + firstName + ", lastName: " + lastName + ", age: " + age;
    }
}
