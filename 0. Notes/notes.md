# Scope and Access

**Scope** and **Access** refer to the idea of where are variables defined and available for use. Sometimes, variables are defined with a wide scope/access, and are available in many places. Other times, variables are defined with a very narrow scope/access, and are available in very limited places.

---

## Local Variables

**Local variables** are variables with a narrow or limited scope, meaning they won't be accessible in very many places, and often are in fact only accessible in one section of code.

While we hadn't referred to them as such, most of our work with variables this year has been local, as if we zoomed out from our small sections of code, those variables wouldn't exist anymore. First, let's look at this example from the `NotesLocal1.java` file:

```java
int x = 5;
System.out.println(x);
```

In order to understand what it means for the variable `x` to be local, we need to zoom out and view the whole file:

```java
public class NotesLocal1 {
    public static void main(String[] args) {
        int x = 5;
        System.out.println(x);
    }
}
```

Curly braces `{}` are a great way to tell something's scope. When inside of the curly braces where a variable is defined, it exists and you have access to it, but as soon as you leave that set of curly braces (basically, you pass the end curly brace `}`), it disappears. This is the idea of locality. If all variables were always available, this would end up being really inefficient, so locality makes programs much easier to run.

Here is another example from the `NotesLocal2` file:

```java
public class NotesLocal2 {
    public static void main(String[] args) {
        int x = 5;
        System.out.println(x);
    }

    public static void main2(String[] args) {
        System.out.println(x);
    }
}
```

Even though we can see `x` is defined, because we leave the curly braces of `main`, it disappears and will not exist when the `println` statement in `main2` calls it, causing an error.

It is important to note that they exist as long as you haven't hit their most-related end curly brace `{`. If you open more curly braces after it, and even close them, the variable can stil exist, as long as the curly brace it is defined nearest to is still open. We see this happen in classes with `static` or instance variables. They exist in methods, because the open curly brace for the `class` is still open! We can see it in an early version of the `Person` class:

```java
public class Person {
    private String name;

    public Person() {
        name = "";
    }
}
```

If `name` was undefined, we wouldn't be able to set it within the constructor! In this example, it would only be after the final curly brace that the variable name ceases to exist.

---

## Parameters and Variables

The parameters in a constructor or a method are locally defined. They are declared in the header, and then only exist within the constructor or method! For example, this is one of the constructors for the `Person` class:

```java
public Person(String n, int a) {
    name = n;
    age = a;
}
```

The parameter variables `n` and `a` only exist within the constructor, and will cease to exist once the constructor finishes (hits that end curly brace `{`).

When constructors or methods are doing a lot of work, it makes sense to make temporary variables inside of them to do work with. These variables are local to the constructor or method they are made within, and therefore don't exist outside of them. Here is an example from a new method in the `Person.java` file:

```java
public static double averageAge(Person p1, Person p2) {
    double average = (p1.age + p2.age) / 2.0;
    return average;
}
```

The variable `average` is local to the `averageAge` method, so outside of that method, the variable doesn't exist.

---

## Instance Variables versus Local Variables

You can have a local variable in a constructor or method that shares the same name as an instance variable in the same class. How does Java choose which one to use?

On the one hand, the instance variable is more important to the object, and so should take priority. On the other hand, the local variable has a narrower scope, and should take priority while its available because the instance variable will still be there later. Java uses the latter reasoning, so the local variable takes priority and makes it temporarily harder for you to access your instance variable. Here is an example of a modified `setAge` method for the `Person` class that puts this to the test:

```java
public void setAge(int age) {
    age = age;
}
```

What we would want to happen here in `age = age` is for it to set the instance variable `age` (left side) to the local parameter variable `age`'s value (right side). What really happens though is it sets the local parameter variable `age` to its own value, and never brings up the instance variable `age`, resulting in nothing happening. Trying to change the age and then printing it should result in no change! Here is an example demonstrating this from the `NotesLocalInstance1.java` file:


```java
Person person1 = new Person("Mr. G", 25);
person1.setAge(26);
System.out.println(person1.getAge());
```

Running this shows us that our reasoning was correct, this doesn't actually set the age to 26 like we want. Java even gives us a warning about our setup not being useful, saying "The assignment to variable `age` has no effect".

We will show a solution to this problem in Unit 5 Section 9. For the time being, be careful when naming local variables not to temporarily override instance variables that you need access to!

---

## Assignment

Now that you have gone through the notes for this section, you can check out the `Try.md` and `Try.java` files to try a short assignment using this material.
