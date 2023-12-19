public class Person {
    public static String species = "Human";
    private static int numHearts = 1;
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

    public static int getNumHearts() {
        return numHearts;
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

    public String toString() {
        return hearts() + name + " is a " + age + " year old " + species;
    }

    public static String hearts() {
        return "All " + species + " have " + numHearts + " heart. ";
    }

    public static void howManyHearts(int h) {
        if (h == numHearts) {
            System.out.print("Correct! ");
        } else {
            System.out.print("Incorrect! ");
        }
        System.out.println(hearts());
    }

    public void copyName(Person p) {
        name = p.name;
    }

    public int getYearBorn() {
        return 2023 - age;
    }
    
    public void sayYearBorn() {
        System.out.println("I was born in " + getYearBorn());
    }
}