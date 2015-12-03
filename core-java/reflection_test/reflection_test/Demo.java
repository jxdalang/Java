/**
* @package reflection_test
* @author ZS@ZJU
* @version V1.0
*/
package reflection_test;

/**
* @className Demo
* @description TODO
* @author ZS@ZJU
* @date Nov 29, 2015 11:03:15 AM
*/
public class Demo {

}

class Person {
    // fields
    private String name;
    private int age;

    // constructor
    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    public Person(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    // methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "[" + this.name + "  " + this.age + "]";
    }
}