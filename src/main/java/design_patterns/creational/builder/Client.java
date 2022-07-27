package design_patterns.creational.builder;

public class Client {
    public static void main(String[] args) {
        Student student1 = new StudentBuilder().withName("John").withLastName("Appleyard").withAge(22).build();
        System.out.println(student1);
        Student student2 = new StudentBuilder().withName("John").withLastName("Appleyard").build();
        System.out.println(student2);
    }
}