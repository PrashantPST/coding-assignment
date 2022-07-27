package design_patterns.creational.builder;

public class StudentBuilder {
    private final Student student;

    public StudentBuilder() {
        student = new Student();
    }

    public StudentBuilder withName(String name) {
        student.setName(name);
        return this;
    }

    public StudentBuilder withLastName(String lastName) {
        student.setLastName(lastName);
        return this;
    }

    public StudentBuilder withAge(int age) {
        student.setAge(age);
        return this;
    }

    public Student build() {
        return student;
    }
}
