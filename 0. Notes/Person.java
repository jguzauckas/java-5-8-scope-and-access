public class Person {
    private String name;
    private int age;

    public Person() {
        name = "";
        age = -1;
    }

    public Person(String n, int a) {
        name = n;
        age = a;
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        age = age;
    }
}