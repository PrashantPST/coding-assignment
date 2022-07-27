package design_patterns.creational.builder;

public class Student {
    private int age;
    private String name;
    private String lastName;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public String toString() {
        return this.age + ", " + this.name + ", "+this.lastName;
    }
}
