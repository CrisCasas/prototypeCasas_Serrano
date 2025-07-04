import java.io.*;
import java.util.*;


class Person implements Cloneable {
  //Lower-level object

 private Car car;

  private String name;
  public Car getCar() {
    return car;
  }
  public String getName() {
     return name;
  }
  public void setName(String s) {
      name = s;
  }
  public Person(String s, String t) {
      name = s;
      car = new Car(t);
  }
  public Object clone() {
    //shallow copy
    try {
      return super.clone(); // copia campo a campo (shallow)
    } catch (CloneNotSupportedException e) {
      return null;
    }
  }
}
class Car {

  private String name;

  public String getName() {
    return name;
  }
  public void setName(String s) {
        name = s;
  }
  public Car(String s) {
    name = s;
  }
}
public class ShallowCopyTest {

  public static void main(String[] args) {
    
      //Original Object
    Person p = new Person("Person-A","Civic");
    System.out.println("Original (orginal values): " + p.getName() + " - " + p.getCar().getName());

    //Clone as a shallow copy
    Person q = (Person) p.clone();

    System.out.println("Clone (before change): " + q.getName() + " - " + q.getCar().getName());

    //change the primitive member
    q.setName("Person-B");

    //change the lower-level object
    q.getCar().setName("Accord");

    System.out.println("Clone (after change): " + q.getName() + " - " + q.getCar().getName());

    System.out.println("Original (after clone is modified): " + p.getName() + " - " + p.getCar().getName());

  }
}
